package com.coooldoggy.pocketbusstop

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform