/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.fabaolingqi.event.ImproveArtifactArg;
/*    */ import mzm.gsp.fabaolingqi.event.ImproveArtifactEventProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnImproveArtifact
/*    */   extends ImproveArtifactEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     RoleModuleManager.refreshFaBaoLingQiPro(((ImproveArtifactArg)this.arg).roleId);
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnImproveArtifact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */