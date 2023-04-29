/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMZeroProfit
/*    */   extends LogicProcedure
/*    */ {
/*    */   private static final String reason = "GM";
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final int seconds;
/*    */   
/*    */   public PGMZeroProfit(long gmRoleId, long roleId, int seconds)
/*    */   {
/* 16 */     this.gmRoleId = gmRoleId;
/* 17 */     this.roleId = roleId;
/* 18 */     this.seconds = seconds;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     if (this.seconds <= 0)
/*    */     {
/* 26 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "无效时长");
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     boolean result = IdipManager.addZeroProfit(this.roleId, this.seconds, "GM");
/* 31 */     if (result)
/*    */     {
/* 33 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "设置零收益成功");
/*    */     }
/*    */     else
/*    */     {
/* 37 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "设置零收益失败");
/*    */     }
/* 39 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMZeroProfit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */