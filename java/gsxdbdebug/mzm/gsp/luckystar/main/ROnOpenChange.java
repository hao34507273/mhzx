/*    */ package mzm.gsp.luckystar.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.luckystar.confbean.SLuckyStarConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class ROnOpenChange extends OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 17 */     if (((OpenChangeComplexArg)this.arg).getType() != 197)
/*    */     {
/* 19 */       return;
/*    */     }
/*    */     
/* 22 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 23 */     long startTime = ActivityInterface.getActivityStartTime(SLuckyStarConsts.getInstance().LUCKY_STAR_ACTIVITY_CFG_ID);
/* 24 */     long endTime = ActivityInterface.getActivityEndTime(SLuckyStarConsts.getInstance().LUCKY_STAR_ACTIVITY_CFG_ID);
/*    */     
/* 26 */     if ((startTime > now) || (now > endTime))
/*    */     {
/* 28 */       return;
/*    */     }
/*    */     
/* 31 */     boolean isOpen = ((OpenChangeComplexArg)this.arg).isOpen();
/* 32 */     Iterator i$; if (isOpen)
/*    */     {
/* 34 */       for (i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */         
/* 36 */         NoneRealTimeTaskManager.getInstance().addTask(new POnActivityLimitStart.PCheckLuckyStarActivity(roleId));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */