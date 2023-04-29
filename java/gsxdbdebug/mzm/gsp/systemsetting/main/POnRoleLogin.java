/*    */ package mzm.gsp.systemsetting.main;
/*    */ 
/*    */ import mzm.gsp.friend.confbean.SFriendConsts;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.systemsetting.SSyncSystemSetting;
/*    */ import xbean.SystemSetting;
/*    */ import xtable.Role2systemsetting;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     SSyncSystemSetting sSyncSystemSetting = new SSyncSystemSetting();
/* 15 */     SystemSetting xSystemSetting = Role2systemsetting.get((Long)this.arg);
/* 16 */     if (xSystemSetting == null)
/*    */     {
/* 18 */       xSystemSetting = xbean.Pod.newSystemSetting();
/* 19 */       Role2systemsetting.insert((Long)this.arg, xSystemSetting);
/* 20 */       SystemSettingInterface.initSystemSetting(((Long)this.arg).longValue(), xSystemSetting);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     }
/* 28 */     else if (SystemSettingInterface.getSetting(((Long)this.arg).longValue(), 6).intValue() == 0)
/*    */     {
/*    */ 
/* 31 */       xSystemSetting.getSettingmap().put(Integer.valueOf(6), Integer.valueOf(SFriendConsts.getInstance().addFriendLvSet));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 36 */     SystemSettingInterface.fill(((Long)this.arg).longValue(), sSyncSystemSetting, xSystemSetting);
/* 37 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), sSyncSystemSetting);
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\systemsetting\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */