import android.content.Context
import com.example.foodapp.R
import com.example.foodapp.dto.RecipeDTO
import com.example.foodapp.model.InstructionModel
import com.example.foodapp.model.RecipeModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader

class RecipeRepository {

    // Replace 'YourFileName.json' with the actual JSON file name in the assets directory
    private val fileName = "foodapp/app/src/main/res/raw/recipes.json"

    // Function to read JSON data from a file and parse it into a list of RecipeDTO objects
    private fun readJsonData(): List<RecipeDTO> {
        val inputStream = javaClass.classLoader?.getResourceAsStream(fileName)
        val reader = BufferedReader(InputStreamReader(inputStream))
        val json = reader.readText()
        val listType = object : TypeToken<List<RecipeDTO>>() {}.type
        return Gson().fromJson(json, listType)
    }

    // Function to provide a list of RecipeModel objects
    fun getRecipes(): List<RecipeModel> {
        val RecipeDTOs = readJsonData()
        return RecipeDTOs.map { it.toModel() }
    }

    fun getAllRecipes(context: Context): List<RecipeModel>? {
        val inputStream = context.resources.openRawResource(R.raw.recipes)
        val reader = BufferedReader(InputStreamReader(inputStream))
        val json = reader.readText()
        val listType = object : TypeToken<List<RecipeDTO>>() {}.type
        val RecipeDTOs = Gson().fromJson<List<RecipeDTO>>(json, listType)
        return RecipeDTOs.map { it.toModel() }
    }
}
