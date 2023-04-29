/*    */ package mzm.gsp.feisheng.developitem;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import xbean.FeiShengDevelopItemInfo;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleFeiShengDevelopItemInfo;
/*    */ import xtable.Role_fei_sheng_develop_item_infos;
/*    */ 
/*    */ public class FeiShengDevelopItemActivityHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 19 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 25 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 31 */     RoleFeiShengDevelopItemInfo xRoleFeiShengDevelopItemInfo = Role_fei_sheng_develop_item_infos.get(Long.valueOf(roleId));
/* 32 */     if (xRoleFeiShengDevelopItemInfo == null)
/*    */     {
/* 34 */       xRoleFeiShengDevelopItemInfo = Pod.newRoleFeiShengDevelopItemInfo();
/* 35 */       Role_fei_sheng_develop_item_infos.insert(Long.valueOf(roleId), xRoleFeiShengDevelopItemInfo);
/*    */     }
/* 37 */     FeiShengDevelopItemInfo xFeiShengDevelopItemInfo = (FeiShengDevelopItemInfo)xRoleFeiShengDevelopItemInfo.getFei_sheng_develop_item_infos().get(Integer.valueOf(activityid));
/*    */     
/* 39 */     if (xFeiShengDevelopItemInfo == null)
/*    */     {
/* 41 */       xFeiShengDevelopItemInfo = Pod.newFeiShengDevelopItemInfo();
/* 42 */       xRoleFeiShengDevelopItemInfo.getFei_sheng_develop_item_infos().put(Integer.valueOf(activityid), xFeiShengDevelopItemInfo);
/*    */     }
/*    */   }
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\developitem\FeiShengDevelopItemActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */