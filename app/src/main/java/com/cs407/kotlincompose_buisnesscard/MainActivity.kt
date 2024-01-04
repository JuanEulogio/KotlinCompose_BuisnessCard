package com.cs407.kotlincompose_buisnesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cs407.kotlincompose_buisnesscard.ui.theme.KotlinCompose_BuisnessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinCompose_BuisnessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    buisnessCardApp()
                }
            }
        }
    }
}

@Composable
fun buisnessCardApp(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        //TODO: note we attack the modifer to it
        modifier= modifier
            .background(colorResource(id = R.color.background))
            .padding(16.dp)
    ){
        buisnessCardHeader(name = stringResource(R.string.name), title = stringResource(R.string.title), modifier.weight(3f))
        buisnessCardContactInfo(number = stringResource(R.string.number), github = stringResource(R.string.github), email = stringResource(R.string.email), modifier.weight(1f))
    }

}


@Composable
fun buisnessCardHeader(name: String, title: String, modifier: Modifier = Modifier) {

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profilepicexample), contentDescription = "profilePicture",
            Modifier
                .clip(CircleShape)
                .border(8.dp, Color.Black, CircleShape)
                .size(260.dp)
        )
        Text(
            text= name,
            modifier= Modifier,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = title,
            modifier= Modifier,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun buisnessCardContactInfo(number: String, github: String, email: String, modifier: Modifier = Modifier) {
    Column (
        modifier.padding(8.dp)
    ) {

        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_phone),
                contentDescription = "phone number",
                modifier= Modifier.padding(end = 12.dp)
            )
            Text(
                text = number,
                modifier= Modifier,
                fontSize = 16.sp
            )
        }
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_github),
                contentDescription = "github link",
                modifier= Modifier.padding(end = 12.dp)
            )
            Text(
                text = github,
                modifier= Modifier,
                fontSize = 16.sp
            )
        }
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = "email address",
                modifier= Modifier.padding(end = 12.dp)
            )
            Text(
                text = email,
                modifier= Modifier,
                fontSize = 16.sp
            )
        }

    }

}



@Preview(showBackground = true)
@Composable
fun buisnessCardAppPreview() {
    KotlinCompose_BuisnessCardTheme {
        buisnessCardApp()
    }
}