package com.masai.sainath.wallpaperx.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.masai.sainath.wallpaperx.R
import com.masai.sainath.wallpaperx.databinding.ActivityMainBinding
import com.masai.sainath.wallpaperx.fragments.DownloadFragment
import com.masai.sainath.wallpaperx.fragments.HomeFragment

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
      //  requestWindowFeature(Window.FEATURE_NO_TITLE);
     //   this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(binding.root)

        replaceFragment(HomeFragment())

        binding.homefragment.setOnClickListener( View.OnClickListener {
            replaceFragment(HomeFragment())
        })

        binding.downloadfragment.setOnClickListener( View.OnClickListener {
            replaceFragment(DownloadFragment())


        })
    }
    fun replaceFragment( fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.flcontainer, fragment).commit()

    }
}