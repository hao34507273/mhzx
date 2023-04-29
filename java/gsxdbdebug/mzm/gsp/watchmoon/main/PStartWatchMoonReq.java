/*    */ package mzm.gsp.watchmoon.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.watchmoon.SStartWatchmoonSuccessRes;
/*    */ import mzm.gsp.watchmoon.confbean.SWatchmoonConsts;
/*    */ import xbean.Watchmoon;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2watchmoon;
/*    */ 
/*    */ public class PStartWatchMoonReq extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PStartWatchMoonReq(long roleid)
/*    */   {
/* 21 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     Watchmoon xWatchmoon = Role2watchmoon.select(Long.valueOf(this.roleid));
/* 29 */     if (xWatchmoon == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     List<Long> roleids = new ArrayList();
/* 34 */     roleids.add(Long.valueOf(this.roleid));
/* 35 */     roleids.add(Long.valueOf(xWatchmoon.getPartenerroleid()));
/* 36 */     Lockeys.lock(Role2watchmoon.getTable(), roleids);
/* 37 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 39 */       if (!mzm.gsp.status.main.RoleStatusInterface.containsStatus(roleid, 28))
/*    */       {
/* 41 */         return false;
/*    */       }
/* 43 */       xWatchmoon = Role2watchmoon.get(Long.valueOf(roleid));
/* 44 */       if (xWatchmoon == null)
/*    */       {
/* 46 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 50 */     if (WatchmoonManager.isFlySessionStart(xWatchmoon.getSessionid()))
/*    */     {
/* 52 */       Session.removeSession(xWatchmoon.getSessionid());
/*    */     }
/* 54 */     if (!WatchmoonManager.isWatchMoonSessionStart(xWatchmoon.getSessionid()))
/*    */     {
/*    */ 
/* 57 */       WatchMoonSession watchMoonSession = new WatchMoonSession(SWatchmoonConsts.getInstance().STAY_TIME, xWatchmoon.getMapid(), roleids);
/*    */       
/* 59 */       for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 61 */         Watchmoon x = Role2watchmoon.get(Long.valueOf(roleid));
/*    */         
/* 63 */         x.setSessionid(watchMoonSession.getSessionId());
/*    */       }
/* 65 */       SStartWatchmoonSuccessRes re = new SStartWatchmoonSuccessRes();
/* 66 */       OnlineManager.getInstance().sendMulti(re, roleids);
/*    */       
/* 68 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 73 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\main\PStartWatchMoonReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */