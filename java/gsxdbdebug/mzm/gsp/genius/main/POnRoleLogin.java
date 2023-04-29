/*    */ package mzm.gsp.genius.main;
/*    */ 
/*    */ import mzm.gsp.genius.confbean.SGeniusConst;
/*    */ import xbean.GeniusInfo;
/*    */ import xtable.Role2genius;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     long roleid = ((Long)this.arg).longValue();
/* 12 */     int level = mzm.gsp.role.main.RoleInterface.getLevel(roleid);
/* 13 */     if (level < SGeniusConst.getInstance().OPEN_LEVEL)
/*    */     {
/* 15 */       return false;
/*    */     }
/*    */     
/* 18 */     GeniusInfo xGeniusInfo = Role2genius.get(Long.valueOf(roleid));
/* 19 */     int extraPoint = 0;
/* 20 */     if (xGeniusInfo != null)
/*    */     {
/* 22 */       extraPoint = xGeniusInfo.getExtra_point();
/*    */     }
/* 24 */     GeniusManager.syncExtraPoint(roleid, extraPoint, true);
/*    */     
/* 26 */     return GeniusManager.checkDoubleGeniusSeriesClosed(roleid, false);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */