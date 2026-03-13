package com.vivotek.myprototype.uicomponent.font

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.vivotek.myprototype.R


private val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs,
)
private val robotoGoogleFont = GoogleFont("Roboto") // Roboto   Lobster Two
private val robotoFont = Font(
    googleFont = robotoGoogleFont,
    fontProvider = provider,
)
private val robotoFontFamily = FontFamily(robotoFont)


val H1: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 96.sp,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Light,
        letterSpacing = (-1.5).sp,
        color = colorResource(id = R.color.text01),
    )

val H2: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 60.sp,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Light,
        letterSpacing = (-0.5).sp,
        color = colorResource(id = R.color.text01),
    )

val H3: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 48.sp,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Normal,
        color = colorResource(id = R.color.text01),
    )

val H4: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 34.sp,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.25.sp,
        color = colorResource(id = R.color.text01),
    )

val H5: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 24.sp,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Normal,
        color = colorResource(id = R.color.text01),
    )

val H6: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 20.sp,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.15.sp,
        color = colorResource(id = R.color.text01),
    )

val Subtitle1: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.15.sp,
        color = colorResource(id = R.color.text01),
    )

val Subtitle2: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 14.sp,
        lineHeight = 24.sp,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.1.sp,
        color = colorResource(id = R.color.text01),
    )

val Body1: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 16.sp,
        lineHeight = 28.sp,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.5.sp,
        color = colorResource(id = R.color.text01),
    )

val Body2: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.25.sp,
        color = colorResource(id = R.color.text01),
    )

val Button: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 14.sp,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Medium,
        letterSpacing = 1.25.sp,
        color = colorResource(id = R.color.text01),
    )

val Caption: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.4.sp,
        color = colorResource(id = R.color.text01),
    )

val OverLine: TextStyle
    @Composable
    get() = TextStyle(
        fontSize = 10.sp,
        lineHeight = 16.sp,
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Medium,
        letterSpacing = 1.5.sp,
        color = colorResource(id = R.color.text01),
    )


@Preview(showBackground = true)
@Composable
fun PreviewTextStyle() {
    Column {
        Text("H1", style = H1)
        Text("H2", style = H2)
        Text("H3", style = H3)
        Text("H4", style = H4)
        Text("H5", style = H5)
        Text("H6", style = H6)
        Text("Subtitle1", style = Subtitle1)
        Text("Subtitle2", style = Subtitle2)
        Text("Body1", style = Body1)
        Text("Body2", style = Body2)
        Text("Button", style = Button)
        Text("Caption", style = Caption)
        Text("OverLine", style = OverLine)
    }
}