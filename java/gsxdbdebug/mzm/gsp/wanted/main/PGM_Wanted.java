/*    */ package mzm.gsp.wanted.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_Wanted
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   
/*    */   public PGM_Wanted(long targetRoleId, long gmRoleId)
/*    */   {
/* 16 */     this.targetRoleId = targetRoleId;
/* 17 */     this.gmRoleId = gmRoleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     WantedInterface.addRoleWantedInfo(this.targetRoleId);
/* 24 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "通缉成功");
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\PGM_Wanted.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */