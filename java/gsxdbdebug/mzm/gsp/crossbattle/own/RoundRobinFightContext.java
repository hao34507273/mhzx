/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ public class RoundRobinFightContext implements FightContext
/*    */ {
/*    */   public final int activityCfgid;
/*    */   public final int roundIndex;
/*    */   public final long corpsAid;
/*    */   public final long corpsBid;
/*    */   
/*    */   public RoundRobinFightContext(int activityCfgid, int roundIndex, long corpsAid, long corpsBid)
/*    */   {
/* 14 */     this.activityCfgid = activityCfgid;
/* 15 */     this.roundIndex = roundIndex;
/* 16 */     this.corpsAid = corpsAid;
/* 17 */     this.corpsBid = corpsBid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\RoundRobinFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */