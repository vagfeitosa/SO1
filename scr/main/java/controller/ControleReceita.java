package controller;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ControleReceitas {
    public void exibirItaliano(String caminhoArquivo) {
        try {
            
            String content = new String(Files.readAllBytes(Paths.get(caminhoArquivo)));

            JSONObject jsonObject = new JSONObject(content);

            JSONArray recipes = jsonObject.getJSONArray("drinks");

            for (int i = 0; i < recipes.length(); i++) {
                JSONObject recipe = recipes.getJSONObject(i);

                String instructionsInItalian = recipe.getString("strInstructionsIT");

                System.out.println("Receita " + (i + 1) + ": " + instructionsInItalian);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
