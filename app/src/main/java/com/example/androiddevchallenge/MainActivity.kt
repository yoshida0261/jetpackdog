/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                SimpleList()
            }
        }
    }
}

@Composable
fun SimpleList() {
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .verticalScroll(scrollState)
    ) {
        val dogs = DogRepository()
        repeat(5) {
            ImageListItem(dogs.list, it)
        }
    }
}

@Composable
fun ImageListItem(list: List<Dog>, index: Int) {
    val context = LocalContext.current
    Row(
        Modifier.clickable {
            val intent = DetailActivity.createIntent(context, index)
            context.startActivity(intent)
        }
    ) {
        Image(
            painterResource(id = list.get(index).image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(150.dp)
        )
        Spacer(Modifier.width(10.dp))
        val name = list.get(index).name
        val age = list.get(index).age
        Column {
            Text("Name $name", style = MaterialTheme.typography.subtitle1)
            Text("Age  $age")
        }
    }
}

@Preview
@Composable
fun prev() {
    SimpleList()
}
