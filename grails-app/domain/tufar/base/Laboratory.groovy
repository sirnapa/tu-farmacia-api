package tufar.base

import tufar.util.PaginableController
import grails.rest.*

@Resource(uri='/api/laboratories', readOnly = false, formats = ['json', 'xml'], superClass = PaginableController)
class Laboratory {

    String name
	String ruc
	String alias
	String phone
	String email
	String comment

	static constraints = {
		ruc nullable: true, blank: true
		alias nullable: true, blank: true
		phone nullable: true, blank: true
		email nullable: true, blank: true
		comment nullable: true, blank: true
	}

	static mapping = {
		table name:"laboratory", schema:"base"
		id generator:'sequence', params:[sequence:'base.seq_laboratory_id']
	}

}
