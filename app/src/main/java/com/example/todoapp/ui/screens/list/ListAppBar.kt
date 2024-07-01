package com.example.todoapp.ui.screens.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todoapp.ui.viewModels.SharedViewModel
import com.example.todoapp.util.SearchAppBarState

@Composable
fun ListAppBar(
    modifier: Modifier = Modifier,
    sharedViewModel: SharedViewModel,
    searchAppBarState: SearchAppBarState,
    searchTextState: String
) {
    when(searchAppBarState) {
        SearchAppBarState.CLOSED -> {
            DefaultListAppBar(
                onSearchClicked = {
                    sharedViewModel.searchAppBarState.value = SearchAppBarState.OPENED
                },
                onSortClicked = {

                },
                onDeleteClicked = {}
            )
        }
        else -> {
            SearchAppBar(
                text = searchTextState,
                onSearchClicked = {

                },
                onCloseClicked = {
                    sharedViewModel.searchAppBarState.value = SearchAppBarState.CLOSED
                    sharedViewModel.searchTextState.value = ""
                },
                onTextChange = { newText ->
                    sharedViewModel.searchTextState.value = newText
                }
            )
        }
    }
}