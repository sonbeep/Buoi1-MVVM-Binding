package com.example.hiltexample.ui.act

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.hiltexample.databinding.ActivityMainBinding
import com.example.hiltexample.ui.adapter.PostAdapter
import com.example.hiltexample.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rycPosts.adapter = adapter
        lifecycleScope.launch {
            viewModel.postPagingFlow.collectLatest {
                adapter.submitData(it)
            }
        }

        binding.notificationSwitch.apply {
            setLabel("Hihahiho")
            setSwitchChecked(true)
            setOnSwitchCheckedChangeListener { isChecked ->
                Toast.makeText(this@MainActivity, "kk $isChecked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}