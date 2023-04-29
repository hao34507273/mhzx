/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*    */ import mzm.gsp.instance.confbean.SOperaInstanceCfg;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.InstanceCacheBean;
/*    */ import xtable.Instance;
/*    */ import xtable.Role2instance;
/*    */ 
/*    */ public class PCLeaveInstance extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PCLeaveInstance(long roleid)
/*    */   {
/* 19 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     Long instanceUuid = xtable.Role2instanceuuid.select(Long.valueOf(this.roleid));
/* 26 */     if (instanceUuid == null) {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     InstanceCacheBean xInstanceCacheData = Instance.select(instanceUuid);
/* 31 */     if (xInstanceCacheData == null) {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     if (mzm.gsp.fight.main.FightInterface.isInFight(this.roleid)) {
/* 36 */       return false;
/*    */     }
/* 38 */     int instanceCfgid = xInstanceCacheData.getInstancecfgid();
/* 39 */     SInstanceCfg instanceCfg = SInstanceCfg.get(instanceCfgid);
/* 40 */     switch (instanceCfg.instanceType)
/*    */     {
/*    */ 
/*    */     case 1: 
/* 44 */       xbean.InstanceBean xInstanceBean = Role2instance.get(Long.valueOf(this.roleid));
/*    */       
/* 46 */       InstanceCacheBean xInstanceCacheBean = Instance.get(instanceUuid);
/*    */       
/*    */ 
/* 49 */       if (xInstanceCacheBean == null) {
/* 50 */         return false;
/*    */       }
/* 52 */       return SingleInstance.onleaveInstance(this.roleid, instanceUuid.longValue(), xInstanceCacheBean, xInstanceBean);
/*    */     
/*    */     case 2: 
/* 55 */       Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, false);
/* 56 */       if (teamid == null) {
/* 57 */         return false;
/*    */       }
/*    */       
/* 60 */       List<Long> allTeamMembers = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/* 61 */       if (allTeamMembers.size() <= 0) {
/* 62 */         return false;
/*    */       }
/*    */       
/* 65 */       if (!TeamInterface.isTeamLeader(teamid.longValue(), this.roleid, false)) {
/* 66 */         return false;
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 71 */       lock(Role2instance.getTable(), allTeamMembers);
/*    */       
/* 73 */       InstanceCacheBean xInstanceCacheTeamBean = Instance.get(instanceUuid);
/*    */       
/*    */ 
/* 76 */       if (xInstanceCacheTeamBean == null) {
/* 77 */         return false;
/*    */       }
/*    */       
/* 80 */       SOperaInstanceCfg operaInstanceCfg = InstanceCfgManager.getOperaInstanceCfg(instanceCfg.id);
/* 81 */       if (operaInstanceCfg.awardpoolid > 0) {
/* 82 */         int awradKey = InstanceExtra.TEAM_INSTANCE_AWARD_STATUS.ordinal();
/* 83 */         Integer awardState = (Integer)xInstanceCacheTeamBean.getExtra().get(Integer.valueOf(awradKey));
/* 84 */         if ((awardState != null) && (awardState.intValue() == 1)) {
/* 85 */           InstanceManager.sendNormalRet(this.roleid, 11, new String[0]);
/* 86 */           return false;
/*    */         }
/*    */       }
/* 89 */       return TeamInstance.onleaveInstance(allTeamMembers, instanceUuid.longValue(), xInstanceCacheTeamBean); }
/*    */     
/* 91 */     GameServer.logger().info("不存在的instanceManage! type:" + instanceCfg.instanceType);
/*    */     
/*    */ 
/*    */ 
/* 95 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\PCLeaveInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */