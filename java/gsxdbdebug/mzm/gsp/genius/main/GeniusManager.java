/*     */ package mzm.gsp.genius.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.genius.SSwitchPlanSuccess;
/*     */ import mzm.gsp.genius.SSyncExtraPoint;
/*     */ import mzm.gsp.genius.confbean.GeniusSeriesBean;
/*     */ import mzm.gsp.genius.confbean.SGeniusCfg;
/*     */ import mzm.gsp.genius.confbean.SGeniusConst;
/*     */ import mzm.gsp.genius.confbean.SGeniusSeriesCfg;
/*     */ import mzm.gsp.genius.event.GeniusSkillChange;
/*     */ import mzm.gsp.genius.event.GeniusSkillChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GeniusInfo;
/*     */ import xbean.GeniusSeries;
/*     */ import xbean.GeniusSeriesInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2genius;
/*     */ 
/*     */ public class GeniusManager
/*     */ {
/*     */   static final int PLAY_ACTIVE_SWITCH = 1;
/*     */   static final int IDIP_DOUBLE_GENIUS_CLOSED = 2;
/*     */   
/*     */   static void init() {}
/*     */   
/*     */   private static void checkMenpaiSeriesCfg()
/*     */   {
/*  41 */     List<Integer> all = RoleInterface.getAllOccupationIds();
/*  42 */     for (Iterator i$ = all.iterator(); i$.hasNext();) { int ocpid = ((Integer)i$.next()).intValue();
/*     */       
/*  44 */       SGeniusSeriesCfg geniusSeriesCfg = SGeniusSeriesCfg.get(ocpid);
/*  45 */       if (geniusSeriesCfg == null)
/*     */       {
/*  47 */         throw new RuntimeException(String.format("occupation = %d not have genius series", new Object[] { Integer.valueOf(ocpid) }));
/*     */       }
/*     */       
/*  50 */       boolean open = false;
/*  51 */       for (GeniusSeriesBean geniusSeriesBean : geniusSeriesCfg.series.values())
/*     */       {
/*  53 */         if (geniusSeriesBean.defaultOpen == 1)
/*     */         {
/*  55 */           open = true;
/*  56 */           break;
/*     */         }
/*     */       }
/*  59 */       if (!open)
/*     */       {
/*  61 */         throw new RuntimeException(String.format("occupation = %d not have default genius series", new Object[] { Integer.valueOf(ocpid) }));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean canDoAction(long roleid, int action)
/*     */   {
/*  68 */     return canDoAction(roleid, action, true);
/*     */   }
/*     */   
/*     */   static boolean canDoAction(long roleid, int action, boolean send)
/*     */   {
/*  73 */     return mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleid, action, send);
/*     */   }
/*     */   
/*     */   static boolean isFunOpen(long roleid)
/*     */   {
/*  78 */     if (!OpenInterface.getOpenStatus(309))
/*     */     {
/*  80 */       GameServer.logger().error("[genius]GeniusManager.isFunOpen@fun not open");
/*  81 */       return false;
/*     */     }
/*  83 */     if (OpenInterface.isBanPlay(roleid, 309))
/*     */     {
/*  85 */       GameServer.logger().error(String.format("[genius]GeniusManager.isFunOpen@ban play|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*  86 */       OpenInterface.sendBanPlayMsg(roleid, 309);
/*  87 */       return false;
/*     */     }
/*  89 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isDoubleSeriesFunOpen(long roleid)
/*     */   {
/*  94 */     if (!OpenInterface.getOpenStatus(313))
/*     */     {
/*  96 */       GameServer.logger().error("[genius]GeniusManager.isDoubleSeriesFunOpen@fun not open");
/*  97 */       return false;
/*     */     }
/*  99 */     if (OpenInterface.isBanPlay(roleid, 313))
/*     */     {
/* 101 */       GameServer.logger().error(String.format("[genius]GeniusManager.isDoubleSeriesFunOpen@ban play|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/* 102 */       OpenInterface.sendBanPlayMsg(roleid, 313);
/* 103 */       return false;
/*     */     }
/* 105 */     return true;
/*     */   }
/*     */   
/*     */   static GeniusInfo getAndInitGeniusInfo(long roleid)
/*     */   {
/* 110 */     GeniusInfo xGeniusInfo = Role2genius.get(Long.valueOf(roleid));
/* 111 */     if (xGeniusInfo == null)
/*     */     {
/* 113 */       xGeniusInfo = Pod.newGeniusInfo();
/* 114 */       Role2genius.insert(Long.valueOf(roleid), xGeniusInfo);
/*     */     }
/* 116 */     return xGeniusInfo;
/*     */   }
/*     */   
/*     */   static GeniusSeries getAndInitGeniusSeries(long roleid, int ocpid)
/*     */   {
/* 121 */     GeniusInfo xGeniusInfo = getAndInitGeniusInfo(roleid);
/* 122 */     GeniusSeries xGeniusSeries = (GeniusSeries)xGeniusInfo.getGenius_series().get(Integer.valueOf(ocpid));
/* 123 */     if (xGeniusSeries == null)
/*     */     {
/* 125 */       xGeniusSeries = Pod.newGeniusSeries();
/* 126 */       xGeniusInfo.getGenius_series().put(Integer.valueOf(ocpid), xGeniusSeries);
/* 127 */       xGeniusSeries.setCur_series(getDefaultGeniusSeriesCfgid(ocpid));
/*     */     }
/* 129 */     return xGeniusSeries;
/*     */   }
/*     */   
/*     */   static GeniusSeries getGeniusSeries(long roleid, int ocpid)
/*     */   {
/* 134 */     return getGeniusSeries(roleid, ocpid, true);
/*     */   }
/*     */   
/*     */   static GeniusSeries getGeniusSeries(long roleid, int ocpid, boolean retainLock)
/*     */   {
/* 139 */     GeniusInfo xGeniusInfo = null;
/* 140 */     if (retainLock)
/*     */     {
/* 142 */       xGeniusInfo = Role2genius.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/* 146 */       xGeniusInfo = Role2genius.select(Long.valueOf(roleid));
/*     */     }
/* 148 */     if (xGeniusInfo == null)
/*     */     {
/* 150 */       return null;
/*     */     }
/* 152 */     return (GeniusSeries)xGeniusInfo.getGenius_series().get(Integer.valueOf(ocpid));
/*     */   }
/*     */   
/*     */   static int getDefaultGeniusSeriesCfgid(int ocpid)
/*     */   {
/* 157 */     SGeniusSeriesCfg geniusSeriesCfg = SGeniusSeriesCfg.get(ocpid);
/* 158 */     if (geniusSeriesCfg == null)
/*     */     {
/* 160 */       GameServer.logger().error(String.format("[genius]GeniusManager.getDefaultGeniusSeriesCfgid@genius_series_cfg is null|ocpid=%d", new Object[] { Integer.valueOf(ocpid) }));
/*     */       
/* 162 */       return -1;
/*     */     }
/*     */     
/* 165 */     for (GeniusSeriesBean bean : geniusSeriesCfg.series.values())
/*     */     {
/* 167 */       if (bean.defaultOpen == 1)
/*     */       {
/* 169 */         return bean.id;
/*     */       }
/*     */     }
/*     */     
/* 173 */     GameServer.logger().error(String.format("[genius]GeniusManager.getDefaultGeniusSeriesCfgid@all genius_series_cfg default close|ocpid=%d", new Object[] { Integer.valueOf(ocpid) }));
/*     */     
/*     */ 
/* 176 */     return -1;
/*     */   }
/*     */   
/*     */   static int getCurGeniousPoint(long roleid)
/*     */   {
/* 181 */     int level = RoleInterface.getLevel(roleid);
/* 182 */     int openLevel = SGeniusConst.getInstance().OPEN_LEVEL;
/* 183 */     if (level < openLevel)
/*     */     {
/* 185 */       return 0;
/*     */     }
/*     */     
/*     */ 
/* 189 */     int maxLevel = SGeniusConst.getInstance().MAX_LEVEL;
/* 190 */     if (level > maxLevel)
/*     */     {
/* 192 */       level = maxLevel;
/*     */     }
/*     */     
/* 195 */     int num = (level - openLevel) / SGeniusConst.getInstance().ADD_POINT_INTERVAL_LEVEL;
/* 196 */     int result = SGeniusConst.getInstance().BASIC_POINT + num * SGeniusConst.getInstance().ADD_POINT_NUM;
/* 197 */     return result;
/*     */   }
/*     */   
/*     */   static int getMaxLayer(GeniusSeriesInfo xGeniusSeriesInfo)
/*     */   {
/* 202 */     Map<Integer, Integer> xGeniusSkills = xGeniusSeriesInfo.getGenius_skills();
/* 203 */     if (xGeniusSkills.isEmpty())
/*     */     {
/* 205 */       return 0;
/*     */     }
/*     */     
/* 208 */     List<Integer> list = new ArrayList(xGeniusSkills.keySet());
/* 209 */     Collections.sort(list);
/* 210 */     SGeniusCfg geniusCfg = SGeniusCfg.get(((Integer)list.get(list.size() - 1)).intValue());
/* 211 */     if (geniusCfg == null)
/*     */     {
/* 213 */       return -1;
/*     */     }
/* 215 */     return geniusCfg.layer;
/*     */   }
/*     */   
/*     */   static void addTLog(long roleid, String logName, Object... logColumns)
/*     */   {
/* 220 */     String vGameIp = mzm.gsp.GameServerInfoManager.getHostIP();
/* 221 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 222 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/* 224 */     StringBuilder logStr = new StringBuilder();
/* 225 */     logStr.append(vGameIp);
/* 226 */     logStr.append("|").append(userid);
/* 227 */     logStr.append("|").append(roleid);
/* 228 */     logStr.append("|").append(roleLevel);
/*     */     
/* 230 */     for (Object colum : logColumns)
/*     */     {
/* 232 */       logStr.append("|").append(colum);
/*     */     }
/*     */     
/* 235 */     TLogManager.getInstance().addLog(roleid, logName, logStr.toString());
/*     */   }
/*     */   
/*     */   static boolean checkDoubleGeniusSeriesClosed(long roleid, boolean sendMsg)
/*     */   {
/* 240 */     int level = RoleInterface.getLevel(roleid);
/* 241 */     if (level < SGeniusConst.getInstance().OPEN_LEVEL)
/*     */     {
/* 243 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 247 */     if (isDoubleSeriesFunOpen(roleid))
/*     */     {
/* 249 */       return false;
/*     */     }
/*     */     
/* 252 */     int ocpid = RoleInterface.getOccupationId(roleid);
/* 253 */     GeniusSeries xGeniusSeries = getGeniusSeries(roleid, ocpid);
/* 254 */     if (xGeniusSeries == null)
/*     */     {
/* 256 */       return false;
/*     */     }
/*     */     
/* 259 */     int defaultGeniusSeriesCfgid = getDefaultGeniusSeriesCfgid(ocpid);
/* 260 */     int oldGeniusSeriesCfgid = xGeniusSeries.getCur_series();
/* 261 */     if (oldGeniusSeriesCfgid == defaultGeniusSeriesCfgid)
/*     */     {
/* 263 */       return false;
/*     */     }
/*     */     
/* 266 */     xGeniusSeries.setCur_series(defaultGeniusSeriesCfgid);
/*     */     
/*     */ 
/* 269 */     triggerGeniusSkillChangeEvent(roleid, GeniusSkillChangeReason.SWITCH_GENIUS);
/*     */     
/*     */ 
/* 272 */     addTLog(roleid, "GeniusSwitchPlanForServer", new Object[] { Integer.valueOf(ocpid), Integer.valueOf(oldGeniusSeriesCfgid), Integer.valueOf(defaultGeniusSeriesCfgid), Integer.valueOf(0), Integer.valueOf(2) });
/*     */     
/*     */ 
/* 275 */     if (sendMsg)
/*     */     {
/* 277 */       SSwitchPlanSuccess rsp = new SSwitchPlanSuccess();
/* 278 */       rsp.genius_series_id = defaultGeniusSeriesCfgid;
/* 279 */       OnlineManager.getInstance().send(roleid, rsp);
/*     */     }
/*     */     
/* 282 */     return true;
/*     */   }
/*     */   
/*     */   static void triggerGeniusSkillChangeEvent(long roleid, GeniusSkillChangeReason reason)
/*     */   {
/* 287 */     GeniusSkillChangeArg arg = new GeniusSkillChangeArg(roleid, reason);
/* 288 */     GeniusSkillChange event = new GeniusSkillChange();
/* 289 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*     */   }
/*     */   
/*     */   static List<Integer> getPassiveSkills(long roleid, boolean retainLock)
/*     */   {
/* 294 */     int ocpid = RoleInterface.getOccupationId(roleid);
/* 295 */     GeniusSeries xGeniusSeries = getGeniusSeries(roleid, ocpid, retainLock);
/* 296 */     if (xGeniusSeries == null)
/*     */     {
/* 298 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 301 */     int curGeniusSeries = xGeniusSeries.getCur_series();
/* 302 */     SGeniusSeriesCfg geniusSeriesCfg = SGeniusSeriesCfg.get(ocpid);
/* 303 */     if (geniusSeriesCfg == null)
/*     */     {
/* 305 */       GameServer.logger().error(String.format("[genius]GeniusManager.getSkills@genius_series_cfg is null|ocpid=%d|roleid=%d", new Object[] { Integer.valueOf(ocpid), Long.valueOf(roleid) }));
/*     */       
/* 307 */       return Collections.emptyList();
/*     */     }
/* 309 */     GeniusSeriesBean geniusSeriesBean = (GeniusSeriesBean)geniusSeriesCfg.series.get(Integer.valueOf(curGeniusSeries));
/* 310 */     if (geniusSeriesBean == null)
/*     */     {
/* 312 */       GameServer.logger().error(String.format("[genius]GeniusManager.getSkills@genius_series_bean is null|ocpid=%d|roleid=%d|genius_series=%d", new Object[] { Integer.valueOf(ocpid), Long.valueOf(roleid), Integer.valueOf(curGeniusSeries) }));
/*     */       
/*     */ 
/*     */ 
/* 316 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 319 */     GeniusSeriesInfo xGeniusSeriesInfo = (GeniusSeriesInfo)xGeniusSeries.getSeries().get(Integer.valueOf(curGeniusSeries));
/* 320 */     if (xGeniusSeriesInfo == null)
/*     */     {
/* 322 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 325 */     Map<Integer, Integer> xGeniusSkills = xGeniusSeriesInfo.getGenius_skills();
/* 326 */     if (xGeniusSkills.isEmpty())
/*     */     {
/* 328 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 331 */     List<Integer> result = new ArrayList();
/* 332 */     for (Map.Entry<Integer, Integer> xEntry : xGeniusSkills.entrySet())
/*     */     {
/* 334 */       int geniusCfgid = ((Integer)xEntry.getKey()).intValue();
/* 335 */       SGeniusCfg geniusCfg = SGeniusCfg.get(geniusCfgid);
/* 336 */       if (geniusCfg == null)
/*     */       {
/* 338 */         GameServer.logger().error(String.format("[genius]GeniusManager.getSkills@genius_cfg is null|ocpid=%d|roleid=%d|genius_series=%d|genius_cfgid=%d", new Object[] { Integer.valueOf(ocpid), Long.valueOf(roleid), Integer.valueOf(curGeniusSeries), geniusCfg }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 345 */       else if (geniusCfg.sourceSkillCfgid <= 0)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 350 */         int addPoint = ((Integer)xEntry.getValue()).intValue();
/* 351 */         if (addPoint > 0)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 356 */           if (addPoint > geniusCfg.skills.size())
/*     */           {
/* 358 */             GameServer.logger().error(String.format("[genius]GeniusManager.getSkills@add point overflow|ocpid=%d|roleid=%d|genius_series=%d|genius_cfgid=%d", new Object[] { Integer.valueOf(ocpid), Long.valueOf(roleid), Integer.valueOf(curGeniusSeries), geniusCfg }));
/*     */ 
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 365 */             result.add(geniusCfg.skills.get(addPoint - 1)); } }
/*     */       }
/*     */     }
/* 368 */     return result;
/*     */   }
/*     */   
/*     */   static Map<Integer, Integer> getActiveSkills(long roleid, boolean retainLock)
/*     */   {
/* 373 */     int ocpid = RoleInterface.getOccupationId(roleid);
/* 374 */     GeniusSeries xGeniusSeries = getGeniusSeries(roleid, ocpid, retainLock);
/* 375 */     if (xGeniusSeries == null)
/*     */     {
/* 377 */       return Collections.emptyMap();
/*     */     }
/*     */     
/* 380 */     int curGeniusSeries = xGeniusSeries.getCur_series();
/* 381 */     SGeniusSeriesCfg geniusSeriesCfg = SGeniusSeriesCfg.get(ocpid);
/* 382 */     if (geniusSeriesCfg == null)
/*     */     {
/* 384 */       GameServer.logger().error(String.format("[genius]GeniusManager.getSkills@genius_series_cfg is null|ocpid=%d|roleid=%d", new Object[] { Integer.valueOf(ocpid), Long.valueOf(roleid) }));
/*     */       
/* 386 */       return Collections.emptyMap();
/*     */     }
/* 388 */     GeniusSeriesBean geniusSeriesBean = (GeniusSeriesBean)geniusSeriesCfg.series.get(Integer.valueOf(curGeniusSeries));
/* 389 */     if (geniusSeriesBean == null)
/*     */     {
/* 391 */       GameServer.logger().error(String.format("[genius]GeniusManager.getSkills@genius_series_bean is null|ocpid=%d|roleid=%d|genius_series=%d", new Object[] { Integer.valueOf(ocpid), Long.valueOf(roleid), Integer.valueOf(curGeniusSeries) }));
/*     */       
/*     */ 
/*     */ 
/* 395 */       return Collections.emptyMap();
/*     */     }
/*     */     
/* 398 */     GeniusSeriesInfo xGeniusSeriesInfo = (GeniusSeriesInfo)xGeniusSeries.getSeries().get(Integer.valueOf(curGeniusSeries));
/* 399 */     if (xGeniusSeriesInfo == null)
/*     */     {
/* 401 */       return Collections.emptyMap();
/*     */     }
/*     */     
/* 404 */     Map<Integer, Integer> xGeniusSkills = xGeniusSeriesInfo.getGenius_skills();
/* 405 */     if (xGeniusSkills.isEmpty())
/*     */     {
/* 407 */       return Collections.emptyMap();
/*     */     }
/*     */     
/* 410 */     Map<Integer, Integer> result = new HashMap();
/* 411 */     for (Map.Entry<Integer, Integer> xEntry : xGeniusSkills.entrySet())
/*     */     {
/* 413 */       int geniusCfgid = ((Integer)xEntry.getKey()).intValue();
/* 414 */       SGeniusCfg geniusCfg = SGeniusCfg.get(geniusCfgid);
/* 415 */       if (geniusCfg == null)
/*     */       {
/* 417 */         GameServer.logger().error(String.format("[genius]GeniusManager.getSkills@genius_cfg is null|ocpid=%d|roleid=%d|genius_series=%d|genius_cfgid=%d", new Object[] { Integer.valueOf(ocpid), Long.valueOf(roleid), Integer.valueOf(curGeniusSeries), geniusCfg }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 424 */       else if (geniusCfg.sourceSkillCfgid > 0)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 429 */         int addPoint = ((Integer)xEntry.getValue()).intValue();
/* 430 */         if (addPoint > 0)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 435 */           if (addPoint > geniusCfg.skills.size())
/*     */           {
/* 437 */             GameServer.logger().error(String.format("[genius]GeniusManager.getSkills@add point overflow|ocpid=%d|roleid=%d|genius_series=%d|genius_cfgid=%d", new Object[] { Integer.valueOf(ocpid), Long.valueOf(roleid), Integer.valueOf(curGeniusSeries), geniusCfg }));
/*     */ 
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 444 */             result.put(Integer.valueOf(geniusCfg.sourceSkillCfgid), geniusCfg.skills.get(addPoint - 1)); } }
/*     */       }
/*     */     }
/* 447 */     return result;
/*     */   }
/*     */   
/*     */   static int getGeniusAddPoint(long roleid, int geniusCfgid, boolean retainLock)
/*     */   {
/* 452 */     int ocpid = RoleInterface.getOccupationId(roleid);
/* 453 */     GeniusSeries xGeniusSeries = getGeniusSeries(roleid, ocpid, retainLock);
/* 454 */     if (xGeniusSeries == null)
/*     */     {
/* 456 */       return 0;
/*     */     }
/* 458 */     for (GeniusSeriesInfo xGeniusSeriesInfo : xGeniusSeries.getSeries().values())
/*     */     {
/* 460 */       Map<Integer, Integer> xGeniusSkills = xGeniusSeriesInfo.getGenius_skills();
/* 461 */       if (!xGeniusSkills.isEmpty())
/*     */       {
/*     */ 
/*     */ 
/* 465 */         for (Map.Entry<Integer, Integer> xEntry : xGeniusSkills.entrySet())
/*     */         {
/* 467 */           if (((Integer)xEntry.getKey()).intValue() == geniusCfgid)
/*     */           {
/* 469 */             return ((Integer)xEntry.getValue()).intValue(); }
/*     */         }
/*     */       }
/*     */     }
/* 473 */     return 0;
/*     */   }
/*     */   
/*     */   static void syncExtraPoint(long roleid, int extraPoint, boolean sendAtOnce)
/*     */   {
/* 478 */     SSyncExtraPoint msg = new SSyncExtraPoint();
/* 479 */     msg.extra_point = extraPoint;
/* 480 */     if (sendAtOnce)
/*     */     {
/* 482 */       OnlineManager.getInstance().sendAtOnce(roleid, msg);
/*     */     }
/*     */     else
/*     */     {
/* 486 */       OnlineManager.getInstance().send(roleid, msg);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\main\GeniusManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */