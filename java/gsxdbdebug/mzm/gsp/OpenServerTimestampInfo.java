/*    */ package mzm.gsp;
/*    */ 
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import java.util.concurrent.locks.ReadWriteLock;
/*    */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.config.event.OpenServerTimeChanged;
/*    */ import xbean.GameServerInfo;
/*    */ 
/*    */ class OpenServerTimestampInfo
/*    */ {
/*    */   private final int openServerNeedCreateRole;
/* 13 */   private final ReadWriteLock openServerTimestampRwLock = new ReentrantReadWriteLock();
/* 14 */   private long openServerTimestamp = 0L;
/*    */   
/*    */   public OpenServerTimestampInfo()
/*    */   {
/* 18 */     int numOfValue = 1;
/* 19 */     String value = System.getProperty("com.zulong.mhzx.open_server_need_create_role_num");
/* 20 */     if (value != null)
/*    */     {
/*    */       try
/*    */       {
/* 24 */         numOfValue = Integer.parseInt(value);
/*    */       }
/*    */       catch (NumberFormatException e) {}
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 32 */     this.openServerNeedCreateRole = numOfValue;
/*    */   }
/*    */   
/*    */   public long getOpenServerTimestamp()
/*    */   {
/* 37 */     this.openServerTimestampRwLock.readLock().lock();
/*    */     try
/*    */     {
/* 40 */       return this.openServerTimestamp;
/*    */     }
/*    */     finally
/*    */     {
/* 44 */       this.openServerTimestampRwLock.readLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public void setOpenServerTimestamp(long timestamp)
/*    */   {
/* 50 */     this.openServerTimestampRwLock.writeLock().lock();
/*    */     try
/*    */     {
/* 53 */       this.openServerTimestamp = timestamp;
/*    */     }
/*    */     finally
/*    */     {
/* 57 */       this.openServerTimestampRwLock.writeLock().unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public void onRoleCreate()
/*    */   {
/* 63 */     GameServerInfo xGameServerInfo = xtable.Gamesrv.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 64 */     if (xGameServerInfo == null)
/*    */     {
/* 66 */       return;
/*    */     }
/*    */     
/* 69 */     int createRoleNum = xGameServerInfo.getCreate_role_num() + 1;
/* 70 */     xGameServerInfo.setCreate_role_num(createRoleNum);
/*    */     
/* 72 */     if (createRoleNum < this.openServerNeedCreateRole)
/*    */     {
/* 74 */       return;
/*    */     }
/*    */     
/* 77 */     long oldOpenServerTimestamp = xGameServerInfo.getOpen_server_timestamp();
/* 78 */     if (oldOpenServerTimestamp > 0L)
/*    */     {
/* 80 */       return;
/*    */     }
/*    */     
/* 83 */     long currTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 84 */     xGameServerInfo.setOpen_server_timestamp(currTime);
/*    */     
/* 86 */     setOpenServerTimestamp(currTime);
/*    */     
/* 88 */     OpenServerTimeChanged event = new OpenServerTimeChanged();
/* 89 */     TriggerEventsManger.getInstance().triggerEvent(event, Long.valueOf(currTime));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\OpenServerTimestampInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */