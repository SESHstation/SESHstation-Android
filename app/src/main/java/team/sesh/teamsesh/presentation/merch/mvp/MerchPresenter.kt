package team.sesh.teamsesh.presentation.merch.mvp

import android.view.View
import team.sesh.teamsesh.data.DataManager
import team.sesh.teamsesh.presentation.global.MvpPresenter

class MerchPresenter : MvpPresenter<MerchInterface>() {

    private var vwMerchPresenter: View? = null
    private val dataManager: DataManager by lazy(LazyThreadSafetyMode.NONE) {
        DataManager()
    }

    fun getMerchOnView() {
        dataManager.getMerchManager(
            onSuccess = { merch ->
                getView().showMerchOnFragment(showMerch = merch)
            },
            onFailure = {

            }
        )
    }
}