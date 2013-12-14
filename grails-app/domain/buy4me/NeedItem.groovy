package buy4me

import buy4me.auth.B4mUser

class NeedItem {

    static constraints = {
    }

    static belongsTo = [needyUser: B4mUser]
    String what;
    String whereFrom;
}
