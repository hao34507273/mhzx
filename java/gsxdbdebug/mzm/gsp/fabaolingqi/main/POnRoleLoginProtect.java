/*    */ package mzm.gsp.fabaolingqi.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProtectProcedure;
/*    */ import xbean.FabaoArtifactRecords;
/*    */ 
/*    */ public class POnRoleLoginProtect extends PlayerLoginProtectProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     if (!FabaoArtifactManager.isEnable()) {
/* 11 */       return false;
/*    */     }
/* 13 */     FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(((Long)this.arg).longValue(), true);
/* 14 */     if (xRecords == null)
/* 15 */       return false;
/* 16 */     FabaoArtifactManager.removeExpiredArtifacts(((Long)this.arg).longValue(), xRecords);
/* 17 */     FabaoArtifactProtocols.syncArtifactInformation(((Long)this.arg).longValue(), xRecords);
/*    */     
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\POnRoleLoginProtect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */