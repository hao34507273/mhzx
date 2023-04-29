/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_SetActivityAmt
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long gmRoleId;
/*    */   final int activityId;
/*    */   final long count;
/*    */   
/*    */   public PGM_SetActivityAmt(long gmRoleId, int activityId, long count)
/*    */   {
/* 15 */     this.gmRoleId = gmRoleId;
/* 16 */     this.activityId = activityId;
/* 17 */     this.count = count;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     int idipRet = DrawCarnivalInterface.setActivityAmt(this.activityId, this.count);
/* 24 */     if (idipRet == 0)
/*    */     {
/* 26 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "设置成功");
/* 27 */       return true;
/*    */     }
/* 29 */     if (idipRet == 63956)
/*    */     {
/* 31 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "活动信息不存在");
/* 32 */       return false;
/*    */     }
/* 34 */     if (idipRet == 63955)
/*    */     {
/* 36 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "通行证类型信息不存在");
/* 37 */       return false;
/*    */     }
/* 39 */     if (idipRet == 63954)
/*    */     {
/* 41 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "参数错误");
/* 42 */       return false;
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\PGM_SetActivityAmt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */