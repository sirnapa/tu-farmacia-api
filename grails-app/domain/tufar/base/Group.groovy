package tufar.base

import tufar.util.PaginableController
import grails.rest.*

@Resource(uri='/api/groups', readOnly = false, formats = ['json', 'xml'], superClass = PaginableController)
class Group {

    String name
    String ruc
    String address
    String phone
    String email

    static hasMany = [stores: Store]

    static constraints = {
        name blank: false, unique: true
        ruc blank: false, unique: true
    }

    static mapping = {
		table name:"group", schema:"base"
		id generator:'sequence', params:[sequence:'base.seq_group_id']
	}
    
}
