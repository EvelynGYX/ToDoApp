package com.example.todoapp.ui.screens.task

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todoapp.data.modals.ToDoTask
import com.example.todoapp.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    Scaffold(
        topBar =
        {
            TaskAppBar(selectedTask = selectedTask,navigateToListScreen = navigateToListScreen)
        }
    ) {
        Surface(modifier = Modifier.padding(it)) {

        }
    }

}