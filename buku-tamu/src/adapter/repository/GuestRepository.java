// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package adapter.repository;

import domain.entity.Guest;
import domain.repository.IGuestRepository;
import java.util.ArrayList;
import java.util.List;

public class GuestRepository implements IGuestRepository {
   private final List<Guest> guests = new ArrayList();
   private int idCounter = 1;

   public GuestRepository() {
   }

   public Guest save(String var1, String var2) {
      String var3 = String.valueOf(this.idCounter++);
      Guest var4 = new Guest(var3, var1, var2);
      this.guests.add(var4);
      return var4;
   }

   public List<Guest> findAll() {
      return new ArrayList(this.guests);
   }

   public List<Guest> findByKeyword(String var1) {
      ArrayList var2 = new ArrayList();
      String var3 = var1.toLowerCase();

      for(Guest var5 : this.guests) {
         if (var5.getName().toLowerCase().contains(var3) || var5.getPurpose().toLowerCase().contains(var3)) {
            var2.add(var5);
         }
      }

      return var2;
   }

   public boolean deleteById(String var1) {
      return this.guests.removeIf((var1x) -> var1x.getId().equalsIgnoreCase(var1));
   }
}
