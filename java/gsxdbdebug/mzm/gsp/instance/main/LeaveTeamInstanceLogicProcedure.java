/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.instance.confbean.SOperaInstanceCfg;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.InstanceCacheBean;
/*    */ import xtable.Instance;
/*    */ 
/*    */ public class LeaveTeamInstanceLogicProcedure extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityid;
/*    */   
/*    */   public LeaveTeamInstanceLogicProcedure(long roleid, int activityid)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.activityid = activityid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     Long instanceUuid = xtable.Role2instanceuuid.select(Long.valueOf(this.roleid));
/* 22 */     if (instanceUuid == null) {
/* 23 */       return false;
/*    */     }
/* 25 */     InstanceCacheBean xInstanceCacheBean = Instance.select(instanceUuid);
/* 26 */     if (xInstanceCacheBean == null) {
/* 27 */       return false;
/*    */     }
/* 29 */     int instanceid = xInstanceCacheBean.getInstancecfgid();
/* 30 */     SOperaInstanceCfg operaInstanceCfg = InstanceCfgManager.getOperaInstanceCfg(instanceid);
/* 31 */     if (operaInstanceCfg == null) {
/* 32 */       return false;
/*    */     }
/* 34 */     if (operaInstanceCfg.activityid != this.activityid) {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, false);
/* 39 */     if (teamid == null) {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     long leaderid = TeamInterface.getTeamLeaderByTeamid(teamid.longValue(), false);
/* 44 */     if (this.roleid != leaderid) {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     java.util.List<Long> memList = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/* 49 */     if (memList.size() <= 0) {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     lock(xtable.Role2instance.getTable(), memList);
/*    */     
/* 55 */     InstanceCacheBean xInstanceTeamCacheBean = Instance.get(instanceUuid);
/* 56 */     if (xInstanceTeamCacheBean == null) {
/* 57 */       return false;
/*    */     }
/* 59 */     return TeamInstance.onleaveInstance(memList, instanceUuid.longValue(), xInstanceTeamCacheBean);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\LeaveTeamInstanceLogicProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */