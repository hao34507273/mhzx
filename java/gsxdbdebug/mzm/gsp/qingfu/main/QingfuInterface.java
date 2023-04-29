/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import openau.ApplyOrderIdArg;
/*     */ import openau.ApplyOrderIdRes;
/*     */ import openau.DataBetweenAuanyAndOthersRep;
/*     */ import openau.DataBetweenAuanyAndOthersReq;
/*     */ import openau.DelFailureOrderArg;
/*     */ import openau.DelFailureOrderRes;
/*     */ 
/*     */ public class QingfuInterface
/*     */ {
/*     */   public static void onApplyOrderAck(ApplyOrderIdArg arg, ApplyOrderIdRes res)
/*     */   {
/*  15 */     QingfuManager.onApplyOrderAck(arg, res);
/*     */   }
/*     */   
/*     */   public static void onApplyOrderTimeout(ApplyOrderIdArg arg)
/*     */   {
/*  20 */     QingfuManager.onApplyOrderTimeout(arg);
/*     */   }
/*     */   
/*     */   public static void onDelFailtureOrderAck(DelFailureOrderArg arg, DelFailureOrderRes res)
/*     */   {
/*  25 */     QingfuManager.onDelFailtureOrderAck(arg, res);
/*     */   }
/*     */   
/*     */   public static void onDelFailtureOrderTimeut(DelFailureOrderArg arg)
/*     */   {
/*  30 */     QingfuManager.onDelFailtureOrderTimeout(arg);
/*     */   }
/*     */   
/*     */   public static void onDataBetweenAuanyAndOthersReq(DataBetweenAuanyAndOthersReq req)
/*     */   {
/*  35 */     QingfuManager.onDataBetweenAuanyAndOthersReq(req);
/*     */   }
/*     */   
/*     */   public static void onDataBetweenAuanyAndOthersRep(DataBetweenAuanyAndOthersRep rep)
/*     */   {
/*  40 */     QingfuManager.onDataBetweenAuanyAndOthersRep(rep);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getSuitableRoleId(String userid)
/*     */   {
/*  51 */     return QingfuManager.getSuitableRoleId(userid).longValue();
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
/*     */   public static long getSaveAmt(String userid, boolean isHoldLock)
/*     */   {
/*  66 */     return QingfuManager.getSaveAmt(userid, isHoldLock);
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
/*     */   public static long getTssBuyTimes(String userid, int serviceid, boolean isHoldLock)
/*     */   {
/*  80 */     return QingfuManager.getTssBuyTimes(userid, serviceid, isHoldLock);
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
/*     */   public static PresentInnerSaveAmtResult presentInnerSaveAmt(String userid, int value)
/*     */   {
/*  94 */     return QingfuManager.presentInnerSaveAmt(userid, value);
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
/*     */   public static long getBalance(String userid, boolean isHoldLock)
/*     */   {
/* 109 */     return QingfuManager.getBalance(userid, isHoldLock);
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
/*     */   public static long getYuanbao(String userid, boolean isHoldLock)
/*     */   {
/* 124 */     return QingfuManager.getYuanbao(userid, isHoldLock);
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
/*     */   public static long getBindYuanbao(String userid, boolean isHoldLock)
/*     */   {
/* 139 */     return QingfuManager.getBindYuanbao(userid, isHoldLock);
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
/*     */   public static long getTotalCash(String userid, boolean isHoldLock)
/*     */   {
/* 154 */     return QingfuManager.getTotalCash(userid, isHoldLock);
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
/*     */   public static long getTotalPresent(String userid, boolean isHoldLock)
/*     */   {
/* 169 */     return QingfuManager.getTotalPresent(userid, isHoldLock);
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
/*     */   public static long getTotalPresentBind(String userid, boolean isHoldLock)
/*     */   {
/* 184 */     return QingfuManager.getTotalPresentBind(userid, isHoldLock);
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
/*     */   public static long getTotalCost(String userid, boolean isHoldLock)
/*     */   {
/* 199 */     return QingfuManager.getTotalCost(userid, isHoldLock);
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
/*     */   public static long getTotalCostBind(String userid, boolean isHoldLock)
/*     */   {
/* 214 */     return QingfuManager.getTotalCostBind(userid, isHoldLock);
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
/*     */   public static CostResult costYuanbao(String userid, long roleid, int costValue, CostType costType, TLogArg tLogArg)
/*     */   {
/* 235 */     return QingfuManager.costYuanbao(userid, roleid, costValue, costType, tLogArg);
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
/*     */   public static PresentResult presentYuanbao(String userid, long roleid, int presentValue, PresentType presentType, TLogArg tLogArg)
/*     */   {
/* 256 */     return QingfuManager.presentYuanbao(userid, roleid, presentValue, presentType, tLogArg);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\QingfuInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */