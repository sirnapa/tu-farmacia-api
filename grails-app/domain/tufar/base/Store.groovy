package tufar.base

import tufar.util.PaginableController
import grails.rest.*

@Resource(uri='/api/stores', readOnly = false, formats = ['json', 'xml'], superClass = PaginableController)
class Store {

    String name
    String address
    String phone
    String email
    Double latitude
    Double longitude

    static belongsTo = [group: Group]

    static constraints = {
        name blank: false, unique: true
    }

    static mapping = {
		table name:"store", schema:"base"
		id generator:'sequence', params:[sequence:'base.seq_store_id']
	}
    
}
