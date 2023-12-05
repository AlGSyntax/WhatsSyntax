<!-- Das Wurzelelement des Layouts ist ein ConstraintLayout, welches flexible Platzierung von Kind-Views ermöglicht. -->
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"  <!-- Die Breite des Layouts füllt den verfügbaren Raum aus. -->
android:layout_height="match_parent" <!-- Die Höhe des Layouts füllt den verfügbaren Raum aus. -->
android:background="@drawable/general_background" <!-- Hintergrundbild für den gesamten Screen. -->
tools:context=".MainActivity">

    <!-- NavHostFragment, das als Container für die Fragmente dient, die durch die Navigation-Komponente ausgetauscht werden. -->
    <androidx.fragment.app.FragmentContainerView
        android:id="@+id/nav_host_fragment"
        android:name="androidx.navigation.fragment.NavHostFragment"
        android:layout_width="0dp" <!-- Die Breite ist auf 0dp gesetzt, was im ConstraintLayout 'match_constraints' bedeutet. -->
        android:layout_height="0dp" <!-- Die Höhe ist ebenfalls auf 'match_constraints' gesetzt. -->
        app:defaultNavHost="true" <!-- Definiert dieses NavHostFragment als den primären Host für die Navigation. -->
        app:navGraph="@navigation/nav_graph" <!-- Verbindet das NavHostFragment mit einem Navigation Graphen. -->
        app:layout_constraintTop_toTopOf="parent" <!-- Positioniert das Top des Fragments am Top des Elternelements. -->
        app:layout_constraintBottom_toTopOf="@id/nav_view" <!-- Positioniert das Bottom des Fragments oben an der BottomNavigationView. -->
        app:layout_constraintLeft_toLeftOf="parent" <!-- Positioniert das Left des Fragments am Left des Elternelements. -->
        app:layout_constraintRight_toRightOf="parent" <!-- Positioniert das Right des Fragments am Right des Elternelements. -->
    />

    <!-- BottomNavigationView bietet Navigationselemente am unteren Bildschirmrand. -->
    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/nav_view"
        android:layout_width="0dp" <!-- Die Breite ist auf 'match_constraints' gesetzt. -->
        android:layout_height="wrap_content" <!-- Die Höhe passt sich dem Inhalt an. -->
        android:background="?android:attr/windowBackground" <!-- Verwendet den Standardhintergrund des Fensters. -->
        app:menu="@menu/bottom_nav_menu" <!-- Definiert das Menü, das in der BottomNavigationView angezeigt wird. -->
        app:layout_constraintLeft_toLeftOf="parent" <!-- Positioniert das Left der BottomNavigationView am Left des Elternelements. -->
        app:layout_constraintRight_toRightOf="parent" <!-- Positioniert das Right der BottomNavigationView am Right des Elternelements. -->
        app:layout_constraintBottom_toBottomOf="parent" <!-- Positioniert das Bottom der BottomNavigationView am Bottom des Elternelements. -->
    />

</androidx.constraintlayout.widget.ConstraintLayout>
Hintergrundbild general_background
Das Hintergrundbild general_background wurde mit Bedacht ausgewählt, um eine Atmosphäre zu schaffen,
die Technologie und Datenfluss assoziiert,
was für eine App eines Kurznachrichtendienstes sehr passend ist. 
Die Visualisierung des Datenflusses in Form von "Code-Regen" aus der Matrix-Filmserie wird oft mit
Kommunikation und dem Austausch von Informationen in Verbindung gebracht. 
Es suggeriert einen ständigen Fluss und die permanente Verfügbarkeit von Kommunikation, 
beides Schlüsselaspekte eines Kurznachrichtendienstes.

RecyclerView im NavHostFragment
Der RecyclerView ist nicht direkt im activity_main.xml Layout definiert,
sondern wird stattdessen in den einzelnen Fragmenten definiert,
die durch das NavHostFragment verwaltet werden. 
Das NavHostFragment fungiert als Container für die Fragmente und ermöglicht die Navigation zwischen
verschiedenen Teilen der App. Jedes Fragment kann seinen eigenen RecyclerView haben,
um Listen von Elementen wie Chats, Kontakten oder Statusmeldungen anzuzeigen.
Durch diese Trennung wird die Wiederverwendbarkeit von Layouts und die Modularität der App verbessert. 
Jedes Fragment kann für spezifische Aufgaben und Darstellungen optimiert werden,
während das NavHostFragment die Gesamtnavigation und das Routing zwischen ihnen übernimmt.




