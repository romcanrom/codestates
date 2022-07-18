package coplit.daily;

import java.util.stream.Stream;

public class DecryptCaesarCipher {
    public static void main(String[] args) {
        String output = decryptCaesarCipher("khoor", 3);
        System.out.println(output); // --> hello

        output = decryptCaesarCipher("zruog", 3);
        System.out.println(output); // --> world

        output = decryptCaesarCipher("mnv xnt zqd qdzcx sn lnud sn hlldqrhud bntqrd", 25);
        System.out.println(output); // --> now you are ready to move to immersive course
    }


    static String decryptCaesarCipher(String str, int secret) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) < 97 || str.charAt(i) > 122) {
                sb.append(str.charAt(i));
                continue;
            }

            int ascii = (int) str.charAt(i) - secret;

            if(ascii < 97) sb.append((char) (123-(97-ascii)));
            else sb.append((char) ascii);
        }

        return String.valueOf(sb);
    }
}

