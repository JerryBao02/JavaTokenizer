import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Tokenizer_V1 {
    HashMap<String, Integer> tokenToInt;
    HashMap<Integer, String> intToToken;


    public Tokenizer_V1(List<String> tokens){
        tokenToInt = new HashMap<>();
        intToToken = new HashMap<>();

        for(int i = 0; i < tokens.size(); i++){
            tokenToInt.put(tokens.get(i), i);
            intToToken.put(i, tokens.get(i));
        }



    }

    public List<Integer> encoder(String text){
        List<Integer> output = new ArrayList<>();

        String[] preProcessed = text.split("(?<=\\W)|(?=\\W)");
        String[] filtered = Arrays.stream(preProcessed)
                .filter(item -> !item.trim().isEmpty())
                .toArray(String[]::new);

        for(String i: filtered){
            if(tokenToInt.get(i) != null){
                output.add(tokenToInt.get(i));

            }
            else{
                output.add(tokenToInt.get("<|unk|>"));
            }

        }


        return output;
    }

    public String decoder(List<Integer> a){
        String output = "";
        for(int i: a ){
            output += intToToken.get(i) + " ";
        }


        return output;
    }






}
