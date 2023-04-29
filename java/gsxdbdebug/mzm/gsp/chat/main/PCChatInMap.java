/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.chat.SChatInMap;
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCChatInMap
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int contenttype;
/*    */   private Octets content;
/*    */   
/*    */   public PCChatInMap(long roleId, int contenttype, Octets content)
/*    */   {
/* 26 */     this.roleId = roleId;
/* 27 */     this.contenttype = contenttype;
/* 28 */     this.content = content;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     if ((this.content == null) || (this.content.array().length < 1)) {
/* 36 */       return false;
/*    */     }
/* 38 */     if (!RoleChatManager.canRoleSpk(this.contenttype, this.content, this.roleId, 4))
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 44 */     SChatInMap sChatInMap = new SChatInMap();
/* 45 */     RoleChatManager.fillRoleInfoInChatContent(this.roleId, sChatInMap.chatcontent, this.content, this.contenttype);
/* 46 */     if (RoleChatManager.isPlatformTalkForbid(this.roleId))
/*    */     {
/* 48 */       OnlineManager.getInstance().send(this.roleId, sChatInMap);
/*    */     }
/*    */     else
/*    */     {
/* 52 */       MapInterface.asyncBroadcastInSight(this.roleId, sChatInMap, true);
/*    */     }
/*    */     
/* 55 */     RoleChatManager.afterChat(this.roleId, 4);
/*    */     
/*    */ 
/* 58 */     IdipManager.chatTLog(this.roleId, 0L, 0L, 0L, 4, null, this.content);
/*    */     
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PCChatInMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */