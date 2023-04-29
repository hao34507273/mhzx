/*     */ package mzm.gsp.status.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
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
/*     */ public class RoleStatusInterface
/*     */ {
/*     */   public static boolean setStatus(List<Long> roleids, int status, boolean sendStatusTip)
/*     */   {
/*  29 */     return RoleStatusManager.setRoleStatus(roleids, status, sendStatusTip);
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
/*     */   public static boolean setStatus(long roleid, int status, boolean sendStatusTip)
/*     */   {
/*  45 */     return RoleStatusManager.setRoleStatus(Arrays.asList(new Long[] { Long.valueOf(roleid) }), status, sendStatusTip);
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
/*     */   public static boolean checkCansetStatus(List<Long> roleids, int status, boolean sendStatusTip)
/*     */   {
/*  62 */     return RoleStatusManager.checkCanSetStatus(roleids, status, sendStatusTip);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean checkCansetStatus(List<Long> roleids, int status, boolean sendStatusTip, boolean retainLock)
/*     */   {
/*  74 */     return RoleStatusManager.checkCanSetStatus(roleids, status, sendStatusTip, retainLock);
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
/*     */   public static boolean checkCansetStatus(List<Long> roleids, int status, boolean sendStatusTip, List<Long> receiveTipRoleids)
/*     */   {
/*  95 */     return RoleStatusManager.checkCanSetStatus(roleids, status, sendStatusTip, receiveTipRoleids);
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
/*     */   public static boolean checkCansetStatus(List<Long> roleids, int status, boolean sendStatusTip, List<Long> receiveTipRoleids, boolean retainLock)
/*     */   {
/* 109 */     return RoleStatusManager.checkCanSetStatus(roleids, status, sendStatusTip, receiveTipRoleids, retainLock);
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
/*     */   public static boolean checkCanSetStatus(long roleid, int status, boolean sendStatusTip)
/*     */   {
/* 125 */     return RoleStatusManager.checkCanSetStatus(Arrays.asList(new Long[] { Long.valueOf(roleid) }), status, sendStatusTip);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean checkCanSetStatus(long roleid, int status, boolean sendStatusTip, boolean retainLock)
/*     */   {
/* 137 */     return RoleStatusManager.checkCanSetStatus(Arrays.asList(new Long[] { Long.valueOf(roleid) }), status, sendStatusTip, retainLock);
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
/*     */   public static boolean checkCanSetStatus(long becheckedRoleid, long receivetipRoleid, int status, boolean sendStatusTip)
/*     */   {
/* 152 */     return RoleStatusManager.checkCanSetStatus(Arrays.asList(new Long[] { Long.valueOf(becheckedRoleid) }), receivetipRoleid, status, sendStatusTip);
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
/*     */   public static boolean checkCanSetStatus(long becheckedRoleid, long receivetipRoleid, int status, boolean sendStatusTip, boolean retainLock)
/*     */   {
/* 167 */     return RoleStatusManager.checkCanSetStatus(Arrays.asList(new Long[] { Long.valueOf(becheckedRoleid) }), receivetipRoleid, status, sendStatusTip, retainLock);
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
/*     */   public static boolean unsetStatus(long roleid, int status)
/*     */   {
/* 182 */     return RoleStatusManager.unsetRoleStatus(roleid, status);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean unsetStatus(long roleid, Collection<Integer> statuses)
/*     */   {
/* 193 */     return RoleStatusManager.unsetRoleStatus(roleid, statuses);
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
/*     */   public static Map<Long, Boolean> unsetStatus(List<Long> roleids, int status)
/*     */   {
/* 207 */     return RoleStatusManager.unsetRoleStatus(roleids, status);
/*     */   }
/*     */   
/*     */   public static Map<Long, Boolean> unsetStatus(List<Long> roleids, Collection<Integer> statuses) {
/* 211 */     return RoleStatusManager.unsetRoleStatus(roleids, statuses);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Set<Integer> getStatusSet(long roleid)
/*     */   {
/* 223 */     return RoleStatusManager.getRoleStatusSet(roleid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean containsStatus(long roleid, int status)
/*     */   {
/* 235 */     return RoleStatusManager.containsStatus(roleid, status);
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
/*     */   public static boolean containsStatus(long roleid, int status, boolean retainLock)
/*     */   {
/* 248 */     return RoleStatusManager.containsStatus(roleid, status, retainLock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean containsAny(long roleid, Set<Integer> statuses, boolean retainLock)
/*     */   {
/* 260 */     return RoleStatusManager.containsAny(roleid, statuses, retainLock);
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
/*     */   public static Set<Integer> selectStatusSet(long roleid)
/*     */   {
/* 273 */     return RoleStatusManager.selectRoleStatusSet(roleid);
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
/*     */   public static Set<Integer> getToClientAllStatus(long roleid, boolean retainlock)
/*     */   {
/* 287 */     return RoleStatusManager.getToClientAllStatus(roleid, retainlock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isToClient(int status)
/*     */   {
/* 297 */     SingleGameStatus singleGameStatus = (SingleGameStatus)RoleStatusManager.statusMap.get(Integer.valueOf(status));
/* 298 */     return (singleGameStatus != null) && (singleGameStatus.isToClient());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean containsStatus(int status)
/*     */   {
/* 309 */     return RoleStatusManager.containsStatus(status);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\status\main\RoleStatusInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */