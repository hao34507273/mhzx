/*    */ package mzm.gsp.xiaohuikuaipao.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.XiaoHuiKuaiPaoInfo;
/*    */ 
/*    */ public class PGM_SetXHKPTurnCount extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   final int activityId;
/*    */   final int turnCount;
/*    */   
/*    */   public PGM_SetXHKPTurnCount(long targetRoleId, long gmRoleId, int activityId, int turnCount)
/*    */   {
/* 15 */     this.targetRoleId = targetRoleId;
/* 16 */     this.gmRoleId = gmRoleId;
/* 17 */     this.activityId = activityId;
/* 18 */     this.turnCount = turnCount;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     if (this.turnCount < 0)
/*    */     {
/* 26 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "错误：圈数为负数");
/* 27 */       return false;
/*    */     }
/* 29 */     xbean.XiaoHuiKuaiPaoActivityInfo xXiaoHuiKuaiPaoActivityInfo = xtable.Role2xiaohuikuaipaoactivityinfo.get(Long.valueOf(this.targetRoleId));
/*    */     
/* 31 */     if (xXiaoHuiKuaiPaoActivityInfo == null)
/*    */     {
/* 33 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "错误：数据不存在");
/* 34 */       return false;
/*    */     }
/* 36 */     XiaoHuiKuaiPaoInfo xXiaoHuiKuaiPaoInfo = (XiaoHuiKuaiPaoInfo)xXiaoHuiKuaiPaoActivityInfo.getActivityid2xiaohuikuaipaoinfo().get(Integer.valueOf(this.activityId));
/*    */     
/* 38 */     if (xXiaoHuiKuaiPaoInfo == null)
/*    */     {
/* 40 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "错误：数据不存在");
/* 41 */       return false;
/*    */     }
/* 43 */     xXiaoHuiKuaiPaoInfo.setAccumulateturncount(this.turnCount);
/* 44 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "设置成功");
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\PGM_SetXHKPTurnCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */