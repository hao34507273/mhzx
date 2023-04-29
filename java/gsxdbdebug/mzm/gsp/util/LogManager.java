/*     */ package mzm.gsp.util;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.confConverter.ConfManager;
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
/*     */ public class LogManager
/*     */ {
/*  20 */   private static LogManager instance = new LogManager();
/*     */   private int onlineLogIntervalSeconds;
/*     */   private int heartbeatLogIntervalSeconds;
/*     */   
/*  24 */   public static LogManager getInstance() { return instance; }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  31 */   private Map<String, LogCfg> name2LogCfg = new HashMap();
/*     */   
/*     */   public void init() {
/*  34 */     LogCfgArgs cfgMgr = (LogCfgArgs)ConfManager.getInstance().getconf("mzm.gsp.util.LogCfgArgs");
/*  35 */     if (cfgMgr == null) {
/*  36 */       throw new RuntimeException("日志配置文件找不到！");
/*     */     }
/*     */     
/*  39 */     this.onlineLogIntervalSeconds = cfgMgr.OnlineLogIntervalSeconds;
/*  40 */     this.heartbeatLogIntervalSeconds = cfgMgr.HeartbeatLogIntervalSeconds;
/*     */     
/*  42 */     for (LogCfg logCfg : cfgMgr.logCfgs) {
/*  43 */       if (this.name2LogCfg.containsKey(logCfg.Name)) {
/*  44 */         throw new RuntimeException("日志的配置文件中Name重复：" + logCfg.Name);
/*     */       }
/*  46 */       this.name2LogCfg.put(logCfg.Name, logCfg);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*  51 */   private static final ThreadLocal<LinkedList<Pair<Integer, String>>> localLogs = new ThreadLocal();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int logBeforeTransaction()
/*     */   {
/*  60 */     LinkedList<Pair<Integer, String>> currLogs = (LinkedList)localLogs.get();
/*  61 */     if (currLogs == null) {
/*  62 */       localLogs.set(currLogs = new LinkedList());
/*     */     }
/*  64 */     return currLogs.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean logAfterTransaction(boolean bSuccess, int savePoint, int nestCount)
/*     */   {
/*  76 */     LinkedList<Pair<Integer, String>> currLogs = (LinkedList)localLogs.get();
/*  77 */     if (currLogs != null) {
/*  78 */       if (nestCount == 0) {
/*     */         try {
/*  80 */           if (bSuccess) {
/*  81 */             for (Pair<Integer, String> pair : currLogs) {
/*  82 */               log.Logger.addLog(((Integer)pair.first).intValue(), (String)pair.second);
/*     */             }
/*     */           }
/*     */         }
/*     */         finally {
/*  87 */           localLogs.set(null);
/*  88 */           currLogs.clear();
/*     */         }
/*     */         
/*  91 */       } else if ((!bSuccess) && (savePoint >= 0)) {
/*  92 */         for (int i = currLogs.size() - 1; i >= savePoint; i--) {
/*  93 */           currLogs.remove(i);
/*     */         }
/*     */       }
/*     */     }
/*  97 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addLog(String typeStr, String logStr)
/*     */   {
/* 108 */     LinkedList<Pair<Integer, String>> currLogs = (LinkedList)localLogs.get();
/* 109 */     if (currLogs == null) {
/* 110 */       GameServer.logger().error("日志需要在LogicProcedure中输出，没有记录的日志类型：" + typeStr + "。没有记录的log：" + logStr);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     LogCfg logCfg = (LogCfg)this.name2LogCfg.get(typeStr);
/*     */     
/* 116 */     if (logCfg == null) {
/* 117 */       GameServer.logger().error("相应的日志类型没有配置：" + typeStr + "。没有记录的log：" + logStr);
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     StringBuilder sb = new StringBuilder(typeStr);
/* 122 */     sb.append("|").append(logStr);
/* 123 */     currLogs.add(new Pair(Integer.valueOf(logCfg.Type), sb.toString()));
/*     */     
/* 125 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addLog(String logType, Object... args)
/*     */   {
/* 135 */     StringBuilder sb = new StringBuilder();
/* 136 */     for (int i = 0; i < args.length; i++) {
/* 137 */       sb.append(args[i]);
/* 138 */       if (i + 1 != args.length) {
/* 139 */         sb.append("|");
/*     */       }
/*     */     }
/* 142 */     addLog(logType, sb.toString());
/*     */   }
/*     */   
/*     */   public int getOnlineLogIntervalSeconds()
/*     */   {
/* 147 */     return this.onlineLogIntervalSeconds;
/*     */   }
/*     */   
/*     */   public int getHeartbeatLogIntervalSeconds() {
/* 151 */     return this.heartbeatLogIntervalSeconds;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\LogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */