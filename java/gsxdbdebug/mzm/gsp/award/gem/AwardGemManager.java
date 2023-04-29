/*     */ package mzm.gsp.award.gem;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.confbean.STAward;
/*     */ import mzm.gsp.award.confbean.STAwardGemCfgIds;
/*     */ import mzm.gsp.award.confbean.STAwardId2gemCfgIds;
/*     */ import mzm.gsp.award.confbean.STGemTable;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Procedure;
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
/*     */ public class AwardGemManager
/*     */ {
/*     */   public static void loadDBCountInfos()
/*     */   {
/*  36 */     for (Iterator i$ = getGemAllCfgIds().iterator(); i$.hasNext();) { int gemCfgId = ((Integer)i$.next()).intValue();
/*     */       
/*     */ 
/*  39 */       Procedure.execute(new PInitGemCacheCountInfo(getGemKey(gemCfgId)));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void checkGemOpenCfg()
/*     */   {
/*  48 */     OpenInterface.setOpenDefaultStatus(138, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void rmAllAwardIdXData()
/*     */   {
/*  56 */     Set<Integer> oldGemAwardIds = AwardGemCfgManager.getAllGemAwardId();
/*  57 */     if ((oldGemAwardIds == null) || (oldGemAwardIds.size() == 0))
/*     */     {
/*  59 */       GameServer.logger().info(String.format("[awardGem] no old xData......", new Object[0]));
/*  60 */       return;
/*     */     }
/*     */     
/*  63 */     for (STAward cfg : STAward.getAll().values())
/*     */     {
/*  65 */       int awardId = cfg.awardId;
/*     */       
/*  67 */       Procedure.execute(new PRmOldAwardIdXGemData(awardId));
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
/*     */   public static Map<Integer, Integer> getGemItemAndCount(long roleId, int awardId)
/*     */   {
/*  83 */     Map<Integer, Integer> itemMap = new HashMap();
/*  84 */     if (!isAwardGemOpened())
/*     */     {
/*  86 */       return itemMap;
/*     */     }
/*  88 */     List<Integer> gemCfgIds = getGemCfgIds(awardId);
/*  89 */     if ((gemCfgIds == null) || (gemCfgIds.size() == 0))
/*     */     {
/*  91 */       return itemMap;
/*     */     }
/*  93 */     for (Iterator i$ = gemCfgIds.iterator(); i$.hasNext();) { int gemCfgId = ((Integer)i$.next()).intValue();
/*     */       
/*  95 */       long gemKey = getGemKey(gemCfgId);
/*  96 */       ItemCountInfo countInfo = CountInfoContainer.getInstance().getCountInfo(gemKey);
/*  97 */       if (countInfo == null)
/*     */       {
/*  99 */         GameServer.logger().error(String.format("[award]AwardGemManager.getGemItemAndCount@ get countInfo error!|gemKey=%d|gemCfgId=%d", new Object[] { Long.valueOf(gemKey), Integer.valueOf(gemCfgId) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 104 */         STGemTable cfg = STGemTable.get(gemCfgId);
/* 105 */         if (cfg == null)
/*     */         {
/* 107 */           GameServer.logger().error(String.format("[award]AwardGemManager.getGemItemAndCount@ STGemTable not exist!|gemKey=%d|gemCfgId=%d", new Object[] { Long.valueOf(gemKey), Integer.valueOf(gemCfgId) }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 112 */           addGemItem(getGemItemAndCount(roleId, awardId, countInfo, cfg), itemMap); }
/*     */       }
/*     */     }
/* 115 */     return itemMap;
/*     */   }
/*     */   
/*     */   private static void addGemItem(int itemId, Map<Integer, Integer> itemMap)
/*     */   {
/* 120 */     if (itemId <= 0)
/*     */     {
/* 122 */       return;
/*     */     }
/* 124 */     Integer count = (Integer)itemMap.get(Integer.valueOf(itemId));
/* 125 */     if (count == null)
/*     */     {
/* 127 */       itemMap.put(Integer.valueOf(itemId), Integer.valueOf(1));
/* 128 */       return;
/*     */     }
/* 130 */     itemMap.put(Integer.valueOf(itemId), Integer.valueOf(count.intValue() + 1));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static List<Integer> getGemCfgIds(int awardId)
/*     */   {
/* 141 */     STAwardId2gemCfgIds cfg = STAwardId2gemCfgIds.get(awardId);
/* 142 */     if (cfg == null)
/*     */     {
/* 144 */       return new ArrayList();
/*     */     }
/* 146 */     return cfg.gemCfgIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isAwardGemOpened()
/*     */   {
/* 156 */     if (!OpenInterface.getOpenStatus(138))
/*     */     {
/* 158 */       return false;
/*     */     }
/* 160 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static CountInfoCopy selectCountInfo(int gemCfgId)
/*     */   {
/* 172 */     if (!isGemCfgIdExist(gemCfgId))
/*     */     {
/* 174 */       GameServer.logger().info(String.format("[awardGem]AwardGemManager.selectCountInfo@ gemCfg not used!|gemCfgId=%d", new Object[] { Integer.valueOf(gemCfgId) }));
/*     */     }
/*     */     
/* 177 */     long gemKey = getGemKey(gemCfgId);
/* 178 */     ItemCountInfo countInfo = CountInfoContainer.getInstance().getCountInfo(gemKey);
/* 179 */     if (countInfo == null)
/*     */     {
/* 181 */       GameServer.logger().error(String.format("[award]AwardGemManager.selectCountInfo@ get countInfo error!|gemCfgId=%d|gemkey=%d", new Object[] { Integer.valueOf(gemCfgId), Long.valueOf(gemKey) }));
/*     */       
/*     */ 
/* 184 */       return null;
/*     */     }
/* 186 */     return countInfo.getSnapshot();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static long getGemKey(int gemCfgId)
/*     */   {
/* 197 */     return GameServerInfoManager.toGlobalId(gemCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getGemCfgId(long gemKey)
/*     */   {
/* 208 */     return (int)GameServerInfoManager.toLocalId(gemKey);
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
/*     */   static void initCountInfo(long gemKey, int count, int awardNum, long startTime, boolean isAward, int curCircle)
/*     */   {
/* 222 */     if (!isGemKeyCfgExist(gemKey))
/*     */     {
/* 224 */       GameServer.logger().info(String.format("[awardGem]AwardGemManager.initCountInfo@gemKey cfg not exist!|gemKey=%d", new Object[] { Long.valueOf(gemKey) }));
/*     */       
/* 226 */       return;
/*     */     }
/* 228 */     ItemCountInfo countInfo = CountInfoContainer.getInstance().getCountInfo(gemKey);
/* 229 */     if (countInfo == null)
/*     */     {
/* 231 */       GameServer.logger().error(String.format("[award]AwardGemManager.selectCountInfo@ get countInfo error!|gemKey=%d", new Object[] { Long.valueOf(gemKey) }));
/*     */       
/* 233 */       return;
/*     */     }
/* 235 */     countInfo.init(gemKey, count, awardNum, startTime, isAward, curCircle);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean isGemKeyCfgExist(long gemKey)
/*     */   {
/* 246 */     int gemCfgId = getGemCfgId(gemKey);
/* 247 */     return isGemCfgIdExist(gemCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean isGemCfgIdExist(int gemCfgId)
/*     */   {
/* 258 */     return STAwardGemCfgIds.get(gemCfgId) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Set<Integer> getGemAllCfgIds()
/*     */   {
/* 268 */     return STAwardGemCfgIds.getAll().keySet();
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
/*     */   private static int getGemItemAndCount(long roleId, int awardId, ItemCountInfo countInfo, STGemTable cfg)
/*     */   {
/* 282 */     AddCountRes res = countInfo.addCount(cfg, canGetAward(roleId, cfg));
/*     */     
/* 284 */     NoneRealTimeTaskManager.getInstance().addTask(new PInsertXCountInfo(res.getSnap()));
/* 285 */     int itemId = -1;
/* 286 */     if (res.isNeedAward())
/*     */     {
/* 288 */       itemId = AwardGemCfgManager.ranOneItem(cfg);
/* 289 */       if (itemId <= 0)
/*     */       {
/* 291 */         GameServer.logger().error(String.format("[awardGem]AwardGemManager.getGemItemAndCount@ranOneItem error!|roleId=%d|awardId=%d|cfgId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(awardId), Integer.valueOf(cfg.gemCfgId) }));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 297 */     tlogGem(roleId, awardId, res.getSnap(), itemId);
/*     */     
/* 299 */     return itemId;
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
/*     */   private static boolean canGetAward(long roleId, STGemTable cfg)
/*     */   {
/* 315 */     int serLv = ServerInterface.getCurrentServerLevel();
/* 316 */     int roleLv = RoleInterface.getLevel(roleId);
/*     */     
/* 318 */     return canGetAward(serLv, roleLv, cfg);
/*     */   }
/*     */   
/*     */   private static boolean canGetAward(int serLv, int roleLv, STGemTable cfg)
/*     */   {
/* 323 */     return roleLv >= Math.max(cfg.dropLvLow, serLv - cfg.dropSerLvInterval);
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
/*     */ 
/*     */   static void tlogGem(long roleId, int awardId, CountInfoCopy snap, int itemId)
/*     */   {
/* 342 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 343 */     String userid = RoleInterface.getUserId(roleId);
/* 344 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 346 */     Object[] colums = { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(awardId), Integer.valueOf(snap.get_count()), Integer.valueOf(snap.get_awardNum()), Long.valueOf(snap.get_startTime()), Integer.valueOf(snap.is_isAwarded() ? 1 : 0), Integer.valueOf(itemId), Integer.valueOf(getGemCfgId(snap.get_gemKey())) };
/*     */     
/*     */ 
/* 349 */     TLogManager.getInstance().addLog(roleId, "AwardGem", colums);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gem\AwardGemManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */