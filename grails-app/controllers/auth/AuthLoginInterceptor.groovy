package auth


import groovy.util.logging.Log4j
import io.jsonwebtoken.ExpiredJwtException
import jwt.JwtUtil

@Log4j
class AuthLoginInterceptor {
    int order = HIGHEST_PRECEDENCE

    AuthLoginInterceptor() {
        matchAll().except(controllerName: 'Login')
    }

    boolean before() {
        String signature = ''
        for (header in request.getCookies()) {
            if (header.name == 'access_token') {
                signature = header.value
                break
            }
        }

        boolean result = false
        try {
            def  claims =  JwtUtil.parseJWT(signature)
            println(claims.getExpiration().time-new Date().time)
            result = true
        } catch (ExpiredJwtException e) {
            log.error(e)
        } catch (IllegalArgumentException e1) {
            log.error(e1)
        }
        result

    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
