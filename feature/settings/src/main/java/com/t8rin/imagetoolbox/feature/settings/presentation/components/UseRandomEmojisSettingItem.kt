/*
 * ImageToolbox is an image editor for android
 * Copyright (c) 2024 T8RIN (Malik Mukhametzyanov)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * You should have received a copy of the Apache License
 * along with this program.  If not, see <http://www.apache.org/licenses/LICENSE-2.0>.
 */

package com.t8rin.imagetoolbox.feature.settings.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.t8rin.imagetoolbox.core.resources.R
import com.t8rin.imagetoolbox.core.resources.icons.Robot
import com.t8rin.imagetoolbox.core.resources.icons.RobotExcited
import com.t8rin.imagetoolbox.core.settings.presentation.provider.LocalSettingsState
import com.t8rin.imagetoolbox.core.ui.widget.modifier.ShapeDefaults
import com.t8rin.imagetoolbox.core.ui.widget.other.LocalToastHostState
import com.t8rin.imagetoolbox.core.ui.widget.preferences.PreferenceRowSwitch
import kotlinx.coroutines.launch

@Composable
fun UseRandomEmojisSettingItem(
    onClick: () -> Unit,
    shape: Shape = ShapeDefaults.bottom,
    modifier: Modifier = Modifier.padding(horizontal = 8.dp)
) {
    val settingsState = LocalSettingsState.current
    val toastHost = LocalToastHostState.current
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    PreferenceRowSwitch(
        modifier = modifier,
        shape = shape,
        title = stringResource(R.string.random_emojis),
        subtitle = stringResource(R.string.random_emojis_sub),
        checked = settingsState.useRandomEmojis,
        enabled = settingsState.selectedEmoji != null,
        onClick = {
            onClick()
        },
        onDisabledClick = {
            scope.launch {
                toastHost.showToast(
                    message = context.getString(R.string.random_emojis_error),
                    icon = Icons.Rounded.Robot
                )
            }
        },
        startIcon = Icons.Outlined.RobotExcited
    )
}