/*     */ package mzm.gsp.indiana.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.indiana.confbean.SIndianaCfg;
/*     */ import mzm.gsp.indiana.confbean.SIndianaTurnInfo;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.TaskOneByOne;
/*     */ import xbean.IndianaAwardInfo;
/*     */ import xbean.IndianaAwardRoleInfo;
/*     */ import xbean.IndianaInfo;
/*     */ import xbean.IndianaTurnInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Indiana_infos;
/*     */ 
/*     */ public class IndianaManager
/*     */ {
/*  24 */   static volatile boolean postInitFlag = false;
/*     */   
/*  26 */   static int REFRESH_INTERVAL_IN_SECOND = 60;
/*  27 */   static int MAX_AWARD_NUMBER_NUM = 100;
/*  28 */   static int MAX_LOG_NUM = 1000;
/*  29 */   static int GRC_MIN_DELAY_IN_SECOND = 30;
/*  30 */   static int GRC_MAX_DELAY_IN_SECOND = 60;
/*     */   
/*     */   static void init()
/*     */   {
/*  34 */     mzm.gsp.activity.main.ActivityInterface.registerActivityByLogicType(132, new IndianaActivityHandler());
/*     */   }
/*     */   
/*     */   static void postInit()
/*     */   {
/*  39 */     postInitFlag = true;
/*  40 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  42 */       return;
/*     */     }
/*  44 */     for (Iterator i$ = SIndianaCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*     */       
/*  46 */       new mzm.gsp.util.LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  51 */           IndianaManager.tryGetAwardNumberAndSendAward(this.val$activityCfgid);
/*  52 */           return true;
/*     */         }
/*     */       }.call();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isIndianaSwitchOpen()
/*     */   {
/*  65 */     if (!OpenInterface.getOpenStatus(522))
/*     */     {
/*  67 */       return false;
/*     */     }
/*  69 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isIndianaSwitchOpenForRole(long roleid)
/*     */   {
/*  80 */     if (!OpenInterface.getOpenStatus(522))
/*     */     {
/*  82 */       return false;
/*     */     }
/*  84 */     if (OpenInterface.isBanPlay(roleid, 522))
/*     */     {
/*  86 */       OpenInterface.sendBanPlayMsg(roleid, 522);
/*  87 */       return false;
/*     */     }
/*  89 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getCurrentTurn(int activityCfgid)
/*     */   {
/* 100 */     SIndianaCfg cfg = SIndianaCfg.get(activityCfgid);
/* 101 */     if (cfg == null)
/*     */     {
/*     */ 
/* 104 */       return -1;
/*     */     }
/* 106 */     long currTimeInMillis = DateTimeUtils.getCurrTimeInMillis();
/* 107 */     Map.Entry<Integer, Integer> entry = cfg.turn_time_infos.floorEntry(Integer.valueOf((int)(currTimeInMillis / 1000L)));
/* 108 */     if (entry == null)
/*     */     {
/* 110 */       return 0;
/*     */     }
/* 112 */     return ((Integer)entry.getValue()).intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getPassTurn(int activityCfgid, long currTimeInMillis)
/*     */   {
/* 124 */     SIndianaCfg cfg = SIndianaCfg.get(activityCfgid);
/* 125 */     if (cfg == null)
/*     */     {
/*     */ 
/* 128 */       return -1;
/*     */     }
/* 130 */     Map.Entry<Integer, Integer> entry = cfg.turn_time_infos.floorEntry(Integer.valueOf((int)(currTimeInMillis / 1000L)));
/* 131 */     if (entry == null)
/*     */     {
/* 133 */       return 0;
/*     */     }
/* 135 */     int turn = ((Integer)entry.getValue()).intValue();
/* 136 */     SIndianaTurnInfo turnInfo = (SIndianaTurnInfo)cfg.turn_infos.get(Integer.valueOf(turn));
/* 137 */     if (turnInfo == null)
/*     */     {
/* 139 */       return 0;
/*     */     }
/* 141 */     if (currTimeInMillis < turnInfo.end_timestamp * 1000L)
/*     */     {
/* 143 */       return turn - 1;
/*     */     }
/* 145 */     return turn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getCurrentPassTurn(int activityCfgid)
/*     */   {
/* 156 */     long currTimeInMillis = DateTimeUtils.getCurrTimeInMillis();
/* 157 */     return getPassTurn(activityCfgid, currTimeInMillis);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getTurnBeginTimestamp(int activityCfgid, int turn)
/*     */   {
/* 169 */     SIndianaCfg cfg = SIndianaCfg.get(activityCfgid);
/* 170 */     if (cfg == null)
/*     */     {
/*     */ 
/* 173 */       return -1L;
/*     */     }
/* 175 */     SIndianaTurnInfo turnInfo = (SIndianaTurnInfo)cfg.turn_infos.get(Integer.valueOf(turn));
/* 176 */     if (turnInfo == null)
/*     */     {
/*     */ 
/* 179 */       return -1L;
/*     */     }
/* 181 */     return turnInfo.begin_timestamp * 1000L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getTurnEndTimestamp(int activityCfgid, int turn)
/*     */   {
/* 193 */     SIndianaCfg cfg = SIndianaCfg.get(activityCfgid);
/* 194 */     if (cfg == null)
/*     */     {
/*     */ 
/* 197 */       return -1L;
/*     */     }
/* 199 */     SIndianaTurnInfo turnInfo = (SIndianaTurnInfo)cfg.turn_infos.get(Integer.valueOf(turn));
/* 200 */     if (turnInfo == null)
/*     */     {
/*     */ 
/* 203 */       return -1L;
/*     */     }
/* 205 */     return turnInfo.end_timestamp * 1000L;
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
/*     */   static String getXNumberKey(int activityCfgid, int turn, int sortid, long number)
/*     */   {
/* 219 */     StringBuffer sb = new StringBuffer();
/* 220 */     sb.append(activityCfgid).append("|");
/* 221 */     sb.append(turn).append("|");
/* 222 */     sb.append(sortid).append("|");
/* 223 */     sb.append(number);
/* 224 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tryGetAwardNumberAndSendAward(int activityCfgid)
/*     */   {
/* 235 */     SIndianaCfg cfg = SIndianaCfg.get(activityCfgid);
/* 236 */     if (cfg == null)
/*     */     {
/*     */ 
/* 239 */       return;
/*     */     }
/* 241 */     long currTimeInMillis = DateTimeUtils.getCurrTimeInMillis();
/* 242 */     int passTurn = getPassTurn(activityCfgid, currTimeInMillis + 30000L);
/* 243 */     if (passTurn <= 0)
/*     */     {
/*     */ 
/* 246 */       return;
/*     */     }
/*     */     
/* 249 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(activityCfgid);
/* 250 */     IndianaInfo xIndianaInfo = Indiana_infos.get(Long.valueOf(globalActivityCfgid));
/* 251 */     if (xIndianaInfo == null)
/*     */     {
/* 253 */       xIndianaInfo = Pod.newIndianaInfo();
/* 254 */       Indiana_infos.insert(Long.valueOf(globalActivityCfgid), xIndianaInfo);
/*     */     }
/* 256 */     for (int turn = 1; turn <= passTurn; turn++)
/*     */     {
/* 258 */       SIndianaTurnInfo turnInfo = (SIndianaTurnInfo)cfg.turn_infos.get(Integer.valueOf(turn));
/* 259 */       if (turnInfo == null)
/*     */       {
/*     */ 
/* 262 */         return;
/*     */       }
/* 264 */       IndianaTurnInfo xIndianaTurnInfo = (IndianaTurnInfo)xIndianaInfo.getTurn_infos().get(Integer.valueOf(turn));
/* 265 */       if (xIndianaTurnInfo == null)
/*     */       {
/* 267 */         xIndianaTurnInfo = Pod.newIndianaTurnInfo();
/* 268 */         xIndianaInfo.getTurn_infos().put(Integer.valueOf(turn), xIndianaTurnInfo);
/*     */       }
/* 270 */       for (int sortid = 1; sortid <= turnInfo.award_infos.size(); sortid++)
/*     */       {
/* 272 */         IndianaAwardInfo xIndianaAwardInfo = (IndianaAwardInfo)xIndianaTurnInfo.getAward_infos().get(Integer.valueOf(sortid));
/* 273 */         if (xIndianaAwardInfo == null)
/*     */         {
/* 275 */           xIndianaAwardInfo = Pod.newIndianaAwardInfo();
/* 276 */           xIndianaTurnInfo.getAward_infos().put(Integer.valueOf(sortid), xIndianaAwardInfo);
/*     */         }
/* 278 */         if (!xIndianaAwardInfo.getGot_award_number())
/*     */         {
/*     */ 
/* 281 */           new GetAwardNumberSession(GRC_MIN_DELAY_IN_SECOND + xdb.Xdb.random().nextInt(GRC_MAX_DELAY_IN_SECOND - GRC_MIN_DELAY_IN_SECOND), activityCfgid, turn, sortid);
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 288 */           boolean needBrd = false;
/* 289 */           for (Map.Entry<Integer, IndianaAwardRoleInfo> entry : xIndianaAwardInfo.getAward_number_infos().entrySet())
/*     */           {
/* 291 */             int number = ((Integer)entry.getKey()).intValue();
/* 292 */             IndianaAwardRoleInfo xIndianaAwardRoleInfo = (IndianaAwardRoleInfo)entry.getValue();
/* 293 */             if ((xIndianaAwardRoleInfo.getAward_state() == 0) && (xIndianaAwardRoleInfo.getRoleid() > 0L))
/*     */             {
/*     */ 
/* 296 */               if (GameServerInfoManager.isRoleInOwnServer(xIndianaAwardRoleInfo.getRoleid()))
/*     */               {
/* 298 */                 IndianaOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(activityCfgid)).add(new PSendAwardAndBulletin(xIndianaAwardRoleInfo.getRoleid(), activityCfgid, turn, sortid, number));
/*     */ 
/*     */               }
/*     */               else
/*     */               {
/*     */ 
/* 304 */                 xIndianaAwardRoleInfo.setAward_state(2);
/*     */               }
/*     */             }
/* 307 */             if (xIndianaAwardRoleInfo.getAward_state() == 2)
/*     */             {
/* 309 */               if (xIndianaAwardRoleInfo.getRoleid() > 0L)
/*     */               {
/* 311 */                 if (GameServerInfoManager.isRoleInOwnServer(xIndianaAwardRoleInfo.getRoleid()))
/*     */                 {
/* 313 */                   xIndianaAwardRoleInfo.setAward_state(0);
/* 314 */                   IndianaOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(activityCfgid)).add(new PSendAwardAndBulletin(xIndianaAwardRoleInfo.getRoleid(), activityCfgid, turn, sortid, number));
/*     */                   
/*     */ 
/* 317 */                   needBrd = true;
/*     */                 }
/*     */               }
/*     */               else
/*     */               {
/* 322 */                 String xNumberKey = getXNumberKey(activityCfgid, turn, sortid, number);
/* 323 */                 Long roleid = xtable.Indiana_number_infos.select(xNumberKey);
/* 324 */                 if (roleid != null)
/*     */                 {
/* 326 */                   xIndianaAwardRoleInfo.setAward_state(0);
/* 327 */                   xIndianaAwardRoleInfo.setRoleid(roleid.longValue());
/* 328 */                   IndianaOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(activityCfgid)).add(new PSendAwardAndBulletin(xIndianaAwardRoleInfo.getRoleid(), activityCfgid, turn, sortid, number));
/*     */                   
/*     */ 
/* 331 */                   needBrd = true;
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/* 336 */           if (needBrd)
/*     */           {
/* 338 */             IndianaOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(activityCfgid)).add(new PBrdAwardRoleInfo(activityCfgid, turn, sortid));
/*     */           }
/*     */         }
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
/*     */   static int getFixAwardItemCfgid(long roleid, int fixAwardid)
/*     */   {
/* 355 */     if (fixAwardid <= 0)
/*     */     {
/* 357 */       return 0;
/*     */     }
/* 359 */     List<Integer> itemCfgids = mzm.gsp.award.main.AwardInterface.getFixAwardItems(roleid, fixAwardid);
/* 360 */     if ((itemCfgids == null) || (itemCfgids.isEmpty()))
/*     */     {
/* 362 */       return 0;
/*     */     }
/* 364 */     return ((Integer)itemCfgids.get(0)).intValue();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\IndianaManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */