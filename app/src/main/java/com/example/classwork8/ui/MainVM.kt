package com.example.classwork8.ui

import androidx.lifecycle.viewModelScope
import com.example.classwork8.base.BaseViewModel
import com.example.classwork8.data.models.ItemsData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(private val getCoursesUseCase: ItemsData) :
    BaseViewModel<ItemsData>() {

    private val _state: MutableStateFlow<ViewState> = MutableStateFlow(ViewState())
    val state = _state.asStateFlow()

    init {
        getCourses()
    }

    private fun getCourses() {
        viewModelScope.launch {
            val courses = getItemsUseCase(Unit)
            getData(courses) {
                _state.value = _state.value.copy(
                    activeCourses = _defaultState.value.data?.?.map { it.toModel() }
                        ?: emptyList(),
                    newCourses = _defaultState.value.data?.?.map { it.toModel() }
                        ?: emptyList()
                )
            }
        }
    }

    data class ViewState(
        val activeCourses: List<> = emptyList(),
        val newCourses: List<> = emptyList()
    )
}