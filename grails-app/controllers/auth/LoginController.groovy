package auth

import grails.plugin.springsecurity.annotation.Secured
import groovy.util.logging.Log4j
import jwt.JwtUtil
import org.springframework.context.MessageSource
import org.springframework.security.authentication.AuthenticationTrustResolver

import javax.servlet.http.Cookie
@Secured('permitAll')
@Log4j
class LoginController {
//    UserService userService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static responseFormats = ['json']
    /** 依赖注入认证接口authenticationTrustResolver. */
    AuthenticationTrustResolver authenticationTrustResolver

    /** 依赖注入springSecurityService. */
    def springSecurityService

    /** 依赖注入messageSource. */
    MessageSource messageSource

    def login() {
//        if(springSecurityService.isLoggedIn())
        String username = params.username
        String password = params.password
        def user = User.findByUsernameAndPassword(username,password)
        log.info(user)
        if (user) {

            respond('token': token)
        } else {
            respond('message': '登陆失败')
        }
    }
//    def login() {
//        def user = userService.login(params.userId, params.password)
//        log.info(user)
//        if (user) {
//            def claims = [userId: params.userId]
//            def token = JwtUtil.create_token(claims)
//            def cookie = new Cookie('access_token', token)
//            response.addCookie(cookie)
////            response.addHeader('Content-Type','text/javascript')
//            respond('token': token)
//        } else {
//            render view: '/notFound'
//        }
//    }

    def registered() {
        String username = params.username
        String password = params.password
        if (User.findByUsername(username)) {
            respond('message':'用户名已经存在')
        }

        def testUser = new User(username: username, password:password).save()
        def adminRole = Role.findByAuthority('ROLE_ADMIN')
        UserRole.create testUser, adminRole
        UserRole.withSession {
            it.flush()
            it.clear()
        }
        respond('success:':true)
    }
}
