package edu.adelphi.birthdayapp

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

// Tab Titles
private val TAB_TITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2
)


// Fragment Manager - Managing which fragment to display
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        if(position == 0)
            return BirthdayFragment.newInstance()
        else
            return AddBirthdayFragment.newInstance()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}