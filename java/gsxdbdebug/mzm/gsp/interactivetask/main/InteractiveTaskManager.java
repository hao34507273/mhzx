/*     */ package mzm.gsp.interactivetask.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.interactivetask.SErrorInfo;
/*     */ import mzm.gsp.interactivetask.SSynInteractiveTaskInfoRes;
/*     */ import mzm.gsp.interactivetask.TaskInfo;
/*     */ import mzm.gsp.interactivetask.confbean.SGivebirthConsts;
/*     */ import mzm.gsp.interactivetask.confbean.SInteractiveTaskCfg;
/*     */ import mzm.gsp.interactivetask.confbean.SInteractiveTaskTypeCfg;
/*     */ import mzm.gsp.interactivetask.event.GiveBirthFinishEvent;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.InteractivetaskInfo;
/*     */ import xbean.InteractivetaskMap;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2interactivetask;
/*     */ 
/*     */ class InteractiveTaskManager
/*     */ {
/*  44 */   static Logger logger = Logger.getLogger("interactivetask");
/*     */   
/*  46 */   private static final Map<Integer, Integer> typeid2Switch = new HashMap();
/*     */   
/*     */   static synchronized void registerSwitch(int typeid, int switchid)
/*     */   {
/*  50 */     typeid2Switch.put(Integer.valueOf(typeid), Integer.valueOf(switchid));
/*     */   }
/*     */   
/*     */   static synchronized Integer getSwitch(int typeid)
/*     */   {
/*  55 */     return (Integer)typeid2Switch.get(Integer.valueOf(typeid));
/*     */   }
/*     */   
/*     */   static void init()
/*     */   {
/*  60 */     logger = Logger.getLogger("interactivetask");
/*  61 */     registerSwitch(SGivebirthConsts.getInstance().TASK_TYPE_ID, 212);
/*     */   }
/*     */   
/*     */   static void transferToFubenWorld(List<Long> roleList, long worldid, int mapid)
/*     */   {
/*  66 */     MapInterface.transferAllRole(roleList, worldid, mapid);
/*     */   }
/*     */   
/*     */   static InteractivetaskInfo getXInteractivetask(long roleid, int typeid)
/*     */   {
/*  71 */     InteractivetaskMap xInteractivetaskMap = Role2interactivetask.get(Long.valueOf(roleid));
/*  72 */     if (xInteractivetaskMap == null)
/*     */     {
/*  74 */       return null;
/*     */     }
/*  76 */     return (InteractivetaskInfo)xInteractivetaskMap.getTypeid2task().get(Integer.valueOf(typeid));
/*     */   }
/*     */   
/*     */ 
/*     */   static void initXInteractivetaskInfo(long commanderRoleid, Collection<Long> roleids, long worldid, InteractivetaskInfo xInteractivetaskInfo, long sessionid)
/*     */   {
/*  82 */     xInteractivetaskInfo.setCurrent_graphid(0);
/*  83 */     xInteractivetaskInfo.getFinished_graphids().clear();
/*  84 */     xInteractivetaskInfo.setCommander_roleid(commanderRoleid);
/*  85 */     xInteractivetaskInfo.getRoleids().addAll(roleids);
/*  86 */     xInteractivetaskInfo.setWorldid(worldid);
/*  87 */     xInteractivetaskInfo.setSessionid(sessionid);
/*     */   }
/*     */   
/*     */   static long createWorld(int mapid)
/*     */   {
/*  92 */     long worldid = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(mapid) }));
/*  93 */     return worldid;
/*     */   }
/*     */   
/*     */ 
/*     */   static void addInteractiveTaskInfo(long roleid, int typeid, long commanderRoleid, Collection<Long> roleids, long worldid, long sessionid)
/*     */   {
/*  99 */     InteractivetaskInfo xInteractivetaskInfo = Pod.newInteractivetaskInfo();
/* 100 */     InteractivetaskMap xInteractivetaskMap = Role2interactivetask.get(Long.valueOf(roleid));
/* 101 */     if (xInteractivetaskMap == null)
/*     */     {
/* 103 */       xInteractivetaskMap = Pod.newInteractivetaskMap();
/* 104 */       Role2interactivetask.insert(Long.valueOf(roleid), xInteractivetaskMap);
/*     */     }
/* 106 */     xInteractivetaskMap.getTypeid2task().put(Integer.valueOf(typeid), xInteractivetaskInfo);
/* 107 */     initXInteractivetaskInfo(commanderRoleid, roleids, worldid, xInteractivetaskInfo, sessionid);
/*     */   }
/*     */   
/*     */   static void sendSErrorInfo(long roleid, int code, int typeid)
/*     */   {
/* 112 */     SErrorInfo res = new SErrorInfo(code, typeid);
/* 113 */     OnlineManager.getInstance().sendAtOnce(roleid, res);
/*     */   }
/*     */   
/*     */   static void sendSErrorInfo(Collection<Long> roleids, int code, int typeid)
/*     */   {
/* 118 */     SErrorInfo res = new SErrorInfo(code, typeid);
/* 119 */     OnlineManager.getInstance().sendMultiAtOnce(res, roleids);
/*     */   }
/*     */   
/*     */   static void leaveFuben(int typeid, List<Long> roleids)
/*     */   {
/* 124 */     boolean isSuccess = false;
/* 125 */     long commanderRoleid = 0L;
/* 126 */     long partnerRoleid = 0L;
/* 127 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 129 */       InteractivetaskMap xInteractivetaskMap = Role2interactivetask.get(Long.valueOf(r));
/* 130 */       if (xInteractivetaskMap == null)
/*     */       {
/* 132 */         return;
/*     */       }
/* 134 */       InteractivetaskInfo xInteractivetaskInfo = (InteractivetaskInfo)xInteractivetaskMap.getTypeid2task().remove(Integer.valueOf(typeid));
/* 135 */       if (r == xInteractivetaskInfo.getCommander_roleid())
/*     */       {
/* 137 */         commanderRoleid = r;
/* 138 */         Session.removeSession(xInteractivetaskInfo.getSessionid());
/* 139 */         MapInterface.destroyWorld(xInteractivetaskInfo.getWorldid());
/* 140 */         isSuccess = isFinishedAllTask(typeid, xInteractivetaskInfo);
/*     */       }
/* 142 */       if (r != xInteractivetaskInfo.getCommander_roleid())
/*     */       {
/* 144 */         partnerRoleid = r;
/* 145 */         TaskInterface.closeActivityGraphWithoutEvent(r, xInteractivetaskInfo.getCurrent_graphid());
/*     */       }
/*     */     }
/* 148 */     mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleids, 650);
/* 149 */     HomelandInterface.transferHome(((Long)roleids.get(0)).longValue(), roleids);
/*     */     
/* 151 */     if (!isSuccess)
/*     */     {
/* 153 */       triggerFinishEvent(roleids, false);
/*     */     }
/* 155 */     tlogInteractivetaskend(commanderRoleid, partnerRoleid, typeid, isSuccess ? 1 : 0);
/*     */   }
/*     */   
/*     */   static boolean isFinishedAllTask(int typeid, InteractivetaskInfo xInteractivetaskInfo)
/*     */   {
/* 160 */     if (xInteractivetaskInfo.getCurrent_graphid() != 0)
/*     */     {
/* 162 */       return false;
/*     */     }
/* 164 */     SInteractiveTaskCfg sInteractiveTaskCfg = SInteractiveTaskCfg.get(typeid);
/*     */     
/* 166 */     if (sInteractiveTaskCfg == null)
/*     */     {
/* 168 */       return false;
/*     */     }
/* 170 */     return xInteractivetaskInfo.getFinished_graphids().containsAll(sInteractiveTaskCfg.graphids);
/*     */   }
/*     */   
/*     */   static boolean isInteractiveTaskMap(int mapid)
/*     */   {
/* 175 */     for (SInteractiveTaskTypeCfg typeCfg : SInteractiveTaskTypeCfg.getAll().values())
/*     */     {
/* 177 */       if (typeCfg.mapid == mapid)
/*     */       {
/* 179 */         return true;
/*     */       }
/*     */     }
/* 182 */     return false;
/*     */   }
/*     */   
/*     */   static SInteractiveTaskTypeCfg getSInteractiveTaskTypeCfg(int mapid)
/*     */   {
/* 187 */     for (SInteractiveTaskTypeCfg typeCfg : SInteractiveTaskTypeCfg.getAll().values())
/*     */     {
/* 189 */       if (typeCfg.mapid == mapid)
/*     */       {
/* 191 */         return typeCfg;
/*     */       }
/*     */     }
/* 194 */     return null;
/*     */   }
/*     */   
/*     */   static boolean isInteractiveTaskSwitchOpenForRole(long roleid, int typeid)
/*     */   {
/* 199 */     Integer moduleid = getSwitch(typeid);
/* 200 */     if (moduleid == null)
/*     */     {
/* 202 */       return false;
/*     */     }
/* 204 */     if (!OpenInterface.getOpenStatus(moduleid.intValue()))
/*     */     {
/* 206 */       return false;
/*     */     }
/* 208 */     if (OpenInterface.isBanPlay(roleid, moduleid.intValue()))
/*     */     {
/* 210 */       OpenInterface.sendBanPlayMsg(roleid, moduleid.intValue());
/* 211 */       return false;
/*     */     }
/*     */     
/* 214 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static void synTaskInfo(long roleid, int typeid)
/*     */   {
/* 220 */     InteractivetaskInfo xInteractivetaskInfo = getXInteractivetask(roleid, typeid);
/*     */     
/* 222 */     SSynInteractiveTaskInfoRes res = new SSynInteractiveTaskInfoRes();
/* 223 */     fillTaskInfo(res.taskinfo, roleid, typeid, xInteractivetaskInfo);
/* 224 */     res.typeid = typeid;
/* 225 */     OnlineManager.getInstance().send(roleid, res);
/*     */   }
/*     */   
/*     */ 
/*     */   static void fillTaskInfo(TaskInfo taskInfo, long roleid, int typeid, InteractivetaskInfo xInteractivetaskInfo)
/*     */   {
/* 231 */     Session session = Session.getSession(xInteractivetaskInfo.getSessionid());
/* 232 */     if (session == null)
/*     */     {
/* 234 */       return;
/*     */     }
/* 236 */     taskInfo.currentgraph = xInteractivetaskInfo.getCurrent_graphid();
/* 237 */     taskInfo.finishedgraphs.addAll(xInteractivetaskInfo.getFinished_graphids());
/* 238 */     taskInfo.iscommander = (xInteractivetaskInfo.getCommander_roleid() == roleid ? 1 : 0);
/* 239 */     taskInfo.endtime = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis() + session.getLeftMillis());
/*     */   }
/*     */   
/*     */   static void triggerFinishEvent(Collection<Long> roleids, boolean isSuccess)
/*     */   {
/* 244 */     TriggerEventsManger.getInstance().triggerEvent(new GiveBirthFinishEvent(), new mzm.gsp.interactivetask.event.GiveBirthArg(roleids, isSuccess));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean cutMoney(String userid, long roleId, LogReason logReason, int subReason, int moneyType, int moneyNum, CostType costType)
/*     */   {
/* 251 */     TLogArg logArg = new TLogArg(logReason, subReason);
/* 252 */     switch (moneyType)
/*     */     {
/*     */ 
/*     */     case 3: 
/* 256 */       if (!RoleInterface.cutSilver(roleId, moneyNum, logArg))
/*     */       {
/* 258 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     case 2: 
/* 263 */       if (!RoleInterface.cutGold(roleId, moneyNum, logArg))
/*     */       {
/* 265 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     case 5: 
/* 270 */       if (!RoleInterface.cutGoldIngot(roleId, moneyNum, logArg))
/*     */       {
/* 272 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     case 1: 
/* 277 */       CostResult costResult = QingfuInterface.costYuanbao(userid, roleId, moneyNum, costType, logArg);
/* 278 */       if (costResult != CostResult.Success)
/*     */       {
/* 280 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     case 4: 
/* 285 */       if (!GangInterface.cutBangGong(roleId, moneyNum, logArg))
/*     */       {
/*     */ 
/* 288 */         return false;
/*     */       }
/*     */       break;
/*     */     default: 
/* 292 */       return false;
/*     */     }
/*     */     
/* 295 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static void tlogInteractivetaskend(long commanderRoleid, long partnerRoleid, int typeid, int result)
/*     */   {
/* 301 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 302 */     String userid = RoleInterface.getUserId(commanderRoleid);
/* 303 */     int rolelevel = RoleInterface.getLevel(commanderRoleid);
/* 304 */     Object[] columnns = { vGameIP, userid, Long.valueOf(commanderRoleid), Integer.valueOf(rolelevel), Long.valueOf(partnerRoleid), Integer.valueOf(typeid), Integer.valueOf(result) };
/* 305 */     TLogManager.getInstance().addLog(commanderRoleid, "Interactivetaskend", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\main\InteractiveTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */