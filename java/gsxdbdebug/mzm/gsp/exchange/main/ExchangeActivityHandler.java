/*    */ package mzm.gsp.exchange.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import xbean.ExchangeActivityInfo;
/*    */ import xbean.ExchangeInfo;
/*    */ import xbean.Pod;
/*    */ import xtable.Role2exchangeinfo;
/*    */ 
/*    */ public class ExchangeActivityHandler implements mzm.gsp.activity.main.ActivityHandler
/*    */ {
/*    */   public java.util.List<mzm.gsp.activity.main.ActivityStage> getActivityStages()
/*    */   {
/* 14 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*    */   {
/* 20 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 44 */     ExchangeInfo xExchangeInfo = Role2exchangeinfo.get(Long.valueOf(roleId));
/* 45 */     if (xExchangeInfo == null)
/*    */     {
/* 47 */       xExchangeInfo = Pod.newExchangeInfo();
/* 48 */       Role2exchangeinfo.insert(Long.valueOf(roleId), xExchangeInfo);
/*    */     }
/*    */     
/* 51 */     ExchangeActivityInfo xExchangeActivityInfo = (ExchangeActivityInfo)xExchangeInfo.getExchange_activity_infos().get(Integer.valueOf(activityid));
/* 52 */     if (xExchangeActivityInfo == null)
/*    */     {
/* 54 */       xExchangeActivityInfo = Pod.newExchangeActivityInfo();
/* 55 */       xExchangeInfo.getExchange_activity_infos().put(Integer.valueOf(activityid), xExchangeActivityInfo);
/*    */     }
/* 57 */     xExchangeActivityInfo.getExchange_award_infos().clear();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\exchange\main\ExchangeActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */