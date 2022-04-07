package io.github.tuguzt.recyclerviewexample.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.tuguzt.recyclerviewexample.model.Person
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

class ListViewModel : ViewModel() {
    private val _people = MutableLiveData<List<Person>>()
    val people: LiveData<List<Person>> get() = _people

    @OptIn(ExperimentalSerializationApi::class)
    fun loadPeople(context: Context) {
        val inputStream = context.assets.open("personData.json")
        val people: List<Person> = Json.decodeFromStream(inputStream)
        _people.value = people
    }

    enum class SortBy {
        Name,
        Sex,
        PhoneNumber,
    }

    fun sortPeople(sortBy: SortBy) {
        val people = requireNotNull(people.value)
        _people.value = when (sortBy) {
            SortBy.Name -> people.sortedBy(Person::name)
            SortBy.Sex -> people.sortedBy(Person::sex)
            SortBy.PhoneNumber -> people.sortedBy(Person::phoneNumber)
        }
    }
}
