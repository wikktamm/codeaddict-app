package com.example.codeaddict_app.di

import com.example.codeaddict_app.data.repositories.implementation.RepositoryRepositoryImpl
import com.example.codeaddict_app.data.repositories.interfaces.RepositoriesRepository
import com.example.codeaddict_app.data.services.GitRepositoriesService
import com.example.codeaddict_app.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client).build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): GitRepositoriesService {
        return retrofit.create(GitRepositoriesService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(service: GitRepositoriesService): RepositoriesRepository {
        return RepositoryRepositoryImpl(service)
    }
}