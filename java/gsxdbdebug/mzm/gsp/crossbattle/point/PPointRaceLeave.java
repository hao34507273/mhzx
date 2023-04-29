/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.SPointRaceLeaveFail;
/*     */ import mzm.gsp.crossbattle.SPointRaceLeaveSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointCfg;
/*     */ import mzm.gsp.crossserver.main.RoamType;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PointPVPInfo;
/*     */ import xbean.UserRoamedInfo;
/*     */ import xtable.Crossbattlepointpvp;
/*     */ import xtable.User2roamedinfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PPointRaceLeave
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PPointRaceLeave(long roleid)
/*     */   {
/* 121 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/* 128 */     Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, false);
/* 129 */     if (teamid == null)
/*     */     {
/* 131 */       onFailed(-2);
/* 132 */       return false;
/*     */     }
/* 134 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamid.longValue(), false);
/* 135 */     if (teamInfo == null)
/*     */     {
/* 137 */       onFailed(-2);
/* 138 */       return false;
/*     */     }
/* 140 */     if (teamInfo.getLeaderId() != this.roleid)
/*     */     {
/* 142 */       onFailed(-3);
/* 143 */       return false;
/*     */     }
/* 145 */     List<Long> teamMembers = teamInfo.getTeamMemberList();
/* 146 */     if (teamMembers.size() < CrossBattlePointManager.TEAM_SIZE)
/*     */     {
/* 148 */       onFailed(-4);
/* 149 */       return false;
/*     */     }
/*     */     
/* 152 */     String userid = RoleInterface.getUserId(this.roleid);
/* 153 */     UserRoamedInfo xUserRoamedInfo = User2roamedinfo.get(userid);
/* 154 */     if (xUserRoamedInfo == null)
/*     */     {
/* 156 */       Map<String, Object> extras = new HashMap();
/* 157 */       extras.put("tip_info", "xbean user roamed info is null");
/* 158 */       onFailed(8, extras);
/* 159 */       return false;
/*     */     }
/*     */     
/* 162 */     if (xUserRoamedInfo.getRoam_type() != RoamType.CROSS_BATTLE_POINT.ordinal())
/*     */     {
/* 164 */       Map<String, Object> extras = new HashMap();
/* 165 */       extras.put("tip_info", "roam type invalid");
/* 166 */       onFailed(8, extras);
/* 167 */       return false;
/*     */     }
/*     */     
/* 170 */     long worldid = xUserRoamedInfo.getInstanceid();
/* 171 */     PointPVPInfo xPointPVPInfo = Crossbattlepointpvp.get(Long.valueOf(worldid));
/* 172 */     if (xPointPVPInfo == null)
/*     */     {
/* 174 */       Map<String, Object> extras = new HashMap();
/* 175 */       extras.put("tip_info", "xbean point pvp info is null");
/* 176 */       onFailed(8, extras);
/* 177 */       return false;
/*     */     }
/*     */     
/* 180 */     PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(worldid);
/* 181 */     if (zoneManager == null)
/*     */     {
/* 183 */       GameServer.logger().error(String.format("[crossbattlepoint]PCPointRaceLeave.processImp@zone manager is null|roleid=%d|worldid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(worldid) }));
/*     */       
/*     */ 
/* 186 */       return false;
/*     */     }
/*     */     
/* 189 */     SCrossBattlePointCfg cfg = zoneManager.crossBattlePointCfg;
/*     */     
/* 191 */     if (!NpcInterface.checkNpcService(cfg.leaveMapNpcCfgid, cfg.leaveMapNpcServiceCfgid, this.roleid))
/*     */     {
/* 193 */       return false;
/*     */     }
/*     */     
/* 196 */     PointRaceCorpsManager corpsManager = zoneManager.getCorpsManager();
/* 197 */     Long corpsid = corpsManager.getCorpsid(this.roleid);
/* 198 */     if (corpsid == null)
/*     */     {
/* 200 */       Map<String, Object> extras = new HashMap();
/* 201 */       extras.put("tip_info", "corpsid not found");
/* 202 */       onFailed(8, extras);
/* 203 */       return false;
/*     */     }
/*     */     
/* 206 */     if (xPointPVPInfo.getFights().contains(corpsid))
/*     */     {
/* 208 */       onFailed(-1);
/* 209 */       return false;
/*     */     }
/*     */     
/* 212 */     int activityCfgid = zoneManager.activityCfgid;
/* 213 */     int timePointCfgid = zoneManager.timePointCfgid;
/*     */     
/* 215 */     List<Long> roleids = corpsManager.getRoleids(corpsid.longValue());
/* 216 */     if ((roleids == null) || (roleids.isEmpty()))
/*     */     {
/* 218 */       Map<String, Object> extras = new HashMap();
/* 219 */       extras.put("tip_info", "roleids not found");
/* 220 */       onFailed(8, extras);
/* 221 */       return false;
/*     */     }
/* 223 */     if ((!teamMembers.containsAll(roleids)) || (teamMembers.size() != roleids.size()))
/*     */     {
/* 225 */       onFailed(-5);
/* 226 */       return false;
/*     */     }
/*     */     
/* 229 */     PointRaceCorpsCurInfo curInfo = corpsManager.getCorpsCurInfo(corpsid.longValue());
/* 230 */     if (curInfo == null)
/*     */     {
/* 232 */       Map<String, Object> extras = new HashMap();
/* 233 */       extras.put("tip_info", "cur info not found");
/* 234 */       onFailed(8, extras);
/* 235 */       return false;
/*     */     }
/*     */     
/* 238 */     PointRaceCorpsInfo corpsInfo = new PointRaceCorpsInfo();
/* 239 */     corpsInfo.setCorpsid(corpsid.longValue());
/* 240 */     corpsInfo.setLose(curInfo.lose);
/* 241 */     corpsInfo.setWin(curInfo.win);
/* 242 */     corpsInfo.setPoint(curInfo.point);
/* 243 */     corpsInfo.setUpdateTime(curInfo.updateTime);
/*     */     
/* 245 */     int pvps = corpsManager.getPvpFight(corpsid.longValue());
/*     */     
/*     */ 
/* 248 */     new PPointRaceReturnOriginal(curInfo.zoneid, roleids, activityCfgid, timePointCfgid, corpsInfo, pvps).execute();
/*     */     
/*     */ 
/* 251 */     zoneManager.removeRoamedContext(corpsid.longValue());
/* 252 */     corpsManager.remove(corpsid.longValue());
/*     */     
/* 254 */     SPointRaceLeaveSuccess rsp = new SPointRaceLeaveSuccess();
/* 255 */     OnlineManager.getInstance().send(this.roleid, rsp);
/* 256 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 261 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 266 */     SPointRaceLeaveFail rsp = new SPointRaceLeaveFail();
/* 267 */     rsp.retcode = retcode;
/* 268 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 270 */     StringBuffer logBuilder = new StringBuffer();
/* 271 */     logBuilder.append("[crossbattlepoint]PPointRaceLeave.onFailed@leave failed");
/* 272 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 273 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 275 */     if (extraParams != null)
/*     */     {
/* 277 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 279 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 283 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PPointRaceLeave.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */