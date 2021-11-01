package team.sesh.teamsesh.presentation.radio

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_radio.*
import team.sesh.teamsesh.R

class RadioFragment : Fragment(), RadioInterface {
    val layoutRes = R.layout.fragment_radio
    lateinit var navController: NavController
    private lateinit var presenter: RadioPresenter
    @SuppressLint("SetJavaScriptEnabled")
//    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View = layoutInflater.inflate(R.layout.fragment_radio, container, false)
    // Inflate the layout for this fragment

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retainInstance = true
        navController = Navigation.findNavController(view)
        presenter = RadioPresenter()
        presenter.attachView(this)

        // включаем поддержку JavaScript
        val myWebView: WebView = webRadio
        myWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                url: String
            ): Boolean {
                view.loadUrl(url)
                return true
            }
        }
        myWebView.loadUrl("https://radio.seshstation.com/public/main")
        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.allowContentAccess = true
        myWebView.settings.domStorageEnabled = true
        myWebView.settings.useWideViewPort = true


//        viewModel = of(requireActivity()).get(SharedViewModel::class.java)
//        viewModel.bundleFromFragmentBToFragmentA.observe(viewLifecycleOwner, Observer {
//            // This will execute when fragment B set data for `bundleFromFragmentBToFragmentA`
//            // TODO: Write your logic here to handle data sent from FragmentB
//            val message = it.getString("ARGUMENT_MESSAGE", "")
//            Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
//        })

    }

    private class MyWebViewClient : WebViewClient() {
        @TargetApi(Build.VERSION_CODES.N)
        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
            view.loadUrl(request.url.toString())
            return true
        }

        // Для старых устройств
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }


    override fun showProgress(show: Boolean) {}

    override fun showMessage(message: String) {}

    override fun onBackPressed(): Boolean {
        TODO("Not yet implemented")
    }
}

