package com.dicoding.mypremierleague.about

import android.content.Context
import com.dicoding.mypremierleague.di.AboutModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [AboutModuleDependencies::class])
interface AboutComponent {

    fun inject(activity: AboutActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(aboutModuleDependencies: AboutModuleDependencies): Builder
        fun build(): AboutComponent
    }
}