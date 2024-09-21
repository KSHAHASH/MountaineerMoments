package edu.appstate.cs.moments

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.action.ViewActions.click
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MomentsActivityTest{

    private lateinit var scenario: ActivityScenario<MomentsActivity>

    @Before
    fun setUp(){
        scenario = launch(MomentsActivity::class.java)
    }

    @After
    fun tearDown(){
        scenario.close()
    }

    @Test
    fun showsTitleAndDescriptionOfFirstMomentOnLaunch(){
        val expectedTitle = "At Anne Belk!"
        val expectedDescription = "We visited the CS building today"

        //testing the titleTextView with the expectedTitle at the first moment
        onView(withId(R.id.titleTextView))
            .check(matches(withText(expectedTitle)))

        //testing the momentTextView with the expectedDescription at the first moment
        onView(withId(R.id.momentTextView))
            .check(matches(withText(expectedDescription)))
    }

    @Test
    fun showsTitleAndDescriptionOfSecondMomentAfterNextButtonClick(){

        val expectedTitle = "At Student Unions!"
        val expectedDescription = "We visited the career development center today"

        //instrumented test to check title and description matches after a nextButton click
        onView(withId(R.id.nextButton)).perform(click())

        onView(withId(R.id.titleTextView))
            .check(matches(withText(expectedTitle)))

        onView(withId(R.id.momentTextView))
            .check(matches(withText(expectedDescription)))

    }

    @Test
    fun showsFirstMomentAfterClickingNextAndPreviousButton(){

        val expectedTitle = "At Anne Belk!"
        val expectedDescription = "We visited the CS building today"

        onView(withId(R.id.nextButton)).perform(click())

        onView(withId(R.id.prevButton)).perform(click())

        onView(withId(R.id.titleTextView))
            .check(matches(withText(expectedTitle)))

        onView(withId(R.id.momentTextView))
            .check(matches(withText(expectedDescription)))
    }

}