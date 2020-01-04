package com.example.appwithvideo


import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.appwithvideo.databinding.Vid2Binding
import com.example.appwithvideo.databinding.Vid4Binding

/**
 * A simple [Fragment] subclass.
 */
class Frag_vid4 : Fragment(),View.OnTouchListener,GestureDetector.OnGestureListener{
    var mDetetor = GestureDetector(context,this)
    var x1 = 0f
    var x2 = 0f
    var y1 = 0f
    var y2 = 0f
    val MIN_DISTANCE = 150

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val string ="android.resource://com.example.appwithvideo/"+R.raw.video4
        val uri = Uri.parse(string)
        val binding = DataBindingUtil.inflate<Vid4Binding>(inflater,R.layout.vid_4,container,false)
        binding.videoView4.setOnTouchListener(this)
        binding.videoView4.setVideoURI(uri)
        binding.videoView4.start()
        return binding.root
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {when (event!!.action) {
        MotionEvent.ACTION_DOWN -> {
            x1 = event.x
            y1 = event.y
        }
        MotionEvent.ACTION_UP -> {
            x2 = event.x
            y2 = event.y
            val deltaX: Float = x2 - x1
            val deltaY = y2 - y1
            if (Math.abs(deltaY) > MIN_DISTANCE) {
                if (y2 > y1) {
                    Toast.makeText(context, "Swipe Down", Toast.LENGTH_SHORT).show()
                    view!!.findNavController().navigate(R.id.action_frag_vid4_to_frag_vid32)
                    y1 = 0f
                    y2 = 0f
                }
                if (y2 < y1) {
                    Toast.makeText(context, " This is the Last Video", Toast.LENGTH_SHORT).show()
                    y1 = 0f
                    y2 = 0f

                }
            }
            if (Math.abs(deltaX) > MIN_DISTANCE) { // Left to Right swipe action
                if (x2 > x1) {
                    Toast.makeText(context, "Left to Right swipe", Toast.LENGTH_SHORT)
                        .show()
                    view!!.findNavController().navigate(R.id.action_frag_vid4_to_frag_about2)
                    x1 = 0f
                    x2 = 0f

                }
                if (x2 < x1) {
                    Toast.makeText(context, "Right to Left swipe", Toast.LENGTH_SHORT)
                        .show()
                    view!!.findNavController().navigate(R.id.action_frag_vid4_to_frag_subs2)
                    x1 = 0f
                    x2 = 0f

                }
            }

        }
    }
        mDetetor.onTouchEvent(event)
            return true

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

    override fun onLongPress(e: MotionEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
