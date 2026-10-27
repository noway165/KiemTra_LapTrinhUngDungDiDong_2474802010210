package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802010210

import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()

            val error = when {
                email.isEmpty() -> getString(R.string.err_empty_email)
                password.isEmpty() -> getString(R.string.err_empty_password)
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> getString(R.string.err_invalid_email)
                password.length < 6 -> getString(R.string.err_short_password)
                else -> null
            }

            if (error != null) {
                showStatus(error, Color.RED)
            } else {
                showStatus(getString(R.string.msg_validation_success), Color.rgb(0, 128, 0))
            }
        }
    }

    private fun showStatus(message: String, color: Int) {
        tvStatus.text = message
        tvStatus.setTextColor(color)
    }
}
