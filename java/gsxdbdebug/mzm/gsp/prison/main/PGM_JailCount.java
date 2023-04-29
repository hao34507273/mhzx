/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_JailCount extends LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   
/*    */   public PGM_JailCount(long targetRoleId, long gmRoleId)
/*    */   {
/* 13 */     this.targetRoleId = targetRoleId;
/* 14 */     this.gmRoleId = gmRoleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "入狱次数：" + PrisonInterface.getRoleTotalJailCount(this.targetRoleId, true));
/*    */     
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\PGM_JailCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */