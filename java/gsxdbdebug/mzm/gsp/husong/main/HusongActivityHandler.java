/*    */ package mzm.gsp.husong.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import xbean.HuSongDataBean;
/*    */ import xbean.Pod;
/*    */ import xtable.Role2husong;
/*    */ 
/*    */ public class HusongActivityHandler implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 15 */     HuSongDataBean xHuSongDataBean = Role2husong.get(Long.valueOf(roleId));
/* 16 */     if (xHuSongDataBean == null)
/*    */     {
/* 18 */       xHuSongDataBean = Pod.newHuSongDataBean();
/* 19 */       Role2husong.insert(Long.valueOf(roleId), xHuSongDataBean);
/*    */     }
/* 21 */     xHuSongDataBean.setSpecialcount(0);
/*    */   }
/*    */   
/*    */ 
/*    */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*    */   {
/* 27 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public java.util.List<ActivityStage> getActivityStages()
/*    */   {
/* 33 */     return new ArrayList();
/*    */   }
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stageIndex, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\husong\main\HusongActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */