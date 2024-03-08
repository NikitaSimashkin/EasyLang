package ru.kram.easylang.navigation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.kram.easylang.R
import ru.kram.easylang.navigation.BottomBarState
import ru.kram.easylang.ui.theme.colors
import ru.kram.easylang.ui.theme.dimens

@Composable
fun BottomNavigationBar(
	state: BottomBarState,
	onCLickLearn: () -> Unit,
	onCLickDictionary: () -> Unit,
	onCLickSettings: () -> Unit,
	modifier: Modifier = Modifier
) {
	Row(
		modifier = modifier
			.fillMaxWidth()
			.height(dimens.bottomBarHeight)
	) {
		val learnText = stringResource(id = R.string.bottom_bar_learn)
		val dictionaryText = stringResource(id = R.string.bottom_bar_dictionary)
		val settingsText = stringResource(id = R.string.bottom_bar_settings)

		val unselectedColor = colors.onPrimaryContainer
		val selectedColor = colors.onPrimary

		val learnColor = if (state == BottomBarState.LEARN) selectedColor else unselectedColor
		val dictionaryColor =
			if (state == BottomBarState.DICTIONARY) selectedColor else unselectedColor
		val settingsColor = if (state == BottomBarState.SETTINGS) selectedColor else unselectedColor

		BottomBarItem(
			onClick = onCLickLearn,
			icon = Icons.Default.Home,
			iconContentDescription = learnText,
			iconColor = learnColor,
			text = learnText,
			textColor = learnColor,
			modifier = Modifier.weight(1f),
			imageModifier = Modifier.size(dimens.bottomBarIconSize)
		)

		BottomBarItem(
			onClick = onCLickDictionary,
			icon = Icons.AutoMirrored.Filled.List,
			iconContentDescription = dictionaryText,
			iconColor = dictionaryColor,
			text = dictionaryText,
			textColor = dictionaryColor,
			modifier = Modifier.weight(1f),
			imageModifier = Modifier.size(dimens.bottomBarIconSize)
		)

		BottomBarItem(
			onClick = onCLickSettings,
			icon = Icons.Default.Settings,
			iconContentDescription = settingsText,
			iconColor = settingsColor,
			text = settingsText,
			textColor = settingsColor,
			modifier = Modifier.weight(1f),
			imageModifier = Modifier.size(dimens.bottomBarIconSize)
		)
	}
}

@Composable
fun BottomBarItem(
	onClick: () -> Unit,
	icon: ImageVector,
	iconContentDescription: String,
	iconColor: Color,
	text: String,
	textColor: Color,
	modifier: Modifier = Modifier,
	imageModifier: Modifier = Modifier,
	textModifier: Modifier = Modifier,
) {
	Column(
		modifier = modifier
			.clickable { onClick() }
			.fillMaxHeight(),
		verticalArrangement = Arrangement.Center
	) {
		Icon(
			imageVector = icon,
			contentDescription = iconContentDescription,
			modifier = imageModifier.align(Alignment.CenterHorizontally),
			tint = iconColor
		)

		Text(
			text = text,
			modifier = textModifier.align(Alignment.CenterHorizontally),
			style = typography.bodyMedium,
			color = textColor
		)
	}
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
	BottomNavigationBar(
		state = BottomBarState.SETTINGS,
		onCLickLearn = {},
		onCLickDictionary = {},
		onCLickSettings = {}
	)
}
