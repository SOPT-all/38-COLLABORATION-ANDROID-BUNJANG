package com.sopt.bunjang.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme
import com.sopt.bunjang.presentation.home.model.CategoryItem

@Composable
private fun HomeCategoryItem(
    item: CategoryItem,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .background(color = BunjangTheme.colors.gray100, RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = item.iconRes),
                contentDescription = item.label,
                modifier = Modifier.size(48.dp),
                tint = Color.Unspecified
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .heightIn(min = 30.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = item.label,
                style = BunjangTheme.typography.body.body4,
                color = BunjangTheme.colors.gray800,
                maxLines = 2,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun HomeCategoryAll(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(CategoryItem.entries) { item ->
            HomeCategoryItem(item = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeCategoryAll() {
    BunjangTheme {
        HomeCategoryAll()
    }
}