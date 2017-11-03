package tufar.security

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import tufar.util.PaginableController
import grails.rest.*

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
@Resource(uri='/api/users', readOnly = false, formats = ['json', 'xml'], superClass = PaginableController)
class User implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String username			// email
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this)*.role
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService','email']

	String getEmail(){
		username
	}

	static constraints = {
		password blank: false, password: true
		username blank: false, unique: true
	}

	static mapping = {
		table name:"user", schema:"security"
		id generator:'sequence', params:[sequence:'security.seq_user_id']
		password column: '`password`'
	}
}
