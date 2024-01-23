package dev.icerock.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.icerock.dto.Contact
import dev.icerock.repository.Repository

class ContactsViewModel : ViewModel() {
    private val repository = Repository()

    val contactList: MutableLiveData<List<Contact>> = MutableLiveData()

    init {
        contactList.value = repository.saveContact()
    }

    fun secondContact(): List<Contact> {
        return repository.saveSecondContact()
    }
}