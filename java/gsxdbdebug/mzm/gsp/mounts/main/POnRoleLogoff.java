/*    */ package mzm.gsp.mounts.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import xbean.Role2MountsObserverInfo;
/*    */ import xtable.Role2mountsobserver;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     Role2MountsObserverInfo xRole2MountsObserverInfo = Role2mountsobserver.get((Long)this.arg);
/* 12 */     if (xRole2MountsObserverInfo == null)
/*    */     {
/* 14 */       return true;
/*    */     }
/*    */     
/* 17 */     for (java.util.Map.Entry<Long, MountsExpiredMillObserver> entry : xRole2MountsObserverInfo.getObserver_map().entrySet())
/*    */     {
/* 19 */       MountsExpiredMillObserver session = (MountsExpiredMillObserver)entry.getValue();
/* 20 */       session.stopTimer();
/*    */     }
/*    */     
/* 23 */     Role2mountsobserver.remove((Long)this.arg);
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */