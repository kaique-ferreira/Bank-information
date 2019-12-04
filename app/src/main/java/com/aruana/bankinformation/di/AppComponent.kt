package com.aruana.bankinformation.di

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.aruana.bankinformation.MyApplication
import com.aruana.bankinformation.ui.bank.BankFragment
import com.aruana.bankinformation.ui.bank.BankViewModel
import com.aruana.bankinformation.ui.biciban.BicIbanFragment
import com.aruana.bankinformation.ui.biciban.BicIbanViewModel
import com.aruana.bankinformation.ui.postcode.PostCodeFragment
import com.aruana.bankinformation.ui.postcode.PostCodeViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, BankModule::class, IbanModule::class, BicModule::class, CommonModule::class, PostCodeModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(fragment: PostCodeFragment)
    fun inject(fragment: BicIbanFragment)
    fun inject(fragment: BankFragment)

    val bankViewModel: BankViewModel
    val bicIbanViewModel: BicIbanViewModel
    val postCodeViewModel: PostCodeViewModel
}

inline fun <reified T : ViewModel> AppCompatActivity.createViewModel(crossinline factory: () -> T): T = T::class.java.let { clazz ->
    ViewModelProviders.of(this, object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass == clazz) {
                @Suppress("UNCHECKED_CAST")
                return factory() as T
            }
            throw IllegalArgumentException("Unexpected argument: $modelClass")
        }
    }).get(clazz)
}

inline fun <reified T : ViewModel> Fragment.createFragmentViewModel(crossinline factory: () -> T): T = T::class.java.let { clazz ->
    ViewModelProviders.of(this, object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass == clazz) {
                @Suppress("UNCHECKED_CAST")
                return factory() as T
            }
            throw IllegalArgumentException("Unexpected argument: $modelClass")
        }
    }).get(clazz)
}

fun BankFragment.createBankViewModel() =
        createFragmentViewModel {
            (requireActivity().application as MyApplication).appComponent.bankViewModel
        }

fun BicIbanFragment.createBicIbanViewModel() =
        createFragmentViewModel {
            (requireActivity().application as MyApplication).appComponent.bicIbanViewModel
        }

fun PostCodeFragment.createPostCodeViewModel() =
        createFragmentViewModel {
            (requireActivity().application as MyApplication).appComponent.postCodeViewModel
        }