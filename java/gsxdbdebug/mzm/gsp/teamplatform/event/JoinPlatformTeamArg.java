/*    */ package mzm.gsp.teamplatform.event;
/*    */ 
/*    */ import mzm.gsp.teamplatform.MatchCfg;
/*    */ 
/*    */ public class JoinPlatformTeamArg
/*    */ {
/*    */   public final long teamId;
/*    */   public final MatchCfg matchCfg;
/*    */   public final int level_low;
/*    */   public final int level_high;
/*    */   
/*    */   public JoinPlatformTeamArg(long teamId, MatchCfg matchCfg, int level_low, int level_high) {
/* 13 */     this.teamId = teamId;
/* 14 */     this.matchCfg = matchCfg;
/* 15 */     this.level_high = level_high;
/* 16 */     this.level_low = level_low;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\event\JoinPlatformTeamArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */