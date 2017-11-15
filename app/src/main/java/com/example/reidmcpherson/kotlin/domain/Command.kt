package com.example.reidmcpherson.kotlin.domain

public interface Command<T> {
    fun execute(): T
}