/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.chat.ChatContent;
/*    */ import mzm.gsp.chat.SChatInRoom;
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PCChatInRoomReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int contentType;
/*    */   private final Octets content;
/*    */   
/*    */   public PCChatInRoomReq(long roleid, int contentType, Octets content)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.contentType = contentType;
/* 24 */     this.content = content;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if ((this.content == null) || (this.content.array().length < 1))
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     if (!BetacatChatRoomManager.isOpen(this.roleid, "PCChatInRoomReq.processImp"))
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     String userid = RoleInterface.getUserId(this.roleid);
/* 41 */     if (userid == null)
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 47 */     if (!RoleChatManager.isLevelToChat(this.roleid, 9))
/*    */     {
/* 49 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 53 */     if (RoleChatManager.isForbidden(this.roleid, 9))
/*    */     {
/* 55 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 59 */     if (!RoleChatManager.checkAndSetChatInterval(this.roleid, 9))
/*    */     {
/* 61 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 65 */     if (!BetacatChatRoomManager.isJoinRoom(this.roleid))
/*    */     {
/* 67 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 71 */     if (!RoleChatManager.checkAndCostEnergy(this.roleid, 9))
/*    */     {
/* 73 */       return false;
/*    */     }
/*    */     
/* 76 */     ChatContent chatContent = new ChatContent();
/* 77 */     RoleChatManager.fillRoleInfoInChatContent(this.roleid, chatContent, this.content, this.contentType);
/* 78 */     if (RoleChatManager.isPlatformTalkForbid(this.roleid))
/*    */     {
/* 80 */       SChatInRoom chatInRoom = new SChatInRoom();
/* 81 */       chatInRoom.sender_zoneid = CommonUtils.getZoneId(userid);
/* 82 */       chatInRoom.content = chatContent;
/* 83 */       OnlineManager.getInstance().send(this.roleid, chatInRoom);
/*    */     }
/*    */     else
/*    */     {
/* 87 */       BetacatChatRoomManager.sendChatInRoomReq(userid, this.roleid, chatContent);
/*    */     }
/*    */     
/* 90 */     RoleChatManager.afterChat(this.roleid, 9);
/*    */     
/*    */ 
/* 93 */     IdipManager.chatTLog(this.roleid, 0L, 0L, 0L, 7, null, this.content);
/*    */     
/* 95 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PCChatInRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */