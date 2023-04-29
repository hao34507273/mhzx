/*     */ package mzm.gsp.genderconvert.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.genderconvert.OccpationInfo;
/*     */ import mzm.gsp.genderconvert.SGenderConvertFailed;
/*     */ import mzm.gsp.genderconvert.SGenderConvertSuccess;
/*     */ import mzm.gsp.genderconvert.SyncOcpGenderInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MultiGender;
/*     */ import xtable.Multigender;
/*     */ 
/*     */ class GenderConvertManager
/*     */ {
/*  16 */   static Logger logger = null;
/*     */   
/*     */   static void init()
/*     */   {
/*  20 */     logger = Logger.getLogger("genderconvert");
/*     */   }
/*     */   
/*     */   static MultiGender getXMultiGender(long paramLong, boolean paramBoolean)
/*     */   {
/*  25 */     MultiGender localMultiGender = null;
/*  26 */     if (paramBoolean) {
/*  27 */       localMultiGender = Multigender.get(Long.valueOf(paramLong));
/*     */     } else {
/*  29 */       localMultiGender = Multigender.select(Long.valueOf(paramLong));
/*     */     }
/*  31 */     return localMultiGender;
/*     */   }
/*     */   
/*     */   static MultiGender getAndCreateXMultiGender(long paramLong, int paramInt)
/*     */   {
/*  36 */     MultiGender localMultiGender = Multigender.get(Long.valueOf(paramLong));
/*  37 */     if (localMultiGender == null)
/*     */     {
/*  39 */       localMultiGender = xbean.Pod.newMultiGender();
/*  40 */       initXMultiGender(localMultiGender, paramInt);
/*  41 */       Multigender.insert(Long.valueOf(paramLong), localMultiGender);
/*     */     }
/*  43 */     return localMultiGender;
/*     */   }
/*     */   
/*     */   static void initXMultiGender(MultiGender paramMultiGender, int paramInt)
/*     */   {
/*  48 */     if ((paramMultiGender == null) || (!paramMultiGender.getGenders().isEmpty())) {
/*  49 */       return;
/*     */     }
/*  51 */     paramMultiGender.getGenders().add(Integer.valueOf(paramInt));
/*     */   }
/*     */   
/*     */   static boolean hasGender(MultiGender paramMultiGender, int paramInt)
/*     */   {
/*  56 */     if (paramMultiGender == null) {
/*  57 */       return false;
/*     */     }
/*  59 */     return paramMultiGender.getGenders().contains(Integer.valueOf(paramInt));
/*     */   }
/*     */   
/*     */   static SyncOcpGenderInfo getSyncOcpGenderInfo(long paramLong, MultiGender paramMultiGender)
/*     */   {
/*  64 */     SyncOcpGenderInfo localSyncOcpGenderInfo = new SyncOcpGenderInfo();
/*  65 */     if (paramMultiGender != null)
/*     */     {
/*  67 */       for (Iterator localIterator1 = mzm.gsp.multioccupation.main.MultiOccupInterface.getOccupList(paramLong, false).iterator(); localIterator1.hasNext();) { localInteger1 = (Integer)localIterator1.next();
/*  68 */         for (Integer localInteger2 : paramMultiGender.getGenders()) {
/*  69 */           OccpationInfo localOccpationInfo = new OccpationInfo(localInteger1.intValue(), localInteger2.intValue());
/*  70 */           localSyncOcpGenderInfo.occpations.add(localOccpationInfo);
/*     */         } }
/*     */       Integer localInteger1;
/*  73 */       localSyncOcpGenderInfo.last_convert_time = ((int)(paramMultiGender.getSwitch_time() / 1000L));
/*  74 */       localSyncOcpGenderInfo.is_guide_open = Integer.valueOf(0).byteValue();
/*     */     }
/*  76 */     return localSyncOcpGenderInfo;
/*     */   }
/*     */   
/*     */   static void sendMultiOcpGender(long paramLong, MultiGender paramMultiGender)
/*     */   {
/*  81 */     SyncOcpGenderInfo localSyncOcpGenderInfo = getSyncOcpGenderInfo(paramLong, paramMultiGender);
/*  82 */     OnlineManager.getInstance().send(paramLong, localSyncOcpGenderInfo);
/*     */   }
/*     */   
/*     */   static void notifyActiveGenderConvert(long paramLong)
/*     */   {
/*  87 */     SGenderConvertSuccess localSGenderConvertSuccess = new SGenderConvertSuccess();
/*  88 */     OnlineManager.getInstance().send(paramLong, localSGenderConvertSuccess);
/*     */   }
/*     */   
/*     */   static void logWarn(String paramString, Object... paramVarArgs)
/*     */   {
/*  93 */     logger.warn(String.format(paramString, paramVarArgs));
/*     */   }
/*     */   
/*     */   static void logError(String paramString, Object... paramVarArgs)
/*     */   {
/*  98 */     logger.error(String.format(paramString, paramVarArgs));
/*     */   }
/*     */   
/*     */   static void logInfo(String paramString, Object... paramVarArgs)
/*     */   {
/* 103 */     logger.info(String.format(paramString, paramVarArgs));
/*     */   }
/*     */   
/*     */   static void logDebug(String paramString, Object... paramVarArgs)
/*     */   {
/* 108 */     logger.debug(String.format(paramString, paramVarArgs));
/*     */   }
/*     */   
/*     */   static void sendFailedResult(long paramLong, int paramInt)
/*     */   {
/* 113 */     SGenderConvertFailed localSGenderConvertFailed = new SGenderConvertFailed();
/* 114 */     localSGenderConvertFailed.retcode = paramInt;
/* 115 */     OnlineManager.getInstance().sendAtOnce(paramLong, localSGenderConvertFailed);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genderconvert\main\GenderConvertManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */