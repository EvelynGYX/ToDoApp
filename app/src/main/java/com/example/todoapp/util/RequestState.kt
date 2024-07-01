package com.example.todoapp.util

sealed class RequestState<out T> {
    object IDLE: RequestState<Nothing>()
    object LOADING : RequestState<Nothing>()
    data class Success<T>(val data: T): RequestState<T>()
    data class Error(val error: Throwable): RequestState<Nothing>()
}