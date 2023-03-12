package com.lucassimao.sorteianomesenumeros.util

import android.widget.EditText

fun EditText.isEmptyOrNull(): Boolean {
    return this.text.toString().trim().isEmpty()
}