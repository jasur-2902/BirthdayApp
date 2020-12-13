package edu.adelphi.birthdayapp

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddBirthdayFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Getting Context from Main Activity
        val view = inflater.inflate(R.layout.fragment_add_birthday, container, false)

        // Initializing UI elements
        val button: Button = view.findViewById(R.id.addBirthday);
        val etBirthday: EditText = view.findViewById(R.id.etBirthday);
        val etName: EditText = view.findViewById(R.id.etName);


        // Creating Event for button click
        button.setOnClickListener{

            // validating birthday field and name field
            if(validate(etBirthday) && validate(etName)) {
                // Creating birthday object
                Birthdays.addItem(
                    Birthdays.BirthdayObject(
                        etBirthday.text.toString(),
                        etName.text.toString()
                    )
                )

                // Removing keyboard
                val imm = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
                imm?.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)

                // clearing fields
                etBirthday.setText("");
                etName.setText("");

            }
            else {
                // If user input is invalid show a message
                Toast.makeText(view.context, "Please fill both fields!!!", Toast.LENGTH_LONG)
                    .show()
            }
        }

        // Inflate the layout for this fragment
        return view
    }


    /** validate: function checks user input, and if it's valid it returns true;
     * @param EditText object
     * @return Boolean
     */
    private fun validate(obj: EditText): Boolean {
        return obj.text.toString().trim().isNotEmpty()
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            AddBirthdayFragment().apply {

            }
    }
}