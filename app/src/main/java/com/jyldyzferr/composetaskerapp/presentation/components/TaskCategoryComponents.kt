package com.jyldyzferr.composetaskerapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jyldyzferr.composetaskerapp.domain.models.Task
import com.jyldyzferr.composetaskerapp.domain.models.TaskCategory
import com.jyldyzferr.composetaskerapp.common.extensions.SpacerHeight
import com.jyldyzferr.composetaskerapp.common.extensions.convertToColor
import com.jyldyzferr.composetaskerapp.presentation.theme.ComposeTaskerAppTheme
import com.jyldyzferr.composetaskerapp.presentation.theme.ExtraMediumSpacing
import com.jyldyzferr.composetaskerapp.presentation.theme.LargeSpacing
import com.jyldyzferr.composetaskerapp.presentation.theme.SmallSpacing


@Preview
@Composable
fun TaskCategoryItemPreview() {
    ComposeTaskerAppTheme {
        TaskCategoryItem(
            category = TaskCategory.preview,
            count = 22
        )
    }
}

@Composable
fun TaskCategoryList(
    modifier: Modifier = Modifier,
    categories: List<TaskCategory>,
    onClick: (TaskCategory) -> Unit
    ) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = categories,
            key = { item -> item.id }
        ) { category ->
            Column(
                modifier = Modifier
                    .clickable { onClick(category) }
                    .padding(horizontal = LargeSpacing)
            ) {
                SpacerHeight(dp = SmallSpacing)
                TaskCategoryItem(category = category)
                SpacerHeight(dp = SmallSpacing)
            }
        }
    }
}



@Composable
fun TaskCategoryItem(
    modifier: Modifier = Modifier,
    category: TaskCategory,
    count: Int? = null
) {
    Box(
        modifier = modifier
            .height(70.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .background(category.colorCode.convertToColor())
    ) {
        Column(
            modifier = modifier
                .padding(start = LargeSpacing)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            SpacerHeight(dp = ExtraMediumSpacing)
            Text(
                text = category.title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 19.sp,
                    color = Color.White

                )
            )
            if (count != null) {
                Text(
                    text = "$count tasks",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black
                    )
                )
            }
        }
    }
}