/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.main.message.MMH_PlayerEnterWorld;
/*    */ import mzm.gsp.map.main.scene.object.MapRoleInitInfo;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.LoginStatus;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/* 14 */   private static final Logger logger = Logger.getLogger(POnRoleLogin.class);
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 22 */     String userid = RoleInterface.getUserId(roleid);
/* 23 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 25 */     if (logger.isDebugEnabled())
/*    */     {
/* 27 */       logger.debug(String.format("[map]POnRoleLogin.processImp@enter role login process|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 32 */     LoginStatus xLoginStatus = xtable.Loginstatus.get(Long.valueOf(roleid));
/* 33 */     if (xLoginStatus == null)
/*    */     {
/* 35 */       logger.error(String.format("[map]POnRoleLogin.processImp@login status is null|userid=%s|roleid=%d", new Object[] { userid, Long.valueOf(roleid) }));
/*    */       
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     int status = xLoginStatus.getStatus();
/* 41 */     if (status != 3)
/*    */     {
/* 43 */       logger.error(String.format("[map]POnRoleLogin.processImp@login status error|userid=%s|roleid=%d|status=%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(status) }));
/*    */       
/*    */ 
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     MapRoleInitInfo mapRoleInitInfo = new MapRoleInitInfo(roleid);
/* 50 */     new MMH_PlayerEnterWorld(roleid, mapRoleInitInfo).execute();
/*    */     
/*    */ 
/* 53 */     GoldStatueManager.getInstance().tryInitGoldStatue();
/*    */     
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */