/*    */ package mzm.gsp.fashiondress.main;
/*    */ 
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import xbean.Role2FashionDressObserverInfo;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleId = ((Long)this.arg).longValue();
/* 12 */     Role2FashionDressObserverInfo xRole2FashionDressObserverInfo = xtable.Role2fashiondressobserver.get(Long.valueOf(roleId));
/* 13 */     if (xRole2FashionDressObserverInfo == null)
/*    */     {
/* 15 */       return true;
/*    */     }
/*    */     
/* 18 */     for (Map.Entry<Integer, FashionDressExpiredObserver> entry : xRole2FashionDressObserverInfo.getObserver_map().entrySet())
/*    */     {
/* 20 */       FashionDressExpiredObserver fashionDressExpiredObserver = (FashionDressExpiredObserver)entry.getValue();
/* 21 */       fashionDressExpiredObserver.stopTimer();
/*    */     }
/*    */     
/* 24 */     xtable.Role2fashiondressobserver.remove(Long.valueOf(roleId));
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */