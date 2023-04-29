/*    */ package mzm.gsp.mibao.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.mibao.confbean.SBaoKuDrawLotteryCfg;
/*    */ import xbean.Role2MiBaoInfo;
/*    */ import xtable.Role2mibao;
/*    */ 
/*    */ public class MiBaoActivityHandler implements ActivityHandler
/*    */ {
/*    */   public void initData(String userId, long roleId, int turn, int activityid)
/*    */   {
/* 16 */     Role2MiBaoInfo xRole2MiBaoInfo = Role2mibao.get(Long.valueOf(roleId));
/* 17 */     if (xRole2MiBaoInfo == null)
/*    */     {
/* 19 */       xRole2MiBaoInfo = xbean.Pod.newRole2MiBaoInfo();
/* 20 */       xRole2MiBaoInfo.setIs_exchange_score(true);
/* 21 */       xRole2MiBaoInfo.setShould_exchange_score_limit_begin_time(0L);
/* 22 */       xRole2MiBaoInfo.setShould_exchange_score_limit_end_time(0L);
/*    */       
/* 24 */       Role2mibao.add(Long.valueOf(roleId), xRole2MiBaoInfo);
/*    */     }
/* 26 */     xRole2MiBaoInfo.setBuy_times_today(0);
/* 27 */     if (SBaoKuDrawLotteryCfg.getAll().isEmpty())
/*    */     {
/* 29 */       return;
/*    */     }
/* 31 */     xRole2MiBaoInfo.setCurrent_index_id(((Integer)SBaoKuDrawLotteryCfg.getAll().keySet().iterator().next()).intValue());
/*    */   }
/*    */   
/*    */ 
/*    */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*    */   {
/* 37 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public java.util.List<mzm.gsp.activity.main.ActivityStage> getActivityStages()
/*    */   {
/* 43 */     return null;
/*    */   }
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\main\MiBaoActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */