package com.example.fkbook.common.model

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.unit.Velocity

interface NestedScrollConnection {

    fun onPreScroll(available: Offset, source: NestedScrollSource): Offset = Offset.Zero

    fun onPostScroll(
        consumed: Offset,
        available: Offset,
        source: NestedScrollSource
    ): Offset = Offset.Zero

    suspend fun onPreFling(available: Velocity): Velocity = Velocity.Zero

    suspend fun onPostFling(consumed: Velocity, available: Velocity): Velocity {
        return Velocity.Zero
    }
}