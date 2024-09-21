package edu.appstate.cs.moments

import androidx.lifecycle.SavedStateHandle
import org.junit.Assert.*
import org.junit.Test

class MomentsViewModelTest{

    @Test
    fun testTitleAndDescriptionOfFirstMoment() {

        val title = "At Anne Belk!"
        val description = "We visited the CS building today"
        val savedStateHandle = SavedStateHandle()
        val momentsViewModel = MomentsViewModel(savedStateHandle)
        assertEquals(title, momentsViewModel.currentTitle)
        assertEquals(description, momentsViewModel.currentMoment)

    }

    @Test
    fun shouldNotChangeTitleWhenMovingToPreviousMomentAtStart(){
        val firstTitle = "At Anne Belk!"
        val savedStateHandle = SavedStateHandle()
        val momentsViewModel = MomentsViewModel(savedStateHandle)

        //at first the currentIndex should be 0
        assertEquals(0, momentsViewModel.currentIndex )

        //moving back using previousButton
        momentsViewModel.prevMoment()

        //testing if the index is equal to the
        assertEquals(firstTitle, momentsViewModel.currentTitle)
    }

    @Test
    fun shouldNotChangeTitleWhenMovingToNextMomentAtLastLastElement(){
        val savedStateHandle = SavedStateHandle()
        val momentsViewModel = MomentsViewModel(savedStateHandle)

        //setting currentIndex to the last element
        val lastIndex = momentsViewModel.listSize -1
        momentsViewModel.currentIndex = lastIndex
        val lastTitle = "At Walker Business!"

        //when it is at the lastIndex, currentIndex can be reflected by lastIndex
        assertEquals(lastIndex, momentsViewModel.currentIndex)

        //move to the next element from the lastIndex
        momentsViewModel.nextMoment()

        //title should remain at the last element
        assertEquals(lastTitle, momentsViewModel.currentTitle)

    }

}