// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package framework.view;

import adapter.presenter.GuestPresenter;
import domain.entity.Guest;
import framework.util.InputUtil;
import usecase.GuestUseCase;

public class GuestView {
   private final GuestUseCase guestUseCase;
   private final GuestPresenter guestPresenter;

   public GuestView(GuestUseCase var1, GuestPresenter var2) {
      this.guestUseCase = var1;
      this.guestPresenter = var2;
   }

   public void show() {
      while(true) {
         this.guestPresenter.printGuestList(this.guestUseCase.getAllGuests());
         System.out.println("Menu:");
         System.out.println("1. Daftarkan");
         System.out.println("2. Cari");
         System.out.println("3. Hapus");
         System.out.println("x. Keluar");
         String var1 = InputUtil.input("Pilih");
         if (var1.equalsIgnoreCase("1")) {
            this.registerGuestView();
         } else if (var1.equalsIgnoreCase("2")) {
            this.searchGuestView();
         } else if (var1.equalsIgnoreCase("3")) {
            this.deleteGuestView();
         } else {
            if (var1.equalsIgnoreCase("x")) {
               return;
            }

            System.out.println("[!] Pilihan tidak dimengerti.");
            System.out.println();
         }
      }
   }

   private void registerGuestView() {
      System.out.println("[Mendaftarkan Tamu]");
      String var1 = InputUtil.input("Nama (x Jika Batal)");
      if (var1.equalsIgnoreCase("x")) {
         System.out.println();
      } else {
         String var2 = InputUtil.input("Tujuan Kunjungan (x Jika Batal)");
         if (var2.equalsIgnoreCase("x")) {
            System.out.println();
         } else {
            Guest var3 = this.guestUseCase.registerGuest(var1, var2);
            this.guestPresenter.printSuccessRegister(var3);
            System.out.println();
         }
      }
   }

   private void searchGuestView() {
      System.out.println("[Mencari Tamu]");
      String var1 = InputUtil.input("Nama (x Jika Batal)");
      if (var1.equalsIgnoreCase("x")) {
         System.out.println();
      } else {
         this.guestPresenter.printSearchResult(var1, this.guestUseCase.searchGuests(var1));
         System.out.println();
      }
   }

   private void deleteGuestView() {
      System.out.println("[Menghapus Tamu]");
      String var1 = InputUtil.input("[ID Tamu] yang dihapus (x Jika Batal)");
      if (var1.equalsIgnoreCase("x")) {
         System.out.println();
      } else {
         try {
            Integer.parseInt(var1);
         } catch (NumberFormatException var3) {
            System.out.println("[!] ID tidak valid!");
            System.out.println();
            return;
         }

         boolean var2 = this.guestUseCase.deleteGuest(var1);
         if (var2) {
            System.out.println("Berhasil menghapus tamu.");
         } else {
            System.out.println("[!] Gagal menghapus tamu dengan ID: " + var1 + ".");
         }

         System.out.println();
      }
   }
}
