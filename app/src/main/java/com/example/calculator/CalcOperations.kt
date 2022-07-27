package com.example.calculator

sealed class CalcOperations(val symbol: String){
    object Add: CalcOperations("+")
    object Subtract: CalcOperations("-")
    object Multiply: CalcOperations("*")
    object Divide: CalcOperations("/")
}