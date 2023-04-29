/*     */ package mzm.gsp.petarena.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.petarena.event.PetArenaRankChanged;
/*     */ import mzm.gsp.petarena.event.PetArenaRankChangedArg;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.util.TaskOneByOne;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetArenaRank;
/*     */ import xbean.PetArenaRankInfo;
/*     */ import xtable.Petarenarank;
/*     */ 
/*     */ public class PetArenaRankManager
/*     */ {
/*  24 */   private static final PetArenaRankManager instance = new PetArenaRankManager();
/*     */   
/*     */   public static PetArenaRankManager getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  36 */   private static final TaskOneByOne tasks = new TaskOneByOne();
/*     */   
/*     */   public static void asyncPetArenaAward()
/*     */   {
/*  40 */     tasks.add(new PToRankBackUp(null));
/*     */   }
/*     */   
/*     */   private static class PToRankBackUp
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  48 */       long key = GameServerInfoManager.getLocalId();
/*  49 */       PetArenaRank xPetArenaRank = Petarenarank.get(Long.valueOf(key));
/*  50 */       if (xPetArenaRank == null)
/*     */       {
/*  52 */         GameServer.logger().error("[petarena]PToRankBackUp.processImp@xbean is null");
/*  53 */         return false;
/*     */       }
/*     */       
/*  56 */       Map<Long, Integer> roles = new HashMap(xPetArenaRank.getRoles());
/*  57 */       long time = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  58 */       mzm.gsp.util.NoneRealTimeTaskManager.getInstance().addTask(new PCheckRankAndBackUp(roles, time));
/*     */       
/*  60 */       GameServer.logger().info(String.format("[petarena]PToRankBackUp.processImp@async start backup|time=%d", new Object[] { Long.valueOf(time) }));
/*  61 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   public static void asyncUpdateRank(PetCVCFightContext fightContext, PetArenaFightResultContext resultContext)
/*     */   {
/*  67 */     tasks.add(new PUpdateRank(fightContext, resultContext));
/*     */   }
/*     */   
/*     */   private static class PUpdateRank
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final PetCVCFightContext fightContext;
/*     */     private final PetArenaFightResultContext resultContext;
/*     */     
/*     */     public PUpdateRank(PetCVCFightContext fightContext, PetArenaFightResultContext resultContext)
/*     */     {
/*  78 */       this.fightContext = fightContext;
/*  79 */       this.resultContext = resultContext;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  85 */       RankInfo activeRankInfo = this.fightContext.activeRankInfo;
/*  86 */       RankInfo passiveRankInfo = this.fightContext.passiveRankInfo;
/*     */       
/*  88 */       long winRoleid = activeRankInfo.roleid;
/*  89 */       long loseRoleid = passiveRankInfo.roleid;
/*     */       
/*  91 */       long key = GameServerInfoManager.getLocalId();
/*  92 */       PetArenaRank xPetArenaRank = Petarenarank.get(Long.valueOf(key));
/*  93 */       if (xPetArenaRank == null)
/*     */       {
/*  95 */         GameServer.logger().error(String.format("[petarena]PUpdateRank.processImp@xbean is null|win_roleid=%d|lose_roleid=%d", new Object[] { Long.valueOf(winRoleid), Long.valueOf(loseRoleid) }));
/*     */         
/*     */ 
/*  98 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 102 */       int opponentRank = passiveRankInfo.rank;
/* 103 */       PetArenaRankInfo xPetArenaRankInfo = (PetArenaRankInfo)xPetArenaRank.getRanks().get(opponentRank - 1);
/* 104 */       if (xPetArenaRankInfo == null)
/*     */       {
/* 106 */         GameServer.logger().error(String.format("[petarena]PUpdateRank.processImp@xbean is null|win_roleid=%d|opponent_rank=%d", new Object[] { Long.valueOf(winRoleid), Integer.valueOf(opponentRank) }));
/*     */         
/*     */ 
/* 109 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 113 */       Integer oldRank = (Integer)xPetArenaRank.getRoles().get(Long.valueOf(winRoleid));
/* 114 */       if (oldRank == null)
/*     */       {
/* 116 */         oldRank = Integer.valueOf(-1);
/*     */       }
/*     */       
/* 119 */       boolean same = xPetArenaRankInfo.getRoleid() == loseRoleid;
/* 120 */       if (loseRoleid > 0L)
/*     */       {
/* 122 */         int realOpponentRank = -1;
/* 123 */         if (same)
/*     */         {
/* 125 */           realOpponentRank = opponentRank;
/*     */         }
/*     */         else
/*     */         {
/* 129 */           Integer rankData = (Integer)xPetArenaRank.getRoles().get(Long.valueOf(loseRoleid));
/* 130 */           if (rankData != null)
/*     */           {
/* 132 */             realOpponentRank = rankData.intValue();
/*     */           }
/*     */         }
/*     */         
/* 136 */         boolean changed = false;
/* 137 */         if (oldRank.intValue() == -1)
/*     */         {
/* 139 */           if (realOpponentRank != -1)
/*     */           {
/* 141 */             changed = true;
/*     */           }
/*     */           
/*     */ 
/*     */         }
/* 146 */         else if ((realOpponentRank > 0) && (realOpponentRank < oldRank.intValue()))
/*     */         {
/* 148 */           changed = true;
/*     */         }
/*     */         
/*     */ 
/* 152 */         if (changed)
/*     */         {
/* 154 */           PetArenaRankInfo xRealPetArenaRankInfo = (PetArenaRankInfo)xPetArenaRank.getRanks().get(realOpponentRank - 1);
/* 155 */           if (xRealPetArenaRankInfo == null)
/*     */           {
/* 157 */             GameServer.logger().error(String.format("[petarena]PUpdateRank.processImp@xbean is null|win_roleid=%d|lose_roleid=%d|old_rank=%d|old_real_rank=%d|opponent_rank=%d|real_opponent_rank=%d", new Object[] { Long.valueOf(winRoleid), Long.valueOf(loseRoleid), Integer.valueOf(activeRankInfo.rank), oldRank, Integer.valueOf(opponentRank), Integer.valueOf(realOpponentRank) }));
/*     */             
/*     */ 
/*     */ 
/* 161 */             return false;
/*     */           }
/*     */           
/*     */ 
/* 165 */           xRealPetArenaRankInfo.setRoleid(winRoleid);
/* 166 */           xPetArenaRank.getRoles().put(Long.valueOf(winRoleid), Integer.valueOf(realOpponentRank));
/* 167 */           PetArenaRankManager.getInstance().setRank(realOpponentRank, new RankInfo(realOpponentRank, winRoleid));
/*     */           
/* 169 */           if (oldRank.intValue() > 0)
/*     */           {
/*     */ 
/* 172 */             PetArenaRankInfo xOldPetArenaRankInfo = (PetArenaRankInfo)xPetArenaRank.getRanks().get(oldRank.intValue() - 1);
/* 173 */             xOldPetArenaRankInfo.setRoleid(loseRoleid);
/* 174 */             xPetArenaRank.getRoles().put(Long.valueOf(loseRoleid), oldRank);
/* 175 */             PetArenaRankManager.getInstance().setRank(oldRank.intValue(), new RankInfo(oldRank.intValue(), loseRoleid));
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 180 */         PetArenaRankChangedArg winArg = new PetArenaRankChangedArg(winRoleid, loseRoleid, true, 0, oldRank.intValue(), changed ? realOpponentRank : oldRank.intValue(), changed, true, this.fightContext.activeInfos, this.fightContext.passiveInfos, this.resultContext);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 186 */         TriggerEventsManger.getInstance().triggerEvent(new PetArenaRankChanged(), winArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(winRoleid)));
/*     */         
/*     */ 
/*     */ 
/* 190 */         PetArenaRankChangedArg loseArg = new PetArenaRankChangedArg(loseRoleid, winRoleid, false, 1, realOpponentRank, changed ? oldRank.intValue() : realOpponentRank, changed, false, this.fightContext.activeInfos, this.fightContext.passiveInfos, this.resultContext);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 197 */         TriggerEventsManger.getInstance().triggerEvent(new PetArenaRankChanged(), loseArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(loseRoleid)));
/*     */         
/*     */ 
/* 200 */         GameServer.logger().info(String.format("[petarena]PUpdateRank.processImp@update success|win_roleid=%d|lose_roleid=%d|old_rank=%d|old_real_rank=%d|rank=%d|real_rank=%d", new Object[] { Long.valueOf(winRoleid), Long.valueOf(loseRoleid), Integer.valueOf(activeRankInfo.rank), oldRank, Integer.valueOf(opponentRank), Integer.valueOf(realOpponentRank) }));
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 207 */         int robotRank = -1;
/* 208 */         if (same)
/*     */         {
/* 210 */           robotRank = opponentRank;
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 215 */           robotRank = PetArenaRankManager.getInstance().getRobotRank(opponentRank);
/*     */         }
/*     */         
/* 218 */         boolean changed = false;
/* 219 */         if (oldRank.intValue() == -1)
/*     */         {
/* 221 */           if (robotRank != -1)
/*     */           {
/* 223 */             changed = true;
/*     */           }
/*     */           
/*     */ 
/*     */         }
/* 228 */         else if ((robotRank > 0) && (robotRank < oldRank.intValue()))
/*     */         {
/* 230 */           changed = true;
/*     */         }
/*     */         
/*     */ 
/* 234 */         if (changed)
/*     */         {
/*     */ 
/* 237 */           xPetArenaRankInfo.setRoleid(winRoleid);
/* 238 */           xPetArenaRank.getRoles().put(Long.valueOf(winRoleid), Integer.valueOf(robotRank));
/* 239 */           PetArenaRankManager.getInstance().setRank(robotRank, new RankInfo(robotRank, winRoleid));
/*     */           
/*     */ 
/* 242 */           PetArenaTeamManager.asyncRemoveRobotTeamInfo(robotRank);
/*     */           
/* 244 */           if (oldRank.intValue() > 0)
/*     */           {
/*     */ 
/* 247 */             PetArenaRankManager.getInstance().setRobotRank(opponentRank, oldRank.intValue());
/*     */             
/* 249 */             PetArenaRankManager.getInstance().removeRobotRank(oldRank.intValue());
/*     */             
/*     */ 
/* 252 */             PetArenaRankInfo xOldPetArenaRankInfo = (PetArenaRankInfo)xPetArenaRank.getRanks().get(oldRank.intValue() - 1);
/* 253 */             xOldPetArenaRankInfo.setRoleid(0L);
/* 254 */             PetArenaRankManager.getInstance().setRank(oldRank.intValue(), new RankInfo(oldRank.intValue(), 0L));
/*     */             
/*     */ 
/* 257 */             if (oldRank.intValue() < PetArenaChartManager.capacity())
/*     */             {
/* 259 */               PetArenaChartManager.rank(new PetArenaChartObj(oldRank.intValue()));
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 264 */             PetArenaRankManager.getInstance().removeRobotRank(opponentRank);
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 269 */         PetArenaRankChangedArg winArg = new PetArenaRankChangedArg(winRoleid, loseRoleid, true, 0, oldRank.intValue(), changed ? robotRank : oldRank.intValue(), changed, true, this.fightContext.activeInfos, this.fightContext.passiveInfos, this.resultContext);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 275 */         TriggerEventsManger.getInstance().triggerEvent(new PetArenaRankChanged(), winArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(winRoleid)));
/*     */         
/*     */ 
/* 278 */         GameServer.logger().info(String.format("[petarena]PUpdateRank.processImp@update success|win_roleid=%d|lose_roleid=%d|old_rank=%d|old_real_rank=%d|opponent_rank=%d|robot_rank=%d", new Object[] { Long.valueOf(winRoleid), Long.valueOf(loseRoleid), Integer.valueOf(activeRankInfo.rank), oldRank, Integer.valueOf(opponentRank), Integer.valueOf(robotRank) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 284 */       return true;
/*     */     }
/*     */   }
/*     */   
/* 288 */   private final ReadWriteLock rwLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/* 289 */   private final List<RankInfo> ranks = new ArrayList();
/* 290 */   private final Map<Long, Integer> roles = new HashMap();
/*     */   
/*     */ 
/* 293 */   private final Map<Integer, Integer> robotRanks = new HashMap();
/*     */   
/*     */   public int getRank(long roleid)
/*     */   {
/* 297 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 300 */       Integer rank = (Integer)this.roles.get(Long.valueOf(roleid));
/* 301 */       return rank == null ? -1 : rank.intValue();
/*     */     }
/*     */     finally
/*     */     {
/* 305 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeRank(long roleid)
/*     */   {
/* 311 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 314 */       this.roles.remove(Long.valueOf(roleid));
/*     */     }
/*     */     finally
/*     */     {
/* 318 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setRank(int rank, RankInfo rankInfo)
/*     */   {
/* 324 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 327 */       this.ranks.set(rank - 1, rankInfo);
/* 328 */       long roleid = rankInfo.roleid;
/* 329 */       if (roleid > 0L)
/*     */       {
/* 331 */         this.roles.put(Long.valueOf(roleid), Integer.valueOf(rank));
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 336 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public List<RankInfo> getRankInfos(List<Integer> ranks)
/*     */   {
/* 342 */     if ((ranks == null) || (ranks.isEmpty()))
/*     */     {
/* 344 */       return java.util.Collections.emptyList();
/*     */     }
/*     */     
/* 347 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 350 */       List<RankInfo> rankInfos = new ArrayList();
/* 351 */       for (Iterator i$ = ranks.iterator(); i$.hasNext();) { int rank = ((Integer)i$.next()).intValue();
/*     */         
/* 353 */         rankInfos.add(this.ranks.get(rank - 1));
/*     */       }
/* 355 */       return rankInfos;
/*     */     }
/*     */     finally
/*     */     {
/* 359 */       this.rwLock.readLock().unlock();
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
/*     */   public boolean checkRankChanged(int targetRank, long roleid)
/*     */   {
/* 372 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 375 */       RankInfo rankInfo = (RankInfo)this.ranks.get(targetRank - 1);
/* 376 */       boolean bool; if (rankInfo == null)
/*     */       {
/* 378 */         return true;
/*     */       }
/* 380 */       return rankInfo.roleid != roleid;
/*     */     }
/*     */     finally
/*     */     {
/* 384 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setRobotRank(int robot, int rank)
/*     */   {
/* 390 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 393 */       this.robotRanks.put(Integer.valueOf(robot), Integer.valueOf(rank));
/*     */     }
/*     */     finally
/*     */     {
/* 397 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeRobotRank(int robot)
/*     */   {
/* 403 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 406 */       this.robotRanks.remove(Integer.valueOf(robot));
/*     */     }
/*     */     finally
/*     */     {
/* 410 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getRobotRank(int robot)
/*     */   {
/* 416 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 419 */       Integer rank = (Integer)this.robotRanks.get(Integer.valueOf(robot));
/* 420 */       return rank != null ? rank.intValue() : -1;
/*     */     }
/*     */     finally
/*     */     {
/* 424 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void addRank(int rank, RankInfo rankInfo)
/*     */   {
/* 430 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 433 */       this.ranks.add(rank - 1, rankInfo);
/* 434 */       long roleid = rankInfo.roleid;
/* 435 */       if (roleid > 0L)
/*     */       {
/* 437 */         this.roles.put(Long.valueOf(roleid), Integer.valueOf(rank));
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 442 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PetArenaRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */