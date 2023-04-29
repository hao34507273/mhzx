/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_GetActivityBigAwardCount
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long gmRoleId;
/*    */   final int activityId;
/*    */   
/*    */   public PGM_GetActivityBigAwardCount(long gmRoleId, int activityId)
/*    */   {
/* 14 */     this.gmRoleId = gmRoleId;
/* 15 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     long ret = DrawCarnivalInterface.getActivityBigAwardCount(this.activityId);
/* 22 */     if (ret >= 0L)
/*    */     {
/* 24 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "活动内已经触发的元宝大奖次数:" + ret);
/* 25 */       return true;
/*    */     }
/* 27 */     if (ret == -1580L)
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "活动信息不存在");
/* 30 */       return false;
/*    */     }
/* 32 */     if (ret == -1581L)
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "通行证类型信息不存在");
/* 35 */       return false;
/*    */     }
/* 37 */     if (ret == -1582L)
/*    */     {
/* 39 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "参数错误");
/* 40 */       return false;
/*    */     }
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\PGM_GetActivityBigAwardCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */