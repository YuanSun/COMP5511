package capitalize;
// --- Directions
// Write a function that accepts a string. The function should
// capitalize the first letter of each word in the string then
// return the capitalized string.
// --- Examples
// capitalize('a short sentence') --> 'A Short Sentence'
// capitalize('a lazy fox') --> 'A Lazy Fox'
// capitalize('look, it is working!') --> 'Look, It Is Working!'

class Capitalize {
  static String CapitalizeStr(String str) {
    String[] result = str.split(" ");
    StringBuilder sb = new StringBuilder();
    for (String word : result) {
      sb.append(Character.toUpperCase(word.charAt(0)) + word.substring(1)).append(" ");
    }

    return sb.toString().trim();
  }
}
