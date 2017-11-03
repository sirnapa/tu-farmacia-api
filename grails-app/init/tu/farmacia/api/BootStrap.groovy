package tu.farmacia.api

import tufar.security.User
import tufar.security.Role
import tufar.security.UserRole


class BootStrap {

    def init = { servletContext ->

        // Role
        def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(
                authority: 'ROLE_ADMIN',
                description:'Admin'
            ).save(flush: true)

        def sellerRole = Role.findByAuthority('ROLE_SELLER') ?: new Role(
                authority: 'ROLE_SELLER',
                description:'Seller'
            ).save(flush: true)

        def consumerRole = Role.findByAuthority('ROLE_CONSUMER') ?: new Role(
                authority: 'ROLE_CONSUMER',
                description:'Consumer'
            ).save(flush: true)

        // Admin user
        def adminUser = User.findByUsername('admin')
        if(!adminUser){
            adminUser = new User(
                username: 'admin',
                password: 'admin',
                enabled: true).save(failOnError: true)

            new UserRole(user: adminUser, role: adminRole).save(failOnError: true)
        }

    }
    def destroy = {
    }
}
