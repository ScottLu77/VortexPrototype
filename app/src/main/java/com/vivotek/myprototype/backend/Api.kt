package com.vivotek.myprototype.backend

import com.google.gson.Gson
import com.vivotek.myprototype.backend.model.GetSitesResponse
import com.vivotek.myprototype.backend.model.Site

open class Api {

    fun getSites(): List<Site> {
        val gson = Gson()
        val response = gson.fromJson(JsonContents.GET_SITES_JSON, GetSitesResponse::class.java)
        return response.sites
    }


}