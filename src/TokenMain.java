import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.awt.SystemColor.text;

public class TokenMain {
    public static void main(String[] args){
        String text1 = "";

        String filePath = "Tokenizer/src/text.txt";

        try{
            text1 = Files.readString(Paths.get(filePath));
            System.out.println("Length of Text: " + text1.length());
            System.out.println(text1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] result = text1.split("(?<=\\W)|(?=\\W)");



        String[] filtered = Arrays.stream(result)
                .filter(item -> !item.trim().isEmpty())
                .toArray(String[]::new);




        TreeSet<String> set = new TreeSet<>(Arrays.asList(filtered));
        List<String> text = new ArrayList<>(set);
        text.add("<|unk|>");

//        System.out.print(set);
        Tokenizer_V1 t1 = new Tokenizer_V1(text);

        System.out.println(
                t1.encoder("Dances wild withh"));

        System.out.println(
                t1.decoder(t1.encoder("Dances wild withh")));
    }
}
