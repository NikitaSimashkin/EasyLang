package ru.kram.easylang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import ru.kram.easylang.navigation.BaseEasyLangRouter
import ru.kram.easylang.navigation.BottomBarState
import ru.kram.easylang.navigation.ui.BottomBarScreen
import ru.kram.easylang.ui.theme.EasyLangTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			EasyLangTheme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					val rootNavController = rememberNavController()
					BottomBarScreen(
						state = BottomBarState.SETTINGS,
						router = BaseEasyLangRouter(rootNavController)
					)
				}
			}
		}
	}
}