package Task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("cat", "dog", "owl", "dog", "cat", "horse",
                "goose", "mouse", "mouse", "bird", "snake", "elephant", "snowman", "lizard", "lizard", "spider",
                "butterfly", "bear", "bison", "lion"));
        System.out.println("Все слова из ArrayList - words: " + words);

        // Уникальные слова с помощью HashSet;
        Set<String> uniqueWords = new HashSet<>(words);
        System.out.println("Уникальные слова из ArrayList - words: " + uniqueWords);

        // Подсчет количество уникальныx слов с помощью Map
        Map<String, Integer> wordsCount = new HashMap<>();
        for(String word : words){
            if(!wordsCount.containsKey(word)){
                wordsCount.put(word, 1);
            }else{
                wordsCount.put(word, wordsCount.get(word) + 1);
            }
        }

        // Количество раз каждое слово встречается
        for( Map.Entry<String, Integer> entry : wordsCount.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


    }
}
