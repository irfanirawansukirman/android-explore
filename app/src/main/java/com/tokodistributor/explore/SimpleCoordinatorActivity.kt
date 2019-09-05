package com.tokodistributor.explore

import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.asksira.loopingviewpager.LoopingViewPager
import com.google.android.material.appbar.AppBarLayout
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_simple_coordinator.*


class SimpleCoordinatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_coordinator)

        makeStatusBarTransparent()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_content)) { _, insets ->
            findViewById<Toolbar>(R.id.toolbar).setMarginTop(insets.systemWindowInsetTop)
            // view_home_topInset.layoutParams.height = insets.systemWindowInsetTop
            insets.consumeSystemWindowInsets()
        }

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler_simple_coor.apply {
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
            adapter = SimpleAdapter()
        }

        recycler_simple_coors.apply {
            layoutManager = LinearLayoutManager(
                this@SimpleCoordinatorActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            adapter = SimpleAdapter()
        }
        val window = window
        val transition = recycler_simple_coor.background as TransitionDrawable
        transition.startTransition(250)

//        appbar.addOnOffsetChangedListener(object : AppBarStateChangeListener() {
//            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?) {
//                when (state?.name) {
//                    "EXPANDED" -> {
////                        transition.startTransition(250)
//                    }
//                    "COLLAPSE" -> {
////                         transition.reverseTransition(250)
//                    }
//                    else -> {
//
//                    }
//                }
//            }
//        })

//        appbar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
//            var scrollRange = -1
//
//            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
//                //Initialize the size of the scroll
//                if (scrollRange == -1) {
//                    scrollRange = appBarLayout.totalScrollRange
//                }
//                //Check if the view is collapsed
//                if (scrollRange + verticalOffset == 0) {
//                    toolbar.setBackgroundColor(
//                        ContextCompat.getColor(
//                            this@SimpleCoordinatorActivity,
//                            android.R.color.white
//                        )
//                    )
//                    recycler_simple_coor.setBackgroundColor(
//                        ContextCompat.getColor(
//                            this@SimpleCoordinatorActivity,
//                            android.R.color.white
//                        )
//                    )
//
//// clear FLAG_TRANSLUCENT_STATUS flag:
//                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//
//// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
//                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//
//// finally change the color
//                    window.statusBarColor = ContextCompat.getColor(
//                        this@SimpleCoordinatorActivity,
//                        android.R.color.white
//                    )
//                } else {
//                    toolbar.setBackgroundColor(
//                        ContextCompat.getColor(
//                            this@SimpleCoordinatorActivity,
//                            android.R.color.transparent
//                        )
//                    )
//                    recycler_simple_coor.setBackgroundColor(
//                        ContextCompat.getColor(
//                            this@SimpleCoordinatorActivity,
//                            R.color.colorPrimary
//                        )
//                    )
//                    // clear FLAG_TRANSLUCENT_STATUS flag:
//                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//
//// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
//                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//
//// finally change the color
//                    window.statusBarColor = ContextCompat.getColor(
//                        this@SimpleCoordinatorActivity,
//                        android.R.color.transparent
//                    )
//                }
//            }
//        })

        setupHighlights()
        setupHighlightProductDefaultBlur("https://ichef.bbci.co.uk/news/660/cpsprodpb/8EC5/production/_107194563_gettyimages-1129237482.jpg")
    }

    private fun setupHighlightProductDefaultBlur(imageUrl: String) {
        img_home_highlightBlur.run {
            setZoom(25f)
            isEnabled = false
            Picasso
                .get()
                .load(imageUrl)
                .into(this)
        }
    }

    private fun setupHighlights() {
        val data = ArrayList<String>().apply {
            add("")
            add("")
            add("")
            add("")
            add("")
            add("")
            add("")
            add("")
            add("")
        }
        viewpager_highlight.apply {
            adapter = HomeHighlightInfinitePagerAdapter(this@SimpleCoordinatorActivity, data, true)
            setPadding(32, 8, 64, 4)
            clipToPadding = false
            pageMargin = 16

            setIndicatorPageChangeListener(object : LoopingViewPager.IndicatorPageChangeListener {
                override fun onIndicatorProgress(selectingPosition: Int, progress: Float) {
                }

                override fun onIndicatorPageChange(newIndicatorPosition: Int) {
                    try {
                        indicator.selection = newIndicatorPosition
                        setupHighlightProductDefaultBlur("https://ichef.bbci.co.uk/news/660/cpsprodpb/8EC5/production/_107194563_gettyimages-1129237482.jpg")
                    } catch (e: Exception) {

                    } finally {
                        indicator.selection = newIndicatorPosition
                    }
                }
            })
        }
    }
}
