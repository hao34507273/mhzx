/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.chat.SChatInWorld;
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ 
/*    */ public class PCChatInWorld
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int contenttype;
/*    */   private Octets content;
/*    */   
/*    */   public PCChatInWorld(long roleId, int contenttype, Octets content)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.contenttype = contenttype;
/* 24 */     this.content = content;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     lock(Lockeys.get(Role2properties.getTable(), Long.valueOf(this.roleId)));
/* 31 */     if (!RoleChatManager.canRoleSpk(this.contenttype, this.content, this.roleId, 5))
/*    */     {
/* 33 */       return false;
/*    */     }
/* 35 */     SChatInWorld sChatInWorld = new SChatInWorld();
/* 36 */     RoleChatManager.fillRoleInfoInChatContent(this.roleId, sChatInWorld.chatcontent, this.content, this.contenttype);
/* 37 */     if (RoleChatManager.isPlatformTalkForbid(this.roleId))
/*    */     {
/* 39 */       OnlineManager.getInstance().send(this.roleId, sChatInWorld);
/*    */     }
/*    */     else
/*    */     {
/* 43 */       BroadCastToAllTimer.add(sChatInWorld);
/*    */     }
/* 45 */     RoleChatManager.afterChat(this.roleId, 5);
/* 46 */     triggerHandler();
/*    */     
/*    */ 
/* 49 */     IdipManager.chatTLog(this.roleId, 0L, 0L, 0L, 5, null, this.content);
/*    */     
/* 51 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private void triggerHandler()
/*    */   {
/* 59 */     if (this.contenttype != 2)
/*    */     {
/* 61 */       return;
/*    */     }
/* 63 */     String contentStr = this.content.getString("UTF-8");
/* 64 */     for (WorldChatHandler handler : ChatInWorldObManager.getChatInWorldObMap().values())
/*    */     {
/* 66 */       handler.onChatInWorld(this.roleId, contentStr);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PCChatInWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */