package team.sesh.teamsesh.presentation.events.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details_banners.*
import kotlinx.android.synthetic.main.fragment_details_banners.toolbar_main
import kotlinx.android.synthetic.main.fragment_details_banners.view.*
import kotlinx.android.synthetic.main.fragment_details_news.*
import team.sesh.teamsesh.R

class BannersDetails : Fragment() {

    private lateinit var description: String
    private lateinit var title: String
    private lateinit var image: String
    lateinit var navControleer: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = layoutInflater.inflate(R.layout.fragment_details_banners, container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        description = arguments?.getString("BANNERdescription")!!
        title = arguments?.getString("BANNERtitle")!!
        image = arguments?.getString("BANNERimage")!!

        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navControleer = Navigation.findNavController(view)
        toolbar_main.setNavigationOnClickListener {
            navControleer.navigate(R.id.action_nav_details_banners_to_navigation_notifications)
        }
        texttitle.setText(title)
        descriptionText.setText(description)
        Picasso
            .get()
            .load(image)
            .into(view.imageCover)

        super.onViewCreated(view, savedInstanceState)

    }
}