//grails.plugin.springsecurity.useBasicAuth = true
//grails.plugin.springsecurity.basic.realmName = "Ralph's Bait and Tackle"

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'auth.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'auth.UserRole'
grails.plugin.springsecurity.authority.className = 'auth.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['permitAll']],
        [pattern: '/index.gsp', access: ['permitAll']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**', filters: 'none'],
        [pattern: '/**/js/**', filters: 'none'],
        [pattern: '/**/css/**', filters: 'none'],
        [pattern: '/**/images/**', filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**', filters: 'JOINED_FILTERS'],
        [pattern: '/login/**', filters: 'JOINED_FILTERS,-exceptionTranslationFilter'],
        [pattern: '/**', filters: 'JOINED_FILTERS,-basicAuthenticationFilter,-basicExceptionTranslationFilter']
]
//grails.plugin.springsecurity.providerNames = [
//        'myAuthenticationProvider',
//        'anonymousAuthenticationProvider',
//        'rememberMeAuthenticationProvider']
//
//grails.plugin.springsecurity.rememberMe.persistent = true
//grails.plugin.springsecurity.rememberMe.persistentToken.domainClassName = 'auth.PersistentLogin'
//
//
//grails.plugin.springsecurity.roleHierarchyEntryClassName = 'auth.RoleHierarchyEntry'
//
grails.plugin.springsecurity.logout.handlerNames = [
        'rememberMeServices', 'securityContextLogoutHandler', 'myLogoutHandler'
]