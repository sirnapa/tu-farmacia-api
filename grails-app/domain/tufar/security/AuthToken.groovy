package tufar.security

class AuthToken {

    String tokenValue
    String username

    static constraints = {
    }

    static mapping = {
       version false
       table name:"auth_token", schema:"security"
       id generator:'sequence', params:[sequence:'security.seq_auth_token_id']
    }
}
