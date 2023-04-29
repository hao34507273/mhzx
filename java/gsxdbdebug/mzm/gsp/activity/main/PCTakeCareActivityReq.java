/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.ActivityCareMap;
/*    */ 
/*    */ public class PCTakeCareActivityReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int activityCfgId;
/*    */   private int active;
/*    */   
/*    */   public PCTakeCareActivityReq(long roleid, int activityCfgId, int active)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.activityCfgId = activityCfgId;
/* 18 */     this.active = active;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     ActivityCareMap xActivityCareMap = xtable.Role2activitycare.get(Long.valueOf(this.roleid));
/* 24 */     mzm.gsp.activity.STakeCareActivityRes sSyncCareActivity = new mzm.gsp.activity.STakeCareActivityRes();
/*    */     
/* 26 */     if (xActivityCareMap == null) {
/* 27 */       xActivityCareMap = xbean.Pod.newActivityCareMap();
/* 28 */       for (SActivityCfg sActivityCfg : SActivityCfg.getAll().values()) {
/* 29 */         xActivityCareMap.getActivitycaremap().put(Integer.valueOf(sActivityCfg.id), Integer.valueOf(0));
/*    */       }
/* 31 */       xtable.Role2activitycare.insert(Long.valueOf(this.roleid), xActivityCareMap);
/* 32 */       sSyncCareActivity.result = 1;
/* 33 */       sSyncCareActivity.activitycfgid = this.activityCfgId;
/* 34 */       OnlineManager.getInstance().send(this.roleid, sSyncCareActivity);
/* 35 */       return true;
/*    */     }
/*    */     
/* 38 */     int roleLevel = mzm.gsp.role.main.RoleInterface.getLevel(this.roleid);
/*    */     
/* 40 */     SActivityCfg sActivityCfg = SActivityCfg.get(this.activityCfgId);
/* 41 */     if ((sActivityCfg == null) || (sActivityCfg.levelMin > roleLevel) || (roleLevel > sActivityCfg.levelMax) || (sActivityCfg.levelMin == 0)) {
/* 42 */       sSyncCareActivity.result = 1;
/* 43 */       sSyncCareActivity.activitycfgid = this.activityCfgId;
/* 44 */       OnlineManager.getInstance().send(this.roleid, sSyncCareActivity);
/* 45 */       return true;
/*    */     }
/* 47 */     int state = ((Integer)xActivityCareMap.getActivitycaremap().get(Integer.valueOf(this.activityCfgId))).intValue();
/* 48 */     if (state == this.active) {
/* 49 */       sSyncCareActivity.result = 1;
/* 50 */       sSyncCareActivity.activitycfgid = this.activityCfgId;
/* 51 */       OnlineManager.getInstance().send(this.roleid, sSyncCareActivity);
/* 52 */       return true;
/*    */     }
/*    */     
/* 55 */     xActivityCareMap.getActivitycaremap().put(Integer.valueOf(this.activityCfgId), Integer.valueOf(this.active));
/* 56 */     sSyncCareActivity.result = 0;
/* 57 */     sSyncCareActivity.activitycfgid = this.activityCfgId;
/* 58 */     OnlineManager.getInstance().send(this.roleid, sSyncCareActivity);
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\PCTakeCareActivityReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */