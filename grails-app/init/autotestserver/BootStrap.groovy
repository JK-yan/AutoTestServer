package autotestserver

import auth.User

class BootStrap {

    def init = { servletContext ->
        new User(userId: 'admin',password: 'admin').save()
    }
    def destroy = {
    }
}
