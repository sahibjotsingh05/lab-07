package com.example.lab07

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    @Test
    fun navigate_to_drivers_screen() {
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()
    }

    @Test
    fun add_driver_displays_in_list() {
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Hamilton")

        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Hamilton")
            .assertExists()
    }

    @Test
    fun clear_drivers_removes_all_from_list() {
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Hamilton")

        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Verstappen")

        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Hamilton")
            .assertExists()

        composeTestRule
            .onNodeWithText("Verstappen")
            .assertExists()

        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Hamilton")
            .assertDoesNotExist()

        composeTestRule
            .onNodeWithText("Verstappen")
            .assertDoesNotExist()
    }

    @Test
    fun back_button_returns_to_home_screen() {
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        composeTestRule
            .onNodeWithTag("driversBackButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}
