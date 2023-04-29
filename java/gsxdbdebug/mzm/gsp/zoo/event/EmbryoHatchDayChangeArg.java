/*    */ package mzm.gsp.zoo.event;
/*    */ 
/*    */ public class EmbryoHatchDayChangeArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final long animalid;
/*    */   public final int days;
/*    */   
/*    */   public EmbryoHatchDayChangeArg(long roleid, long animalid, int days)
/*    */   {
/* 11 */     this.roleid = roleid;
/* 12 */     this.animalid = animalid;
/* 13 */     this.days = days;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\event\EmbryoHatchDayChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */