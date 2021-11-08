package com.example.reach.flames.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import com.example.reach.flames.databinding.FragmentUserLandingBinding
import com.example.reach.flames.domain.FlamesFlowState
import com.example.reach.flames.domain.FlamesViewModel
import com.example.reach.flames.utils.safeNavigate
import com.example.reach.flames.utils.setOnClickListener
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserLandingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserLandingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentUserLandingBinding? = null
    private val binding get() = _binding!!
    private val flamesViewModel: FlamesViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private var flamesFlowJob: Job? = null

    override fun onStop() {
        flamesFlowJob?.cancel()
        super.onStop()
        Log.e(TAG, "onStop: ")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: ")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG, "onDestroyView: ")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUserLandingBinding.inflate(inflater, container, false)
        initListeners()
        initClickListeners()
        return binding.root
    }

    private fun initClickListeners() {
        binding.flames.setOnClickListener(debounceInterval = 1000) {
            flamesViewModel.initFlames(
                binding.editText.text.toString(),
                binding.editText2.text.toString()
            )
        }
    }


    private fun initListeners() {

        // Start a coroutine in the lifecycle scope
        lifecycleScope.launch {
            // repeatOnLifecycle launches the block in a new coroutine every time the
            // lifecycle is in the STARTED state (or above) and cancels it when it's STOPPED.
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                // Trigger the flow and start listening for values.
                // Note that this happens when lifecycle is STARTED and stops
                // collecting when the lifecycle is STOPPED
                flamesViewModel.flamesFlowState.asLiveData()
                    .observe(viewLifecycleOwner, Observer { data ->

                        if (viewLifecycleOwner.lifecycle.currentState == Lifecycle.State.RESUMED) {
                            when (data) {
                                is FlamesFlowState.Empty -> {
                                }
                                is FlamesFlowState.Success -> {
                                    Log.e(TAG, "initListeners: ")
                                    clearEditText()
                                    findNavController().safeNavigate(
                                        UserLandingFragmentDirections.actionUserLandingFragmentToResultFragment(
                                            data.result
                                        )
                                    )
                                }
                                is FlamesFlowState.Error -> {
                                    Toast.makeText(
                                        requireContext(),
                                        data.errorMessage,
                                        Toast.LENGTH_SHORT
                                    )
                                        .show()
                                }
                            }
                        }

                    })

            }
        }

    }

    private fun clearEditText() {
        binding.editText.setText("")
        binding.editText2.setText("")
    }

    companion object {
        private const val TAG = "UserLandingFragment"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UserLandingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserLandingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}