package tifor.cal

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import tifor.cal.databinding.ActivitySactivityBinding

class SActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySactivityBinding
    private var pi = "3.141592653589793"
    private lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySactivityBinding.inflate(layoutInflater)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        window.navigationBarColor = resources.getColor(R.color.tiforColor)
        setContentView(binding.root)
        setFullScreen()

        if (loadColor() != resources.getColor(R.color.tiforColor)) {
            binding.buttonsLayout.setBackgroundColor(loadColor())
            window.navigationBarColor = loadColor()
        }


        binding.buttonS.setOnClickListener {

            try {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }

        }

        binding.button0.setOnClickListener {

            try {
                binding.solutionTv.append("0")

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }

        binding.button1.setOnClickListener {
            try {
                binding.solutionTv.append("1")

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }

        binding.button2.setOnClickListener {

            try {
                binding.solutionTv.append("2")

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }

        binding.button3.setOnClickListener {
            try {

                binding.solutionTv.append("3")
            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }

        binding.button4.setOnClickListener {
            try {
                binding.solutionTv.append("4")

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }

        binding.button5.setOnClickListener {
            try {
                binding.solutionTv.append("5")

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }

        binding.button6.setOnClickListener {
            try {
                binding.solutionTv.append("6")

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }

        binding.button7.setOnClickListener {
            try {
                binding.solutionTv.append("7")

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }

        binding.button8.setOnClickListener {
            try {
                binding.solutionTv.append("8")

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }

        binding.button9.setOnClickListener {
            try {
                binding.solutionTv.append("9")

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }


        binding.buttonAc.setOnClickListener {
            try {
                binding.solutionTv.text = null
                binding.resultTv.text = null

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }

        binding.buttonDelete.setOnClickListener(View.OnClickListener {
            val button = it as TextView
            val buttonText = button.text.toString()
            var dataToCalculate = binding.solutionTv.text.toString()

            try {
                dataToCalculate = if (buttonText == "⌫") {
                    dataToCalculate.substring(0, dataToCalculate.length - 1)
                } else {
                    dataToCalculate + buttonText
                }

                binding.solutionTv.text = dataToCalculate
                binding.resultTv.text = null
            } catch (e: Exception) {
                return@OnClickListener
            }
        })

        binding.buttonPlus.setOnClickListener {
            try {
                binding.solutionTv.text = binding.solutionTv.text.toString() + "+"

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }

        binding.buttonMinus.setOnClickListener {
            try {
                binding.solutionTv.text = binding.solutionTv.text.toString() + "-"

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }

        binding.buttonMultiply.setOnClickListener {
            try {
                binding.solutionTv.text = binding.solutionTv.text.toString() + "×"

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }

        binding.buttonPersent.setOnClickListener {
            try {
                val currentText = binding.solutionTv.text.toString()
                val updatedText = if (currentText.isNotEmpty()) {
                    val value = currentText.toDouble() / 100
                    value.toString()
                } else {
                    ""
                }
                binding.solutionTv.text = updatedText
                binding.resultTv.text = currentText + "%"
            } catch (e: Exception) {
                return@setOnClickListener
            }
        }


        binding.buttonDot.setOnClickListener {

            try {
                binding.solutionTv.append(".")

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }


        }

        binding.buttonDivide.setOnClickListener {
            try {
                binding.solutionTv.text = binding.solutionTv.text.toString() + "÷"

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }

        binding.bsqrt.setOnClickListener(View.OnClickListener {
            try {
                val value = binding.solutionTv.text.toString()
                val r = Math.sqrt(value.toDouble())
                binding.solutionTv.text = r.toString()
            } catch (e: Exception) {
                return@OnClickListener
            }
        })

        binding.bb1.setOnClickListener {
            try {
                binding.solutionTv.text = binding.solutionTv.text.toString() + "("

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }

        binding.bb2.setOnClickListener {
            try {
                binding.solutionTv.text = binding.solutionTv.text.toString() + ")"

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }

        binding.bpi.setOnClickListener(View.OnClickListener {
            try {
                binding.solutionTv.text = binding.solutionTv.text.toString() + pi
            } catch (e: Exception) {
                return@OnClickListener
            }
        })

        binding.bsin.setOnClickListener(View.OnClickListener {
            try {
                binding.solutionTv.text = binding.solutionTv.text.toString() + "sin"
            } catch (e: Exception) {
                return@OnClickListener
            }
        })

        binding.bcos.setOnClickListener(View.OnClickListener {
            try {
                binding.solutionTv.text = binding.solutionTv.text.toString() + "cos"
            } catch (e: Exception) {
                return@OnClickListener
            }
        })

        binding.bln.setOnClickListener(View.OnClickListener {
            try {
                binding.solutionTv.text = binding.solutionTv.text.toString() + "ln"
            } catch (e: Exception) {
                return@OnClickListener
            }
        })

        binding.blog.setOnClickListener {
            try {
                binding.solutionTv.text = binding.solutionTv.text.toString() + "log"

            } catch (e: Exception) {

                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()

            }
        }

        binding.btan.setOnClickListener(View.OnClickListener {
            try {
                binding.solutionTv.text = binding.solutionTv.text.toString() + "tan"
            } catch (e: Exception) {
                return@OnClickListener
            }
        })

        binding.binv.setOnClickListener(View.OnClickListener {
            try {
                binding.solutionTv.text = binding.solutionTv.text.toString() + "^" + "-1"
            } catch (e: Exception) {
                return@OnClickListener
            }
        })

        binding.bfact.setOnClickListener(View.OnClickListener {
            try {
                val value = binding.solutionTv.text.toString().toInt()
                val fact = factorial(value)
                binding.solutionTv.text = fact.toString()
                binding.resultTv.text = "$value!"
            } catch (e: Exception) {
                return@OnClickListener
            }
        })

        binding.bsquare.setOnClickListener(View.OnClickListener {
            try {
                val d = binding.solutionTv.text.toString().toDouble()
                val square = d * d
                binding.solutionTv.text = square.toString()
                binding.resultTv.text = "$d²"
            } catch (e: Exception) {
                return@OnClickListener
            }
        })

        binding.buttonEcual.setOnClickListener(View.OnClickListener {
            try {
                val value = binding.solutionTv.text.toString()
                val replacedStr = value.replace('÷', '/').replace('×', '*')
                val result = eval(replacedStr)
                binding.solutionTv.text = result.toString()
                binding.resultTv.text = value
            } catch (e: Exception) {
                binding.solutionTv.text = e.message
            }
        })
    }

    // Custom factorial function
    fun factorial(n: Int): Int {
        return if (n == 1 || n == 0) 1 else n * factorial(n - 1)
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

    override fun onStart() {
        super.onStart()
        if (loadColor() != resources.getColor(R.color.tiforColor)) {
            binding.buttonsLayout.setBackgroundColor(loadColor())
            window.navigationBarColor = loadColor()
        }
    }

    private fun loadColor(): Int {
        sharedPreferences = getSharedPreferences("color", MODE_PRIVATE)
        return sharedPreferences.getInt("myColor", resources.getColor(R.color.tiforColor))
    }

    companion object {
        // eval function
        fun eval(str: String): Double {
            return object : Any() {
                var pos = -1
                var ch = 0

                fun nextChar() {
                    ch = if (++pos < str.length) str[pos].code else -1
                }

                fun eat(charToEat: Int): Boolean {
                    while (ch == ' '.code) nextChar()
                    if (ch == charToEat) {
                        nextChar()
                        return true
                    }
                    return false
                }

                fun parse(): Double {
                    nextChar()
                    val x = parseExpression()
                    if (pos < str.length) throw RuntimeException("Unexpected For {Tifor}: " + ch.toChar())
                    return x
                }

                // Grammar:
                // expression = term | expression `+` term | expression `-` term
                // term = factor | term `*` factor | term `/` factor
                // factor = `+` factor | `-` factor | `(` expression `)`
                //        | number | functionName factor | factor `^` factor
                fun parseExpression(): Double {
                    var x = parseTerm()
                    while (true) {
                        if (eat('+'.code)) x += parseTerm() // addition
                        else if (eat('-'.code)) x -= parseTerm() // subtraction
                        else return x
                    }
                }

                fun parseTerm(): Double {
                    var x = parseFactor()
                    while (true) {
                        if (eat('*'.code)) x *= parseFactor() // multiplication
                        else if (eat('/'.code)) x /= parseFactor() // division
                        else return x
                    }
                }

                fun parseFactor(): Double {
                    if (eat('+'.code)) return parseFactor() // unary plus
                    if (eat('-'.code)) return -parseFactor() // unary minus

                    var x: Double
                    val startPos = pos
                    if (eat('('.code)) { // parentheses
                        x = parseExpression()
                        eat(')'.code)
                    } else if (ch in '0'.code..'9'.code || ch == '.'.code) { // numbers
                        while (ch in '0'.code..'9'.code || ch == '.'.code) nextChar()
                        x = str.substring(startPos, pos).toDouble()
                    } else if (ch in 'a'.code..'z'.code) { // functions
                        while (ch in 'a'.code..'z'.code) nextChar()
                        val func = str.substring(startPos, pos)
                        x = parseFactor()
                        x = when (func) {
                            "sqrt" -> Math.sqrt(x)
                            "sin" -> Math.sin(Math.toRadians(x))
                            "cos" -> Math.cos(Math.toRadians(x))
                            "tan" -> Math.tan(Math.toRadians(x))
                            "ln" -> Math.log(x)
                            "log" -> Math.log10(x)
                            else -> throw RuntimeException("Unknown function: $func")
                        }
                    } else {
                        throw RuntimeException("Unexpected: " + ch.toChar())
                    }

                    if (eat('^'.code)) x = Math.pow(x, parseFactor()) // exponentiation

                    return x
                }
            }.parse()
        }
    }
}