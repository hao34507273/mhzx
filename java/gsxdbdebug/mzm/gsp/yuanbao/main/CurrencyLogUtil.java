/*     */ package mzm.gsp.yuanbao.main;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogManager;
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
/*     */ public class CurrencyLogUtil
/*     */ {
/*     */   public static final String LOG_CURRENCY = "currency";
/*     */   public static final String TLOG_CURRENCY = "Currency";
/*     */   public static final String TLOG_MoneyFlow = "MoneyFlow";
/*     */   
/*     */   public static void logCurrency(long roleId, CurrencyType currencyType, int changeNum, long leftNum, TLogArg logArg)
/*     */   {
/*  27 */     String userid = RoleInterface.getUserId(roleId);
/*     */     
/*  29 */     logCurrency(userid, roleId, currencyType, changeNum, leftNum, logArg);
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
/*     */   public static void logCurrency(String userId, long roleId, CurrencyType currencyType, int changeNum, long leftNum, TLogArg logArg)
/*     */   {
/*  47 */     int platform = RoleInterface.getPlatform(roleId);
/*  48 */     String channel = RoleInterface.getChannel(roleId);
/*  49 */     String mac = RoleInterface.getMac(roleId);
/*     */     
/*  51 */     int rolelevel = RoleInterface.getLevel(roleId);
/*  52 */     int viplevel = rolelevel;
/*  53 */     int itemChangeCount = logArg.getItemChangeCount();
/*  54 */     Object[] columnns = { Integer.valueOf(platform), channel, mac, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(currencyType.value), Integer.valueOf(logArg.logReason.value), Integer.valueOf(changeNum), Long.valueOf(leftNum), Integer.valueOf(logArg.subReason), Integer.valueOf(viplevel), Integer.valueOf(itemChangeCount) };
/*     */     
/*     */ 
/*  57 */     LogManager.getInstance().addLog("currency", columnns);
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
/*     */   public static void tLogCurrency(long roleId, CurrencyType currencyType, int changeNum, long leftNum, TLogArg logArg)
/*     */   {
/*  73 */     String userId = RoleInterface.getUserId(roleId);
/*  74 */     tLogCurrency(userId, roleId, currencyType, changeNum, leftNum, logArg);
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
/*     */   public static void tLogCurrency(String userId, long roleId, CurrencyType currencyType, int changeNum, long leftNum, TLogArg logArg)
/*     */   {
/*  90 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/*  92 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/*  94 */     Object[] columnns = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(currencyType.value), Integer.valueOf(changeNum), Integer.valueOf(logArg.logReason.value), Long.valueOf(leftNum) };
/*     */     
/*     */ 
/*  97 */     TLogManager.getInstance().addLog(roleId, "Currency", columnns);
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
/*     */   public static void tlogMoneyFlow(long roleId, CurrencyType currencyType, int changeNum, long leftNum, TLogArg logArg)
/*     */   {
/* 112 */     long sequence = logArg.sequence;
/* 113 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 115 */     long AfterMoney = leftNum;
/* 116 */     int iMoney = Math.abs(changeNum);
/* 117 */     int Reason = logArg.logReason.value;
/* 118 */     long SubReason = logArg.getSubReason();
/* 119 */     int iMoneyType = currencyType.value;
/* 120 */     int AddOrReduce = changeNum > 0 ? 0 : 1;
/*     */     
/* 122 */     Object[] columnns = { Long.valueOf(sequence), Integer.valueOf(rolelevel), Long.valueOf(AfterMoney), Integer.valueOf(iMoney), Integer.valueOf(Reason), Long.valueOf(SubReason), Integer.valueOf(AddOrReduce), Integer.valueOf(iMoneyType), Long.valueOf(roleId) };
/*     */     
/*     */ 
/* 125 */     TLogManager.getInstance().addLog(roleId, "MoneyFlow", columnns);
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
/*     */   public static void tlogMoneyFlow(String userId, long roleId, CurrencyType currencyType, int changeNum, long leftNum, TLogArg logArg)
/*     */   {
/* 141 */     tlogMoneyFlow(roleId, currencyType, changeNum, leftNum, logArg);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\yuanbao\main\CurrencyLogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */