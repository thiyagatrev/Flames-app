package com.example.reach.flames.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.reach.flames.R
import com.example.reach.flames.databinding.FragmentResultBinding
import com.example.reach.flames.domain.FlamesViewModel
import com.example.reach.flames.utils.show

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val flamesViewModel: FlamesViewModel by activityViewModels()

    val args: ResultFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate: ")
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        Log.e(TAG, "initViews: ")
        when (args.result) {
            "f" -> {
                binding.mtxtFriends.show()
                binding.mimgView.background =
                    AppCompatResources.getDrawable(requireContext(), R.drawable.frd)
            }
            "l" -> {
                binding.mtxtLove.show()
                binding.mimgView.background =
                    AppCompatResources.getDrawable(requireContext(), R.drawable.lovers)

            }
            "a" -> {
                binding.mtxtAffection.show()
                binding.mimgView.background =
                    AppCompatResources.getDrawable(requireContext(), R.drawable.affection)
            }
            "m" -> {
                binding.mtxtMarriage.show()
                binding.mimgView.background =
                    AppCompatResources.getDrawable(requireContext(), R.drawable.marriage)
            }
            "e" -> {
                binding.mtxtEnemies.show()
                binding.mimgView.background =
                    AppCompatResources.getDrawable(requireContext(), R.drawable.enemies)
            }
            "s" -> {
                binding.mtxtSiblings.show()
                binding.mimgView.background =
                    AppCompatResources.getDrawable(requireContext(), R.drawable.sibling)
            }
            else -> {
                binding.mtxtSiblings.show()
                binding.mimgView.background =
                    AppCompatResources.getDrawable(requireContext(), R.drawable.sibling)
            }
        }

    }

    companion object {
        private const val TAG = "ResultFragment"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ResultFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}


