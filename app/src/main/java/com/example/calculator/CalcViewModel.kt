package com.example.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalcViewModel: ViewModel() {
    var state by mutableStateOf(CalcState())
    private set

    fun onAction(action: CalcActions){
        when(action){
            is CalcActions.Number -> enterNumber(action.number)
            is CalcActions.Decimal -> enterDecimal()
            is CalcActions.Clear -> state = CalcState()
            is CalcActions.Operation -> enterOperation(action.operation)
            is CalcActions.Calculate -> performCalc()
            is CalcActions.Delete -> performDeletion()
        }
    }



    private fun enterNumber(number: Int) {
        if(state.operation == null){
            if(state.number1.length >= MAX_NUM_LENGTH){
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if(state.number2.length >= MAX_NUM_LENGTH){
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
        return
    }



    private fun enterDecimal() {
        if(state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()){
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }

        if(!state.number2.contains(".") && state.number2.isNotBlank()){
            state = state.copy(
                number2 = state.number2 + "."
            )
        }

    }



    private fun enterOperation(operation: CalcOperations) {
        if(state.number1.isNotBlank()){
            state = state.copy(
                operation = operation
            )
        }
    }



    private fun performCalc() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if(number1 != null && number2 != null) {
            val result = when(state.operation){
                is CalcOperations.Add -> number1 + number2
                is CalcOperations.Subtract -> number1 - number2
                is CalcOperations.Multiply -> number1 * number2
                is CalcOperations.Divide -> number1 / number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }
    }


    private fun performDeletion() {
        when{
            state.number2.isNotBlank() ->  state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }



companion object{
    private const val MAX_NUM_LENGTH = 8
}

}