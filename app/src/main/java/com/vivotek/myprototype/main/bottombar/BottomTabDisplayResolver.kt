package com.vivotek.myprototype.main.bottombar

import com.vivotek.myprototype.archive.ArchiveFileProvider
import com.vivotek.myprototype.common.FeatureToggle
import com.vivotek.myprototype.main.bottombar.BottomTabItem.Archive
import com.vivotek.myprototype.manager.OrganizationInfoManager

open class BottomTabDisplayResolver {
    private val featureToggle = FeatureToggle.shared()


    open fun visibleTabs(source: List<BottomTabItem>): List<BottomTabItem> {
        return source.filter { featureToggle.canView(it) }
    }

    fun enabled(tab: BottomTabItem): Boolean {
        return featureToggle.canTouch(tab)
    }

    fun showBadge(tab: BottomTabItem): Boolean {
        return when (tab) {
            Archive -> !OrganizationInfoManager.isFreePlan && ArchiveFileProvider.archivingFiles.isNotEmpty()
            else -> false
        }
    }
}