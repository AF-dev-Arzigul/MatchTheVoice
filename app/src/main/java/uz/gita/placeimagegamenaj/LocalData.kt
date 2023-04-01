package uz.gita.placeimagegamenaj

import android.content.Context
import android.content.SharedPreferences

class LocalData {
    companion object {
        private lateinit var sharedPref: SharedPreferences
        fun getInstance(context: Context): SharedPreferences {
            if (!::sharedPref.isInitialized) sharedPref =
                context.getSharedPreferences("DATA", Context.MODE_PRIVATE)
            return sharedPref
        }

        fun levelUp() {
            sharedPref.edit().putInt("LEVEL", getLevel() + 1).apply()
        }

        fun getLevel(): Int {
            return sharedPref.getInt("LEVEL", 1)
        }

        fun coin(coin: Int) {
            sharedPref.edit().putInt("COINS", coin).apply()
        }

        fun coin(): Int {
            return sharedPref.getInt("COINS", 10)
        }


    }
}