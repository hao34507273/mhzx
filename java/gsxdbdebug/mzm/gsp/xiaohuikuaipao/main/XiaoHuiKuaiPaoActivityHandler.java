/*    */ package mzm.gsp.xiaohuikuaipao.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoActivityCfg;
/*    */ import xbean.XiaoHuiKuaiPaoGlobalInfo;
/*    */ import xbean.XiaoHuiKuaiPaoPointInfo;
/*    */ import xtable.Activityid2xiaohuikuaipaoglobalinfo;
/*    */ import xtable.Role2xiaohuikuaipaopointinfo;
/*    */ 
/*    */ public class XiaoHuiKuaiPaoActivityHandler implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 17 */     XiaoHuiKuaiPaoActivityCfg xiaoHuiKuaiPaoActivityCfg = XiaoHuiKuaiPaoActivityCfg.get(activityid);
/* 18 */     if (xiaoHuiKuaiPaoActivityCfg == null)
/*    */     {
/* 20 */       return;
/*    */     }
/*    */     
/*    */ 
/* 24 */     XiaoHuiKuaiPaoManager.clearFanBaoDi(roleId, xiaoHuiKuaiPaoActivityCfg.lotteryViewCfgId);
/*    */     
/*    */ 
/* 27 */     XiaoHuiKuaiPaoPointInfo xXiaoHuiKuaiPaoPointInfo = Role2xiaohuikuaipaopointinfo.get(Long.valueOf(roleId));
/* 28 */     if (xXiaoHuiKuaiPaoPointInfo == null)
/*    */     {
/* 30 */       return;
/*    */     }
/* 32 */     if (xiaoHuiKuaiPaoActivityCfg.isClearPointExchangeInfo == 1)
/*    */     {
/* 34 */       xXiaoHuiKuaiPaoPointInfo.getCfgid2count().clear();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*    */   {
/* 41 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public java.util.List<mzm.gsp.activity.main.ActivityStage> getActivityStages()
/*    */   {
/* 47 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 54 */     long globalTableKeyId = GameServerInfoManager.toGlobalId(activityid);
/* 55 */     XiaoHuiKuaiPaoGlobalInfo xXiaoHuiKuaiPaoGlobalInfo = Activityid2xiaohuikuaipaoglobalinfo.get(Long.valueOf(globalTableKeyId));
/*    */     
/* 57 */     if (xXiaoHuiKuaiPaoGlobalInfo == null)
/*    */     {
/* 59 */       xXiaoHuiKuaiPaoGlobalInfo = xbean.Pod.newXiaoHuiKuaiPaoGlobalInfo();
/* 60 */       xXiaoHuiKuaiPaoGlobalInfo.setIsautodraw(true);
/* 61 */       Activityid2xiaohuikuaipaoglobalinfo.insert(Long.valueOf(globalTableKeyId), xXiaoHuiKuaiPaoGlobalInfo);
/*    */     }
/*    */   }
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\XiaoHuiKuaiPaoActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */