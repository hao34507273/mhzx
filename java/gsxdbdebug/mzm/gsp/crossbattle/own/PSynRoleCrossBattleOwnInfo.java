/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.corps.main.CorpsInfo;
/*     */ import mzm.gsp.crossbattle.SCrossBattleOwnLoginProcessDone;
/*     */ import mzm.gsp.crossbattle.SSynCrossBattleRoundRobinIdipRestartInfo;
/*     */ import mzm.gsp.crossbattle.SSynRoleCrossBattleOwnInfo;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.AttendCorpsInfo;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xbean.CrossBattleOwnActivityInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleCrossBattleOwnInfo;
/*     */ import xbean.RoundRobinRoundInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_cross_battle_own_infos;
/*     */ import xtable.Team;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PSynRoleCrossBattleOwnInfo extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final boolean isLoginProtect;
/*     */   
/*     */   public PSynRoleCrossBattleOwnInfo(long roleid, int activityCfgid, boolean isLoginProtect)
/*     */   {
/*  40 */     this.roleid = roleid;
/*  41 */     this.activityCfgid = activityCfgid;
/*  42 */     this.isLoginProtect = isLoginProtect;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*     */ 
/*  51 */       return false;
/*     */     }
/*  53 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  54 */     if (cfg == null)
/*     */     {
/*     */ 
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     if (!mzm.gsp.activity.main.ActivityInterface.isActivityOpen(this.activityCfgid))
/*     */     {
/*     */ 
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     TeamInfo selectTeamInfo = TeamInterface.getTeamInfoByRoleId(this.roleid);
/*  69 */     if (selectTeamInfo != null)
/*     */     {
/*     */ 
/*  72 */       long teamid = selectTeamInfo.getTeamId();
/*  73 */       List<Long> lockRoleids = selectTeamInfo.getTeamMemberList();
/*  74 */       List<String> lockRoleUserids = new ArrayList();
/*  75 */       for (Iterator i$ = lockRoleids.iterator(); i$.hasNext();) { long lockRoleid = ((Long)i$.next()).longValue();
/*     */         
/*  77 */         lockRoleUserids.add(RoleInterface.getUserId(lockRoleid));
/*     */       }
/*     */       
/*  80 */       lock(User.getTable(), lockRoleUserids);
/*     */       
/*  82 */       lock(Basic.getTable(), lockRoleids);
/*     */       
/*  84 */       lock(Team.getTable(), Arrays.asList(new Long[] { Long.valueOf(teamid) }));
/*     */     }
/*     */     else
/*     */     {
/*  88 */       String userid = RoleInterface.getUserId(this.roleid);
/*     */       
/*  90 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/*  92 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     }
/*     */     
/*  95 */     CorpsInfo corpsInfo = mzm.gsp.corps.main.CorpsInterface.getCorpsInfoByRoleId(this.roleid, true, true);
/*     */     
/*  97 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  98 */     CrossBattleOwn xCrossBattleOwn = xtable.Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*     */     
/*     */ 
/* 101 */     SSynRoleCrossBattleOwnInfo protocol = new SSynRoleCrossBattleOwnInfo();
/* 102 */     protocol.activity_cfg_id = this.activityCfgid;
/* 103 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*     */     {
/* 105 */       protocol.stage = -1;
/*     */     }
/*     */     else
/*     */     {
/* 109 */       protocol.stage = xCrossBattleOwn.getStage();
/* 110 */       protocol.vote_stage_direct_promotion_corps_list.addAll(xCrossBattleOwn.getVote_stage_direct_promotion_corps_list());
/* 111 */       protocol.round_robin_point_rank_list.addAll(xCrossBattleOwn.getRound_robin_point_rank_list());
/* 112 */       protocol.round_robin_round_index = xCrossBattleOwn.getRound_robin_round_index();
/* 113 */       if (xCrossBattleOwn.getRound_robin_round_index() > 0)
/*     */       {
/* 115 */         protocol.round_robin_round_stage = ((RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(xCrossBattleOwn.getRound_robin_round_index() - 1)).getStage();
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 120 */         protocol.round_robin_round_stage = -1;
/*     */       }
/* 122 */       protocol.round_robin_stage_promotion_corps_list.addAll(xCrossBattleOwn.getRound_robin_stage_promotion_corps_list());
/*     */       
/* 124 */       if ((corpsInfo != null) && (xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(corpsInfo.getCorpsId()))))
/*     */       {
/* 126 */         protocol.register_info = 1;
/*     */       }
/*     */       else
/*     */       {
/* 130 */         protocol.register_info = 0;
/*     */       }
/*     */       
/* 133 */       long now = DateTimeUtils.getCurrTimeInMillis();
/* 134 */       RoleCrossBattleOwnInfo xRoleCrossBattleOwnInfo = Role_cross_battle_own_infos.get(Long.valueOf(this.roleid));
/* 135 */       if (xRoleCrossBattleOwnInfo == null)
/*     */       {
/* 137 */         xRoleCrossBattleOwnInfo = Pod.newRoleCrossBattleOwnInfo();
/* 138 */         Role_cross_battle_own_infos.insert(Long.valueOf(this.roleid), xRoleCrossBattleOwnInfo);
/*     */       }
/* 140 */       CrossBattleOwnActivityInfo xCrossBattleOwnActivityInfo = (CrossBattleOwnActivityInfo)xRoleCrossBattleOwnInfo.getCross_battle_own_activity_infos().get(Integer.valueOf(this.activityCfgid));
/*     */       
/* 142 */       if (xCrossBattleOwnActivityInfo == null)
/*     */       {
/* 144 */         xCrossBattleOwnActivityInfo = Pod.newCrossBattleOwnActivityInfo();
/* 145 */         xCrossBattleOwnActivityInfo.setVote_times(0);
/* 146 */         xCrossBattleOwnActivityInfo.setVote_timestamp(now);
/* 147 */         xRoleCrossBattleOwnInfo.getCross_battle_own_activity_infos().put(Integer.valueOf(this.activityCfgid), xCrossBattleOwnActivityInfo);
/*     */       }
/*     */       
/* 150 */       if (DateTimeUtils.needDailyReset(xCrossBattleOwnActivityInfo.getVote_timestamp(), now, 0))
/*     */       {
/* 152 */         xCrossBattleOwnActivityInfo.setVote_times(0);
/* 153 */         xCrossBattleOwnActivityInfo.setVote_timestamp(now);
/*     */       }
/* 155 */       protocol.vote_times = xCrossBattleOwnActivityInfo.getVote_times();
/* 156 */       protocol.canvass_timestamp = ((int)(xCrossBattleOwnActivityInfo.getCanvass_timestamp() / 1000L));
/*     */     }
/* 158 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/*     */ 
/* 161 */     RoundRobinRestartInfo restartInfo = RoundRobinRestartManager.getInstance().getRestartInfo(this.activityCfgid);
/* 162 */     if (restartInfo != null)
/*     */     {
/* 164 */       SSynCrossBattleRoundRobinIdipRestartInfo protocolIdip = new SSynCrossBattleRoundRobinIdipRestartInfo();
/* 165 */       protocolIdip.activity_cfg_id = this.activityCfgid;
/* 166 */       protocolIdip.round_index = restartInfo.roundIndex;
/* 167 */       protocolIdip.timestamp = ((int)(restartInfo.timestamp / 1000L));
/* 168 */       OnlineManager.getInstance().send(this.roleid, protocolIdip);
/*     */     }
/*     */     
/* 171 */     boolean loginProcessDone = true;
/*     */     
/* 173 */     long activityWorldid = RoundRobinWorldManager.getInstance().getWorldid(this.activityCfgid);
/* 174 */     if ((activityWorldid <= 0L) || (activityWorldid != MapInterface.getRoleWorldInstanceId(this.roleid)))
/*     */     {
/*     */ 
/* 177 */       RoleStatusInterface.unsetStatus(this.roleid, 1305);
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/* 182 */     else if ((selectTeamInfo == null) || (corpsInfo == null))
/*     */     {
/*     */ 
/* 185 */       leaveRoundRobinMap(this.roleid, this.activityCfgid, cfg.round_robin_out_map_cfg_id, cfg.round_robin_out_map_transfer_x, cfg.round_robin_out_map_transfer_y);
/*     */       
/* 187 */       loginProcessDone = false;
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 192 */       int roundIndex = 0;
/* 193 */       if (restartInfo != null)
/*     */       {
/* 195 */         roundIndex = restartInfo.roundIndex;
/*     */       }
/*     */       else
/*     */       {
/* 199 */         roundIndex = xCrossBattleOwn.getRound_robin_round_index();
/*     */       }
/* 201 */       RoundRobinRoundInfo xRoundRobinRoundInfo = (RoundRobinRoundInfo)xCrossBattleOwn.getRound_robin_round_infos().get(roundIndex - 1);
/*     */       
/* 203 */       if (xRoundRobinRoundInfo.getStage() == 0)
/*     */       {
/*     */ 
/* 206 */         TeamInfo teamInfo = TeamInterface.getTeamInfo(selectTeamInfo.getTeamId(), true);
/* 207 */         if ((teamInfo == null) || (!teamInfo.isRoleInTeam(this.roleid)))
/*     */         {
/* 209 */           leaveRoundRobinMap(this.roleid, this.activityCfgid, cfg.round_robin_out_map_cfg_id, cfg.round_robin_out_map_transfer_x, cfg.round_robin_out_map_transfer_y);
/*     */           
/* 211 */           loginProcessDone = false;
/*     */ 
/*     */ 
/*     */         }
/* 215 */         else if (teamInfo.isNormalState(this.roleid))
/*     */         {
/*     */ 
/* 218 */           if ((corpsInfo != null) && (xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(corpsInfo.getCorpsId()))))
/*     */           {
/*     */ 
/* 221 */             AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsInfo.getCorpsId()));
/*     */             
/* 223 */             CrossBattleOwnManager.setRoundRobinTitle(this.roleid, corpsInfo.getCorpsId(), xAttendCorpsInfo.getName(), ((Long)xAttendCorpsInfo.getMembers().get(0)).longValue() == this.roleid ? 1 : 2, xAttendCorpsInfo.getBadge());
/*     */ 
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 232 */         else if (MapInterface.getRoleWorldInstanceId(teamInfo.getLeaderId()) != MapInterface.getRoleWorldInstanceId(this.roleid))
/*     */         {
/*     */ 
/* 235 */           leaveRoundRobinMap(this.roleid, this.activityCfgid, cfg.round_robin_out_map_cfg_id, cfg.round_robin_out_map_transfer_x, cfg.round_robin_out_map_transfer_y);
/*     */           
/* 237 */           loginProcessDone = false;
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 242 */           TeamInterface.returnTeam(this.roleid);
/* 243 */           if ((corpsInfo != null) && (xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(corpsInfo.getCorpsId()))))
/*     */           {
/*     */ 
/* 246 */             AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsInfo.getCorpsId()));
/*     */             
/* 248 */             CrossBattleOwnManager.setRoundRobinTitle(this.roleid, corpsInfo.getCorpsId(), xAttendCorpsInfo.getName(), ((Long)xAttendCorpsInfo.getMembers().get(0)).longValue() == this.roleid ? 1 : 2, xAttendCorpsInfo.getBadge());
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 260 */         TeamInfo teamInfo = TeamInterface.getTeamInfo(selectTeamInfo.getTeamId(), true);
/* 261 */         if ((teamInfo == null) || (!teamInfo.isRoleInTeam(this.roleid)))
/*     */         {
/* 263 */           leaveRoundRobinMap(this.roleid, this.activityCfgid, cfg.round_robin_out_map_cfg_id, cfg.round_robin_out_map_transfer_x, cfg.round_robin_out_map_transfer_y);
/*     */           
/* 265 */           loginProcessDone = false;
/*     */ 
/*     */ 
/*     */         }
/* 269 */         else if (teamInfo.isNormalState(this.roleid))
/*     */         {
/*     */ 
/* 272 */           if ((corpsInfo != null) && (xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(corpsInfo.getCorpsId()))))
/*     */           {
/*     */ 
/* 275 */             AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsInfo.getCorpsId()));
/*     */             
/* 277 */             CrossBattleOwnManager.setRoundRobinTitle(this.roleid, corpsInfo.getCorpsId(), xAttendCorpsInfo.getName(), ((Long)xAttendCorpsInfo.getMembers().get(0)).longValue() == this.roleid ? 1 : 2, xAttendCorpsInfo.getBadge());
/*     */ 
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 286 */         else if (MapInterface.getRoleWorldInstanceId(teamInfo.getLeaderId()) != MapInterface.getRoleWorldInstanceId(this.roleid))
/*     */         {
/*     */ 
/* 289 */           leaveRoundRobinMap(this.roleid, this.activityCfgid, cfg.round_robin_out_map_cfg_id, cfg.round_robin_out_map_transfer_x, cfg.round_robin_out_map_transfer_y);
/*     */           
/* 291 */           loginProcessDone = false;
/*     */         }
/* 293 */         else if ((MapInterface.getRoleWorldInstanceId(teamInfo.getLeaderId()) == MapInterface.getRoleWorldInstanceId(this.roleid)) && (!this.isLoginProtect))
/*     */         {
/*     */ 
/*     */ 
/* 297 */           TeamInterface.leaveTeam(this.roleid);
/* 298 */           leaveRoundRobinMap(this.roleid, this.activityCfgid, cfg.round_robin_out_map_cfg_id, cfg.round_robin_out_map_transfer_x, cfg.round_robin_out_map_transfer_y);
/*     */           
/* 300 */           loginProcessDone = false;
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 305 */           TeamInterface.returnTeam(this.roleid);
/* 306 */           if ((corpsInfo != null) && (xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(corpsInfo.getCorpsId()))))
/*     */           {
/*     */ 
/* 309 */             AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(corpsInfo.getCorpsId()));
/*     */             
/* 311 */             CrossBattleOwnManager.setRoundRobinTitle(this.roleid, corpsInfo.getCorpsId(), xAttendCorpsInfo.getName(), ((Long)xAttendCorpsInfo.getMembers().get(0)).longValue() == this.roleid ? 1 : 2, xAttendCorpsInfo.getBadge());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 322 */     if (loginProcessDone)
/*     */     {
/* 324 */       SCrossBattleOwnLoginProcessDone sCrossBattleOwnLoginProcessDone = new SCrossBattleOwnLoginProcessDone();
/* 325 */       sCrossBattleOwnLoginProcessDone.activity_cfg_id = this.activityCfgid;
/* 326 */       MapInterface.send(this.roleid, sCrossBattleOwnLoginProcessDone);
/*     */     }
/* 328 */     return true;
/*     */   }
/*     */   
/*     */   private void leaveRoundRobinMap(long roleid, int activityCfgid, int mapCfgid, int x, int y)
/*     */   {
/* 333 */     RoleStatusInterface.unsetStatus(this.roleid, 1305);
/* 334 */     CrossBattleOwnManager.unsetRoundRobinTitle(this.roleid);
/* 335 */     MapInterface.forceTransferToScene(this.roleid, MapInterface.getBigWorldid(), mapCfgid, x, y, new LeaveRoundRobinCallBack(roleid, activityCfgid));
/*     */   }
/*     */   
/*     */   private class LeaveRoundRobinCallBack
/*     */     implements mzm.gsp.map.main.MapCallback<Boolean>
/*     */   {
/*     */     private final long roleid;
/*     */     private final int activityCfgid;
/*     */     
/*     */     public LeaveRoundRobinCallBack(long roleid, int activityCfgid)
/*     */     {
/* 346 */       this.roleid = roleid;
/* 347 */       this.activityCfgid = activityCfgid;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isCallInProcedure()
/*     */     {
/* 353 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean onResult(Boolean result)
/*     */     {
/* 359 */       SCrossBattleOwnLoginProcessDone protocol = new SCrossBattleOwnLoginProcessDone();
/* 360 */       protocol.activity_cfg_id = this.activityCfgid;
/* 361 */       MapInterface.send(this.roleid, protocol);
/* 362 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PSynRoleCrossBattleOwnInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */