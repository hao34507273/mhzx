/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ 
/*    */ public class KnockOutSignalFightEndArg
/*    */ {
/*    */   public final int activityCfgId;
/*    */   public final long corpsId;
/*    */   public final int knockOutType;
/*    */   public final int stage;
/*    */   public final boolean isWin;
/*    */   
/*    */   public KnockOutSignalFightEndArg(int activityCfgId, long corpsId, int knockOutType, int stage, boolean isWin)
/*    */   {
/* 14 */     this.activityCfgId = activityCfgId;
/* 15 */     this.corpsId = corpsId;
/* 16 */     this.knockOutType = knockOutType;
/* 17 */     this.stage = stage;
/* 18 */     this.isWin = isWin;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\KnockOutSignalFightEndArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */