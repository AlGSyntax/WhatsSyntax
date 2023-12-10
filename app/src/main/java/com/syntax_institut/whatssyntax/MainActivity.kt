package com.syntax_institut.whatssyntax

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.syntax_institut.whatssyntax.data.Datasource
import com.syntax_institut.whatssyntax.databinding.ActivityMainBinding

/**
 * MainActivity ist die Hauptaktivität deiner App.
 *
 * Diese Aktivität initialisiert das Layout und die Navigationselemente.
 */
class MainActivity : AppCompatActivity() {

    // Binding-Instanz für das Layout der MainActivity
    private lateinit var binding: ActivityMainBinding
    val datasource = Datasource()


    /**
     * onCreate wird aufgerufen, wenn die Aktivität erstellt wird.
     *
     * @param savedInstanceState : Wenn die Aktivität neu erstellt wird,
     * nachdem Sie vom System beendet wurde, enthält dieses Bundle die zuletzt bereitgestellten
     * Daten.
     * Andernfalls ist es null.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialisiert das Binding für das Layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Findet das NavHostFragment und holt den NavController daraus
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Verknüpft die BottomNavigationView mit dem NavController
        binding.navView.setupWithNavController(navController)


    }
}
