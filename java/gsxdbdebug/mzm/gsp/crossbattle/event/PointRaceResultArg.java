/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PointRaceResultArg
/*    */ {
/*    */   public final long coprsid;
/*    */   
/*    */ 
/*    */ 
/*    */   public final int rank;
/*    */   
/*    */ 
/*    */ 
/*    */   public final boolean promotion;
/*    */   
/*    */ 
/*    */ 
/*    */   public PointRaceResultArg(long corpsid, int rank, boolean promotion)
/*    */   {
/* 22 */     this.coprsid = corpsid;
/* 23 */     this.rank = rank;
/* 24 */     this.promotion = promotion;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\PointRaceResultArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */