/*    */ package mzm.gsp.baitan.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import xbean.Shoppoingid2Sessionid;
/*    */ import xtable.Role2shoppingsession;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     boolean ret = xtable.Role2baitanshoppinglist.remove((Long)this.arg);
/* 13 */     String logStr = String.format("[baitan]POnRoleLogoff.processImp@logoff clear baitan info|roleid=%d|level=%d|suc=%d", new Object[] { this.arg, Integer.valueOf(mzm.gsp.role.main.RoleInterface.getLevel(((Long)this.arg).longValue())), Integer.valueOf(ret ? 1 : 0) });
/*    */     
/* 15 */     BaiTanManager.logger.info(logStr);
/*    */     
/* 17 */     Shoppoingid2Sessionid ss = Role2shoppingsession.get((Long)this.arg);
/* 18 */     if (ss != null)
/*    */     {
/* 20 */       for (Iterator i$ = ss.getShoppingid2sessionid().values().iterator(); i$.hasNext();) { long sessionid = ((Long)i$.next()).longValue();
/*    */         
/* 22 */         mzm.gsp.timer.main.Session.removeSession(sessionid);
/*    */       }
/*    */       
/* 25 */       Role2shoppingsession.remove((Long)this.arg);
/*    */     }
/*    */     
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */