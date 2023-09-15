package com.ch.activityfragmentexample.presentation.fragmentone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ch.activityfragmentexample.R
import com.ch.activityfragmentexample.databinding.FragmentOneBinding
import com.ch.activityfragmentexample.model.Person

class FragmentOne : Fragment() {

    private lateinit var binding: FragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
    }

    private fun setClickListener() {
        binding.btnNavigate.setOnClickListener {
            navigateToFragmentTwo()
        }
        binding.btnSendDataNavigate.setOnClickListener {
            navigateToFragmentTwo(getPerson())
        }
    }

    private fun getPerson(): Person? {
        return Person(
            name = "Tony Stark",
            job = "The Mechanic",
            profileDesc = "Genius, Billionaire, Playboy, Philantropist",
            profilePictUrl = "https://upload.wikimedia.org/wikipedia/commons/8/82/Neymar_-_FC_Barcelona_-_2015.jpg"
        )
    }

    private fun navigateToFragmentTwo(person: Person? = null) {
        //bundle
        /*        findNavController().navigate(R.id.action_fragmentOne_to_fragmentTwo,Bundle().apply {
                    putParcelable(FragmentTwo.ARGS_PERSON,person)
                })*/

        //safeargs
        val action = FragmentOneDirections.actionFragmentOneToFragmentTwo(person)
        findNavController().navigate(action)
    }


}