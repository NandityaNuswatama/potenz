package com.nandits.potenz.utils

import android.app.Activity
import androidx.appcompat.app.AlertDialog

fun Activity.dialogShow(
    positiveAction: () -> Unit = {}
) {
    AlertDialog.Builder(this).apply {
        setTitle("Konten Terkunci")
        setMessage("Untuk membuka konten ini Anda memerlukan tiket. Ingin beli tiket?")
        setPositiveButton("Beli tiket") { dialog, _ ->
            positiveAction()
            dialog.dismiss()
        }
        create()
        show()
    }
}