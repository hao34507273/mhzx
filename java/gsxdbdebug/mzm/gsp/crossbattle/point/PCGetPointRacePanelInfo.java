/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.corps.main.CorpsInfo;
/*     */ import mzm.gsp.crossbattle.SGetPointRacePanelInfoSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossbattle.confbean.TimePointInfo;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CrossbattlePointRaceInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetPointRacePanelInfo extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int index;
/*     */   
/*     */   public PCGetPointRacePanelInfo(long roleid, int activityCfgid, int index)
/*     */   {
/*  36 */     this.roleid = roleid;
/*  37 */     this.activityCfgid = activityCfgid;
/*  38 */     this.index = index;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (this.activityCfgid <= 0)
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(this.activityCfgid);
/*  50 */     if (cfg == null)
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if ((this.index <= 0) || (this.index > cfg.timePoints.size()))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if (!CrossBattlePointManager.canDoAction(this.roleid, 1444))
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     if (!CrossBattlePointManager.isFunOpen(this.roleid, cfg.activitySwitch, cfg.funSwitch))
/*     */     {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PGetPointRacePanelInfo(this.roleid, this.activityCfgid, this.index));
/*     */     
/*  72 */     return true;
/*     */   }
/*     */   
/*     */   private static class PGetPointRacePanelInfo
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int activityCfgid;
/*     */     private final int index;
/*     */     
/*     */     public PGetPointRacePanelInfo(long roleid, int activityCfgid, int index)
/*     */     {
/*  84 */       this.roleid = roleid;
/*  85 */       this.activityCfgid = activityCfgid;
/*  86 */       this.index = index;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  92 */       if (this.activityCfgid <= 0)
/*     */       {
/*  94 */         return false;
/*     */       }
/*     */       
/*  97 */       SCrossBattlePointCfg cfg = SCrossBattlePointCfg.get(this.activityCfgid);
/*  98 */       if (cfg == null)
/*     */       {
/* 100 */         onFailed(7);
/* 101 */         return false;
/*     */       }
/*     */       
/* 104 */       if (!CrossBattlePointManager.canDoAction(this.roleid, 1444))
/*     */       {
/* 106 */         return false;
/*     */       }
/*     */       
/* 109 */       if (!CrossBattlePointManager.isFunOpen(this.roleid, cfg.activitySwitch, cfg.funSwitch))
/*     */       {
/* 111 */         onFailed(1);
/* 112 */         return false;
/*     */       }
/*     */       
/* 115 */       int timePointCfgid = ((TimePointInfo)cfg.timePoints.get(this.index - 1)).timePoint;
/* 116 */       CrossbattlePointRaceInfo xCrossbattlePointRaceInfo = CrossBattlePointManager.getCrossbattlePointRaceInfo(this.activityCfgid, timePointCfgid, false);
/*     */       
/* 118 */       if (xCrossbattlePointRaceInfo == null)
/*     */       {
/* 120 */         onFailed(8);
/* 121 */         return false;
/*     */       }
/*     */       
/* 124 */       boolean fiveRoleTeam = false;
/* 125 */       boolean inOneCorps = false;
/* 126 */       boolean canJoinPointRace = false;
/* 127 */       boolean roleSameWithSignUp = false;
/*     */       
/*     */ 
/* 130 */       List<Long> teamNormals = new ArrayList();
/* 131 */       Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, false);
/* 132 */       if (teamid != null)
/*     */       {
/* 134 */         TeamInfo teamInfo = TeamInterface.getTeamInfo(teamid.longValue(), false);
/* 135 */         if (teamInfo != null)
/*     */         {
/* 137 */           teamNormals.addAll(teamInfo.getTeamNormalList());
/* 138 */           if (teamNormals.size() >= CrossBattlePointManager.TEAM_SIZE)
/*     */           {
/* 140 */             fiveRoleTeam = true;
/*     */           }
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 146 */         teamNormals.add(Long.valueOf(this.roleid));
/*     */       }
/*     */       
/* 149 */       Map<Long, String> role2Users = new HashMap();
/* 150 */       for (Iterator i$ = teamNormals.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 152 */         String userid = RoleInterface.getUserId(roleid);
/* 153 */         role2Users.put(Long.valueOf(roleid), userid);
/*     */       }
/*     */       
/* 156 */       lock(User.getTable(), role2Users.values());
/* 157 */       lock(Basic.getTable(), teamNormals);
/*     */       
/*     */ 
/* 160 */       ActivityJoinResult result = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(role2Users, teamNormals, this.activityCfgid);
/*     */       
/* 162 */       if (!result.isCanJoin())
/*     */       {
/* 164 */         onFailed(4);
/* 165 */         return false;
/*     */       }
/*     */       
/* 168 */       for (Iterator i$ = teamNormals.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 170 */         if (!CrossBattlePointManager.isFunOpen(roleid, cfg.activitySwitch, cfg.funSwitch))
/*     */         {
/* 172 */           OpenInterface.sendBanPlayMsg(this.roleid, roleid, RoleInterface.getName(roleid), cfg.funSwitch);
/* 173 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 177 */       CorpsInfo corpsInfo = mzm.gsp.corps.main.CorpsInterface.getCorpsInfoByRoleId(this.roleid, true, true);
/* 178 */       if ((corpsInfo != null) && (corpsInfo.getAllMemberIds().containsAll(teamNormals)))
/*     */       {
/* 180 */         inOneCorps = true;
/*     */       }
/*     */       
/*     */ 
/* 184 */       long corpsid = corpsInfo.getCorpsId();
/* 185 */       int zone = CrossBattlePointManager.getCorpsZone(this.activityCfgid, corpsid);
/* 186 */       if (zone > 0)
/*     */       {
/* 188 */         canJoinPointRace = true;
/*     */       }
/*     */       
/*     */ 
/* 192 */       long startTime = CrossBattlePointManager.getStartTime(cfg, xCrossbattlePointRaceInfo, zone);
/* 193 */       long lastTime = TimeUnit.MINUTES.toMillis(cfg.durationInMinute);
/* 194 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 195 */       if (startTime > now)
/*     */       {
/* 197 */         Map<String, Object> extras = new HashMap();
/* 198 */         extras.put("time_point_cfgid", Integer.valueOf(xCrossbattlePointRaceInfo.getTime_point_cfgid()));
/* 199 */         onFailed(8, extras);
/* 200 */         return false;
/*     */       }
/* 202 */       long delay = CrossBattlePointManager.getDelay(now, startTime, lastTime);
/* 203 */       if (delay <= 0L)
/*     */       {
/* 205 */         Map<String, Object> extras = new HashMap();
/* 206 */         extras.put("time_point_cfgid", Integer.valueOf(xCrossbattlePointRaceInfo.getTime_point_cfgid()));
/* 207 */         onFailed(8, extras);
/* 208 */         return false;
/*     */       }
/*     */       
/* 211 */       List<Long> registerRoles = mzm.gsp.crossbattle.own.CrossBattleOwnInterface.getCrossBattleRegisterRoleList(corpsid, this.activityCfgid, true);
/*     */       
/* 213 */       if ((registerRoles != null) && (registerRoles.containsAll(teamNormals)))
/*     */       {
/* 215 */         roleSameWithSignUp = true;
/*     */       }
/*     */       
/* 218 */       sendResponse(fiveRoleTeam, inOneCorps, canJoinPointRace, roleSameWithSignUp);
/* 219 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     private void sendResponse(boolean isFiveRoleTeam, boolean isInOneCorps, boolean isCanJoinPointRace, boolean isRoleSameWithSignUp)
/*     */     {
/* 225 */       SGetPointRacePanelInfoSuccess msg = new SGetPointRacePanelInfoSuccess();
/* 226 */       msg.is_five_role_team = ((byte)(isFiveRoleTeam ? 1 : 0));
/* 227 */       msg.is_in_one_corps = ((byte)(isInOneCorps ? 1 : 0));
/* 228 */       msg.is_can_join_point_race = ((byte)(isCanJoinPointRace ? 1 : 0));
/* 229 */       msg.is_role_same_with_sign_up = ((byte)(isRoleSameWithSignUp ? 1 : 0));
/* 230 */       OnlineManager.getInstance().sendAtOnce(this.roleid, msg);
/*     */     }
/*     */     
/*     */     private void onFailed(int retcode)
/*     */     {
/* 235 */       onFailed(retcode, null);
/*     */     }
/*     */     
/*     */     private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */     {
/* 240 */       StringBuffer logBuilder = new StringBuffer();
/* 241 */       logBuilder.append("[crossbattlepoint]PGetPointRacePanelInfo.onFailed@get point race panel info failed");
/* 242 */       logBuilder.append('|').append("roleid=").append(this.roleid);
/* 243 */       logBuilder.append('|').append("activity_cfgid=").append(this.activityCfgid);
/* 244 */       logBuilder.append('|').append("retcode=").append(retcode);
/*     */       
/* 246 */       if (extraParams != null)
/*     */       {
/* 248 */         for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */         {
/* 250 */           logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */         }
/*     */       }
/*     */       
/* 254 */       GameServer.logger().error(logBuilder.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PCGetPointRacePanelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */