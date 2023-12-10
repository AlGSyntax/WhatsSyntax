# WhatsSyntax
## ProjektWoche : Entwicklung einer rudimentären Messager-App
<details>
<summary>Ziel des Projekts</summary>
Das Ziel war es, eine funktionierende Messaging-App zu erstellen, die die grundlegenden Funktionen von WhatsApp nachbildet. Hierbei standen das Verständnis für die Architektur einer solchen App und die Interaktion mit einer Benutzerschnittstelle im Vordergrund.
</details>

## Fragmente/Screens
### ChatsFragment Klasse und Layout
![ChatsFragment Screenshot](https://github.com/AlGSyntax/WhatsSyntax/blob/81c1993e9f56d2b71402f9ddb5895c2ef187fee3/Screenshot_20231210_111917.png)
Das "ChatsFragment" repreäsentiert einen Bildschirm in unserer Messenger-App, auf dem die Benutzer ihre verschiedenen Chat-Konversationen einsehen können.
Es ist ein zentraler Bestandteil des Nutererlebnisses und demonstriert die Fähigkeit,mit dynamischen Inhalten zu arbeiten.

<details>
  <summary>onCreateView</summary>
  In der Methode "onCreateView" wird das Layout für das Fragment definiert. Hier wird das XML-Layout "fragment_chats" geladen und intialisiert , welches den
  Rahmen für unsere Chat-Liste bildet. Die "RecyclerView" wird hier mit der ID "recycler_views_chats" verbunden, die es uns ermöglicht, die Chat-Elemente 
  anzuzeigen und zu verwalten.
</details>

<details>
  <summary>onViewcreated</summary>
  Nach dem Erstellen der Ansicht wird in "onViewCreated" die Logik implementiert,die benötigt wird, um die Chat-Daten aus der "DataSource" zu holen und diese Daten dann an den
  "ItemAdapter" weiterzugeben. Dieser Adapter kümmert sich um die Darstellung der einzelnen Chat-Elemente in der "RecyclerView". Zudem wird hier die Logik für die Interaktion
  mit den Listenelementen definiert, wie das Weiterleiten des Benutzers an das "ChatsDetailFragment", wenn ein Chat ausgewählt wird.
</details>

#### Layout: fragment_chats.xml

Das Layout "fragment_chats.xml" verwendet ein vertikal ausgerichtetes "LinearLayout", um die "RecyclerView" zu beinhalten. Die "RecyclerView" nimmt den gesamten 
verfügbaren Bildschirmplatz ein und ist das Schlüsselelement für die Darstellung der Chat-Liste.

#### Layout: chat_item.xml

Das "chat_item.xml"-Layout nutzt zwei "LinearLayouts": ein äußeres mit horizontaler Ausrichtung für das Profilbild
und den Textcontainer und ein inneres mit vertikaler Ausrichtung für den Namen des Kontakts und die letzte Nachricht. Diese Struktur ermöglicht eine klare Trennung 
und flexible Anordnung der verschiedenen Elemente des Chat-Items.


### ChatsDetailFragment Klasse  und Layouts
![ChatsDetailFragment Screenshot](https://github.com/AlGSyntax/WhatsSyntax/blob/1781c86700e02d09b37dce4039bff458c849b009/Screenshot_20231210_121737.png)

Das "ChatsDetailFragment" zeigt die Detailansicht eines ausgewählten Chats an. Hier können Benutzer die gesamte Konversation sehen und neue Nachrichten senden.

#### Funktionsweise des ChatsDetailFragment

Im "ChatsDetailFragment" wird das Benutzerinterface für die Darstellung von Nachrichten in einem Chat und die Möglichkeit zum Senden neuer Nachrichten bereitgestellt. 

<details>
<summary>Layout und Initialisierung</summary>
Das Layout wird in "fragment_chats_detail.xml" definiert und beinhaltet eine "RecyclerView" für die Nachrichten und ein Eingabefeld mit einem Senden-Button. 
Beim Laden des Fragments ("onCreateView") wird das Layout initialisiert und die "RecyclerView" für die Nachrichtenanzeige eingerichtet. Das Fragment verwendet einen
"MessageAdapter", um die Nachrichten zu verwalten und darzustellen.
</details>

<details>
<summary>Nachrichten senden und anzeigen</summary>
Benutzer können Nachrichten über das Eingabefeld eingeben und mit dem Senden-Button abschicken. Beim Klicken des Buttons wird die Nachricht verarbeitet,
dem "MessageAdapter" hinzugefügt und die Ansicht aktualisiert, um die neue Nachricht anzuzeigen.
</details>

### ItemAdapter für ChatsFragment

Der "ItemAdapter" im "ChatsFragment" spielt eine entscheidende Rolle, indem er die Datenverwaltung und die Darstellung der Chat-Liste in der "RecyclerView" übernimmt.

#### Funktionsweise des ItemAdapter

Der "ItemAdapter" ist speziell für das Handling und die Anzeige von Chat-Informationen in einer Listenansicht konzipiert. Er interagiert direkt mit der "RecyclerView"
im "ChatsFragment".

<details>
<summary>Datenverwaltung und Darstellung</summary>
Der Adapter erhält eine Liste von "Chat"-Objekten, die alle notwendigen Informationen über die einzelnen Chats enthalten, wie zum Beispiel die Namen der Kontakte und die
letzten Nachrichten. Jedes Chat-Element in der Liste wird durch den Adapter in ein individuelles Layout umgewandelt und in der "RecyclerView" angezeigt.
</details>

<details>
<summary>Layout und Bindung</summary>
Für jedes Chat-Element verwendet der Adapter ein vordefiniertes Layout (z.B. "chat_item.xml"), das die Anzeige des Profilbilds des Kontakts, des Namens
und der letzten Nachricht definiert. In der `bind`-Methode des Adapters werden diese Informationen an die entsprechenden UI-Komponenten im Layout gebunden.
</details>

<details>
<summary>Klick-Interaktionen</summary>
Der Adapter behandelt auch Klick-Interaktionen auf einzelne Chat-Elemente. Beim Tippen auf ein Chat-Element in der Liste wird eine spezifische Aktion ausgelöst, wie zum Beispiel das Navigieren zum `ChatsDetailFragment`, um die Konversation anzuzeigen.
</details>

#### Verwendung im ChatsFragment

Im "ChatsFragment" wird der "ItemAdapter" instanziiert und mit der "RecyclerView" verbunden. Der Adapter wird mit der Chat-Liste initialisiert, die aus der Datenquelle
(z.B. "Datasource") geholt wird. Dies ermöglicht es dem "ChatsFragment", eine dynamische und interaktive Liste von Chats anzuzeigen.



#### MessageAdapter

Der "MessageAdapter" ist für das Handling und die Darstellung der einzelnen Chat-Nachrichten in der "RecyclerView" zuständig. 

<details>
<summary>Adapter Funktionsweise</summary>
Der Adapter unterscheidet zwischen eingehenden und ausgehenden Nachrichten und verwendet unterschiedliche Layouts (`item_message_incoming.xml` und `item_message_outgoing.xml`)
für die Darstellung. Dies ermöglicht eine klare visuelle Trennung zwischen gesendeten und empfangenen Nachrichten.
</details>

#### XML-Layouts

##### fragment_chats_detail.xml

Das Layout für das "ChatsDetailFragment" umfasst eine "RecyclerView" und ein Eingabefeld mit einem Senden-Button. Die "RecyclerView" nutzt die volle Bildschirmhöhe,
und das Eingabefeld befindet sich am unteren Rand des Bildschirms.

##### item_message_incoming.xml und item_message_outgoing.xml

Diese Layouts definieren das Aussehen der einzelnen Nachrichtenelemente in der Chat-Ansicht. "item_message_incoming.xml" wird für eingehende Nachrichten verwendet, 
während "item_message_outgoing.xml" für Nachrichten genutzt wird, die vom Benutzer gesendet werden.




### StatusFragment Klasse und Layouts
![StatusFragment Screenshot](https://github.com/AlGSyntax/WhatsSyntax/blob/717c535b6aae147ba56d9a641730169ca0583fd7/Screenshot_20231210_122829.png)

Das "StatusFragment" zeigt eine Liste von Kontakten mit ihren Statusinformationen an. Benutzer können sehen, welche Kontakte einen Status gesetzt haben und darauf navigieren,
um den Status im Detail anzuzeigen.

#### Funktionsweise des StatusFragment

Das "StatusFragment" verwendet ein RecyclerView, um eine Liste von Kontakten anzuzeigen. Es nutzt den "ItemAdapter", um die Daten zu verwalten und darzustellen.

<details>
<summary>Layout und Initialisierung</summary>
Das Layout wird in "fragment_status.xml" definiert und umfasst eine "RecyclerView", die für die Anzeige der Kontaktliste zuständig ist. Beim Laden des Fragments (`onCreateView`) 
wird das Layout initialisiert und die `RecyclerView` für die Statusanzeige eingerichtet.
</details>

<details>
<summary>Statusanzeige und Navigation</summary>
Das Fragment sortiert die Kontakte nach ihrem Status und zeigt nur diejenigen an, die einen Status haben. Bei Auswahl eines Kontakts mit Status navigiert das Fragment
zum "StatusDetailFragment", um den Status im Detail anzuzeigen.
</details>

#### ItemAdapter

Der "ItemAdapter" ist verantwortlich für das Handling und die Darstellung der einzelnen Kontakt-Elemente in der "RecyclerView" des "StatusFragment".

<details>
<summary>Adapter Funktionsweise</summary>
Der Adapter zeigt die Kontaktnamen und Bilder an. Kontakte ohne Status werden in der Liste ausgegraut dargestellt. Der Adapter nutzt einen Klick-Listener,
um bei Auswahl eines Kontakts die entsprechende Aktion auszulösen.
</details>

#### XML-Layouts

##### fragment_status.xml

Das Layout für das "StatusFragment" besteht aus einer "RecyclerView", die den verfügbaren Platz des Bildschirms einnimmt und für die Anzeige der Kontaktliste mit 
Statusinformationen verwendet wird.

##### status_item.xml

Das Layout "status_item.xml" definiert das Aussehen jedes Kontakts in der Liste. Es enthält ein Bild des Kontakts und den Namen.
Optional können hier weitere Informationen wie Zeitstempel oder Icons hinzugefügt werden.


### StatusDetailFragment
![StatusDetailFragment Screenshot](https://github.com/AlGSyntax/WhatsSyntax/blob/bc0f2f06ffb22e41b50ce41986094f0c0e59fdbb/Screenshot_20231210_124919.png)
Das "StatusDetailFragment" zeigt detaillierte Informationen zu einem ausgewählten Status an. Es ist so gestaltet, dass es eine einzelne Statusmeldung in einem fokussierten
Ansichtsbereich präsentiert.

#### Funktionsweise des StatusDetailFragment

Das "StatusDetailFragment" ist für die detaillierte Darstellung eines Status konzipiert. Es empfängt die ausgewählte Statusmeldung als Argument und zeigt diese in einem TextView
an.

<details>
<summary>Layout und Darstellung</summary>
Das Layout wird in "fragment_status_detail.xml" definiert und umfasst einen zentral platzierten TextView, der für die Anzeige der Statusmeldung verwendet wird. Beim Laden des
Fragments (`onCreateView`) wird das Layout erstellt und der übergebene Status wird in das TextView eingetragen.
</details>

#### Layout: fragment_status_detail.xml

Das Layout "fragment_status_detail.xml" ist einfach gehalten, mit einem TextView im Zentrum der Ansicht. Dieser TextView ist so konfiguriert, dass er die übergebene
Statusmeldung in einem großen, gut lesbaren Textformat darstellt. Das Layout nutzt Constraints, um den TextView in der Mitte des Bildschirms zu zentrieren.




### CallFragment Klasse und Layouts
![CallFragment Screenshot](https://github.com/AlGSyntax/WhatsSyntax/blob/37df1006c8dd98c7f00a2f677146244a18d463d0/Screenshot_20231210_124135.png)

Das "CallFragment" bietet eine Übersicht über alle getätigten und empfangenen Anrufe. Es verwendet eine RecyclerView, um die Anrufliste darzustellen und ermöglicht
interaktive Funktionen durch den Einsatz eines speziell entwickelten "CallsAdapter".

#### Funktionsweise des CallFragment

Das Fragment ist so konzipiert, dass es eine Liste von Anrufen anzeigt, die aus einer Datenquelle, wie "Datasource", geladen werden. Jeder Anruf wird mit relevanten Informationen,
wie dem Namen des Kontakts und dem Anrufzeitpunkt, angezeigt.

<details>
<summary>Layout und Initialisierung</summary>
Das Layout "fragment_call.xml" definiert die Struktur des Fragments, einschließlich einer RecyclerView, die den Hauptteil der Benutzeroberfläche ausmacht.
Beim Erstellen der Ansicht ("onCreateView") wird der RecyclerView initialisiert und mit einem LinearLayoutManager versehen, um die Anrufliste linear anzuzeigen.
</details>

<details>
<summary>Anrufliste und Navigation</summary>
Der "CallsAdapter" wird mit der Liste der Anrufe initialisiert und an den RecyclerView gebunden. Der Adapter ermöglicht es, auf einzelne Anrufe zu tippen und führt dann Aktionen
wie das Öffnen des Dialers mit der Telefonnummer des Kontakts aus.
</details>

#### CallsAdapter

Der "CallsAdapter" ist speziell für die Darstellung von Anrufen in der "RecyclerView" des "CallFragment" entwickelt.

<details>
<summary>Adapter Funktionsweise</summary>
Der Adapter verarbeitet die Anrufliste und stellt jeden Anruf separat dar. Dabei unterscheidet er zwischen eingehenden und ausgehenden Anrufen und setzt entsprechende Icons und
Texte. Der Adapter ermöglicht auch das Auslösen von Aktionen beim Klicken auf einen Anruf, wie zum Beispiel das Öffnen des Dialers.
</details>

#### XML-Layouts

##### fragment_call.xml

Das Layout für das "CallFragment" beinhaltet lediglich eine "RecyclerView", die den gesamten verfügbaren Platz für die Anzeige der Anrufliste nutzt.

##### call_item.xml

Das "call_item.xml"-Layout definiert das Design jedes Anrufelements in der Liste. Es beinhaltet Elemente wie das Profilbild des Kontakts, den Namen, Informationen zum Anruf 
und das Status-Icon, das den Typ des Anrufs anzeigt.


### SettingsFragment
![SettingsFragment Screenshot](https://github.com/AlGSyntax/WhatsSyntax/blob/b9f66c6283ba91279384b86cf66cd285f7f44ef4/Screenshot_20231210_125502.png)

Das "SettingsFragment" bietet eine Benutzeroberfläche für die Benutzereinstellungen, wo Benutzer ihre Profilinformationen wie Name und Telefonnummer bearbeiten können.

#### Funktionsweise des SettingsFragment

Das "SettingsFragment" ist so konzipiert, dass es dem Benutzer eine einfache Möglichkeit bietet, seine Profildaten zu bearbeiten und zu speichern.

<details>
<summary>Layout und Initialisierung</summary>
Das Layout wird in "fragment_settings.xml" definiert und umfasst ein ImageView für das Profilbild sowie zwei EditText-Felder für den Namen und die Telefonnummer.
Beim Laden des Fragments (`onCreateView`) werden diese UI-Elemente initialisiert.
</details>

<details>
<summary>Profil laden und speichern</summary>
Beim Öffnen des Fragments wird das aktuelle Profil aus der Datenquelle geladen und in die EditText-Felder eingetragen. Der Benutzer kann diese Informationen bearbeiten
und die Änderungen durch Drücken des 'Speichern'-Buttons speichern. Derzeit bleibt das Profilbild unverändert und wird fest aus den Ressourcen geladen.
</details>

#### Layout: fragment_settings.xml

Das Layout "fragment_settings.xml" bietet eine strukturierte Anordnung für die Profilbearbeitung. Der obere Bereich des Layouts zeigt das Profilbild, 
gefolgt von den EditText-Feldern für den Namen und die Telefonnummer. Am Ende des Layouts befindet sich der Speichern-Button.















