/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ 
/*    */ public class RoundRobinFightEndArg
/*    */ {
/*    */   public final int activityCfgid;
/*    */   public final int roundIndex;
/*    */   public final long corpsAid;
/*    */   public final long corpsBid;
/*    */   public final int state;
/*    */   
/*    */   public RoundRobinFightEndArg(int activityCfgid, int roundIndex, long corpsAid, long corpsBid, int state)
/*    */   {
/* 14 */     this.activityCfgid = activityCfgid;
/* 15 */     this.roundIndex = roundIndex;
/* 16 */     this.corpsAid = corpsAid;
/* 17 */     this.corpsBid = corpsBid;
/* 18 */     this.state = state;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\RoundRobinFightEndArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */