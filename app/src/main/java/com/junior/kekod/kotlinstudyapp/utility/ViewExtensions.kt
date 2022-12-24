package com.junior.kekod.kotlinstudyapp.utility

import androidx.appcompat.widget.AppCompatEditText
import com.junior.kekod.kotlinstudyapp.ui.contract.AbstractTextWatcher
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

fun AppCompatEditText.observeTextChanges(): Flow<String> {
    return callbackFlow {
        val textWatcher = object : AbstractTextWatcher() {
            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                super.onTextChanged(s, p1, p2, p3)
                trySend(s.toString())
            }
        }
        addTextChangedListener(textWatcher)

        awaitClose {
            removeTextChangedListener(textWatcher)
        }
    }.onStart {
        text?.let {
            emit(it.toString())
        }
    }
}