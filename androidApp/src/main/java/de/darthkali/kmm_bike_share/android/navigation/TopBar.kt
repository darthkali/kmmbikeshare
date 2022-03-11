package de.darthkali.weefood.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    title: String = "",
    navigationIcon: ImageVector? = null,
    navigationIconClickAction: (() -> Unit)? = null,
    actionIcon: ImageVector? = null,
    actionIconIconClickAction: (() -> Unit)? = null,
) {
    TopAppBar(
        navigationIcon = setIcon(navigationIcon, navigationIconClickAction = navigationIconClickAction),
        title = {
            Text(
                text = title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        },
        actions = {
            actionIconIconClickAction?.let { it ->
                IconButton(onClick = it) {

                    actionIcon?.let { Icon(it, "") }
                }
            }
        },
        backgroundColor = MaterialTheme.colors.primary,

    )
}

fun setIcon(
    icon: ImageVector? = null,
    navigationIconClickAction: (() -> Unit)? = null,
): @Composable() (() -> Unit)? {
    icon?.let {
        return {
            Icon(
                imageVector = it,
                contentDescription = "Back",
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .clickable(onClick = navigationIconClickAction!!)
                    .fillMaxHeight()
            )
        }
    }
    return null
}
