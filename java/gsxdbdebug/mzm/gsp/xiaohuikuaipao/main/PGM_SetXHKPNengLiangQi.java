/*    */ package mzm.gsp.xiaohuikuaipao.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoActivityCfg;
/*    */ import xbean.XiaoHuiKuaiPaoInfo;
/*    */ 
/*    */ public class PGM_SetXHKPNengLiangQi extends LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   final int count;
/*    */   final int activityId;
/*    */   
/*    */   public PGM_SetXHKPNengLiangQi(long targetRoleId, long gmRoleId, int count, int activityId)
/*    */   {
/* 18 */     this.targetRoleId = targetRoleId;
/* 19 */     this.gmRoleId = gmRoleId;
/* 20 */     this.count = count;
/* 21 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if (this.count < 0)
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "能量旗数量要大于等于0");
/* 30 */       return false;
/*    */     }
/* 32 */     SActivityCfg activityCfg = SActivityCfg.get(this.activityId);
/* 33 */     if ((activityCfg == null) || (activityCfg.activityLogicType != 124))
/*    */     {
/* 35 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "活动id错误");
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     XiaoHuiKuaiPaoInfo xXiaoHuiKuaiPaoInfo = XiaoHuiKuaiPaoManager.getXiaoHuiKuaiPaoInfo(this.targetRoleId, this.activityId, XiaoHuiKuaiPaoActivityCfg.get(this.activityId));
/*    */     
/* 41 */     xXiaoHuiKuaiPaoInfo.setTicketcount(this.count);
/* 42 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "能量旗设置成功");
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\PGM_SetXHKPNengLiangQi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */