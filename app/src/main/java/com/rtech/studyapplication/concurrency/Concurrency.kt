package com.rtech.studyapplication.concurrency

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.Duration
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class Concurrency {

}
fun main() = runBlocking {

}
// fun main() = runBlocking {
//     val job = launch {
//         repeat(1000) { i ->
//             println("job: I'm sleeping $i ...")
//             delay(500L)
//         }
//     }
//     delay(1600L)
//     job.cancel()
//     job.join()
//     println("main: Now I can quit.")
// }