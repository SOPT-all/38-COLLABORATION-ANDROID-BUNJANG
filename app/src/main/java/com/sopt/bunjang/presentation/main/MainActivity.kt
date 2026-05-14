package com.sopt.bunjang.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BunjangTheme {
                MainScreen(
                    modifier = Modifier
                        .background(color = BunjangTheme.colors.white)
                )
            }
        }
    }
}