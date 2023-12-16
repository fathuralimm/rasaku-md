package app.capstone.rasaku.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import app.capstone.rasaku.R
import app.capstone.rasaku.ui.theme.RasakuTheme
import coil.compose.AsyncImage

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class Recipe(
    val id:Int,
    val imageId: Int,
    val ingredients: String,
    val description: String,
    val steps: String
    )

val recipe = listOf(
    Recipe(
        id = 1,
        imageId = R.drawable.img,
        description = "Soto Lamongan menjadi salah satu makanan khas Jawa Timur yang saat sangat mudah ditemukan di berbagai daerah lainnya. Namun, terdapat perbedaan antara soto Lamongan dengan soto lainnya, yakni koya.",
        ingredients = "1/2 ekor ayam, 4 buah ceker, Serai, Laos seral, daun jeruk, secukupnya kunyit, garam & gula, bumbu, udang mentah",
        steps = "Pertama bikin kaldu dulu.Presto ayam & ceker, tambahkan serai, daun jeruk, kunyit yang sudah dihaluskan dan garam secukupnya supaya ayamnya teras gurih. Presto selama 15 menit dihitung presto mulai berbunyi.\n" +
                "Kedua, bumbunya.Tumis bawang, kunyit, jahe dan kemiri sampai harum. Haluskan bersama dengan udang mentah (tanpa kepala boleh, pakai kepalanya juga boleh) bebaaaas. \n" +
                "Lalu, Tumis kembali bumbu, tambahkan daun jeruk dan laos geprek.\n" +
                "Kemudian, masukkan bumbu ke dalam kuah kaldu, tambahkan garam, gula, lada secukupnya. \n" +
                "Terakhir, koreksi rasa, jika dirasa sudah pas, matikan kompor. \n" +
                "Soto ayam siap dinikmati dengan nasi hangat, jeruk nipis dan sambal \uD83D\uDE0A"

    )
)
@Composable
fun DetailSesungguhnya(

){
    LazyColumn(){
        items(recipe, key = {it.id}){
            DetailScreen(imageId = it.id, description = it.description, ingredients = it.ingredients, steps = it.steps)
        }
    }
}
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    imageId: Int,
    description: String,
    ingredients: String,
    steps: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = modifier
        ) {
            Box {
                Image(
                    painter = painterResource(imageId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)),
                    contentScale = ContentScale.Crop
                )
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription =null,
                    modifier = modifier
                        .padding(12.dp)
                        .clickable { }
                )
            }
        }
        Text(
            text = description,
            modifier = modifier.padding(6.dp)
        )
        Divider(color = MaterialTheme.colorScheme.onBackground,
            thickness = 2.dp,
            modifier = Modifier
                .padding(9.dp)
                .fillMaxWidth())
        Column(modifier = modifier.padding(9.dp)) {
            Text(
                text = "Resep Makanan",
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Default
            )
            Text(
                text = "Bahan",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Default
            )
            Text(text = ingredients)
        }
        Column(modifier = modifier.padding(9.dp)) {
            Text(
                text = "Langkah Pembuatan",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Default
            )
            Text(
                text = steps,
                fontSize = 12.sp,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    RasakuTheme {
        DetailScreen(
            imageId = R.drawable.img,
            description = "Soto Lamongan menjadi salah satu makanan khas Jawa Timur yang saat sangat mudah ditemukan di berbagai daerah lainnya. Namun, terdapat perbedaan antara soto Lamongan dengan soto lainnya, yakni koya.",
            ingredients = "1/2 ekor ayam, 4 buah ceker, Serai, Laos seral, daun jeruk, secukupnya kunyit, garam & gula, bumbu, udang mentah",
            steps = "Pertama bikin kaldu dulu.Presto ayam & ceker, tambahkan serai, daun jeruk, kunyit yang sudah dihaluskan dan garam secukupnya supaya ayamnya teras gurih. Presto selama 15 menit dihitung presto mulai berbunyi.\n" +
                    "Kedua, bumbunya.Tumis bawang, kunyit, jahe dan kemiri sampai harum. Haluskan bersama dengan udang mentah (tanpa kepala boleh, pakai kepalanya juga boleh) bebaaaas. \n" +
                    "Lalu, Tumis kembali bumbu, tambahkan daun jeruk dan laos geprek.\n" +
                    "Kemudian, masukkan bumbu ke dalam kuah kaldu, tambahkan garam, gula, lada secukupnya. \n" +
                    "Terakhir, koreksi rasa, jika dirasa sudah pas, matikan kompor. \n" +
                    "Soto ayam siap dinikmati dengan nasi hangat, jeruk nipis dan sambal \uD83D\uDE0A"

        )
    }
}