package tufar.util


import grails.rest.*
import grails.converters.*

class PaginableController<T> extends RestfulController<T> {
	static responseFormats = ['json', 'xml']

    PaginableController(Class<T> domainClass){
        this(domainClass, false)
    }

    PaginableController(Class<T> domainClass, boolean readOnly){
        super(domainClass, readOnly)
    }

    @Override
    def index(Integer max) {
        params.per_page = Math.min(params.per_page ? params.int('per_page') : 10, 100)
        params.page = params.page ? params.int('page') : 1

//        def domainCriteria = resource.createCriteria()
//        def resultList = domainCriteria.list(params)

        def totalPages = Math.ceil(resource.count()/params.per_page)
        def offset = (params.page-1)*params.per_page

        def resultList = [
            data: resource.list(max: params.per_page, offset: offset),
            meta: [
                page: params.page,
                per_page: params.per_page,
                total_pages: totalPages,
            ]
        ]

        render resultList as JSON
    }
}
