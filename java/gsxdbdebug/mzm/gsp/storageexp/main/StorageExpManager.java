/*     */ package mzm.gsp.storageexp.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.SSyncStorageExp;
/*     */ import mzm.gsp.award.SSyncStorageExpChange;
/*     */ import mzm.gsp.award.confbean.StorageExpConsts;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.StorageExp;
/*     */ import xtable.Role2storageexp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class StorageExpManager
/*     */ {
/*  28 */   private static StorageExpManager instance = new StorageExpManager();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static StorageExpManager getInstance()
/*     */   {
/*  38 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void init() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getDiffDay(long now, long before)
/*     */   {
/*  54 */     Calendar nowCal = Calendar.getInstance();
/*  55 */     Calendar beforeCal = Calendar.getInstance();
/*  56 */     nowCal.setTimeInMillis(now);
/*  57 */     beforeCal.setTimeInMillis(before);
/*  58 */     return Math.abs(nowCal.get(6) - beforeCal.get(6));
/*     */   }
/*     */   
/*     */   static void update(long roleId, StorageExp xStorageExp)
/*     */   {
/*  63 */     xStorageExp.setLastupdate(DateTimeUtils.getCurrTimeInMillis());
/*  64 */     int addStorageExp = (int)xStorageExp.getNeedupdatestorageexp();
/*  65 */     long addExp = Math.min(xStorageExp.getStorageexp() + addStorageExp, StorageExpConsts.getInstance().STORAGE_LIMIT);
/*  66 */     xStorageExp.setNeedupdatestorageexp(0L);
/*  67 */     if (addExp <= 0L)
/*     */     {
/*  69 */       return;
/*     */     }
/*  71 */     addCanUseStorExp(roleId, xStorageExp, addStorageExp, addExp, true);
/*     */   }
/*     */   
/*     */   static void addCanUseStorExp(long roleId, StorageExp xStorageExp, int storAddNum, long addExpLast, boolean needMail)
/*     */   {
/*  76 */     if (isAddStorageExpSwitchOpen())
/*     */     {
/*  78 */       xStorageExp.setStorageexp(addExpLast);
/*  79 */       newUseStorageExpNotic(roleId, storAddNum);
/*  80 */       if (needMail)
/*     */       {
/*  82 */         sendStorageExpAddTipMail(roleId, storAddNum);
/*     */       }
/*     */     }
/*  85 */     synStorage2Client(roleId, xStorageExp);
/*     */   }
/*     */   
/*     */   static void synStorage2Client(long roleId, StorageExp xStorageExp)
/*     */   {
/*  90 */     SSyncStorageExp sSyncStorageExp = new SSyncStorageExp();
/*  91 */     sSyncStorageExp.newstorageexp = xStorageExp.getStorageexp();
/*  92 */     OnlineManager.getInstance().send(roleId, sSyncStorageExp);
/*     */   }
/*     */   
/*     */   static void newUseStorageExpNotic(long roleId, int addStorageExp)
/*     */   {
/*  97 */     SSyncStorageExpChange sSyncStorageExpChange = new SSyncStorageExpChange();
/*  98 */     sSyncStorageExpChange.newstorageexp = addStorageExp;
/*  99 */     OnlineManager.getInstance().send(roleId, sSyncStorageExpChange);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getStorageMailId()
/*     */   {
/* 109 */     return StorageExpConsts.getInstance().STORAGE_EXP_TIP_MAILID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendStorageExpAddTipMail(long roleId, int needStorageExp)
/*     */   {
/* 120 */     if (needStorageExp <= 0)
/*     */     {
/* 122 */       return;
/*     */     }
/* 124 */     List<String> contentArgs = new ArrayList();
/* 125 */     contentArgs.add(String.valueOf(needStorageExp));
/* 126 */     TLogArg logArg = new TLogArg(LogReason.AWARD_STORAGE_EXP_TIP_MAIL);
/* 127 */     MailInterface.synBuildAndSendMail(roleId, getStorageMailId(), new ArrayList(), contentArgs, logArg);
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
/*     */   static void addStorageExp(long roleId, int exp)
/*     */   {
/* 140 */     if (!isAddStorageExpSwitchOpen())
/*     */     {
/* 142 */       return;
/*     */     }
/* 144 */     if (exp <= 0)
/*     */     {
/* 146 */       return;
/*     */     }
/*     */     
/* 149 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/* 151 */       return;
/*     */     }
/* 153 */     StorageExp xStorageExp = Role2storageexp.get(Long.valueOf(roleId));
/* 154 */     if (xStorageExp == null)
/*     */     {
/* 156 */       xStorageExp = Pod.newStorageExp();
/* 157 */       Role2storageexp.add(Long.valueOf(roleId), xStorageExp);
/*     */     }
/* 159 */     if (StorageStateCache.getInstance().isOnlineState(roleId))
/*     */     {
/* 161 */       long addExp = Math.min(xStorageExp.getNeedupdatestorageexp() + exp, StorageExpConsts.getInstance().STORAGE_LIMIT);
/* 162 */       xStorageExp.setNeedupdatestorageexp(addExp);
/* 163 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 165 */         GameServer.logger().debug(String.format("[storageexp]StorageExpManager.addStorageExp@ add to cache!|roleId=%d|addExp=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(addExp) }));
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 172 */       addCanUseStorExp(roleId, exp, false, false);
/* 173 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 175 */         GameServer.logger().debug(String.format("[storageexp]StorageExpManager.addStorageExp@ add to can use!|roleId=%d|addExp=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(exp) }));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static ModStorageExpRes addCanUseStorExp(long roleId, int addExpNum, boolean activeGet, boolean needMail)
/*     */   {
/* 185 */     ModStorageExpRes res = new ModStorageExpRes();
/* 186 */     if (!isAddStorageExpSwitchOpen())
/*     */     {
/* 188 */       res.setRes(ModStorageExpRes.ModRes.ERROR_ADD_STORE_EXP_SWITCH_CLOSED);
/* 189 */       return res;
/*     */     }
/* 191 */     if (addExpNum < 0)
/*     */     {
/* 193 */       res.setRes(ModStorageExpRes.ModRes.ERROR_STOR_EXP_NUM_SIGN);
/* 194 */       return res;
/*     */     }
/* 196 */     StorageExp xStorageExp = Role2storageexp.get(Long.valueOf(roleId));
/* 197 */     if (xStorageExp == null)
/*     */     {
/* 199 */       res.setRes(ModStorageExpRes.ModRes.ERROR_STOR_EXP_NO_XDATA);
/* 200 */       return res;
/*     */     }
/* 202 */     long oldNum = xStorageExp.getStorageexp();
/* 203 */     long addLastSum = oldNum + addExpNum;
/* 204 */     long realAddExp = addExpNum;
/* 205 */     if (addLastSum > StorageExpConsts.getInstance().STORAGE_LIMIT)
/*     */     {
/* 207 */       if (activeGet)
/*     */       {
/* 209 */         res.setRes(ModStorageExpRes.ModRes.ERROR_STOR_EXP_NUM_HAS_REACH_TOP_LIMIT);
/* 210 */         return res;
/*     */       }
/*     */       
/*     */ 
/* 214 */       addLastSum = StorageExpConsts.getInstance().STORAGE_LIMIT;
/* 215 */       realAddExp = addLastSum - oldNum;
/* 216 */       AwardInterface.sendNormalRet(roleId, 26, false, new String[0]);
/*     */     }
/*     */     
/* 219 */     addCanUseStorExp(roleId, xStorageExp, (int)realAddExp, addLastSum, needMail);
/* 220 */     res.setModValue(realAddExp);
/* 221 */     res.setbSucceed(true);
/* 222 */     return res;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isAddStorageExpSwitchOpen()
/*     */   {
/* 232 */     return !OpenInterface.getOpenStatus(555);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\main\StorageExpManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */