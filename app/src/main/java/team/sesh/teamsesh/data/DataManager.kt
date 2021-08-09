package team.sesh.teamsesh.data

import android.util.Log

import com.google.firebase.database.*
import team.sesh.teamsesh.models.Banner
import team.sesh.teamsesh.models.Merch
import team.sesh.teamsesh.models.News

class DataManager {


    fun getMerchManager(onSuccess: ((ArrayList<Merch>) -> Unit), onFailure: (() -> Unit)) {

        val merchArray = ArrayList<Merch>()


        val reference: DatabaseReference = FirebaseDatabase.getInstance().getReference("Merch")
        reference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Log.e("DATA", "error")
                onFailure.invoke()
            }

            override fun onDataChange(p0: DataSnapshot) {

                for (snapshot in p0.children) {

                    val merch = snapshot.getValue(Merch::class.java)
                    merch?.let { merchArray.add(it) }
                }
                onSuccess.invoke(merchArray)
            }

        })

    }


    fun getNewsManager(onSuccess: ((ArrayList<News>) -> Unit), onFailure: (() -> Unit)) {

        val reference: DatabaseReference = FirebaseDatabase.getInstance().getReference("News")
        reference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Log.e("DATA", "error")
                onFailure.invoke()
            }

            override fun onDataChange(p0: DataSnapshot) {

                val newsArray = arrayListOf<News>()

                for (snapshot in p0.children) {
                    val news = snapshot.getValue(News::class.java)
                    news?.let { newsArray.add(it) }
                }
                onSuccess.invoke(newsArray)
            }
        })
    }
    fun getBannersManager(onFailure: () -> Unit, onSuccess: (ArrayList<Banner>) -> Unit) {
        val bannersArray = ArrayList<Banner>()
        val reference = FirebaseDatabase.getInstance().getReference("banners")
        reference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                onFailure.invoke()
            }
            override fun onDataChange(p0: DataSnapshot) {
                for (snapshot in p0.children) {
                    val banner = snapshot.getValue(Banner::class.java)
                    banner?. let { bannersArray.add(it) }
                }
                onSuccess.invoke(bannersArray)
            }
        })
    }
}


