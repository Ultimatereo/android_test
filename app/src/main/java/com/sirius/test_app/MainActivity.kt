package com.sirius.test_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.sirius.test_app.databinding.ActivityMainBinding
import com.sirius.test_app.databinding.ReviewBinding
import com.sirius.test_app.databinding.TagBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val dataModel = DataModel()
        binding.gameImage.load(dataModel.image)
        binding.logoImage.load(dataModel.logo)
        binding.nameOfTheGame.text = dataModel.name
        binding.numberOfPlayers.text = dataModel.gradeCnt
        binding.description.text = dataModel.description
        val s = "${dataModel.gradeCnt} Reviews"
        binding.rate.text = dataModel.rating.toString()
        binding.ratingBar.rating = dataModel.rating
        binding.ratingBar1.rating = dataModel.rating
        binding.mReviews.text = s
        binding.buttonInstall.text = dataModel.action.name

        dataModel.tags.forEach { tag ->
            val tagBinding = TagBinding.inflate(layoutInflater)
            tagBinding.textView.text = tag
            binding.tagsLinearLayout.addView(tagBinding.root)
        }

        dataModel.reviews.forEach { review ->
            val reviewBinding = ReviewBinding.inflate(layoutInflater)
            reviewBinding.userImageView.load(review.userImage)
            reviewBinding.dateTextView.text = review.date
            reviewBinding.messageTextView.text = review.message
            reviewBinding.userNameTextView.text = review.userName
            binding.reviewsLinearLayout.addView(reviewBinding.root)
        }

    }
}