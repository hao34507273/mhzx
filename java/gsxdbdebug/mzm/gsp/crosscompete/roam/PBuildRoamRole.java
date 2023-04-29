/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import mzm.gsp.gang.main.GangManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoamCrossCompeteFaction;
/*    */ import xbean.RoamCrossCompeteRole;
/*    */ import xtable.Basic;
/*    */ import xtable.Gang;
/*    */ import xtable.Roam_crosscompete_role;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PBuildRoamRole extends LogicProcedure
/*    */ {
/*    */   private final String userid;
/*    */   private final long roleid;
/*    */   private final long factionid;
/*    */   private final long contextid;
/*    */   
/*    */   public PBuildRoamRole(String userid, long roleid, long factionid, long contextid)
/*    */   {
/* 25 */     this.userid = userid;
/* 26 */     this.roleid = roleid;
/* 27 */     this.factionid = factionid;
/* 28 */     this.contextid = contextid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     lock(User.getTable(), Arrays.asList(new String[] { this.userid }));
/*    */     
/* 36 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/* 38 */     lock(Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.factionid) }));
/*    */     
/* 40 */     RoamCrossCompeteFaction xRoamFaction = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(this.factionid, true);
/*    */     
/*    */ 
/* 43 */     if (xRoamFaction == null) {
/* 44 */       CrossCompeteManager.logError("PBuildRoamCrossCompeteRole.processImp@roam faction null|roleid=%d|factionid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.factionid) });
/*    */       
/*    */ 
/* 47 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 51 */     int dutyid = CrossCompeteRoamManager.getMemberDuty(xRoamFaction, this.roleid);
/* 52 */     if (dutyid < 0) {
/* 53 */       GangManager.logError("PBuildRoamCrossCompeteRole.processImp@no roam member duty|roleid=%d|factionid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.factionid) });
/*    */       
/*    */ 
/* 56 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 60 */     Roam_crosscompete_role.remove(Long.valueOf(this.roleid));
/*    */     
/* 62 */     RoamCrossCompeteRole xRoamRole = xbean.Pod.newRoamCrossCompeteRole();
/* 63 */     xRoamRole.setFactionid(this.factionid);
/* 64 */     xRoamRole.setDuty(dutyid);
/*    */     
/* 66 */     xRoamRole.setAction_point(SCrossCompeteConsts.getInstance().InitActionPoint);
/* 67 */     Roam_crosscompete_role.insert(Long.valueOf(this.roleid), xRoamRole);
/*    */     
/*    */ 
/* 70 */     CrossServerInterface.setUserRoamedInfo(this.userid, mzm.gsp.crossserver.main.RoamType.CROSS_COMPETE, this.contextid);
/*    */     
/* 72 */     GangManager.logInfo("PBuildRoamCrossCompeteRole.processImp@succeed|roleid=%d|factionid=%d|dutyid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.factionid), Integer.valueOf(dutyid) });
/*    */     
/*    */ 
/*    */ 
/* 76 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PBuildRoamRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */