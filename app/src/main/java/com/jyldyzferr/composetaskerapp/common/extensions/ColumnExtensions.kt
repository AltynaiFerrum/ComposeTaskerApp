package com.jyldyzferr.composetaskerapp.common.extensions

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.jyldyzferr.composetaskerapp.presentation.theme.SmallSpacing

@Composable
fun ColumnScope.SpacerHeight(dp: Dp) {
    Spacer(modifier = Modifier.height(dp))
}