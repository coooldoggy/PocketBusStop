package com.coooldoggy.pocketbusstop.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.coooldoggy.pocketbusstop.presentation.enums.Dialog
import com.coooldoggy.pocketbusstop.presentation.enums.DialogType
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BasicDialog(dialogData: Dialog) {
    if (dialogData is Dialog.OneButton) {
        Dialog(
            onDismissRequest = { dialogData.data.onDismiss.invoke() },
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true),
            content = {
                BasicCustomDialog(dialogType = DialogType.OneButton, title = dialogData.data.title, onDismiss = dialogData.data.onDismiss,
                    onConfirm = {}, description = dialogData.data.message)
            }
        )
    }else if (dialogData is Dialog.TwoButton) {
        AlertDialog(
            onDismissRequest = { dialogData.data.onDismiss.invoke() },
            confirmButton =
                { BasicDialogButton(text = dialogData.positiveButton, onClick = { dialogData.data.onConfirm.invoke() }) }
            ,
            dismissButton = { BasicDialogButton(text = dialogData.negativeButton, onClick = { dialogData.data.onDismiss.invoke() }) },
            text = { Text(text = dialogData.data.message, fontSize = 14.sp) },
            title = {  },
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true),
            modifier = Modifier.fillMaxSize(),
            backgroundColor = androidx.compose.ui.graphics.Color.Transparent,
            contentColor = androidx.compose.ui.graphics.Color.Transparent,
            shape = androidx.compose.ui.graphics.RectangleShape,
        )
    }
}

@Composable
fun BasicCustomDialog(dialogType: DialogType,
                title: String,
                onDismiss: () -> Unit,
                onConfirm: () -> Unit,
                description: String? = null,
                confirmButtonText: String = "",
                dismissButtonText: String = "") {
    Box(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        Column {
            Text(text = title, fontSize = 20.sp, modifier = Modifier.padding(top = 16.dp))
            if (description != null) {
                Text(text = description, fontSize = 14.sp)
            }
                Row(modifier = Modifier.padding(top = 16.dp).fillMaxWidth()) {
                    BasicDialogButton(dismissButtonText, onDismiss)
                    if (dialogType == DialogType.TwoButton) {
                        BasicDialogButton(confirmButtonText, onConfirm)
                    }
                }
        }
    }
}

@Composable
fun BasicDialogButton(text: String, onClick: () -> Unit) {
    Button(onClick = { onClick.invoke() }, modifier = Modifier.padding(start = 5.dp)){
        Text(text = text, fontSize = 14.sp)
    }
}

@Preview
@Composable
fun BasicDialogPreview() {
    BasicDialog(DialogType.OneButton, "Title", {}, {}, "Description", "Confirm", "Dismiss")
}


