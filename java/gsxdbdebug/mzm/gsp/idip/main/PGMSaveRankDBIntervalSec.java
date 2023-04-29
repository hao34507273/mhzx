/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.chart.main.PGM_SetSaveDBIntervalSec;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMSaveRankDBIntervalSec extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final int second;
/*    */   
/*    */   public PGMSaveRankDBIntervalSec(long gmRoleId, int second)
/*    */   {
/* 14 */     this.gmRoleId = gmRoleId;
/* 15 */     this.second = second;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     if (this.second <= 0)
/*    */     {
/* 23 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "时间无效");
/* 24 */       return false;
/*    */     }
/* 26 */     if (this.second < 60)
/*    */     {
/* 28 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("时间设置过小，至少要大于%d秒", new Object[] { Integer.valueOf(60) }));
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     new PGM_SetSaveDBIntervalSec(this.second).call();
/* 33 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "操作成功");
/*    */     
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMSaveRankDBIntervalSec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */