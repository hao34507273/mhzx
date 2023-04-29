/*    */ package mzm.gsp.fashiondress.main;
/*    */ 
/*    */ import mzm.gsp.fashiondress.event.FashionDressObserverArg;
/*    */ 
/*    */ public class POnFashionDressObserver extends mzm.gsp.fashiondress.event.FashionDressObserverProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     long roleId = ((FashionDressObserverArg)this.arg).roleId;
/* 10 */     xbean.Role2FashionDressObserverInfo xRole2FashionDressObserverInfo = xtable.Role2fashiondressobserver.get(Long.valueOf(roleId));
/* 11 */     if (xRole2FashionDressObserverInfo == null)
/*    */     {
/* 13 */       xRole2FashionDressObserverInfo = xbean.Pod.newRole2FashionDressObserverInfo();
/* 14 */       xtable.Role2fashiondressobserver.add(Long.valueOf(roleId), xRole2FashionDressObserverInfo);
/*    */     }
/*    */     
/* 17 */     int fashionDressCfgId = ((FashionDressObserverArg)this.arg).fashionDressCfgId;
/* 18 */     FashionDressExpiredObserver fashionDressExpiredObserver = new FashionDressExpiredObserver(((FashionDressObserverArg)this.arg).leftTime * 1000L, roleId, fashionDressCfgId);
/*    */     
/*    */ 
/*    */ 
/* 22 */     FashionDressExpiredObserver oldFashionDressExpiredObserver = (FashionDressExpiredObserver)xRole2FashionDressObserverInfo.getObserver_map().put(Integer.valueOf(fashionDressCfgId), fashionDressExpiredObserver);
/*    */     
/* 24 */     if (oldFashionDressExpiredObserver != null)
/*    */     {
/* 26 */       oldFashionDressExpiredObserver.stopTimer();
/*    */     }
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\POnFashionDressObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */