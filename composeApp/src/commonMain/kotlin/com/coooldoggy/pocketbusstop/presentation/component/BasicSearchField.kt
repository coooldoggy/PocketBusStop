package com.coooldoggy.pocketbusstop.presentation.component

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.coooldoggy.pocketbusstop.presentation.enums.DialogType

@Composable
fun BasicSearchField(backGroundColor: Color) {
    var inputText by remember { mutableStateOf("") }



    BasicTextField(
        value = "",
        onValueChange = {})
}