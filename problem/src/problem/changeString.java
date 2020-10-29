public class changeString {

    private String change(String word){
        StringBuilder wordChange = new StringBuilder(word);
        char Upper=155;
        char Lower=219;

        for(int i=0;i<word.length();i++){

            if(Character.isUpperCase(word.charAt(i))==true)
                wordChange.setCharAt(i,(char)(Upper-word.charAt(i)));

            else if(Character.isLowerCase(word.charAt(i))==true)
                wordChange.setCharAt(i,(char)(Lower-word.charAt(i)));

            else
                continue;
        }

        word = wordChange.toString();
        return word;
    }


    public static void main(String[] args){
        changeString chageWord = new changeString();

        String word = "I love you";

        word = chageWord.change(word);

        System.out.print(word);

    }
}
