class Caesar
{
   public static void main(String[] args)
   {
      String message = getMessage(args[1]);
      if (args[0].equals("encrypt"))
      {
         int key = (int)(args[2].charAt(0)) - 65; 
         message = encrypt(message, key);
      }
      else if (args[0].equals("decrypt"))
      {
         int key = (int)(args[2].charAt(0)) - 65;
         message = decrypt(message, key);
      }
      else if (args[0].equals("crack"))
      {
         double[] english = getDictionaryFrequencies(args[2]);
         message = crack(message, english);
      }
      else
      {
         System.out.println("Not a valid test case check to see arguments are typed or positioned correctly.");
      }
      System.out.println(message);
   }
    /*
    * Description: converts a string to a symbol array,
    *              where each element of the array is an
    *              integer encoding of the corresponding
    *              element of the string.
    * Input:  the message text to be converted
    * Output: integer encoding of the message
    */
    public static int[] stringToSymbolArray(String str) 
    {
       int[]  symbolArray = new int[str.length()];
       str = str.toUpperCase();
       for (int k = 0; k < str.length();k++)
       {
         symbolArray[k] = (int)(str.charAt(k)) - 65;
       }
       //for (int a = 0; a < str.length(); a++)
       //{
       //  System.out.println(symbolArray[a]);
       //}
       // TODO: Replace this return statement (and this comment) with actual code.
       // Temporarily including the "return null" statement
       // ensures your code compiles so you can focus
       // on one function at a time.
       return symbolArray;
    }

    /*
    * Description: converts an array of symbols to a string,
    *              where each element of the array is an
    *              integer encoding of the corresponding
    *              element of the string.
    * Input:  integer encoding of the message
    * Output: the message text
    */
    public static String symbolArrayToString(int[] symbols) 
    {
      String str = "";
      for (int h = 0; h < symbols.length; h++)
      {
        str += (char)(symbols[h] + 65);
      }
      str = str.toUpperCase();
      //System.out.println(str);
      // TODO: Replace this return statement (and this comment) with actual code.
      return str;
    }
    // The numerical value for a letter is shifted down the alphabet by a given offset
    public static int shift(int symbol, int offset)
    {
      if (symbol >= 0 && symbol <= 25)
      {
         offset %= 26;
         symbol += offset;
         if (symbol > 25) symbol -= 26;
      } 
      return symbol;
    }
    // The numerical calue for a letter is reverted back up to its original letter in the alphabet by a given offset
    public static int unshift(int symbol, int offset)
    {
      if (symbol >= 0 && symbol <= 25)
      {
         offset %= 26;
         symbol -= offset;
         if (symbol < 0) symbol += 26;
      }
      return symbol;
    }
    //This will encrypt a message by shifting the letters by the frequency of the key which is given
    public static String encrypt(String message, int key)
    {
      int offset = key;
      int[] symbol = stringToSymbolArray(message);
      for (int y = 0; y < symbol.length; y++)
      {
         symbol[y] = shift(symbol[y], offset);
      }
      message = symbolArrayToString(symbol);
      return message;
    }
    //This will decrypt a message by shifting the letters by the frequency of the key which is given
    public static String decrypt(String message, int key)
    {
      int offset = key;
      int[] symbol = stringToSymbolArray(message);
      for (int y = 0; y < symbol.length; y++)
      {
         symbol[y] = unshift(symbol[y], offset);
      }
      message = symbolArrayToString(symbol);
      //System.out.println(message);
      return message;    
    }
    // This gets the frequencies of letters from a dictionary file and puts them into an array
    public static double[] getDictionaryFrequencies(String file)
    {
      In scan = new In(file);
      double[] english = new double[26]; 
      for (int p = 0; p < 26; p++)
      {
         english[p] = scan.readDouble();
      }
      return english;
    }
    //This returns a frequncy table based of a given symbol array
    public static double[] findFrequencies(int[] symbolsArray)
    {
      double[] cipherArray = new double[26];
      int letterCount = 0;
      for (int t = 0; t < symbolsArray.length; t++)
      {
         if (symbolsArray[t] >= 0 && symbolsArray[t] <= 25)
         {
            cipherArray[symbolsArray[t]] += 1;
            letterCount += 1;
         }
      }
      for (int g = 0; g < cipherArray.length; g++)
      {
         cipherArray[g] /= letterCount;
      }
      return cipherArray;
    }
    //This gets a frequency score that compares a symbol array frequency table and a frequency table based on the dictionary
    public static double scoreFrequencies(double[] freqs, double[] englishfreqs)
    {
      double freqScore = 0.0;
      for (int e = 0; e < 26; e++)
      {
         freqScore += Math.abs(freqs[e] - englishfreqs[e]);
      }
      //System.out.println("scoreFreq:" + freqScore);
      return freqScore;
    }
    //decrypts a cipher by finding the key with the lowest frequency score and using that key to find the message that fits the english dictionary the most to return
    public static String crack(String cipher, double[] english)
    {
      String currentDecrypt = "";
      double lowestFreqScore = 1.0;
      double freqsScore = 0.0;
      int lowestKey = 0;
      int[] decryptArray = new int[cipher.length()];
      double[] decryptFreq = new double[26];
      char key = (char)0;
      for (int q = 0; q < 26; q++)
      {
         currentDecrypt = decrypt(cipher, q);
         decryptArray = stringToSymbolArray(currentDecrypt);
         decryptFreq = findFrequencies(decryptArray);
         freqsScore = scoreFrequencies(decryptFreq, english);
         if ( freqsScore < lowestFreqScore)
         {
            lowestFreqScore = freqsScore;
            lowestKey = q;
         }
      }
      key = (char)(lowestKey + 65);
      System.out.println("The key for this encrypted message is: " + key);
      //System.out.println("LowestFrequency:" + lowestFreqScore);
      //System.out.println("lowestKey:" + lowestKey);
      currentDecrypt = decrypt(cipher, lowestKey);
      return currentDecrypt;
    }
    public static String getMessage(String filename)
    {
      In scanner = new In(filename);
      String message = scanner.readAll();
      return message;
    }
}