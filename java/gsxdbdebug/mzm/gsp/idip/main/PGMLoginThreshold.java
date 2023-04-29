/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.PGM_SetIntervalLoginNum;
/*    */ 
/*    */ public class PGMLoginThreshold extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final int num;
/*    */   
/*    */   public PGMLoginThreshold(long gmRoleId, int num)
/*    */   {
/* 13 */     this.gmRoleId = gmRoleId;
/* 14 */     this.num = num;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (this.num <= 0)
/*    */     {
/* 22 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "数量无效");
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     boolean result = new PGM_SetIntervalLoginNum(this.num).call();
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMLoginThreshold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */