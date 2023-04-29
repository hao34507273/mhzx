/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     long roleid = ((Long)this.arg).longValue();
/* 11 */     if (!PetArenaManager.getPetArenaAward(roleid))
/*    */     {
/* 13 */       GameServer.logger().info(String.format("[petarena]POnRoleLogin.processImp@get award failed|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/* 14 */       return false;
/*    */     }
/*    */     
/* 17 */     GameServer.logger().info(String.format("[petarena]POnRoleLogin.processImp@get award success|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */