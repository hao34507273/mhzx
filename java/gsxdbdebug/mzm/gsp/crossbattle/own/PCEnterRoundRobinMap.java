/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.corps.main.CorpsInfo;
/*     */ import mzm.gsp.corps.main.CorpsInterface;
/*     */ import mzm.gsp.crossbattle.SEnterRoundRobinMapFail;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AttendCorpsInfo;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCEnterRoundRobinMap extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCEnterRoundRobinMap(long roleid, int activityCfgid)
/*     */   {
/*  34 */     this.roleid = roleid;
/*  35 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!CrossBattleOwnManager.isCrossBattleRoundRobinStageSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  44 */       onFail(-1, null);
/*  45 */       return false;
/*     */     }
/*  47 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  48 */     if (cfg == null)
/*     */     {
/*     */ 
/*  51 */       onFail(-3, null);
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     TeamInfo selectTeamInfo = TeamInterface.getTeamInfoByRoleId(this.roleid);
/*  57 */     if (selectTeamInfo == null)
/*     */     {
/*     */ 
/*  60 */       onFail(-3, null);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     long teamid = selectTeamInfo.getTeamId();
/*  65 */     List<Long> lockRoleids = selectTeamInfo.getTeamMemberList();
/*  66 */     List<String> lockRoleUserids = new ArrayList();
/*  67 */     for (Iterator i$ = lockRoleids.iterator(); i$.hasNext();) { long lockRoleid = ((Long)i$.next()).longValue();
/*     */       
/*  69 */       lockRoleUserids.add(RoleInterface.getUserId(lockRoleid));
/*     */     }
/*     */     
/*  72 */     lock(User.getTable(), lockRoleUserids);
/*     */     
/*  74 */     lock(Basic.getTable(), lockRoleids);
/*     */     
/*  76 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamid, true);
/*  77 */     if (teamInfo == null)
/*     */     {
/*     */ 
/*  80 */       onFail(3, null);
/*  81 */       return false;
/*     */     }
/*  83 */     List<Long> teamMembers = teamInfo.getTeamMemberList();
/*  84 */     if ((teamMembers.size() != lockRoleids.size()) || (!teamMembers.containsAll(lockRoleids)))
/*     */     {
/*     */ 
/*  87 */       onFail(4, null);
/*  88 */       return false;
/*     */     }
/*  90 */     if (this.roleid != teamInfo.getLeaderId())
/*     */     {
/*     */ 
/*  93 */       onFail(5, null);
/*  94 */       return false;
/*     */     }
/*  96 */     if (teamMembers.size() < CrossBattleConsts.getInstance().ENTER_ROUND_ROBIN_MAP_TEAM_MEMBER_NUM)
/*     */     {
/*     */ 
/*  99 */       onFail(6, null);
/* 100 */       return false;
/*     */     }
/* 102 */     if (!teamInfo.isAllTeamMemberNormal())
/*     */     {
/*     */ 
/* 105 */       onFail(11, null);
/* 106 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 110 */     CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByRoleId(this.roleid, true, true);
/* 111 */     if (corpsInfo == null)
/*     */     {
/*     */ 
/* 114 */       onFail(7, null);
/* 115 */       return false;
/*     */     }
/* 117 */     if (!corpsInfo.getAllMemberIds().containsAll(teamMembers))
/*     */     {
/*     */ 
/* 120 */       onFail(8, null);
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     if (!CrossBattleOwnManager.isInRoundRobinStage(this.activityCfgid))
/*     */     {
/*     */ 
/* 127 */       onFail(2, null);
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/* 132 */     CrossBattleOwn xCrossBattleOwn = xtable.Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/* 133 */     if (!CrossBattleOwnManager.checkCorpsCanAttendCurrentRound(xCrossBattleOwn, corpsInfo.getCorpsId(), this.activityCfgid))
/*     */     {
/*     */ 
/* 136 */       onFail(9, null);
/* 137 */       return false;
/*     */     }
/*     */     
/* 140 */     AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsInfo.getCorpsId()));
/* 141 */     if (xAttendCorpsInfo == null)
/*     */     {
/*     */ 
/* 144 */       onFail(-5, null);
/* 145 */       return false;
/*     */     }
/* 147 */     if (!xAttendCorpsInfo.getMembers().containsAll(teamMembers))
/*     */     {
/*     */ 
/* 150 */       onFail(10, null);
/* 151 */       return false;
/*     */     }
/*     */     
/* 154 */     if (!mzm.gsp.status.main.RoleStatusInterface.setStatus(teamMembers, 1305, true))
/*     */     {
/*     */ 
/* 157 */       onFail(-2, null);
/* 158 */       return false;
/*     */     }
/*     */     
/* 161 */     long worldid = RoundRobinWorldManager.getInstance().getWorldid(this.activityCfgid);
/* 162 */     if (worldid < 0L)
/*     */     {
/*     */ 
/* 165 */       onFail(-6, null);
/* 166 */       return false;
/*     */     }
/*     */     
/* 169 */     for (Iterator i$ = lockRoleids.iterator(); i$.hasNext();) { long teamMemberid = ((Long)i$.next()).longValue();
/*     */       
/* 171 */       CrossBattleOwnManager.setRoundRobinTitle(teamMemberid, corpsInfo.getCorpsId(), xAttendCorpsInfo.getName(), ((Long)xAttendCorpsInfo.getMembers().get(0)).longValue() == teamMemberid ? 1 : 2, xAttendCorpsInfo.getBadge());
/*     */     }
/*     */     
/*     */ 
/* 175 */     MapInterface.forceTransferToScene(this.roleid, worldid, cfg.round_robin_map_cfg_id, cfg.round_robin_map_transfer_x, cfg.round_robin_map_transfer_y);
/*     */     
/*     */ 
/* 178 */     StringBuilder sb = new StringBuilder();
/* 179 */     sb.append(String.format("[crossbattle_own]PCEnterRoundRobinMap.processImp@enter round robin map success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*     */     
/*     */ 
/* 182 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 183 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 188 */     StringBuilder sb = new StringBuilder();
/* 189 */     sb.append(String.format("[crossbattle_own]PCEnterRoundRobinMap.processImp@enter round robin map fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 192 */     if (extraInfo != null)
/*     */     {
/* 194 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 196 */         sb.append("|").append((String)entry.getKey());
/* 197 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 200 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 201 */     if (res > 0)
/*     */     {
/* 203 */       SEnterRoundRobinMapFail protocol = new SEnterRoundRobinMapFail();
/* 204 */       protocol.res = res;
/* 205 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PCEnterRoundRobinMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */