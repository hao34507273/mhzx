/*     */ package mzm.gsp.storageexp.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.SSendAwardInfoWithStorageExp;
/*     */ import mzm.gsp.award.confbean.StorageExpConsts;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.backgame.main.BackGameInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.StorageExp;
/*     */ import xtable.Role2storageexp;
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
/*     */ public class StorageExpInterface
/*     */ {
/*     */   private static final int WAN = 10000;
/*     */   
/*     */   public static long getCurCanUseStorageExp(long roleId)
/*     */   {
/*  34 */     Long curStorageExp = Role2storageexp.selectStorageexp(Long.valueOf(roleId));
/*  35 */     return curStorageExp == null ? 0L : curStorageExp.longValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addStorageExp(long roleId, int exp)
/*     */   {
/*  47 */     StorageExpManager.addStorageExp(roleId, exp);
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
/*     */   public static ModStorageExpRes addCanUseStorageExp(long roleId, int addExpNum, boolean activeGet)
/*     */   {
/*  65 */     return StorageExpManager.addCanUseStorExp(roleId, addExpNum, activeGet, false);
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
/*     */   public static boolean award(String userid, long roleId, AwardModel awardModel, AwardReason reason)
/*     */   {
/*  78 */     int needStorageExp = getNeedStorageExp(roleId, awardModel.getRoleExp());
/*     */     
/*  80 */     StorageExp xStorageExp = Role2storageexp.get(Long.valueOf(roleId));
/*  81 */     if ((xStorageExp != null) && (xStorageExp.getStorageexp() > 0L))
/*     */     {
/*  83 */       long totalStorage = xStorageExp.getStorageexp();
/*  84 */       long reminStorage = totalStorage - needStorageExp;
/*  85 */       if (reminStorage < 0L)
/*     */       {
/*  87 */         needStorageExp = (int)totalStorage;
/*     */       }
/*  89 */       xStorageExp.setStorageexp(totalStorage - needStorageExp);
/*  90 */       RoleInterface.addExp(userid, roleId, needStorageExp, new TLogArg(reason.getLogReason()));
/*  91 */       StorageExpManager.synStorage2Client(roleId, xStorageExp);
/*     */       
/*  93 */       boolean res = AwardInterface.awardToRoleByAwardModel(userid, roleId, awardModel, false, false, reason);
/*  94 */       if (!res)
/*     */       {
/*  96 */         GameServer.logger().error(String.format("[storageexp]StorageExpInterface.award@ do award failed!|roleId=%d|awardModel=%s", new Object[] { Long.valueOf(roleId), awardModel }));
/*     */         
/*     */ 
/*  99 */         return false;
/*     */       }
/*     */       
/* 102 */       SSendAwardInfoWithStorageExp sSendAwardInfoWithStorageExp = new SSendAwardInfoWithStorageExp();
/* 103 */       sSendAwardInfoWithStorageExp.addexp = needStorageExp;
/* 104 */       AwardInterface.fillAwardBean(sSendAwardInfoWithStorageExp.awardinfo, awardModel);
/* 105 */       OnlineManager.getInstance().send(roleId, sSendAwardInfoWithStorageExp);
/* 106 */       return true;
/*     */     }
/* 108 */     return AwardInterface.awardToRoleByAwardModel(userid, roleId, awardModel, false, true, reason);
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
/*     */   private static int getNeedStorageExp(long roleId, int awardRoleExp)
/*     */   {
/* 124 */     int backGameRate = BackGameInterface.getBackGameStorage2ExpRate(roleId);
/* 125 */     int baseRate = StorageExpConsts.getInstance().STORAGE_2_EXP_RATE;
/* 126 */     return (backGameRate + baseRate) * awardRoleExp / 10000;
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
/*     */   public static StorageExpOperResult addStorageForAqIdip(long roleId, int exp)
/*     */   {
/* 140 */     if (exp <= 0)
/* 141 */       return StorageExpOperResult.STORAGEEXP_NUM_ERROR;
/* 142 */     StorageExp xStorageExp = Role2storageexp.get(Long.valueOf(roleId));
/* 143 */     if (xStorageExp == null)
/*     */     {
/* 145 */       xStorageExp = Pod.newStorageExp();
/* 146 */       Role2storageexp.add(Long.valueOf(roleId), xStorageExp);
/*     */     }
/* 148 */     long lastExp = Math.min(xStorageExp.getStorageexp() + exp, StorageExpConsts.getInstance().STORAGE_LIMIT);
/* 149 */     long addExp = lastExp - xStorageExp.getStorageexp();
/*     */     
/* 151 */     StorageExpManager.addCanUseStorExp(roleId, xStorageExp, (int)addExp, lastExp, false);
/* 152 */     return StorageExpOperResult.SUCCESS;
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
/*     */   public static StorageExpOperResult cutStorageExpForAqIdip(long roleId, int exp)
/*     */   {
/* 166 */     if (exp <= 0)
/* 167 */       return StorageExpOperResult.STORAGEEXP_NUM_ERROR;
/* 168 */     StorageExp xStorageExp = Role2storageexp.get(Long.valueOf(roleId));
/* 169 */     if (xStorageExp == null)
/*     */     {
/* 171 */       return StorageExpOperResult.STORAGEEXP_CLEAR_FOR_AQIDIP;
/*     */     }
/* 173 */     long beginValue = xStorageExp.getStorageexp();
/* 174 */     long endValue = beginValue - exp;
/*     */     
/* 176 */     StorageExpOperResult res = null;
/*     */     
/* 178 */     if (endValue < 0L)
/*     */     {
/* 180 */       xStorageExp.setStorageexp(0L);
/* 181 */       res = StorageExpOperResult.STORAGEEXP_CLEAR_FOR_AQIDIP;
/*     */     }
/*     */     else
/*     */     {
/* 185 */       xStorageExp.setStorageexp(endValue);
/* 186 */       res = StorageExpOperResult.SUCCESS;
/*     */     }
/*     */     
/* 189 */     StorageExpManager.synStorage2Client(roleId, xStorageExp);
/* 190 */     return res;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\main\StorageExpInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */