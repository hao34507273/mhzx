/*    */ package mzm.gsp.badge.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.badge.SSynRoleBadgesInfo;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.RoleBadgesInfo;
/*    */ import xtable.Role2rolebadgesinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     RoleBadgesInfo xRoleBadgesInfo = Role2rolebadgesinfo.select((Long)this.arg);
/* 24 */     if (xRoleBadgesInfo == null)
/*    */     {
/* 26 */       return false;
/*    */     }
/* 28 */     xRoleBadgesInfo = Role2rolebadgesinfo.get((Long)this.arg);
/* 29 */     SSynRoleBadgesInfo pro = new SSynRoleBadgesInfo();
/*    */     
/* 31 */     Iterator<Map.Entry<Integer, xbean.BadgeInfo>> it = xRoleBadgesInfo.getBadgesinfo().entrySet().iterator();
/* 32 */     while (it.hasNext())
/*    */     {
/* 34 */       Map.Entry<Integer, xbean.BadgeInfo> entry = (Map.Entry)it.next();
/* 35 */       int badgeId = ((Integer)entry.getKey()).intValue();
/* 36 */       xbean.BadgeInfo xBadgeInfo = (xbean.BadgeInfo)entry.getValue();
/* 37 */       long timeLimt = xBadgeInfo.getTimelimit();
/* 38 */       if (timeLimt > 0L)
/*    */       {
/*    */ 
/*    */ 
/* 42 */         long nowTime = DateTimeUtils.getCurrTimeInMillis();
/* 43 */         if (nowTime < timeLimt)
/*    */         {
/* 45 */           long time = (timeLimt - nowTime) / 1000L;
/* 46 */           mzm.gsp.badge.BadgeInfo pBadge = startBadgeSession(xBadgeInfo, timeLimt, time);
/* 47 */           if (pBadge == null)
/*    */           {
/* 49 */             return false;
/*    */           }
/* 51 */           pro.badgesinfo.add(pBadge);
/*    */ 
/*    */         }
/*    */         else
/*    */         {
/* 56 */           it.remove();
/*    */           
/* 58 */           BadgeManager.tlogHandBadge(((Long)this.arg).longValue(), BadgeManager.getRoleBadgeInfo(xRoleBadgesInfo), badgeId, 0, timeLimt);
/*    */         }
/*    */       } }
/* 61 */     if (xRoleBadgesInfo.getBadgesinfo().size() == 0)
/*    */     {
/* 63 */       Role2rolebadgesinfo.remove((Long)this.arg);
/*    */     }
/* 65 */     if (pro.badgesinfo.size() > 0)
/*    */     {
/* 67 */       OnlineManager.getInstance().send(((Long)this.arg).longValue(), pro);
/*    */     }
/*    */     
/* 70 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   mzm.gsp.badge.BadgeInfo startBadgeSession(xbean.BadgeInfo xBadgeInfo, long timeLimt, long time)
/*    */   {
/* 81 */     BadgeSession session = new BadgeSession(time, ((Long)this.arg).longValue(), xBadgeInfo.getBadgeid());
/* 82 */     long sessionId = session.getSessionId();
/* 83 */     if (sessionId <= 0L)
/*    */     {
/*    */ 
/* 86 */       return null;
/*    */     }
/* 88 */     xBadgeInfo.setSessionid(sessionId);
/* 89 */     mzm.gsp.badge.BadgeInfo pBadge = new mzm.gsp.badge.BadgeInfo();
/* 90 */     pBadge.badgeid = xBadgeInfo.getBadgeid();
/* 91 */     pBadge.timelimit = ((int)(timeLimt / 1000L));
/* 92 */     return pBadge;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\badge\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */