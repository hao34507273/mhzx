/*    */ package mzm.gsp.fabaolingqi.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import xbean.FabaoArtifactSessionInfo;
/*    */ 
/*    */ public class POnRoleLogout
/*    */   extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (!FabaoArtifactManager.isEnable()) {
/* 12 */       return false;
/*    */     }
/* 14 */     FabaoArtifactSessionInfo xSessionInfo = FabaoArtifactManager.getSessionInfo(((Long)this.arg).longValue(), true);
/* 15 */     FabaoArtifactExpireSession.removeSessions(((Long)this.arg).longValue(), xSessionInfo);
/*    */     
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\POnRoleLogout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */