/*    */ package mzm.gsp.xiaohuikuaipao.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.XiaoHuiKuaiPaoGlobalInfo;
/*    */ 
/*    */ public class PGM_SetXHKPGlobal extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final long gmRoleId;
/*    */   final int activityId;
/*    */   final int isAutoDraw;
/*    */   
/*    */   public PGM_SetXHKPGlobal(long gmRoleId, int activityId, int isAutoDraw)
/*    */   {
/* 15 */     this.gmRoleId = gmRoleId;
/* 16 */     this.activityId = activityId;
/* 17 */     this.isAutoDraw = isAutoDraw;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     long globalTableKeyId = GameServerInfoManager.toGlobalId(this.activityId);
/*    */     
/* 26 */     XiaoHuiKuaiPaoGlobalInfo xXiaoHuiKuaiPaoGlobalInfo = xtable.Activityid2xiaohuikuaipaoglobalinfo.get(Long.valueOf(globalTableKeyId));
/*    */     
/* 28 */     if (xXiaoHuiKuaiPaoGlobalInfo == null)
/*    */     {
/* 30 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("没有该活动[%d]信息", new Object[] { Integer.valueOf(this.activityId) }));
/* 31 */       return false;
/*    */     }
/* 33 */     xXiaoHuiKuaiPaoGlobalInfo.setIsautodraw(this.isAutoDraw == 1);
/* 34 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "设置成功");
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\PGM_SetXHKPGlobal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */