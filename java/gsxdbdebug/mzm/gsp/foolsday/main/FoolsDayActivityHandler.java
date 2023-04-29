/*    */ package mzm.gsp.foolsday.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.foolsday.confbean.FoolsDayConsts;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.FoolsDayInfo;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleFoolsDayInfo;
/*    */ import xtable.Role_fools_day_infos;
/*    */ 
/*    */ public class FoolsDayActivityHandler implements ActivityHandler
/*    */ {
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 20 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 26 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 33 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 34 */     RoleFoolsDayInfo xRoleFoolsDayInfo = Role_fools_day_infos.get(Long.valueOf(roleId));
/* 35 */     if (xRoleFoolsDayInfo == null)
/*    */     {
/* 37 */       xRoleFoolsDayInfo = Pod.newRoleFoolsDayInfo();
/* 38 */       Role_fools_day_infos.insert(Long.valueOf(roleId), xRoleFoolsDayInfo);
/*    */     }
/* 40 */     FoolsDayInfo xFoolsDayInfo = (FoolsDayInfo)xRoleFoolsDayInfo.getFools_day_infos().get(Integer.valueOf(FoolsDayConsts.getInstance().ACTIVITY_CFG_ID));
/*    */     
/* 42 */     if (xFoolsDayInfo == null)
/*    */     {
/* 44 */       xFoolsDayInfo = Pod.newFoolsDayInfo();
/* 45 */       xRoleFoolsDayInfo.getFools_day_infos().put(Integer.valueOf(FoolsDayConsts.getInstance().ACTIVITY_CFG_ID), xFoolsDayInfo);
/* 46 */       xFoolsDayInfo.getAlternative_buff_cfg_ids().addAll(FoolsDayManager.getAlternativeBuffCfgids());
/* 47 */       xFoolsDayInfo.getOpen_chest_maker_ids().clear();
/* 48 */       xFoolsDayInfo.setOpen_chest_maker_ids_timestamp(now);
/*    */     }
/* 50 */     xFoolsDayInfo.setMake_chest_num(0);
/* 51 */     xFoolsDayInfo.getAlternative_buff_cfg_ids().clear();
/* 52 */     xFoolsDayInfo.getAlternative_buff_cfg_ids().addAll(FoolsDayManager.getAlternativeBuffCfgids());
/* 53 */     xFoolsDayInfo.setRefresh_time(0);
/*    */   }
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\main\FoolsDayActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */