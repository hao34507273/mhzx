/*    */ package mzm.gsp.task.ban;
/*    */ 
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.GameServerInfo;
/*    */ 
/*    */ class BanGraphInfo
/*    */ {
/* 13 */   private final ReadWriteLock disableProtocolRwLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*    */   
/* 15 */   private final Set<Integer> disableProtocols = new java.util.HashSet();
/*    */   
/*    */   public void initOnGameServerStart(Set<Integer> protids)
/*    */   {
/* 19 */     this.disableProtocolRwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 22 */       this.disableProtocols.addAll(protids);
/*    */     }
/*    */     finally
/*    */     {
/* 26 */       this.disableProtocolRwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean containsDisableProtocol(int protid)
/*    */   {
/* 32 */     this.disableProtocolRwLock.readLock().lock();
/*    */     try
/*    */     {
/* 35 */       return this.disableProtocols.contains(Integer.valueOf(protid));
/*    */     }
/*    */     finally
/*    */     {
/* 39 */       this.disableProtocolRwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean addDisableProtocol(final int protid)
/*    */   {
/* 45 */     new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 50 */         GameServerInfo xGameServerInfo = xtable.Gamesrv.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 51 */         if (xGameServerInfo == null)
/*    */         {
/* 53 */           return false;
/*    */         }
/*    */         
/* 56 */         xGameServerInfo.getDisable_protocol_info().getProtocols().add(Integer.valueOf(protid));
/*    */         
/* 58 */         BanGraphInfo.this.disableProtocolRwLock.writeLock().lock();
/*    */         try
/*    */         {
/* 61 */           BanGraphInfo.this.disableProtocols.add(Integer.valueOf(protid));
/*    */         }
/*    */         finally
/*    */         {
/* 65 */           BanGraphInfo.this.disableProtocolRwLock.writeLock().unlock();
/*    */         }
/*    */         
/* 68 */         GameServer.logger().info(String.format("add disable protocol|protocolid=%d", new Object[] { Integer.valueOf(protid) }));
/*    */         
/* 70 */         return true;
/*    */       }
/*    */     }.call();
/*    */   }
/*    */   
/*    */   public boolean removeDisableProtocol(final int protid)
/*    */   {
/* 77 */     new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 82 */         GameServerInfo xGameServerInfo = xtable.Gamesrv.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 83 */         if (xGameServerInfo == null)
/*    */         {
/* 85 */           return false;
/*    */         }
/*    */         
/* 88 */         xGameServerInfo.getDisable_protocol_info().getProtocols().remove(Integer.valueOf(protid));
/*    */         
/* 90 */         BanGraphInfo.this.disableProtocolRwLock.writeLock().lock();
/*    */         try
/*    */         {
/* 93 */           BanGraphInfo.this.disableProtocols.remove(Integer.valueOf(protid));
/*    */         }
/*    */         finally
/*    */         {
/* 97 */           BanGraphInfo.this.disableProtocolRwLock.writeLock().unlock();
/*    */         }
/*    */         
/* :0 */         GameServer.logger().info(String.format("remove disable protocol|protocolid=%d", new Object[] { Integer.valueOf(protid) }));
/*    */         
/* :2 */         return true;
/*    */       }
/*    */     }.call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\ban\BanGraphInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */