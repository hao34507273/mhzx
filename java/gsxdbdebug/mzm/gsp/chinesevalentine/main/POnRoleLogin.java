/*    */ package mzm.gsp.chinesevalentine.main;
/*    */ 
/*    */ import mzm.gsp.chinesevalentine.SChineseValentineGameInfo;
/*    */ import xbean.ChineseValentineGame;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 12 */     Long gameID = xtable.Role2chinesevalentine.get(Long.valueOf(roleId));
/* 13 */     if (gameID == null) {
/* 14 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 18 */     ChineseValentineGame xChineseValentineGame = xtable.Chinesevalentine.get(gameID);
/* 19 */     if (xChineseValentineGame == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     SChineseValentineGameInfo protocol = new SChineseValentineGameInfo();
/* 23 */     protocol.roleidlist.addAll(xChineseValentineGame.getRoleidlist());
/* 24 */     protocol.rightcount = xChineseValentineGame.getRightcount();
/* 25 */     protocol.wrongcount = xChineseValentineGame.getWrongcount();
/* 26 */     protocol.roundnumber = xChineseValentineGame.getRoundinfo().getRoundnumber();
/* 27 */     mzm.gsp.online.main.OnlineManager.getInstance().send(roleId, protocol);
/*    */     
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chinesevalentine\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */