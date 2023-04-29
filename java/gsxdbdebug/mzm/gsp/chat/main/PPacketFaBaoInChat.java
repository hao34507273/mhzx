/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.chat.SPacketFaBaoInChatInfo;
/*    */ import mzm.gsp.fabao.main.FabaoInterface;
/*    */ import mzm.gsp.item.ItemInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PPacketFaBaoInChat extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long checkedRoleid;
/*    */   private final long uuid;
/*    */   
/*    */   public PPacketFaBaoInChat(long roleid, long checkedroleid, long uuid)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.checkedRoleid = checkedroleid;
/* 20 */     this.uuid = uuid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     boolean isRoamServerAndNotOnline = false;
/* 26 */     if ((GameServerInfoManager.isRoamServer()) && (!OnlineManager.getInstance().isOnline(this.checkedRoleid)))
/*    */     {
/* 28 */       isRoamServerAndNotOnline = true;
/*    */     }
/* 30 */     ItemInfo itemInfo = FabaoInterface.getFabaoItemInfo(this.checkedRoleid, this.uuid, false);
/* 31 */     if ((itemInfo == null) || (isRoamServerAndNotOnline)) {
/* 32 */       RoleChatManager.sendNormalResult(this.roleid, 10, new String[0]);
/* 33 */       return false;
/*    */     }
/* 35 */     SPacketFaBaoInChatInfo packetFaBaoInChatInfo = new SPacketFaBaoInChatInfo();
/* 36 */     packetFaBaoInChatInfo.checkedroleid = this.checkedRoleid;
/* 37 */     packetFaBaoInChatInfo.iteminfo = itemInfo;
/* 38 */     OnlineManager.getInstance().send(this.roleid, packetFaBaoInChatInfo);
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PPacketFaBaoInChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */