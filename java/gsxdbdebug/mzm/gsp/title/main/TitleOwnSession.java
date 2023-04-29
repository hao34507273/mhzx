/*     */ package mzm.gsp.title.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.TitleAppellation;
/*     */ import xbean.TitleInfo;
/*     */ import xbean.TitleSessionInfo;
/*     */ 
/*     */ public class TitleOwnSession extends Session
/*     */ {
/*     */   private final int titleId;
/*     */   private final long roleId;
/*     */   
/*     */   TitleOwnSession(long interval, long roleId, int titleId)
/*     */   {
/*  21 */     super(interval, roleId);
/*  22 */     this.titleId = titleId;
/*  23 */     this.roleId = roleId; }
/*     */   
/*     */   @Deprecated
/*  26 */   private static Map<Long, Map<Integer, TitleOwnSession>> titleSessionMap = Collections.synchronizedMap(new HashMap());
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  31 */     NoneRealTimeTaskManager.getInstance().addTask(new PRmTimeOutTitle(null));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private class PRmTimeOutTitle
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private PRmTimeOutTitle() {}
/*     */     
/*     */ 
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  46 */       TitleAppellation xTitleAppellation = xtable.Role2titleappellation.get(Long.valueOf(TitleOwnSession.this.roleId));
/*  47 */       if (xTitleAppellation == null)
/*     */       {
/*  49 */         return false;
/*     */       }
/*     */       
/*  52 */       java.util.List<TitleInfo> xTitleInfos = xTitleAppellation.getOwntitle();
/*  53 */       TitleInfo xTitleInfo = null;
/*  54 */       for (TitleInfo xInfo : xTitleInfos)
/*     */       {
/*  56 */         if (xInfo.getTitleid() == TitleOwnSession.this.titleId)
/*     */         {
/*  58 */           xTitleInfo = xInfo;
/*     */         }
/*     */       }
/*  61 */       if (xTitleInfo == null)
/*     */       {
/*  63 */         return false;
/*     */       }
/*     */       
/*  66 */       long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  67 */       long timeOutTime = xTitleInfo.getTimeout();
/*  68 */       if ((timeOutTime == 0L) || (curTime + 3000L < timeOutTime))
/*     */       {
/*  70 */         GameServer.logger().info(String.format("[title]PRmTimeOutTitle.processImp@ no need rm!|roleId=%d|curTime=%d|timeOut=%d|titleId=%d", new Object[] { Long.valueOf(TitleOwnSession.this.roleId), Long.valueOf(curTime), Long.valueOf(timeOutTime), Integer.valueOf(TitleOwnSession.this.titleId) }));
/*     */         
/*     */ 
/*     */ 
/*  74 */         return false;
/*     */       }
/*  76 */       return new PRemoveTitle(TitleOwnSession.this.roleId, TitleOwnSession.this.titleId).call();
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
/*     */   static void addTitleSession(long intervalSec, long roleId, int titleId)
/*     */   {
/*  89 */     TitleSessionInfo xInfo = TitleManager.getTitleSessionXInfoIfAbsence(roleId);
/*  90 */     TitleManager.rmTitleSession(titleId, xInfo);
/*  91 */     TitleOwnSession newSession = new TitleOwnSession(intervalSec, roleId, titleId);
/*  92 */     xInfo.getTitlesession().put(Integer.valueOf(titleId), Long.valueOf(newSession.getSessionId()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   static void addTitleOwnSession(long intervalSec, long roleId, int titleId)
/*     */   {
/* 105 */     if (titleSessionMap.containsKey(Long.valueOf(roleId)))
/*     */     {
/* 107 */       Map<Integer, TitleOwnSession> titleOwnSessionMap = (Map)titleSessionMap.get(Long.valueOf(roleId));
/* 108 */       if (titleOwnSessionMap.containsKey(Integer.valueOf(titleId)))
/*     */       {
/* 110 */         TitleOwnSession session = (TitleOwnSession)titleOwnSessionMap.get(Integer.valueOf(titleId));
/* 111 */         session.stopTimer();
/* 112 */         titleOwnSessionMap.remove(Integer.valueOf(titleId));
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 117 */       Map<Integer, TitleOwnSession> titleOwnSessionMap = Collections.synchronizedMap(new HashMap());
/* 118 */       titleSessionMap.put(Long.valueOf(roleId), titleOwnSessionMap);
/*     */     }
/* 120 */     TitleOwnSession titleOwnSession = new TitleOwnSession(intervalSec, roleId, titleId);
/* 121 */     ((Map)titleSessionMap.get(Long.valueOf(roleId))).put(Integer.valueOf(titleId), titleOwnSession);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   static void remTitleOwnSession(long roleId)
/*     */   {
/* 132 */     if (titleSessionMap.containsKey(Long.valueOf(roleId)))
/*     */     {
/* 134 */       Map<Integer, TitleOwnSession> titleOwnSessionMap = (Map)titleSessionMap.remove(Long.valueOf(roleId));
/* 135 */       for (Map.Entry<Integer, TitleOwnSession> entry : titleOwnSessionMap.entrySet())
/*     */       {
/* 137 */         ((TitleOwnSession)entry.getValue()).stopTimer();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\TitleOwnSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */