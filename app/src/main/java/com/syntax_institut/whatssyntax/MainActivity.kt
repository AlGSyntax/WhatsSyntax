package com.syntax_institut.whatssyntax


// Import-Anweisungen für benötigte Klassen und Bibliotheken.
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.syntax_institut.whatssyntax.data.Datasource
import com.syntax_institut.whatssyntax.databinding.ActivityMainBinding

/**
 * MainActivity ist die Hauptaktivität deiner App.
 *
 * Diese Aktivität dient als zentraler Container für die verschiedenen Fragments der App.
 * Sie initialisiert das Layout und die Navigationselemente und verwaltet die Navigation
 * zwischen den verschiedenen Teilen der App.
 */

class MainActivity : AppCompatActivity() {

    // Binding-Instanz für das Layout der MainActivity. Ermöglicht die Interaktion mit den
    // View-Elementen.
    private lateinit var binding: ActivityMainBinding

    // Datenquelle, die von der gesamten App verwendet wird, um Benutzerdaten zu speichern und
    // abzurufen.
    val datasource = Datasource()


    /**
     * onCreate wird aufgerufen, wenn die Aktivität erstellt wird.
     * Diese Methode initialisiert die Benutzeroberfläche und konfiguriert die Navigation.
     *
     * @param savedInstanceState Wenn die Aktivität neu erstellt wird, nachdem sie vom System
     * beendet wurde, enthält dieses Bundle die zuletzt bereitgestellten Daten. Andernfalls ist es
     * null.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialisiert das Binding für das Layout, wodurch eine direkte Referenz auf die
        // UI-Elemente ermöglicht wird.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Findet das NavHostFragment, das als Container für die Fragments innerhalb der
        // MainActivity dient.
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Verknüpft die BottomNavigationView mit dem NavController
        binding.navView.setupWithNavController(navController)

        // Verknüpft die BottomNavigationView mit dem NavController für eine nahtlose Navigation.
    }
}

/**
 *
 *
 * Zusammenfassung des MainActivity-Codes
 * Die MainActivity ist das Herzstück meiner Android-App. Sie dient als zentraler Anlaufpunkt,
 * von dem aus alle anderen Fragmente der App gesteuert und angezeigt werden. In dieser Aktivität
 * wird das Haupt-Layout der App initialisiert, und es werden Mechanismen zur Navigation zwischen
 * den verschiedenen Teilen der App eingerichtet. Die Schlüsselkomponenten umfassen:
 *
 * Data Binding Setup: Hier wird das Binding für das Layout initialisiert, wodurch eine direkte
 *                     Verbindung zu den UI-Elementen hergestellt wird.
 *
 * Navigation Setup: Die MainActivity konfiguriert und steuert die Navigation innerhalb der App
 *                   mithilfe eines NavController, der in einem NavHostFragment enthalten ist.
 *
 * Datasource-Integration: Die MainActivity initialisiert und verwaltet eine zentrale Datenquelle,
 *                         die von verschiedenen Komponenten der App genutzt wird.
 *
 * Analogie zu jeder Komponente:
 *
 * Stellen wir uns vor, die MainActivity ist wie das Zentrum oder die Lobby eines großen Hotels:
 *
 * Data Binding Setup: Dies ist vergleichbar mit dem Rezeptionstresen in einem Hotel. Genau wie der
 *                     Tresen den Mitarbeitern direkten Zugang zu Informationen und Werkzeugen
 *                     bietet, ermöglicht das Data Binding der MainActivity direkten Zugriff auf
 *                     UI-Elemente.
 *
 * Navigation Setup: Die Navigation in der MainActivity entspricht den Wegweisern und Mitarbeitern
 *                   in der Hotellobby, die Gäste zu verschiedenen Bereichen des Hotels leiten –
 *                   sei es zu den Zimmern (verschiedene Fragmente) oder zu anderen Einrichtungen
 *                   wie dem Restaurant oder Konferenzräumen (weitere Funktionen der App).
 *
 * Datasource-Integration: Die zentrale Datenquelle in der MainActivity ist wie die zentrale
 *                         Datenbank eines Hotels, in der Informationen über Gäste, Zimmerbuchungen
 *                         und Dienstleistungen gespeichert sind. Diese Datenbank ist von jedem
 *                         Punkt im Hotel aus zugänglich und bietet den Mitarbeitern die
 *                         Informationen, die sie benötigen, um ihren Service zu erbringen.
 *
 * Zusammengefasste Erklärung des Codes:
 *
 * onCreate: Die Erstellung der MainActivity ist wie die Eröffnung der Hotellobby.
 *           Hier wird alles eingerichtet und bereitgestellt, damit das Hotel (die App) reibungslos
 *           funktionieren kann.
 *
 * Layout-Setup: Das Aufblasen des Layouts und die Einrichtung des Data Binding ist wie das
 *               Einrichten der Rezeption und anderer Informationspunkte in der Lobby, die den
 *               Gästen Orientierung und Service bieten.
 *
 * Navigationskonfiguration: Das Einrichten des NavController und des NavHostFragment ist wie das
 *                           Aufstellen von Schildern und das Bereitstellen von Personal, das den
 *                           Gästen hilft, ihren Weg durch das Hotel zu finden.
 *
 *
 */