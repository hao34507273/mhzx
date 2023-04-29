/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossbattle.SPointRaceLeaveSuccess;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PPointRaceReturnOriginal extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final int zoneid;
/* 14 */   private final List<Long> roleids = new ArrayList();
/*    */   
/*    */   private final int activityCfgid;
/*    */   private final int timePointCfgid;
/*    */   private final PointRaceCorpsInfo corpsInfo;
/*    */   private final int pvps;
/*    */   
/*    */   public PPointRaceReturnOriginal(int zoneid, List<Long> roleids, int activityCfgid, int timePointCfgid, PointRaceCorpsInfo corpsInfo, int pvps)
/*    */   {
/* 23 */     this.zoneid = zoneid;
/* 24 */     this.roleids.addAll(roleids);
/* 25 */     this.activityCfgid = activityCfgid;
/* 26 */     this.timePointCfgid = timePointCfgid;
/* 27 */     this.corpsInfo = corpsInfo;
/* 28 */     this.pvps = pvps;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     List<String> userids = new ArrayList();
/* 35 */     for (Iterator i$ = this.roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 37 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 38 */       userids.add(userid);
/*    */     }
/*    */     
/* 41 */     lock(User.getTable(), userids);
/* 42 */     lock(Basic.getTable(), this.roleids);
/*    */     
/*    */ 
/* 45 */     SPointRaceLeaveSuccess msg = new SPointRaceLeaveSuccess();
/* 46 */     OnlineManager.getInstance().sendMulti(msg, this.roleids);
/*    */     
/*    */ 
/* 49 */     for (Iterator i$ = this.roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 51 */       CrossBattlePointManager.unsetPointRaceTitle(roleid);
/*    */     }
/*    */     
/* 54 */     CrossBattlePointManager.doReturnOriginalServer(this.zoneid, this.roleids, this.activityCfgid, this.timePointCfgid, this.corpsInfo, this.pvps);
/*    */     
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PPointRaceReturnOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */