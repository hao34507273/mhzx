/*     */ package mzm.gsp.instance.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.instance.confbean.SOperaInstanceCfg;
/*     */ import mzm.gsp.instance.event.JoinMultiInstanceArg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Role2instance;
/*     */ 
/*     */ public class PCChallengeTeamInstance extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int instanceid;
/*     */   
/*     */   public PCChallengeTeamInstance(long roleid, int instanceid)
/*     */   {
/*  26 */     this.roleid = roleid;
/*  27 */     this.instanceid = instanceid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  32 */     if (!TeamInstance.isTeamInstanceSwitchOpenForRole(this.roleid, this.instanceid)) {
/*  33 */       return false;
/*     */     }
/*     */     
/*  36 */     Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, false);
/*  37 */     if (teamid == null) {
/*  38 */       if (GameServer.logger().isDebugEnabled())
/*  39 */         GameServer.logger().debug("玩家没有队伍!!");
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     long teamLeaderid = TeamInterface.getTeamLeaderByTeamid(teamid.longValue(), false);
/*  44 */     if (teamLeaderid != this.roleid) {
/*  45 */       if (GameServer.logger().isDebugEnabled())
/*  46 */         GameServer.logger().debug("不是队长不能够进行挑战操作!!");
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     SOperaInstanceCfg operaInstanceCfg = InstanceCfgManager.getOperaInstanceCfg(this.instanceid);
/*     */     
/*  52 */     if (operaInstanceCfg == null) {
/*  53 */       if (GameServer.logger().isDebugEnabled())
/*  54 */         GameServer.logger().debug("挑战的副本不是队伍剧情副本!!!");
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     List<Long> roleids = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/*     */     
/*     */ 
/*  61 */     Map<Long, String> role2User = new HashMap();
/*  62 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long tmpRoleid = ((Long)i$.next()).longValue();
/*  63 */       role2User.put(Long.valueOf(tmpRoleid), RoleInterface.getUserId(tmpRoleid));
/*     */     }
/*  65 */     lock(xtable.User.getTable(), role2User.values());
/*     */     
/*  67 */     lock(Role2instance.getTable(), roleids);
/*     */     
/*  69 */     for (int i = 1; i < roleids.size(); i++) {
/*  70 */       long roleid = ((Long)roleids.get(i)).longValue();
/*  71 */       if (OpenInterface.isBanPlay(roleid, 7)) {
/*  72 */         OpenInterface.sendBanPlayMsg(this.roleid, roleid, RoleInterface.getName(roleid), 7);
/*     */         
/*  74 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  80 */     ActivityJoinResult joinResult = ActivityInterface.canJoinAndCheckTeamInstanceInitActivityData(role2User, roleids, operaInstanceCfg.activityid, this.instanceid);
/*     */     
/*  82 */     if (!joinResult.isCanJoin()) {
/*  83 */       if (joinResult.isActivityJoinCountMax()) {
/*  84 */         if (joinResult.getRoleId() == this.roleid) {
/*  85 */           GameServer.logger().info(String.format("[TeamInstance]PCChallengeTeamInstance.processImp@can not join activity|roleid=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(joinResult.getReasonValue()) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*  90 */           return false;
/*     */         }
/*     */       }
/*     */       else {
/*  94 */         GameServer.logger().info(String.format("[TeamInstance]PCChallengeTeamInstance.processImp@can not join activity|roleid=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(joinResult.getReasonValue()) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  99 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 105 */     if (!TeamInstance.canEnterInstance(this.instanceid, roleids)) {
/* 106 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 111 */     xbean.InstanceBean xInstanceBean = Role2instance.get(Long.valueOf(this.roleid));
/* 112 */     int leaderProcess = TeamInstance.getRoleInstanceProcess(this.instanceid, xInstanceBean);
/* 113 */     if (ActivityInterface.isToMaxCount((String)role2User.get(role2User), this.roleid, operaInstanceCfg.activityid)) {
/* 114 */       if (GameServer.logger().isDebugEnabled())
/* 115 */         GameServer.logger().debug("队长已经完成了，不能够带队进副本了!!");
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     mzm.gsp.confirm.main.TeamConfirmInterface.startTeamConfirm(teamid.longValue(), operaInstanceCfg.confirmType, new TeamInstanceConfirmContext(this.instanceid, leaderProcess, roleids));
/*     */     
/*     */ 
/*     */ 
/* 123 */     long endTime = ActivityInterface.getActivityEndTime(operaInstanceCfg.activityid);
/* 124 */     JoinMultiInstanceArg joinMultiInstanceArg = new JoinMultiInstanceArg(roleids, endTime, this.instanceid);
/* 125 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.instance.event.JoinMultiInstanceEvent(), joinMultiInstanceArg);
/*     */     
/* 127 */     GameServer.logger().info(String.format("[instance]PCChallengeTeamInstance.processImp@challenge team instance|roleid=%d|teamid=%d|team_members=%s|instance_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), teamid, roleids.toString(), Integer.valueOf(this.instanceid) }));
/*     */     
/*     */ 
/*     */ 
/* 131 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\PCChallengeTeamInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */