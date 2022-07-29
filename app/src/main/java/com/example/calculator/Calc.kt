package com.example.calculator

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.Purple200
import com.example.calculator.ui.theme.numbersPink
import com.example.calculator.ui.theme.unicornPurple
import androidx.compose.material.Text
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.text.AnnotatedString

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Calc(
    state: CalcState,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier,
    onAction : (CalcActions) -> Unit
){
    Box(modifier = modifier){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ){
            Text(
                AnnotatedString(text = state.number1 + (state.operation ?: "") + state.number2),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                Color = Color.WHITE,
                textAlign =  TextAlign.End,
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                maxLines = 2
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalcBtn(
                    symbol = "AC",
                    modifier = Modifier
                        .background(unicornPurple)
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    onAction(CalcActions.Clear)
                }
                CalcBtn(
                    symbol = "DEL",
                    modifier = Modifier
                        .background(unicornPurple)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalcActions.Delete)
                }
                CalcBtn(
                    symbol = "/",
                    modifier = Modifier
                        .background(Purple200)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalcActions.Operation(CalcOperations.Divide))
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ){
                    CalcBtn(
                        symbol = "7",
                        modifier = Modifier
                            .background(numbersPink)
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onAction(CalcActions.Number(7))
                    }
                    CalcBtn(
                        symbol = "8",
                        modifier = Modifier
                            .background(numbersPink)
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onAction(CalcActions.Number(8))
                    }
                    CalcBtn(
                        symbol = "9",
                        modifier = Modifier
                            .background(numbersPink)
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onAction(CalcActions.Number(9))
                    }
                    CalcBtn(
                        symbol = "*",
                        modifier = Modifier
                            .background(Purple200)
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onAction(CalcActions.Operation(CalcOperations.Multiply))
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                    ){
                    CalcBtn(
                        symbol = "4",
                        modifier = Modifier
                            .background(numbersPink)
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onAction(CalcActions.Number(4))
                    }
                    CalcBtn(
                        symbol = "5",
                        modifier = Modifier
                            .background(numbersPink)
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onAction(CalcActions.Number(5))
                    }
                    CalcBtn(
                        symbol = "6",
                        modifier = Modifier
                            .background(numbersPink)
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onAction(CalcActions.Number(6))
                    }
                    CalcBtn(
                        symbol = "-",
                        modifier = Modifier
                            .background(Purple200)
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onAction(CalcActions.Operation(CalcOperations.Subtract))
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ){
                    CalcBtn(
                        symbol = "1",
                        modifier = Modifier
                            .background(numbersPink)
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onAction(CalcActions.Number(1))
                    }
                    CalcBtn(
                        symbol = "2",
                        modifier = Modifier
                            .background(numbersPink)
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onAction(CalcActions.Number(2))
                    }
                    CalcBtn(
                        symbol = "3",
                        modifier = Modifier
                            .background(numbersPink)
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onAction(CalcActions.Number(3))
                    }
                    CalcBtn(
                        symbol = "+",
                        modifier = Modifier
                            .background(Purple200)
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onAction(CalcActions.Operation(CalcOperations.Add))
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ){
                    CalcBtn(
                        symbol = "0",
                        modifier = Modifier
                            .background(numbersPink)
                            .aspectRatio(2f)
                            .weight(2f)
                    ) {
                        onAction(CalcActions.Number(0))
                    }
                    CalcBtn(
                        symbol = ".",
                        modifier = Modifier
                            .background(numbersPink)
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onAction(CalcActions.Decimal)
                    }
                    CalcBtn(
                        symbol = "=",
                        modifier =Modifier
                            .background(Purple200)
                            .aspectRatio(1f)
                            .weight(1f)
                    ) {
                        onAction(CalcActions.Calculate)
                    }
                }

            }
        }
    }
}

