/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.chat.ChatContent;
/*    */ import mzm.gsp.chat.SChatInAnchor;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PChatInAnchor
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int roomType;
/*    */   private int contenttype;
/*    */   private Octets content;
/*    */   
/*    */   public PChatInAnchor(long roleId, int roomType, int contenttype, Octets content)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.roomType = roomType;
/* 27 */     this.contenttype = contenttype;
/* 28 */     this.content = content;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 35 */     if (!RoleChatManager.canRoleSpk(this.contenttype, this.content, this.roleId, 8)) {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     send2Client(getSChatInAnchorPro());
/* 40 */     RoleChatManager.afterChat(this.roleId, 8);
/* 41 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private void send2Client(SChatInAnchor sChatInAnchor)
/*    */   {
/* 49 */     if (RoleChatManager.isPlatformTalkForbid(this.roleId))
/*    */     {
/* 51 */       OnlineManager.getInstance().send(this.roleId, sChatInAnchor);
/*    */     }
/*    */     else {
/* 54 */       send2Anchor();
/*    */       
/* 56 */       BroadCastToAllTimer.add(sChatInAnchor);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private SChatInAnchor getSChatInAnchorPro()
/*    */   {
/* 65 */     SChatInAnchor sChatInAnchor = new SChatInAnchor();
/* 66 */     sChatInAnchor.roomtype = this.roomType;
/* 67 */     RoleChatManager.fillRoleInfoInChatContent(this.roleId, sChatInAnchor.chatcontent, this.content, this.contenttype);
/* 68 */     return sChatInAnchor;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   private void send2Anchor()
/*    */   {
/* 75 */     ChatContent chatcontent = new ChatContent();
/* 76 */     RoleChatManager.fillRoleInfoInChatContent(this.roleId, chatcontent, this.content, this.contenttype);
/* 77 */     ChatInterface.send2AppolloAnchor(this.roleId, this.roomType, new OctetsStream().marshal(chatcontent));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PChatInAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */