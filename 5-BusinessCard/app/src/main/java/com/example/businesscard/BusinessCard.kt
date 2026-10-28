package com.example.businesscard

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val AndroidGreen = Color(0xFF3DDC84)

@Composable
fun BusinessCardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(2f).fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier.height(120.dp)
            )
            Text(
                text = "Your Full Name",
                fontSize = 40.sp,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Android Developer",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = AndroidGreen
            )
        }
        Column(
            modifier = Modifier.weight(1f).padding(bottom = 32.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            ContactRow(Icons.Filled.Phone, "+970 59 000 0000")
            ContactRow(Icons.Filled.Share, "@AndroidDev")
            ContactRow(Icons.Filled.Email, "you@example.com")
        }
    }
}

@Composable
private fun ContactRow(icon: ImageVector, text: String) {
    Row(Modifier.padding(vertical = 6.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = icon, contentDescription = null, tint = AndroidGreen)
        Spacer(Modifier.width(24.dp))
        Text(text = text, color = MaterialTheme.colorScheme.onBackground)
    }
}

@Preview(name = "Light", showBackground = true, showSystemUi = true)
@Preview(name = "Dark", showBackground = true, showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        Surface(color = MaterialTheme.colorScheme.background) { BusinessCardScreen() }
    }
}
