/*     */ package mzm.gsp.buff.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.RoleBuffList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BuffInterface
/*     */ {
/*     */   public static boolean installBuff(long roleId, int buffId)
/*     */   {
/*  21 */     return BuffManager.installBuff(roleId, buffId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void installBuffAsyc(long roleId, int buffId)
/*     */   {
/*  32 */     NoneRealTimeTaskManager.getInstance().addTask(new PInstalBuff(roleId, buffId));
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
/*     */   public static boolean installIDIPBuff(long roleId, int buffId, int multiple, long endTime)
/*     */   {
/*  48 */     return BuffManager.installIDIPBuff(roleId, buffId, multiple, endTime);
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
/*     */   public static void installIDIPBuffAsyc(long roleId, int buffId, int multiple, long leftTime)
/*     */   {
/*  63 */     NoneRealTimeTaskManager.getInstance().addTask(new PInstalIDIPBuff(roleId, buffId, multiple, leftTime));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean uninstallBuf(long roleId, int buffId)
/*     */   {
/*  75 */     return BuffManager.uninstallBuff(roleId, buffId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void uninstallBufWithType(long roleId, int type)
/*     */   {
/*  87 */     BuffManager.uninstallBuffWithType(roleId, type);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void uninstallBufWithTypeAsyc(long roleId, int type)
/*     */   {
/*  99 */     NoneRealTimeTaskManager.getInstance().addTask(new PUninstallBuffWithType(roleId, type));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void uninstallBufAsyc(long roleId, int buffId)
/*     */   {
/* 110 */     NoneRealTimeTaskManager.getInstance().addTask(new PUninstallBuff(roleId, buffId));
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
/*     */   public static int getCollisionBuff(long roleId, int buffId)
/*     */   {
/* 123 */     return BuffManager.getCollisionBuff(roleId, buffId);
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
/*     */   public static boolean isContainBuff(long roleId, List<Integer> buffIdList)
/*     */   {
/* 138 */     List<Integer> copyList = new ArrayList(buffIdList);
/* 139 */     return BuffManager.containBuff(roleId, copyList);
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
/*     */   public static List<Integer> contains(long roleid, List<Integer> buffids, boolean retainLock)
/*     */   {
/* 153 */     if (buffids == null)
/*     */     {
/* 155 */       return Collections.emptyList();
/*     */     }
/* 157 */     if (buffids.isEmpty())
/*     */     {
/* 159 */       return Collections.emptyList();
/*     */     }
/* 161 */     return BuffManager.contains(roleid, buffids, retainLock);
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
/*     */   public static boolean isContainBuff(long roleId, int buffId)
/*     */   {
/* 176 */     List<Integer> list = new ArrayList();
/* 177 */     list.add(Integer.valueOf(buffId));
/* 178 */     return isContainBuff(roleId, list);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerBuffChange(Integer buffCfgId, BuffChangeHandler buffChangeHandler)
/*     */   {
/* 190 */     BuffManager.registerBuffChangeImpl(buffCfgId, buffChangeHandler);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void unRegisterBuffChange(Integer buffCfgId)
/*     */   {
/* 201 */     BuffManager.unRegisterBuffChangeImpl(buffCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> getRoleRewardBuff(long roleId)
/*     */   {
/* 211 */     return BuffManager.getRewardBuffIdSet(roleId);
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
/*     */   public static ProfitResult getProfitEffect(long roleId, int profigType, Set<Integer> conditionList)
/*     */   {
/* 227 */     return BuffManager.getProfitEffect(roleId, profigType, conditionList);
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
/*     */   public static ProfitResult getProfitEffect(long roleId, int profigType)
/*     */   {
/* 241 */     ProfitResult profitResult = new ProfitResult();
/* 242 */     List<RoleBuffList> xAllBuffs = BuffManager.getRoleAllBuffs(roleId, false);
/* 243 */     if (xAllBuffs == null)
/*     */     {
/* 245 */       return profitResult;
/*     */     }
/* 247 */     return BuffManager.getProfitEffect(roleId, profitResult, profigType, -1, xAllBuffs);
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
/*     */   public static void uninstallBuffs(long roleid)
/*     */   {
/* 260 */     BuffManager.uninstallBuffs(roleid);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\BuffInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */