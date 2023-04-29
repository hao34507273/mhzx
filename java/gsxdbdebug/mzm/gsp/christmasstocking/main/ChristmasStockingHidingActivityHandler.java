/*    */ package mzm.gsp.christmasstocking.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.Role2ChristmasStockingInfo;
/*    */ 
/*    */ public class ChristmasStockingHidingActivityHandler implements ActivityHandler
/*    */ {
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 18 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 24 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 31 */     Role2ChristmasStockingInfo xRole2ChristmasStockingInfo = ChristmasStockingManager.getRole2ChristmasStockingInfo(roleId);
/* 32 */     xRole2ChristmasStockingInfo.setGetstockinghidingawardnum(0);
/* 33 */     xRole2ChristmasStockingInfo.setHasgotstockinghidingmail(false);
/*    */   }
/*    */   
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
/*    */ 
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 55 */     if (!OpenInterface.getOpenStatus(583))
/*    */     {
/* 57 */       return;
/*    */     }
/*    */     
/*    */ 
/* 61 */     ChristmasStockingManager.triggerStockingAddEvent();
/*    */     
/*    */ 
/* 64 */     List<Long> allRoles = OnlineManager.getInstance().getAllRolesInWorld();
/* 65 */     for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 67 */       NoneRealTimeTaskManager.getInstance().addTask(new PSendStockingHidingNotifyMail(roleId));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\main\ChristmasStockingHidingActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */