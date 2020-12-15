package com.BELLE.formation.tpmovieapi.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import com.BELLE.formation.tpmovieapi.R
import com.BELLE.formation.tpmovieapi.presentation.list.DetailFragment
import com.BELLE.formation.tpmovieapi.presentation.search.SearchFragment

private var container2: FragmentContainerView? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container2 = findViewById(R.id.fragment_container_2)

        supportFragmentManager.commit {
            //add ou replace, replace remplace le fragment si existe déjà.
            replace(R.id.fragment_container, SearchFragment())
        }

    }

    //quand on clique sur un item
    fun displayMovieDetail(id: String) {
        if (container2 != null) {
            //cas tablette
            supportFragmentManager.commit {
                replace(R.id.fragment_container_2, DetailFragment.newInstance(id))
            }
        } else {
            //cas smartphone
            supportFragmentManager.commit {
                replace(R.id.fragment_container, DetailFragment.newInstance(id))
                addToBackStack(null)
            }
        }

    }
}