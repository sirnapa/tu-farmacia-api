package tufar.base

import tufar.util.PaginableController
import grails.rest.*

@Resource(uri='/api/tags', readOnly = false, formats = ['json', 'xml'], superClass = PaginableController)
class Tag {

    String name

	static belongsTo = [product: Product]

	static mapping = {
		table name:"tag", schema:"base"
		id generator:'sequence', params:[sequence:'base.seq_tag_id']
	}
    
}
