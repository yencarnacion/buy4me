package buy4me.auth

import buy4me.NeedItem

class B4mUser extends User{

    static constraints = {
    }

    static hasMany = [needs: NeedItem]
}
