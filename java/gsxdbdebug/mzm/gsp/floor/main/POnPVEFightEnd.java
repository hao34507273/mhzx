/*     */ package mzm.gsp.floor.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity3.confbean.FloorCfg;
/*     */ import mzm.gsp.activity3.confbean.STFloorHelpCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.fight.event.PVEFightEndArg;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.floor.SChallengeSuc;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FloorFightRes;
/*     */ import xbean.GlobalFloorActivityInfo;
/*     */ import xbean.GlobalFloorInfo;
/*     */ import xbean.GlobalSingleFloorInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleFloorActivityInfo;
/*     */ import xbean.RoleFloorInfo;
/*     */ import xbean.RoleSingleFloorInfo;
/*     */ import xtable.Role2flooractivity;
/*     */ 
/*     */ public class POnPVEFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  36 */     if (!(((PVEFightEndArg)this.arg).context instanceof FloorFightContext))
/*     */     {
/*  38 */       return false;
/*     */     }
/*  40 */     if (!((PVEFightEndArg)this.arg).isPlayerWin)
/*     */     {
/*     */ 
/*  43 */       FightInterface.removeFightRecord(((PVEFightEndArg)this.arg).recordid);
/*  44 */       return false;
/*     */     }
/*  46 */     FloorFightContext fightContext = (FloorFightContext)((PVEFightEndArg)this.arg).context;
/*     */     
/*  48 */     int activityId = fightContext.getActivityId();
/*  49 */     int floor = fightContext.getFloor();
/*     */     
/*  51 */     List<Long> lockMembers = ((PVEFightEndArg)this.arg).notEscapeRoles();
/*     */     
/*  53 */     if (lockMembers.size() == 0)
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (((PVEFightEndArg)this.arg).recordid <= 0L)
/*     */     {
/*     */ 
/*  61 */       GameServer.logger().error(String.format("[floor]POnPVEFightEnd.processImp@ not hava redioId!|floorData=%s|usedTime=%d|redioId=%d", new Object[] { fightContext.toString(), Long.valueOf(((PVEFightEndArg)this.arg).timeMills), Long.valueOf(((PVEFightEndArg)this.arg).recordid) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  66 */     FloorCfg floorCfg = FloorManager.getFloorCfg(activityId, floor);
/*  67 */     if (floorCfg == null)
/*     */     {
/*  69 */       GameServer.logger().error(String.format("[floor]POnPVEFightEnd.processImp@ cfg is null!|activityId=%d|floor=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(floor) }));
/*     */       
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     Map<Long, String> roleidToUserid = new java.util.HashMap();
/*  75 */     for (Iterator i$ = lockMembers.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */       
/*  77 */       roleidToUserid.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/*  80 */     xdb.Lockeys.lock(xtable.User.getTable(), roleidToUserid.values());
/*     */     
/*  82 */     xdb.Lockeys.lock(xtable.Role2task.getTable(), lockMembers);
/*     */     
/*     */ 
/*  85 */     Set<Long> helpRoleIds = new java.util.HashSet();
/*  86 */     for (Iterator i$ = lockMembers.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  88 */       handSingleRole(activityId, floor, floorCfg, (String)roleidToUserid.get(Long.valueOf(roleId)), roleId, helpRoleIds, fightContext.getStartTime());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  93 */     doHelpAward(activityId, lockMembers, floorCfg, roleidToUserid, helpRoleIds);
/*     */     
/*     */ 
/*  96 */     RefreshGlobalRes res = refreshGlobalData(activityId, floor, lockMembers, floorCfg, getGlobalSingleFloorInfoIfAbsent(activityId, floor), fightContext.getStartTime());
/*     */     
/*     */ 
/*     */ 
/* 100 */     doFirstBloodAward(activityId, lockMembers, floorCfg.fristBloodAwardId, roleidToUserid, res.isFirstBlood());
/*     */     
/*     */ 
/* 103 */     mzm.event.TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.floor.event.PassFloorEvent(), new mzm.gsp.floor.event.RolePassFloorEventArg(new java.util.HashSet(lockMembers), activityId, floor, helpRoleIds));
/*     */     
/*     */ 
/* 106 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void doHelpAward(int activityId, List<Long> lockMembers, FloorCfg floorCfg, Map<Long, String> roleidToUserid, Set<Long> helpRoleIds)
/*     */   {
/* 112 */     if ((helpRoleIds.size() == 0) || (helpRoleIds.size() == lockMembers.size()))
/*     */     {
/*     */ 
/* 115 */       return;
/*     */     }
/* 117 */     for (Iterator i$ = helpRoleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 119 */       awardHelp(floorCfg, (String)roleidToUserid.get(Long.valueOf(roleId)), roleId, activityId);
/*     */     }
/*     */   }
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
/*     */   private void doFirstBloodAward(int activityId, List<Long> lockMembers, int fristBloodAwardId, Map<Long, String> roleidToUserid, boolean isFirstBlood)
/*     */   {
/* 137 */     if (!isFirstBlood)
/*     */     {
/* 139 */       return;
/*     */     }
/* 141 */     if (fristBloodAwardId <= 0)
/*     */     {
/*     */ 
/* 144 */       return;
/*     */     }
/* 146 */     if (!OpenInterface.getOpenStatus(429))
/*     */     {
/*     */ 
/* 149 */       return;
/*     */     }
/* 151 */     for (Iterator i$ = lockMembers.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/* 154 */       AwardModel awardModel = AwardInterface.award(fristBloodAwardId, (String)roleidToUserid.get(Long.valueOf(roleId)), roleId, false, true, new AwardReason(LogReason.FIRST_BLOOD_FLOOR_AWARD, activityId));
/*     */       
/* 156 */       if (awardModel == null)
/*     */       {
/* 158 */         GameServer.logger().error(String.format("[floor]POnPVEFightEnd.doFirstBloodAward@ do first blood award err!|roleId=%d|activityId=%d|fristBloodAwardId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId), Integer.valueOf(fristBloodAwardId) }));
/*     */       }
/*     */     }
/*     */   }
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
/*     */   private void handSingleRole(int activityId, int floor, FloorCfg floorCfg, String userId, long roleId, Set<Long> helpRoleIds, long startTime)
/*     */   {
/* 178 */     RoleFloorInfo xRoleFloorInfo = getRoleFloorInfoIfAbsent(activityId, roleId);
/* 179 */     RoleSingleFloorInfo xRoleSingleFloorInfo = (RoleSingleFloorInfo)xRoleFloorInfo.getFloor2info().get(Integer.valueOf(floor));
/* 180 */     if (xRoleSingleFloorInfo == null)
/*     */     {
/* 182 */       xRoleFloorInfo.getFloor2info().put(Integer.valueOf(floor), xRoleSingleFloorInfo = Pod.newRoleSingleFloorInfo());
/*     */       
/* 184 */       AwardReason awardReason = new AwardReason(LogReason.WIN_FLOOR_AWARD, activityId);
/* 185 */       AwardModel awardModel = AwardInterface.award(floorCfg.awardId, userId, roleId, false, true, awardReason);
/* 186 */       if (awardModel == null)
/*     */       {
/* 188 */         return;
/*     */       }
/*     */       
/* 191 */       xRoleFloorInfo.getHistoryfloors().add(Integer.valueOf(floor));
/*     */     }
/*     */     else
/*     */     {
/* 195 */       helpRoleIds.add(Long.valueOf(roleId));
/*     */     }
/* 197 */     xRoleSingleFloorInfo.setUsedtime((int)(((PVEFightEndArg)this.arg).timeMills / 1000L));
/*     */     
/* 199 */     FloorManager.tlogWinFloorActivity(userId, roleId, activityId, floor, FloorManager.getFinishFloors(xRoleFloorInfo), (int)(((PVEFightEndArg)this.arg).timeMills / 1000L));
/*     */     
/*     */ 
/*     */ 
/* 203 */     if (startTime < mzm.gsp.activity.main.ActivityInterface.getActivityStartTime(activityId))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 208 */       return;
/*     */     }
/* 210 */     SChallengeSuc p = new SChallengeSuc();
/* 211 */     p.activityid = activityId;
/* 212 */     p.floor = floor;
/* 213 */     p.usedtime = ((int)(((PVEFightEndArg)this.arg).timeMills / 1000L));
/* 214 */     OnlineManager.getInstance().send(roleId, p);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void awardHelp(FloorCfg floorCfg, String userId, long roleId, int activityId)
/*     */   {
/* 227 */     if (!OpenInterface.getOpenStatus(430))
/*     */     {
/*     */ 
/* 230 */       return;
/*     */     }
/*     */     
/* 233 */     RoleFloorActivityInfo xRoleActivityInfo = Role2flooractivity.get(Long.valueOf(roleId));
/* 234 */     if (xRoleActivityInfo == null)
/*     */     {
/*     */ 
/* 237 */       return;
/*     */     }
/* 239 */     int helpLibId = floorCfg.helpLibId;
/* 240 */     STFloorHelpCfg stHelpCfg = STFloorHelpCfg.get(helpLibId);
/* 241 */     if (stHelpCfg == null)
/*     */     {
/*     */ 
/* 244 */       return;
/*     */     }
/* 246 */     int alreadyHelpCount = getAlreadyHelpCount(helpLibId, xRoleActivityInfo.getHelpdata());
/* 247 */     int helpCountMax = stHelpCfg.countMax;
/* 248 */     int finalHelpCount = alreadyHelpCount;
/* 249 */     if (helpCountMax > alreadyHelpCount)
/*     */     {
/*     */ 
/* 252 */       AwardReason awardReason = new AwardReason(LogReason.HELP_FLOOR_AWARD, activityId);
/* 253 */       AwardModel awardModel = AwardInterface.award(stHelpCfg.awardId, userId, roleId, false, true, awardReason);
/* 254 */       if (awardModel == null)
/*     */       {
/* 256 */         return;
/*     */       }
/* 258 */       finalHelpCount = alreadyHelpCount + 1;
/* 259 */       xRoleActivityInfo.getHelpdata().put(Integer.valueOf(helpLibId), Integer.valueOf(finalHelpCount));
/*     */     }
/* 261 */     int leftCount = helpCountMax - finalHelpCount;
/*     */     
/* 263 */     OnlineManager.getInstance().send(roleId, new mzm.gsp.floor.SFloorHelpTip(stHelpCfg.floorMin, stHelpCfg.floorMax, leftCount > 0 ? leftCount : 0));
/*     */   }
/*     */   
/*     */ 
/*     */   int getAlreadyHelpCount(int helpLibId, Map<Integer, Integer> helpdata)
/*     */   {
/* 269 */     if (helpdata == null)
/*     */     {
/* 271 */       return 0;
/*     */     }
/* 273 */     Integer alreadyCount = (Integer)helpdata.get(Integer.valueOf(helpLibId));
/* 274 */     return alreadyCount == null ? 0 : alreadyCount.intValue();
/*     */   }
/*     */   
/*     */   private RoleFloorInfo getRoleFloorInfoIfAbsent(int activityId, long roleId)
/*     */   {
/* 279 */     RoleFloorActivityInfo xRoleActivityInfo = Role2flooractivity.get(Long.valueOf(roleId));
/* 280 */     if (xRoleActivityInfo == null)
/*     */     {
/* 282 */       Role2flooractivity.insert(Long.valueOf(roleId), xRoleActivityInfo = Pod.newRoleFloorActivityInfo());
/*     */     }
/* 284 */     RoleFloorInfo xRoleFloorInfo = (RoleFloorInfo)xRoleActivityInfo.getActivityinfo().get(Integer.valueOf(activityId));
/* 285 */     if (xRoleFloorInfo == null)
/*     */     {
/* 287 */       xRoleActivityInfo.getActivityinfo().put(Integer.valueOf(activityId), xRoleFloorInfo = Pod.newRoleFloorInfo());
/*     */     }
/* 289 */     return xRoleFloorInfo;
/*     */   }
/*     */   
/*     */   private GlobalSingleFloorInfo getGlobalSingleFloorInfoIfAbsent(int activityId, int floor)
/*     */   {
/* 294 */     GlobalFloorActivityInfo xGlobalFloorActivityInfo = xtable.Globalfloor.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 295 */     if (xGlobalFloorActivityInfo == null)
/*     */     {
/* 297 */       xtable.Globalfloor.insert(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()), xGlobalFloorActivityInfo = Pod.newGlobalFloorActivityInfo());
/*     */     }
/*     */     
/* 300 */     GlobalFloorInfo xGlobalFloorInfo = (GlobalFloorInfo)xGlobalFloorActivityInfo.getActivityinfo().get(Integer.valueOf(activityId));
/* 301 */     if (xGlobalFloorInfo == null)
/*     */     {
/* 303 */       xGlobalFloorActivityInfo.getActivityinfo().put(Integer.valueOf(activityId), xGlobalFloorInfo = Pod.newGlobalFloorInfo());
/*     */     }
/* 305 */     GlobalSingleFloorInfo xGlobalSingleFloorInfo = (GlobalSingleFloorInfo)xGlobalFloorInfo.getFloor2info().get(Integer.valueOf(floor));
/* 306 */     if (xGlobalSingleFloorInfo == null)
/*     */     {
/* 308 */       xGlobalFloorInfo.getFloor2info().put(Integer.valueOf(floor), xGlobalSingleFloorInfo = Pod.newGlobalSingleFloorInfo());
/*     */     }
/* 310 */     return xGlobalSingleFloorInfo;
/*     */   }
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
/*     */   private RefreshGlobalRes refreshGlobalData(int activityId, int floor, List<Long> lockMembers, FloorCfg floorCfg, GlobalSingleFloorInfo xGlobalSingleFloorInfo, long startTime)
/*     */   {
/* 326 */     boolean needRmRedio = true;
/* 327 */     boolean firstBlood = false;
/* 328 */     boolean fastKill = false;
/*     */     
/* 330 */     FloorFightRes xFirstBlood = xGlobalSingleFloorInfo.getFirstblood();
/* 331 */     if ((xFirstBlood.getKilltime() <= 0) && (startTime > mzm.gsp.activity.main.ActivityInterface.getActivityStartTime(activityId)))
/*     */     {
/*     */ 
/*     */ 
/* 335 */       xFirstBlood.setKilltime((int)(DateTimeUtils.getCurrTimeInMillis() / 1000L));
/* 336 */       xFirstBlood.setUsedtime((int)(((PVEFightEndArg)this.arg).timeMills / 1000L));
/* 337 */       xFirstBlood.setRadioid(((PVEFightEndArg)this.arg).recordid);
/* 338 */       xFirstBlood.getNames().clear();
/* 339 */       for (Iterator i$ = lockMembers.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*     */         
/* 341 */         xFirstBlood.getNames().add(RoleInterface.getName(member));
/*     */       }
/*     */       
/* 344 */       FloorManager.firstBloodBro(activityId, floor, xFirstBlood);
/* 345 */       needRmRedio = false;
/* 346 */       firstBlood = true;
/*     */     }
/*     */     
/*     */ 
/* 350 */     FloorFightRes xFastKill = xGlobalSingleFloorInfo.getFastkill();
/* 351 */     if (needRefreshRecord(xFastKill, floorCfg.fastFinishTimeLimit))
/*     */     {
/* 353 */       FloorManager.removeRedio(xGlobalSingleFloorInfo, false);
/*     */       
/* 355 */       xFastKill.setKilltime((int)(DateTimeUtils.getCurrTimeInMillis() / 1000L));
/* 356 */       xFastKill.setUsedtime((int)(((PVEFightEndArg)this.arg).timeMills / 1000L));
/* 357 */       xFastKill.setRadioid(((PVEFightEndArg)this.arg).recordid);
/* 358 */       xFastKill.getNames().clear();
/* 359 */       for (Iterator i$ = lockMembers.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*     */         
/* 361 */         xFastKill.getNames().add(RoleInterface.getName(member));
/*     */       }
/*     */       
/* 364 */       FloorManager.fastKillBro(activityId, floor, xFastKill);
/* 365 */       needRmRedio = false;
/* 366 */       fastKill = true;
/*     */     }
/*     */     
/* 369 */     if (needRmRedio)
/*     */     {
/*     */ 
/* 372 */       FightInterface.removeFightRecord(((PVEFightEndArg)this.arg).recordid);
/*     */     }
/*     */     
/* 375 */     return new RefreshGlobalRes(firstBlood, fastKill);
/*     */   }
/*     */   
/*     */   boolean needRefreshRecord(FloorFightRes xFastKill, int fastFinishTimeLimit)
/*     */   {
/* 380 */     long fightTime = (int)(((PVEFightEndArg)this.arg).timeMills / 1000L);
/* 381 */     if (fightTime / 60L > fastFinishTimeLimit)
/*     */     {
/* 383 */       return false;
/*     */     }
/* 385 */     if (xFastKill.getUsedtime() <= 0)
/*     */     {
/* 387 */       return true;
/*     */     }
/* 389 */     if (fightTime < xFastKill.getUsedtime())
/*     */     {
/* 391 */       return true;
/*     */     }
/* 393 */     return false;
/*     */   }
/*     */   
/*     */   private class RefreshGlobalRes
/*     */   {
/*     */     private final boolean firstBlood;
/*     */     private final boolean fastKill;
/*     */     
/*     */     RefreshGlobalRes(boolean firstBlood, boolean fastKill)
/*     */     {
/* 403 */       this.firstBlood = firstBlood;
/* 404 */       this.fastKill = fastKill;
/*     */     }
/*     */     
/*     */     public boolean isFirstBlood()
/*     */     {
/* 409 */       return this.firstBlood;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isFastKill()
/*     */     {
/* 415 */       return this.fastKill;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */