/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.fabaolingqi.event.UnlockArtifactArg;
/*    */ import mzm.gsp.fabaolingqi.event.UnlockArtifactEventProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnUnlockArtifact
/*    */   extends UnlockArtifactEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     RoleModuleManager.refreshFaBaoLingQiPro(((UnlockArtifactArg)this.arg).roleId);
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnUnlockArtifact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */