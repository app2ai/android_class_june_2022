package com.rtech.studyapplication.test

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Test {
    companion object {
        fun test(ctx: Context): TestData {
            return Gson().fromJson<TestData>(
                ctx.assets.open("data.json").reader().readText(),
                object : TypeToken<TestData>() {}.type
            )
        }
    }
}
