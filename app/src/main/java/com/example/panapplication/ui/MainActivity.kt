package com.example.panapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.panapplication.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel= ViewModelProvider(this). get(MainViewModel::class.java)
        observData()
    }

    private fun observData() {
        viewModel.getResponse().observe(this, Observer {
            if (it== "Success"){
                Toast.makeText(this, "Details Submitted", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun checkValidation(view: View) {
        if (editPanCard.text.isNullOrEmpty()){
            Toast.makeText(this, "Please Submit Pancard Number", Toast.LENGTH_SHORT).show()
        }else if (editDate.text.isNullOrEmpty()&& editMonth.text.isNullOrEmpty() && editYear.text.isNullOrEmpty()){
            Toast.makeText(this, "Please enter Date of birth", Toast.LENGTH_SHORT).show()
        }else {
            viewModel.saveData(editPanCard.text.toString(), "${editDate.text}/${editMonth.text}/${editYear.text}")
        }
    }
    fun backScreen(view: View) {
        onBackPressed()
    }
}