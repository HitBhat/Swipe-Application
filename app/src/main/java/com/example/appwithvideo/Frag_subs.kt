package com.example.appwithvideo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.appwithvideo.databinding.AboutFragBinding
import com.example.appwithvideo.databinding.SubCribeBinding

/**
 * A simple [Fragment] subclass.
 */
class Frag_subs : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<SubCribeBinding>(inflater,R.layout.sub_cribe,container,false)
        Toast.makeText(context,"SUBSCRIBED", Toast.LENGTH_LONG).show()
        return binding.root
    }


}
