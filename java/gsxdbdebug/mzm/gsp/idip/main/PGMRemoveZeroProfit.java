/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMRemoveZeroProfit
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   
/*    */   public PGMRemoveZeroProfit(long gmRoleId, long roleId)
/*    */   {
/* 14 */     this.gmRoleId = gmRoleId;
/* 15 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     IdipManager.relieveZeroProfit(this.roleId);
/* 22 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "解除零收益完成");
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMRemoveZeroProfit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */