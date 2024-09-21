package edu.appstate.cs.moments

import android.os.Bundle

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import edu.appstate.cs.moments.databinding.ActivityMomentsBinding


class MomentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMomentsBinding
    //instance of the MomentViewModel
    private val momentsViewModel: MomentsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMomentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setting the title for the first moment in the list
        val firstTitle = momentsViewModel.currentTitle
        binding.titleTextView.text = firstTitle

        //setting the first moment in the list
        val firstMoment = momentsViewModel.currentMoment
        binding.momentTextView.text = firstMoment

        //setting the timeStamp
        val firstTimeStamp = momentsViewModel.currentTimeStamp
        binding.timeStampView.text = firstTimeStamp

        //nextButton
        binding.nextButton.setOnClickListener {
            updateNextQuestion()
        }

        //previousButton
        binding.prevButton.setOnClickListener {
                updatePrevQuestion()
        }



    }

    private fun updateNextQuestion() {
        // Check if there are more moments to navigate to
        if (momentsViewModel.currentIndex < momentsViewModel.listSize - 1) {
            // Update the index to show the next moment
            momentsViewModel.nextMoment()

            // Get the updated data from the ViewModel
            val currentTitleId = momentsViewModel.currentTitle
            val currentMomentId = momentsViewModel.currentMoment
            val currentTimeStamp = momentsViewModel.currentTimeStamp

            // Update the UI with the next moment's data
            binding.titleTextView.text = currentTitleId
            binding.momentTextView.text = currentMomentId
            binding.timeStampView.text = currentTimeStamp
        } else {
            // Show a Snackbar when already at the last moment
            Snackbar.make(
                binding.root,
                "You are already on the last moment",
                Snackbar.LENGTH_SHORT
            ).show()

        }
    }


    private fun updatePrevQuestion() {
        // calling the viewModel's prevMoment()
            momentsViewModel.prevMoment()

        if(momentsViewModel.currentIndex == 0) {
            // Show a Snackbar when already at the first moment
            Snackbar.make(
                binding.root,
                "You are already on the first moment",
                Snackbar.LENGTH_SHORT
            ).show()
        }
            // Get the updated data from the ViewModel
            val currentTitleId = momentsViewModel.currentTitle
            val currentMomentId = momentsViewModel.currentMoment
            val currentTimeStamp = momentsViewModel.currentTimeStamp

            // Update the UI with the previous moment's data
            binding.titleTextView.text = currentTitleId
            binding.momentTextView.text = currentMomentId
            binding.timeStampView.text = currentTimeStamp


    }
    }

