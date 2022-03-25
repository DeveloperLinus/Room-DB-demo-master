package com.itlong.common.utils

import android.util.Log
import io.reactivex.Flowable
import io.reactivex.FlowableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import java.lang.Exception

object RxJava2Helper {
    @JvmStatic
    fun <T> getFlowable(method: () -> T): Flowable<T> {
        return object : Flowable<T>() {
            override fun subscribeActual(subscriber: Subscriber<in T>) {
                try {
                    subscriber.onNext(method.invoke())
                } catch (exception: Exception) {
                    Log.e("Room", "getFlowable fail msg=${exception.message}")
                    subscriber.onError(exception)
                }
                subscriber.onComplete()
            }
        }.compose(io2main())
    }

    @JvmStatic
    fun <T> io2main(): FlowableTransformer<T, T> {
        return FlowableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }
}