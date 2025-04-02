package com.michaelrichards.pagepal.navigation

sealed class Graph(
    val graphName: String
){
    data object Auth: Graph("authentication")
    data object Main: Graph("main")
}
