/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_AddInnerSaveAmt extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long targetRoleid;
/*    */   private final int amt;
/*    */   
/*    */   public PGM_AddInnerSaveAmt(long gmRoleid, long targetRoleid, int amt)
/*    */   {
/* 15 */     this.gmRoleid = gmRoleid;
/* 16 */     this.targetRoleid = targetRoleid;
/* 17 */     this.amt = amt;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     String userid = RoleInterface.getUserId(this.targetRoleid);
/* 24 */     if (userid == null)
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     PresentInnerSaveAmtResult result = QingfuManager.presentInnerSaveAmt(userid, this.amt);
/* 30 */     if (result == PresentInnerSaveAmtResult.Success)
/*    */     {
/* 32 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "add inner save amt success");
/*    */       
/* 34 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 38 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("add inner save amt failed|reason=%s", new Object[] { result.name() }));
/*    */     
/*    */ 
/* 41 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PGM_AddInnerSaveAmt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */