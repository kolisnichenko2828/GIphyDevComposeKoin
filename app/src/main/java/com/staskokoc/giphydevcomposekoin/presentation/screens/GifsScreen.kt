package com.staskokoc.giphydevcomposekoin.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
@OptIn(ExperimentalMaterial3Api::class)
fun GifsScreenCompose(onClick: (String) -> Unit = {}) {
    val vm: MainViewModel = koinViewModel()
    val gifs = vm.liveDataGifs.observeAsState()
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
                onValueChange = { value -> searchText.value = value },
                onSearch = {
                    focusManager.clearFocus()
                    vm.getGifs(q = searchText.value)
                }
            )
            OutlinedButton(
                modifier = Modifier.padding(top = 4.dp).fillMaxWidth().height(60.dp),
                shape = RoundedCornerShape(4.dp),
                // textStyle = TextStyle(fontSize = 18.sp),
                onClick = {
                    focusManager.clearFocus()
                    vm.getGifs(q = searchText.value)
                }
            ) {
                Text(text = "search", style = TextStyle(fontSize = 18.sp))
            }
        }
        LazyColumn(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surface)
                .fillMaxSize()
        ) {
            gifs.value?.let {
                items(it.listOfUrls) { url ->
                    ListGifCompose(url = url, onClick = onClick)
                }
            }
        }
    }
}
