/*     */ package mzm.gsp.floor.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity3.confbean.FloorCfg;
/*     */ import mzm.gsp.activity3.confbean.SFloorActivityCfg;
/*     */ import mzm.gsp.activity3.confbean.SFloorRuleCfg;
/*     */ import mzm.gsp.activity3.confbean.STFloorRuleCfg;
/*     */ import mzm.gsp.floor.SFastKillBro;
/*     */ import mzm.gsp.floor.SFloorNormalResult;
/*     */ import mzm.gsp.floor.SGetFirstBloodBro;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import xbean.GlobalFloorActivityInfo;
/*     */ import xbean.GlobalFloorInfo;
/*     */ import xbean.GlobalSingleFloorInfo;
/*     */ import xbean.RoleFloorActivityInfo;
/*     */ import xbean.RoleFloorInfo;
/*     */ import xtable.Globalfloor;
/*     */ import xtable.Role2flooractivity;
/*     */ 
/*     */ public class FloorManager
/*     */ {
/*     */   static final String ENCODING = "UTF-8";
/*     */   
/*     */   static Set<Integer> getAllConfirmType()
/*     */   {
/*  36 */     Set<Integer> confirmTypes = new HashSet();
/*  37 */     for (SFloorRuleCfg cfg : SFloorRuleCfg.getAll().values())
/*     */     {
/*  39 */       confirmTypes.add(Integer.valueOf(cfg.confirmType));
/*     */     }
/*  41 */     return confirmTypes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static RoleFloorInfo getRoleFloorInfo(int activityId, long roleId)
/*     */   {
/*  53 */     RoleFloorActivityInfo xRoleActivityInfo = Role2flooractivity.get(Long.valueOf(roleId));
/*  54 */     if (xRoleActivityInfo == null)
/*     */     {
/*  56 */       return null;
/*     */     }
/*  58 */     return (RoleFloorInfo)xRoleActivityInfo.getActivityinfo().get(Integer.valueOf(activityId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getFinishFloors(RoleFloorInfo xRoleFloorInfo)
/*     */   {
/*  69 */     Set<Integer> finishedFloors = new HashSet();
/*  70 */     if (xRoleFloorInfo == null)
/*     */     {
/*  72 */       return finishedFloors;
/*     */     }
/*  74 */     finishedFloors.addAll(xRoleFloorInfo.getFloor2info().keySet());
/*  75 */     return finishedFloors;
/*     */   }
/*     */   
/*     */   static GlobalSingleFloorInfo getGlobalSingleFloorInfo(int activityId, int floor, boolean remainGlobalLock)
/*     */   {
/*  80 */     GlobalFloorInfo xGlobalFloorInfo = getGlobalFloorInfo(activityId, remainGlobalLock);
/*  81 */     if (xGlobalFloorInfo == null)
/*     */     {
/*  83 */       return null;
/*     */     }
/*  85 */     return (GlobalSingleFloorInfo)xGlobalFloorInfo.getFloor2info().get(Integer.valueOf(floor));
/*     */   }
/*     */   
/*     */   static GlobalFloorInfo getGlobalFloorInfo(int activityId, boolean remainGlobalLock) {
/*     */     GlobalFloorActivityInfo xGlobalFloorActivityInfo;
/*     */     GlobalFloorActivityInfo xGlobalFloorActivityInfo;
/*  91 */     if (remainGlobalLock)
/*     */     {
/*  93 */       xGlobalFloorActivityInfo = Globalfloor.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*     */     }
/*     */     else
/*     */     {
/*  97 */       xGlobalFloorActivityInfo = Globalfloor.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*     */     }
/*     */     
/* 100 */     if (xGlobalFloorActivityInfo == null)
/*     */     {
/* 102 */       return null;
/*     */     }
/* 104 */     return (GlobalFloorInfo)xGlobalFloorActivityInfo.getActivityinfo().get(Integer.valueOf(activityId));
/*     */   }
/*     */   
/*     */   static GlobalSingleFloorInfo selectGlobalSingleFloorInfo(int activityId, int floor)
/*     */   {
/* 109 */     return getGlobalSingleFloorInfo(activityId, floor, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static FloorCfg getFloorCfg(int activityId, int floor)
/*     */   {
/* 121 */     STFloorRuleCfg cfg = STFloorRuleCfg.get(activityId);
/* 122 */     if (cfg == null)
/*     */     {
/* 124 */       return null;
/*     */     }
/* 126 */     return (FloorCfg)cfg.floorCfgs.get(Integer.valueOf(floor));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean fristBlooded(GlobalFloorInfo xGlobalFloorInfo, int floor)
/*     */   {
/* 138 */     GlobalSingleFloorInfo xGlobalSingleFloorInfo = (GlobalSingleFloorInfo)xGlobalFloorInfo.getFloor2info().get(Integer.valueOf(floor));
/* 139 */     if (xGlobalSingleFloorInfo == null)
/*     */     {
/* 141 */       return false;
/*     */     }
/* 143 */     return xGlobalSingleFloorInfo.getFirstblood().getKilltime() > 0;
/*     */   }
/*     */   
/*     */   static void firstBloodBro(int activityId, int floor, xbean.FloorFightRes xFristBlood)
/*     */   {
/* 148 */     SGetFirstBloodBro bro = new SGetFirstBloodBro();
/* 149 */     bro.activityid = activityId;
/* 150 */     bro.floor = floor;
/* 151 */     fillFloorFightRes(xFristBlood, bro.fightinfo);
/* 152 */     OnlineManager.getInstance().sendAll(bro);
/*     */   }
/*     */   
/*     */   static void fastKillBro(int activityId, int floor, xbean.FloorFightRes xFristBlood)
/*     */   {
/* 157 */     SFastKillBro bro = new SFastKillBro();
/* 158 */     bro.activityid = activityId;
/* 159 */     bro.floor = floor;
/* 160 */     fillFloorFightRes(xFristBlood, bro.fightinfo);
/* 161 */     OnlineManager.getInstance().sendAll(bro);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void fillFloorFightRes(xbean.FloorFightRes xFightRes, mzm.gsp.floor.FloorFightRes res)
/*     */   {
/* 172 */     res.killtime = xFightRes.getKilltime();
/* 173 */     res.usedtime = xFightRes.getUsedtime();
/* 174 */     for (String name : xFightRes.getNames())
/*     */     {
/* 176 */       Octets octets = new Octets();
/*     */       try
/*     */       {
/* 179 */         octets.setString(name, "UTF-8");
/*     */       }
/*     */       catch (UnsupportedEncodingException e) {}
/*     */       
/*     */ 
/*     */ 
/* 185 */       res.names.add(octets);
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean isThisFloorOpen(int activityId, int floor)
/*     */   {
/* 191 */     SFloorActivityCfg sFloorActivityCfg = SFloorActivityCfg.get(activityId);
/* 192 */     if (sFloorActivityCfg == null)
/*     */     {
/* 194 */       return false;
/*     */     }
/* 196 */     if (!OpenInterface.getOpenStatus(sFloorActivityCfg.activityOpenId))
/*     */     {
/* 198 */       return false;
/*     */     }
/* 200 */     FloorCfg floorCfg = getFloorCfg(activityId, floor);
/* 201 */     if (floorCfg == null)
/*     */     {
/* 203 */       return false;
/*     */     }
/* 205 */     if (!OpenInterface.getOpenStatus(floorCfg.floorOpenId))
/*     */     {
/* 207 */       return false;
/*     */     }
/* 209 */     return true;
/*     */   }
/*     */   
/*     */   static void removeRedio(GlobalSingleFloorInfo xGlobalSingleFloorInfo, boolean fristBloodRedio)
/*     */   {
/* 214 */     long redioId = getRemoveRedioId(xGlobalSingleFloorInfo, fristBloodRedio);
/* 215 */     if (redioId <= 0L)
/*     */     {
/* 217 */       return;
/*     */     }
/* 219 */     mzm.gsp.fight.main.FightInterface.removeFightRecord(redioId);
/*     */   }
/*     */   
/*     */   static long getRemoveRedioId(GlobalSingleFloorInfo xGlobalSingleFloorInfo, boolean fristBloodRedio)
/*     */   {
/* 224 */     if (xGlobalSingleFloorInfo == null)
/*     */     {
/* 226 */       return 0L;
/*     */     }
/* 228 */     long fastKillRedioId = xGlobalSingleFloorInfo.getFastkill().getRadioid();
/* 229 */     long fristBloodRedioId = xGlobalSingleFloorInfo.getFirstblood().getRadioid();
/*     */     
/* 231 */     long redioId = fristBloodRedio ? fristBloodRedioId : fastKillRedioId;
/* 232 */     if (redioId <= 0L)
/*     */     {
/* 234 */       return 0L;
/*     */     }
/* 236 */     if (fastKillRedioId == fristBloodRedioId)
/*     */     {
/* 238 */       mzm.gsp.GameServer.logger().info(String.format("[floor]FloorManage.removeRedio@ same redio, can not remove!|redioId=%d|fristBloodRedio=%s", new Object[] { Long.valueOf(redioId), Boolean.valueOf(fristBloodRedio) }));
/*     */       
/*     */ 
/* 241 */       return 0L;
/*     */     }
/* 243 */     return redioId;
/*     */   }
/*     */   
/*     */   static int getCanChallengeMaxFloor(long roleId, int activityId)
/*     */   {
/* 248 */     STFloorRuleCfg cfg = STFloorRuleCfg.get(activityId);
/* 249 */     RoleFloorActivityInfo xRoleActivityInfo = Role2flooractivity.get(Long.valueOf(roleId));
/* 250 */     if (xRoleActivityInfo == null)
/*     */     {
/* 252 */       return 1;
/*     */     }
/* 254 */     RoleFloorInfo xFloorInfo = (RoleFloorInfo)xRoleActivityInfo.getActivityinfo().get(Integer.valueOf(activityId));
/* 255 */     if (xFloorInfo == null)
/*     */     {
/* 257 */       return 1;
/*     */     }
/* 259 */     int canChallengeFloor = -1;
/* 260 */     for (int tmpFloor = 1; tmpFloor <= cfg.floorCfgs.size(); tmpFloor++)
/*     */     {
/* 262 */       if (!xFloorInfo.getFloor2info().containsKey(Integer.valueOf(tmpFloor)))
/*     */       {
/*     */ 
/*     */ 
/* 266 */         FloorCfg tmpFloorCfg = (FloorCfg)cfg.floorCfgs.get(Integer.valueOf(tmpFloor));
/* 267 */         if (OpenInterface.getOpenStatus(tmpFloorCfg.floorOpenId))
/*     */         {
/*     */ 
/*     */ 
/* 271 */           canChallengeFloor = tmpFloor;
/* 272 */           break;
/*     */         } } }
/* 274 */     return canChallengeFloor;
/*     */   }
/*     */   
/*     */   static void tlogJoinFloorActivity(String userId, long roleId, int activityId, int floor, Set<Integer> curFinishedFloors)
/*     */   {
/* 279 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 280 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 282 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Integer.valueOf(floor), curFinishedFloors.toString() };
/*     */     
/* 284 */     TLogManager.getInstance().addLog(roleId, "JoinFloorActivity", colums);
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogWinFloorActivity(String userId, long roleId, int activityId, int floor, Set<Integer> curFinishedFloors, int usedTime)
/*     */   {
/* 290 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 291 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 293 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Integer.valueOf(floor), curFinishedFloors.toString(), Integer.valueOf(usedTime) };
/*     */     
/*     */ 
/* 296 */     TLogManager.getInstance().addLog(roleId, "WinFloorActivity", colums);
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogSweepFloorActivity(String userId, long roleId, int activityId, Set<Integer> floors, Set<Integer> curFinishedFloors)
/*     */   {
/* 302 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 303 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 305 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), floors.toString(), curFinishedFloors.toString() };
/*     */     
/*     */ 
/* 308 */     TLogManager.getInstance().addLog(roleId, "SweepFloorActivity", colums);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isCheckRecordOpen()
/*     */   {
/* 318 */     return OpenInterface.getOpenStatus(410);
/*     */   }
/*     */   
/*     */   static void sendFloorNotice(long roleid, boolean afterSuc, int result, String... args)
/*     */   {
/* 323 */     SFloorNormalResult pro = new SFloorNormalResult();
/* 324 */     pro.result = result;
/* 325 */     for (String arg : args)
/*     */     {
/* 327 */       pro.args.add(arg);
/*     */     }
/* 329 */     if (afterSuc)
/*     */     {
/* 331 */       OnlineManager.getInstance().send(roleid, pro);
/*     */     }
/*     */     else
/*     */     {
/* 335 */       OnlineManager.getInstance().sendAtOnce(roleid, pro);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\FloorManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */