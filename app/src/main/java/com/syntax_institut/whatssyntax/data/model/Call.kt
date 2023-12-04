package com.syntax_institut.whatssyntax.data.model

data class Call(val contact: Contact, val incoming: Boolean, val accepted: Boolean, val time: String)