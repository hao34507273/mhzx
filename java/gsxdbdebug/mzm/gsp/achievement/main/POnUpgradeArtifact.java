/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.fabaolingqi.event.UpgradeArtifactArg;
/*    */ import mzm.gsp.fabaolingqi.event.UpgradeArtifactEventProcedure;
/*    */ 
/*    */ public class POnUpgradeArtifact
/*    */   extends UpgradeArtifactEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((UpgradeArtifactArg)this.arg).roleId, 4204, null, "POnUpgradeArtifact.processImp@handle FABAO_LINGQI_SPECIFIC_STAR finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnUpgradeArtifact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */