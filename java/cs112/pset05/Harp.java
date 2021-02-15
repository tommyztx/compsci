public class Harp
{
   static String NOTE_MAPPING = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
   static double BASE_FREQUENCY = 440.0;
   public static void main(String[] args)
   { 
      double stringFrequency = 0.0;
      HarpString[] harpStrings = new HarpString[NOTE_MAPPING.length()];
      while(true)
      {
         if (PennDraw.hasNextKeyTyped())
         {
            char key = PennDraw.nextKeyTyped();
            int index = -1;
            for (int o = 0; o < NOTE_MAPPING.length(); o++)
            {  
               if (key == NOTE_MAPPING.charAt(o))
               {
                  index = NOTE_MAPPING.indexOf(key);
               }   
            }
            if (index == -1) continue;
            stringFrequency = BASE_FREQUENCY * Math.pow(2.0, ((((double)(index)) - 24.0) / 12.0));
            harpStrings[index] = new HarpString(stringFrequency);
            harpStrings[index].pluck();
         }
         double sample = 0.0;
         for (int i = 0; i < harpStrings.length; i++)
         {
            if (harpStrings[i] != null)
            {
               sample += harpStrings[i].sample();
            }
         }
         StdAudio.play(sample);
         for (int k = 0; k < harpStrings.length; k++)
         {
            if (harpStrings[k] != null)
            {
               harpStrings[k].tic();
            }                           
         }
      }    
   }
}