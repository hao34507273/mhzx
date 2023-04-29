/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.List;
/*    */ import mzm.gsp.chat.SChatInNewer;
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.NewerChannel;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ public class PCChatInNewer extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int contenttype;
/*    */   private Octets content;
/*    */   
/*    */   public PCChatInNewer(long roleId, int contenttype, Octets content)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.contenttype = contenttype;
/* 23 */     this.content = content;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if ((this.content == null) || (this.content.getBytes().length < 1)) {
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 34 */     lock(Lockeys.get(Role2properties.getTable(), Long.valueOf(this.roleId)));
/*    */     
/* 36 */     List<NewerChannel> newerChannels = NewerManager.getNewerChannels();
/*    */     
/* 38 */     if (!RoleChatManager.canRoleSpk(this.contenttype, this.content, this.roleId, 1))
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 44 */     SChatInNewer sChatInNewer = new SChatInNewer();
/* 45 */     RoleChatManager.fillRoleInfoInChatContent(this.roleId, sChatInNewer.chatcontent, this.content, this.contenttype);
/*    */     
/*    */ 
/* 48 */     if (RoleChatManager.isPlatformTalkForbid(this.roleId)) {
/* 49 */       OnlineManager.getInstance().send(this.roleId, sChatInNewer);
/*    */     }
/* 51 */     else if (!NewerManager.sendToNewer(this.roleId, newerChannels, sChatInNewer)) {
/* 52 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 56 */     RoleChatManager.afterChat(this.roleId, 1);
/*    */     
/*    */ 
/* 59 */     IdipManager.chatTLog(this.roleId, 0L, 0L, 0L, 1, null, this.content);
/*    */     
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PCChatInNewer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */