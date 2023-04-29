/*    */ package mzm.gsp.xiaohuikuaipao.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import xbean.XiaoHuiKuaiPaoGlobalInfo;
/*    */ import xtable.Activityid2xiaohuikuaipaoglobalinfo;
/*    */ 
/*    */ public class POnOpenChange extends mzm.gsp.open.event.OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if (((OpenChangeComplexArg)this.arg).getType() != 482)
/*    */     {
/* 14 */       return false;
/*    */     }
/* 16 */     long activityId = XiaoHuiKuaiPaoManager.getCurrentActivityId();
/* 17 */     if (activityId <= 0L)
/*    */     {
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     long globalTableKeyId = GameServerInfoManager.toGlobalId(activityId);
/*    */     
/* 24 */     XiaoHuiKuaiPaoGlobalInfo xXiaoHuiKuaiPaoGlobalInfo = Activityid2xiaohuikuaipaoglobalinfo.get(Long.valueOf(globalTableKeyId));
/*    */     
/* 26 */     if (xXiaoHuiKuaiPaoGlobalInfo == null)
/*    */     {
/* 28 */       xXiaoHuiKuaiPaoGlobalInfo = xbean.Pod.newXiaoHuiKuaiPaoGlobalInfo();
/* 29 */       Activityid2xiaohuikuaipaoglobalinfo.insert(Long.valueOf(globalTableKeyId), xXiaoHuiKuaiPaoGlobalInfo);
/*    */     }
/*    */     
/* 32 */     if (((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/* 34 */       xXiaoHuiKuaiPaoGlobalInfo.setIsautodraw(true);
/*    */     }
/*    */     else
/*    */     {
/* 38 */       xXiaoHuiKuaiPaoGlobalInfo.setIsautodraw(false);
/*    */     }
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */