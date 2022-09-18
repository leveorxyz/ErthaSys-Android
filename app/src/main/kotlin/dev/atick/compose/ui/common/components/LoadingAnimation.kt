package dev.atick.compose.ui.common.components

import android.animation.ValueAnimator
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.airbnb.lottie.LottieAnimationView
import dev.atick.compose.R

@Composable
fun LoadingAnimation() {
    AndroidView(
        factory = { ctx ->
            LottieAnimationView(ctx).apply {
                setAnimation(R.raw.loading)
                repeatCount = ValueAnimator.INFINITE
                playAnimation()
            }
        },
        modifier = Modifier
            .width(160.dp)
            .height(160.dp)
    )

}