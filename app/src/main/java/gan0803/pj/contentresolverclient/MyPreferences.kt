package gan0803.pj.contentresolverclient

class MyPreferences {
    companion object {
        public const val SAVED_STRING_KEY = "SavedStringKey"
        public const val SAVED_BOOLEAN_KEY = "SavedBooleanKey"
        public const val SAVED_INT_KEY = "SavedIntKey"
        public const val URI = "content://gan0803.pj.sharedpreferencestudy.provider/"
        public const val AUTHORITY = "gan0803.pj.sharedpreferencestudy.provider"

        public const val GET_STRING_PREFERENCE_METHOD = "getStringPreference"
        public const val PUT_STRING_PREFERENCE_METHOD = "putStringPreference"
        public const val SAVE_PREFERENCE_METHOD = "savePreferences"
        public const val READ_PREFERENCE_METHOD = "readPreferences"
    }
}