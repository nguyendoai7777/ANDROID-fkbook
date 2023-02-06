package com.example.fkbook.common.constants

import androidx.annotation.StringRes
import com.example.fkbook.R

enum class AppRoutes(@StringRes val title: Int) {
    Home(title = R.string.home),
    Friend(title = R.string.friend),
    Video(title = R.string.game),
    Personal(title = R.string.personal),
    Notifies(title = R.string.notification),
    Settings(title = R.string.settings),
}