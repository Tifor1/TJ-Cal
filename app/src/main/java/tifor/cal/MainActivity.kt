package tifor.cal

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable
import tifor.cal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var data: String
    private lateinit var sharedPreferences: SharedPreferences


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFullScreen()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // bottom navigration color
        window.navigationBarColor = resources.getColor(R.color.tiforColor)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        perm()
        if (loadColor() != resources.getColor(R.color.tiforColor)) {
            binding.buttonsLayout.setBackgroundColor(loadColor())
            window.navigationBarColor = loadColor()
        }

        binding.settings.setOnClickListener {
            try {
                val intent = Intent(applicationContext, SettingActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                binding.resultTv.setText(e.message)
            }
        }
        binding.button0.setOnClickListener(View.OnClickListener {
            data = binding.solutionTv.getText().toString()
            binding.solutionTv.setText(data + "0")
        })
        binding.button1.setOnClickListener(View.OnClickListener {
            data = binding.solutionTv.getText().toString()
            binding.solutionTv.setText(data + "1")
        })
        binding.button2.setOnClickListener(View.OnClickListener {
            data = binding.solutionTv.getText().toString()
            binding.solutionTv.setText(data + "2")
        })
        binding.button3.setOnClickListener(View.OnClickListener {
            data = binding.solutionTv.getText().toString()
            binding.solutionTv.setText(data + "3")
        })
        binding.button4.setOnClickListener(View.OnClickListener {
            data = binding.solutionTv.getText().toString()
            binding.solutionTv.setText(data + "4")
        })
        binding.button5.setOnClickListener(View.OnClickListener {
            data = binding.solutionTv.getText().toString()
            binding.solutionTv.setText(data + "5")
        })
        binding.button6.setOnClickListener(View.OnClickListener {
            data = binding.solutionTv.getText().toString()
            binding.solutionTv.setText(data + "6")
        })
        binding.button7.setOnClickListener(View.OnClickListener {
            data = binding.solutionTv.getText().toString()
            binding.solutionTv.setText(data + "7")
        })
        binding.button8.setOnClickListener(View.OnClickListener {
            data = binding.solutionTv.getText().toString()
            binding.solutionTv.setText(data + "8")
        })
        binding.button9.setOnClickListener(View.OnClickListener {
            data = binding.solutionTv.getText().toString()
            binding.solutionTv.setText(data + "9")
        })
        binding.buttonAc.setOnClickListener(View.OnClickListener {
            binding.solutionTv.setText(null)
            binding.resultTv.setText(null)
        })
        binding.buttonDot.setOnClickListener(View.OnClickListener {
            data = binding.solutionTv.getText().toString()
            binding.solutionTv.setText("$data.")
        })
        binding.buttonPlus.setOnClickListener(View.OnClickListener {
            data = binding.solutionTv.getText().toString()
            binding.solutionTv.setText("$data+")
        })
        binding.buttonMinus.setOnClickListener(View.OnClickListener {
            data = binding.solutionTv.getText().toString()
            binding.solutionTv.setText("$data-")
        })
        binding.buttonPersent.setOnClickListener(View.OnClickListener {
            data = binding.solutionTv.getText().toString()
            binding.solutionTv.setText("$data%")
        })
        binding.buttonMultiply.setOnClickListener(View.OnClickListener {
            data = binding.solutionTv.getText().toString()
            binding.solutionTv.setText("$data×")
        })
        binding.buttonDivide.setOnClickListener(View.OnClickListener {
            data = binding.solutionTv.getText().toString()
            binding.solutionTv.setText("$data÷")
        })
        binding.buttonS.setOnClickListener(View.OnClickListener {
            try {
                val intent = Intent(applicationContext, SActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                binding.resultTv.setText(e.message)
            }
        })
        binding.buttonDelete.setOnClickListener(View.OnClickListener {
            val button = it as TextView
            val buttenText = button.text.toString()
            var dataTOCalculate = binding.solutionTv.getText().toString()
            try {
                dataTOCalculate = if (buttenText == "⌫") {
                    dataTOCalculate.substring(0, dataTOCalculate.length - 1)
                } else {
                    dataTOCalculate + buttenText
                }
                binding.solutionTv.setText(dataTOCalculate)
                binding.resultTv.setText(null)

                /* String finalResult = getResult(dataTOCalculate);
    
                        if (!finalResult.equals("Err")) {
                            outPuttxt.setText(finalResult);
                        }*/
            } catch (e: Exception) {
                return@OnClickListener
            }
        })
        binding.buttonEcual.setOnClickListener(View.OnClickListener {
            try {
                data = binding.solutionTv.getText().toString()
                data = data.replace("×".toRegex(), "*")
                data = data.replace("%".toRegex(), "/100")
                data = data.replace("÷".toRegex(), "/")
                val rhino = Context.enter()
                rhino.optimizationLevel = -1
                var finalResult: String
                val scriptable: Scriptable = rhino.initStandardObjects()
                finalResult = rhino.evaluateString(scriptable, data, "Tifor", 1, null).toString()
                if (finalResult.endsWith(".0")) {
                    finalResult = finalResult.replace(".0", "")
                }
                binding.resultTv.setText(finalResult)
            } catch (e: Exception) {
                binding.resultTv.setText(e.message)
            }
        })
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

    private fun perm() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val permissionNotif = ActivityCompat.checkSelfPermission(
                this@MainActivity, Manifest.permission.POST_NOTIFICATIONS
            )
            if (permissionNotif != PackageManager.PERMISSION_GRANTED) {
                val NOTIF_PERM = arrayOf(Manifest.permission.POST_NOTIFICATIONS)
                ActivityCompat.requestPermissions(this, NOTIF_PERM, 10)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        perm()
        if (loadColor() != resources.getColor(R.color.tiforColor)) {
            binding.buttonsLayout.setBackgroundColor(loadColor())
            window.navigationBarColor = loadColor()
        }
    }

    private fun loadColor(): Int {
        sharedPreferences = getSharedPreferences("color", MODE_PRIVATE)
        return sharedPreferences.getInt("myColor", resources.getColor(R.color.tiforColor))
    }
}