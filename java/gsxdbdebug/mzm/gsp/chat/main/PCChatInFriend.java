/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.List;
/*    */ import mzm.gsp.chat.SChatInFriend;
/*    */ import mzm.gsp.friend.main.FriendInterface;
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCChatInFriend
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int contentType;
/*    */   private final Octets content;
/*    */   
/*    */   public PCChatInFriend(long roleId, int contentType, Octets content)
/*    */   {
/* 27 */     this.roleId = roleId;
/* 28 */     this.contentType = contentType;
/* 29 */     this.content = content;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 36 */     if (!OpenInterface.getOpenStatus(541))
/*    */     {
/* 38 */       return false;
/*    */     }
/* 40 */     if ((this.content == null) || (this.content.getBytes().length < 1))
/*    */     {
/* 42 */       return false;
/*    */     }
/* 44 */     if (!RoleChatManager.canRoleSpk(this.contentType, this.content, this.roleId, 14))
/*    */     {
/* 46 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 50 */     List<Long> friendIds = FriendInterface.getAllFriends(this.roleId, true);
/* 51 */     if (friendIds.isEmpty())
/*    */     {
/* 53 */       RoleChatManager.sendFailMoreProc(this.roleId, 14, 20, this.content, this.contentType);
/* 54 */       return false;
/*    */     }
/* 56 */     SChatInFriend sChatInFriend = new SChatInFriend();
/* 57 */     RoleChatManager.fillRoleInfoInChatContent(this.roleId, sChatInFriend.chatcontent, this.content, this.contentType);
/* 58 */     if (RoleChatManager.isPlatformTalkForbid(this.roleId))
/*    */     {
/* 60 */       OnlineManager.getInstance().send(this.roleId, sChatInFriend);
/*    */     }
/*    */     else
/*    */     {
/* 64 */       friendIds.add(Long.valueOf(this.roleId));
/* 65 */       OnlineManager.getInstance().sendMulti(sChatInFriend, friendIds);
/*    */     }
/* 67 */     RoleChatManager.afterChat(this.roleId, 14);
/* 68 */     IdipManager.chatTLog(this.roleId, 0L, 0L, 0L, 9, null, this.content);
/*    */     
/* 70 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PCChatInFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */