package com.ortalesoft.letsshop.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.ortalesoft.letsshop.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val nunitoFont = GoogleFont("Nunito")
val dmSansFont = GoogleFont("DM Sans")

val Nunito = FontFamily(
    Font(googleFont = nunitoFont, fontProvider = provider, weight = FontWeight.Normal),
    Font(googleFont = nunitoFont, fontProvider = provider, weight = FontWeight.Medium),
    Font(googleFont = nunitoFont, fontProvider = provider, weight = FontWeight.SemiBold),
    Font(googleFont = nunitoFont, fontProvider = provider, weight = FontWeight.Bold),
)

val DmSans = FontFamily(
    Font(googleFont = dmSansFont, fontProvider = provider, weight = FontWeight.Normal),
    Font(googleFont = dmSansFont, fontProvider = provider, weight = FontWeight.Medium),
)

// Set of Material typography styles to start with
val LetsShopTypography = Typography(
    // Nunito for headings and titles
    displayLarge  = TextStyle(fontFamily = Nunito, fontWeight = FontWeight.Bold,   fontSize = 32.sp),
    displayMedium = TextStyle(fontFamily = Nunito, fontWeight = FontWeight.Bold,   fontSize = 26.sp),
    headlineLarge = TextStyle(fontFamily = Nunito, fontWeight = FontWeight.Bold,   fontSize = 22.sp),
    headlineMedium= TextStyle(fontFamily = Nunito, fontWeight = FontWeight.SemiBold, fontSize = 18.sp),
    titleLarge    = TextStyle(fontFamily = Nunito, fontWeight = FontWeight.SemiBold, fontSize = 16.sp),
    titleMedium   = TextStyle(fontFamily = Nunito, fontWeight = FontWeight.SemiBold, fontSize = 14.sp),

    // DM Sans for body and labels
    bodyLarge     = TextStyle(fontFamily = DmSans, fontWeight = FontWeight.Normal, fontSize = 16.sp),
    bodyMedium    = TextStyle(fontFamily = DmSans, fontWeight = FontWeight.Normal, fontSize = 14.sp),
    bodySmall     = TextStyle(fontFamily = DmSans, fontWeight = FontWeight.Normal, fontSize = 12.sp),
    labelLarge    = TextStyle(fontFamily = DmSans, fontWeight = FontWeight.Medium, fontSize = 14.sp),
    labelMedium   = TextStyle(fontFamily = DmSans, fontWeight = FontWeight.Medium, fontSize = 12.sp),
    labelSmall    = TextStyle(fontFamily = DmSans, fontWeight = FontWeight.Medium, fontSize = 10.sp),
)