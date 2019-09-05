package com.tokodistributor.explore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.asksira.loopingviewpager.LoopingPagerAdapter
import com.squareup.picasso.Picasso

class HomeHighlightInfinitePagerAdapter(
    context: Context,
    itemList: ArrayList<String>,
    isInfinite: Boolean
) :
    LoopingPagerAdapter<String>(context, itemList, isInfinite) {

    override fun inflateView(viewType: Int, container: ViewGroup, listPosition: Int): View {
        return LayoutInflater.from(context)
            .inflate(R.layout.home_highlight_item_fragment, container, false)
    }

    override fun bindView(convertView: View, listPosition: Int, viewType: Int) {
        val imageTest = convertView.findViewById<ImageView>(R.id.img_homeHighlightItem)
        imageTest.run {
            Picasso
                .get()
                .load("https://ichef.bbci.co.uk/news/660/cpsprodpb/8EC5/production/_107194563_gettyimages-1129237482.jpg")
                .into(this)

            setOnClickListener {
            }
        }
    }
}