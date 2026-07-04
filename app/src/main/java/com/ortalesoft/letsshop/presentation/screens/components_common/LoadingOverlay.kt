package com.ortalesoft.letsshop.presentation.screens.components_common

import android.graphics.drawable.Animatable
import androidx.appcompat.widget.AppCompatImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.ortalesoft.letsshop.R

@Composable
fun LoadingOverlay(
    isLoading: Boolean,
    modifier: Modifier = Modifier
) {

    if (!isLoading) return

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.0f))
            .pointerInput(Unit) {
                awaitPointerEventScope {
                    while (true) {
                        awaitPointerEvent()
                    }
                }
            },
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            AndroidView(
                modifier = Modifier.size(140.dp),
                factory = { context ->

                    AppCompatImageView(context).apply {

                        setImageResource(R.drawable.ic_lets_shop_android_animated)

                        (drawable as? Animatable)?.start()
                    }
                },
                update = { imageView ->
                    (imageView.drawable as? Animatable)?.start()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingOverlayPreview() {
    LoadingOverlay(
        isLoading = true,
        modifier = Modifier.fillMaxSize()
    )
}