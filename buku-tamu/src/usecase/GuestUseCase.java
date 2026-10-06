// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package usecase;

import domain.entity.Guest;
import domain.repository.IGuestRepository;
import java.util.List;

public class GuestUseCase {
   private final IGuestRepository guestRepository;

   public GuestUseCase(IGuestRepository var1) {
      this.guestRepository = var1;
   }

   public Guest registerGuest(String var1, String var2) {
      return this.guestRepository.save(var1, var2);
   }

   public List<Guest> getAllGuests() {
      return this.guestRepository.findAll();
   }

   public List<Guest> searchGuests(String var1) {
      return this.guestRepository.findByKeyword(var1);
   }

   public boolean deleteGuest(String var1) {
      return this.guestRepository.deleteById(var1);
   }
}
