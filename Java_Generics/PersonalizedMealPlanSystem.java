import java.util.ArrayList;
import java.util.List;


interface MealPlan {
    void displayMeal();
}


//Meal Plans
class VegetarianMeal implements MealPlan {
    private String mealName;
    
    public VegetarianMeal(String mealName) {
        this.mealName = mealName;
    }
    
    @Override
    public void displayMeal() {
        System.out.println("Vegetarian Meal: " + mealName);
    }
}

class VeganMeal implements MealPlan {
    private String mealName;
    
    public VeganMeal(String mealName) {
        this.mealName = mealName;
    }
    
    @Override
    public void displayMeal() {
        System.out.println("Vegan Meal: " + mealName);
    }
}

class KetoMeal implements MealPlan {
    private String mealName;
    
    public KetoMeal(String mealName) {
        this.mealName = mealName;
    }
    
    @Override
    public void displayMeal() {
        System.out.println("Keto Meal: " + mealName);
    }
}

class HighProteinMeal implements MealPlan {
    private String mealName;
    
    public HighProteinMeal(String mealName) {
        this.mealName = mealName;
    }
    
    @Override
    public void displayMeal() {
        System.out.println("High Protein Meal: " + mealName);
    }
}



class Meal<T extends MealPlan> {
    private List<T> mealList = new ArrayList<>();
    
    public void addMeal(T meal) {
        mealList.add(meal);
    }
    
    public void showMeals() {
        for (T meal : mealList) {
            meal.displayMeal();
        }
    }
}


class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(T meal) {
        System.out.println("Generating a personalized meal plan for: ");
        meal.displayMeal();
    }
}


public class PersonalizedMealPlanSystem {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMealPlan = new Meal<>();
        vegetarianMealPlan.addMeal(new VegetarianMeal("Grilled Veggie Sandwich"));
        vegetarianMealPlan.addMeal(new VegetarianMeal("Mixed Bean Salad"));
        
        Meal<VeganMeal> veganMealPlan = new Meal<>();
        veganMealPlan.addMeal(new VeganMeal("Tofu Stir Fry"));
        veganMealPlan.addMeal(new VeganMeal("Vegan Buddha Bowl"));
        
        Meal<KetoMeal> ketoMealPlan = new Meal<>();
        ketoMealPlan.addMeal(new KetoMeal("Grilled Chicken with Avocado"));
        ketoMealPlan.addMeal(new KetoMeal("Zucchini Noodles with Pesto"));
        
        Meal<HighProteinMeal> highProteinMealPlan = new Meal<>();
        highProteinMealPlan.addMeal(new HighProteinMeal("Salmon with Quinoa"));
        highProteinMealPlan.addMeal(new HighProteinMeal("Egg Omelette with Cheese"));

        System.out.println("Vegetarian Meal Plan:");
        vegetarianMealPlan.showMeals();

        System.out.println("\nVegan Meal Plan:");
        veganMealPlan.showMeals();

        System.out.println("\nKeto Meal Plan:");
        ketoMealPlan.showMeals();

        System.out.println("\nHigh Protein Meal Plan:");
        highProteinMealPlan.showMeals();

        System.out.println("\nPersonalized Meal Plan Generation:");
        MealPlanGenerator.generateMealPlan(new VeganMeal("Vegan Smoothie"));
        MealPlanGenerator.generateMealPlan(new HighProteinMeal("Steak with Broccoli"));
    }
}
