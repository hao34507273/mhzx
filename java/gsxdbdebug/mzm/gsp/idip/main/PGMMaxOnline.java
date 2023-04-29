/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.PGM_SetMaxPalyerNum;
/*    */ 
/*    */ public class PGMMaxOnline extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final int maxOnline;
/*    */   
/*    */   public PGMMaxOnline(long gmRoleId, int maxOnline)
/*    */   {
/* 13 */     this.gmRoleId = gmRoleId;
/* 14 */     this.maxOnline = maxOnline;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (this.maxOnline <= 0)
/*    */     {
/* 22 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "数量无效");
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     boolean result = new PGM_SetMaxPalyerNum(this.maxOnline).call();
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMMaxOnline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */