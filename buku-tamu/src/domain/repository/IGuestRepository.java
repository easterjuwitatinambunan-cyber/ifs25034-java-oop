// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package domain.repository;

import domain.entity.Guest;
import java.util.List;

public interface IGuestRepository {
   Guest save(String var1, String var2);

   List<Guest> findAll();

   List<Guest> findByKeyword(String var1);

   boolean deleteById(String var1);
}
