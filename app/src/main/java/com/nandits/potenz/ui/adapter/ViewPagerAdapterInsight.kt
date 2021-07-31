package com.nandits.potenz.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nandits.potenz.R
import com.nandits.potenz.ui.insight.TestResultFragment
import com.nandits.potenz.ui.learn.ArticleFragment
import com.nandits.potenz.ui.learn.VideoFragment

class ViewPagerAdapterInsight(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val tabTitle = arrayOf(
        R.string.test_result,
//        R.string.progress,
    )
    
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment?= null
        when(position){
            0 -> fragment = TestResultFragment()
//            1 -> fragment = ArticleFragment()
        }
        return fragment as Fragment
    }
    
    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(tabTitle[position])
    }
    
    override fun getCount(): Int {
        return tabTitle.size
    }
}