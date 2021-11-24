package com.madrat.shadowexample

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Rect
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.madrat.shadowexample.databinding.ActivityMainBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.BitmapDescriptorFactory

import com.google.android.gms.maps.model.MarkerOptions

import com.google.android.gms.maps.model.LatLng
import android.util.DisplayMetrics
import android.widget.LinearLayout
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private val appBarConfiguration: AppBarConfiguration? = null
    private lateinit var binding: ActivityMainBinding
    private var googleMap: GoogleMap? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }
    
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> {
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
    
    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main)
        return (NavigationUI.navigateUp(navController, appBarConfiguration!!)
            || super.onSupportNavigateUp())
    }
    
    private fun calculateDialogImageSideSize(percentFromHeight: Int): Int {
        val percentHeight = percentFromHeight.toFloat() / 100
        val displayMetrics = Resources.getSystem().displayMetrics
        val rect = displayMetrics.run { Rect(0, 0, widthPixels, heightPixels) }
        val finalHeight = rect.height() * percentHeight
        return finalHeight.toInt()
    }
    
    override fun onMapReady(map: GoogleMap) {
        this.googleMap = map
        
        val markerWidth = calculateDialogImageSideSize(4)
        
        val markerDrawable = ViewUtils.generateBackgroundWithShadow(
            this,
            R.color.redka,
            R.dimen.radius_corner,
            R.color.black_40,
            R.dimen.elevation,
            Gravity.BOTTOM
        ).toBitmap(
            markerWidth,
            (markerWidth + (markerWidth / 3.5)).toInt()
        )
        
        googleMap?.let {
            // Add a marker in Sydney and move the camera
            val sydney = LatLng(
                (-34).toDouble(),
                (151).toDouble()
            )
            it.addMarker(
                MarkerOptions()
                    .position(sydney)
                    .title("Marker in Sydney")
                    .icon(
                        BitmapDescriptorFactory.fromBitmap(
                            markerDrawable
                        )
                    )
            )
            it.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        }
    }
}