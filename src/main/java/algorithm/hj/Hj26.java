package algorithm.hj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @description:
 * @author: gaoliang.wang
 * @date: 2022/7/25 11:18 PM
 **/
public class Hj26 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        List<Character> list = new ArrayList<>();
        for(Character ch:s.toCharArray()){
            if(Character.isLetter(ch)){
                list.add(ch);
            }
        }
        list.sort(Comparator.comparing(Character::toLowerCase));
        StringBuilder sb = new StringBuilder();
        for(int i=0,j=0;i<s.length();i++){

        }
    }
}
