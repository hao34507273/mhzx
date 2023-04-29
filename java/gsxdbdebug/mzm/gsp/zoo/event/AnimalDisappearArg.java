/*    */ package mzm.gsp.zoo.event;
/*    */ 
/*    */ public class AnimalDisappearArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final long animalid;
/*    */   public final int reason;
/*    */   
/*    */   public AnimalDisappearArg(long roleid, long animalid, int reason)
/*    */   {
/* 11 */     this.roleid = roleid;
/* 12 */     this.animalid = animalid;
/* 13 */     this.reason = reason;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\event\AnimalDisappearArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */