/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.occupation.confbean.RoleCommonConstants;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.Activity2Vigor;
/*    */ import xbean.Properties;
/*    */ import xtable.Role2properties;
/*    */ import xtable.Role2vigor;
/*    */ 
/*    */ 
/*    */ public class VigorDayUpdateObserver
/*    */   extends DateObserver
/*    */ {
/*    */   private static long updateTimeStamp;
/*    */   
/*    */   public VigorDayUpdateObserver()
/*    */   {
/* 26 */     super(RoleCommonConstants.getInstance().VIGOR_REFRESH_TIME);
/* 27 */     updateTimeStamp = TimeUnit.MILLISECONDS.toMinutes(getPrevTriggerTime());
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 33 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 38 */         VigorDayUpdateObserver.access$002(TimeUnit.MILLISECONDS.toMinutes(DateTimeUtils.getCurrTimeInMillis()));
/* 39 */         List<Long> allRoles = OnlineManager.getInstance().getAllRolesInWorld();
/* 40 */         for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*    */           
/* 42 */           NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */           {
/*    */             protected boolean processImp()
/*    */               throws Exception
/*    */             {
/* 47 */               return VigorDayUpdateObserver.checkVigor(roleId);
/*    */             }
/*    */           });
/*    */         }
/* 51 */         return true;
/*    */       }
/* 53 */     }.execute();
/* 54 */     return true;
/*    */   }
/*    */   
/*    */   public static void loginRole(long roleId)
/*    */   {
/* 59 */     Properties xProperties = Role2properties.get(Long.valueOf(roleId));
/* 60 */     if (xProperties.getVigorrefreshtime() < updateTimeStamp)
/*    */     {
/* 62 */       checkVigor(roleId);
/*    */     }
/*    */   }
/*    */   
/*    */   private static boolean checkVigor(long roleId)
/*    */   {
/* 68 */     Properties xProperties = Role2properties.get(Long.valueOf(roleId));
/* 69 */     if (xProperties == null)
/*    */     {
/* 71 */       return true;
/*    */     }
/* 73 */     int vigor = xProperties.getVigor();
/* 74 */     xProperties.setVigorrefreshtime(updateTimeStamp);
/*    */     
/* 76 */     Activity2Vigor xHistory = Role2vigor.get(Long.valueOf(roleId));
/* 77 */     if (xHistory != null)
/*    */     {
/* 79 */       xHistory.getAwardvigorhistorymap().clear();
/*    */     }
/*    */     
/* 82 */     int vigorLimit = RoleCommonConstants.getInstance().VIGOR_LIMIT;
/* 83 */     vigorLimit += RoleCommonConstants.getInstance().ADD_VIGOR_LIMIT_PERLV * (xProperties.getLevel() - 1);
/* 84 */     if (vigor <= vigorLimit)
/*    */     {
/* 86 */       return true;
/*    */     }
/*    */     
/* 89 */     vigor = vigorLimit;
/* 90 */     xProperties.setVigor(vigor);
/* 91 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\VigorDayUpdateObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */