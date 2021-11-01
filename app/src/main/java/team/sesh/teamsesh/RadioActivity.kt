package team.sesh.teamsesh

import android.content.Context
import android.media.AudioManager.OnAudioFocusChangeListener
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*
//import com.google.android.exoplayer2.*
//import com.google.android.exoplayer2.source.MediaSource
//import com.google.android.exoplayer2.source.hls.HlsMediaSource
//import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
//import com.google.android.exoplayer2.trackselection.TrackSelector
//import com.google.android.exoplayer2.ui.PlayerControlView
//import com.google.android.exoplayer2.upstream.DataSource
//import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
//import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
//import com.google.android.exoplayer2.upstream.TransferListener
//import com.google.android.exoplayer2.util.Util
import org.jetbrains.anko.audioManager
import team.sesh.teamsesh.presentation.home.mvp.HomePresenter


class RadioActivity( ): AppCompatActivity(), OnAudioFocusChangeListener {

//    companion object {
//        const val radio_api = "stream_url"
//    }
//    private lateinit var player: SimpleExoPlayer
//    lateinit var pvStream:PlayerControlView


//    private fun buildMediaSource(uri:Uri):MediaSource {
//        val defaultBandwidthMeter = DefaultBandwidthMeter()
//        val defaultDataSourceFactory = DefaultDataSourceFactory(this as Context, Util.getUserAgent(this as Context, "SeshApp" as String), defaultBandwidthMeter as TransferListener)
//        val hlsMediaSource = HlsMediaSource(uri, defaultDataSourceFactory as DataSource.Factory, 3, null, null)
//        return hlsMediaSource
//    }
//
//    private fun initializePlayer() {
//        if (
//            this.audioManager.requestAudioFocus(this as OnAudioFocusChangeListener, 3, 1) !== 1)
//        {
//            return
//        }
//        this.player = ExoPlayerFactory.newSimpleIMynstance(DefaultRenderersFactory(this as Context) as RenderersFactory, DefaultTrackSelector() as TrackSelector, DefaultLoadControl() as LoadControl)
//        this.pvStream.setPlayer(this.player)
//        this.player.playWhenReady = true
//        val mediaSource = this.buildMediaSource(Uri.parse(this.intent.extras?.getString(radio_api) as String))
//        this.player.prepare(mediaSource)
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_radio)
//    }
//
    override fun onAudioFocusChange(focusChange: Int) {
        TODO("Not yet implemented")
    }
}

