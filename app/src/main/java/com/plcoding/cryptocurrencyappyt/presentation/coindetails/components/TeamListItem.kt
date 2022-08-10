package com.plcoding.cryptocurrencyappyt.presentation.coindetails.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.cryptocurrencyappyt.domain.model.TeamMember

/**
 * Created by felipebertanha on 09/August/2022
 */
@Composable
fun TeamListItem(
    teamMember: TeamMember,
    modifier: Modifier = Modifier
) {
    Column(

        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = teamMember.name,
            style = MaterialTheme.typography.h4,
        )
        Spacer(
            modifier = Modifier.height(4.dp)
        )
        Text(
            text = teamMember.position,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TeamListPreview() {
    Column {
        TeamListItem(teamMember = TeamMember("Felipe", "Founder"))
        TeamListItem(teamMember = TeamMember("Evelyn", "Blockchain Developer"))
        TeamListItem(teamMember = TeamMember("Osmar", "Blockchain Developer"))
    }
}