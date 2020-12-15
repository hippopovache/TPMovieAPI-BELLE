package com.BELLE.formation.tpmovieapi.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.BELLE.formation.tpmovieapi.R
import com.BELLE.formation.tpmovieapi.presentation.search.SearchState
import com.BELLE.formation.tpmovieapi.presentation.search.SearchViewModel
import com.BELLE.formation.tpmovieapi.presentation.search.ShowState
import com.BELLE.formation.tpmovieapi.presentation.search.ShowViewModel

class DetailFragment : Fragment() {

    lateinit var titreDetail: TextView
    lateinit var descriptionDetail: TextView
    lateinit var actorsDetail: TextView
    lateinit var metascoreDetail: TextView
    lateinit var directorDetail: TextView
    lateinit var imageDetail: ImageView

    private val viewModel: ShowViewModel by viewModels()


    companion object {
        private const val KEY_ID = "Key_id"
        fun newInstance(id: String): DetailFragment {
            var bundle = Bundle()
            bundle.putString(KEY_ID, id)
            val fragment = DetailFragment()
            fragment.arguments = bundle

            return fragment
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        titreDetail = view.findViewById(R.id.fragment_movie_detail_title)
        descriptionDetail = view.findViewById(R.id.fragment_movie_detail_description)
        actorsDetail = view.findViewById(R.id.fragment_movie_detail_actors)
        metascoreDetail = view.findViewById(R.id.fragment_movie_detail_metascore)
        imageDetail = view.findViewById(R.id.fragment_movie_detail_image)
        directorDetail = view.findViewById(R.id.fragment_movie_detail_director)

        viewModel.state.observe(viewLifecycleOwner, ::updateState)

        arguments?.getString(KEY_ID)?.let{
            viewModel.showMovie(it)
        }
    }

    private fun updateState(state: ShowState){
        when (state) {
            is ShowState.ErrorState -> {
                //progressBar.isVisible = false
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
                //adapter.setData(null)
            }
            is ShowState.LoadingState -> {
                //progressBar.isVisible = true
                //adapter.setData(null)
            }
            is ShowState.SuccessState -> {
                //progressBar.isVisible = false
                //adapter.setData(state.movies)

            }
        }
    }

}