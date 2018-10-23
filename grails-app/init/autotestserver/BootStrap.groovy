package autotestserver

import auth.Role
import auth.User
import auth.UserRole


class BootStrap {

    def init = { servletContext ->
//        new Users(userId: 'admin',password: 'admin').save()
        def adminRole = new Role(authority: 'ROLE_ADMIN').save()

        def testUser = new User(username: 'me', password: 'password').save()

        UserRole.create testUser, adminRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }

        assert User.count() == 1
        assert Role.count() == 1
        assert UserRole.count() == 1
    }
    def destroy = {
    }
}
