/*     */ package mzm.gsp.npc.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.npc.SNPCNormalResult;
/*     */ import mzm.gsp.npc.confbean.SNpc;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.task.confbean.SNpc2Task;
/*     */ import xbean.BanNpcServices;
/*     */ import xtable.Bannpcservice;
/*     */ 
/*     */ public class NpcManager
/*     */ {
/*  18 */   private static final ReadWriteLock banNpcServiceLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*  20 */   private static final Set<Integer> banNpcServices = new java.util.HashSet();
/*     */   
/*     */   static void init() {
/*  23 */     new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  27 */         long localid = GameServerInfoManager.getLocalId();
/*  28 */         BanNpcServices xBanNpcServices = Bannpcservice.get(Long.valueOf(localid));
/*  29 */         if (xBanNpcServices == null) {
/*  30 */           return false;
/*     */         }
/*  32 */         NpcManager.banNpcServiceLock.writeLock().lock();
/*     */         try {
/*  34 */           NpcManager.banNpcServices.addAll(xBanNpcServices.getNpcservices());
/*     */         } finally {
/*  36 */           NpcManager.banNpcServiceLock.writeLock().unlock();
/*     */         }
/*  38 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SNpc getNpc(int npcId)
/*     */   {
/*  50 */     return SNpc.get(npcId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean containsNpc(int npcId)
/*     */   {
/*  60 */     return SNpc.getAll().containsKey(Integer.valueOf(npcId));
/*     */   }
/*     */   
/*     */   public static Set<Integer> getAllNpcId() {
/*  64 */     Set<Integer> npcids = new java.util.HashSet();
/*  65 */     for (SNpc npc : SNpc.getAll().values()) {
/*  66 */       npcids.add(Integer.valueOf(npc.id));
/*     */     }
/*  68 */     return npcids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static SNpc2Task getNpc2Task(int npcId)
/*     */   {
/*  78 */     return SNpc2Task.get(npcId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean containsNpc2Task(int npcId)
/*     */   {
/*  88 */     return SNpc2Task.getAll().containsKey(Integer.valueOf(npcId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean containsServiceId(int npcId, int serviceId)
/*     */   {
/*  99 */     SNpc npc = SNpc.get(npcId);
/* 100 */     if (npc == null) {
/* 101 */       return false;
/*     */     }
/* 103 */     return npc.npcServiceTradeList.contains(Integer.valueOf(serviceId));
/*     */   }
/*     */   
/*     */   static void sendNormalResult(long roleid, int ret, String... args) {
/* 107 */     SNPCNormalResult npcNormalResult = new SNPCNormalResult();
/* 108 */     npcNormalResult.result = ret;
/* 109 */     for (String arg : args) {
/* 110 */       npcNormalResult.args.add(arg);
/*     */     }
/* 112 */     OnlineManager.getInstance().sendAtOnce(roleid, npcNormalResult);
/*     */   }
/*     */   
/*     */   static void sendNormalResult(java.util.List<Long> roleids, int ret, String... args) {
/* 116 */     SNPCNormalResult npcNormalResult = new SNPCNormalResult();
/* 117 */     npcNormalResult.result = ret;
/* 118 */     for (String arg : args) {
/* 119 */       npcNormalResult.args.add(arg);
/*     */     }
/* 121 */     OnlineManager.getInstance().sendMultiAtOnce(npcNormalResult, roleids);
/*     */   }
/*     */   
/*     */   static boolean isBanNpcService(int npcServiceid) {
/* 125 */     banNpcServiceLock.readLock().lock();
/*     */     try {
/* 127 */       return banNpcServices.contains(Integer.valueOf(npcServiceid));
/*     */     } finally {
/* 129 */       banNpcServiceLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean banNpcService(int npcServiceid) {
/* 134 */     long localid = GameServerInfoManager.getLocalId();
/* 135 */     BanNpcServices xBanNpcServices = Bannpcservice.get(Long.valueOf(localid));
/* 136 */     if (xBanNpcServices == null) {
/* 137 */       xBanNpcServices = xbean.Pod.newBanNpcServices();
/* 138 */       Bannpcservice.insert(Long.valueOf(localid), xBanNpcServices);
/*     */     }
/* 140 */     xBanNpcServices.getNpcservices().add(Integer.valueOf(npcServiceid));
/* 141 */     banNpcServiceLock.writeLock().lock();
/*     */     try {
/* 143 */       banNpcServices.add(Integer.valueOf(npcServiceid));
/*     */     } finally {
/* 145 */       banNpcServiceLock.writeLock().unlock();
/*     */     }
/* 147 */     return true;
/*     */   }
/*     */   
/*     */   static boolean unBanNpcService(int npcServiceid) {
/* 151 */     long localid = GameServerInfoManager.getLocalId();
/* 152 */     BanNpcServices xBanNpcServices = Bannpcservice.get(Long.valueOf(localid));
/* 153 */     if (xBanNpcServices == null) {
/* 154 */       return false;
/*     */     }
/* 156 */     boolean ret = xBanNpcServices.getNpcservices().remove(Integer.valueOf(npcServiceid));
/* 157 */     if (!ret) {
/* 158 */       return false;
/*     */     }
/* 160 */     banNpcServiceLock.writeLock().lock();
/*     */     try {
/* 162 */       banNpcServices.remove(Integer.valueOf(npcServiceid));
/*     */     } finally {
/* 164 */       banNpcServiceLock.writeLock().unlock();
/*     */     }
/* 166 */     return true;
/*     */   }
/*     */   
/*     */   static Set<Integer> getBanNpcServices() {
/* 170 */     Set<Integer> allBanServices = new java.util.HashSet();
/* 171 */     banNpcServiceLock.readLock().lock();
/*     */     try {
/* 173 */       allBanServices.addAll(banNpcServices);
/* 174 */       return allBanServices;
/*     */     } finally {
/* 176 */       banNpcServiceLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\main\NpcManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */