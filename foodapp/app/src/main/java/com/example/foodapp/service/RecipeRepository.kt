import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.foodapp.RecipeDao
import com.example.foodapp.RecipeEntity
import com.example.foodapp.model.RecipeModel
import org.json.JSONArray
import java.io.InputStream

class RecipeRepository(private val recipeDao: RecipeDao) {
//    var recipeModels: ArrayList<RecipeModel> = ArrayList<RecipeModel>()
    val readAllData: LiveData<List<RecipeEntity>> = recipeDao.readRecipes()

    suspend fun addRecipe(recipeEntity: RecipeEntity) {
        recipeDao.addRecipe(recipeEntity)
    }
}

