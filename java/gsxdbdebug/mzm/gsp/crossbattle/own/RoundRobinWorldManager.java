/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoundRobinWorldManager
/*     */ {
/*  17 */   private static RoundRobinWorldManager instance = new RoundRobinWorldManager();
/*     */   
/*     */   static RoundRobinWorldManager getInstance()
/*     */   {
/*  21 */     return instance;
/*     */   }
/*     */   
/*  24 */   private ReentrantLock lock = new ReentrantLock();
/*  25 */   private HashMap<Integer, Long> worldids = new HashMap();
/*  26 */   private HashMap<Long, Integer> activityCfgids = new HashMap();
/*     */   
/*     */   long createWorld(int activityCfgid)
/*     */   {
/*  30 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(activityCfgid);
/*  31 */     if (cfg == null)
/*     */     {
/*  33 */       return -1L;
/*     */     }
/*  35 */     this.lock.lock();
/*     */     try
/*     */     {
/*  38 */       if (this.worldids.containsKey(Integer.valueOf(activityCfgid)))
/*     */       {
/*  40 */         CrossBattleOwnManager.logger.error(String.format("[crossbattle_own]RoundRobinWorldManager.createWorld@create world error|activity_cfg_id=%d|worldid=%d", new Object[] { Integer.valueOf(activityCfgid), this.worldids.get(Integer.valueOf(activityCfgid)) }));
/*     */         
/*     */ 
/*  43 */         return -1L;
/*     */       }
/*  45 */       long worldid = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(cfg.round_robin_map_cfg_id) }));
/*  46 */       TeamInterface.registerJoinTeam(worldid, new RoundRobinJoinTeamCheckHandler());
/*  47 */       this.worldids.put(Integer.valueOf(activityCfgid), Long.valueOf(worldid));
/*  48 */       this.activityCfgids.put(Long.valueOf(worldid), Integer.valueOf(activityCfgid));
/*  49 */       CrossBattleOwnManager.logger.info(String.format("[crossbattle_own]RoundRobinWorldManager.createWorld@create world|activity_cfg_id=%d|worldid=%d", new Object[] { Integer.valueOf(activityCfgid), Long.valueOf(worldid) }));
/*     */       
/*     */ 
/*  52 */       return worldid;
/*     */     }
/*     */     finally
/*     */     {
/*  56 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   long getWorldid(int activityCfgid)
/*     */   {
/*  62 */     this.lock.lock();
/*     */     try
/*     */     {
/*  65 */       Long worldid = (Long)this.worldids.get(Integer.valueOf(activityCfgid));
/*  66 */       long l; if (worldid == null)
/*     */       {
/*  68 */         return -1L;
/*     */       }
/*  70 */       return worldid.longValue();
/*     */     }
/*     */     finally
/*     */     {
/*  74 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   int getActivityCfgid(long worldid)
/*     */   {
/*  80 */     this.lock.lock();
/*     */     try
/*     */     {
/*  83 */       Integer activityCfgid = (Integer)this.activityCfgids.get(Long.valueOf(worldid));
/*  84 */       int i; if (activityCfgid == null)
/*     */       {
/*  86 */         return -1;
/*     */       }
/*  88 */       return activityCfgid.intValue();
/*     */     }
/*     */     finally
/*     */     {
/*  92 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   long destroyWorld(int activityCfgid)
/*     */   {
/*  98 */     this.lock.lock();
/*     */     try
/*     */     {
/* 101 */       Long worldid = (Long)this.worldids.remove(Integer.valueOf(activityCfgid));
/* 102 */       long l; if (worldid == null)
/*     */       {
/* 104 */         CrossBattleOwnManager.logger.error(String.format("[crossbattle_own]RoundRobinWorldManager.destroyWorld@destroy world error|activity_cfg_id=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*     */         
/*     */ 
/* 107 */         return -1L;
/*     */       }
/* 109 */       TeamInterface.unRegisterJoinTeam(worldid.longValue());
/* 110 */       MapInterface.destroyWorld(worldid.longValue());
/* 111 */       this.activityCfgids.remove(worldid);
/* 112 */       CrossBattleOwnManager.logger.info(String.format("[crossbattle_own]RoundRobinWorldManager.createWorld@destroy world|activity_cfg_id=%d|worldid=%d", new Object[] { Integer.valueOf(activityCfgid), worldid }));
/*     */       
/*     */ 
/* 115 */       return worldid.longValue();
/*     */     }
/*     */     finally
/*     */     {
/* 119 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\RoundRobinWorldManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */