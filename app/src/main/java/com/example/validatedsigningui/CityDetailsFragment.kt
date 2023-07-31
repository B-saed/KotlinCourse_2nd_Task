package com.example.validatedsigningui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CityDetailsFragment : Fragment() {

    private lateinit var cityDetailsView: View
    private lateinit var backButton: FloatingActionButton
    private lateinit var cityImg : ImageView
    private lateinit var cityName: TextView
    private lateinit var cityReviewsString: TextView
    private lateinit var cityDescription: TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        cityDetailsView = inflater.inflate(R.layout.fragment_city_details, container, false)
        return cityDetailsView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        fillData()

    }




    private fun initView(){
        cityImg = cityDetailsView.findViewById(R.id.cityImageView)
        cityName = cityDetailsView.findViewById(R.id.textViewCityName)
        cityReviewsString = cityDetailsView.findViewById(R.id.textViewReviewsString)
        cityDescription = cityDetailsView.findViewById(R.id.textViewDescription)
        backButton = cityDetailsView.findViewById(R.id.floatingActionButtonBack)
        backButton.setOnClickListener{
            Navigation.findNavController(cityDetailsView).navigate(R.id.action_cityDetailsFragment_to_homeFragment)
        }
    }

    private fun fillData() {
        cityImg.setImageResource(globalCity!!.img!!)
        cityName.text = globalCity!!.title
        cityReviewsString.text = globalCity!!.reviewsString
        cityDescription.text = globalCity!!.description
    }
}