package Lab6;

import java.util.TreeMap;

public class TermFrequencyCalculator implements ITermFrequency {

    @Override
    public TreeMap<String, TreeMap<String, Double>> getTermFrequency(TreeMap<String, String> songLyrics) {
        TreeMap<String, TreeMap<String, Double>> result = new TreeMap<String, TreeMap<String, Double>> ();
        
        for(String songTitle: songLyrics.keySet())
        {
            // For each song you have to create TF values
            TreeMap<String, Double> tempMap = new TreeMap<String, Double>();

            // current lyrics
            String lyric = songLyrics.get(songTitle);
            String[] words = lyric.split(" ");
            
            // Calculate the Term Frequency (TF) Values here and save them in tempMap
            
            // You might need to introduce other methods and additional variables
            
            // TF for Term (word) X in Song S is calculated as frequency of that X divided 
            // by total number of words in the lyric
            
            for (String word : words)
                // Check if the word is empty 
                    // Update the TF value for this word in the current song
                    if (tempMap.containsKey(word)) {
                        tempMap.put(word, tempMap.get(word) + 1.0);
                    } else {
                        tempMap.put(word, 1.0);
                    }
                }
            
            
            
            int totalWords = words.length;
            
            for (String word : tempMap.keySet()) {
            	
                double frequency = tempMap.get(word);
                
                double tf = frequency / totalWords;
                
                tempMap.put(word, tf); 
            }

            // After Calculation, 
            result.put(songTitle, tempMap);
        }

        return result;
    }
}
