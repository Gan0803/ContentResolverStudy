package gan0803.pj.contentresolverclient

import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uri = Uri.parse(MyPreferences.URI);
        val cr = contentResolver
        val auth = MyPreferences.AUTHORITY
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            cr.call(auth, MyPreferences.READ_PREFERENCE_METHOD, null, null)
        } else {
            cr.call(uri, MyPreferences.READ_PREFERENCE_METHOD, null, null)
        }
        // TODO bundleでデータ受け渡し。戻り値でも行ける？
    }
}