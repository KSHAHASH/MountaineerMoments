package edu.appstate.cs.moments

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat

const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

class MomentsViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val listOfMoments = listOf(
        Moment("At Anne Belk!", "We visited the CS building today"),
        Moment("At Student Unions!", "We visited the career development center today"),
        Moment("At Walker Business!", "We visited the Business building today")
    )

     var currentIndex:Int
        get() = savedStateHandle[CURRENT_INDEX_KEY]?:0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val listSize:Int
        get() = listOfMoments.size

    val currentMoment: String
        get() = listOfMoments[currentIndex].description

    val currentTitle: String
        get() = listOfMoments[currentIndex].title

    val currentTimeStamp: String
        get() {
            val dateFormat = SimpleDateFormat.getDateTimeInstance()
            return dateFormat.format(listOfMoments[currentIndex].timestamp)
        }

    fun nextMoment(){
        if(currentIndex < listSize -1){
            currentIndex++
        }
    }

    fun prevMoment(){
            if (currentIndex > 0) {
                currentIndex--
            }


    }


}