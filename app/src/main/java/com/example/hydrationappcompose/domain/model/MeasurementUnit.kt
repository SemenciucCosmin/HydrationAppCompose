package com.example.hydrationappcompose.domain.model

import androidx.annotation.StringRes
import com.example.hydrationappcompose.R

enum class MeasurementUnit(
    val id: Int,
    @StringRes val shortStringRes: Int,
    @StringRes val detailedStringRes: Int,
    @StringRes val formattedStringRes: Int
) {
    MILLILITERS(
        id = 0,
        shortStringRes = R.string.lbl_unit_ml,
        detailedStringRes = R.string.lbl_unit_milliliters,
        formattedStringRes = R.string.lbl_unit_formatted_ml
    ),
    OUNCES(
        id = 1,
        shortStringRes = R.string.lbl_unit_oz,
        detailedStringRes = R.string.lbl_unit_ounces,
        formattedStringRes = R.string.lbl_unit_formatted_oz
    );

    companion object {
        fun getById(id: Int) = entries.firstOrNull { it.id == id } ?: MILLILITERS
    }
}
