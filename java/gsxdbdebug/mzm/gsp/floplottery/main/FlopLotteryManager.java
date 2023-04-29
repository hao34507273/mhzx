/*     */ package mzm.gsp.floplottery.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.floplottery.FlopLotteryResult;
/*     */ import mzm.gsp.floplottery.SFlopLotteryContinue;
/*     */ import mzm.gsp.floplottery.SFlopLotteryError;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FlopLotteryAwardPoolResult;
/*     */ import xbean.FlopLotteryEntry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FlopLotteryManager
/*     */ {
/*  28 */   static final AtomicLong uIdGen = new AtomicLong(0L);
/*     */   
/*     */   static long getNextUId()
/*     */   {
/*  32 */     return uIdGen.addAndGet(1L);
/*     */   }
/*     */   
/*     */   static boolean handleLastFlopLottery(FlopLotteryEntry xFlopLotteryEntry, long roleId)
/*     */   {
/*  37 */     ArrayList<FlopLotteryResult> flopLotteryResultArrayList = new ArrayList();
/*  38 */     List<FlopLotteryAwardPoolResult> xFlopLotteryAwardPoolResultList = xFlopLotteryEntry.getFloplotteryawardpoolresultlist();
/*  39 */     for (FlopLotteryAwardPoolResult xFlopLotteryAwardPoolResult : xFlopLotteryAwardPoolResultList)
/*     */     {
/*  41 */       FlopLotteryResult flopLotteryResult = new FlopLotteryResult();
/*  42 */       flopLotteryResult.index = xFlopLotteryAwardPoolResult.getIndex();
/*  43 */       flopLotteryResult.awardidlist.addAll(xFlopLotteryAwardPoolResult.getResultlist());
/*  44 */       flopLotteryResultArrayList.add(flopLotteryResult);
/*     */     }
/*  46 */     return OnlineManager.getInstance().send(roleId, new SFlopLotteryContinue(xFlopLotteryEntry.getUid(), xFlopLotteryEntry.getFloplotterymaincfgid(), flopLotteryResultArrayList));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean handleError(String errorLog, String errorLogHead, long roleId, int errorCode)
/*     */   {
/*  53 */     GameServer.logger().error(errorLogHead + errorLog);
/*  54 */     if (errorCode != -1)
/*     */     {
/*  56 */       ArrayList<String> params = new ArrayList();
/*  57 */       OnlineManager.getInstance().sendAtOnce(roleId, new SFlopLotteryError(errorCode, params));
/*     */     }
/*  59 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean cutMoney(String userid, long roleId, LogReason logReason, int subReason, int moneyType, int moneyNum, CostType costType)
/*     */   {
/*  65 */     TLogArg logArg = new TLogArg(logReason, subReason);
/*  66 */     switch (moneyType)
/*     */     {
/*     */     case 3: 
/*  69 */       if (!RoleInterface.cutSilver(roleId, moneyNum, logArg))
/*     */       {
/*  71 */         return false;
/*     */       }
/*     */       break;
/*     */     case 2: 
/*  75 */       if (!RoleInterface.cutGold(roleId, moneyNum, logArg))
/*     */       {
/*  77 */         return false;
/*     */       }
/*     */       break;
/*     */     case 5: 
/*  81 */       if (!RoleInterface.cutGoldIngot(roleId, moneyNum, logArg))
/*     */       {
/*  83 */         return false;
/*     */       }
/*     */       break;
/*     */     case 1: 
/*  87 */       CostResult costResult = QingfuInterface.costYuanbao(userid, roleId, moneyNum, costType, logArg);
/*  88 */       if (costResult != CostResult.Success)
/*     */       {
/*  90 */         return false;
/*     */       }
/*     */       break;
/*     */     case 4: 
/*  94 */       if (!GangInterface.cutBangGong(roleId, moneyNum, logArg))
/*     */       {
/*  96 */         return false;
/*     */       }
/*     */       break;
/*     */     default: 
/* 100 */       return false;
/*     */     }
/* 102 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floplottery\main\FlopLotteryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */