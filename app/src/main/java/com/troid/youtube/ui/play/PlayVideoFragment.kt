package com.troid.youtube.ui.play

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import com.troid.youtube.MY_API_KEY
import com.troid.youtube.R
import com.troid.youtube.databinding.FragmentPlayVideoBinding


/**
 * A simple [Fragment] subclass.
 */
class PlayVideoFragment : Fragment(), YouTubePlayer.OnInitializedListener {

    private lateinit var playVideoViewModel: PlayVideoViewModel
    private lateinit var binding: FragmentPlayVideoBinding

    private val RECOVERY_DIALOG_REQUEST = 1
    private lateinit var videoLink: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_play_video, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initialize viewModel
        playVideoViewModel = ViewModelProvider(this).get(PlayVideoViewModel::class.java)
        val bundle = this.arguments
        if (bundle != null) {
            videoLink = bundle.getString("videoLink").toString()
        }
        // initialize youTube Player
        val youTubePlayerFragment =
            childFragmentManager.findFragmentById(R.id.official_player_view) as YouTubePlayerSupportFragment?

        youTubePlayerFragment!!.initialize(MY_API_KEY, this)
    }


    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean
    ) {
        if (!p2) {
            p1!!.cueVideo(videoLink)
            Log.e("Tag", "done")
        }
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        if (p1!!.isUserRecoverableError) {
            p1.getErrorDialog(activity, RECOVERY_DIALOG_REQUEST).show()
        } else {
            val errorMessage = String.format(
                "There was an error initializing the YouTubePlayer (%1\$s)",
                p1.toString()
            )
            Toast.makeText(activity, errorMessage, Toast.LENGTH_LONG).show()
            Log.e("Tag", "Error")

        }
    }

}
