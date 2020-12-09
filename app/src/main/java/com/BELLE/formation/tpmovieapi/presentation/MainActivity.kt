package com.BELLE.formation.tpmovieapi.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import com.BELLE.formation.tpmovieapi.R
import com.BELLE.formation.tpmovieapi.presentation.list.DetailFragment
import com.BELLE.formation.tpmovieapi.presentation.search.SearchFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            //add ou replace, replace remplace le fragment si existe déjà.
            replace(R.id.fragment_container, SearchFragment())
        }

        findViewById<FragmentContainerView>(R.id.fragment_container_2)?.let {
            supportFragmentManager.commit{
                add(R.id.fragment_container_2, DetailFragment())
            }
        }
    }
}