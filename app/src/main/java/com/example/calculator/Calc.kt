package com.example.calculator

import CalcBtn
import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.Purple200
import com.example.calculator.ui.theme.numbersPink
import com.example.calculator.ui.theme.unicornPurple

@Composable
fun Calc(
    state: CalcState,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier,
    onAction : (CalcActions) -> Unit
){
    Box(modifier = Modifier){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ){
            Text(
                text = state.number1 + (state.operation ?: "") + state.number2,
                textAlign =  TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.WHITE,
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
                        .weight(2f),
                    onClick = {
                        onAction(CalcActions.Clear)
                    }
                )
                CalcBtn(
                    symbol = "DEL",
                    modifier = Modifier
                        .background(unicornPurple)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcActions.Delete)
                    }
                )
                CalcBtn(
                    symbol = "/",
                    modifier = Modifier
                        .background(Purple200)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalcActions.Operation(CalcOperations.Divide))
                    }
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ){
                    CalcBtn(
                        symbol = "7",
                        modifier = Modifier
                            .background(numbersPink)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalcActions.Number(7))
                        }
                    )
                    CalcBtn(
                        symbol = "8",
                        modifier = Modifier
                            .background(numbersPink)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalcActions.Number(8))
                        }
                    )
                    CalcBtn(
                        symbol = "9",
                        modifier = Modifier
                            .background(numbersPink)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalcActions.Number(9))
                        }
                    )
                    CalcBtn(
                        symbol = "*",
                        modifier = Modifier
                    )
                }
            }
        }
    }
}