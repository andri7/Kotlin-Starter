package isfaaghyth.app.kotlinstarter.core.main

import io.reactivex.observers.ResourceObserver
import isfaaghyth.app.kotlinstarter.base.BasePresenter
import isfaaghyth.app.kotlinstarter.models.User
import retrofit2.Response

/**
 * Created by isfaaghyth on 11/7/17.
 * github: @isfaaghyth
 */
class MainPresenter(view: MainView): BasePresenter<MainView>() {

    init {
        super.attachView(view)
    }

    fun getUser(username: String) {
        subscribe(service!!.getUser(username), object : ResourceObserver<Response<User>>() {
            override fun onComplete() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onNext(result: Response<User>?) {
                if (result!!.isSuccessful) {
                    result.body()?.let {
                        view!!.onSuccess(it)
                    }
                }
            }

            override fun onError(e: Throwable?) {
                e!!.message?.let {
                    view!!.onError(it)
                }
            }

        })
    }

}