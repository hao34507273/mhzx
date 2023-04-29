/*     */ package mzm.gsp.title.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.AppellationInfo;
/*     */ import xbean.TitleAppellation;
/*     */ import xbean.TitleSessionInfo;
/*     */ 
/*     */ public class AppellationOwnSession extends Session
/*     */ {
/*     */   private final int appellationId;
/*     */   private final long roleId;
/*     */   
/*     */   AppellationOwnSession(long interval, long roleId, int appellationId)
/*     */   {
/*  20 */     super(interval, roleId);
/*  21 */     this.appellationId = appellationId;
/*  22 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   @Deprecated
/*  26 */   private static Map<Long, Map<Integer, AppellationOwnSession>> AppellationSessionMap = Collections.synchronizedMap(new HashMap());
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  31 */     NoneRealTimeTaskManager.getInstance().addTask(new PRmTimeOutApp(null));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private class PRmTimeOutApp
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private PRmTimeOutApp() {}
/*     */     
/*     */ 
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  46 */       TitleAppellation xTitleAppellation = xtable.Role2titleappellation.get(Long.valueOf(AppellationOwnSession.this.roleId));
/*  47 */       if (xTitleAppellation == null)
/*     */       {
/*  49 */         return false;
/*     */       }
/*  51 */       AppellationInfo xAppInfo = (AppellationInfo)xTitleAppellation.getAppellations().get(Integer.valueOf(AppellationOwnSession.this.appellationId));
/*  52 */       if (xAppInfo == null)
/*     */       {
/*  54 */         return false;
/*     */       }
/*  56 */       long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  57 */       long timeOutTime = xAppInfo.getTimeout();
/*  58 */       if ((timeOutTime == 0L) || (curTime + 3000L < timeOutTime))
/*     */       {
/*  60 */         mzm.gsp.GameServer.logger().info(String.format("[title]PRmTimeOutApp.processImp@ no need rm!|roleId=%d|curTime=%d|timeOut=%d|appId=%d", new Object[] { Long.valueOf(AppellationOwnSession.this.roleId), Long.valueOf(curTime), Long.valueOf(timeOutTime), Integer.valueOf(AppellationOwnSession.this.appellationId) }));
/*     */         
/*     */ 
/*  63 */         return false;
/*     */       }
/*  65 */       return TitleManager.pRmAppellantionImpl(AppellationOwnSession.this.roleId, AppellationOwnSession.this.appellationId, xTitleAppellation);
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
/*     */   static void addAppSession(long intervalSec, long roleId, int appellationId)
/*     */   {
/*  78 */     TitleSessionInfo xInfo = TitleManager.getTitleSessionXInfoIfAbsence(roleId);
/*  79 */     TitleManager.rmAppSession(appellationId, xInfo);
/*  80 */     AppellationOwnSession newSession = new AppellationOwnSession(intervalSec, roleId, appellationId);
/*  81 */     xInfo.getAppsession().put(Integer.valueOf(appellationId), Long.valueOf(newSession.getSessionId()));
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
/*     */   @Deprecated
/*     */   static void addAppellationOwnSession(long intervalSec, long roleId, int appellationId)
/*     */   {
/*  95 */     if (AppellationSessionMap.containsKey(Long.valueOf(roleId)))
/*     */     {
/*  97 */       Map<Integer, AppellationOwnSession> appellationOwnSessionMap = (Map)AppellationSessionMap.get(Long.valueOf(roleId));
/*  98 */       if (appellationOwnSessionMap.containsKey(Integer.valueOf(appellationId)))
/*     */       {
/* 100 */         AppellationOwnSession session = (AppellationOwnSession)appellationOwnSessionMap.get(Integer.valueOf(appellationId));
/* 101 */         session.stopTimer();
/* 102 */         appellationOwnSessionMap.remove(Integer.valueOf(appellationId));
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 107 */       Map<Integer, AppellationOwnSession> appellationOwnSessionMap = Collections.synchronizedMap(new HashMap());
/* 108 */       AppellationSessionMap.put(Long.valueOf(roleId), appellationOwnSessionMap);
/*     */     }
/* 110 */     AppellationOwnSession appellationOwnSession = new AppellationOwnSession(intervalSec, roleId, appellationId);
/* 111 */     ((Map)AppellationSessionMap.get(Long.valueOf(roleId))).put(Integer.valueOf(appellationId), appellationOwnSession);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   static void remAppellationSession(long roleId)
/*     */   {
/* 122 */     if (AppellationSessionMap.containsKey(Long.valueOf(roleId)))
/*     */     {
/* 124 */       Map<Integer, AppellationOwnSession> appellationOwnSessionMap = (Map)AppellationSessionMap.remove(Long.valueOf(roleId));
/* 125 */       for (Map.Entry<Integer, AppellationOwnSession> entry : appellationOwnSessionMap.entrySet())
/*     */       {
/* 127 */         ((AppellationOwnSession)entry.getValue()).stopTimer();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\AppellationOwnSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */