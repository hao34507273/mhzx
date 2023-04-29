/*     */ package mzm.gsp.mergecompensation.main;
/*     */ 
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.item.confbean.SExpBottleMergeServerItemCfg;
/*     */ import mzm.gsp.mergecompensation.confbean.SMergeCompensationConsts;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.serverconf.confbean.SServerLevelConfig;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ServerLevelInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MergeCompensationManager
/*     */ {
/*  20 */   static final Logger logger = Logger.getLogger("merge_compensation");
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isAServerLevelLargerThanB(ServerLevelInfo xAServerLevelInfo, ServerLevelInfo xBServerLevelInfo)
/*     */   {
/*  32 */     if (xAServerLevelInfo.getServerlevel() > xBServerLevelInfo.getServerlevel())
/*     */     {
/*  34 */       return true;
/*     */     }
/*  36 */     if (xAServerLevelInfo.getServerlevel() < xBServerLevelInfo.getServerlevel())
/*     */     {
/*  38 */       return false;
/*     */     }
/*  40 */     if (xAServerLevelInfo.getTime_offset() - xAServerLevelInfo.getStarttime() - (xBServerLevelInfo.getTime_offset() - xBServerLevelInfo.getStarttime()) > 0L)
/*     */     {
/*     */ 
/*  43 */       return true;
/*     */     }
/*  45 */     return false;
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
/*     */   static int getServerLevelDeltaDay(long mergeSystemTimestamp, ServerLevelInfo xAServerLevelInfo, ServerLevelInfo xBServerLevelInfo)
/*     */   {
/*  61 */     if (isAServerLevelLargerThanB(xAServerLevelInfo, xBServerLevelInfo))
/*     */     {
/*  63 */       return -1;
/*     */     }
/*  65 */     long deltaTime = 0L;
/*  66 */     int startServerLevel = xAServerLevelInfo.getServerlevel();
/*  67 */     int endServerLevel = xBServerLevelInfo.getServerlevel();
/*     */     
/*  69 */     if (startServerLevel == endServerLevel)
/*     */     {
/*  71 */       deltaTime += mergeSystemTimestamp + xBServerLevelInfo.getTime_offset() - xBServerLevelInfo.getStarttime() - (mergeSystemTimestamp + xAServerLevelInfo.getTime_offset() - xAServerLevelInfo.getStarttime());
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/*  77 */       SServerLevelConfig cfg = SServerLevelConfig.get(startServerLevel);
/*  78 */       if (cfg == null)
/*     */       {
/*  80 */         return -2;
/*     */       }
/*  82 */       deltaTime += cfg.duration * 60 * 60 * 1000L - (mergeSystemTimestamp + xAServerLevelInfo.getTime_offset() - xAServerLevelInfo.getStarttime());
/*     */       
/*     */ 
/*  85 */       for (int serverLevel = ServerInterface.getNextServerLevelBean(startServerLevel).level; serverLevel < endServerLevel; serverLevel = ServerInterface.getNextServerLevelBean(serverLevel).level)
/*     */       {
/*  87 */         SServerLevelConfig cfg = SServerLevelConfig.get(serverLevel);
/*  88 */         if (cfg == null)
/*     */         {
/*  90 */           return -2;
/*     */         }
/*  92 */         deltaTime += cfg.duration * 60 * 60 * 1000L;
/*     */       }
/*     */       
/*  95 */       deltaTime += mergeSystemTimestamp + xBServerLevelInfo.getTime_offset() - xBServerLevelInfo.getStarttime();
/*     */     }
/*     */     
/*  98 */     if (deltaTime < 0L)
/*     */     {
/* 100 */       return -3;
/*     */     }
/* 102 */     return (int)(deltaTime / 86400000L);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isInSameMergeOperation(long timestamp1, long timestamp2)
/*     */   {
/* 114 */     return Math.abs(timestamp1 - timestamp2) <= SMergeCompensationConsts.getInstance().MERGE_OPERATION_TIME_IN_HOUR * 60 * 60 * 1000L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isMergeCompensationSwitchOpen()
/*     */   {
/* 124 */     if (!OpenInterface.getOpenStatus(316))
/*     */     {
/* 126 */       return false;
/*     */     }
/* 128 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isMergeCompensationSwitchOpenForRole(long roleid)
/*     */   {
/* 139 */     if (!OpenInterface.getOpenStatus(316))
/*     */     {
/* 141 */       return false;
/*     */     }
/* 143 */     if (OpenInterface.isBanPlay(roleid, 316))
/*     */     {
/* 145 */       OpenInterface.sendBanPlayMsg(roleid, 316);
/* 146 */       return false;
/*     */     }
/* 148 */     return true;
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
/*     */   static int getExpBottleItemCfgid(int deltaDay)
/*     */   {
/* 161 */     TreeMap<Integer, SExpBottleMergeServerItemCfg> itemCfgids = null;
/* 162 */     if ((SExpBottleMergeServerItemCfg.getAll() instanceof TreeMap))
/*     */     {
/* 164 */       itemCfgids = (TreeMap)SExpBottleMergeServerItemCfg.getAll();
/*     */     }
/* 166 */     if (itemCfgids == null)
/*     */     {
/* 168 */       return -1;
/*     */     }
/* 170 */     return ((SExpBottleMergeServerItemCfg)itemCfgids.floorEntry(Integer.valueOf(deltaDay)).getValue()).item_cfg_id;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mergecompensation\main\MergeCompensationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */