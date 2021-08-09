package team.sesh.teamsesh.presentation.merch.mvp

import team.sesh.teamsesh.models.Merch
import team.sesh.teamsesh.presentation.global.MvpView


interface MerchInterface : MvpView {

    fun showMerchOnFragment(showMerch: List<Merch>)

    fun startInfoActivity(merch: Merch)
}