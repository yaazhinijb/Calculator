package com.example.calculator

sealed class CalcActions{
    data class Number(val number: Int): CalcActions()
    object Clear: CalcActions()
    object Delete: CalcActions()
    data class Operation(val operation: CalcOperations): CalcActions()
    object Calculate: CalcActions()
    object Decimal: CalcActions()
}