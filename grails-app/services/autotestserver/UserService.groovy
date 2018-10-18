package autotestserver

import auth.User
import grails.gorm.transactions.Transactional
import groovy.util.logging.Log4j

@Log4j
@Transactional
class UserService {

    def login(String userId,String passWord){
        User.findByUserIdAndPassword(userId,passWord)
    }
    def create(User user){
        if (!user.validate()){
            user.errors.allErrors.each {
                log.error(it)
            }
        }
        user.save()
    }
}
