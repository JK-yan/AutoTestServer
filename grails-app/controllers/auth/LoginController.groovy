package auth

import autotestserver.UserService
import grails.converters.JSON
import groovy.util.logging.Log4j
import jwt.JwtUtil

import javax.servlet.http.Cookie
@Log4j
class LoginController {
    UserService userService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def login() {
        def user = userService.login(params.userId, params.password)
        log.info(user)
        if (user) {
            def claims = [userId: params.userId]
            def token = JwtUtil.create_token(claims)
            def cookie = new Cookie('access_token', token)
            response.addCookie(cookie)
//            response.addHeader('Content-Type','text/javascript')
            redirect (uri:'/dashboard')
        } else {
            render view:'/notFound'
        }
    }
    def index() { }
}
