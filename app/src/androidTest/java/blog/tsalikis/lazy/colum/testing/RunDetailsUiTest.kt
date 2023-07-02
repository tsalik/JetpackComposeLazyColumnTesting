package blog.tsalikis.lazy.colum.testing

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasAnySibling
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performScrollToNode
import androidx.compose.ui.test.printToLog
import androidx.test.ext.junit.runners.AndroidJUnit4
import blog.tsalikis.lazy.colum.testing.ui.theme.RunAppTheme
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class RunDetailsUiTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun should_populate_records_properly() {
        composeTestRule.setContent {
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
                    )
                )
            }
        }

        composeTestRule.onNodeWithTag(RunDetailsTestTags.records)
            .printToLog(RunDetailsTestTags.records)

        composeTestRule.onNodeWithTag(RunDetailsTestTags.records)
            .performScrollToNode(hasText("Avg. Pace") and hasAnySibling( hasText("07:42 min/km")))
            .assertIsDisplayed()
    }
}