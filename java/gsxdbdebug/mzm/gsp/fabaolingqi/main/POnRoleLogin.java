/*    */ package mzm.gsp.fabaolingqi.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import xbean.FabaoArtifactRecords;
/*    */ import xbean.FabaoArtifactSessionInfo;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (!FabaoArtifactManager.isEnable()) {
/* 12 */       return false;
/*    */     }
/* 14 */     FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(((Long)this.arg).longValue(), true);
/* 15 */     if (xRecords == null)
/* 16 */       return false;
/* 17 */     FabaoArtifactManager.removeExpiredArtifacts(((Long)this.arg).longValue(), xRecords);
/* 18 */     FabaoArtifactProtocols.syncArtifactInformation(((Long)this.arg).longValue(), xRecords);
/*    */     
/* 20 */     FabaoArtifactSessionInfo xSessionInfo = FabaoArtifactManager.getOrCreateSessionInfo(((Long)this.arg).longValue());
/* 21 */     FabaoArtifactExpireSession.startSessions(((Long)this.arg).longValue(), xRecords, xSessionInfo);
/*    */     
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */