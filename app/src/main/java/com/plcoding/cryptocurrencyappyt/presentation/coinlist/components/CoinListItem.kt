package com.plcoding.cryptocurrencyappyt.presentation.coinlist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.cryptocurrencyappyt.domain.model.Coin

/**
 * Created by felipebertanha on 08/August/2022
 */

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClicked: (Coin) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClicked(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = if (coin.isActive) "active" else "inactive",
            color = if (coin.isActive) Color.Green else Color.Red,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CoinListItemPreview() {
    Column() {
        CoinListItem(
            Coin(
                "1",
                true,
                "Bitcoin",
                1,
                "BTC"
            )
        ) {}
        CoinListItem(
            Coin(
                "2",
                false,
                "Dogecoin",
                2,
                "DGC"
            )
        ) {}
    }

}