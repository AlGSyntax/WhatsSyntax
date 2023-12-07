package com.syntax_institut.whatssyntax.data

import com.syntax_institut.whatssyntax.R
import com.syntax_institut.whatssyntax.data.model.Call
import com.syntax_institut.whatssyntax.data.model.Chat
import com.syntax_institut.whatssyntax.data.model.Contact
import com.syntax_institut.whatssyntax.data.model.Message
import com.syntax_institut.whatssyntax.data.model.Profile
import com.syntax_institut.whatssyntax.data.model.Status

class Datasource {

    private var profile = Profile("Max Mustermann", "666-555-4444", R.drawable.pp_01)

    private val contactList = listOf(
        Contact("Anna Smith", "123-456-7890", R.drawable.pp_01, Status("Habe Steinpilze abzugeben.")),
        Contact("John Doe", "321-654-0987", R.drawable.pp_02, null),
        Contact("Emily Johnson", "111-222-3333", R.drawable.pp_03, null),
        Contact("Tom Brown", "555-666-7777", R.drawable.pp_04, null),
        Contact("Sara Williams", "888-999-0000", R.drawable.pp_05, null),
        Contact("Mike Davis", "246-135-7920", R.drawable.pp_06, Status("Schönes Wetter heute!")),
        Contact("Lena Wilson", "654-987-3210", R.drawable.pp_07, null),
        Contact("Daniel Taylor", "987-654-3210", R.drawable.pp_01, null),
        Contact("Chris Miller", "444-555-6666", R.drawable.pp_02, null),
        Contact("Sophia Adams", "333-444-5555", R.drawable.pp_03, Status("Meine Katze ist verschwunden, hat sie jemand gesehen?")),
        Contact("Lucas Nelson", "111-999-8888", R.drawable.pp_04, null),
        Contact("Nina Lewis", "777-888-9999", R.drawable.pp_05, null),
        Contact("Eva Clark", "222-333-4444", R.drawable.pp_06, null),
        Contact("Tim Scott", "555-444-3333", R.drawable.pp_07, Status("Liege krank im Bett, nur Notfälle heute.")),
        Contact("Oliver King", "666-555-4444", R.drawable.pp_01, null),
        Contact("Julia Hill", "777-666-5555", R.drawable.pp_02, null),
        Contact("Max Allen", "888-777-6666", R.drawable.pp_03, null),
        Contact("Laura Reed", "999-888-7777", R.drawable.pp_04, null),
        Contact("John Hall", "000-999-8888", R.drawable.pp_05, null),
        Contact("Lisa Baker", "111-000-9999", R.drawable.pp_06, null)
    )

    private val callList = listOf(
        Call(contactList[0], true, true, "11.10.2023 15:30"),
        Call(contactList[1], false, false, "11.10.2023 14:20"),
        Call(contactList[2], true, false, "10.10.2023 18:45"),
        Call(contactList[3], false, true, "10.10.2023 12:10"),
        Call(contactList[4], true, true, "09.10.2023 21:30"),
        Call(contactList[5], true, false, "09.10.2023 19:20"),
        Call(contactList[6], false, false, "08.10.2023 08:00"),
        Call(contactList[7], true, true, "08.10.2023 06:15"),
        Call(contactList[8], false, true, "07.10.2023 22:40"),
        Call(contactList[9], true, false, "07.10.2023 21:15"),
        Call(contactList[10], true, true, "07.10.2023 14:50"),
        Call(contactList[11], false, true, "06.10.2023 20:30"),
        Call(contactList[12], true, false, "06.10.2023 11:00"),
        Call(contactList[13], true, true, "05.10.2023 16:25"),
        Call(contactList[14], false, false, "05.10.2023 14:10"),
        Call(contactList[15], true, true, "05.10.2023 09:45"),
        Call(contactList[16], false, true, "04.10.2023 23:30"),
        Call(contactList[17], true, false, "04.10.2023 18:15"),
        Call(contactList[18], false, false, "03.10.2023 16:00"),
        Call(contactList[19], true, true, "03.10.2023 10:30")
    )

    private val chatList = listOf(
        Chat(contactList[2], mutableListOf(
            Message("Hallo!", true),
            Message("Hi, wie geht's?", false),
            Message("Mir geht's gut, danke!", true)
        )
        ),
        Chat(contactList[6], mutableListOf(
            Message("Bist du heute Abend frei?", false),
            Message("Ja, was ist los?", true)
        )),
        Chat(contactList[8], mutableListOf(
            Message("Wo bist du?", true),
            Message("Im Büro.", false),
            Message("Ok, ich bin in 5 Minuten da.", true)
        )),
        Chat(contactList[3], mutableListOf(
            Message("Vergiss nicht, Milch zu kaufen.", false),
            Message("Werde ich nicht!", true)
        )),
        Chat(contactList[4], mutableListOf(
            Message("Wie spät ist es?", true),
            Message("Es ist 18 Uhr.", false)
        )),
        Chat(contactList[3], mutableListOf(
            Message("Wann treffen wir uns?", true),
            Message("Um 17 Uhr.", false),
            Message("Passt.", true),
            Message("Super, bis dann!", false)
        )),
        Chat(contactList[5], mutableListOf(
            Message("Was gibt's zum Abendessen?", true),
            Message("Pizza.", false)
        )),
        Chat(contactList[7], mutableListOf(
            Message("Treffen wir uns morgen?", true),
            Message("Ja, klingt gut.", false),
            Message("Um wie viel Uhr?", true)
        )),
        Chat(contactList[8], mutableListOf(
            Message("Hast du die E-Mail bekommen?", false),
            Message("Noch nicht, ich schaue nach.", true)
        )),
        Chat(contactList[1], mutableListOf(
            Message("Brauchst du etwas?", true),
            Message("Nein, danke.", false)
        ))
    )

    fun getCalls(): List<Call> {
        return callList
    }

    fun getChats(): List<Chat> {
        return chatList
    }

    fun getContacts(): List<Contact> {
        return contactList
    }

    fun getProfile(): Profile {
        return profile
    }

    fun setProfile(profile: Profile) {
        this.profile = profile
    }

    fun getMessagesForChat(chatIndex: Int): MutableList<Message> {
        // Überprüft, ob der Index innerhalb der Grenzen der Chat-Liste liegt.
        if (chatIndex in chatList.indices) {
            return chatList[chatIndex].messages
        } else {
            // Gibt eine leere Liste zurück, wenn der Index ungültig ist.
            return mutableListOf()
        }
    }
}

