/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AccumulateBuyYuanBao
/*    */   extends AbstractAccumulate
/*    */ {
/*    */   public int getType()
/*    */   {
/* 18 */     return 4601;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initParams(AchievementInfo xAchievementInfo)
/*    */   {
/* 24 */     xAchievementInfo.getGoal_parameters().add(Integer.valueOf(0));
/* 25 */     xAchievementInfo.getGoal_parameters_extra().put(Long.valueOf(0L), String.valueOf(0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 33 */     int saveAmt = (int)QingfuInterface.getSaveAmt(RoleInterface.getUserId(roleId), false);
/*    */     
/* 35 */     List<Integer> xAccumulateGoalParameter = xAchievementInfo.getGoal_parameters();
/* 36 */     int xAccumulateValue = ((Integer)xAccumulateGoalParameter.get(0)).intValue();
/*    */     
/* 38 */     int xInitValue = Integer.valueOf((String)xAchievementInfo.getGoal_parameters_extra().get(Long.valueOf(0L))).intValue();
/*    */     
/* 40 */     int goalAccumulateValue = ((Integer)goalParameters.get(0)).intValue();
/*    */     
/* 42 */     int saveAmtFromActivity = saveAmt - xInitValue;
/*    */     
/* 44 */     if (saveAmtFromActivity != xAccumulateValue)
/*    */     {
/* 46 */       xAccumulateGoalParameter.set(0, Integer.valueOf(saveAmtFromActivity > goalAccumulateValue ? goalAccumulateValue : saveAmtFromActivity));
/*    */       
/* 48 */       return true;
/*    */     }
/* 50 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\AccumulateBuyYuanBao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */