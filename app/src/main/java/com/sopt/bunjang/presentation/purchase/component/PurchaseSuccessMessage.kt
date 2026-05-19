package com.sopt.bunjang.presentation.purchase.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme

@Composable
fun PurchaseSuccessMessage(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_complete_check),
            contentDescription = null,
            modifier = Modifier
                .size(52.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "결제가 완료되었어요",
            style = BunjangTheme.typography.title.title1,
            color = BunjangTheme.colors.black
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "상품이 준비되면 번개톡으로 알려드릴게요.\n설레는 마음으로 조금만 기다려주세요.",
            style = BunjangTheme.typography.body.body1,
            color = BunjangTheme.colors.gray600,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PurchaseSuccessMessagePreview() {
    BunjangTheme {
        PurchaseSuccessMessage()
    }
}