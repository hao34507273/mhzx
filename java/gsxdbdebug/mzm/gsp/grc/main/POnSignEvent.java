/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.signaward.event.SignArg;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnSignEvent extends mzm.gsp.signaward.event.SignEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 14 */       return false;
/*    */     }
/*    */     
/* 17 */     if (((SignArg)this.arg).isResign)
/*    */     {
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     long roleid = ((SignArg)this.arg).roleid;
/*    */     
/* 24 */     if (!GrcManager.isOpenPrivilege(roleid))
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 30 */     if (userid == null)
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 36 */     Lockeys.lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 38 */     return GrcManager.addSignExtraAward(userid, roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnSignEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */