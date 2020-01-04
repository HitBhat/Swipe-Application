package com.example.appwithvideo


import android.annotation.SuppressLint
import android.database.DatabaseUtils
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.appwithvideo.databinding.Vid1Binding

/**
 * A simple [Fragment] subclass.
 */
class Frag_vid1 : Fragment(),View.OnTouchListener,GestureDetector.OnGestureListener {
    var mDetetor = GestureDetector(context,this)
    var x1 = 0f
    var x2 = 0f
    var y1 = 0f
    var y2 = 0f
    val MIN_DISTANCE = 150


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val string ="android.resource://com.example.appwithvideo/"+R.raw.video1
        val uri = Uri.parse(string)


        val binding =
            DataBindingUtil.inflate<Vid1Binding>(inflater, R.layout.vid_1, container, false).also {
                it.videoView.setOnTouchListener(this)
                it.videoView.setVideoURI(uri)
                it.videoView.start()
            }
        return binding.root

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {

        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                x1 = event.x
                y1 = event.y
            }
            MotionEvent.ACTION_UP -> {
                x2 = event.x
                y2 = event.y
                val deltaX: Float = x2 - x1
                val deltaY = y2-y1
                if(Math.abs(deltaY) > MIN_DISTANCE){
                    if(y2 > y1){
                        Toast.makeText(context,"This is the First Video",Toast.LENGTH_SHORT).show()
                        y2 = 0f
                        y1 = 0f
                    }
                    if(y2 < y1){
                        Toast.makeText(context,"Swipe Up",Toast.LENGTH_SHORT).show()
                        view!!.findNavController().navigate(R.id.action_frag_vid1_to_frag_vid2)
                        y1 = 0f
                        y2 = 0f
                    }
                }
                if (Math.abs(deltaX) > MIN_DISTANCE) { // Left to Right swipe action
                    if (x2 > x1) {
                        Toast.makeText(context, "Left to Right swipe", Toast.LENGTH_SHORT).show()
                     view!!.findNavController().navigate(R.id.action_frag_vid1_to_frag_about)
                        x1 = 0f
                        x2 = 0f
                    }
                    if (x2 < x1) {
                        Toast.makeText(context, "Right to left swipe", Toast.LENGTH_SHORT).show()
                       view!!.findNavController().navigate(R.id.action_frag_vid1_to_frag_subs)
                        x1 = 0f
                        x2 = 0f

                    }

                }
            }

        }
        mDetetor.onTouchEvent(event)
        return true
   }


        override fun onLongPress(e: MotionEvent?) {

        }

        override fun onShowPress(e: MotionEvent?) {

        }

        override fun onSingleTapUp(e: MotionEvent?): Boolean {
           return true
        }

        override fun onDown(e: MotionEvent?): Boolean {
            return true
        }

        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent?,
            velocityX: Float,
            velocityY: Float
        ): Boolean {

            return true
        }


    override fun onScroll(
            e1: MotionEvent?,
            e2: MotionEvent?,
            distanceX: Float,
            distanceY: Float
        ): Boolean {

            return true
        }
    }
