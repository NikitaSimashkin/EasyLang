package ru.kram.easylang.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHost
import androidx.navigation.NavHostController

class BaseEasyLangRouter(
	private val rootNavController: NavHostController
) : EasyLangRouter {

	override fun openLearn() {
		rootNavController.navigate(BottomBarState.LEARN.route)
	}

	override fun openDictionary() {
		rootNavController.navigate(BottomBarState.DICTIONARY.route)
	}

	override fun openSettings() {
		rootNavController.navigate(BottomBarState.SETTINGS.route)
	}

	companion object {

		@Composable
		fun NavHost(
			router: BaseEasyLangRouter,
			startDestination: String,
			modifier: Modifier = Modifier,
			contentAlignment: Alignment = Alignment.Center,
			route: String? = null,
			enterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
				{ fadeIn(animationSpec = tween(700)) },
			exitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
				{ fadeOut(animationSpec = tween(700)) },
			popEnterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
				enterTransition,
			popExitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
				exitTransition,
			builder: NavGraphBuilder.() -> Unit
		) {
			androidx.navigation.compose.NavHost(
				navController = router.rootNavController,
				startDestination = startDestination,
				modifier = modifier,
				contentAlignment = contentAlignment,
				route = route,
				enterTransition = enterTransition,
				exitTransition = exitTransition,
				popEnterTransition = popEnterTransition,
				popExitTransition = popExitTransition,
				builder =  builder
			)
		}
	}
}