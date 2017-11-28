package tufar.base

import tufar.util.PaginableController
import grails.rest.*

@Resource(uri='/api/taxes', readOnly = false, formats = ['json', 'xml'], superClass = PaginableController)
class Tax {
    String name
	Integer percent
	String comment

	static constraints = {
		comment nullable: true, blank: true
	}

	static mapping = {
		table name:"tax", schema:"base"
		id generator:'sequence', params:[sequence:'base.seq_tax_id']
	}
}
