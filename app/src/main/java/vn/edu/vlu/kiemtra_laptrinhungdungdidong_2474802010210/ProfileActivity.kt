package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802010210

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var lvSkills: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)
        lvSkills = findViewById(R.id.lvSkills)

        val email = intent.getStringExtra(EXTRA_EMAIL).orEmpty()
        tvEmail.text = getString(R.string.profile_email, email)

        btnLogout.setOnClickListener {
            finish()
        }

        val skills = listOf(
            "Kotlin Programming",
            "XML Layout Design",
            "Git/GitHub Management",
            "Intent Processing",
            "Android Architecture",
            "ListView and ArrayAdapter"
        )
        lvSkills.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, skills)

        lvSkills.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, skills[position], Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val EXTRA_EMAIL = "EXTRA_EMAIL"
    }
}
