package com.vivotek.myprototype.backend

import com.amplifyframework.datastore.generated.model.MyOrganization


open class Backend {

    open fun listMyOrganization(): MutableList<MyOrganization> {
        return mutableListOf()
    }
}