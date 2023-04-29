/*    */ package mzm.gsp.xiaohuikuaipao.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import xbean.XiaoHuiKuaiPaoGlobalInfo;
/*    */ import xtable.Activityid2xiaohuikuaipaoglobalinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XiaoHuiKuaiPaoInterface
/*    */ {
/*    */   public static boolean setXHKPGlobal(int activityId, int isAutoDraw)
/*    */   {
/* 19 */     long globalTableKeyId = GameServerInfoManager.toGlobalId(activityId);
/*    */     
/* 21 */     XiaoHuiKuaiPaoGlobalInfo xXiaoHuiKuaiPaoGlobalInfo = Activityid2xiaohuikuaipaoglobalinfo.get(Long.valueOf(globalTableKeyId));
/*    */     
/* 23 */     if (xXiaoHuiKuaiPaoGlobalInfo == null)
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     xXiaoHuiKuaiPaoGlobalInfo.setIsautodraw(isAutoDraw == 1);
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\XiaoHuiKuaiPaoInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */