package auth

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class AuthLoginInterceptorSpec extends Specification implements InterceptorUnitTest<AuthLoginInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test authLogin interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"authLogin")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
