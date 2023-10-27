package com.example.playdata.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.playdata.data.DataForm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CobaViewModel : ViewModel(){
    var namaUsr: String by mutableStateOf("") //revised
        private set
    var alamatUsr: String by mutableStateOf("")
        private set
    var noTlp: String by mutableStateOf("")
        private set
    var jenisKl: String by mutableStateOf("")
        private set
    var eMail: String by mutableStateOf("")
        private set
    var statuS: String by mutableStateOf("")
        private set
    private val _uiState = MutableStateFlow(DataForm())
    val uiState: StateFlow<DataForm> = _uiState.asStateFlow()

    fun insertData(nm: String, almt:String, tlp:String, jk:String, email: String, status: String){
        namaUsr =nm
        alamatUsr = almt
        noTlp = tlp
        jenisKl = jk
        eMail = email
        statuS = status
    }

    fun setJenisK(pilihJk: String){
        _uiState.update { currentState -> currentState.copy(sex = pilihJk) }
    }

    fun setStatus(pilihS: String){
        _uiState.update { currentState -> currentState.copy(status = pilihS) }
    }
}