/*     */ package mzm.gsp.floor.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity3.confbean.FloorCfg;
/*     */ import mzm.gsp.activity3.confbean.SFloorActivityCfg;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GlobalFloorActivityInfo;
/*     */ import xbean.GlobalFloorInfo;
/*     */ import xbean.Pod;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Globalfloor;
/*     */ import xtable.Role2task;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCChallengeFloorReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int activityId;
/*     */   final int floor;
/*     */   long teamId;
/*  35 */   List<Long> lockMembers = new ArrayList();
/*  36 */   Map<Long, String> roleidToUserid = new HashMap();
/*     */   
/*  38 */   boolean isSingle = false;
/*     */   
/*     */   public PCChallengeFloorReq(long roleId, int activityId, int floor)
/*     */   {
/*  42 */     this.roleId = roleId;
/*  43 */     this.activityId = activityId;
/*  44 */     this.floor = floor;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  50 */     SFloorActivityCfg sFloorActivityCfg = SFloorActivityCfg.get(this.activityId);
/*  51 */     if (sFloorActivityCfg == null)
/*     */     {
/*  53 */       return false;
/*     */     }
/*  55 */     if (!OpenInterface.getOpenStatus(sFloorActivityCfg.activityOpenId))
/*     */     {
/*  57 */       return false;
/*     */     }
/*  59 */     FloorCfg floorCfg = FloorManager.getFloorCfg(this.activityId, this.floor);
/*  60 */     if (floorCfg == null)
/*     */     {
/*  62 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.processImp@ floor cfg is null!|roleId=%d|activityId=%d|floor=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.floor) }));
/*     */       
/*     */ 
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     if (!OpenInterface.getOpenStatus(floorCfg.floorOpenId))
/*     */     {
/*  70 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.processImp@ floor not open!|roleId=%d|activityId=%d|floor=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.floor) }));
/*     */       
/*     */ 
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  77 */     if (teamInfo != null)
/*     */     {
/*  79 */       this.teamId = teamInfo.getTeamId();
/*  80 */       if (teamInfo.isNormalState(this.roleId))
/*     */       {
/*     */ 
/*  83 */         this.lockMembers = teamInfo.getTeamNormalList();
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  88 */         this.isSingle = true;
/*  89 */         this.lockMembers.add(Long.valueOf(this.roleId));
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/*  95 */       this.isSingle = true;
/*  96 */       this.lockMembers.add(Long.valueOf(this.roleId));
/*     */     }
/*     */     
/*  99 */     for (Iterator i$ = this.lockMembers.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */       
/* 101 */       this.roleidToUserid.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/* 104 */     Lockeys.lock(User.getTable(), this.roleidToUserid.values());
/*     */     
/* 106 */     Lockeys.lock(Role2task.getTable(), this.lockMembers);
/*     */     
/* 108 */     if (this.teamId > 0L)
/*     */     {
/* 110 */       teamInfo = TeamInterface.getTeamInfo(teamInfo.getTeamId(), true);
/*     */     }
/*     */     
/* 113 */     GlobalFloorActivityInfo xGlobalFloorActivityInfo = Globalfloor.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 114 */     if (xGlobalFloorActivityInfo == null)
/*     */     {
/* 116 */       Globalfloor.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xGlobalFloorActivityInfo = Pod.newGlobalFloorActivityInfo());
/*     */     }
/*     */     
/* 119 */     GlobalFloorInfo xGlobalFloorInfo = (GlobalFloorInfo)xGlobalFloorActivityInfo.getActivityinfo().get(Integer.valueOf(this.activityId));
/* 120 */     if (xGlobalFloorInfo == null)
/*     */     {
/* 122 */       xGlobalFloorActivityInfo.getActivityinfo().put(Integer.valueOf(this.activityId), xGlobalFloorInfo = Pod.newGlobalFloorInfo());
/*     */     }
/*     */     
/* 125 */     if (!checkAFGetLock(teamInfo, this.lockMembers))
/*     */     {
/* 127 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.processImp@ team change!|roleId=%d|activityId=%d|floor=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.floor) }));
/*     */       
/*     */ 
/* 130 */       return false;
/*     */     }
/*     */     
/* 133 */     for (Iterator i$ = this.lockMembers.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*     */       
/* 135 */       int memberLv = RoleInterface.getLevel(member);
/* 136 */       if (memberLv < floorCfg.joinLevel)
/*     */       {
/*     */ 
/*     */ 
/* 140 */         GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.processImp@ member's level not ok!|roleId=%d|activityId=%d|floor=%d|roleLv=%d|joinLevel=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.floor), Integer.valueOf(memberLv), Integer.valueOf(floorCfg.joinLevel) }));
/*     */         
/*     */ 
/*     */ 
/* 144 */         return false;
/*     */       }
/*     */     }
/* 147 */     int canChallengeMaxFloor = FloorManager.getCanChallengeMaxFloor(this.roleId, this.activityId);
/* 148 */     if ((canChallengeMaxFloor != -1) && (canChallengeMaxFloor < this.floor))
/*     */     {
/* 150 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.processImp@ can not challenge!|roleId=%d|activityId=%d|floor=%d|canChallengeMaxFloor=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.floor), Integer.valueOf(canChallengeMaxFloor) }));
/*     */       
/*     */ 
/*     */ 
/* 154 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 158 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCansetStatus(this.lockMembers, 1381, true))
/*     */     {
/* 160 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.processImp@ can not join activity!|roleId=%d|activityId=%d|floor=%d|canChallengeMaxFloor=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.floor), Integer.valueOf(canChallengeMaxFloor) }));
/*     */       
/*     */ 
/*     */ 
/* 164 */       return false;
/*     */     }
/*     */     
/* 167 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(this.roleidToUserid, this.lockMembers, this.activityId);
/* 168 */     if (!res.isCanJoin())
/*     */     {
/* 170 */       GameServer.logger().error(String.format("[floor]PCChallengeFloorReq.processImp@ can not join activity!|roleId=%d|activityId=%d|floor=%d|reason=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.floor), Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/* 174 */       return false;
/*     */     }
/*     */     
/* 177 */     doAction(floorCfg, xGlobalFloorInfo);
/*     */     
/* 179 */     return true;
/*     */   }
/*     */   
/*     */   void doAction(FloorCfg floorCfg, GlobalFloorInfo xGlobalFloorInfo)
/*     */   {
/* 184 */     for (Iterator i$ = this.lockMembers.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*     */       
/* 186 */       FloorManager.tlogJoinFloorActivity((String)this.roleidToUserid.get(Long.valueOf(member)), member, this.activityId, this.floor, FloorManager.getFinishFloors(FloorManager.getRoleFloorInfo(this.activityId, member)));
/*     */     }
/*     */     
/* 189 */     int fightId = FloorManager.fristBlooded(xGlobalFloorInfo, this.floor) ? floorCfg.normalFightId : floorCfg.hardFightId;
/* 190 */     mzm.gsp.fight.main.FightInterface.startPVEFight(this.roleId, fightId, new FloorFightContext(this.activityId, this.floor, DateTimeUtils.getCurrTimeInMillis()), 27, FightReason.FLOOR_FIGHT);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean checkAFGetLock(TeamInfo teamInfo, List<Long> lockMembers)
/*     */   {
/* 197 */     if (this.isSingle)
/*     */     {
/* 199 */       if (this.teamId == 0L)
/*     */       {
/*     */ 
/* 202 */         return !TeamInterface.isRoleInTeam(this.roleId, true);
/*     */       }
/* 204 */       if ((teamInfo == null) || (!teamInfo.isRoleInTeam(this.roleId)) || (teamInfo.isNormalState(this.roleId)))
/*     */       {
/*     */ 
/* 207 */         return false;
/*     */       }
/* 209 */       return true;
/*     */     }
/* 211 */     if ((teamInfo == null) || (!teamInfo.isLeader(this.roleId)))
/*     */     {
/* 213 */       return false;
/*     */     }
/* 215 */     List<Long> normalMembers = teamInfo.getTeamNormalList();
/* 216 */     if ((normalMembers.size() != lockMembers.size()) || (!normalMembers.containsAll(lockMembers)))
/*     */     {
/* 218 */       return false;
/*     */     }
/* 220 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\PCChallengeFloorReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */