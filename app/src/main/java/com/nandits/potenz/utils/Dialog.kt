package com.nandits.potenz.utils

import android.app.Activity
import androidx.appcompat.app.AlertDialog

fun Activity.dialogShow(
    title: String, message: String, cancelable: Boolean = false,
    positiveButton: String, positiveAction: () -> Unit = {},
    negativeButton: String, negativeAction: () -> Unit = {}
) {
    AlertDialog.Builder(this).apply {
        setTitle(title)
        setMessage(message)
        setCancelable(cancelable)
        setPositiveButton(positiveButton) { dialog, _ ->
            positiveAction()
            dialog.dismiss()
        }
        setNegativeButton(negativeButton) { dialog, _ ->
            negativeAction()
            dialog.dismiss()
        }
        create()
        show()
    }
}