/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.PGM_SetAccountNumlimit;
/*    */ 
/*    */ public class PGMAccountNumLimit extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final boolean isLimit;
/*    */   
/*    */   public PGMAccountNumLimit(long gmRoleId, int limit)
/*    */   {
/* 13 */     this.gmRoleId = gmRoleId;
/* 14 */     this.isLimit = (limit == 1);
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     new PGM_SetAccountNumlimit(this.isLimit).call();
/* 21 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("操作成功，帐号数目限制为%s状态", new Object[] { this.isLimit ? "开启" : "关闭" }));
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMAccountNumLimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */