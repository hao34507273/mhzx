/*     */ package mzm.gsp;
/*     */ 
/*     */ import gnet.link.Link;
/*     */ import gnet.link.LinkServerControl;
/*     */ import gnet.link.Onlines;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.management.ManagementFactory;
/*     */ import java.net.BindException;
/*     */ import java.rmi.registry.LocateRegistry;
/*     */ import java.rmi.server.ExportException;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.TreeSet;
/*     */ import java.util.concurrent.locks.Condition;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import javax.management.MBeanServer;
/*     */ import javax.management.remote.JMXConnectorServer;
/*     */ import javax.management.remote.JMXConnectorServerFactory;
/*     */ import javax.management.remote.JMXServiceURL;
/*     */ import mzm.event.ModuleService;
/*     */ import mzm.event.mbeans.ModuleStopperMXBean;
/*     */ import mzm.gsp.confConverter.ConfManager;
/*     */ import mzm.gsp.online.SServerShutDownBrd;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.online.main.PPlayerPreLogout;
/*     */ import mzm.gsp.tlog.TLogInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.apache.log4j.xml.DOMConfigurator;
/*     */ import xdb.Xdb;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GameServer
/*     */ {
/*     */   public static final int GAMEID = 205;
/*     */   public static final int SELECTOR_NUMBER = 16;
/*  54 */   private static Logger logger = null;
/*     */   
/*  56 */   private static Logger surveillanceLogger = null;
/*     */   
/*  58 */   private static boolean isTiyan = false;
/*     */   
/*  60 */   private static int zoneid = -1;
/*     */   
/*  62 */   private static JMXConnectorServer cs = null;
/*     */   
/*     */   private static String xdbXmlFile;
/*     */   
/*  66 */   private static File gamedataDir = null;
/*     */   
/*  68 */   private static final transient ReentrantLock stateLock = new ReentrantLock();
/*     */   
/*     */   public static boolean isTiyan() {
/*  71 */     return isTiyan;
/*     */   }
/*     */   
/*     */   public static Logger logger() {
/*  75 */     if (logger == null)
/*  76 */       initLogger();
/*  77 */     return logger;
/*     */   }
/*     */   
/*     */   public static Logger surveillanceLogger() {
/*  81 */     if (surveillanceLogger == null)
/*  82 */       initLogger();
/*  83 */     return surveillanceLogger;
/*     */   }
/*     */   
/*     */   public static void setZoneid(int paramInt) {
/*  87 */     zoneid = paramInt;
/*     */   }
/*     */   
/*     */   public static int getZoneid() {
/*  91 */     return zoneid;
/*     */   }
/*     */   
/*     */   public static String getGamedataDir() {
/*  95 */     return gamedataDir == null ? null : gamedataDir.getAbsolutePath();
/*     */   }
/*     */   
/*     */   static void initLogger() {
/*  99 */     System.out.println("configuring log4j with log4j.xml");
/* 100 */     DOMConfigurator.configure("log4j.xml");
/* 101 */     logger = Logger.getLogger("root");
/* 102 */     surveillanceLogger = Logger.getLogger("surveillance");
/*     */   }
/*     */   
/*     */   static void initLogger(Logger paramLogger) {
/* 106 */     paramLogger = paramLogger;
/*     */   }
/*     */   
/*     */   static void initTlog() {
/* 110 */     String str1 = System.getProperty("com.zulong.mhzx.tlogserver");
/* 111 */     String str2 = System.getProperty("com.zulong.mhzx.tlogport");
/* 112 */     if ((str1 != null) && (str2 != null))
/* 113 */       TLogInterface.initTlogServerIPAndPort(str1, Integer.parseInt(str2));
/* 114 */     logger.info(String.format("tlogserver = %s  tlogport=%d", new Object[] { TLogInterface.getTlogServerIP(), Integer.valueOf(TLogInterface.getTlogServerPort()) }));
/*     */   }
/*     */   
/*     */   private static int initJMX() throws Exception {
/* 118 */     String str1 = System.getProperty("com.zulong.mhzx.jmxport1");
/* 119 */     String str2 = System.getProperty("com.zulong.mhzx.jmxport2");
/* 120 */     if ((str1 != null) && (str2 != null)) {
/* 121 */       int i = Integer.valueOf(str1).intValue();
/* 122 */       int j = Integer.valueOf(str2).intValue();
/* 123 */       System.setProperty("java.rmi.server.randomIDs", "true");
/*     */       try {
/* 125 */         LocateRegistry.createRegistry(j);
/*     */       } catch (ExportException localExportException) {
/* 127 */         logger.error("err", localExportException);
/* 128 */         return -1;
/*     */       }
/* 130 */       MBeanServer localMBeanServer = ManagementFactory.getPlatformMBeanServer();
/* 131 */       HashMap localHashMap = new HashMap();
/* 132 */       localHashMap.put("jmx.remote.x.password.file", "jmxremote.password");
/* 133 */       JMXServiceURL localJMXServiceURL = new JMXServiceURL("service:jmx:rmi://127.0.0.1:" + i + "/jndi/rmi://127.0.0.1:" + j + "/jmxrmi");
/* 134 */       cs = JMXConnectorServerFactory.newJMXConnectorServer(localJMXServiceURL, localHashMap, localMBeanServer);
/*     */       try {
/* 136 */         cs.start();
/* 137 */         return 0;
/*     */       } catch (BindException localBindException) {
/* 139 */         logger.error("端口已被占用", localBindException);
/* 140 */         return -2;
/*     */       }
/*     */     }
/* 143 */     logger.error("jmx端口未通过系统属性设置");
/* 144 */     return -1;
/*     */   }
/*     */   
/*     */   static boolean initGameData(String paramString) throws Exception {
/* 148 */     if (paramString == null)
/* 149 */       return false;
/* 150 */     gamedataDir = new File(paramString);
/* 151 */     if ((gamedataDir.isDirectory()) && (gamedataDir.exists())) {
/* 152 */       String str1 = gamedataDir.getAbsolutePath() + "/xml";
/* 153 */       logger.info("begin loading xstream xml data, path=" + str1);
/*     */       try {
/* 155 */         ConfManager.getInstance(gamedataDir.getAbsolutePath() + "/xml");
/*     */       } catch (Exception localException) {
/* 157 */         logger.error("conf file load error...", localException);
/* 158 */         return false;
/*     */       }
/* 160 */       logger.info("finish loading xstream xml data, path=" + str1);
/* 161 */       String str2 = getGamedataDir() + "/cfg/auto";
/* 162 */       logger.info("loading all auto xml, path=" + str2);
/* 163 */       CfgManager.getInstance().init(str2);
/* 164 */       CfgManager.getInstance().loadAll(false);
/* 165 */       return true;
/*     */     }
/* 167 */     logger.error(paramString + "不是有效的目录");
/* 168 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean isDebugMode() {
/* 172 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean isRunning()
/*     */   {
/* 177 */     stateLock.lock();
/*     */     boolean bool;
/* 179 */     try { bool = state == State.RUNNING;
/*     */     } finally {
/* 181 */       stateLock.unlock();
/*     */     }
/* 183 */     return bool;
/*     */   }
/*     */   
/*     */   public static boolean isShutdown()
/*     */   {
/* 188 */     stateLock.lock();
/*     */     boolean bool;
/* 190 */     try { bool = state == State.SHUTDOWN;
/*     */     } finally {
/* 192 */       stateLock.unlock();
/*     */     }
/* 194 */     return bool;
/*     */   }
/*     */   
/*     */   private static void doCleanup() {
/*     */     try {
/*     */       
/*     */     } catch (Exception localException1) {
/* 201 */       logger.error("err", localException1);
/*     */     }
/* 203 */     logger.info("正在关闭xdb...");
/*     */     try {
/* 205 */       Xdb.getInstance().stop();
/*     */     } catch (Exception localException2) {
/* 207 */       logger.error("err", localException2);
/*     */     }
/*     */     try {
/* 210 */       if (cs != null)
/* 211 */         cs.stop();
/*     */     } catch (Exception localException3) {
/* 213 */       logger.error("err", localException3);
/*     */     }
/* 215 */     logger.info("gs成功关闭");
/*     */   }
/*     */   
/*     */   private static void kickAllRoles() throws Exception {
/* 219 */     LinkServerControl localLinkServerControl = new LinkServerControl();
/* 220 */     localLinkServerControl.ptype = 1;
/* 221 */     Link[] arrayOfLink = Onlines.getInstance().links();
/* 222 */     int i = arrayOfLink.length;
/* 223 */     Object localObject; for (int j = 0; j < i; j = (byte)(j + 1)) {
/* 224 */       localObject = arrayOfLink[j];
/* 225 */       localLinkServerControl.send(((Link)localObject).getXio());
/*     */     }
/* 227 */     LinkedList localLinkedList = OnlineManager.getInstance().getAllRolesInWorld();
/* 228 */     if (localLinkedList.size() > 0) {
/* 229 */       logger.info("正在强制用户下线，10秒后服务器完成关闭");
/* 230 */       localObject = localLinkedList.iterator();
/* 231 */       long l; while (((Iterator)localObject).hasNext()) {
/* 232 */         l = ((Long)((Iterator)localObject).next()).longValue();
/* 233 */         Onlines.getInstance().kick(Long.valueOf(l), 2053);
/*     */       }
/* 235 */       Thread.sleep(3000L);
/* 236 */       localObject = localLinkedList.iterator();
/* 237 */       while (((Iterator)localObject).hasNext()) {
/* 238 */         l = ((Long)((Iterator)localObject).next()).longValue();
/* 239 */         PPlayerPreLogout localPPlayerPreLogout = new PPlayerPreLogout(l, 5);
/* 240 */         if (localPPlayerPreLogout.call()) {}
/*     */       }
/* 242 */       Thread.sleep(10000L);
/*     */     }
/*     */   }
/*     */   
/*     */   private static long getStopTime()
/*     */   {
/* 248 */     shutdownAlarmLock.lock();
/*     */     long l;
/* 250 */     try { l = m_nStopTime;
/*     */     } finally {
/* 252 */       shutdownAlarmLock.unlock();
/*     */     }
/* 254 */     return l;
/*     */   }
/*     */   
/*     */   public static void stop(int paramInt) {
/* 258 */     if (paramInt >= 0) {
/* 259 */       shutdownAlarmLock.lock();
/*     */       try {
/* 261 */         m_nStopTime = Calendar.getInstance().getTimeInMillis() + paramInt * 1000;
/* 262 */         if (shutdownBroadCastThread != null)
/* 263 */           shutdownBroadCastThread.interrupt();
/* 264 */         if (paramInt > 0)
/*     */           try {
/* 266 */             shutdownBroadCastThread = new Thread(new AlarmShutdown());
/*     */           }
/*     */           catch (Exception localException) {
/* 269 */             shutdownBroadCastThread = null;
/*     */           }
/* 271 */         shutdownAlarm.signalAll();
/*     */       } finally {
/* 273 */         shutdownAlarmLock.unlock();
/*     */       }
/* 275 */       stateLock.lock();
/*     */       try {
/* 277 */         state = State.SHUTDOWN;
/* 278 */         mzm.gsp.online.main.OnlineUsers.conti = false;
/*     */       } finally {
/* 280 */         stateLock.unlock();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void cancelShutdown() {
/* 286 */     shutdownAlarmLock.lock();
/*     */     try {
/* 288 */       m_nStopTime = -1L;
/* 289 */       if (shutdownBroadCastThread != null)
/* 290 */         shutdownBroadCastThread.interrupt();
/* 291 */       shutdownAlarm.signalAll();
/*     */     } finally {
/* 293 */       shutdownAlarmLock.unlock();
/*     */     }
/* 295 */     stateLock.lock();
/*     */     try {
/* 297 */       if (state == State.SHUTDOWN)
/* 298 */         state = State.RUNNING;
/*     */     } finally {
/* 300 */       stateLock.unlock();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 398 */   private static State state = State.STARTUP;
/*     */   
/* 400 */   private static final transient ReentrantLock shutdownAlarmLock = new ReentrantLock();
/*     */   
/* 402 */   private static final transient Condition shutdownAlarm = shutdownAlarmLock.newCondition();
/*     */   
/* 404 */   private static long m_nStopTime = -1L;
/*     */   
/* 406 */   private static Thread shutdownBroadCastThread = null;
/*     */   
/*     */   /* Error */
/*     */   public static void main(String[] paramArrayOfString)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: arraylength
/*     */     //   2: iconst_4
/*     */     //   3: if_icmpeq +14 -> 17
/*     */     //   6: getstatic 135	java/lang/System:err	Ljava/io/PrintStream;
/*     */     //   9: ldc -120
/*     */     //   11: invokevirtual 12	java/io/PrintStream:println	(Ljava/lang/String;)V
/*     */     //   14: goto +560 -> 574
/*     */     //   17: invokestatic 137	jsonio/JsonStream:enableOptionalKey	()V
/*     */     //   20: aload_0
/*     */     //   21: iconst_3
/*     */     //   22: aaload
/*     */     //   23: invokestatic 32	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
/*     */     //   26: invokevirtual 33	java/lang/Integer:intValue	()I
/*     */     //   29: putstatic 7	mzm/gsp/GameServer:zoneid	I
/*     */     //   32: invokestatic 5	mzm/gsp/GameServer:initLogger	()V
/*     */     //   35: ldc -118
/*     */     //   37: invokestatic 19	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   40: ifnull +15 -> 55
/*     */     //   43: getstatic 4	mzm/gsp/GameServer:logger	Lorg/apache/log4j/Logger;
/*     */     //   46: ldc -117
/*     */     //   48: invokevirtual 29	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   51: iconst_1
/*     */     //   52: putstatic 3	mzm/gsp/GameServer:isTiyan	Z
/*     */     //   55: getstatic 4	mzm/gsp/GameServer:logger	Lorg/apache/log4j/Logger;
/*     */     //   58: new 48	java/lang/StringBuilder
/*     */     //   61: dup
/*     */     //   62: invokespecial 49	java/lang/StringBuilder:<init>	()V
/*     */     //   65: ldc -116
/*     */     //   67: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   70: getstatic 3	mzm/gsp/GameServer:isTiyan	Z
/*     */     //   73: invokevirtual 141	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
/*     */     //   76: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   79: invokevirtual 29	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   82: ldc -114
/*     */     //   84: invokestatic 19	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   87: astore_1
/*     */     //   88: aload_1
/*     */     //   89: ifnull +19 -> 108
/*     */     //   92: aload_1
/*     */     //   93: invokestatic 21	java/lang/Integer:parseInt	(Ljava/lang/String;)I
/*     */     //   96: iconst_1
/*     */     //   97: if_icmpne +7 -> 104
/*     */     //   100: iconst_1
/*     */     //   101: goto +4 -> 105
/*     */     //   104: iconst_0
/*     */     //   105: invokestatic 143	mzm/gsp/csprovider/main/CSProviderInterface:setRequireActivateUser	(Z)V
/*     */     //   108: getstatic 4	mzm/gsp/GameServer:logger	Lorg/apache/log4j/Logger;
/*     */     //   111: ldc -112
/*     */     //   113: iconst_1
/*     */     //   114: anewarray 24	java/lang/Object
/*     */     //   117: dup
/*     */     //   118: iconst_0
/*     */     //   119: invokestatic 145	mzm/gsp/csprovider/main/CSProviderInterface:getRequireActivateUser	()Z
/*     */     //   122: invokestatic 146	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
/*     */     //   125: aastore
/*     */     //   126: invokestatic 28	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   129: invokevirtual 29	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   132: invokestatic 147	mzm/gsp/GameServer:initTlog	()V
/*     */     //   135: aload_0
/*     */     //   136: iconst_1
/*     */     //   137: aaload
/*     */     //   138: invokestatic 148	mzm/gsp/GameServer:initGameData	(Ljava/lang/String;)Z
/*     */     //   141: ifne +7 -> 148
/*     */     //   144: invokestatic 149	mzm/gsp/GameServer:doCleanup	()V
/*     */     //   147: return
/*     */     //   148: invokestatic 150	mzm/gsp/util/LogManager:getInstance	()Lmzm/gsp/util/LogManager;
/*     */     //   151: invokevirtual 151	mzm/gsp/util/LogManager:init	()V
/*     */     //   154: invokestatic 152	mzm/gsp/GameServer:initJMX	()I
/*     */     //   157: ifge +11 -> 168
/*     */     //   160: getstatic 4	mzm/gsp/GameServer:logger	Lorg/apache/log4j/Logger;
/*     */     //   163: ldc -103
/*     */     //   165: invokevirtual 63	org/apache/log4j/Logger:error	(Ljava/lang/Object;)V
/*     */     //   168: aload_0
/*     */     //   169: iconst_2
/*     */     //   170: aaload
/*     */     //   171: putstatic 154	mzm/gsp/GameServer:xdbXmlFile	Ljava/lang/String;
/*     */     //   174: getstatic 4	mzm/gsp/GameServer:logger	Lorg/apache/log4j/Logger;
/*     */     //   177: ldc -101
/*     */     //   179: invokevirtual 29	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   182: getstatic 135	java/lang/System:err	Ljava/io/PrintStream;
/*     */     //   185: ldc -100
/*     */     //   187: invokevirtual 12	java/io/PrintStream:println	(Ljava/lang/String;)V
/*     */     //   190: invokestatic 157	mzm/gsp/effect/main/FighterAction:fightStartAction	()V
/*     */     //   193: invokestatic 89	xdb/Xdb:getInstance	()Lxdb/Xdb;
/*     */     //   196: new 158	xdb/XdbConf
/*     */     //   199: dup
/*     */     //   200: getstatic 154	mzm/gsp/GameServer:xdbXmlFile	Ljava/lang/String;
/*     */     //   203: invokespecial 159	xdb/XdbConf:<init>	(Ljava/lang/String;)V
/*     */     //   206: invokevirtual 160	xdb/Xdb:setConf	(Lxdb/XdbConf;)V
/*     */     //   209: aload_0
/*     */     //   210: iconst_0
/*     */     //   211: aaload
/*     */     //   212: invokestatic 161	gnet/link/Onlines:loadConf	(Ljava/lang/String;)V
/*     */     //   215: goto +17 -> 232
/*     */     //   218: astore_2
/*     */     //   219: getstatic 4	mzm/gsp/GameServer:logger	Lorg/apache/log4j/Logger;
/*     */     //   222: ldc -93
/*     */     //   224: aload_2
/*     */     //   225: invokevirtual 40	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   228: invokestatic 149	mzm/gsp/GameServer:doCleanup	()V
/*     */     //   231: return
/*     */     //   232: invokestatic 89	xdb/Xdb:getInstance	()Lxdb/Xdb;
/*     */     //   235: invokevirtual 164	xdb/Xdb:start	()Z
/*     */     //   238: pop
/*     */     //   239: invokestatic 96	gnet/link/Onlines:getInstance	()Lgnet/link/Onlines;
/*     */     //   242: invokestatic 165	xdb/Procedure:setOlines	(Lxdb/Procedure$IOnlines;)V
/*     */     //   245: ldc -90
/*     */     //   247: invokestatic 19	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   250: ifnull +12 -> 262
/*     */     //   253: ldc -89
/*     */     //   255: invokestatic 168	mzm/gsp/PPBTransform:prepareTransform	(Ljava/lang/String;)V
/*     */     //   258: invokestatic 149	mzm/gsp/GameServer:doCleanup	()V
/*     */     //   261: return
/*     */     //   262: invokestatic 169	mzm/gsp/GameServerInfoManager:onGameServerStart	()V
/*     */     //   265: getstatic 4	mzm/gsp/GameServer:logger	Lorg/apache/log4j/Logger;
/*     */     //   268: ldc -86
/*     */     //   270: invokevirtual 29	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   273: new 48	java/lang/StringBuilder
/*     */     //   276: dup
/*     */     //   277: invokespecial 49	java/lang/StringBuilder:<init>	()V
/*     */     //   280: getstatic 8	mzm/gsp/GameServer:gamedataDir	Ljava/io/File;
/*     */     //   283: invokevirtual 9	java/io/File:getAbsolutePath	()Ljava/lang/String;
/*     */     //   286: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   289: ldc -85
/*     */     //   291: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   294: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   297: astore_2
/*     */     //   298: aload_2
/*     */     //   299: invokestatic 172	mzm/event/ModuleService:init	(Ljava/lang/String;)V
/*     */     //   302: aload_2
/*     */     //   303: invokestatic 173	mzm/event/EventInitialiser:init	(Ljava/lang/String;)V
/*     */     //   306: getstatic 81	mzm/gsp/GameServer:stateLock	Ljava/util/concurrent/locks/ReentrantLock;
/*     */     //   309: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:lock	()V
/*     */     //   312: getstatic 84	mzm/gsp/GameServer$State:RUNNING	Lmzm/gsp/GameServer$State;
/*     */     //   315: putstatic 83	mzm/gsp/GameServer:state	Lmzm/gsp/GameServer$State;
/*     */     //   318: getstatic 81	mzm/gsp/GameServer:stateLock	Ljava/util/concurrent/locks/ReentrantLock;
/*     */     //   321: invokevirtual 85	java/util/concurrent/locks/ReentrantLock:unlock	()V
/*     */     //   324: invokestatic 89	xdb/Xdb:getInstance	()Lxdb/Xdb;
/*     */     //   327: bipush 16
/*     */     //   329: invokevirtual 174	xdb/Xdb:startNetwork	(I)V
/*     */     //   332: getstatic 4	mzm/gsp/GameServer:logger	Lorg/apache/log4j/Logger;
/*     */     //   335: ldc -81
/*     */     //   337: invokevirtual 29	org/apache/log4j/Logger:info	(Ljava/lang/Object;)V
/*     */     //   340: goto +17 -> 357
/*     */     //   343: astore_2
/*     */     //   344: getstatic 4	mzm/gsp/GameServer:logger	Lorg/apache/log4j/Logger;
/*     */     //   347: ldc -80
/*     */     //   349: aload_2
/*     */     //   350: invokevirtual 40	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   353: invokestatic 149	mzm/gsp/GameServer:doCleanup	()V
/*     */     //   356: return
/*     */     //   357: invokestatic 177	mzm/event/mbeans/MBeanManager:getInstance	()Lmzm/event/mbeans/MBeanManager;
/*     */     //   360: ldc_w 178
/*     */     //   363: invokevirtual 179	java/lang/Class:getName	()Ljava/lang/String;
/*     */     //   366: invokevirtual 180	mzm/event/mbeans/MBeanManager:getObjectByName	(Ljava/lang/String;)Ljava/lang/Object;
/*     */     //   369: astore_2
/*     */     //   370: aload_2
/*     */     //   371: ifnull +26 -> 397
/*     */     //   374: aload_2
/*     */     //   375: instanceof 178
/*     */     //   378: ifeq +19 -> 397
/*     */     //   381: aload_2
/*     */     //   382: checkcast 178	mzm/event/mbeans/ModuleStopper
/*     */     //   385: astore_3
/*     */     //   386: aload_3
/*     */     //   387: new 181	mzm/gsp/GameServer$Stopper
/*     */     //   390: dup
/*     */     //   391: invokespecial 182	mzm/gsp/GameServer$Stopper:<init>	()V
/*     */     //   394: invokevirtual 183	mzm/event/mbeans/ModuleStopper:setImplementation	(Lmzm/event/mbeans/ModuleStopperMXBean;)V
/*     */     //   397: new 184	mzm/gsp/online/main/OnlineThread
/*     */     //   400: dup
/*     */     //   401: invokespecial 185	mzm/gsp/online/main/OnlineThread:<init>	()V
/*     */     //   404: invokevirtual 186	mzm/gsp/online/main/OnlineThread:start	()V
/*     */     //   407: getstatic 119	mzm/gsp/GameServer:shutdownAlarmLock	Ljava/util/concurrent/locks/ReentrantLock;
/*     */     //   410: invokevirtual 187	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
/*     */     //   413: getstatic 120	mzm/gsp/GameServer:m_nStopTime	J
/*     */     //   416: lconst_0
/*     */     //   417: lcmp
/*     */     //   418: ifge +14 -> 432
/*     */     //   421: getstatic 130	mzm/gsp/GameServer:shutdownAlarm	Ljava/util/concurrent/locks/Condition;
/*     */     //   424: invokeinterface 188 1 0
/*     */     //   429: goto +58 -> 487
/*     */     //   432: invokestatic 121	java/util/Calendar:getInstance	()Ljava/util/Calendar;
/*     */     //   435: invokevirtual 122	java/util/Calendar:getTimeInMillis	()J
/*     */     //   438: lstore_3
/*     */     //   439: lload_3
/*     */     //   440: getstatic 120	mzm/gsp/GameServer:m_nStopTime	J
/*     */     //   443: lcmp
/*     */     //   444: iflt +24 -> 468
/*     */     //   447: getstatic 119	mzm/gsp/GameServer:shutdownAlarmLock	Ljava/util/concurrent/locks/ReentrantLock;
/*     */     //   450: invokevirtual 85	java/util/concurrent/locks/ReentrantLock:unlock	()V
/*     */     //   453: getstatic 119	mzm/gsp/GameServer:shutdownAlarmLock	Ljava/util/concurrent/locks/ReentrantLock;
/*     */     //   456: invokevirtual 85	java/util/concurrent/locks/ReentrantLock:unlock	()V
/*     */     //   459: getstatic 119	mzm/gsp/GameServer:shutdownAlarmLock	Ljava/util/concurrent/locks/ReentrantLock;
/*     */     //   462: invokevirtual 85	java/util/concurrent/locks/ReentrantLock:unlock	()V
/*     */     //   465: goto +55 -> 520
/*     */     //   468: getstatic 130	mzm/gsp/GameServer:shutdownAlarm	Ljava/util/concurrent/locks/Condition;
/*     */     //   471: new 189	java/util/Date
/*     */     //   474: dup
/*     */     //   475: getstatic 120	mzm/gsp/GameServer:m_nStopTime	J
/*     */     //   478: invokespecial 190	java/util/Date:<init>	(J)V
/*     */     //   481: invokeinterface 191 2 0
/*     */     //   486: pop
/*     */     //   487: getstatic 119	mzm/gsp/GameServer:shutdownAlarmLock	Ljava/util/concurrent/locks/ReentrantLock;
/*     */     //   490: invokevirtual 85	java/util/concurrent/locks/ReentrantLock:unlock	()V
/*     */     //   493: goto +24 -> 517
/*     */     //   496: astore_3
/*     */     //   497: getstatic 119	mzm/gsp/GameServer:shutdownAlarmLock	Ljava/util/concurrent/locks/ReentrantLock;
/*     */     //   500: invokevirtual 85	java/util/concurrent/locks/ReentrantLock:unlock	()V
/*     */     //   503: goto +17 -> 520
/*     */     //   506: astore 5
/*     */     //   508: getstatic 119	mzm/gsp/GameServer:shutdownAlarmLock	Ljava/util/concurrent/locks/ReentrantLock;
/*     */     //   511: invokevirtual 85	java/util/concurrent/locks/ReentrantLock:unlock	()V
/*     */     //   514: aload 5
/*     */     //   516: athrow
/*     */     //   517: goto -110 -> 407
/*     */     //   520: getstatic 81	mzm/gsp/GameServer:stateLock	Ljava/util/concurrent/locks/ReentrantLock;
/*     */     //   523: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:lock	()V
/*     */     //   526: getstatic 193	mzm/gsp/GameServer$State:DOCLEANUP	Lmzm/gsp/GameServer$State;
/*     */     //   529: putstatic 83	mzm/gsp/GameServer:state	Lmzm/gsp/GameServer$State;
/*     */     //   532: getstatic 81	mzm/gsp/GameServer:stateLock	Ljava/util/concurrent/locks/ReentrantLock;
/*     */     //   535: invokevirtual 85	java/util/concurrent/locks/ReentrantLock:unlock	()V
/*     */     //   538: invokestatic 194	mzm/gsp/GameServer:kickAllRoles	()V
/*     */     //   541: invokestatic 195	mzm/gsp/GameServerInfoManager:onGameServerStop	()V
/*     */     //   544: invokestatic 149	mzm/gsp/GameServer:doCleanup	()V
/*     */     //   547: goto +27 -> 574
/*     */     //   550: astore_2
/*     */     //   551: getstatic 4	mzm/gsp/GameServer:logger	Lorg/apache/log4j/Logger;
/*     */     //   554: ldc 39
/*     */     //   556: aload_2
/*     */     //   557: invokevirtual 40	org/apache/log4j/Logger:error	(Ljava/lang/Object;Ljava/lang/Throwable;)V
/*     */     //   560: invokestatic 149	mzm/gsp/GameServer:doCleanup	()V
/*     */     //   563: goto +11 -> 574
/*     */     //   566: astore 6
/*     */     //   568: invokestatic 149	mzm/gsp/GameServer:doCleanup	()V
/*     */     //   571: aload 6
/*     */     //   573: athrow
/*     */     //   574: return
/*     */     // Line number table:
/*     */     //   Java source line #305	-> byte code offset #0
/*     */     //   Java source line #306	-> byte code offset #6
/*     */     //   Java source line #308	-> byte code offset #17
/*     */     //   Java source line #309	-> byte code offset #20
/*     */     //   Java source line #310	-> byte code offset #32
/*     */     //   Java source line #311	-> byte code offset #35
/*     */     //   Java source line #312	-> byte code offset #43
/*     */     //   Java source line #313	-> byte code offset #51
/*     */     //   Java source line #315	-> byte code offset #55
/*     */     //   Java source line #316	-> byte code offset #82
/*     */     //   Java source line #317	-> byte code offset #88
/*     */     //   Java source line #318	-> byte code offset #92
/*     */     //   Java source line #319	-> byte code offset #108
/*     */     //   Java source line #320	-> byte code offset #132
/*     */     //   Java source line #322	-> byte code offset #135
/*     */     //   Java source line #393	-> byte code offset #144
/*     */     //   Java source line #324	-> byte code offset #148
/*     */     //   Java source line #325	-> byte code offset #154
/*     */     //   Java source line #326	-> byte code offset #160
/*     */     //   Java source line #327	-> byte code offset #168
/*     */     //   Java source line #328	-> byte code offset #174
/*     */     //   Java source line #329	-> byte code offset #182
/*     */     //   Java source line #330	-> byte code offset #190
/*     */     //   Java source line #331	-> byte code offset #193
/*     */     //   Java source line #333	-> byte code offset #209
/*     */     //   Java source line #337	-> byte code offset #215
/*     */     //   Java source line #334	-> byte code offset #218
/*     */     //   Java source line #335	-> byte code offset #219
/*     */     //   Java source line #393	-> byte code offset #228
/*     */     //   Java source line #338	-> byte code offset #232
/*     */     //   Java source line #339	-> byte code offset #239
/*     */     //   Java source line #340	-> byte code offset #245
/*     */     //   Java source line #341	-> byte code offset #253
/*     */     //   Java source line #393	-> byte code offset #258
/*     */     //   Java source line #344	-> byte code offset #262
/*     */     //   Java source line #346	-> byte code offset #265
/*     */     //   Java source line #347	-> byte code offset #273
/*     */     //   Java source line #348	-> byte code offset #298
/*     */     //   Java source line #349	-> byte code offset #302
/*     */     //   Java source line #350	-> byte code offset #306
/*     */     //   Java source line #351	-> byte code offset #312
/*     */     //   Java source line #352	-> byte code offset #318
/*     */     //   Java source line #353	-> byte code offset #324
/*     */     //   Java source line #354	-> byte code offset #332
/*     */     //   Java source line #358	-> byte code offset #340
/*     */     //   Java source line #355	-> byte code offset #343
/*     */     //   Java source line #356	-> byte code offset #344
/*     */     //   Java source line #393	-> byte code offset #353
/*     */     //   Java source line #359	-> byte code offset #357
/*     */     //   Java source line #360	-> byte code offset #370
/*     */     //   Java source line #361	-> byte code offset #381
/*     */     //   Java source line #362	-> byte code offset #386
/*     */     //   Java source line #364	-> byte code offset #397
/*     */     //   Java source line #366	-> byte code offset #407
/*     */     //   Java source line #368	-> byte code offset #413
/*     */     //   Java source line #369	-> byte code offset #421
/*     */     //   Java source line #371	-> byte code offset #432
/*     */     //   Java source line #372	-> byte code offset #439
/*     */     //   Java source line #373	-> byte code offset #447
/*     */     //   Java source line #374	-> byte code offset #453
/*     */     //   Java source line #382	-> byte code offset #459
/*     */     //   Java source line #377	-> byte code offset #468
/*     */     //   Java source line #382	-> byte code offset #487
/*     */     //   Java source line #383	-> byte code offset #493
/*     */     //   Java source line #379	-> byte code offset #496
/*     */     //   Java source line #382	-> byte code offset #497
/*     */     //   Java source line #385	-> byte code offset #520
/*     */     //   Java source line #386	-> byte code offset #526
/*     */     //   Java source line #387	-> byte code offset #532
/*     */     //   Java source line #388	-> byte code offset #538
/*     */     //   Java source line #389	-> byte code offset #541
/*     */     //   Java source line #393	-> byte code offset #544
/*     */     //   Java source line #394	-> byte code offset #547
/*     */     //   Java source line #390	-> byte code offset #550
/*     */     //   Java source line #391	-> byte code offset #551
/*     */     //   Java source line #393	-> byte code offset #560
/*     */     //   Java source line #394	-> byte code offset #563
/*     */     //   Java source line #393	-> byte code offset #566
/*     */     //   Java source line #396	-> byte code offset #574
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	575	0	paramArrayOfString	String[]
/*     */     //   87	6	1	str1	String
/*     */     //   218	7	2	localClassNotFoundException	ClassNotFoundException
/*     */     //   297	6	2	str2	String
/*     */     //   343	7	2	localException1	Exception
/*     */     //   369	13	2	localObject1	Object
/*     */     //   550	7	2	localException2	Exception
/*     */     //   385	2	3	localModuleStopper	mzm.event.mbeans.ModuleStopper
/*     */     //   438	2	3	l	long
/*     */     //   496	1	3	localInterruptedException	InterruptedException
/*     */     //   506	9	5	localObject2	Object
/*     */     //   566	6	6	localObject3	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   209	215	218	java/lang/ClassNotFoundException
/*     */     //   265	340	343	java/lang/Exception
/*     */     //   413	459	496	java/lang/InterruptedException
/*     */     //   468	487	496	java/lang/InterruptedException
/*     */     //   413	459	506	finally
/*     */     //   468	487	506	finally
/*     */     //   496	497	506	finally
/*     */     //   506	508	506	finally
/*     */     //   135	144	550	java/lang/Exception
/*     */     //   148	228	550	java/lang/Exception
/*     */     //   232	258	550	java/lang/Exception
/*     */     //   262	353	550	java/lang/Exception
/*     */     //   357	544	550	java/lang/Exception
/*     */     //   135	144	566	finally
/*     */     //   148	228	566	finally
/*     */     //   232	258	566	finally
/*     */     //   262	353	566	finally
/*     */     //   357	544	566	finally
/*     */     //   550	560	566	finally
/*     */     //   566	568	566	finally
/*     */   }
/*     */   
/*     */   public static class AlarmShutdown
/*     */     implements Runnable
/*     */   {
/* 409 */     private static TreeSet<Integer> interval = new TreeSet(Arrays.asList(new Integer[] { Integer.valueOf(5), Integer.valueOf(10), Integer.valueOf(30), Integer.valueOf(60), Integer.valueOf(120), Integer.valueOf(180), Integer.valueOf(300), Integer.valueOf(600), Integer.valueOf(1200), Integer.valueOf(1800) }));
/*     */     
/*     */     void sendAlarm(int paramInt) {
/* 412 */       SServerShutDownBrd localSServerShutDownBrd = new SServerShutDownBrd(paramInt);
/* 413 */       OnlineManager.getInstance().sendAll(localSServerShutDownBrd);
/*     */     }
/*     */     
/*     */     public void run() {
/* 417 */       while (GameServer.isShutdown()) {
/* 418 */         int i = (int)((GameServer.access$000() - DateTimeUtils.getCurrTimeInMillis()) / 1000L);
/* 419 */         if (i > 0) {
/* 420 */           sendAlarm(i);
/* 421 */           Integer localInteger = (Integer)interval.floor(Integer.valueOf(i - 1));
/* 422 */           if (localInteger != null)
/*     */             try {
/* 424 */               Thread.sleep((i - localInteger.intValue()) * 1000L);
/*     */             } catch (Exception localException) {
/*     */               break;
/*     */             }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Stopper implements ModuleStopperMXBean {
/*     */     public void run() {
/* 435 */       GameServer.stop(5);
/*     */     }
/*     */     
/*     */ 
/*     */     public void cancel() {}
/*     */   }
/*     */   
/*     */   static enum State
/*     */   {
/* 444 */     STARTUP,  RUNNING,  SHUTDOWN,  DOCLEANUP;
/*     */     
/*     */     private State() {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\GameServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */