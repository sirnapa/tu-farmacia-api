

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'tufar.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'tufar.security.UserRole'
grails.plugin.springsecurity.authority.className = 'tufar.security.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/**',         							access: ['ROLE_ADMIN']],
	[pattern: '/api/**',        						access: ['ROLE_ADMIN']],
]

grails.plugin.springsecurity.filterChain.chainMap = [
	//Stateless chain
	[pattern: '/**', 		filters: 'JOINED_FILTERS,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter']
]

grails.plugin.springsecurity.rest.token.storage.useGorm = true
grails.plugin.springsecurity.rest.token.storage.gorm.tokenDomainClassName = 'tufar.security.AuthToken'
