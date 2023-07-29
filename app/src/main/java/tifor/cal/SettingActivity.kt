package tifor.cal

import android.content.SharedPreferences
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import tifor.cal.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        window.navigationBarColor = resources.getColor(R.color.tifor2)
        setContentView(binding.root)
        setFullScreen()
        binding.tiforColor.setOnClickListener {
            storeColor(
                resources.getColor(R.color.tiforColor)
            )
        }
        binding.rubyColor.setOnClickListener { storeColor(resources.getColor(R.color.rubyColor)) }
        binding.paleMagenta.setOnClickListener { storeColor(resources.getColor(R.color.paleMagenta)) }
        binding.lightBlue.setOnClickListener { storeColor(resources.getColor(R.color.lightBlue)) }
        binding.pink.setOnClickListener { storeColor(resources.getColor(R.color.pink)) }
        binding.aquamarine.setOnClickListener { storeColor(resources.getColor(R.color.aquamarine)) }
        binding.night.setOnClickListener { storeColor(resources.getColor(R.color.night)) }
        binding.blueGray.setOnClickListener { storeColor(resources.getColor(R.color.blueGray)) }
        binding.ghostWhite.setOnClickListener { storeColor(resources.getColor(R.color.ghostWhite)) }
        binding.blueDiamond.setOnClickListener { storeColor(resources.getColor(R.color.blueDiamond)) }
        binding.neonYellowGreen.setOnClickListener { storeColor(resources.getColor(R.color.neonYellowGreen)) }
        binding.algaeGreen.setOnClickListener { storeColor(resources.getColor(R.color.algaeGreen)) }
        binding.loveRed.setOnClickListener { storeColor(resources.getColor(R.color.loveRed)) }
        binding.blush.setOnClickListener { storeColor(resources.getColor(R.color.blush)) }
        binding.deepRose.setOnClickListener { storeColor(resources.getColor(R.color.deepRose)) }
        binding.lightPink.setOnClickListener { storeColor(resources.getColor(R.color.lightPink)) }
        binding.fuchsiaPink.setOnClickListener { storeColor(resources.getColor(R.color.fuchsiaPink)) }
        binding.blossomPink.setOnClickListener { storeColor(resources.getColor(R.color.blossomPink)) }
        binding.lightCyan.setOnClickListener { storeColor(resources.getColor(R.color.lightCyan)) }
        binding.milkWhite.setOnClickListener { storeColor(resources.getColor(R.color.milkWhite)) }
        binding.lime.setOnClickListener { storeColor(resources.getColor(R.color.lime)) }
        binding.lightPurpleBlue.setOnClickListener { storeColor(resources.getColor(R.color.lightPurpleBlue)) }
        binding.chromeWhite.setOnClickListener { storeColor(resources.getColor(R.color.chromeWhite)) }
        binding.darkPink.setOnClickListener { storeColor(resources.getColor(R.color.darkPink)) }
        binding.lavender.setOnClickListener { storeColor(resources.getColor(R.color.lavender)) }
    }

    private fun setFullScreen() {
        try {
            supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        } catch (e: Exception) {
            return
        }
    }

    private fun storeColor(color: Int) {
        sharedPreferences = getSharedPreferences("color", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("myColor", color)
        editor.apply()
    }
}