/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.fabaolingqi.event.ArtifactExpireArg;
/*    */ import mzm.gsp.fabaolingqi.event.ArtifactExpireEventProcedure;
/*    */ 
/*    */ public class POnArtifactExpire
/*    */   extends ArtifactExpireEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((ArtifactExpireArg)this.arg).roleId, 4204, null, "POnArtifactExpire.processImp@handle FABAO_LINGQI_SPECIFIC_STAR finish");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnArtifactExpire.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */