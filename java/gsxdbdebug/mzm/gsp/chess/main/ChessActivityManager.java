/*     */ package mzm.gsp.chess.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.activity3.confbean.ChessActivityConsts;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChessActivityInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2chessactivityinfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ class ChessActivityManager
/*     */ {
/*  19 */   static final Logger logger = Logger.getLogger(ChessActivityManager.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isAnyBaned(List<Long> roleIds)
/*     */   {
/*  30 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  32 */       if (OpenInterface.isBanPlay(roleId, 396))
/*     */       {
/*  34 */         OpenInterface.sendBanPlayMsg(roleId, 396);
/*  35 */         return true;
/*     */       }
/*     */     }
/*  38 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean canGetAward(long roleId)
/*     */   {
/*  49 */     ChessActivityInfo xChessActivityInfo = Role2chessactivityinfo.get(Long.valueOf(roleId));
/*  50 */     if (null == xChessActivityInfo)
/*     */     {
/*  52 */       xChessActivityInfo = Pod.newChessActivityInfo();
/*  53 */       Role2chessactivityinfo.add(Long.valueOf(roleId), xChessActivityInfo);
/*     */     }
/*  55 */     int awardedCount = xChessActivityInfo.getToday_win_count() + xChessActivityInfo.getToday_lose_count() + xChessActivityInfo.getToday_draw_count();
/*     */     
/*  57 */     return awardedCount < ChessActivityConsts.getInstance().AWARD_COUNT;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void offerActivityAward(String userId, long roleId, int result)
/*     */   {
/*     */     LogReason logReason;
/*     */     
/*     */ 
/*     */ 
/*  69 */     switch (result)
/*     */     {
/*     */     case 1: 
/*  72 */       logReason = LogReason.ACTIVITY_CHESS_WIN_AWARD;
/*  73 */       break;
/*     */     case 2: 
/*  75 */       logReason = LogReason.ACTIVITY_CHESS_LOSE_AWARD;
/*  76 */       break;
/*     */     default: 
/*  78 */       logReason = LogReason.ACTIVITY_CHESS_DRAW_AWARD;
/*     */     }
/*     */     
/*  81 */     if (canGetAward(roleId))
/*     */     {
/*  83 */       int awardId = ChessActivityConsts.getInstance().AWARD_ID;
/*  84 */       AwardInterface.award(awardId, userId, roleId, false, true, new AwardReason(logReason));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addActivityCount(long roleId, int result)
/*     */   {
/*  96 */     ChessActivityInfo xChessActivityInfo = Role2chessactivityinfo.get(Long.valueOf(roleId));
/*  97 */     if (null == xChessActivityInfo)
/*     */     {
/*  99 */       xChessActivityInfo = Pod.newChessActivityInfo();
/* 100 */       Role2chessactivityinfo.add(Long.valueOf(roleId), xChessActivityInfo);
/*     */     }
/* 102 */     switch (result)
/*     */     {
/*     */     case 1: 
/* 105 */       xChessActivityInfo.setToday_win_count(xChessActivityInfo.getToday_win_count() + 1);
/* 106 */       break;
/*     */     case 2: 
/* 108 */       xChessActivityInfo.setToday_lose_count(xChessActivityInfo.getToday_lose_count() + 1);
/* 109 */       break;
/*     */     default: 
/* 111 */       xChessActivityInfo.setToday_draw_count(xChessActivityInfo.getToday_draw_count() + 1);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\ChessActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */