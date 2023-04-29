/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_SetExtraRate
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long gmRoleId;
/*    */   final int activityId;
/*    */   final int passTypeId;
/*    */   final int rate;
/*    */   
/*    */   public PGM_SetExtraRate(long gmRoleId, int activityId, int passTypeId, int rate)
/*    */   {
/* 16 */     this.gmRoleId = gmRoleId;
/* 17 */     this.activityId = activityId;
/* 18 */     this.passTypeId = passTypeId;
/* 19 */     this.rate = rate;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     int idipRet = DrawCarnivalInterface.setExtraRate(this.activityId, this.passTypeId, this.rate);
/* 26 */     if (idipRet == 0)
/*    */     {
/* 28 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "设置成功");
/* 29 */       return true;
/*    */     }
/* 31 */     if (idipRet == 63956)
/*    */     {
/* 33 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "活动信息不存在");
/* 34 */       return false;
/*    */     }
/* 36 */     if (idipRet == 63955)
/*    */     {
/* 38 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "通行证类型信息不存在");
/* 39 */       return false;
/*    */     }
/* 41 */     if (idipRet == 63954)
/*    */     {
/* 43 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "参数错误");
/* 44 */       return false;
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\PGM_SetExtraRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */