package buy4me

import grails.plugin.springsecurity.SpringSecurityUtils

class LoginSuccessController {

    def index() {

        if(SpringSecurityUtils.ifAnyGranted('ROLE_USER')){
            redirect(uri: "/home/dashboard")
        } else if (SpringSecurityUtils.ifAnyGranted('ROLE_ADMIN')) {
            redirect(uri: "/secure/dashboard")
        } else {
            redirect(uri: "/logout")
        }
    }
}
