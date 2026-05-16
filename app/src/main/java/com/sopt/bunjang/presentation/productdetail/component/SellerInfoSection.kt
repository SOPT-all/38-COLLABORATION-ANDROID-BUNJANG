package com.sopt.bunjang.presentation.productdetail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme

@Composable
fun SellerInfoSection(
    storeName: String,
    rating: Double,
    reviewCount: Int,
    transactionCount: Int,
    isFollowing: Boolean = false,
    onFollowClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 19.5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_detail_page_profile),
                contentDescription = "profile",
                tint = Color.Unspecified,
                modifier = Modifier.size(42.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = storeName,
                    color = BunjangTheme.colors.gray900,
                    style = BunjangTheme.typography.title.title4
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_detail_page_star),
                        contentDescription = "rating",
                        tint = BunjangTheme.colors.yellow,
                        modifier = Modifier.size(12.dp)
                    )

                    Spacer(modifier = Modifier.width(2.dp))

                    Text(
                        text = "$rating · 후기 $reviewCount · 거래내역 $transactionCount",
                        color = BunjangTheme.colors.gray500,
                        style = BunjangTheme.typography.body.body2
                    )
                }
            }

            FollowButton(
                isFollowing = isFollowing,
                onClick = onFollowClick
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun SellerInfoSectionPreview() {
    BunjangTheme {
        SellerInfoSection(
            storeName = "Zufall",
            rating = 5.0,
            reviewCount = 15,
            transactionCount = 26,
            isFollowing = false
        )
    }
}
