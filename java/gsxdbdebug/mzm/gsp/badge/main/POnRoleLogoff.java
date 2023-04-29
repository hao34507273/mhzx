/*    */ package mzm.gsp.badge.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xbean.BadgeInfo;
/*    */ import xbean.RoleBadgesInfo;
/*    */ import xtable.Role2rolebadgesinfo;
/*    */ 
/*    */ 
/*    */ public class POnRoleLogoff
/*    */   extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     RoleBadgesInfo xRoleBadgesInfo = Role2rolebadgesinfo.select((Long)this.arg);
/* 18 */     if (xRoleBadgesInfo == null)
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     xRoleBadgesInfo = Role2rolebadgesinfo.get((Long)this.arg);
/* 23 */     for (BadgeInfo xBadgeInfo : xRoleBadgesInfo.getBadgesinfo().values())
/*    */     {
/* 25 */       long sessionid = xBadgeInfo.getSessionid();
/* 26 */       if (sessionid > 0L)
/*    */       {
/*    */ 
/*    */ 
/* 30 */         Session session = Session.getSession(sessionid);
/* 31 */         if ((session == null) || (!(session instanceof BadgeSession)))
/*    */         {
/* 33 */           return false;
/*    */         }
/* 35 */         Session.removeSession(sessionid);
/* 36 */         xBadgeInfo.setSessionid(0L);
/*    */       } }
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\badge\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */