/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.chat.crossserver.CrossServerChatHandler;
/*    */ import mzm.gsp.chat.crossserver.CrossServerChatInterface;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCChatInFaction
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int contenttype;
/*    */   private Octets content;
/*    */   
/*    */   public PCChatInFaction(long roleId, int contenttype, Octets content)
/*    */   {
/* 28 */     this.roleId = roleId;
/* 29 */     this.contenttype = contenttype;
/* 30 */     this.content = content;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 36 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/*    */ 
/* 39 */       if (!RoleChatManager.isFactionCrossServerChatOpenForRole(this.roleId))
/*    */       {
/* 41 */         GameServer.logger().error(String.format("[chat]PCChatInFaction.processImp@module close or role forbidden|roleid=%d|content_type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.contenttype) }));
/*    */         
/*    */ 
/*    */ 
/* 45 */         return false;
/*    */       }
/* 47 */       for (final CrossServerChatHandler handler : CrossServerChatInterface.getHandlers(2))
/*    */       {
/* 49 */         RoleOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(this.roleId), new LogicProcedure()
/*    */         {
/*    */           protected boolean processImp()
/*    */             throws Exception
/*    */           {
/* 54 */             return RoleChatManager.chatInFactionInRoamServer(PCChatInFaction.this.roleId, PCChatInFaction.this.contenttype, PCChatInFaction.this.content, handler);
/*    */           }
/*    */         });
/*    */       }
/* 58 */       return true;
/*    */     }
/*    */     
/* 61 */     return RoleChatManager.chatInFaction(this.roleId, this.contenttype, this.content);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PCChatInFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */