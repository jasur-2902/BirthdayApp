package edu.adelphi.birthdayapp

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing Birthday content for user interfaces created by
 */

object Birthdays {

    /**
     * An array of Birthday objects.
     */
    val ITEMS: MutableList<BirthdayObject> = ArrayList()


    /**
     * A map of birthday items, by ID.
     */
    private val ITEM_MAP: MutableMap<String, BirthdayObject> = HashMap()

    private val sampleName: ArrayList<String> = ArrayList()
    private val sampleBirthday: ArrayList<String> = ArrayList()

    private val COUNT = 2


    init {

        sampleName.add("Jasur")
        sampleBirthday.add("29/02/1900")

        sampleName.add("Giuseppe")
        sampleBirthday.add("26/07/1900")

        sampleName.add("Dan")
        sampleBirthday.add("09/09/1900")


        // Add some sample birthday.
        for (i in 0..COUNT) {
            addItem(
                createBirthdayObject(
                    sampleBirthday[i],
                    sampleName[i]
                )
            )
        }
    }

    fun addItem(item: BirthdayObject) {
        ITEMS.add(item)
        ITEM_MAP[item.birthday] = item
    }

    //
    private fun createBirthdayObject(birtday: String ,name: String): BirthdayObject {
        return BirthdayObject(
            birtday,
            name
        )
    }

    /**
     * An object representing name and birthday.
     */
    data class BirthdayObject(val birthday: String, val content: String) {
        override fun toString(): String = content
    }
}