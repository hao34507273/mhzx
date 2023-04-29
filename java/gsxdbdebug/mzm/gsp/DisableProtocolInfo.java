/*    */ package mzm.gsp;
/*    */ 
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.GameServerInfo;
/*    */ 
/*    */ class DisableProtocolInfo
/*    */ {
/* 12 */   private final ReadWriteLock disableProtocolRwLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*    */   
/* 14 */   private final Set<Integer> disableProtocols = new java.util.HashSet();
/*    */   
/*    */   public void initOnGameServerStart(Set<Integer> protids)
/*    */   {
/* 18 */     this.disableProtocolRwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 21 */       this.disableProtocols.addAll(protids);
/*    */     }
/*    */     finally
/*    */     {
/* 25 */       this.disableProtocolRwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean containsDisableProtocol(int protid)
/*    */   {
/* 31 */     this.disableProtocolRwLock.readLock().lock();
/*    */     try
/*    */     {
/* 34 */       return this.disableProtocols.contains(Integer.valueOf(protid));
/*    */     }
/*    */     finally
/*    */     {
/* 38 */       this.disableProtocolRwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean addDisableProtocol(final int protid)
/*    */   {
/* 44 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 49 */         GameServerInfo xGameServerInfo = xtable.Gamesrv.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 50 */         if (xGameServerInfo == null)
/*    */         {
/* 52 */           return false;
/*    */         }
/*    */         
/* 55 */         xGameServerInfo.getDisable_protocol_info().getProtocols().add(Integer.valueOf(protid));
/*    */         
/* 57 */         DisableProtocolInfo.this.disableProtocolRwLock.writeLock().lock();
/*    */         try
/*    */         {
/* 60 */           DisableProtocolInfo.this.disableProtocols.add(Integer.valueOf(protid));
/*    */         }
/*    */         finally
/*    */         {
/* 64 */           DisableProtocolInfo.this.disableProtocolRwLock.writeLock().unlock();
/*    */         }
/*    */         
/* 67 */         GameServer.logger().info(String.format("add disable protocol|protocolid=%d", new Object[] { Integer.valueOf(protid) }));
/*    */         
/* 69 */         return true;
/*    */       }
/*    */     }.call();
/*    */   }
/*    */   
/*    */   public boolean removeDisableProtocol(final int protid)
/*    */   {
/* 76 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 81 */         GameServerInfo xGameServerInfo = xtable.Gamesrv.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 82 */         if (xGameServerInfo == null)
/*    */         {
/* 84 */           return false;
/*    */         }
/*    */         
/* 87 */         xGameServerInfo.getDisable_protocol_info().getProtocols().remove(Integer.valueOf(protid));
/*    */         
/* 89 */         DisableProtocolInfo.this.disableProtocolRwLock.writeLock().lock();
/*    */         try
/*    */         {
/* 92 */           DisableProtocolInfo.this.disableProtocols.remove(Integer.valueOf(protid));
/*    */         }
/*    */         finally
/*    */         {
/* 96 */           DisableProtocolInfo.this.disableProtocolRwLock.writeLock().unlock();
/*    */         }
/*    */         
/* 99 */         GameServer.logger().info(String.format("remove disable protocol|protocolid=%d", new Object[] { Integer.valueOf(protid) }));
/*    */         
/* :1 */         return true;
/*    */       }
/*    */     }.call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\DisableProtocolInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */