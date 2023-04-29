/*    */ package mzm.gsp.luckystar.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.activity.event.ActivityLimitTimeStartArg;
/*    */ import mzm.gsp.activity.event.ActivityLimitTimeStartProcedure;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.luckystar.confbean.SLuckyStarConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnActivityLimitStart extends ActivityLimitTimeStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     int activityCfgId = ((ActivityLimitTimeStartArg)this.arg).activityid;
/* 21 */     if (activityCfgId != SLuckyStarConsts.getInstance().LUCKY_STAR_ACTIVITY_CFG_ID)
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     if (!OpenInterface.getOpenStatus(197))
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 33 */       NoneRealTimeTaskManager.getInstance().addTask(new PCheckLuckyStarActivity(roleId));
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public static class PCheckLuckyStarActivity extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     
/*    */     public PCheckLuckyStarActivity(long roleId)
/*    */     {
/* 44 */       this.roleId = roleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 50 */       String userId = RoleInterface.getUserId(this.roleId);
/*    */       
/* 52 */       lock(Lockeys.get(User.getTable(), userId));
/*    */       
/* 54 */       int luckyStarActivityCfgId = SLuckyStarConsts.getInstance().LUCKY_STAR_ACTIVITY_CFG_ID;
/* 55 */       ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, luckyStarActivityCfgId);
/*    */       
/* 57 */       if (!activityJoinResult.isCanJoin())
/*    */       {
/* 59 */         return false;
/*    */       }
/*    */       
/* 62 */       LuckyStarManager.checkAndInitLuckyStarActivity(userId, this.roleId, luckyStarActivityCfgId, "PCheckLuckyStarActivity.processImp");
/*    */       
/*    */ 
/* 65 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\main\POnActivityLimitStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */