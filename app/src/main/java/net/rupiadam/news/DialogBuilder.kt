package net.rupiadam.news

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Point
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AlertDialog
import android.util.TypedValue
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import com.bumptech.glide.Glide

import java.util.concurrent.Callable

/**
 * Created by rupi on 7/1/2017.
 */

class DialogBuilder {
    private var context: Context
    private var title: String? = null
    private var content: String? = null
    private var icon: Int = 0
    private var backgroundColor: Int? = null

    constructor(context: Context){
        this.context = context
    }

    constructor(context: Context, content: String) {
        this.context = context
        this.content = content
        this.title = "Info"
    }

    constructor(context: Context, title: String, content: String) {
        this.context = context
        this.title = title
        this.content = content
    }

    constructor(context: Context, title: String, content: String, icon: Int, backgroundColor: Int) {
        this.context = context
        this.title = title
        this.content = content
        this.icon = icon
        this.backgroundColor = backgroundColor
    }

    fun show_and_finish() {
        if (!(context as Activity).isFinishing) {
            val dialog = AlertDialog.Builder(context)
            dialog.setTitle(this.title)
            dialog.setMessage(this.content)
            dialog.setCancelable(false)
            dialog.setPositiveButton("Ok") { dialogInterface, i -> (context as Activity).finish() }
            dialog.show()
        }
    }

    fun show_and_dismiss() {
        if (!(context as Activity).isFinishing) {
            val dialog = AlertDialog.Builder(context)
            dialog.setTitle(this.title)
            dialog.setMessage(this.content)
            dialog.setCancelable(false)
            dialog.setPositiveButton("Ok") { dialogInterface, i -> dialogInterface.dismiss() }
            dialog.show()
        }
    }

    fun show_with_dualbutton(positiveButton: String, positiveFunction: Callable<Void>?, negativeButton: String, negativeFunction: Callable<Void>?) {
        val dialog = AlertDialog.Builder(context)
        dialog.setTitle(this.title)
        dialog.setMessage(this.content)
        dialog.setCancelable(false)
        dialog.setPositiveButton(positiveButton) { dialogInterface, i ->
            if (positiveFunction != null) {
                try {
                    positiveFunction.call()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            } else {
                dialogInterface.dismiss()
            }
        }
        dialog.setNegativeButton(negativeButton) { dialogInterface, i ->
            if (negativeFunction != null) {
                try {
                    negativeFunction.call()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            } else {
                dialogInterface.dismiss()
            }
        }
        dialog.show()
    }


}

