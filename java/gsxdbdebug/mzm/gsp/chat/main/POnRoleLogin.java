/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.chat.confbean.SysCfgConsts;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import xbean.NewerChannel;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleChatInfo;
/*    */ import xtable.Role2chat;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     long roleId = ((Long)this.arg).longValue();
/* 19 */     RoleChatInfo roleChatInfo = Role2chat.get(Long.valueOf(roleId));
/* 20 */     if (roleChatInfo == null) {
/* 21 */       roleChatInfo = creatRoleChatData(roleId);
/*    */     }
/*    */     
/* 24 */     ChatStorageManager.sendInitMsg(roleId, roleChatInfo);
/*    */     
/* 26 */     if (GangInterface.getGangId(roleId) <= 0L)
/*    */     {
/* 28 */       List<NewerChannel> newerChannels = NewerManager.getNewerChannels();
/* 29 */       NewerManager.addNewer(roleId, newerChannels);
/*    */     }
/*    */     
/* 32 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private RoleChatInfo creatRoleChatData(long roleId)
/*    */   {
/* 41 */     RoleChatInfo roleChatInfo = Pod.newRoleChatInfo();
/* 42 */     roleChatInfo.getChatcfg().put(Integer.valueOf(4), Integer.valueOf(SysCfgConsts.getInstance().autoPlayVoiceGang));
/* 43 */     roleChatInfo.getChatcfg().put(Integer.valueOf(1), Integer.valueOf(SysCfgConsts.getInstance().autoPlayVoiceMap));
/* 44 */     roleChatInfo.getChatcfg().put(Integer.valueOf(3), Integer.valueOf(SysCfgConsts.getInstance().autoPlayVoiceTeam));
/* 45 */     roleChatInfo.getChatcfg().put(Integer.valueOf(2), Integer.valueOf(SysCfgConsts.getInstance().autoPlayVoiceWorld));
/* 46 */     roleChatInfo.getChatcfg().put(Integer.valueOf(8), Integer.valueOf(SysCfgConsts.getInstance().shieldMessageGang));
/* 47 */     roleChatInfo.getChatcfg().put(Integer.valueOf(5), Integer.valueOf(SysCfgConsts.getInstance().shieldMessageMap));
/* 48 */     roleChatInfo.getChatcfg().put(Integer.valueOf(7), Integer.valueOf(SysCfgConsts.getInstance().shieldMessageTeam));
/* 49 */     roleChatInfo.getChatcfg().put(Integer.valueOf(6), Integer.valueOf(SysCfgConsts.getInstance().shieldMessageWorld));
/*    */     
/* 51 */     return roleChatInfo;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */