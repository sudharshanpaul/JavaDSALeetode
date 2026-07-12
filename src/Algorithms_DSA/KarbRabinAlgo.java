package Algorithms_DSA;

// Algorithm is used for String searching in a given long in O(n) time complexity using hashing

public class KarbRabinAlgo {
    private final int PRIME = 101;

    private double calculateHash(String str){
        double hash = 0;
        for(int i=0; i < str.length(); i++){
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }

        return hash;
    }

    private double updateHash(double prevHash, char oldChar, char newChar, int patternLength){
        double newHash = (prevHash - oldChar) / PRIME;
        newHash += newChar * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }

    public void search(String text, String pattern){
        int patternLength = pattern.length();
        double patternHash = calculateHash(pattern);
        double textHash = calculateHash(text.substring(0, patternLength));

        for(int i=0; i<=text.length() - patternLength; i++){
            if(textHash == patternHash){
                if(text.substring(i, i+patternLength).equals(pattern)){
                    System.out.println("Sub String found at the index:" + i);
                }
            }

            if(i < text.length() - patternLength){
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i+patternLength), patternLength);
            }
        }
    }

}
