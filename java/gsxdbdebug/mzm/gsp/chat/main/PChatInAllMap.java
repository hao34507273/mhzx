/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.chat.SChatInAllMap;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PChatInAllMap
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int mapCfgId;
/*    */   private final int contentType;
/*    */   private final Octets content;
/*    */   
/*    */   public PChatInAllMap(long roleid, int mapCfgId, int contentType, Octets content)
/*    */   {
/* 24 */     this.roleid = roleid;
/* 25 */     this.mapCfgId = mapCfgId;
/* 26 */     this.contentType = contentType;
/* 27 */     this.content = content;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     GameServer.logger().info(String.format("[chat]PChatInAllMap.processImp@receive chat in all map req|roleid=%d|mapCfgId=%d|contentType=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.mapCfgId), Integer.valueOf(this.contentType) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 38 */     if ((this.content == null) || (this.content.array().length < 1))
/*    */     {
/* 40 */       GameServer.logger().info(String.format("[chat]PChatInAllMap.processImp@content is empty|roleid=%d|mapCfgId=%d|contentType=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.mapCfgId), Integer.valueOf(this.contentType) }));
/*    */       
/*    */ 
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     if (MapInterface.getRoleMapId(this.roleid) != this.mapCfgId)
/*    */     {
/* 48 */       RoleChatManager.sendFailMoreProc(this.roleid, 11, 20, this.content, this.contentType);
/*    */       
/* 50 */       GameServer.logger().info(String.format("[chat]PChatInAllMap.processImp@role is not in map|roleid=%d|mapCfgId=%d|contentType=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.mapCfgId), Integer.valueOf(this.contentType) }));
/*    */       
/*    */ 
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     if (!RoleChatManager.canRoleSpk(this.contentType, this.content, this.roleid, 11))
/*    */     {
/* 58 */       GameServer.logger().info(String.format("[chat]PChatInAllMap.processImp@role cannot speak|roleid=%d|mapCfgId=%d|contentType=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.mapCfgId), Integer.valueOf(this.contentType) }));
/*    */       
/*    */ 
/* 61 */       return false;
/*    */     }
/*    */     
/* 64 */     SChatInAllMap protocol = new SChatInAllMap();
/* 65 */     RoleChatManager.fillRoleInfoInChatContent(this.roleid, protocol.content, this.content, this.contentType);
/* 66 */     protocol.map_cfg_id = this.mapCfgId;
/* 67 */     if (RoleChatManager.isPlatformTalkForbid(this.roleid))
/*    */     {
/* 69 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*    */     }
/*    */     else
/*    */     {
/* 73 */       MapInterface.brocadCastInWorldMap(MapInterface.getRoleWorldInstanceId(this.roleid), this.mapCfgId, protocol, false);
/*    */     }
/* 75 */     RoleChatManager.afterChat(this.roleid, 11);
/*    */     
/*    */ 
/* 78 */     GameServer.logger().info(String.format("[chat]PChatInAllMap.processImp@chat in all map success|roleid=%d|mapCfgId=%d|contentType=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.mapCfgId), Integer.valueOf(this.contentType) }));
/*    */     
/*    */ 
/* 81 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PChatInAllMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */