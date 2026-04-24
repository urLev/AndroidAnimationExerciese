package com.goble.animationpractice.views

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun Task6() {
    val items = remember { (1..8).map { "Item $it" } }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(items) { index, item ->
            // TODO: Create animated list item here
            // remember to user index for staggered animation
            AnimatedListItem(
                index = index,
                description = "Description for $item",
                title = item
            )
        }
    }
}

@Composable
fun AnimatedListItem(
    title: String,
    description: String,
    index: Int
) {
    // TODO Implement the list item with animations
    // use remember to track whether item should be visible
    // calculate delay based on index

    var isVisible by remember{mutableStateOf(false)}

    LaunchedEffect(Unit){
        delay(timeMillis = index * 250L)
        isVisible = true
    }

    val alpha by animateFloatAsState(
        targetValue =
            if (isVisible)
                1f
            else
                0f,
        animationSpec = tween(durationMillis = 1000)
    )

    val offset by animateDpAsState(
        targetValue = if (isVisible)
            0.dp
        else
            500.dp,
        animationSpec = tween(durationMillis = 1000)
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = offset)
            .graphicsLayer{this.alpha = alpha}
    ){
        Column(
            modifier = Modifier
                .padding(15.dp)
        ){
            Text(
                text = title
            )
            Spacer(
                modifier = Modifier
                    .height(4.dp)
            )
            Text(
                text = description
            )
        }
    }
}