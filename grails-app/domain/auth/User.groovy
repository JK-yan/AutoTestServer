package auth

class User {
    String userId
    String password
    Date dateCreated
    Date lastUpdated
//    String email
//    String phone
//    String address

    static constraints = {
        userId(size: 2..10,blank: false,unique: true,)
        password(size: 2..10,blank: false)
    }
}
