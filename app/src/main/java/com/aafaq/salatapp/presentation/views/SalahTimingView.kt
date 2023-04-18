package com.aafaq.salatapp.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.aafaq.network.data.models.salah.Data
import com.aafaq.salatapp.R
import com.aafaq.salatapp.databinding.SalahTimeRecyclerViewBinding
import com.airbnb.lottie.LottieAnimationView

class SalahTimingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
    private val binding: SalahTimeRecyclerViewBinding
    private val salahTimeRecyclerView: RecyclerView

    init{
        binding = SalahTimeRecyclerViewBinding.inflate(LayoutInflater.from(context), this, true)
        salahTimeRecyclerView = binding.recyclerViewSalahTime
    }

    fun setSalahMenuItems(
        data: List<Data>,
        salahTimeClickListener: SalahTimeClickListener? = null){

        binding.recyclerViewSalahTime.apply {
            this.adapter = SalahTimeAdapter(
                context,
                data,
                salahTimeClickListener,
                binding
            )
        }
    }

}

private class SalahTimeAdapter(
    val context: Context,
    val data: List<Data>,
    val sideMenuItemListener: SalahTimeClickListener? = null,
    val binding: SalahTimeRecyclerViewBinding
): RecyclerView.Adapter<SalahTimeAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_prayer_time, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = data[position]

        //send Click event
        holder.rootView.setOnClickListener {
            sideMenuItemListener?.onItemClicked(currentItem, position)
        }

        //send long click Event
        holder.rootView.setOnLongClickListener {
            sideMenuItemListener?.onItemLongClicked(currentItem, position)
            true
        }

        //set State
        holder.buttonState.setOnClickListener {
            Toast.makeText(context, "State Button Clicked", Toast.LENGTH_SHORT).show()
        }

        //map text views
        holder.textViewHour.text = "5"
        holder.textViewMinutes.text = "25"
        holder.textViewStreaks.text = "10"
        holder.textViewButtonState.text = "Confirmed"
        holder.textViewSalahHeading.text = currentItem.timings?.Fajr
        holder.textViewSalahTimeRemaining.text = "3 Hours Remaining in Salah"

        //set animations
        holder.salahTimeLottie.apply {
            setMaxProgress(if(position % 2 == 0) 0.5f else 0.2f)
            resumeAnimation()
        }
    }
    override fun getItemCount() = data.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
      val rootView: RelativeLayout = view.findViewById(R.id.salah_item_root)
      val buttonState: RelativeLayout = view.findViewById(R.id.button_set_state)
      val textViewHour: TextView = view.findViewById(R.id.text_view_hour)
      val textViewMinutes: TextView = view.findViewById(R.id.text_view_min)
      val textViewStreaks: TextView = view.findViewById(R.id.text_view_streak_days)
      val textViewButtonState: TextView = view.findViewById(R.id.text_view_set_state)
      val textViewSalahHeading: TextView = view.findViewById(R.id.salah_heading)
      val textViewSalahTimeRemaining: TextView = view.findViewById(R.id.text_view_salah_time_remaining)
      val salahTimeLottie: LottieAnimationView = view.findViewById(R.id.lottie_animation_day_night)
    }
}

interface SalahTimeClickListener {
    fun onItemClicked(item: Data, position: Int)
    fun onItemLongClicked(item: Data, position: Int)
}