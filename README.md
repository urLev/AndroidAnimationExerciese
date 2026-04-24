# Android Animation Exercises
---
## Exercise 1: Basic Fade-In Animation

### Objective
Create a simple fade-in animation that runs when a composable first appears. The starter code for this is available in Task1.kt

### Requirements
* Display a Text composable with "Hello Android!"
* Apply a fade-in effect whent he composable is first composed
* The animation should take 5000ms to complete (5s)
* use animateFloatAsState for the alpha property

---

## Exercise 2: Animate a composable onto the screen

### Objective
Animate a composable onto and off of the screen. The starter code is found in Task2.kt

### Requirements
* Use the provided Button composable to toggle the state of whether or not additional composables are visible on the screen
* Use the AnimatedVisiblity composable that listens to the above mentioned state and determines whether or not new composbales are shows on the screen.
* AnimatedVisible allows us to not only specify the state we want to listen to, but also specify how we want to animate into and out of visibility
* Call the AnimatedVisible composable with the contents of the Box composable that has been included. 
* In the AnimatedVisible parameters, specify the state we want to listen to, and an enter and exit animation style

```kotlin
//AnimatedVisible(
//    ...
//) {
//    Box(
//        modifier = Modifier.background(Color.Red)
//    )
//}
```

## Exercise 3: Infinite Animation

### Objective
Create a loading animation that continuously changes between two colors and has the `Loading...` text that fades in and out

The source code for this task is in Task5.kt

### Requirements
* You are given a Box composable that is clipped to a Circle shape
* set an infinite animation to the color of this composable that transitions between two `Color`s.
* Optionally, you can also add another infinite animation on the Text composable that transitions the alpha value of the text to appear as if it is fading in and out.

## Exercise 4: Animated List Item Appearance

### Objective
Create a list where items animate in with a staggered effect (each item animates slightly after the previous one.) The source code for this task is found in `Task6.kt`

### Requirements
* Display a `LazyColumn` with 8 items
* Each item should fade in and slide up from below as the list loads
* Items should appear with a staggered delay(e.g. 100ms between each)
* use `animateFloatAsState` for alpha value
* use `animateDpAsState` for vertical offset
* Each item should be a `Card` with title and description

