package DataStructure.Text;

public class StringManipulation {
    public String reverseString(String word){
        char[] tmp = new char[word.length()];
        int left = 0;
        int right = word.length()-1;
        while(left <= right){
            tmp[right] = word.charAt(left);
            tmp[left] = word.charAt(right);
            left++;
            right--;
        }
        return new String(tmp);
    }
}
