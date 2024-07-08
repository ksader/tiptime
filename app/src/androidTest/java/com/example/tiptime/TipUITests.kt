import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.tiptime.TipTimeLayout
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_22_percent_tip_no_roundup() {
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeLayout()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("22")

        val expectedTip = NumberFormat.getCurrencyInstance().format(2.20)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
            "No node with this text was found.")
    }

    @Test
    fun calculate_22_percent_tip_round_up() {
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeLayout()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount").performTextInput("123.57")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("22")
        composeTestRule.onNodeWithTag("roundUpTip").performClick()

        val expectedTip = NumberFormat.getCurrencyInstance().format(28.43)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
            "No node with this text was found.")

        val expectedTotal = NumberFormat.getCurrencyInstance().format(28.43 + 123.57)
        composeTestRule.onNodeWithText("Total Bill: $expectedTotal").assertExists(
            "No node with this text was found.")
    }
}