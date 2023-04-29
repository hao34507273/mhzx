/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import gnet.link.Onlines;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class DelayKickSession extends Session
/*    */ {
/*    */   public DelayKickSession(long interval, long roleId)
/*    */   {
/* 12 */     super(interval, roleId);
/*    */   }
/*    */   
/*    */   long getRoleid() {
/* 16 */     return getOwerId();
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 21 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 26 */         long roleid = DelayKickSession.this.getRoleid();
/* 27 */         Onlines.getInstance().kick(Long.valueOf(roleid), 2056);
/* 28 */         new PPlayerPreLogout(roleid, 2).call();
/* 29 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\DelayKickSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */