package com.tds.githubtrending.model

data class GitHubTrending(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)