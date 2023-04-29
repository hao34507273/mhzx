/*    */ package mzm.gsp.badge.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.RoleBadgesInfo;
/*    */ import xtable.Role2rolebadgesinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BadgeInterface
/*    */ {
/*    */   public static boolean addBadge(long roleId, int badgeId)
/*    */   {
/* 29 */     PAddNewBadge p = new PAddNewBadge(roleId, badgeId);
/* 30 */     return p.call();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void addBadgeNoneRealTime(long roleId, int badgeId)
/*    */   {
/* 44 */     NoneRealTimeTaskManager.getInstance().addTask(new PAddNewBadge(roleId, badgeId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isBadgeCfgExist(int badgeId)
/*    */   {
/* 57 */     return BadgeManager.isBadgeIdExist(badgeId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static Set<Integer> selectRoleBadgeIds(long roleId)
/*    */   {
/* 70 */     RoleBadgesInfo xRoleBadgesInfo = Role2rolebadgesinfo.select(Long.valueOf(roleId));
/* 71 */     if (xRoleBadgesInfo == null)
/*    */     {
/* 73 */       return new HashSet();
/*    */     }
/* 75 */     return xRoleBadgesInfo.getBadgesinfo().keySet();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\badge\main\BadgeInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */