/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.fabaolingqi.event.UnlockArtifactArg;
/*    */ import mzm.gsp.fabaolingqi.event.UnlockArtifactEventProcedure;
/*    */ 
/*    */ public class POnUnlockArtifact
/*    */   extends UnlockArtifactEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((UnlockArtifactArg)this.arg).roleId, 4204, null, "POnUnlockArtifact.processImp@handle FABAO_LINGQI_SPECIFIC_STAR finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnUnlockArtifact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */