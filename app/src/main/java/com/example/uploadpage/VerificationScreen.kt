package com.example.uploadpage

import android.widget.Button
import android.widget.RadioButton
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.*
import kotlinx.coroutines.selects.select

@Composable
fun VerificationScreen(){
     Column(modifier = Modifier.fillMaxSize()){
         TopBar(name = "Verification & Limits                  ",
         modifier = Modifier.padding(4.dp))
         Spacer(modifier = Modifier.height(4.dp))
         UploadProof(name = "Upload proof of address",
         modifier = Modifier.padding(top=7.dp ))
         Buttons(modifier = Modifier.padding(3.dp))
         Spacer(Modifier.height(12.dp))
         ContinueButton()
         Spacer(modifier = Modifier.height(120.dp))
     }
}
@Composable
fun TopBar(
    name: String,
    modifier: Modifier=Modifier
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            ){
        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription ="Back",
            tint= Color.Black,
            modifier=Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )


    }
}

@Composable
fun UploadProof(
    name:String,
    modifier: Modifier=Modifier
){
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Upload proof of address ",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
        
    }
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "verify your address by uploading one of the following documents:",
            fontSize = 10.sp)
    }
}


@Composable
fun Buttons(
    modifier: Modifier=Modifier
){
    var selectedOption by remember { mutableStateOf(0) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(5.dp)
                ),

        ) {
            RadioButton(selected = selectedOption==0 ,
                onClick = { selectedOption=0 }
            )
            Text(text = "Utility Bill")
        }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
    ) {
        RadioButton(selected = selectedOption==1 ,
            onClick = { selectedOption=1 }
        )
        Text(text = "Bank Statement")
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
    ) {
        RadioButton(selected = selectedOption==2 ,
            onClick = { selectedOption=2 }
        )
        Text(text = "Loan Statement")
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
    ) {
        RadioButton(selected = selectedOption==3 ,
            onClick = { selectedOption=3 }
        )
        Text(text = "Credit Card Statement")
    }

}
@Composable
fun ContinueButton(
    modifier: Modifier=Modifier
){
   Row(
       verticalAlignment = Alignment.CenterVertically,
       horizontalArrangement = Arrangement.Center,
       modifier = modifier
           .fillMaxWidth()
      ) {
       Button(
           onClick = { /*TODO*/ }) {
           Text(text = "Continue",color =Color.Black)
       }
   }
}