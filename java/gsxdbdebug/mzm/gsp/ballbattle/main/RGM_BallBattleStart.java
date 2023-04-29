/*    */ package mzm.gsp.ballbattle.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.ballbattle.confbean.SBallBattleActivityCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class RGM_BallBattleStart
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final int activityId;
/* 15 */   private final Set<Long> roleIds = new HashSet();
/*    */   
/*    */   public RGM_BallBattleStart(long gmRoleId, int activityId, String roleIds)
/*    */   {
/* 19 */     this.gmRoleId = gmRoleId;
/* 20 */     this.activityId = activityId;
/* 21 */     for (String roleId : roleIds.split("-"))
/*    */     {
/* 23 */       if (!roleId.isEmpty())
/*    */       {
/* 25 */         this.roleIds.add(Long.valueOf(roleId));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 33 */     if (this.roleIds.size() <= 1)
/*    */     {
/* 35 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "人数不足");
/* 36 */       return;
/*    */     }
/* 38 */     SBallBattleActivityCfg activityCfg = SBallBattleActivityCfg.get(this.activityId);
/* 39 */     if (activityCfg == null)
/*    */     {
/* 41 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("活动ID%d无效", new Object[] { Integer.valueOf(this.activityId) }));
/* 42 */       return;
/*    */     }
/* 44 */     BallBattleGameInstance.newInstances(this.activityId, true, Collections.singletonList(this.roleIds));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\main\RGM_BallBattleStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */