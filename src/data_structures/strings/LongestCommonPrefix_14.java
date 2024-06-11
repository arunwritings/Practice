public class LongestCommonPrefix_14 {

   public String longestCommonPrefix(String[] strings) {
        int length = strings.length;
        if (length == 0) return "";
        if (length == 1) return strings[0];

        Arrays.sort(strings);
        int end = Math.min(strings[0].length(),strings[length-1].length());
        int i=0;
        while (i<end && strings[0].charAt(i) == strings[length-1].charAt(i))
            i++;
        return strings[0].substring(0,i);
    }
  
  public static void main(String[] args) {
    LongestCommonPrefix_14 lcp = new LongestCommonPrefix_14();
    String[] strings = {"arun","arjun","arya"};
    System.out.println(lcp.longestCommonPrefix(strings));
  }
}
