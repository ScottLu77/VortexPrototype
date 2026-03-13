package com.vivotek.myprototype.main.bottombar

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.vivotek.myprototype.R
import kotlinx.parcelize.Parcelize

@Parcelize
enum class BottomTabItem(val id: Int, val key: String, @StringRes val title: Int, @DrawableRes val icon: Int, val testTag: String) : Parcelable {
    View(R.id.view_navigation, "view", R.string.view, R.drawable.icon_general_scene_solid, "view_navigation"),
    CustomView(R.id.customized_view_navigation, "customview", R.string.Customized_view, R.drawable.icon_general_customize_view_solid, "customized_view_navigation"),
    Message(R.id.message_navigation, "message", R.string.Message, R.drawable.icon_general_notification_solid, "message_navigation"),
    Archive(R.id.archive_navigation, "archive", R.string.Archive, R.drawable.icon_general_archive_solid, "archive_navigation"),
    FloorPlan(R.id.floor_plan_navigation, "floorplan", R.string.floor_plan, R.drawable.icon_general_floor_plan_solid, "floor_plan"),
    SearchLight(R.id.search_light_navigation, "searchlight", R.string.search_light_title, R.drawable.slcloud_black_24dp, "search_light_navigation"),
    More(R.id.more_navigation, "more", R.string.more_title, R.drawable.icon_general_more_solid, "more_navigation"),
    AIHub(R.id.ai_hub_navigation, "aihub", R.string.AI_Hub, R.drawable.icon_general_ai_solid, "ai_hub_navigation"),
    ThinkSearch(R.id.think_search_navigation, "thinksearch", R.string.Think_search, R.drawable.icon_general_deep_search_lm, "think_search_navigation"),
    DeepSearch(R.id.deep_search_navigation, "deepsearch", R.string.Deep_search, R.drawable.icon_general_ai_solid, "deep_search_navigation"),
    EventInsight(R.id.event_insight_navigation, "eventinsight", R.string.Event_insight, R.drawable.icon_general_notification_solid, "event_insight_navigation");
}