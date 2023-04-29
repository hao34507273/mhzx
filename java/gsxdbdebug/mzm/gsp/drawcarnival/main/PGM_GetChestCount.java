/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_GetChestCount
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long gmRoleId;
/*    */   final int activityId;
/*    */   final int randomTypeId;
/*    */   
/*    */   public PGM_GetChestCount(long gmRoleId, int activityId, int randomTypeId)
/*    */   {
/* 15 */     this.gmRoleId = gmRoleId;
/* 16 */     this.activityId = activityId;
/* 17 */     this.randomTypeId = randomTypeId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     int ret = DrawCarnivalInterface.getChestCount(this.activityId, this.randomTypeId);
/* 24 */     if (ret >= 0)
/*    */     {
/* 26 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "散财宝箱数量:" + ret);
/* 27 */       return true;
/*    */     }
/* 29 */     if (ret == 63956)
/*    */     {
/* 31 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "活动信息不存在");
/* 32 */       return false;
/*    */     }
/* 34 */     if (ret == 63955)
/*    */     {
/* 36 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "通行证类型信息不存在");
/* 37 */       return false;
/*    */     }
/* 39 */     if (ret == 63954)
/*    */     {
/* 41 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "参数错误");
/* 42 */       return false;
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\PGM_GetChestCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */