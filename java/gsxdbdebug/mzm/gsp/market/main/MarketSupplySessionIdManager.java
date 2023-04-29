/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ class MarketSupplySessionIdManager
/*    */ {
/* 12 */   private static final MarketSupplySessionIdManager instance = new MarketSupplySessionIdManager();
/*    */   
/*    */   public static MarketSupplySessionIdManager getInstance()
/*    */   {
/* 16 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 24 */   private final Map<Integer, Long> itemOrPetCfgId2sessionId = new HashMap();
/*    */   
/* 26 */   private final ReadWriteLock locker = new ReentrantReadWriteLock();
/*    */   
/*    */   boolean isSessionStart(int itemOrPetCfgId)
/*    */   {
/*    */     try
/*    */     {
/* 32 */       this.locker.readLock().lock();
/* 33 */       return this.itemOrPetCfgId2sessionId.containsKey(Integer.valueOf(itemOrPetCfgId));
/*    */     }
/*    */     finally
/*    */     {
/* 37 */       this.locker.readLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   boolean removeSession(int itemOrPetCfgId)
/*    */   {
/*    */     try
/*    */     {
/* 45 */       this.locker.writeLock().lock();
/* 46 */       Long sessionId = (Long)this.itemOrPetCfgId2sessionId.remove(Integer.valueOf(itemOrPetCfgId));
/* 47 */       Session session; if (sessionId != null)
/*    */       {
/* 49 */         session = Session.removeSession(sessionId.longValue());
/* 50 */         return session != null;
/*    */       }
/*    */       
/*    */ 
/* 54 */       return 0;
/*    */ 
/*    */     }
/*    */     finally
/*    */     {
/* 59 */       this.locker.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   boolean addSession(int itemOrPetCfgId, long interval)
/*    */   {
/*    */     try
/*    */     {
/* 67 */       this.locker.writeLock().lock();
/* 68 */       if (this.itemOrPetCfgId2sessionId.containsKey(Integer.valueOf(itemOrPetCfgId)))
/*    */       {
/* 70 */         return false;
/*    */       }
/* 72 */       MarketSupplySession marketSupplySession = new MarketSupplySession(interval, itemOrPetCfgId);
/* 73 */       this.itemOrPetCfgId2sessionId.put(Integer.valueOf(itemOrPetCfgId), Long.valueOf(marketSupplySession.getSessionId()));
/* 74 */       return true;
/*    */     }
/*    */     finally
/*    */     {
/* 78 */       this.locker.writeLock().unlock();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\MarketSupplySessionIdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */