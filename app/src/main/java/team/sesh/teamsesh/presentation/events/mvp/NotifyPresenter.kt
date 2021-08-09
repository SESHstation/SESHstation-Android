package team.sesh.teamsesh.presentation.events.mvp

import android.view.View
import team.sesh.teamsesh.data.DataManager
import team.sesh.teamsesh.presentation.events.mvp.NotifyInterface
import team.sesh.teamsesh.presentation.global.MvpPresenter

class NotifyPresenter : MvpPresenter<NotifyInterface>() {

    private var vwHomePresenter: View? = null
    private val dataManager: DataManager by lazy(LazyThreadSafetyMode.NONE) {
        DataManager()
    }

    fun getBannersOnView() {

        dataManager.getBannersManager(
            onSuccess = {banner ->
                getView().showBannersOnFragment(showBanners = banner)
            },
            onFailure = {

            }
        )
    }

}