/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.fabaolingqi.event.ArtifactExpireArg;
/*    */ import mzm.gsp.fabaolingqi.event.ArtifactExpireEventProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnArtifactExpire
/*    */   extends ArtifactExpireEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     RoleModuleManager.refreshFaBaoLingQiPro(((ArtifactExpireArg)this.arg).roleId);
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnArtifactExpire.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */