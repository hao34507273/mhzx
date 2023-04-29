/*    */ package mzm.gsp.moneytree.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.moneytree.confbean.MoneyTreeConsts;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MoneyTreeActivityHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 22 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 28 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 40 */     if (!MoneyTreeManager.isMoneyTreeSwitchOpen())
/*    */     {
/* 42 */       return;
/*    */     }
/* 44 */     ControllerInterface.collectController(MoneyTreeConsts.getInstance().NPC_CONTROLLER_ID);
/*    */     
/* 46 */     StringBuilder sb = new StringBuilder();
/* 47 */     sb.append(String.format("[moneytree]MoneyTreeActivityHandler.onActivityEnd@money tree activity end", new Object[0]));
/* 48 */     MoneyTreeManager.logger.info(sb.toString());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 60 */     if (!MoneyTreeManager.isMoneyTreeSwitchOpen())
/*    */     {
/* 62 */       return;
/*    */     }
/* 64 */     ControllerInterface.triggerOrReSpawn(MapInterface.getBigWorldid(), MoneyTreeConsts.getInstance().NPC_CONTROLLER_ID);
/*    */     
/* 66 */     StringBuilder sb = new StringBuilder();
/* 67 */     sb.append(String.format("[moneytree]MoneyTreeActivityHandler.onActivityStart@money tree activity start", new Object[0]));
/* 68 */     MoneyTreeManager.logger.info(sb.toString());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\moneytree\main\MoneyTreeActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */