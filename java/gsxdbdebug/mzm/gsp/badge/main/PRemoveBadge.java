/*    */ package mzm.gsp.badge.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BadgeInfo;
/*    */ import xbean.RoleBadgesInfo;
/*    */ import xtable.Role2rolebadgesinfo;
/*    */ 
/*    */ public class PRemoveBadge extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int badgeId;
/*    */   private final boolean timeOut;
/*    */   
/*    */   public PRemoveBadge(long roleId, int badgeId)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.badgeId = badgeId;
/* 20 */     this.timeOut = true;
/*    */   }
/*    */   
/*    */   public PRemoveBadge(long roleId, int badgeId, boolean timeOut)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.badgeId = badgeId;
/* 27 */     this.timeOut = timeOut;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     RoleBadgesInfo xRoleBadgesInfo = Role2rolebadgesinfo.get(Long.valueOf(this.roleId));
/* 35 */     if (xRoleBadgesInfo == null)
/*    */     {
/* 37 */       return false;
/*    */     }
/* 39 */     BadgeInfo xBadgeInfo = (BadgeInfo)xRoleBadgesInfo.getBadgesinfo().get(Integer.valueOf(this.badgeId));
/* 40 */     if (xBadgeInfo == null)
/*    */     {
/* 42 */       GameServer.logger().error(String.format("[badge]PRemoveBadge.processImp@ no contains this badge!|roleId=%d|badgeId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.badgeId) }));
/*    */       
/*    */ 
/* 45 */       return false;
/*    */     }
/* 47 */     if (this.timeOut)
/*    */     {
/* 49 */       long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 50 */       long timeOutTime = xBadgeInfo.getTimelimit();
/* 51 */       if ((timeOutTime == 0L) || (curTime + 3000L < timeOutTime))
/*    */       {
/* 53 */         GameServer.logger().info(String.format("[badge]PRemoveBadge.processImp@ no need rm!|roleId=%d|curTime=%d|timeOut=%d|badgeId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(curTime), Long.valueOf(timeOutTime), Integer.valueOf(this.badgeId) }));
/*    */         
/*    */ 
/* 56 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 60 */     xRoleBadgesInfo.getBadgesinfo().remove(Integer.valueOf(this.badgeId));
/*    */     
/* 62 */     if (xRoleBadgesInfo.getBadgesinfo().size() == 0)
/*    */     {
/* 64 */       Role2rolebadgesinfo.remove(Long.valueOf(this.roleId));
/*    */     }
/*    */     
/* 67 */     mzm.gsp.badge.SRoleRemoveBadge pro = new mzm.gsp.badge.SRoleRemoveBadge();
/* 68 */     pro.badgeid = this.badgeId;
/* 69 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleId, pro);
/*    */     
/*    */ 
/* 72 */     BadgeManager.tlogHandBadge(this.roleId, BadgeManager.getRoleBadgeInfo(xRoleBadgesInfo), this.badgeId, 0, xBadgeInfo.getTimelimit());
/*    */     
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\badge\main\PRemoveBadge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */