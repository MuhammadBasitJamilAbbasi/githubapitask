package com.github.myapplication


import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.myapplication.Adpaters.UserAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchGitHubUsers()
    }

    private fun fetchGitHubUsers() {
        lifecycleScope.launch {
            try {
                // Execute the network request
                val response = RetrofitInstance.api.getUsers()

                // Check if the response is successful
                if (response.size>0) {

                    // Initialize the adapter with the list of users
                    userAdapter = UserAdapter(response) { user ->
                        val intent = Intent(this@MainActivity, Detailprofile::class.java).apply {
                            putExtra("USER", user as Parcelable)
                        }
                        startActivity(intent)
                    }
                    // Set the adapter to the RecyclerView
                    recyclerView.adapter = userAdapter
                } else {
                    // Handle HTTP errors
                    Log.e("GitHubService", "HTTP Error: ${response} }")
                    // Optionally show an error message to the user
                }
            } catch (e: Exception) {
                // Handle network or other exceptions
                Log.e("GitHubService", "Exception: ${e.message}")
                // Optionally show an error message to the user
            }
        }
    }

}