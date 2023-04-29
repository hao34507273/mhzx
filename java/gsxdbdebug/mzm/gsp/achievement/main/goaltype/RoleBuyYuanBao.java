/*    */ package mzm.gsp.achievement.main.goaltype;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.AchievementInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleBuyYuanBao
/*    */   extends AbstractDoneOneEventTimes
/*    */ {
/*    */   public int getType()
/*    */   {
/* 18 */     return 4600;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean innerCheckGoalState(long roleId, SAchievementGoalCfg sAchievementGoalCfg, AchievementInfo xAchievementInfo, List<Integer> goalParameters)
/*    */   {
/* 26 */     int yuanbao = (int)QingfuInterface.getSaveAmt(RoleInterface.getUserId(roleId), false);
/* 27 */     if (yuanbao > 0)
/*    */     {
/*    */ 
/* 30 */       xAchievementInfo.getGoal_parameters().set(0, Integer.valueOf(1));
/* 31 */       return true;
/*    */     }
/* 33 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\RoleBuyYuanBao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */