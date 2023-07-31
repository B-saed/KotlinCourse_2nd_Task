package com.example.validatedsigningui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class CityAdapter(val context: Context? = null, var citiesList: ArrayList<CityDataClass>? = null) :
    RecyclerView.Adapter<CityAdapter.CityHolder>() {

    class CityHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cityImg: ImageView = itemView.findViewById<ImageView>(R.id.cityImgView)
        val cityName: TextView = itemView.findViewById<TextView>(R.id.textViewCityName)
        val reviewsString: TextView = itemView.findViewById<TextView>(R.id.textViewReviewsString)
        val cityConstraintLayout: ConstraintLayout = itemView.findViewById<ConstraintLayout>(R.id.constraintLayoutOfItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val view = LayoutInflater.from(context).inflate((R.layout.places_recycler_view), parent, false)
        return CityHolder(view)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        val currentCity = citiesList?.get(position)
        holder.cityImg.setImageResource(currentCity?.img!!)
        holder.cityName.text = currentCity.title!!
        holder.reviewsString.text = currentCity.reviewsString!!
       holder.cityConstraintLayout.setOnClickListener{
           globalCity = currentCity
           Navigation.findNavController(holder.itemView).navigate(R.id.action_homeFragment_to_cityDetailsFragment)
       }
    }

    override fun getItemCount(): Int {
        return citiesList!!.size
    }

}