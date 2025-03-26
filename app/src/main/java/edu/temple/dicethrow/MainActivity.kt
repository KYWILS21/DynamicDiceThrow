package edu.temple.dicethrow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.res.Configuration

class MainActivity : AppCompatActivity(), ButtonFragment.ButtonInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

            if (isLandscape) {
                // In landscape, load both fragments
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container1, ButtonFragment())
                    .replace(R.id.container2, DieFragment())
                    .commit()
            } else {
                // In portrait, load only ButtonFragment
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container1, ButtonFragment())
                    .commit()
            }
        }
    }

    override fun buttonClicked() {
        val isPortrait = resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

        if (isPortrait) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1, DieFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}