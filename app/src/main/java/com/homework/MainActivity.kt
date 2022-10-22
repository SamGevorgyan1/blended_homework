package com.homework

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val datePickerActivity = DatePickerActivity()
    private val timePickerActivity = TimePickerActivity()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val popupMenuButton = findViewById<AppCompatButton>(R.id.popupMenu_button_id)

        popupMenuButton.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.date_picker_id -> {
                intent(datePickerActivity)
                true
            }
            R.id.time_picker_id -> {
                intent(timePickerActivity)
                true
            }
            R.id.exit_id -> exitProcess(-1)

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun intent(activity: Activity) {
        val intent = Intent(this@MainActivity, activity::class.java)
        startActivity(intent)
    }

    private fun makeToast(item: String) {
        Toast.makeText(this@MainActivity, "You clicked: $item", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        val popupMenu = PopupMenu(this, v)
        popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.open_id -> makeToast(item.title as String)
                R.id.copy_id -> makeToast(item.title as String)
            }
            true
        }
        popupMenu.show()
    }
}

