package dev.ogabek.kotlin.model

class Filter {
    var title: String? = null
        private set
    var isExploreHave = false
        private set
    val isSelected: Boolean

    constructor(isExploreHave: Boolean, isSelected: Boolean) {
        this.isExploreHave = isExploreHave
        this.isSelected = isSelected
    }

    constructor(title: String?, isSelected: Boolean) {
        this.title = title
        this.isSelected = isSelected
    }
}