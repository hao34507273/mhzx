/*     */ package mzm.gsp.feisheng.fight;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.feisheng.SAttendFightActivityFail;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengFightActivityCfg;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengFightInfo;
/*     */ import mzm.gsp.feisheng.main.FeiShengManager;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FeiShengFightInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleFeiShengFightInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_fei_sheng_fight_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAttendFightActivity extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int sortid;
/*     */   
/*     */   public PCAttendFightActivity(long roleid, int activityCfgid, int sortid)
/*     */   {
/*  38 */     this.roleid = roleid;
/*  39 */     this.activityCfgid = activityCfgid;
/*  40 */     this.sortid = sortid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (!FightActivityManager.isFeiShengFightActivitySwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  49 */       onFail(-1, null);
/*  50 */       return false;
/*     */     }
/*  52 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 958, true))
/*     */     {
/*     */ 
/*  55 */       onFail(-2, null);
/*  56 */       return false;
/*     */     }
/*  58 */     SFeiShengFightActivityCfg cfg = SFeiShengFightActivityCfg.get(this.activityCfgid);
/*  59 */     if ((cfg == null) || (!cfg.fight_infos.containsKey(Integer.valueOf(this.sortid))))
/*     */     {
/*     */ 
/*  62 */       onFail(-3, null);
/*  63 */       return false;
/*     */     }
/*  65 */     if (mzm.gsp.server.main.ServerInterface.getCurrentServerLevel() < cfg.serverlevel)
/*     */     {
/*     */ 
/*  68 */       onFail(-5, null);
/*  69 */       return false;
/*     */     }
/*  71 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(cfg.npc_id, cfg.npc_service_id, this.roleid))
/*     */     {
/*     */ 
/*  74 */       onFail(-4, null);
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  79 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleid);
/*     */     
/*  81 */     if ((teamInfo == null) || (!teamInfo.isNormalState(this.roleid)))
/*     */     {
/*  83 */       String userid = RoleInterface.getUserId(this.roleid);
/*     */       
/*  85 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/*  87 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*  90 */       TeamInfo doublecheckteamInfo = TeamInterface.getTeamInfoByRoleId(this.roleid);
/*  91 */       if ((doublecheckteamInfo != null) && (doublecheckteamInfo.isNormalState(this.roleid)))
/*     */       {
/*     */ 
/*  94 */         onFail(4, null);
/*  95 */         return false;
/*     */       }
/*     */       
/*  98 */       ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */       
/* 100 */       if (!activityJoinResult.isCanJoin())
/*     */       {
/*     */ 
/* 103 */         Map<String, Object> extraInfo = new HashMap();
/* 104 */         extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/* 105 */         onFail(1, extraInfo);
/* 106 */         return false;
/*     */       }
/*     */       
/* 109 */       long now = DateTimeUtils.getCurrTimeInMillis();
/* 110 */       RoleFeiShengFightInfo xRoleFeiShengFightInfo = Role_fei_sheng_fight_infos.get(Long.valueOf(this.roleid));
/* 111 */       if (xRoleFeiShengFightInfo == null)
/*     */       {
/* 113 */         xRoleFeiShengFightInfo = Pod.newRoleFeiShengFightInfo();
/* 114 */         Role_fei_sheng_fight_infos.insert(Long.valueOf(this.roleid), xRoleFeiShengFightInfo);
/*     */       }
/* 116 */       FeiShengFightInfo xFeiShengFightInfo = (FeiShengFightInfo)xRoleFeiShengFightInfo.getFei_sheng_fight_infos().get(Integer.valueOf(this.activityCfgid));
/*     */       
/* 118 */       if (xFeiShengFightInfo == null)
/*     */       {
/* 120 */         xFeiShengFightInfo = Pod.newFeiShengFightInfo();
/* 121 */         xFeiShengFightInfo.setDaily_get_team_member_award_times(0);
/* 122 */         xFeiShengFightInfo.setDaily_get_team_member_award_times_timestamp(now);
/* 123 */         xRoleFeiShengFightInfo.getFei_sheng_fight_infos().put(Integer.valueOf(this.activityCfgid), xFeiShengFightInfo);
/*     */       }
/* 125 */       if (xFeiShengFightInfo.getComplete_sortids().contains(Integer.valueOf(this.sortid)))
/*     */       {
/*     */ 
/* 128 */         onFail(2, null);
/* 129 */         return false;
/*     */       }
/* 131 */       mzm.gsp.fight.main.FightInterface.startPVEFight(this.roleid, ((SFeiShengFightInfo)cfg.fight_infos.get(Integer.valueOf(this.sortid))).fight_cfg_id, new FeiShengFightContext(this.roleid, this.activityCfgid, this.sortid), FightReason.FEI_SHENG_FIGHT_ACTIVITY_PVE);
/*     */ 
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 138 */       long teamid = teamInfo.getTeamId();
/* 139 */       List<Long> lockRoleids = teamInfo.getTeamNormalList();
/* 140 */       List<String> lockRoleUserids = new java.util.ArrayList();
/* 141 */       for (Iterator i$ = lockRoleids.iterator(); i$.hasNext();) { long lockRoleid = ((Long)i$.next()).longValue();
/*     */         
/* 143 */         lockRoleUserids.add(RoleInterface.getUserId(lockRoleid));
/*     */       }
/* 145 */       String userid = RoleInterface.getUserId(this.roleid);
/*     */       
/* 147 */       lock(User.getTable(), lockRoleUserids);
/*     */       
/* 149 */       lock(Basic.getTable(), lockRoleids);
/*     */       
/* 151 */       TeamInfo doublecheckteamInfo = TeamInterface.getTeamInfo(teamid, true);
/* 152 */       List<Long> normalMembers = doublecheckteamInfo.getTeamNormalList();
/* 153 */       if ((normalMembers.size() != lockRoleids.size()) || (!normalMembers.containsAll(lockRoleids)))
/*     */       {
/*     */ 
/* 156 */         onFail(4, null);
/* 157 */         return false;
/*     */       }
/* 159 */       if (this.roleid != doublecheckteamInfo.getLeaderId())
/*     */       {
/*     */ 
/* 162 */         onFail(5, null);
/* 163 */         return false;
/*     */       }
/*     */       
/* 166 */       ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */       
/* 168 */       if (!activityJoinResult.isCanJoin())
/*     */       {
/*     */ 
/* 171 */         Map<String, Object> extraInfo = new HashMap();
/* 172 */         extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/* 173 */         onFail(1, extraInfo);
/* 174 */         return false;
/*     */       }
/*     */       
/* 177 */       long now = DateTimeUtils.getCurrTimeInMillis();
/* 178 */       RoleFeiShengFightInfo xRoleFeiShengFightInfo = Role_fei_sheng_fight_infos.get(Long.valueOf(this.roleid));
/* 179 */       if (xRoleFeiShengFightInfo == null)
/*     */       {
/* 181 */         xRoleFeiShengFightInfo = Pod.newRoleFeiShengFightInfo();
/* 182 */         Role_fei_sheng_fight_infos.insert(Long.valueOf(this.roleid), xRoleFeiShengFightInfo);
/*     */       }
/* 184 */       FeiShengFightInfo xFeiShengFightInfo = (FeiShengFightInfo)xRoleFeiShengFightInfo.getFei_sheng_fight_infos().get(Integer.valueOf(this.activityCfgid));
/*     */       
/* 186 */       if (xFeiShengFightInfo == null)
/*     */       {
/* 188 */         xFeiShengFightInfo = Pod.newFeiShengFightInfo();
/* 189 */         xFeiShengFightInfo.setDaily_get_team_member_award_times(0);
/* 190 */         xFeiShengFightInfo.setDaily_get_team_member_award_times_timestamp(now);
/* 191 */         xRoleFeiShengFightInfo.getFei_sheng_fight_infos().put(Integer.valueOf(this.activityCfgid), xFeiShengFightInfo);
/*     */       }
/* 193 */       if (xFeiShengFightInfo.getComplete_sortids().contains(Integer.valueOf(this.sortid)))
/*     */       {
/*     */ 
/* 196 */         onFail(2, null);
/* 197 */         return false;
/*     */       }
/* 199 */       mzm.gsp.fight.main.FightInterface.startPVEFight(this.roleid, ((SFeiShengFightInfo)cfg.fight_infos.get(Integer.valueOf(this.sortid))).fight_cfg_id, new FeiShengFightContext(this.roleid, this.activityCfgid, this.sortid), FightReason.FEI_SHENG_FIGHT_ACTIVITY_PVE);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 204 */     StringBuilder sb = new StringBuilder();
/* 205 */     sb.append(String.format("[feisheng]PCAttendFightActivity.processImp@attend fight activity success|roleid=%d|activity_cfg_id=%d|sortid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid) }));
/*     */     
/*     */ 
/* 208 */     FeiShengManager.logger.info(sb.toString());
/* 209 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 214 */     StringBuilder sb = new StringBuilder();
/* 215 */     sb.append(String.format("[feisheng]PCAttendFightActivity.processImp@attend fight activity fail|roleid=%d|activity_cfg_id=%d|sortid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sortid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 218 */     if (extraInfo != null)
/*     */     {
/* 220 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 222 */         sb.append("|").append((String)entry.getKey());
/* 223 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 226 */     FeiShengManager.logger.info(sb.toString());
/* 227 */     if (res > 0)
/*     */     {
/* 229 */       SAttendFightActivityFail protocol = new SAttendFightActivityFail();
/* 230 */       protocol.res = res;
/* 231 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\fight\PCAttendFightActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */