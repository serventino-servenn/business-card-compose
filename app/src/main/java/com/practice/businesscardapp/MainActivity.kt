package com.practice.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.businesscardapp.ui.theme.BusinessCardAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Surface(
                    color=MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 50.dp, bottom = 50.dp),
    ) {
        HeaderSection(
            modifier = Modifier.weight(1f),
        )
        ContactInfoSection()
    }
}

@Composable
fun HeaderSection(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ProfileImage()
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(R.string.developer_name),
            fontSize = 25.sp,
            fontWeight = FontWeight.Thin
        )
        Text(
            text = stringResource(R.string.developer_occupation),
            fontWeight = FontWeight.Normal,
            color = colorResource(R.color.main_color)
        )
    }
}

@Composable
fun ProfileImage(){
    Image(
        painter = painterResource(R.drawable.serventino),
        contentDescription = "profile image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(170.dp)
            .clip(CircleShape)
            .border(
                width = 4.dp,
                color = colorResource(R.color.main_color),
                shape = CircleShape
            )
    )
}



@Composable
fun ContactInfoSection(modifier: Modifier = Modifier){
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 200.dp)
            .padding(20.dp),
        shadowElevation = 1.dp,
        color = Color.Transparent,


    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            ContactInfo(
                icon = Icons.Default.Share,
                contact = stringResource(R.string.social_media)
            )
            Spacer(modifier = Modifier.height(10.dp))
            ContactInfo(
                icon = Icons.Default.Call,
                contact = stringResource(R.string.phone_number)
            )
            Spacer(modifier = Modifier.height(10.dp))
            ContactInfo(
                icon = Icons.Default.Email,
                contact = stringResource(R.string.developer_email)
            )
        }
    }
}

@Composable
fun ContactInfo(
    icon:ImageVector,
    contact:String,
){
    Row{
        Icon(
            imageVector = icon,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(25.dp))
        Text(
            text = contact,
            color = colorResource(R.color.main_color),
            fontWeight = FontWeight.Light,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}
