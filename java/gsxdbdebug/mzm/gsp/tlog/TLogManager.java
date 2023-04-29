/*     */ package mzm.gsp.tlog;
/*     */ 
/*     */ import gnet.link.Onlines;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.DatagramChannel;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TLogManager
/*     */ {
/*  36 */   private static String TLogPath = "";
/*     */   
/*     */   private static final String TLogCfgFileName = "tlogCfg.xml";
/*  39 */   private Map<String, TLogStruct> name2TLogStruct = new HashMap();
/*     */   private static final String UTF_8 = "UTF-8";
/*  41 */   private static volatile String TLOG_SERVER_IP = "10.236.100.29";
/*  42 */   private static volatile int TLOG_SERVER_PORT = 29400;
/*     */   
/*     */   private static final int COMMON_COLUMN_LENGTH = 6;
/*     */   private static final int COMMON_COLUMN_LENGTH_SEC = 6;
/*  46 */   private static TLogManager instance = new TLogManager();
/*     */   
/*  48 */   private Logger logger = null;
/*  49 */   private Logger gstlog = null;
/*     */   
/*     */   public static TLogManager getInstance()
/*     */   {
/*  53 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  60 */   private static final ThreadLocal<LinkedList<String>> localLogs = new ThreadLocal();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int logBeforeTransaction()
/*     */   {
/*  70 */     LinkedList<String> currLogs = (LinkedList)localLogs.get();
/*  71 */     if (currLogs == null) {
/*  72 */       localLogs.set(currLogs = new LinkedList());
/*     */     }
/*  74 */     return currLogs.size();
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
/*     */   public boolean logAfterTransaction(boolean bSuccess, int savePoint, int nestCount)
/*     */   {
/*  88 */     LinkedList<String> currLogs = (LinkedList)localLogs.get();
/*  89 */     if (currLogs != null)
/*     */     {
/*  91 */       if (nestCount == 0)
/*     */       {
/*     */         try
/*     */         {
/*  95 */           if (bSuccess)
/*     */           {
/*  97 */             for (String logStr : currLogs)
/*     */             {
/*  99 */               writeTLog(logStr);
/*     */             }
/*     */             
/*     */           }
/*     */         }
/*     */         finally
/*     */         {
/* 106 */           localLogs.set(null);
/* 107 */           currLogs.clear();
/*     */ 
/*     */         }
/*     */         
/*     */       }
/* 112 */       else if ((!bSuccess) && (savePoint >= 0)) {
/* 113 */         for (int i = currLogs.size() - 1; i >= savePoint; i--)
/* 114 */           currLogs.remove(i);
/*     */       }
/*     */     }
/* 117 */     return true;
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
/*     */   public boolean addLog(long roleid, String logName, String logStr)
/*     */   {
/* 133 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/* 135 */     return addLog(userid, logName, logStr);
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
/*     */   public boolean addLog(String userid, String logName, String logStr)
/*     */   {
/* 152 */     boolean ret = checkLogLength(logName, logStr, 6);
/* 153 */     if (!ret)
/*     */     {
/* 155 */       return false;
/*     */     }
/* 157 */     String finalLog = getLogStrWithCommonColumns(userid, logName, logStr);
/*     */     
/* 159 */     insertLog(finalLog, false);
/*     */     
/* 161 */     return true;
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
/*     */   public boolean addLog(String logName, String logStr)
/*     */   {
/* 174 */     boolean ret = checkLogLength(logName, logStr, 0);
/* 175 */     if (!ret)
/*     */     {
/* 177 */       return false;
/*     */     }
/*     */     
/* 180 */     if (!logStr.endsWith("\n"))
/*     */     {
/* 182 */       logStr = logStr + "\n";
/*     */     }
/* 184 */     insertLog(logName + "|" + logStr, false);
/*     */     
/* 186 */     return true;
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
/*     */   private boolean checkLogLength(String logName, String logStr, int commonLength)
/*     */   {
/* 202 */     TLogStruct tLogStruct = (TLogStruct)this.name2TLogStruct.get(logName);
/*     */     
/* 204 */     if (tLogStruct == null)
/*     */     {
/* 206 */       String s = String.format("[tlogmanager]TLogManager.checkLogLength@check tlog error,logname not found|logname=%s|logstr=%s", new Object[] { logName, logStr });
/*     */       
/*     */ 
/* 209 */       this.logger.error(s);
/* 210 */       return false;
/*     */     }
/*     */     
/* 213 */     String[] ss = logStr.split("\\|");
/* 214 */     int logcfgsize = tLogStruct.getColumnList().size();
/* 215 */     if (ss.length + commonLength != logcfgsize)
/*     */     {
/* 217 */       String s = String.format("[tlogmanager]TLogManager.checkLogLength@check tlog length error|logname=%s|logstr=%s|cfglength=%d|loglength=%d", new Object[] { logName, logStr, Integer.valueOf(logcfgsize), Integer.valueOf(ss.length) });
/*     */       
/*     */ 
/* 220 */       this.logger.error(s);
/* 221 */       return false;
/*     */     }
/*     */     
/* 224 */     return true;
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
/*     */   private String getLogStrWithCommonColumns(String userid, String logName, String logStr)
/*     */   {
/* 238 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/*     */     
/* 240 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 241 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 242 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*     */     
/* 244 */     String vGameAppid = Onlines.getInstance().findGameAppid(userid);
/* 245 */     int PlatID = Onlines.getInstance().findPlatid(userid);
/*     */     
/* 247 */     int iZoneAreaID = GameServerInfoManager.getZoneidFromUserid(userid);
/* 248 */     String vopenid = Onlines.getInstance().findOpenid(userid);
/*     */     
/* 250 */     StringBuffer sb = new StringBuffer();
/*     */     
/* 252 */     sb.append(logName).append("|");
/*     */     
/* 254 */     sb.append(GameSvrId).append("|");
/* 255 */     sb.append(dtEventTime).append("|");
/* 256 */     sb.append(vGameAppid).append("|");
/* 257 */     sb.append(PlatID).append("|");
/* 258 */     sb.append(iZoneAreaID).append("|");
/* 259 */     sb.append(vopenid).append("|");
/*     */     
/* 261 */     sb.append(logStr);
/*     */     
/* 263 */     if (!logStr.endsWith("\n"))
/*     */     {
/* 265 */       sb.append("\n");
/*     */     }
/*     */     
/* 268 */     return sb.toString();
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
/*     */   public boolean addLogSec(long roleid, String logName, String logStr)
/*     */   {
/* 290 */     StringBuffer sBuffer = new StringBuffer();
/* 291 */     String userId = "";
/* 292 */     if (roleid != 0L)
/*     */     {
/* 294 */       userId = RoleInterface.getUserId(roleid);
/*     */     }
/* 296 */     boolean ret = checkLogStrSec(userId, logName, logStr, sBuffer);
/* 297 */     if (!ret)
/*     */     {
/* 299 */       return false;
/*     */     }
/* 301 */     insertLog(sBuffer.toString(), false);
/*     */     
/* 303 */     return true;
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
/*     */   private boolean checkLogStrSec(String userid, String logName, String logStr, StringBuffer sb)
/*     */   {
/* 321 */     boolean ret = checkLogLength(logName, logStr, 6);
/*     */     
/* 323 */     if (!ret)
/*     */     {
/* 325 */       return false;
/*     */     }
/* 327 */     if (!logStr.endsWith("\n"))
/*     */     {
/* 329 */       logStr = logStr + "\n";
/*     */     }
/*     */     
/* 332 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/*     */     
/* 334 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 335 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 336 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*     */     
/*     */ 
/* 339 */     int ZoneId = 0;
/* 340 */     String GameAppid = "0";
/* 341 */     int PlatID = 0;
/*     */     
/* 343 */     int AreaId = 0;
/* 344 */     if (!userid.isEmpty())
/*     */     {
/* 346 */       ZoneId = GameServerInfoManager.getZoneidFromUserid(userid);
/*     */       
/* 348 */       GameAppid = Onlines.getInstance().findGameAppid(userid);
/* 349 */       PlatID = Onlines.getInstance().findPlatid(userid);
/* 350 */       if ((GameAppid != null) && (GameAppid.startsWith("G_")))
/*     */       {
/* 352 */         AreaId = 3;
/*     */       }
/*     */       else
/*     */       {
/* 356 */         String platName = CommonUtils.getPlatName(userid);
/* 357 */         if ("qq".equals(platName))
/*     */         {
/* 359 */           AreaId = 2;
/*     */         }
/* 361 */         else if ("wechat".equals(platName))
/*     */         {
/* 363 */           AreaId = 1;
/*     */         }
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 369 */       ZoneId = GameServerInfoManager.getZoneId();
/*     */     }
/*     */     
/* 372 */     sb.append(logName).append("|");
/*     */     
/* 374 */     sb.append(GameSvrId).append("|");
/* 375 */     sb.append(dtEventTime).append("|");
/* 376 */     sb.append(GameAppid).append("|");
/*     */     
/* 378 */     sb.append(PlatID).append("|");
/* 379 */     sb.append(AreaId).append("|");
/* 380 */     sb.append(ZoneId).append("|");
/*     */     
/* 382 */     sb.append(logStr);
/*     */     
/* 384 */     return true;
/*     */   }
/*     */   
/*     */   void init()
/*     */   {
/* 389 */     this.gstlog = Logger.getLogger("tlog");
/* 390 */     this.logger = Logger.getLogger("TLogManager");
/*     */     
/* 392 */     TLogPath = GameServer.getGamedataDir() + File.separator + "tlog";
/*     */     
/* 394 */     File f = new File(TLogPath);
/* 395 */     if (!f.exists())
/*     */     {
/* 397 */       f.mkdirs();
/*     */     }
/*     */     
/*     */ 
/* 401 */     String logCfgFilePathName = TLogPath + File.separator + "tlogCfg.xml";
/* 402 */     load(logCfgFilePathName);
/*     */   }
/*     */   
/*     */ 
/*     */   private void load(String logPath)
/*     */   {
/*     */     try
/*     */     {
/* 410 */       Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(logPath));
/* 411 */       Element root = doc.getDocumentElement();
/* 412 */       NodeList structList = root.getElementsByTagName("struct");
/*     */       
/* 414 */       for (int i = 0; i < structList.getLength(); i++)
/*     */       {
/* 416 */         TLogStruct struct = new TLogStruct(structList.item(i));
/* 417 */         if (this.name2TLogStruct.containsKey(struct.getStructName()))
/*     */         {
/* 419 */           throw new RuntimeException("配置了相同的日志结构名称:" + struct.getStructName());
/*     */         }
/* 421 */         this.name2TLogStruct.put(struct.getStructName(), struct);
/* 422 */         if ((!struct.getStructName().equals("GangLevelup")) && (!struct.getStructName().equals("GameSvrState")) && (!struct.getStructName().equals("SnsFlow")) && (!struct.getStructName().equals("ServerAwardPoolDrop")))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 427 */           checkStruct(struct);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 433 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   private void checkStruct(TLogStruct struct)
/*     */   {
/* 439 */     if (struct.isSecIdip())
/*     */     {
/* 441 */       if (struct.getColumnList().size() < 6)
/*     */       {
/* 443 */         throw new RuntimeException(struct.getStructName() + " 日志结果配置错误，至少应包含 GameSvrId、dtEventTime、GameAppID、PlatID、AreaID、ZoneID");
/*     */       }
/*     */       
/* 446 */       if (!((String)struct.getColumnList().get(0)).equals("GameSvrId"))
/*     */       {
/* 448 */         throw new RuntimeException(struct.getStructName() + " 日志结果配置错误，第1列应该为 GameSvrId");
/*     */       }
/* 450 */       if (!((String)struct.getColumnList().get(1)).equals("dtEventTime"))
/*     */       {
/* 452 */         throw new RuntimeException(struct.getStructName() + " 日志结果配置错误，第2列应该为dtEventTime");
/*     */       }
/* 454 */       if (!((String)struct.getColumnList().get(2)).equals("GameAppID"))
/*     */       {
/* 456 */         throw new RuntimeException(struct.getStructName() + " 日志结果配置错误，第3列应该为GameAppID");
/*     */       }
/* 458 */       if (!((String)struct.getColumnList().get(3)).equals("PlatID"))
/*     */       {
/* 460 */         throw new RuntimeException(struct.getStructName() + " 日志结果配置错误，第4列应该为PlatID");
/*     */       }
/* 462 */       if (!((String)struct.getColumnList().get(4)).equals("AreaID"))
/*     */       {
/* 464 */         throw new RuntimeException(struct.getStructName() + " 日志结果配置错误，第5列应该为AreaID");
/*     */       }
/* 466 */       if (!((String)struct.getColumnList().get(5)).equals("ZoneID"))
/*     */       {
/* 468 */         throw new RuntimeException(struct.getStructName() + " 日志结果配置错误，第6列应该为ZoneID");
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 473 */       if (struct.getColumnList().size() < 6)
/*     */       {
/* 475 */         throw new RuntimeException(struct.getStructName() + " 日志结果配置错误，至少应包含 GameSvrId、dtEventTime、vGameAppid、PlatID、iZoneAreaID、vopenid");
/*     */       }
/*     */       
/* 478 */       if (!((String)struct.getColumnList().get(0)).equals("GameSvrId"))
/*     */       {
/* 480 */         throw new RuntimeException(struct.getStructName() + " 日志结果配置错误，第1列应该为 GameSvrId");
/*     */       }
/* 482 */       if (!((String)struct.getColumnList().get(1)).equals("dtEventTime"))
/*     */       {
/* 484 */         throw new RuntimeException(struct.getStructName() + " 日志结果配置错误，第2列应该为dtEventTime");
/*     */       }
/* 486 */       if (!((String)struct.getColumnList().get(2)).equals("vGameAppid"))
/*     */       {
/* 488 */         throw new RuntimeException(struct.getStructName() + " 日志结果配置错误，第3列应该为vGameAppid");
/*     */       }
/* 490 */       if (!((String)struct.getColumnList().get(3)).equals("PlatID"))
/*     */       {
/* 492 */         throw new RuntimeException(struct.getStructName() + " 日志结果配置错误，第4列应该为PlatID");
/*     */       }
/* 494 */       if (!((String)struct.getColumnList().get(4)).equals("iZoneAreaID"))
/*     */       {
/* 496 */         throw new RuntimeException(struct.getStructName() + " 日志结果配置错误，第5列应该为iZoneAreaID");
/*     */       }
/* 498 */       if (!((String)struct.getColumnList().get(5)).equals("vopenid"))
/*     */       {
/* 500 */         throw new RuntimeException(struct.getStructName() + " 日志结果配置错误，第6列应该为vopenid");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void writeLogToServer(String logstr)
/*     */   {
/* 507 */     DatagramChannel channel = null;
/*     */     try
/*     */     {
/* 510 */       channel = DatagramChannel.open();
/* 511 */       channel.configureBlocking(false);
/* 512 */       ByteBuffer buffer = ByteBuffer.wrap(logstr.getBytes("UTF-8"));
/* 513 */       int sendsize = channel.send(buffer, new InetSocketAddress(TLOG_SERVER_IP, TLOG_SERVER_PORT));
/* 514 */       if (sendsize == 0)
/*     */       {
/* 516 */         String s = String.format("[tlogmanager]TLogManager.writeLogToServer@write log to server %s:%d error|logstr=%s", new Object[] { TLOG_SERVER_IP, Integer.valueOf(TLOG_SERVER_PORT), logstr });
/*     */         
/* 518 */         this.logger.error(s);
/*     */       }
/*     */       String s;
/*     */       String s;
/*     */       String s;
/*     */       String s;
/*     */       return; } catch (Exception e) { s = String.format("[tlogmanager]TLogManager.writeLogToServer@write log to server %s:%d error|logstr=%s", new Object[] { TLOG_SERVER_IP, Integer.valueOf(TLOG_SERVER_PORT), logstr });
/*     */       
/* 526 */       this.logger.error(s, e);
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 531 */       if (channel != null)
/*     */       {
/*     */         try
/*     */         {
/* 535 */           channel.close();
/*     */         }
/*     */         catch (IOException e)
/*     */         {
/* 539 */           s = String.format("[tlogmanager]TLogManager.writelog@关闭DatagramChannel 通道异常", new Object[0]);
/* 540 */           this.logger.error(s, e);
/*     */         }
/*     */       }
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
/*     */   static void initTlogServerIPAndPort(String tlogServerIp, int port)
/*     */   {
/* 557 */     TLOG_SERVER_IP = tlogServerIp;
/* 558 */     TLOG_SERVER_PORT = port;
/*     */   }
/*     */   
/*     */   static String getTlogServerIP()
/*     */   {
/* 563 */     return TLOG_SERVER_IP;
/*     */   }
/*     */   
/*     */ 
/*     */   static int getTlogServerPort()
/*     */   {
/* 569 */     return TLOG_SERVER_PORT;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void writeGsLog(String logstr)
/*     */   {
/* 577 */     this.gstlog.info(logstr.substring(0, logstr.length() - 1));
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
/*     */   public boolean addLog(long roleid, String logName, Object... logColumns)
/*     */   {
/* 591 */     return addLog(roleid, logName, false, logColumns);
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
/*     */   public boolean addLogAtOnce(long roleid, String logName, Object... logColumns)
/*     */   {
/* 605 */     return addLog(roleid, logName, true, logColumns);
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
/*     */   private boolean addLog(long roleid, String logName, boolean isSendAtOnce, Object... logColumns)
/*     */   {
/* 620 */     String userId = RoleInterface.getUserId(roleid);
/*     */     
/* 622 */     return addLog(userId, logName, isSendAtOnce, logColumns);
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
/*     */   public boolean addLog(String userId, long roleid, String logName, Object... logColumns)
/*     */   {
/* 637 */     return addLog(userId, roleid, logName, false, logColumns);
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
/*     */   public boolean addLogAtOnce(String userId, long roleid, String logName, Object... logColumns)
/*     */   {
/* 651 */     return addLog(userId, roleid, logName, true, logColumns);
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
/*     */   private boolean addLog(String userId, long roleid, String logName, boolean isSendAtOnce, Object... logColumns)
/*     */   {
/* 667 */     return addLog(userId, logName, isSendAtOnce, logColumns);
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
/*     */   public boolean addLog(String userId, String logName, Object... logColumns)
/*     */   {
/* 682 */     return addLog(userId, logName, false, logColumns);
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
/*     */   public boolean addLogAtOnce(String userId, String logName, Object... logColumns)
/*     */   {
/* 697 */     return addLog(userId, logName, true, logColumns);
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
/*     */   private boolean addLog(String userId, String logName, boolean isSendAtOnce, Object... logColumns)
/*     */   {
/* 712 */     boolean ret = checkLogLength(logName, 6, logColumns);
/* 713 */     if (!ret)
/*     */     {
/* 715 */       return false;
/*     */     }
/*     */     
/* 718 */     String logStr = getLogStrWithCommonColumns(userId, logName, logColumns);
/*     */     
/* 720 */     insertLog(logStr, isSendAtOnce);
/*     */     
/* 722 */     return true;
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
/*     */   public boolean addLog(String logName, Object... logColumns)
/*     */   {
/* 735 */     return addLog(logName, false, logColumns);
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
/*     */   public boolean addLogAtOnce(String logName, Object... logColumns)
/*     */   {
/* 749 */     return addLog(logName, true, logColumns);
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
/*     */   private boolean addLog(String logName, boolean isSendAtOnce, Object... logColumns)
/*     */   {
/* 765 */     boolean ret = checkLogLength(logName, 0, logColumns);
/* 766 */     if (!ret)
/*     */     {
/* 768 */       return false;
/*     */     }
/*     */     
/* 771 */     String logStr = logName + "|" + getLogStr(logColumns);
/*     */     
/* 773 */     insertLog(logStr, isSendAtOnce);
/*     */     
/* 775 */     return true;
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
/*     */   private boolean checkLogLength(String logName, int commonColumnLength, Object... logColumns)
/*     */   {
/* 789 */     if (logColumns == null)
/*     */     {
/*     */ 
/* 792 */       String s = String.format("[tlogmanager]TLogManager.checkLogLength@logColumns null|logname=%s", new Object[] { logName });
/* 793 */       this.logger.error(s);
/* 794 */       return false;
/*     */     }
/* 796 */     TLogStruct tLogStruct = (TLogStruct)this.name2TLogStruct.get(logName);
/*     */     
/* 798 */     if (tLogStruct == null)
/*     */     {
/* 800 */       String errorLogStr = getErrorLogStr(",", logColumns);
/* 801 */       String s = String.format("[tlogmanager]TLogManager.checkLogLength@check tlog error,logname not found|logname=%s|logstr=%s", new Object[] { logName, errorLogStr });
/*     */       
/*     */ 
/* 804 */       this.logger.error(s);
/* 805 */       return false;
/*     */     }
/*     */     
/* 808 */     int logcfgsize = tLogStruct.getColumnList().size();
/* 809 */     if (logColumns.length + commonColumnLength != logcfgsize)
/*     */     {
/* 811 */       String errorLogStr = getErrorLogStr(",", logColumns);
/* 812 */       String s = String.format("[tlogmanager]TLogManager.checkLogLength@check tlog length error|logname=%s|logstr=%s|cfglength=%d|loglength=%d", new Object[] { logName, errorLogStr, Integer.valueOf(logcfgsize), Integer.valueOf(logColumns.length) });
/*     */       
/*     */ 
/* 815 */       this.logger.error(s);
/* 816 */       return false;
/*     */     }
/*     */     
/* 819 */     return true;
/*     */   }
/*     */   
/*     */   private String getErrorLogStr(String splitString, Object... logColumns)
/*     */   {
/* 824 */     StringBuffer sb = new StringBuffer();
/* 825 */     for (Object s : logColumns)
/*     */     {
/* 827 */       sb.append(s).append(splitString);
/*     */     }
/* 829 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   private String getLogStrWithCommonColumns(String userId, String logName, Object... logColumns)
/*     */   {
/* 835 */     String customizedLogString = getLogStr(logColumns);
/* 836 */     return getLogStrWithCommonColumns(userId, logName, customizedLogString);
/*     */   }
/*     */   
/*     */ 
/*     */   private String getLogStr(Object... logColumns)
/*     */   {
/* 842 */     StringBuffer sb = new StringBuffer();
/*     */     
/* 844 */     for (Object s : logColumns)
/*     */     {
/* 846 */       sb.append(s).append("|");
/*     */     }
/*     */     
/* 849 */     String logStr = sb.substring(0, sb.length() - 1);
/*     */     
/* 851 */     if (!logStr.endsWith("\n"))
/*     */     {
/* 853 */       logStr = logStr + "\n";
/*     */     }
/* 855 */     return logStr;
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
/*     */   private void insertLog(String finalLogStr, boolean isSendAtOnce)
/*     */   {
/* 868 */     if (isSendAtOnce)
/*     */     {
/* 870 */       writeTLog(finalLogStr);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 875 */       LinkedList<String> currLogs = (LinkedList)localLogs.get();
/* 876 */       if (currLogs == null)
/*     */       {
/* 878 */         currLogs = new LinkedList();
/* 879 */         localLogs.set(currLogs);
/*     */       }
/* 881 */       currLogs.add(finalLogStr);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void writeTLog(String finalLogStr)
/*     */   {
/* 888 */     if (!GameServerInfoManager.isRoamServer())
/*     */     {
/* 890 */       writeLogToServer(finalLogStr);
/*     */     }
/* 892 */     writeGsLog(finalLogStr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\tlog\TLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */