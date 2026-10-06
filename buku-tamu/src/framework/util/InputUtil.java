// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package framework.util;

import java.util.Scanner;

public class InputUtil {
   private static final Scanner scanner;

   public InputUtil() {
   }

   public static String input(String var0) {
      System.out.print(var0 + " : ");
      return scanner.nextLine();
   }

   static {
      scanner = new Scanner(System.in);
   }
}
