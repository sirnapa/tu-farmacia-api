package tufar.base

import tufar.util.PaginableController
import grails.rest.*

@Resource(uri='/api/products', readOnly = false, formats = ['json', 'xml'], superClass = PaginableController)
class Product {

    String name
	String code
	Integer stock = 0
	Integer minimalStock = 0
	Double price
	Tax tax
	Date expiration
	Boolean freeSale

	static hasMany = [tags: Tag]

	static mapping = {
		table name:"product", schema:"base"
		id generator:'sequence', params:[sequence:'base.seq_product_id']
	}
    
}
