/*     */ package mzm.gsp.online.main;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLIntegrityConstraintViolationException;
/*     */ import java.sql.SQLNonTransientConnectionException;
/*     */ import java.sql.SQLRecoverableException;
/*     */ import java.util.concurrent.BlockingQueue;
/*     */ import java.util.concurrent.LinkedBlockingDeque;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.StorageEngineType;
/*     */ import xdb.Xdb;
/*     */ import xdb.XdbConf;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OnlineInfoFlusher
/*     */   implements Runnable
/*     */ {
/*     */   private static OnlineInfoFlusher instance;
/*     */   private final String flushOnlineInfoSQL;
/*     */   private final String flushAccountNumSQL;
/*     */   private final Thread thread;
/*     */   
/*     */   static abstract interface FlushStatisInfo
/*     */   {
/*     */     public abstract PreparedStatement getStatisStatement(Connection paramConnection)
/*     */       throws SQLException;
/*     */     
/*     */     public abstract void fillStatisStatement(PreparedStatement paramPreparedStatement)
/*     */       throws SQLException;
/*     */     
/*     */     public abstract boolean isShutdownInfo();
/*     */   }
/*     */   
/*     */   public static class OnlineInfo
/*     */     implements OnlineInfoFlusher.FlushStatisInfo
/*     */   {
/*     */     public String gameAppId;
/*     */     public int onlinecntIOS;
/*     */     public int onlinecntAndroid;
/*     */     
/*     */     public OnlineInfo() {}
/*     */     
/*     */     public OnlineInfo(String gameAppId)
/*     */     {
/*  55 */       this.gameAppId = gameAppId;
/*     */       
/*  57 */       this.onlinecntAndroid = 0;
/*  58 */       this.onlinecntIOS = 0;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public boolean isShutdownInfo()
/*     */     {
/*  68 */       return false;
/*     */     }
/*     */     
/*     */     public PreparedStatement getStatisStatement(Connection connection)
/*     */       throws SQLException
/*     */     {
/*  74 */       return connection.prepareStatement(OnlineInfoFlusher.instance.getFlushOnlinInfoSQL());
/*     */     }
/*     */     
/*     */     public void fillStatisStatement(PreparedStatement pstmt)
/*     */       throws SQLException
/*     */     {
/*  80 */       int timestamp = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/*  81 */       String partition = String.valueOf(GameServerInfoManager.getZoneId());
/*  82 */       String hostname = GameServerInfoManager.getHostname();
/*  83 */       pstmt.setString(1, this.gameAppId);
/*  84 */       pstmt.setInt(2, timestamp);
/*  85 */       pstmt.setString(3, hostname);
/*  86 */       pstmt.setString(4, partition);
/*  87 */       pstmt.setInt(5, this.onlinecntIOS);
/*  88 */       pstmt.setInt(6, this.onlinecntAndroid);
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/*  94 */       return String.format("game_appid=%s|timestamp=%d|zoneid=%d|hostname=%s|online_cnt_ios=%d|online_cnt_android=%d", new Object[] { this.gameAppId, Long.valueOf(DateTimeUtils.getCurrTimeInMillis()), Integer.valueOf(GameServerInfoManager.getZoneId()), GameServerInfoManager.getHostname(), Integer.valueOf(this.onlinecntIOS), Integer.valueOf(this.onlinecntAndroid) });
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static class AccountNumInfo
/*     */     implements OnlineInfoFlusher.FlushStatisInfo
/*     */   {
/*     */     public final int accountNum;
/*     */     
/*     */     public AccountNumInfo(int accountNum)
/*     */     {
/* 106 */       this.accountNum = accountNum;
/*     */     }
/*     */     
/*     */     public PreparedStatement getStatisStatement(Connection connection)
/*     */       throws SQLException
/*     */     {
/* 112 */       return connection.prepareStatement(OnlineInfoFlusher.instance.getFlushAccountNumSQL());
/*     */     }
/*     */     
/*     */     public void fillStatisStatement(PreparedStatement pstmt)
/*     */       throws SQLException
/*     */     {
/* 118 */       int timestamp = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 119 */       String partition = String.valueOf(GameServerInfoManager.getZoneId());
/* 120 */       pstmt.setInt(1, timestamp);
/* 121 */       pstmt.setString(2, partition);
/* 122 */       pstmt.setInt(3, this.accountNum);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isShutdownInfo()
/*     */     {
/* 128 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 134 */       return String.format("timestamp=%d|zoneid=%d|account_num=%d", new Object[] { Long.valueOf(DateTimeUtils.getCurrTimeInMillis()), Integer.valueOf(GameServerInfoManager.getZoneId()), Integer.valueOf(this.accountNum) });
/*     */     }
/*     */   }
/*     */   
/*     */   static class ShutdownInfo
/*     */     implements OnlineInfoFlusher.FlushStatisInfo
/*     */   {
/*     */     public PreparedStatement getStatisStatement(Connection connection)
/*     */       throws SQLException
/*     */     {
/* 144 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public void fillStatisStatement(PreparedStatement pstmt)
/*     */       throws SQLException
/*     */     {}
/*     */     
/*     */ 
/*     */     public boolean isShutdownInfo()
/*     */     {
/* 155 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void init()
/*     */   {
/* 163 */     if (Xdb.getInstance().getConf().getStorageEngineType() != StorageEngineType.STORAGE_ENGING_TSPIDER)
/*     */     {
/* 165 */       return;
/*     */     }
/*     */     try
/*     */     {
/* 169 */       instance = new OnlineInfoFlusher();
/* 170 */       instance.start();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 174 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void exit()
/*     */   {
/* 180 */     if (instance != null)
/*     */     {
/* 182 */       instance.stop();
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
/*     */   public static final void statisOnlineInfo(OnlineInfo onlineInfo)
/*     */     throws InterruptedException
/*     */   {
/* 196 */     GameServer.logger().info(String.format("[online]OnlineInfoFlusher.statisOnlineInfo@online info|game_appid=%s|zoneid=%s|online_cnt_ios=%d|online_cnt_android=%d", new Object[] { onlineInfo.gameAppId, Integer.valueOf(GameServerInfoManager.getZoneId()), Integer.valueOf(onlineInfo.onlinecntIOS), Integer.valueOf(onlineInfo.onlinecntAndroid) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 202 */     if (instance == null)
/*     */     {
/* 204 */       return;
/*     */     }
/*     */     
/* 207 */     instance.flushStatisInfos.put(onlineInfo);
/*     */   }
/*     */   
/*     */   public static final void statisAccountNum(int accountNum) throws InterruptedException
/*     */   {
/* 212 */     long zoneid = GameServerInfoManager.getZoneId();
/*     */     
/* 214 */     GameServer.logger().info(String.format("[online]OnlineInfoFlusher.statisAccountNum@statis info|zoneid=%s|account_num=%d", new Object[] { Long.valueOf(zoneid), Integer.valueOf(accountNum) }));
/*     */     
/*     */ 
/*     */ 
/* 218 */     if (instance == null)
/*     */     {
/* 220 */       return;
/*     */     }
/*     */     
/* 223 */     instance.flushStatisInfos.put(new AccountNumInfo(accountNum));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 230 */   private final AtomicBoolean isRunning = new AtomicBoolean(true);
/* 231 */   private final BlockingQueue<FlushStatisInfo> flushStatisInfos = new LinkedBlockingDeque();
/*     */   private Connection writeConnection;
/*     */   
/*     */   private OnlineInfoFlusher()
/*     */     throws SQLException
/*     */   {
/* 237 */     this.flushOnlineInfoSQL = String.format("insert into %s values(?, ?, ?, ?, ?, ?);", new Object[] { OnlineInfoArgs.getInstance().onlineInfoTableName });
/*     */     
/* 239 */     this.flushAccountNumSQL = String.format("insert into %s values(?, ?, ?);", new Object[] { OnlineInfoArgs.getInstance().accountNumTableName });
/*     */     
/* 241 */     this.thread = new Thread(this, "online_info_flusher");
/* 242 */     this.writeConnection = getConnection();
/*     */   }
/*     */   
/*     */   String getFlushOnlinInfoSQL()
/*     */   {
/* 247 */     return this.flushOnlineInfoSQL;
/*     */   }
/*     */   
/*     */   String getFlushAccountNumSQL()
/*     */   {
/* 252 */     return this.flushAccountNumSQL;
/*     */   }
/*     */   
/*     */   private void start()
/*     */   {
/* 257 */     this.thread.setDaemon(true);
/* 258 */     this.thread.start();
/*     */   }
/*     */   
/*     */   private void stop()
/*     */   {
/* 263 */     this.isRunning.set(false);
/*     */     
/* 265 */     FlushStatisInfo flushStatisInfo = new ShutdownInfo();
/*     */     try
/*     */     {
/* 268 */       this.flushStatisInfos.add(flushStatisInfo);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 272 */       GameServer.logger().warn(OnlineInfoFlusher.class.getName() + " shutdown. ignore exception=" + e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void run()
/*     */   {
/* 279 */     while (this.isRunning.get())
/*     */     {
/*     */       try
/*     */       {
/* 283 */         FlushStatisInfo flushStatisInfo = (FlushStatisInfo)this.flushStatisInfos.take();
/* 284 */         if (flushStatisInfo.isShutdownInfo()) {
/*     */           break;
/*     */         }
/*     */         
/* 288 */         flushStatisInfo(flushStatisInfo);
/*     */       }
/*     */       catch (Throwable t)
/*     */       {
/* 292 */         GameServer.logger().error(String.format("%s.run, ignore throwable=%s", new Object[] { getClass().getName(), t }));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean flushStatisInfo(FlushStatisInfo flushStatisInfo)
/*     */   {
/* 299 */     int i = 0;
/*     */     for (;;) {
/* 301 */       Connection connection = getWriteConnection();
/*     */       try
/*     */       {
/* 304 */         PreparedStatement pstmt = flushStatisInfo.getStatisStatement(connection);
/*     */         try
/*     */         {
/* 307 */           flushStatisInfo.fillStatisStatement(pstmt);
/* 308 */           pstmt.executeUpdate();
/* 309 */           return true;
/*     */         }
/*     */         finally
/*     */         {
/* 313 */           if (pstmt != null)
/*     */           {
/* 315 */             pstmt.close();
/*     */           }
/*     */         }
/* 299 */         i++;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*     */       catch (SQLException e)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 321 */         if (isSpecialError(e))
/*     */         {
/* 323 */           renewWriteConnection();
/*     */           
/*     */           try
/*     */           {
/* 327 */             Thread.sleep(1000L);
/*     */           }
/*     */           catch (InterruptedException ie)
/*     */           {
/* 331 */             return false;
/*     */           }
/*     */           
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 338 */           if ((i > 0) && ((e instanceof SQLIntegrityConstraintViolationException)))
/*     */           {
/* 340 */             return true;
/*     */           }
/*     */           
/* 343 */           GameServer.logger().error(String.format("[online]OnlineInfoFlusher.flushStatisInfo@flush statis info error|%s", new Object[] { flushStatisInfo.toString() }), e);
/*     */           
/*     */ 
/*     */ 
/* 347 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private Connection getWriteConnection() {
/* 354 */     return this.writeConnection;
/*     */   }
/*     */   
/*     */   private Connection getConnection() throws SQLException
/*     */   {
/* 359 */     Connection conn = OnlineInfoArgs.getInstance().getConnection();
/* 360 */     if (conn != null)
/*     */     {
/* 362 */       return conn;
/*     */     }
/*     */     
/* 365 */     return Xdb.getInstance().getConf().getConnection();
/*     */   }
/*     */   
/*     */   private Connection renewWriteConnection()
/*     */   {
/* 370 */     if (this.writeConnection != null)
/*     */     {
/*     */       try
/*     */       {
/* 374 */         this.writeConnection.close();
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 378 */         GameServer.logger().error("[online]OnlineInfoFlusher.renewWriteConnection@close write connection error", e);
/*     */       }
/* 380 */       this.writeConnection = null;
/*     */     }
/*     */     
/*     */     for (;;)
/*     */     {
/*     */       try
/*     */       {
/* 387 */         Thread.sleep(3000L);
/*     */         
/* 389 */         this.writeConnection = getConnection();
/*     */ 
/*     */       }
/*     */       catch (InterruptedException e)
/*     */       {
/*     */ 
/* 395 */         GameServer.logger().error("[online]OnlineInfoFlusher.renewWriteConnection@renew write connection error", e);
/*     */ 
/*     */       }
/*     */       catch (SQLException e)
/*     */       {
/* 400 */         GameServer.logger().error("[online]OnlineInfoFlusher.renewWriteConnection@renew write connection error", e);
/*     */       }
/*     */     }
/*     */     
/* 404 */     return this.writeConnection;
/*     */   }
/*     */   
/*     */   private boolean isSpecialError(SQLException e)
/*     */   {
/* 409 */     int errorCode = e.getErrorCode();
/* 410 */     if ((errorCode == 2003) || (errorCode == 2006) || (errorCode == 2013) || (errorCode == 1105))
/*     */     {
/* 412 */       return true;
/*     */     }
/*     */     
/* 415 */     return ((e instanceof SQLNonTransientConnectionException)) || ((e instanceof SQLRecoverableException));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\OnlineInfoFlusher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */