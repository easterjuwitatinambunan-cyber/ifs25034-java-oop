// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package adapter.presenter;

import domain.entity.Guest;
import java.io.PrintStream;
import java.util.List;

public class GuestPresenter {
   public GuestPresenter() {
   }

   public void printGuestList(List<Guest> var1) {
      System.out.println("Daftar Tamu:");
      if (var1.isEmpty()) {
         System.out.println("- Data tamu belum tersedia!");
      } else {
         for(Guest var3 : var1) {
            PrintStream var10000 = System.out;
            String var10001 = var3.getId();
            var10000.println(var10001 + " | " + var3.getName() + " | " + var3.getPurpose());
         }
      }

   }

   public void printSearchResult(String var1, List<Guest> var2) {
      System.out.println("Hasil Pencarian: \"" + var1 + "\"");
      if (var2.isEmpty()) {
         System.out.println("- Tamu tidak ditemukan!");
      } else {
         for(Guest var4 : var2) {
            PrintStream var10000 = System.out;
            String var10001 = var4.getId();
            var10000.println(var10001 + " | " + var4.getName() + " | " + var4.getPurpose());
         }
      }

   }

   public void printSuccessRegister(Guest var1) {
      PrintStream var10000 = System.out;
      String var10001 = var1.getId();
      var10000.println("Berhasil mendaftarkan tamu: " + var10001 + " | " + var1.getName() + " | " + var1.getPurpose());
   }
}