<?xml version="1.0" encoding="utf-8"?>
<!-- Das Haupt-LinearLayout dient als Container für das gesamte Chat-Element. Es nutzt eine horizontale Orientierung, um das Profilbild und den Text nebeneinander anzuordnen. -->
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent"  <!-- Die Breite des Chat-Elements füllt den verfügbaren horizontalen Raum aus. -->
android:layout_height="wrap_content" <!-- Die Höhe passt sich dem Inhalt an, sodass kein unnötiger Platz verbraucht wird. -->
android:orientation="horizontal"     <!-- Horizontale Anordnung der Unterelemente. -->
android:padding="16dp">              <!-- Innerer Abstand von allen Seiten, um das Element vom Rand des Bildschirms zu trennen. -->

    <!-- ImageView für das Profilbild des Kontakts. -->
    <ImageView
        android:id="@+id/imageView_profile"
        android:layout_width="40dp"         <!-- Feste Breite für das Profilbild. -->
        android:layout_height="40dp"        <!-- Feste Höhe für das Profilbild. -->
        android:layout_marginEnd="16dp"     <!-- Rechter Abstand zum nächsten Element, um eine visuelle Trennung zu gewährleisten. -->
        android:src="@drawable/pp_01" />    <!-- Das Standardprofilbild. Im realen Einsatz würde hier ein dynamisches Bild geladen. -->

    <!-- Ein zweites LinearLayout, das für die vertikale Anordnung des Kontaktnamens und der letzten Nachricht zuständig ist. -->
    <LinearLayout
        android:layout_width="0dp"          <!-- Die Breite wird durch das Gewicht (layout_weight) bestimmt, sodass es den verbleibenden Raum füllt. -->
        android:layout_height="wrap_content" <!-- Die Höhe passt sich dem Inhalt an. -->
        android:layout_weight="1"            <!-- Gibt an, dass dieses LinearLayout den gesamten verbleibenden Raum einnehmen soll. -->
        android:orientation="vertical">      <!-- Vertikale Anordnung der Unterelemente. -->

        <!-- TextView für den Namen des Kontakts. -->
        <TextView
            android:id="@+id/textView_contact_name"
            android:layout_width="wrap_content"  <!-- Die Breite passt sich dem Textinhalt an. -->
            android:layout_height="wrap_content"  <!-- Die Höhe passt sich dem Textinhalt an. -->
            android:text="Kontaktname"            <!-- Beispielinhalte, die im realen Einsatz durch Daten ersetzt werden. -->

        <!-- TextView für die letzte Nachricht des Chats. -->
        <TextView
            android:id="@+id/textView_last_message"
            android:layout_width="wrap_content"  <!-- Die Breite passt sich dem Textinhalt an. -->
            android:layout_height="wrap_content"  <!-- Die Höhe passt sich dem Textinhalt an. -->
            android:text="Letzte Nachricht"       <!-- Beispielinhalte, die im realen Einsatz durch Daten ersetzt werden. -->
    </LinearLayout>

Erklärung der Verwendung von zwei LinearLayouts:
Die Verwendung von zwei verschachtelten LinearLayouts ermöglicht es, komplexe Layouts einfach zu strukturieren. Im bereitgestellten Layout:

Das äußere LinearLayout hat eine horizontale Orientierung und ordnet das Profilbild und den Textcontainer nebeneinander an.
Das innere LinearLayout hat eine vertikale Orientierung und stapelt den Namen des Kontakts über die letzte Nachricht innerhalb des durch das äußere LinearLayout zugewiesenen Raums.
Diese Struktur bietet eine klare Trennung zwischen den Bild- und Textelementen des Layouts, wobei beide leicht anpassbar sind, ohne die anderen Teile des Layouts zu beeinflussen. Darüber hinaus ermöglicht sie es, das Layout dynamisch an die Inhalte anzupassen, wodurch die Benutzeroberfläche flexibel und reaktionsfähig bleibt.





<?xml version="1.0" encoding="utf-8"?>
<!-- Das Root-Element ist ein LinearLayout, das hier als einziger Container dient und eine vertikale Orientierung hat. Das bedeutet, dass alle darin enthaltenen Elemente vertikal angeordnet werden. In diesem Fall gibt es nur ein Element: die RecyclerView. -->
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent"  <!-- Die Breite des LinearLayouts entspricht der Breite des Elternelements bzw. des Gerätebildschirms. -->
android:layout_height="match_parent" <!-- Die Höhe des LinearLayouts entspricht der Höhe des Elternelements bzw. des Gerätebildschirms. -->
android:orientation="vertical">      <!-- Die Ausrichtung der Kinder-Views ist vertikal. -->

    <!-- Die RecyclerView ist zuständig für die Anzeige einer Liste oder eines Grids von Elementen. In diesem Fall wird sie verwendet, um die Chat-Nachrichten anzuzeigen. -->
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recycler_view_chats"  <!-- Die ID, über die auf die RecyclerView in der Kotlin/Java-Code zugegriffen wird. -->
        android:layout_width="match_parent"    <!-- Die Breite der RecyclerView entspricht der Breite des Elternelements bzw. des Gerätebildschirms. -->
        android:layout_height="match_parent"/> <!-- Die Höhe der RecyclerView entspricht der Höhe des Elternelements bzw. des Gerätebildschirms. -->
        <!-- Es wurden keine Margins oder Paddings gesetzt, was bedeutet, dass die RecyclerView direkt an den Rändern des Elternelements anliegt. -->
        <!-- Die RecyclerView benötigt einen Adapter und einen LayoutManager, die in der dazugehörigen Fragment- oder Activity-Klasse in Kotlin/Java gesetzt werden müssen. -->

