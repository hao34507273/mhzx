/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.chat.SChatInActivity;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCChatInActivity
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int contenttype;
/*    */   private Octets content;
/*    */   
/*    */   public PCChatInActivity(long roleId, int contenttype, Octets content)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.contenttype = contenttype;
/* 23 */     this.content = content;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 28 */     if ((this.content == null) || (this.content.getBytes().length < 1)) {
/* 29 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 33 */     if (!RoleChatManager.isLevelToChat(this.roleId, 6)) {
/* 34 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 38 */     if (RoleChatManager.isForbidden(this.roleId, 6)) {
/* 39 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 43 */     if (!RoleChatManager.checkAndSetChatInterval(this.roleId, 6))
/*    */     {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     if (!RoleChatManager.checkAndCostEnergy(this.roleId, 6)) {
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     Set<Long> roleList = new HashSet();
/*    */     
/*    */ 
/* 55 */     SChatInActivity sChatInActivity = new SChatInActivity();
/* 56 */     RoleChatManager.fillRoleInfoInChatContent(this.roleId, sChatInActivity.chatcontent, this.content, this.contenttype);
/*    */     
/* 58 */     if (RoleChatManager.isPlatformTalkForbid(this.roleId)) {
/* 59 */       OnlineManager.getInstance().send(this.roleId, sChatInActivity);
/*    */     } else {
/* 61 */       OnlineManager.getInstance().sendMulti(sChatInActivity, roleList);
/*    */     }
/*    */     
/* 64 */     RoleChatManager.afterChat(this.roleId, 6);
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PCChatInActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */