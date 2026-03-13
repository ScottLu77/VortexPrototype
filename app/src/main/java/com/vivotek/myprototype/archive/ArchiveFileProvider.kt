package com.vivotek.myprototype.archive

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.vivotek.myprototype.backend.Backend
import com.vivotek.myprototype.backend.model.ArchiveFilterV2
import com.vivotek.myprototype.manager.OrganizationInfoManager
import kotlin.properties.Delegates


open class BaseArchiveFileProvider {

    var fetchingState = mutableStateOf(false)
    var archivingFiles = mutableStateListOf<ArchiveFile>()
    val successFiles = mutableStateListOf<ArchiveFile>()

    open fun fetchArchiveFiles() {}
}

class ArchiveFileProvider {
    companion object : BaseArchiveFileProvider() {

        private var backend: Backend = Backend()

        private var filter = ArchiveFilterV2()
        private var files: MutableList<ArchiveFile> by Delegates.observable(mutableListOf()) { _, _, newValue ->
            val archiving = newValue
                .filter { file -> file.archivingAction != ArchiveAction.Success }
                .sortedBy { it.createdAt }
            val success = newValue
                .filter { file -> file.archivingAction == ArchiveAction.Success }
                .sortedByDescending { it.createdAt }
            val devices = success
                .map { it.deviceID }
                .distinct()

            // Update new Compose state
            archivingFiles.clear()
            archivingFiles.addAll(archiving)
            successFiles.clear()
            successFiles.addAll(success)
        }


        override fun fetchArchiveFiles() {
            val result = backend.fetchArchiveFileList(OrganizationInfoManager.organizationId, filter)
            files = result.toMutableList()
        }

    }
}