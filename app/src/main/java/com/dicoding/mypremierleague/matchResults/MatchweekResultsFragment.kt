package com.dicoding.mypremierleague.matchResults

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.mypremierleague.R
import com.dicoding.mypremierleague.core.data.Resource
import com.dicoding.mypremierleague.core.ui.MatchResultAdapter
import com.dicoding.mypremierleague.databinding.FragmentMatchweekResultsBinding
import com.dicoding.mypremierleague.detailMatch.DetailMatchActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchweekResultsFragment : Fragment() {

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
        @JvmStatic
        fun newInstance(index: Int) =
            MatchweekResultsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, index)
                }
            }
    }

    private val matchResultsViewModel: MatchResultsViewModel by viewModels()

    private var _binding: FragmentMatchweekResultsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMatchweekResultsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)
            binding.sectionLabel.text = getString(R.string.match_week, index)

            val matchResultsAdapter = MatchResultAdapter()
            matchResultsAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailMatchActivity::class.java)
                intent.putExtra(DetailMatchActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            matchResultsViewModel.matchResults(index.toString(), "2021-2022").observe(viewLifecycleOwner, { matchResults ->
                if (matchResults != null) {
                    when (matchResults) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            matchResultsAdapter.setData(matchResults.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text = matchResults.message ?: getString((R.string.something_wrong))
                        }
                    }
                }
            })

            with(binding.rvMatchResults) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = matchResultsAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}