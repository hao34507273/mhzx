/*     */ package mzm.gsp.chat.main;
/*     */ 
/*     */ import betacat.DataBetweenBetacatAndGameServerReq;
/*     */ import betacat.DataBetweenBetacatAndGameServerRsp;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import mzm.gsp.apollo.main.ApolloInterface;
/*     */ import mzm.gsp.chat.ChatContent;
/*     */ import mzm.gsp.chat.SChatInFaction;
/*     */ import mzm.gsp.chat.SChatToAnchor;
/*     */ import mzm.gsp.chat.confbean.SChatDefaultMsg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import xio.Protocol;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChatInterface
/*     */ {
/*     */   public static boolean chatInFaction(long roleId, int contenttype, Octets content)
/*     */   {
/*  35 */     return RoleChatManager.chatInFaction(roleId, contenttype, content);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean onReceiveFactionChatContent(long roleid, long factionid, SChatInFaction protocol)
/*     */   {
/*  51 */     return RoleChatManager.onReceiveFactionChatContent(roleid, factionid, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void chatToSbNoneRealTime(long sender, long receiver, String _msg)
/*     */   {
/*  67 */     RoleChatManager.chatToSbNoneRealTimeImpl(sender, receiver, _msg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void chatToSbNoneRealTime(long sender, long receiver, int _msgId)
/*     */   {
/*  83 */     RoleChatManager.chatToSbNoneRealTimeImpl(sender, receiver, _msgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isContentIdExist(int contendId)
/*     */   {
/*  95 */     return SChatDefaultMsg.get(contendId) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean registerWorldChat(int type, WorldChatHandler worldChatOber)
/*     */   {
/* 109 */     return ChatInWorldObManager.registerChatInWorldImpl(type, worldChatOber);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean unRegisterWorldChat(int type)
/*     */   {
/* 122 */     return ChatInWorldObManager.unRegisterChatInWorldImpl(type);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void send2AppolloAnchor(long senderId, int roomType, Octets content)
/*     */   {
/* 137 */     ApolloInterface.sendSyncApolloChatInfo(senderId, roomType, content);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void send2AnchorClient(String anchorUserId, int senderZoneId, int senderRoomType, Octets content)
/*     */   {
/* 160 */     SChatToAnchor sChatToAnchor = new SChatToAnchor();
/* 161 */     sChatToAnchor.chatcontent = content;
/* 162 */     sChatToAnchor.senderroomtype = senderRoomType;
/* 163 */     sChatToAnchor.senderzoneid = senderZoneId;
/*     */     
/* 165 */     OnlineManager.getInstance().send(anchorUserId, sChatToAnchor);
/*     */   }
/*     */   
/*     */   public static void onDataBetweenBetacatAndGameServerReq(DataBetweenBetacatAndGameServerReq req)
/*     */   {
/* 170 */     BetacatChatRoomManager.onDataBetweenBetacatAndGameServerReq(req);
/*     */   }
/*     */   
/*     */   public static void onDataBetweenBetacatAndGameServerRsp(DataBetweenBetacatAndGameServerRsp rsp)
/*     */   {
/* 175 */     new POnDataBetweenBetacatAndGameServerRsp(rsp).call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean sendBullet(long roleid, Octets content)
/*     */   {
/* 188 */     return RoleChatManager.sendBullet(roleid, content);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean chatInGroup(long roleid, long groupid, int contentType, Octets content)
/*     */   {
/* 210 */     return RoleChatManager.chatInGroup(roleid, groupid, contentType, content);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean chatInTrumpet(String userid, long roleid, int trumpetCfgid, int contentType, Octets content)
/*     */   {
/* 233 */     return RoleChatManager.chatInTrumpet(userid, roleid, trumpetCfgid, contentType, content);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void fillChatContent(long roleId, ChatContent chatcontent, Octets content, int contentType)
/*     */   {
/* 253 */     RoleChatManager.fillRoleInfoInChatContent(roleId, chatcontent, content, contentType);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addWorldBroMsg(Protocol protocol)
/*     */   {
/* 263 */     BroadCastToAllTimer.add(protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ChatChannelCfg getChatChannelCfg(int channel)
/*     */   {
/* 274 */     return RoleChatManager.getChatCfgByChannelType(channel);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\ChatInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */