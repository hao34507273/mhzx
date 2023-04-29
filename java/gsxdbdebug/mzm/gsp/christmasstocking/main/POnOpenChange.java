/*    */ package mzm.gsp.christmasstocking.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity4.confbean.SChristmasStockingHidingConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class POnOpenChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     if (((OpenChangeComplexArg)this.arg).getType() == 582)
/*    */     {
/* 19 */       if ((((OpenChangeComplexArg)this.arg).isOpen()) && (ChristmasStockingManager.isActivityOpenOrNeedRetain()))
/*    */       {
/*    */ 
/* 22 */         ChristmasStockingManager.triggerTreeAddEvent();
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 27 */         ChristmasStockingManager.triggerTreeRemoveEvent();
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 32 */     int activityId = SChristmasStockingHidingConsts.getInstance().ACTIVITY_ID;
/* 33 */     if (((OpenChangeComplexArg)this.arg).getType() == 583) {
/*    */       Iterator i$;
/* 35 */       if ((((OpenChangeComplexArg)this.arg).isOpen()) && (ActivityInterface.isActivityOpen(activityId)))
/*    */       {
/*    */ 
/* 38 */         ChristmasStockingManager.triggerStockingAddEvent();
/*    */         
/*    */ 
/* 41 */         List<Long> allRoles = OnlineManager.getInstance().getAllRolesInWorld();
/* 42 */         for (i$ = allRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */           
/* 44 */           NoneRealTimeTaskManager.getInstance().addTask(new PSendStockingHidingNotifyMail(roleId));
/*    */         }
/*    */         
/*    */       }
/*    */       else
/*    */       {
/* 50 */         ChristmasStockingManager.triggerStockingRemoveEvent();
/*    */       }
/*    */     }
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */