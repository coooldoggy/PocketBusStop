package com.coooldoggy.pocketbusstop.presentation.enums

enum class DialogType {
    TwoButton,
    OneButton,
}

sealed class Dialog {
    data class DialogData(val type: DialogType, val title: String, val message: String, val onDismiss: () -> Unit = {}, val onConfirm: () -> Unit = {}): Dialog()
    data class TwoButton(val data: DialogData, val positiveButton: String, val negativeButton: String): Dialog()
    data class OneButton(val data: DialogData, val positiveButton: String): Dialog()
}