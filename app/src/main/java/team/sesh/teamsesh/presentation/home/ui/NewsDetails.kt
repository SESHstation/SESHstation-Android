package team.sesh.teamsesh.presentation.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details_banners.*
import kotlinx.android.synthetic.main.fragment_details_news.*
import kotlinx.android.synthetic.main.fragment_details_news.toolbar_main
import kotlinx.android.synthetic.main.fragment_details_news.view.*
import team.sesh.teamsesh.R
import team.sesh.teamsesh.presentation.global.BaseFragment

class NewsDetails: BaseFragment() {

    override val layoutRes = R.layout.fragment_details_news
    private lateinit var titlenews: String
    private lateinit var descriptionnews: String
    private lateinit var imagenews: String
    lateinit var navControleer: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = layoutInflater.inflate(R.layout.fragment_details_news, container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        descriptionnews = arguments?.getString("newsDescription")!!
        titlenews = arguments?.getString("newsTitle")!!
        imagenews = arguments?.getString("newsImage")!!

        super.onCreate(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navControleer = Navigation.findNavController(view)
        toolbar_main.setNavigationOnClickListener {
            navControleer.navigate(R.id.action_nav_details_news_to_navigation_home)
        }
        textnews.setText(titlenews)
        descriptionNews.setText(descriptionnews)
        Picasso
            .get()
            .load(imagenews)
            .into(view.imageNews)

        super.onViewCreated(view, savedInstanceState)

    }

}