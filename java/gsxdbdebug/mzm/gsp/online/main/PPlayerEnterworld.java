/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.SSyncServerMergeHistory;
/*    */ import mzm.gsp.online.event.PlayerLogin;
/*    */ import mzm.gsp.online.event.PlayerLoginProtect;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.LoginStatus;
/*    */ 
/*    */ public class PPlayerEnterworld extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PPlayerEnterworld(long roleId)
/*    */   {
/* 18 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   void announceModuleOnline(long roleid, int prevStatus, int lineid)
/*    */   {
/* 23 */     SSyncServerMergeHistory core = new SSyncServerMergeHistory();
/* 24 */     core.zoneids.addAll(mzm.gsp.GameServerInfoManager.getZoneIds());
/* 25 */     OnlineManager.getInstance().sendAtOnce(this.roleId, core);
/*    */     
/*    */ 
/* 28 */     switch (prevStatus) {
/*    */     case 2: 
/* 30 */       PlayerLogin pl = new PlayerLogin();
/* 31 */       pl.setSequential(true);
/* 32 */       TriggerEventsManger.getInstance().triggerEvent(pl, Long.valueOf(roleid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*    */       
/* 34 */       break;
/*    */     case 10: 
/* 36 */       PlayerLoginProtect plp = new PlayerLoginProtect();
/* 37 */       plp.setSequential(true);
/* 38 */       TriggerEventsManger.getInstance().triggerEvent(plp, Long.valueOf(roleid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*    */     }
/*    */     
/*    */     
/*    */ 
/* 43 */     mzm.gsp.online.SSendServerTime sendServerTime = new mzm.gsp.online.SSendServerTime();
/* 44 */     sendServerTime.servertime = (mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 45 */     sendServerTime.raw_offset = mzm.gsp.util.DateTimeUtils.RAW_OFFSET_SEC;
/* 46 */     sendServerTime.serveropentime = (mzm.gsp.server.main.ServerInterface.getOpenServertime(true) / 1000L);
/* 47 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sendServerTime);
/*    */     
/* 49 */     GameServer.logger().info(String.format("announceModuleOnline@通告module玩家%d上线!", new Object[] { Long.valueOf(roleid) }));
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 54 */     boolean result = false;
/* 55 */     LoginStatus loginStatus = xtable.Loginstatus.get(Long.valueOf(this.roleId));
/* 56 */     OnlineInfo onlineRoleInfo = OnlineManager.getInstance().getOnlineInfo(this.roleId);
/* 57 */     gnet.link.Role role = gnet.link.Onlines.getInstance().find(Long.valueOf(this.roleId));
/* 58 */     if ((loginStatus == null) || (role == null))
/*    */     {
/* 60 */       GameServer.logger().fatal("PlayerEnterworld@错误：玩家不存在，这种情况不应出现！！roleid=" + this.roleId);
/*    */     }
/*    */     else
/*    */     {
/* 64 */       int prevStatus = loginStatus.getStatus();
/* 65 */       if ((prevStatus == 2) || (prevStatus == 10))
/*    */       {
/*    */ 
/* 68 */         loginStatus.setStatus(3);
/* 69 */         if (onlineRoleInfo == null) {
/* 70 */           onlineRoleInfo = new OnlineInfo(3);
/* 71 */           OnlineManager.getInstance().addOnlineInfo(this.roleId, onlineRoleInfo);
/* 72 */           GameServer.logger().error(String.format("PPlayerEnterworld.processImp@不应该存在玩家进入世界但是还没有在线信息的情况", new Object[] { Long.valueOf(this.roleId) }));
/*    */         }
/* 74 */         onlineRoleInfo.setOnlineStatus(3);
/* 75 */         GameServer.logger().debug("PlayerEnterworld@玩家进入世界，roleid=" + this.roleId);
/*    */         
/* 77 */         announceModuleOnline(this.roleId, prevStatus, 0);
/* 78 */         result = true;
/*    */       }
/*    */       else {
/* 81 */         GameServer.logger().error(String.format("PlayerEnterworld@错误：玩家%d， 状态错误%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(prevStatus) }));
/*    */       }
/*    */     }
/* 84 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PPlayerEnterworld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */