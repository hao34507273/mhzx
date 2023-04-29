/*    */ package mzm.gsp.teamplatform.event;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.teamplatform.MatchCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JoinPlatformRoleArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final List<MatchCfg> matchCfgs;
/*    */   public final int level_low;
/*    */   public final int level_high;
/*    */   
/*    */   public JoinPlatformRoleArg(long roleId, List<MatchCfg> matchCfgs, int level_low, int level_high)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.matchCfgs = matchCfgs;
/* 21 */     this.level_high = level_high;
/* 22 */     this.level_low = level_low;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\event\JoinPlatformRoleArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */