/*    */ package mzm.gsp.legoushangcheng.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     xbean.LeGouShangChengInfo xLeGouShangChengInfo = xtable.Role2legoushangchenginfo.get((Long)this.arg);
/*  9 */     LeGouShangChengManager.synLeGouShangchengInfo(((Long)this.arg).longValue(), xLeGouShangChengInfo);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\legoushangcheng\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */