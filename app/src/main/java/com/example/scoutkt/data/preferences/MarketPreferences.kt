import android.content.Context
import android.content.SharedPreferences
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

class MarketPreferences(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("market_pref", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveFavourite(user: String, fav: String) {
        // Recupera la lista attuale delle criptovalute preferite per l'utente
        val currentFavourites = getFavourites(user).toMutableList()

        // Aggiungi la nuova criptovaluta alla lista se non è già presente
        if (!currentFavourites.contains(fav)) {
            currentFavourites.add(fav)
        }

        // Salva la lista aggiornata
        val editor = sharedPreferences.edit()
        val favJson = gson.toJson(currentFavourites)
        editor.putString(user, favJson)
        editor.apply()
    }

    fun getFavourites(user: String): List<String> {
        val favJson = sharedPreferences.getString(user, null)
        return if (favJson != null) {
            gson.fromJson(favJson, object : TypeToken<List<String>>() {}.type)
        } else {
            emptyList()
        }
    }
}
