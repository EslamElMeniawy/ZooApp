package elmeniawy.eslam.zoo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Get data
        val bundle = intent.extras
        tvName.text = bundle.getString("name")
        tvDescription.text = bundle.getString("description")
        ivImage.setImageResource(bundle.getInt("image"))
    }
}
