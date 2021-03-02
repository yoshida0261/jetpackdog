package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class DetailActivity : AppCompatActivity() {

    companion object {
        private val EXTRA_DOGS = "dogs"

        @JvmStatic
        fun createIntent(
            context: Context,
            index: Int
        ) = Intent(context, DetailActivity::class.java).apply {
            putExtra(EXTRA_DOGS, index)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val index = intent?.getIntExtra(EXTRA_DOGS, 1)
            //AndroidDevChallengeTheme {
            // A surface container using the 'background' color from the theme
            val dogs = DogRepository()

            Surface(color = MaterialTheme.colors.background) {

                Detail(dogs.list.get(index!!))
            }
            //}
        }
    }


}


@Composable
fun Detail(dog: Dog) {
    Column() {
        Image(
            painterResource(id = dog.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Text("Name ${dog.name}")
        Text("Descritption ${dog.descript}")

    }

}
