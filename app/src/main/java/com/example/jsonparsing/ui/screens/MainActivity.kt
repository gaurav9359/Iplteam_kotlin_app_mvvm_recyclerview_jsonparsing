package com.example.jsonparsing.ui.screens

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.jsonparsing.databinding.ActivityMainBinding
import com.example.jsonparsing.ui.adapters.TeamAdapter
import com.example.jsonparsing.ui.viewmodels.TeamViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding;
    private lateinit var adapter: TeamAdapter
    private val viewModel:TeamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = TeamAdapter(viewModel.parseJsonFromAssets(this))
        binding.rv.layoutManager = GridLayoutManager(this, 1)
        binding.rv.adapter = adapter
    }
}