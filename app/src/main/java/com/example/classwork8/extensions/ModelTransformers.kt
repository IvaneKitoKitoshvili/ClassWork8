package com.example.classwork8.extensions

import com.example.classwork8.data.models.ItemsData



fun ItemsData.toModel(): ItemsData = ItemsModel(
    title,
    price,
    cover,
    liked
)

fun NewItemDto.toModel(): NewItemModel = NewCoursesModel(
    id, iconType, duration, title, question, mainColor
)

fun itemsDto.toModel(): ItemsData = CoursesModel(newCourses, activeCourses)