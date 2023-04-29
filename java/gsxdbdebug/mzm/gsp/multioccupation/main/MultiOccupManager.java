/*     */ package mzm.gsp.multioccupation.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.multioccupation.SActiveNewOccupationRes;
/*     */ import mzm.gsp.multioccupation.SMultiOccupationRes;
/*     */ import mzm.gsp.multioccupation.SSwitchOccupationRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MultiOccupation;
/*     */ import xtable.Multioccupation;
/*     */ 
/*     */ class MultiOccupManager
/*     */ {
/*     */   static final String TLOG_ACTIVATE = "ActivateNewOccupation";
/*     */   static final String TLOG_SWITCH = "SwitchOccupation";
/*  16 */   static Logger logger = null;
/*     */   
/*     */   static void init() {
/*  19 */     logger = Logger.getLogger("multioccup");
/*     */   }
/*     */   
/*     */   static MultiOccupation getXMultiOccup(long roleid, boolean remainLock) {
/*  23 */     MultiOccupation xMultiOccup = null;
/*  24 */     if (remainLock) {
/*  25 */       xMultiOccup = Multioccupation.get(Long.valueOf(roleid));
/*     */     }
/*     */     else {
/*  28 */       xMultiOccup = Multioccupation.select(Long.valueOf(roleid));
/*     */     }
/*  30 */     return xMultiOccup;
/*     */   }
/*     */   
/*     */   static MultiOccupation getAndCreateXMultiOccup(long roleid, int currentOccup)
/*     */   {
/*  35 */     MultiOccupation xMultiOccup = Multioccupation.get(Long.valueOf(roleid));
/*  36 */     if (xMultiOccup == null) {
/*  37 */       xMultiOccup = xbean.Pod.newMultiOccupation();
/*  38 */       initXMultiOccup(xMultiOccup, currentOccup);
/*  39 */       Multioccupation.insert(Long.valueOf(roleid), xMultiOccup);
/*     */     }
/*  41 */     return xMultiOccup;
/*     */   }
/*     */   
/*     */   static void initXMultiOccup(MultiOccupation xMultiOccup, int occupation) {
/*  45 */     if ((xMultiOccup == null) || (!xMultiOccup.getOccupations().isEmpty())) {
/*  46 */       return;
/*     */     }
/*  48 */     xMultiOccup.getOccupations().add(Integer.valueOf(occupation));
/*     */   }
/*     */   
/*     */   static boolean hasOccup(MultiOccupation xMultiOccup, int occup) {
/*  52 */     if (xMultiOccup == null) {
/*  53 */       return false;
/*     */     }
/*  55 */     return xMultiOccup.getOccupations().contains(Integer.valueOf(occup));
/*     */   }
/*     */   
/*     */   static SMultiOccupationRes getSMultiOccupationRes(MultiOccupation xMultiOccup)
/*     */   {
/*  60 */     SMultiOccupationRes res = new SMultiOccupationRes();
/*  61 */     if (xMultiOccup != null) {
/*  62 */       res.activated_occpations.addAll(xMultiOccup.getOccupations());
/*  63 */       res.activate_time = xMultiOccup.getActivate_time();
/*  64 */       res.switch_time = xMultiOccup.getSwitch_time();
/*     */     }
/*  66 */     return res;
/*     */   }
/*     */   
/*     */   static void sendMultiOccup(long roleid, MultiOccupation xMultiOccup) {
/*  70 */     SMultiOccupationRes res = getSMultiOccupationRes(xMultiOccup);
/*  71 */     OnlineManager.getInstance().send(roleid, res);
/*     */   }
/*     */   
/*     */   static void notifyActiveNewOccup(long roleid, int newOccup) {
/*  75 */     SActiveNewOccupationRes res = new SActiveNewOccupationRes();
/*  76 */     res.new_occupation = newOccup;
/*  77 */     OnlineManager.getInstance().send(roleid, res);
/*     */   }
/*     */   
/*     */   static void sendSwitchOccup(long roleid, int newOccup) {
/*  81 */     SSwitchOccupationRes res = new SSwitchOccupationRes();
/*  82 */     res.new_occupation = newOccup;
/*  83 */     OnlineManager.getInstance().send(roleid, res);
/*     */   }
/*     */   
/*     */   static void logWarn(String formatStr, Object... args) {
/*  87 */     logger.warn(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logError(String formatStr, Object... args) {
/*  91 */     logger.error(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logInfo(String formatStr, Object... args) {
/*  95 */     logger.info(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void logDebug(String formatStr, Object... args) {
/*  99 */     logger.debug(String.format(formatStr, args));
/*     */   }
/*     */   
/*     */   static void sendNormalResult(long roleid, int result) {
/* 103 */     mzm.gsp.multioccupation.SMultiOccupationNormalResult p = new mzm.gsp.multioccupation.SMultiOccupationNormalResult();
/* 104 */     p.result = result;
/* 105 */     OnlineManager.getInstance().sendAtOnce(roleid, p);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multioccupation\main\MultiOccupManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */