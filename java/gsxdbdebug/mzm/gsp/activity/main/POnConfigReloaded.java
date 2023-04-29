/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.config.event.ConfigReloadedProcedure;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ public class POnConfigReloaded extends ConfigReloadedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     Map<Integer, Long> openActivityidToTime = new HashMap();
/* 14 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 15 */     for (SActivityCfg sActivityCfg : SActivityCfg.getAll().values()) {
/* 16 */       if (SActivityCfg.getOld(sActivityCfg.id) == null)
/*    */       {
/* 18 */         ActivityManager.initDateObserver(sActivityCfg);
/* 19 */         ActivityManager.initLimitTimeSession(sActivityCfg);
/* 20 */         ActivityManager.initOpenTime(openActivityidToTime, curTime, sActivityCfg);
/* 21 */         if (!openActivityidToTime.containsKey(Integer.valueOf(sActivityCfg.id))) {
/* 22 */           ActivityManager.initActvityBeforeStartSession(sActivityCfg.id);
/*    */         }
/*    */       }
/*    */     }
/* 26 */     ActivityManager.initOpenActivity(openActivityidToTime, curTime);
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\POnConfigReloaded.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */