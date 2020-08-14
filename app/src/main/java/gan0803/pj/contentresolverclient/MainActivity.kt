package gan0803.pj.contentresolverclient

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uri = Uri.parse(MyPreferences.URI);
        val cr = contentResolver
        val auth = MyPreferences.AUTHORITY
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            cr.call(auth, MyPreferences.READ_PREFERENCE_METHOD, null, null)
            cr.call(
                auth,
                MyPreferences.PUT_STRING_PREFERENCE_METHOD,
                System.currentTimeMillis().toString(),
                null
            )
            val bundle = cr.call(auth, MyPreferences.GET_STRING_PREFERENCE_METHOD, null, null)
            val str: String = bundle?.getString(MyPreferences.SAVED_STRING_KEY) ?: ""
            Log.d(TAG, "get: $str")
        } else {
            cr.call(
                uri,
                MyPreferences.PUT_STRING_PREFERENCE_METHOD,
                System.currentTimeMillis().toString(),
                null
            )
            cr.call(uri, MyPreferences.READ_PREFERENCE_METHOD, null, null)
            val bundle = cr.call(uri, MyPreferences.GET_STRING_PREFERENCE_METHOD, null, null)
            val str: String = bundle?.getString(MyPreferences.SAVED_STRING_KEY) ?: ""
            Log.d(TAG, "get: $str")
        }
    }
}