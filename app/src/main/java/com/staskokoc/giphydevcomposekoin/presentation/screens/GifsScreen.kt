package com.staskokoc.giphydevcomposekoin.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.staskokoc.giphydevcomposekoin.presentation.activities.MainViewModel
import com.staskokoc.giphydevcomposekoin.presentation.widgets.SearchBarCompose
import org.koin.androidx.compose.koinViewModel

@Composable
@Preview(showSystemUi = true)
fun GifsScreenCompose(onClick: (String) -> Unit = {}) {
    val vm: MainViewModel = koinViewModel()
    if(vm.gifsLiveData.value == null) { vm.getTrendingGifs() }
    val gifsState = vm.gifsLiveData.observeAsState()
    val searchText = remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.surface)
            .fillMaxSize()
            .padding(start = 4.dp, end = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surface)
                .height(68.dp)
                .padding(bottom = 4.dp)
        ) {
            SearchBarCompose(
                modifier = Modifier
                    .padding(top = 4.dp, end = 4.dp)
                    .fillMaxWidth(0.7F)
                    .height(60.dp),
                value = searchText.value,
                onValueChange = { v ->
                    if(v.isEmpty()) {
                        searchText.value = v
                    } else if(v.isNotEmpty() && v[v.length - 1] == '\n' && v[0] != ' ' && v[0] != '\n') {
                        searchText.value = v
                        focusManager.clearFocus()
                        vm.getGifs(q = searchText.value)
                    } else if(v.isNotEmpty() && v[0] != ' ' && v[0] != '\n') {
                        searchText.value = v
                    } else if(v.isNotEmpty() && (v[0] == ' ' || v[0] == '\n')) {
                        searchText.value = ""
                    }
                },
                onSearch = {
                    if(searchText.value.isNotEmpty()) {
                        focusManager.clearFocus()
                        vm.getGifs(q = searchText.value)
                    } else if(searchText.value.isEmpty()) {
                        focusManager.clearFocus()
                    }
                }
            )
            OutlinedButton(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(4.dp),
                onClick = {
                    if(searchText.value.isNotEmpty()) {
                        focusManager.clearFocus()
                        vm.getGifs(q = searchText.value)
                    }
                }
            ) {
                Text(
                    text = "search",
                    style = TextStyle(fontSize = 18.sp)
                )
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(128.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
        ) {
            gifsState.value?.let {
                items(it.listOfUrlsPreviewGifs.size) { position ->
                    ListGifCompose(
                        url = it.listOfUrlsPreviewGifs[position],
                        urlLarge = it.listOfUrlsLargeGifs[position],
                        onClick = onClick)
                }
            }

        }
    }
}
