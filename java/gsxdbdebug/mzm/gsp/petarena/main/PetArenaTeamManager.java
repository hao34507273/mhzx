/*     */ package mzm.gsp.petarena.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightInterface.PetFightInfo;
/*     */ import mzm.gsp.fight.main.FightInterface.PetFightRobotInfo;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.petarena.SGetDefendPetTeamSuccess;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import mzm.gsp.util.TaskOneByOne;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PetArenaTeamManager
/*     */ {
/*  31 */   private static final PetArenaTeamManager instance = new PetArenaTeamManager();
/*  32 */   private static final TaskOneByOne tasks = new TaskOneByOne();
/*     */   
/*     */   public static PetArenaTeamManager getInstance()
/*     */   {
/*  36 */     return instance;
/*     */   }
/*     */   
/*     */   public static void addTask(LogicRunnable r)
/*     */   {
/*  41 */     tasks.add(r);
/*     */   }
/*     */   
/*     */   public static void asyncBuildAndSendTeamInfo(long roleid, List<RankInfo> rankInfos, int serial)
/*     */   {
/*  46 */     tasks.add(new PPetArenaBuildAndSendTeamInfo(roleid, rankInfos, serial));
/*     */   }
/*     */   
/*     */   private static class PPetArenaBuildAndSendTeamInfo extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final List<RankInfo> rankInfos;
/*     */     private final int serial;
/*     */     
/*     */     public PPetArenaBuildAndSendTeamInfo(long roleid, List<RankInfo> rankInfos, int serial)
/*     */     {
/*  57 */       this.roleid = roleid;
/*  58 */       this.rankInfos = rankInfos;
/*  59 */       this.serial = serial;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  65 */       Map<Integer, PetTeamInfo> petTeamInfos = new HashMap();
/*  66 */       Map<Long, Integer> roleids = new HashMap();
/*  67 */       List<Integer> robots = new ArrayList();
/*     */       
/*  69 */       for (RankInfo rankInfo : this.rankInfos)
/*     */       {
/*  71 */         long roleid = rankInfo.roleid;
/*  72 */         int rank = rankInfo.rank;
/*  73 */         if (roleid > 0L)
/*     */         {
/*  75 */           RolePetTeamInfo petTeamInfo = PetArenaTeamManager.getInstance().getPetTeamInfo(roleid);
/*  76 */           if (petTeamInfo != null)
/*     */           {
/*  78 */             petTeamInfos.put(Integer.valueOf(rank), petTeamInfo);
/*     */           }
/*     */           else
/*     */           {
/*  82 */             roleids.put(Long.valueOf(roleid), Integer.valueOf(rank));
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/*  87 */           RobotPetTeamInfo petTeamInfo = PetArenaTeamManager.getInstance().getPetTeamInfo(rank);
/*  88 */           if (petTeamInfo != null)
/*     */           {
/*  90 */             petTeamInfos.put(Integer.valueOf(rank), petTeamInfo);
/*     */           }
/*     */           else
/*     */           {
/*  94 */             robots.add(Integer.valueOf(rank));
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*  99 */       if (petTeamInfos.size() == this.rankInfos.size())
/*     */       {
/* 101 */         PetArenaManager.sendSyncOpponentInfos(this.roleid, petTeamInfos, this.serial);
/* 102 */         GameServer.logger().info(String.format("[petarena]PetArenaTeamManager.asyncBuildAndSendTeamInfo@send msg success|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */         
/*     */ 
/* 105 */         return true;
/*     */       }
/*     */       
/*     */       Iterator i$;
/* 109 */       if (!robots.isEmpty())
/*     */       {
/* 111 */         for (i$ = robots.iterator(); i$.hasNext();) { int robot = ((Integer)i$.next()).intValue();
/*     */           
/* 113 */           RobotPetTeamInfo petTeamInfo = PetArenaManager.randomRobotPetTeam(robot);
/* 114 */           if (petTeamInfo != null)
/*     */           {
/* 116 */             PetArenaTeamManager.getInstance().setPetTeamInfo(robot, petTeamInfo);
/* 117 */             petTeamInfos.put(Integer.valueOf(robot), petTeamInfo);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 122 */       if (!roleids.isEmpty())
/*     */       {
/* 124 */         lock(Lockeys.get(Basic.getTable(), roleids.keySet()));
/* 125 */         for (Map.Entry<Long, Integer> entry : roleids.entrySet())
/*     */         {
/* 127 */           long roleid = ((Long)entry.getKey()).longValue();
/* 128 */           Role role = RoleInterface.getRole(roleid, true);
/* 129 */           int avatar = AvatarInterface.getCurrentAvatar(roleid, true);
/* 130 */           int avatarFrame = AvatarFrameInterface.getCurrentAvatarFrameId(roleid, true);
/* 131 */           int score = PetInterface.getDefenseTeamScore(roleid);
/* 132 */           RolePetTeamInfo petTeamInfo = new RolePetTeamInfo(roleid, avatar, avatarFrame, role.getName(), role.getLevel(), role.getOccupationId(), role.getGender(), score);
/*     */           
/*     */ 
/* 135 */           PetArenaTeamManager.getInstance().setPetTeamInfo(roleid, petTeamInfo);
/* 136 */           petTeamInfos.put(entry.getValue(), petTeamInfo);
/*     */         }
/*     */       }
/*     */       
/* 140 */       PetArenaManager.sendSyncOpponentInfos(this.roleid, petTeamInfos, this.serial);
/* 141 */       GameServer.logger().info(String.format("[petarena]PetArenaTeamManager.asyncBuildAndSendTeamInfo@build and send msg success|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*     */ 
/*     */ 
/* 145 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   public static void asyncRemoveRobotTeamInfo(int robot)
/*     */   {
/* 151 */     tasks.add(new RRemoveRobotTeamInfo(robot));
/*     */   }
/*     */   
/*     */   private static class RRemoveRobotTeamInfo extends LogicRunnable
/*     */   {
/*     */     private final int robot;
/*     */     
/*     */     public RRemoveRobotTeamInfo(int robot)
/*     */     {
/* 160 */       this.robot = robot;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 166 */       RobotPetTeamInfo robotPetTeamInfo = PetArenaTeamManager.getInstance().remove(this.robot);
/* 167 */       if (robotPetTeamInfo == null)
/*     */       {
/* 169 */         GameServer.logger().error(String.format("[petarena]RRemoveRobotTeamInfo.processImp@logic error|robot=%d", new Object[] { Integer.valueOf(this.robot) }));
/*     */       }
/*     */       
/* 172 */       GameServer.logger().info(String.format("[petarena]RRemoveRobotTeamInfo.processImp@remove success|robot=%d", new Object[] { Integer.valueOf(this.robot) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void asyncGetDefendPetTeamInfo(long roleid, int robot)
/*     */   {
/* 179 */     tasks.add(new RGetDefendPetTeamInfo(roleid, robot));
/*     */   }
/*     */   
/*     */   private static class RGetDefendPetTeamInfo extends LogicRunnable
/*     */   {
/*     */     private final long roleid;
/*     */     private final int robot;
/*     */     
/*     */     public RGetDefendPetTeamInfo(long roleid, int robot)
/*     */     {
/* 189 */       this.roleid = roleid;
/* 190 */       this.robot = robot;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 196 */       RobotPetTeamInfo robotPetTeamInfo = PetArenaTeamManager.getInstance().getAndBuildRobotTeamInfo(this.robot);
/* 197 */       if (robotPetTeamInfo == null)
/*     */       {
/* 199 */         GameServer.logger().error(String.format("[petarena]RPutRobotTeamInfo.processImp@logic error|roleid=%d|robot=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.robot) }));
/*     */         
/*     */ 
/* 202 */         return;
/*     */       }
/*     */       
/* 205 */       PetArenaTeamManager.getInstance().setPetTeamInfo(this.robot, robotPetTeamInfo);
/* 206 */       SGetDefendPetTeamSuccess msg = new SGetDefendPetTeamSuccess();
/* 207 */       msg.rank = this.robot;
/* 208 */       robotPetTeamInfo.fillPetArenaTeamInfo(msg.team_info);
/* 209 */       OnlineManager.getInstance().send(this.roleid, msg);
/*     */       
/* 211 */       GameServer.logger().info(String.format("[petarena]RPutRobotTeamInfo.processImp@build and send msg|roleid=%d|robot=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.robot) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void asyncStartFight(long roleid, FightInterface.PetFightInfo roleFightInfo, PetCVCFightContext context, int robot)
/*     */   {
/* 220 */     tasks.add(new RStartFight(roleid, roleFightInfo, context, robot));
/*     */   }
/*     */   
/*     */   private static class RStartFight
/*     */     extends LogicRunnable
/*     */   {
/*     */     private final long roleid;
/*     */     private final FightInterface.PetFightInfo roleFightInfo;
/*     */     private final PetCVCFightContext context;
/*     */     private final int robot;
/*     */     
/*     */     public RStartFight(long roleid, FightInterface.PetFightInfo roleFightInfo, PetCVCFightContext context, int robot)
/*     */     {
/* 233 */       this.roleid = roleid;
/* 234 */       this.roleFightInfo = roleFightInfo;
/* 235 */       this.context = context;
/* 236 */       this.robot = robot;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 242 */       RobotPetTeamInfo robotPetTeamInfo = PetArenaTeamManager.getInstance().getAndBuildRobotTeamInfo(this.robot);
/* 243 */       if (robotPetTeamInfo == null)
/*     */       {
/* 245 */         GameServer.logger().error(String.format("[petarena]RStartFight.process@logic error|roleid=%d|robot=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.robot) }));
/*     */         
/* 247 */         return;
/*     */       }
/*     */       
/* 250 */       FightInterface.PetFightRobotInfo robotFightInfo = new FightInterface.PetFightRobotInfo();
/* 251 */       robotPetTeamInfo.fillPetFightRobotInfo(robotFightInfo);
/* 252 */       robotPetTeamInfo.fillPetAreanFightInfos(this.context.passiveInfos);
/* 253 */       FightInterface.startPetCVCRobotFight(this.roleFightInfo, robotFightInfo, this.context, 28, FightReason.PET_ARENA_CVC);
/*     */       
/*     */ 
/* 256 */       GameServer.logger().info(String.format("[petarena]RStartFight.process@build and send msg|roleid=%d|robot=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.robot) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/* 262 */   private final ReadWriteLock rwLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/* 263 */   private final Map<Long, RolePetTeamInfo> roles = new HashMap();
/* 264 */   private final Map<Integer, RobotPetTeamInfo> robots = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public RolePetTeamInfo getPetTeamInfo(long roleid)
/*     */   {
/* 273 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 276 */       return (RolePetTeamInfo)this.roles.get(Long.valueOf(roleid));
/*     */     }
/*     */     finally
/*     */     {
/* 280 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public RobotPetTeamInfo getPetTeamInfo(int robot)
/*     */   {
/* 286 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 289 */       return (RobotPetTeamInfo)this.robots.get(Integer.valueOf(robot));
/*     */     }
/*     */     finally
/*     */     {
/* 293 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setPetTeamInfo(long roleid, RolePetTeamInfo petTeamInfo)
/*     */   {
/* 299 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 302 */       this.roles.put(Long.valueOf(roleid), petTeamInfo);
/*     */     }
/*     */     finally
/*     */     {
/* 306 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setPetTeamInfo(int robot, RobotPetTeamInfo petTeamInfo)
/*     */   {
/* 312 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 315 */       this.robots.put(Integer.valueOf(robot), petTeamInfo);
/*     */     }
/*     */     finally
/*     */     {
/* 319 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean contains(long roleid)
/*     */   {
/* 325 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 328 */       return this.roles.containsKey(Long.valueOf(roleid));
/*     */     }
/*     */     finally
/*     */     {
/* 332 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean contains(int robot)
/*     */   {
/* 338 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 341 */       return this.robots.containsKey(Integer.valueOf(robot));
/*     */     }
/*     */     finally
/*     */     {
/* 345 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public RobotPetTeamInfo remove(int robot)
/*     */   {
/* 351 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 354 */       return (RobotPetTeamInfo)this.robots.remove(Integer.valueOf(robot));
/*     */     }
/*     */     finally
/*     */     {
/* 358 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public Map<Integer, PetTeamInfo> getPetTeamInfos(List<RankInfo> rankInfos)
/*     */   {
/* 364 */     if ((rankInfos == null) || (rankInfos.isEmpty()))
/*     */     {
/* 366 */       return java.util.Collections.emptyMap();
/*     */     }
/*     */     
/* 369 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 372 */       Map<Integer, PetTeamInfo> result = new HashMap();
/* 373 */       for (RankInfo rankInfo : rankInfos)
/*     */       {
/* 375 */         long roleid = rankInfo.roleid;
/* 376 */         int rank = rankInfo.rank;
/* 377 */         Map<Integer, PetTeamInfo> localMap1; if (roleid > 0L)
/*     */         {
/* 379 */           RolePetTeamInfo petTeamInfo = (RolePetTeamInfo)this.roles.get(Long.valueOf(roleid));
/* 380 */           if (petTeamInfo == null)
/*     */           {
/* 382 */             return null;
/*     */           }
/* 384 */           result.put(Integer.valueOf(rank), petTeamInfo);
/*     */         }
/*     */         else
/*     */         {
/* 388 */           RobotPetTeamInfo robotPetTeamInfo = (RobotPetTeamInfo)this.robots.get(Integer.valueOf(rank));
/* 389 */           if (robotPetTeamInfo == null)
/*     */           {
/* 391 */             return null;
/*     */           }
/* 393 */           result.put(Integer.valueOf(rank), robotPetTeamInfo);
/*     */         }
/*     */       }
/* 396 */       return result;
/*     */     }
/*     */     finally
/*     */     {
/* 400 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean updateAvatar(long roleid, int avatar)
/*     */   {
/* 406 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 409 */       RolePetTeamInfo petTeamInfo = (RolePetTeamInfo)this.roles.remove(Long.valueOf(roleid));
/* 410 */       if (petTeamInfo == null)
/*     */       {
/* 412 */         return false;
/*     */       }
/* 414 */       RolePetTeamInfo newPetTeamInfo = new RolePetTeamInfo(petTeamInfo.roleid, avatar, petTeamInfo.avatarFrame, petTeamInfo.name, petTeamInfo.level, petTeamInfo.occupation, petTeamInfo.gender, petTeamInfo.score);
/*     */       
/*     */ 
/*     */ 
/* 418 */       this.roles.put(Long.valueOf(roleid), newPetTeamInfo);
/* 419 */       return true;
/*     */     }
/*     */     finally
/*     */     {
/* 423 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean updateAvatarFrame(long roleid, int avatarFrame)
/*     */   {
/* 429 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 432 */       RolePetTeamInfo petTeamInfo = (RolePetTeamInfo)this.roles.remove(Long.valueOf(roleid));
/* 433 */       if (petTeamInfo == null)
/*     */       {
/* 435 */         return false;
/*     */       }
/* 437 */       RolePetTeamInfo newPetTeamInfo = new RolePetTeamInfo(petTeamInfo.roleid, petTeamInfo.avatar, avatarFrame, petTeamInfo.name, petTeamInfo.level, petTeamInfo.occupation, petTeamInfo.gender, petTeamInfo.score);
/*     */       
/*     */ 
/*     */ 
/* 441 */       this.roles.put(Long.valueOf(roleid), newPetTeamInfo);
/* 442 */       return true;
/*     */     }
/*     */     finally
/*     */     {
/* 446 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean updateLevel(long roleid, int level)
/*     */   {
/* 452 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 455 */       RolePetTeamInfo petTeamInfo = (RolePetTeamInfo)this.roles.remove(Long.valueOf(roleid));
/* 456 */       if (petTeamInfo == null)
/*     */       {
/* 458 */         return false;
/*     */       }
/* 460 */       RolePetTeamInfo newPetTeamInfo = new RolePetTeamInfo(petTeamInfo.roleid, petTeamInfo.avatar, petTeamInfo.avatarFrame, petTeamInfo.name, level, petTeamInfo.occupation, petTeamInfo.gender, petTeamInfo.score);
/*     */       
/*     */ 
/*     */ 
/* 464 */       this.roles.put(Long.valueOf(roleid), newPetTeamInfo);
/* 465 */       return true;
/*     */     }
/*     */     finally
/*     */     {
/* 469 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean updateName(long roleid, String name)
/*     */   {
/* 475 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 478 */       RolePetTeamInfo petTeamInfo = (RolePetTeamInfo)this.roles.remove(Long.valueOf(roleid));
/* 479 */       if (petTeamInfo == null)
/*     */       {
/* 481 */         return false;
/*     */       }
/* 483 */       RolePetTeamInfo newPetTeamInfo = new RolePetTeamInfo(petTeamInfo.roleid, petTeamInfo.avatar, petTeamInfo.avatarFrame, name, petTeamInfo.level, petTeamInfo.occupation, petTeamInfo.gender, petTeamInfo.score);
/*     */       
/*     */ 
/*     */ 
/* 487 */       this.roles.put(Long.valueOf(roleid), newPetTeamInfo);
/* 488 */       return true;
/*     */     }
/*     */     finally
/*     */     {
/* 492 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean updateScore(long roleid, int score)
/*     */   {
/* 498 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 501 */       RolePetTeamInfo petTeamInfo = (RolePetTeamInfo)this.roles.remove(Long.valueOf(roleid));
/* 502 */       if (petTeamInfo == null)
/*     */       {
/* 504 */         return false;
/*     */       }
/* 506 */       RolePetTeamInfo newPetTeamInfo = new RolePetTeamInfo(petTeamInfo.roleid, petTeamInfo.avatar, petTeamInfo.avatarFrame, petTeamInfo.name, petTeamInfo.level, petTeamInfo.occupation, petTeamInfo.gender, score);
/*     */       
/*     */ 
/*     */ 
/* 510 */       this.roles.put(Long.valueOf(roleid), newPetTeamInfo);
/* 511 */       return true;
/*     */     }
/*     */     finally
/*     */     {
/* 515 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean updateAllRobotTeamInfo()
/*     */   {
/* 521 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 524 */       List<Integer> ranks = new ArrayList(this.robots.keySet());
/* 525 */       for (Iterator i$ = ranks.iterator(); i$.hasNext();) { int rank = ((Integer)i$.next()).intValue();
/*     */         
/* 527 */         RobotPetTeamInfo robotPetTeamInfo = PetArenaManager.randomRobotPetTeam(rank);
/* 528 */         if (robotPetTeamInfo != null)
/*     */         {
/* 530 */           this.robots.put(Integer.valueOf(rank), robotPetTeamInfo);
/*     */         }
/*     */       }
/* 533 */       return 1;
/*     */     }
/*     */     finally
/*     */     {
/* 537 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public RobotPetTeamInfo getAndBuildRobotTeamInfo(int robot)
/*     */   {
/* 543 */     RobotPetTeamInfo robotPetTeamInfo = null;
/* 544 */     this.rwLock.readLock().lock();
/*     */     RobotPetTeamInfo localRobotPetTeamInfo1;
/*     */     try {
/* 547 */       robotPetTeamInfo = (RobotPetTeamInfo)this.robots.get(Integer.valueOf(robot));
/* 548 */       if (robotPetTeamInfo != null)
/*     */       {
/* 550 */         return robotPetTeamInfo;
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 555 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */     
/* 558 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 561 */       robotPetTeamInfo = (RobotPetTeamInfo)this.robots.get(Integer.valueOf(robot));
/* 562 */       if (robotPetTeamInfo != null)
/*     */       {
/* 564 */         return robotPetTeamInfo;
/*     */       }
/* 566 */       robotPetTeamInfo = PetArenaManager.randomRobotPetTeam(robot);
/* 567 */       if (robotPetTeamInfo == null)
/*     */       {
/* 569 */         return null;
/*     */       }
/* 571 */       this.robots.put(Integer.valueOf(robot), robotPetTeamInfo);
/* 572 */       return robotPetTeamInfo;
/*     */     }
/*     */     finally
/*     */     {
/* 576 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PetArenaTeamManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */