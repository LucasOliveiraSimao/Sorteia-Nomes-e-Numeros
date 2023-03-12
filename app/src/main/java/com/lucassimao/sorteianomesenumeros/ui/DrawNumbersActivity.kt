package com.lucassimao.sorteianomesenumeros.ui

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lucassimao.sorteianomesenumeros.R
import com.lucassimao.sorteianomesenumeros.databinding.ActivityDrawNumbersBinding
import com.lucassimao.sorteianomesenumeros.util.isEmptyOrNull

class DrawNumbersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDrawNumbersBinding

    private var initialNumber = 0
    private var finalNumber = 0
    private var howManyNumbers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawNumbersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRaffle.setOnClickListener {

            if (binding.etInitialNumber.isEmptyOrNull()) {
                showErrorAndRequestFocus(
                    binding.etInitialNumber,
                    getString(R.string.initial_number_field_cannot_be_empty)
                )
            } else if (binding.etFinalNumber.isEmptyOrNull()) {
                showErrorAndRequestFocus(
                    binding.etFinalNumber,
                    getString(R.string.final_number_field_cannot_be_empty)
                )
            } else if (binding.etHowManyNumbers.isEmptyOrNull()) {
                showErrorAndRequestFocus(
                    binding.etHowManyNumbers,
                    getString(R.string.field_cannot_be_empty)
                )
            }

            val initialNumberInput = binding.etInitialNumber.text.toString()
            if (!initialNumberInput.isValidInt()) {
                return@setOnClickListener
            }
            initialNumber = initialNumberInput.toIntOrOne()

            val finalNumberInput = binding.etFinalNumber.text.toString()
            if (!finalNumberInput.isValidInt()) {
                return@setOnClickListener
            }
            finalNumber = finalNumberInput.toIntOrOne()

            val howManyNumbersInput = binding.etHowManyNumbers.text.toString()
            if (!howManyNumbersInput.isValidInt()) {
                return@setOnClickListener
            }
            howManyNumbers = howManyNumbersInput.toIntOrOne()

            if (checkInitialNumber(initialNumber, finalNumber)) {
                val numbers = drawNumbers(initialNumber, finalNumber, howManyNumbers).toString()
                binding.txtResult.text = numbers
            } else {
                Toast.makeText(
                    this,
                    getString(R.string.the_starting_number_is_greater_than_the_ending_number),
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

    }

    private fun checkInitialNumber(initial: Int, final: Int): Boolean {
        return initial <= final
    }

    private fun showErrorAndRequestFocus(editText: EditText, errorMessage: String) {
        editText.requestFocus()
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }

    private fun String?.isValidInt(): Boolean {
        return this != null && this.isNotBlank() && this.toIntOrNull() != null
    }

    private fun String.toIntOrOne(): Int {
        return this.toIntOrNull() ?: 1
    }

    private fun drawNumbers(start: Int, end: Int, count: Int): List<Int> {

        val range = (start..end).toList()

        return range.shuffled().take(count)
    }

}