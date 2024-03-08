package ru.kram.easylang.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(
	val bottomBarHeight: Dp,
	val bottomBarIconSize: Dp = 28.dp
)

val defaultDimens = Dimens(
	bottomBarHeight = 56.dp
)

val LocalDimens = staticCompositionLocalOf {
	defaultDimens
}

val dimens: Dimens @Composable get() = LocalDimens.current