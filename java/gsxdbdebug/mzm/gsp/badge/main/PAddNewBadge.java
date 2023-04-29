/*    */ package mzm.gsp.badge.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.badge.SRoleGetNewBadge;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.BadgeInfo;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleBadgesInfo;
/*    */ import xtable.Role2rolebadgesinfo;
/*    */ 
/*    */ 
/*    */ public class PAddNewBadge
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int badgeId;
/*    */   
/*    */   public PAddNewBadge(long roleId, int badgeId)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.badgeId = badgeId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (!BadgeManager.isBadgeIdExist(this.badgeId))
/*    */     {
/*    */ 
/* 31 */       return false;
/*    */     }
/* 33 */     RoleBadgesInfo xRoleBadgesInfo = Role2rolebadgesinfo.get(Long.valueOf(this.roleId));
/* 34 */     if (xRoleBadgesInfo == null)
/*    */     {
/* 36 */       xRoleBadgesInfo = Pod.newRoleBadgesInfo();
/* 37 */       Role2rolebadgesinfo.insert(Long.valueOf(this.roleId), xRoleBadgesInfo);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 44 */     long timeLimt = BadgeManager.getRoleBadgeEndTime(this.badgeId);
/* 45 */     if (timeLimt < 0L)
/*    */     {
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     BadgeInfo xBadgeInfo = Pod.newBadgeInfo();
/* 51 */     xBadgeInfo.setBadgeid(this.badgeId);
/* 52 */     xBadgeInfo.setTimelimit(timeLimt);
/*    */     
/* 54 */     long time = BadgeManager.getBadgeTimeCfg(this.badgeId);
/* 55 */     BadgeSession session = new BadgeSession(time, this.roleId, this.badgeId);
/* 56 */     long sessionId = session.getSessionId();
/* 57 */     if (sessionId <= 0L)
/*    */     {
/*    */ 
/* 60 */       return false;
/*    */     }
/* 62 */     xBadgeInfo.setSessionid(sessionId);
/*    */     
/* 64 */     xRoleBadgesInfo.getBadgesinfo().put(Integer.valueOf(this.badgeId), xBadgeInfo);
/*    */     
/* 66 */     SRoleGetNewBadge pro = new SRoleGetNewBadge();
/* 67 */     pro.badgeid = this.badgeId;
/* 68 */     pro.timelimit = ((int)(timeLimt / 1000L));
/* 69 */     OnlineManager.getInstance().send(this.roleId, pro);
/*    */     
/*    */ 
/* 72 */     BadgeManager.tlogHandBadge(this.roleId, BadgeManager.getRoleBadgeInfo(xRoleBadgesInfo), this.badgeId, 1, timeLimt);
/* 73 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\badge\main\PAddNewBadge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */