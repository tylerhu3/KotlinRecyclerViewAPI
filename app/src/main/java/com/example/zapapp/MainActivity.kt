
/**
 * ZapLabs HW:
 * Program grabs data from http://jsonplaceholder.typicode.com/photos
 * and then display it in a ListView */
package com.example.zapapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val retrofit = Retrofit.Builder() //Make the API request to grab data
                //Starting with Android 9 (API level 28), cleartext support is disabled by default.
                //This means all base should be https rather than http
            .baseUrl("https://jsonplaceholder.typicode.com") //base api page
                //add a converter to convert out json to objects
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        val api = retrofit.create(ApiService::class.java) //create the API based on APIService.kt
        //Below we will make the GET Request for: "http://jsonplaceholder.typicode.com/photos"
        api.fetchAllItems().enqueue(object : Callback<List<Item>> { //Callback after data is recieved
            //On Success, do:
            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                Toast.makeText(applicationContext, "Data retrieved successfully",
                    Toast.LENGTH_LONG).show();
                showData(response.body()!!) // show the recycler data
            }
            //On Failure, do
            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                //Notify user of failure
                Toast.makeText(applicationContext, "Fail to get data", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }

    /**
     * showData:
     * this function takes a list of "Item" put it in a adapter and
     * is then apply to the main's recycler_view to show the data on screen
     *
     * */
    private fun showData(body: List<Item>){ //body is the response body from API Call
        recycler_view.apply { // this is our recycler from main xml file
            layoutManager = LinearLayoutManager(this@MainActivity)
            // initialize adapter with data from API Call
            adapter = ZapAdapter(body)
        }
    }




}
