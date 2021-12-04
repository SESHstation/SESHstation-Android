package team.sesh.teamsesh.presentation.merch.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_merch.*
import team.sesh.teamsesh.R
import team.sesh.teamsesh.models.Merch
import team.sesh.teamsesh.presentation.global.Utils
import team.sesh.teamsesh.presentation.global.Utils.Companion.DP
import team.sesh.teamsesh.presentation.merch.mvp.MerchInterface
import team.sesh.teamsesh.presentation.merch.mvp.MerchPresenter

class MerchFragment : Fragment(), MerchInterface {

    private var girdSpaceValue = 4
    private lateinit var recViewMerch: RecyclerView
    private lateinit var presenter: MerchPresenter
    private val merchAdapter: MerchAdapter by lazy {
        MerchAdapter(
            itemWidth = (Utils.getDisplayWidth(context) - (girdSpaceValue * 10) * DP.toInt()) / 2
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View = layoutInflater.inflate(R.layout.fragment_merch, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recViewMerch = view.findViewById(R.id.recViewCategories)
        presenter = MerchPresenter()
        presenter.getMerchOnView()
        presenter.attachView(this)
        recViewCategories.adapter = merchAdapter
        initViews()
    }

    private fun initViews() {

        recViewMerch.run {
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    override fun showMerchOnFragment(showMerch: List<Merch>) {
        merchAdapter.setData(showMerch as ArrayList<Merch>)

    }

    override fun startInfoActivity(merch: Merch) {}

    override fun showProgress(show: Boolean) {}

    override fun showMessage(message: String) {}
    override fun onBackPressed(): Boolean {
        TODO("Not yet implemented")
    }

}