Erklärung des Layouts:
Das LinearLayout dient als einfacher Container, der in diesem Fall nur ein Kind-Element enthält, die RecyclerView.
Die RecyclerView nimmt den gesamten Bildschirm ein, da sie sowohl in der Breite als auch in der Höhe auf match_parent gesetzt ist. Dies ist üblich für ein Hauptlisten-Layout, das den gesamten zur Verfügung stehenden Platz nutzen soll.
Es ist wichtig zu beachten, dass die RecyclerView selbst keine Darstellung der Inhalte definiert. Stattdessen wird sie durch ihren Adapter mit Daten versorgt, und der LayoutManager bestimmt, ob die Elemente in einer Liste, einem Grid oder einer anderen Form angezeigt werden.
Dieses Layout ist typisch für einen Bildschirm, der eine Liste von Elementen darstellt. Es ist minimalistisch, was die Flexibilität und Anpassungsfähigkeit in der Handhabung der dargestellten Daten durch den Adapter maximiert.


<?xml version="1.0" encoding="utf-8"?>
<!-- Der Navigationsgraph definiert alle Navigationspfade innerhalb der App. -->
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:id="@+id/nav_graph" <!-- Die eindeutige ID des Navigationsgraphen. -->
app:startDestination="@id/chatsFragment3"> <!-- Startdestination ist das ChatsFragment. -->

    <!-- Fragment für die Chat-Ansicht -->
    <fragment
        android:id="@+id/chatsFragment3"
        android:name="com.syntax_institut.whatssyntax.ChatsFragment" <!-- Voll qualifizierter Klassenname des Fragments. -->
        android:label="fragment_chats" <!-- Beschriftung, die in der App-Leiste angezeigt wird. -->
        tools:layout="@layout/fragment_chats" > <!-- Verweist auf das Layout, das im Design-Editor angezeigt wird. -->

        <!-- Aktion, um von ChatsFragment zu SettingsFragment zu navigieren. -->
        <action
            android:id="@+id/action_chatsFragment3_to_settingsFragment"
            app:destination="@id/settingsFragment" />

        <!-- Aktion, um von ChatsFragment zu CallFragment zu navigieren. -->
        <action
            android:id="@+id/action_chatsFragment3_to_callFragment"
            app:destination="@id/callFragment" />

        <!-- Aktion, um von ChatsFragment zu StatusFragment zu navigieren. -->
        <action
            android:id="@+id/action_chatsFragment3_to_statusFragment"
            app:destination="@id/statusFragment" />
    </fragment>

    <!-- Fragment für die Einstellungen -->
    <fragment
        android:id="@+id/settingsFragment"
        android:name="com.syntax_institut.whatssyntax.SettingsFragment"
        android:label="fragment_settings"
        tools:layout="@layout/fragment_settings" />

    <!-- Fragment für Anrufhistorie -->
    <fragment
        android:id="@+id/callFragment"
        android:name="com.syntax_institut.whatssyntax.CallFragment"
        android:label="fragment_call"
        tools:layout="@layout/fragment_call" />

    <!-- Fragment für den Status -->
    <fragment
        android:id="@+id/statusFragment"
        android:name="com.syntax_institut.whatssyntax.StatusFragment"
        android:label="fragment_status"
        tools:layout="@layout/fragment_status" />

    Jeder <fragment>-Eintrag definiert eine Navigationsdestination. Die action-Einträge definieren, wie man von einem Fragment zum nächsten navigiert. Die app:startDestination gibt an, welches Fragment beim Start der App zuerst angezeigt wird.

In der visuellen Darstellung des Navigationsgraphen, wie in Android Studio gezeigt, werden diese Beziehungen als verbundene Knoten dargestellt. Die Pfeile repräsentieren die Aktionen und zeigen die Richtung der Navigation zwischen den Fragmenten.

Die tools:layout-Attribute sind besonders nützlich während der Entwicklung, da sie es dir ermöglichen, eine Vorschau des Layouts der Fragmente direkt im Navigationseditor anzusehen, ohne die App ausführen zu müssen.

Der nav_graph.xml erleichtert die Verwaltung der Navigationslogik in deiner App, indem er eine zentrale Stelle bietet, an der du deine Navigationsstruktur definieren und verwalten kannst.

