/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.SSyncCareActivity;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import xbean.ActivityCareMap;
/*    */ 
/*    */ public class PCGetCareActivityReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PCGetCareActivityReq(long roleid)
/*    */   {
/* 14 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     ActivityCareMap activityCareMap = xtable.Role2activitycare.select(Long.valueOf(this.roleid));
/* 21 */     SSyncCareActivity sSyncCareActivity = new SSyncCareActivity();
/* 22 */     int roleLevel = mzm.gsp.role.main.RoleInterface.getLevel(this.roleid);
/* 23 */     if (activityCareMap == null) {
/* 24 */       activityCareMap = xbean.Pod.newActivityCareMap();
/* 25 */       for (SActivityCfg sActivityCfg : SActivityCfg.getAll().values()) {
/* 26 */         activityCareMap.getActivitycaremap().put(Integer.valueOf(sActivityCfg.id), Integer.valueOf(0));
/* 27 */         if ((sActivityCfg.levelMin > 0) && (roleLevel >= sActivityCfg.levelMin) && (roleLevel <= sActivityCfg.levelMax)) {
/* 28 */           sSyncCareActivity.caremap.put(Integer.valueOf(sActivityCfg.id), Integer.valueOf(0));
/*    */         }
/*    */       }
/* 31 */       xtable.Role2activitycare.insert(Long.valueOf(this.roleid), activityCareMap);
/*    */     } else {
/* 33 */       for (SActivityCfg sActivityCfg : SActivityCfg.getAll().values()) {
/* 34 */         if ((sActivityCfg.levelMin > 0) && (roleLevel >= sActivityCfg.levelMin) && (roleLevel <= sActivityCfg.levelMax)) {
/* 35 */           Integer careFlag = (Integer)activityCareMap.getActivitycaremap().get(Integer.valueOf(sActivityCfg.id));
/* 36 */           if (careFlag == null) {
/* 37 */             careFlag = Integer.valueOf(0);
/*    */           }
/* 39 */           sSyncCareActivity.caremap.put(Integer.valueOf(sActivityCfg.id), careFlag);
/*    */         }
/*    */       }
/*    */     }
/* 43 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleid, sSyncCareActivity);
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\PCGetCareActivityReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */