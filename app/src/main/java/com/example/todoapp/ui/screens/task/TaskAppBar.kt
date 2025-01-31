package com.example.todoapp.ui.screens.task

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoapp.R
import com.example.todoapp.data.modals.Priority
import com.example.todoapp.data.modals.ToDoTask
import com.example.todoapp.ui.theme.topAppBarBackgroundColor
import com.example.todoapp.ui.theme.topAppBarContentColor
import com.example.todoapp.util.Action

@Composable
fun TaskAppBar(selectedTask: ToDoTask?, navigateToListScreen: (Action) -> Unit) {
    if(selectedTask == null) {
        NewTaskAppBar(navigateToListScreen = navigateToListScreen)
    } else {
        ExistingTaskAppBar(selectedTask = selectedTask, navigateToListScreen = navigateToListScreen)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTaskAppBar(
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            BackAction(onBackClicked  = navigateToListScreen)
        },
        title = {
            Text(text = "Add Task", color = MaterialTheme.colorScheme.topAppBarContentColor)
        },
        colors = TopAppBarDefaults.topAppBarColors().copy(
            containerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor
        ),
        actions = {
            AddAction (onAddClicked = navigateToListScreen)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExistingTaskAppBar(
    selectedTask: ToDoTask,
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            CloseAction(onCloseClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = selectedTask.title,
                color = MaterialTheme.colorScheme.topAppBarContentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = TopAppBarDefaults.topAppBarColors().copy(
            containerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor
        ),
        actions = {
            DeleteAction (onDeleteClicked = navigateToListScreen)
            UpdateAction (onUpdateClicked = navigateToListScreen)
        }
    )
}

@Composable
fun AddAction(
    onAddClicked: (Action) -> Unit
) {
    IconButton(onClick = { onAddClicked (Action.ADD)}) {
        Icon(imageVector = Icons.Filled.Check, contentDescription = stringResource(R.string.add_task), tint = MaterialTheme.colorScheme.topAppBarContentColor)
    }
}

@Composable
fun BackAction(
    onBackClicked: (Action) -> Unit
) {
    IconButton(onClick = { onBackClicked (Action.NO_ACTION)}) {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = stringResource(R.string.back_arrow), tint = MaterialTheme.colorScheme.topAppBarContentColor)
    }
}

@Composable
fun CloseAction(
    onCloseClicked: (Action) -> Unit
) {
    IconButton(onClick = { onCloseClicked (Action.NO_ACTION)}) {
        Icon(imageVector = Icons.Filled.Close, contentDescription = stringResource(R.string.close_icon), tint = MaterialTheme.colorScheme.topAppBarContentColor)
    }
}

@Composable
fun DeleteAction(
    onDeleteClicked: (Action) -> Unit
) {
    IconButton(onClick = { onDeleteClicked (Action.DELETE)}) {
        Icon(imageVector = Icons.Filled.Delete, contentDescription = stringResource(R.string.delete_icon), tint = MaterialTheme.colorScheme.topAppBarContentColor)
    }
}

@Composable
fun UpdateAction(
    onUpdateClicked: (Action) -> Unit
) {
    IconButton(onClick = { onUpdateClicked (Action.UPDATE)}) {
        Icon(imageVector = Icons.Filled.Check, contentDescription = stringResource(R.string.update_icon), tint = MaterialTheme.colorScheme.topAppBarContentColor)
    }
}


@Preview
@Composable
private fun NewTaskAppBarPreview() {
    NewTaskAppBar(
        navigateToListScreen = {}
    )
}

@Preview
@Composable
private fun ExistingTaskAppBarPreview() {
    ExistingTaskAppBar(
        selectedTask = ToDoTask(
            id = 0,
            title = "Eve",
            description = "Some Random Text",
            priority = Priority.LOW
        ),
        navigateToListScreen = {}
    )
}