package com.staskokoc.giphydevcomposekoin.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.staskokoc.giphydevcomposekoin.ui.activities.MainViewModel

@Composable
// @Preview(showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
fun GifsScreen(vm: MainViewModel) {
    val searchText = remember { mutableStateOf("") }
    val gifs = vm.liveDataGifs.observeAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 4.dp, start = 4.dp, end = 4.dp)
    ) {
        Row(modifier = Modifier.height(60.dp).padding(bottom = 4.dp),
        ) {
            SearchBar(
                modifier = Modifier
                    .padding(end = 4.dp)
                    .fillMaxWidth(0.7F)
                    .fillMaxHeight(),
                shape = RoundedCornerShape(4.dp),
                query = searchText.value,
                onQueryChange = { text -> searchText.value = text },
                onSearch = { text -> vm.getGifs(q = text) },
                placeholder = { Text(text = "type to search ...") },
                active = false,
                onActiveChange = {}
            ) {}
            Button(
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxSize(),
                shape = RoundedCornerShape(4.dp),
                onClick = { vm.getGifs(q = searchText.value) }
            ) {
                Text(text = "search")
            }
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            gifs.value?.let {
                items(it.listOfUrls) { url ->
                    ListGif(url = url)
                }
            }
        }
    }
}
