/*    */ package mzm.gsp.zoo.main;
/*    */ 
/*    */ public class AddAnimalResult
/*    */ {
/*    */   private long animalid;
/*    */   private Reason reason;
/*    */   
/*    */   public long getAnimalid()
/*    */   {
/* 10 */     return this.animalid;
/*    */   }
/*    */   
/*    */   public void setAnimalid(long animalid)
/*    */   {
/* 15 */     this.animalid = animalid;
/*    */   }
/*    */   
/*    */   public Reason getReason()
/*    */   {
/* 20 */     return this.reason;
/*    */   }
/*    */   
/*    */   public void setReason(Reason reason)
/*    */   {
/* 25 */     this.reason = reason;
/*    */   }
/*    */   
/*    */   public static enum Reason
/*    */   {
/* 30 */     SUCCESS(0, "success"), 
/*    */     
/* 32 */     ANIMAL_FULL(1, "animal full"), 
/*    */     
/* 34 */     CFG_ERROR(2, "cfg error");
/*    */     
/*    */     public final int code;
/*    */     public final String desc;
/*    */     
/*    */     private Reason(int code, String desc)
/*    */     {
/* 41 */       this.code = code;
/* 42 */       this.desc = desc;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\AddAnimalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */