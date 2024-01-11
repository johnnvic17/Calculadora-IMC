package com.example.calculadoraimc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {

        if (view.id == R.id.btn_calculate) {

            calculate()
        }
    }

    private fun validate(): Boolean {

        return (binding.editWeight.text.toString() != ""
                && binding.editHeight.text.toString() != ""
                && binding.editWeight.text.toString().toFloat() != 0f
                && binding.editHeight.text.toString().toFloat() != 0f)
    }

    private fun calculate() {

        if (validate()) {

            val weight = binding.editWeight.text.toString().toFloat()
            val height = binding.editHeight.text.toString().toFloat()

            val imcCalc = weight / (height * height)

            binding.textImc.text = "IMC: ${"%.2f".format(imcCalc)}"

            if (imcCalc < 17) {

                binding.textResultImc.text = getResources().getString(R.string.result1)

            } else if (imcCalc <= 18.5) {

                binding.textResultImc.text = getResources().getString(R.string.result2)

            } else if (imcCalc < 25) {

                binding.textResultImc.text = getResources().getString(R.string.result3)

            } else if (imcCalc < 30) {

                binding.textResultImc.text = getResources().getString(R.string.result4)

            } else if (imcCalc < 35) {

                binding.textResultImc.text = getResources().getString(R.string.result5)

            } else if (imcCalc <= 40) {

                binding.textResultImc.text = getResources().getString(R.string.result6)

            } else if (imcCalc > 40) {

                binding.textResultImc.text = getResources().getString(R.string.result7)
            }

        } else {

            Toast.makeText(this, R.string.validate_fields, Toast.LENGTH_SHORT).show()
        }
    }
}