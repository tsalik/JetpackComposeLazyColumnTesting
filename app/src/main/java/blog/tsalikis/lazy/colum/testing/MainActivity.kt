package blog.tsalikis.lazy.colum.testing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import blog.tsalikis.lazy.colum.testing.ui.theme.RunAppTheme
import blog.tsalikis.lazy.colum.testing.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RunAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RunDetailsScreen(
                        records = listOf(
                            RunRecord(
                                icon = R.drawable.ic_average_pace,
                                title = "Avg. Pace",
                                record = "07:42 min/km"
                            ),
                            RunRecord(
                                icon = R.drawable.ic_speed,
                                title = "Avg. Speed",
                                record = "7.8 km/h"
                            ),
                            RunRecord(
                                icon = R.drawable.ic_max_speed,
                                title = "Max. Speed",
                                record = "11.1 km/h"
                            ),
                            RunRecord(
                                icon = R.drawable.ic_elevation_gain,
                                title = "Elevation Gain",
                                record = "83 m"
                            ),
                            RunRecord(
                                icon = R.drawable.ic_elevation_loss,
                                title = "Elevation Loss",
                                record = "87 m"
                            )
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun RunDetailsScreen(records: List<RunRecord>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)) {
            Column(modifier = Modifier.weight(0.33f), horizontalAlignment = Alignment.Start) {
                Text(text = "10.01", style = Typography.titleLarge)
                Text(text = "Distance (km)", style = Typography.labelSmall)
            }
            Column(
                modifier = Modifier.weight(0.33f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "01:17:15", style = Typography.titleLarge)
                Text(text = "Duration", style = Typography.labelSmall)
            }
            Column(modifier = Modifier.weight(0.33f), horizontalAlignment = Alignment.End) {
                Text(text = "996", style = Typography.titleLarge)
                Text(text = "Calories", style = Typography.labelSmall)
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Divider()
        Spacer(modifier = Modifier.height(4.dp))
        LazyColumn(
            modifier = modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(records) { record ->
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = record.icon),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = record.title,
                            modifier = Modifier
                                .weight(.8f),
                            style = Typography.titleMedium
                        )
                        Text(
                            text = record.record,
                            style = Typography.titleMedium
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider()
                }
            }
        }
    }
}

data class RunRecord(
    @DrawableRes val icon: Int,
    val title: String,
    val record: String
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RunAppTheme {
        RunDetailsScreen(
            records = listOf(
                RunRecord(
                    icon = R.drawable.ic_average_pace,
                    title = "Avg. Pace",
                    record = "07:42 min/km"
                ),
                RunRecord(
                    icon = R.drawable.ic_speed,
                    title = "Avg. Speed",
                    record = "7.8 km/h"
                ),
                RunRecord(
                    icon = R.drawable.ic_max_speed,
                    title = "Max. Speed",
                    record = "11.1 km/h"
                ),
                RunRecord(
                    icon = R.drawable.ic_elevation_gain,
                    title = "Elevation Gain",
                    record = "83 m"
                ),
                RunRecord(
                    icon = R.drawable.ic_elevation_loss,
                    title = "Elevation Loss",
                    record = "87 m"
                )
            )
        )
    }
}