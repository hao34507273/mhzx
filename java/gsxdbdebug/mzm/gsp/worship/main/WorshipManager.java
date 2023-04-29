/*     */ package mzm.gsp.worship.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.STWorShipSalaryCfg;
/*     */ import mzm.gsp.activity.confbean.WorShipConst;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.CloneRoleNpcModelType;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.worship.SSynRoleWorshipInfo;
/*     */ import mzm.gsp.worship.SSynWorshipInfo;
/*     */ import mzm.gsp.worship.SWorshipNormalResult;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FactionWorshipInfo;
/*     */ import xbean.RoleWorshipInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2worship;
/*     */ 
/*     */ public class WorshipManager
/*     */ {
/*  32 */   private static boolean debugMode = false;
/*     */   
/*  34 */   private static final ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*     */   static boolean isDebugMode()
/*     */   {
/*  38 */     lock.readLock().lock();
/*     */     try
/*     */     {
/*  41 */       return debugMode;
/*     */     }
/*     */     finally
/*     */     {
/*  45 */       lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   static void setDebugMode(boolean isDebug)
/*     */   {
/*  51 */     lock.writeLock().lock();
/*     */     try
/*     */     {
/*  54 */       debugMode = isDebug;
/*     */     }
/*     */     finally
/*     */     {
/*  58 */       lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   static void setAllFactionMasterNpc()
/*     */   {
/*  64 */     for (Iterator i$ = GangInterface.getAllGangIdSet().iterator(); i$.hasNext();) { long factionId = ((Long)i$.next()).longValue();
/*     */       
/*  66 */       setFactionMasterNpc(factionId);
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
/*     */   static RoleWorshipInfo getXRoleWorshipDataIfAbsent(long roleId, long factionId)
/*     */   {
/*  85 */     RoleWorshipInfo xRoleWorshipInfo = Role2worship.get(Long.valueOf(roleId));
/*  86 */     if (xRoleWorshipInfo == null)
/*     */     {
/*  88 */       xRoleWorshipInfo = xbean.Pod.newRoleWorshipInfo();
/*  89 */       xRoleWorshipInfo.setCurfactionid(factionId);
/*  90 */       Role2worship.insert(Long.valueOf(roleId), xRoleWorshipInfo);
/*     */     }
/*  92 */     return xRoleWorshipInfo;
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
/*     */   static int getSalary(long roleId, int fileCount)
/*     */   {
/* 106 */     if (fileCount <= 0)
/*     */     {
/* 108 */       return 0;
/*     */     }
/* 110 */     STWorShipSalaryCfg cfg = null;
/* 111 */     for (STWorShipSalaryCfg tmpCfg : STWorShipSalaryCfg.getAll().values())
/*     */     {
/* 113 */       if ((tmpCfg.minNum <= fileCount) && 
/*     */       
/*     */ 
/*     */ 
/* 117 */         (tmpCfg.maxNum >= fileCount))
/*     */       {
/*     */ 
/*     */ 
/* 121 */         cfg = tmpCfg;
/*     */       }
/*     */     }
/* 124 */     if (cfg == null)
/*     */     {
/* 126 */       GameServer.logger().error(String.format("[worship]WorshipManager.getSalary@ can not find right cfg!|roleId=%d|fileCount=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(fileCount) }));
/*     */       
/*     */ 
/* 129 */       return 0;
/*     */     }
/* 131 */     return cfg.salary + cfg.salaryPerOneFile * (fileCount - cfg.minNum + 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synRoleWorshipData(long roleId, long factionId, RoleWorshipInfo xRoleWorshipInfo)
/*     */   {
/* 143 */     if (xRoleWorshipInfo == null)
/*     */     {
/* 145 */       return;
/*     */     }
/* 147 */     Integer thisCircleNum = (Integer)xRoleWorshipInfo.getThiscycledata().get(Long.valueOf(factionId));
/* 148 */     Integer dbLastNum = (Integer)xRoleWorshipInfo.getLastcycledata().get(Long.valueOf(factionId));
/* 149 */     SSynRoleWorshipInfo synPro = new SSynRoleWorshipInfo();
/* 150 */     synPro.worshipid = xRoleWorshipInfo.getWorshipid();
/* 151 */     synPro.lastcyclenum = (dbLastNum == null ? 0 : dbLastNum.intValue());
/* 152 */     synPro.thiscyclenum = (thisCircleNum == null ? 0 : thisCircleNum.intValue());
/* 153 */     synPro.cangetsalary = getSalary(roleId, synPro.lastcyclenum);
/* 154 */     synPro.nextcangetsalary = getSalary(roleId, synPro.thiscyclenum);
/* 155 */     OnlineManager.getInstance().send(roleId, synPro);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void convertFactionData(RoleWorshipInfo xRoleWorshipInfo, long factionId)
/*     */   {
/* 166 */     if (xRoleWorshipInfo == null)
/*     */     {
/* 168 */       return;
/*     */     }
/* 170 */     if (factionId <= 0L)
/*     */     {
/*     */ 
/* 173 */       return;
/*     */     }
/* 175 */     long xCurFactionId = xRoleWorshipInfo.getCurfactionid();
/* 176 */     if (xCurFactionId == factionId)
/*     */     {
/* 178 */       return;
/*     */     }
/*     */     
/* 181 */     convertFactionData(xRoleWorshipInfo.getLastcycledata(), factionId, xCurFactionId);
/* 182 */     convertFactionData(xRoleWorshipInfo.getThiscycledata(), factionId, xCurFactionId);
/* 183 */     xRoleWorshipInfo.setCurfactionid(factionId);
/*     */   }
/*     */   
/*     */   private static void convertFactionData(Map<Long, Integer> xCircleData, long curFactionId, long oldFactionId)
/*     */   {
/* 188 */     Integer oldCycleNum = (Integer)xCircleData.get(Long.valueOf(oldFactionId));
/* 189 */     Integer newCycleNum = (Integer)xCircleData.get(Long.valueOf(curFactionId));
/* 190 */     if (oldCycleNum == null)
/*     */     {
/* 192 */       return;
/*     */     }
/* 194 */     int newNum = newCycleNum == null ? oldCycleNum.intValue() : newCycleNum.intValue() + oldCycleNum.intValue();
/* 195 */     if (newNum <= 0)
/*     */     {
/* 197 */       return;
/*     */     }
/* 199 */     xCircleData.put(Long.valueOf(curFactionId), Integer.valueOf(newNum));
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
/*     */   static void setFactionMasterNpc(long factionId)
/*     */   {
/* 212 */     Gang faction = GangInterface.getGang(factionId, false);
/* 213 */     if (faction == null)
/*     */     {
/* 215 */       return;
/*     */     }
/* 217 */     long masterRoleId = faction.getBangZhuId();
/* 218 */     if (masterRoleId <= 0L)
/*     */     {
/* 220 */       GameServer.logger().error(String.format("[worship]POnCreateGang.processImp@ can not get master's id!|gangId=%d", new Object[] { Long.valueOf(factionId) }));
/*     */       
/* 222 */       return;
/*     */     }
/* 224 */     MapInterface.setCloneRoleNpcModelAsyc(CloneRoleNpcModelType.GANG, factionId, masterRoleId, WorShipConst.getInstance().npcId, GangInterface.getGangChengWeiId());
/*     */     
/* 226 */     long worldId = GangInterface.getGangWorldId(factionId);
/* 227 */     if (worldId == -1L)
/*     */     {
/* 229 */       return;
/*     */     }
/* 231 */     MapInterface.addCloneRoleNpcAsync(CloneRoleNpcModelType.GANG, factionId, WorShipConst.getInstance().npcId, worldId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void rmFactionMasterNpc(long factionId)
/*     */   {
/* 242 */     MapInterface.unsetCloneRoleNpcModelAsync(CloneRoleNpcModelType.GANG, factionId, WorShipConst.getInstance().npcId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void aSynRoleAllWorshipInfo(long roleId)
/*     */   {
/* 254 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 260 */         WorshipManager.synAllWorshipInfo(this.val$roleId);
/* 261 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synAllWorshipInfo(long roleId)
/*     */   {
/* 275 */     SSynWorshipInfo pro = new SSynWorshipInfo();
/*     */     
/* 277 */     String userid = RoleInterface.getUserId(roleId);
/* 278 */     Lockeys.lock(Lockeys.get(xtable.User.getTable(), userid));
/*     */     
/* 280 */     Lockeys.lock(xtable.Basic.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/* 281 */     RoleWorshipInfo xRoleWorshipInfo = Role2worship.get(Long.valueOf(roleId));
/*     */     
/* 283 */     long factionId = GangInterface.getGangId(roleId);
/*     */     
/* 285 */     convertFactionData(xRoleWorshipInfo, factionId);
/*     */     
/* 287 */     fillRoleData(roleId, xRoleWorshipInfo, factionId, pro);
/* 288 */     fillFactionData(factionId, pro);
/* 289 */     OnlineManager.getInstance().send(roleId, pro);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void fillRoleData(long roleId, RoleWorshipInfo xRoleWorshipInfo, long factionId, SSynWorshipInfo pro)
/*     */   {
/* 300 */     if (xRoleWorshipInfo == null)
/*     */     {
/* 302 */       return;
/*     */     }
/* 304 */     Integer thisCircleNum = (Integer)xRoleWorshipInfo.getThiscycledata().get(Long.valueOf(factionId));
/* 305 */     Integer dbLastNum = (Integer)xRoleWorshipInfo.getLastcycledata().get(Long.valueOf(factionId));
/* 306 */     pro.worshipid = xRoleWorshipInfo.getWorshipid();
/* 307 */     pro.lastcyclenum = (dbLastNum == null ? 0 : dbLastNum.intValue());
/* 308 */     pro.thiscyclenum = (thisCircleNum == null ? 0 : thisCircleNum.intValue());
/* 309 */     pro.cangetsalary = getSalary(roleId, pro.lastcyclenum);
/* 310 */     pro.nextcangetsalary = getSalary(roleId, pro.thiscyclenum);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void fillFactionData(long factionId, SSynWorshipInfo pro)
/*     */   {
/* 322 */     if (factionId <= 0L)
/*     */     {
/* 324 */       return;
/*     */     }
/* 326 */     FactionWorshipInfo xFactionData = xtable.Faction2worship.select(Long.valueOf(factionId));
/* 327 */     if (xFactionData == null)
/*     */     {
/* 329 */       return;
/*     */     }
/* 331 */     pro.worshipid2num.putAll(xFactionData.getWorshipdata());
/*     */     
/* 333 */     for (xbean.SingleWorshipInfo xSingleWorshipInfo : xFactionData.getWorshiprecord())
/*     */     {
/* 335 */       mzm.gsp.worship.SingleWorshipInfo pSingleWorshipInfo = new mzm.gsp.worship.SingleWorshipInfo();
/* 336 */       pSingleWorshipInfo.contentindex = xSingleWorshipInfo.getContentindex();
/* 337 */       pSingleWorshipInfo.roleid = xSingleWorshipInfo.getRoleid();
/* 338 */       pSingleWorshipInfo.worshipid = xSingleWorshipInfo.getWorshipid();
/* 339 */       pro.worshiprecord.add(pSingleWorshipInfo);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isWorshipOpen()
/*     */   {
/* 350 */     if (!OpenInterface.getOpenStatus(272))
/*     */     {
/* 352 */       return false;
/*     */     }
/* 354 */     return true;
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
/*     */   static void tlogWorship(String userId, long roleId, int worshipId, long factionId, long masterId)
/*     */   {
/* 368 */     String vGameIP = mzm.gsp.GameServerInfoManager.getHostIP();
/* 369 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 371 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(worshipId), Long.valueOf(factionId), Long.valueOf(masterId) };
/*     */     
/* 373 */     TLogManager.getInstance().addLog(roleId, "Worship", colums);
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
/*     */   static void sendWorshipNotice(Collection<Long> roleIds, boolean afterSuc, int result, String... args)
/*     */   {
/* 386 */     if ((roleIds == null) || (roleIds.size() == 0))
/*     */     {
/* 388 */       return;
/*     */     }
/* 390 */     SWorshipNormalResult pro = new SWorshipNormalResult();
/* 391 */     pro.result = result;
/* 392 */     for (String arg : args)
/*     */     {
/* 394 */       pro.args.add(arg);
/*     */     }
/* 396 */     if (afterSuc)
/*     */     {
/* 398 */       OnlineManager.getInstance().sendMulti(pro, roleIds);
/*     */     }
/*     */     else
/*     */     {
/* 402 */       OnlineManager.getInstance().sendMultiAtOnce(pro, roleIds);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\main\WorshipManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */