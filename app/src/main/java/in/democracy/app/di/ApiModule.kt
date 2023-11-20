package `in`.democracy.app.di

import `in`.democracy.app.io.RequestAPIs
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(createdAtStart = false) { get<Retrofit>().create(RequestAPIs::class.java) }
}

