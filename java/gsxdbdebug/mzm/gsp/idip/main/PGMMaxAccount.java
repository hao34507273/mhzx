/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.PGM_SetAccountNum;
/*    */ 
/*    */ public class PGMMaxAccount extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final int maxAccount;
/*    */   
/*    */   public PGMMaxAccount(long gmRoleId, int maxAccount)
/*    */   {
/* 13 */     this.gmRoleId = gmRoleId;
/* 14 */     this.maxAccount = maxAccount;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (this.maxAccount <= 0)
/*    */     {
/* 22 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "数量无效");
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     boolean result = new PGM_SetAccountNum(this.maxAccount).call();
/* 27 */     if (result)
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "操作成功");
/*    */     }
/*    */     else
/*    */     {
/* 33 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "操作失败");
/*    */     }
/* 35 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMMaxAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */