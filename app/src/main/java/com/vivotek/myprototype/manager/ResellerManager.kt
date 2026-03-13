package com.vivotek.myprototype.manager

import com.amplifyframework.datastore.generated.model.SIService
import com.vivotek.myprototype.backend.Backend

open class ResellerManager {

    companion object {

        private var _shared: ResellerManager = ResellerManager()

        fun shared(): ResellerManager {
            return _shared
        }
    }

    private var backend = Backend()
    var resellers = mutableListOf<SIService>()

    init {
        fetch()
    }

    open fun fetch() {
        val organizationID = OrganizationInfoManager.organizationId
        val temp = backend.listSIOfOrganization(organizationID)
        resellers.clear()
        resellers.addAll(temp)
    }
}