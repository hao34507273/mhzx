/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KnockOutFightEndArg
/*    */ {
/*    */   public final long corpsId;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int knockOutType;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int fightZoneId;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int rank;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isWin;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isDraw;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public KnockOutFightEndArg(long corpsId, int knockOutType, int fightZoneId, int rank, boolean isWin, boolean isDraw)
/*    */   {
/* 45 */     this.corpsId = corpsId;
/* 46 */     this.knockOutType = knockOutType;
/* 47 */     this.fightZoneId = fightZoneId;
/* 48 */     this.rank = rank;
/* 49 */     this.isWin = isWin;
/* 50 */     this.isDraw = isDraw;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\KnockOutFightEndArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */