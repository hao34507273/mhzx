/*    */ package mzm.gsp.mounts.main;
/*    */ 
/*    */ import mzm.gsp.mounts.event.AppearanceMountsObserverArg;
/*    */ 
/*    */ public class POnAppearanceMountsObserver extends mzm.gsp.mounts.event.AppearanceMountsObserverProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     long roleId = ((AppearanceMountsObserverArg)this.arg).getRoleId();
/*    */     
/* 11 */     xbean.Role2MountsObserverInfo xRole2MountsObserverInfo = xtable.Role2mountsobserver.get(Long.valueOf(roleId));
/* 12 */     if (xRole2MountsObserverInfo == null)
/*    */     {
/* 14 */       xRole2MountsObserverInfo = xbean.Pod.newRole2MountsObserverInfo();
/* 15 */       xtable.Role2mountsobserver.add(Long.valueOf(roleId), xRole2MountsObserverInfo);
/*    */     }
/*    */     
/* 18 */     long mountsId = ((AppearanceMountsObserverArg)this.arg).getMountsId();
/* 19 */     MountsExpiredMillObserver observer = new MountsExpiredMillObserver(((AppearanceMountsObserverArg)this.arg).getRemainMillisSeconds(), roleId, mountsId);
/*    */     
/* 21 */     MountsExpiredMillObserver oldObserver = (MountsExpiredMillObserver)xRole2MountsObserverInfo.getObserver_map().put(Long.valueOf(mountsId), observer);
/* 22 */     if (oldObserver != null)
/*    */     {
/* 24 */       oldObserver.stopTimer();
/*    */     }
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\POnAppearanceMountsObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */