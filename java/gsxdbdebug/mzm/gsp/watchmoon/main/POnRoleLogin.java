/*    */ package mzm.gsp.watchmoon.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.watchmoon.SSynWatchmoonTarget;
/*    */ import xbean.Watchmoon;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2watchmoon;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     Watchmoon xWatchmoon = Role2watchmoon.select((Long)this.arg);
/* 23 */     if ((xWatchmoon == null) || (xWatchmoon.getPartenerroleid() == 0L))
/*    */     {
/* 25 */       WatchmoonManager.forceRemoveRoleState(((Long)this.arg).longValue());
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 30 */       long now = DateTimeUtils.getCurrTimeInMillis();
/* 31 */       List<Long> roleids = new ArrayList();
/* 32 */       roleids.add(this.arg);
/* 33 */       roleids.add(Long.valueOf(xWatchmoon.getPartenerroleid()));
/* 34 */       Lockeys.lock(Role2watchmoon.getTable(), roleids);
/* 35 */       Watchmoon xWatchmoon1 = Role2watchmoon.get((Long)this.arg);
/* 36 */       Watchmoon xWatchmoon2 = Role2watchmoon.get(Long.valueOf(xWatchmoon.getPartenerroleid()));
/*    */       
/* 38 */       if ((xWatchmoon1 == null) || (xWatchmoon2 == null) || ((xWatchmoon1.getPartenerroleid() == xWatchmoon.getPartenerroleid()) && (xWatchmoon1.getInvitetime() + WatchmoonManager.getWatchmoonMaxLengthTime() < now)))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 43 */         WatchmoonManager.forceRemoveRoleState(((Long)this.arg).longValue());
/* 44 */         WatchmoonManager.forceRemoveRoleState(xWatchmoon.getPartenerroleid());
/*    */ 
/*    */ 
/*    */ 
/*    */       }
/* 49 */       else if ((xWatchmoon1.getPartenerroleid() == xWatchmoon.getPartenerroleid()) && (xWatchmoon1.getInvitetime() + WatchmoonManager.getWatchmoonMaxLengthTime() >= now) && (RoleStatusInterface.containsStatus(((Long)this.arg).longValue(), 28)))
/*    */       {
/*    */ 
/*    */ 
/* 53 */         Session session = Session.getSession(xWatchmoon1.getSessionid());
/*    */         
/* 55 */         if ((session != null) && ((session instanceof WatchMoonSession)))
/*    */         {
/* 57 */           WatchMoonSession watchMoonSession = (WatchMoonSession)session;
/* 58 */           SSynWatchmoonTarget res = new SSynWatchmoonTarget();
/* 59 */           res.partnerroleid = xWatchmoon1.getPartenerroleid();
/* 60 */           res.endtime = TimeUnit.MILLISECONDS.toSeconds(watchMoonSession.getWatchMoonEndtime());
/*    */           
/* 62 */           OnlineManager.getInstance().send(((Long)this.arg).longValue(), res);
/*    */ 
/*    */         }
/*    */         else
/*    */         {
/* 67 */           WatchmoonManager.forceRemoveRoleState(((Long)this.arg).longValue());
/* 68 */           WatchmoonManager.forceRemoveRoleState(xWatchmoon.getPartenerroleid());
/*    */         }
/*    */         
/*    */       }
/*    */       else
/*    */       {
/* 74 */         WatchmoonManager.forceRemoveRoleState(((Long)this.arg).longValue());
/* 75 */         WatchmoonManager.forceRemoveRoleState(xWatchmoon.getPartenerroleid());
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 81 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */