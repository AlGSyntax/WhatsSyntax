package com.syntax_institut.whatssyntax.data.model

data class Chat(
    val contact: Contact,
    val messages: MutableList<Message>
)