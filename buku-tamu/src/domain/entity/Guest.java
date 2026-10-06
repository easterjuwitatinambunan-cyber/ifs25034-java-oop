// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package domain.entity;

public class Guest {
   private String id;
   private String name;
   private String purpose;

   public Guest(String var1, String var2, String var3) {
      this.id = var1;
      this.name = var2;
      this.purpose = var3;
   }

   public String getId() {
      return this.id;
   }

   public void setId(String var1) {
      this.id = var1;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public String getPurpose() {
      return this.purpose;
   }

   public void setPurpose(String var1) {
      this.purpose = var1;
   }
}
