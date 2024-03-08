package ru.kram.easylang.navigation.ui

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.composable
import ru.kram.easylang.navigation.BaseEasyLangRouter
import ru.kram.easylang.navigation.BaseEasyLangRouter.Companion.NavHost
import ru.kram.easylang.navigation.BottomBarState

@Composable
fun BottomBarScreen(
	state: BottomBarState,
	router: BaseEasyLangRouter,
) {
	Column {
		Box(modifier = Modifier.weight(1f)) {
			SetupNavigation(router)
		}

		BottomNavigationBar(
			state = state,
			onCLickLearn = router::openLearn,
			onCLickDictionary = router::openDictionary,
			onCLickSettings = router::openSettings
		)
	}
}

@Composable
private fun SetupNavigation(router: BaseEasyLangRouter) {
	NavHost(
		router = router,
		startDestination = BottomBarState.LEARN.route,
		enterTransition = { EnterTransition.None },
		exitTransition = { ExitTransition.None }
	) {
		composable(
			BottomBarState.LEARN.route
		) {
			Box(
				modifier = Modifier
					.fillMaxSize()
					.background(Color.Red)
			) {
			}
		}

		composable(
			BottomBarState.DICTIONARY.route
		) {
			Box(
				modifier = Modifier
					.fillMaxSize()
					.background(Color.Green)
			) {
			}
		}

		composable(
			BottomBarState.SETTINGS.route
		) {
			Box(
				modifier = Modifier
					.fillMaxSize()
					.background(Color.Blue)
			) {
			}
		}
	}
}