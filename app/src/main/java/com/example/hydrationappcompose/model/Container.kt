package com.example.hydrationappcompose.model

import androidx.annotation.StringRes
import com.example.hydrationappcompose.R

enum class Container(@StringRes val messageRes: Int) {
    DAILY_GOAL(messageRes = R.string.lbl_daily_goal_route_message),
    CONTAINER_1(messageRes = R.string.lbl_container_route_message),
    CONTAINER_2(messageRes = R.string.lbl_container_route_message),
    CONTAINER_3(messageRes = R.string.lbl_container_route_message);
}
