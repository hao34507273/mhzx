/*    */ package mzm.gsp.singletask.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     Set<Integer> activityIds = getAllActivityIds();
/* 21 */     if ((activityIds == null) || (activityIds.size() == 0))
/*    */     {
/* 23 */       return false;
/*    */     }
/* 25 */     for (Iterator i$ = activityIds.iterator(); i$.hasNext();) { int activityId = ((Integer)i$.next()).intValue();
/*    */       
/* 27 */       NoneRealTimeTaskManager.getInstance().addTask(new PRoleActivityCheck(((Long)this.arg).longValue(), activityId));
/*    */     }
/* 29 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   Set<Integer> getAllActivityIds()
/*    */   {
/* 39 */     return ActivityInterface.getActivityIdsByLogicType(52);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singletask\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */