/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.chat.SChatInGroup;
/*    */ import mzm.gsp.group.main.GroupInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PChatInGroupReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long groupid;
/*    */   private final int contentType;
/*    */   private final Octets content;
/*    */   
/*    */   public PChatInGroupReq(long roleid, long groupid, int contentType, Octets content)
/*    */   {
/* 29 */     this.roleid = roleid;
/* 30 */     this.groupid = groupid;
/* 31 */     this.contentType = contentType;
/* 32 */     this.content = content;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 38 */     if (this.groupid < 0L)
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     if ((this.content == null) || (this.content.array().length < 1))
/*    */     {
/* 45 */       GameServer.logger().info(String.format("[chat]PChatInGroupReq.processImp@content is empty|roleid=%d|groupid=%d|contentType=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Integer.valueOf(this.contentType) }));
/*    */       
/*    */ 
/* 48 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 52 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/* 54 */     if (!RoleChatManager.canRoleSpk(this.contentType, this.content, this.roleid, 10))
/*    */     {
/* 56 */       GameServer.logger().info(String.format("[chat]PChatInGroupReq.processImp@role cannot speak|roleid=%d|groupid=%d|contentType=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Integer.valueOf(this.contentType) }));
/*    */       
/*    */ 
/* 59 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 63 */     if (!GroupInterface.isRoleInGroup(this.roleid, this.groupid))
/*    */     {
/* 65 */       RoleChatManager.sendFailMoreProc(this.roleid, 10, 20, this.content, this.contentType);
/*    */       
/* 67 */       GameServer.logger().info(String.format("[chat]PChatInGroupReq.processImp@role is not in group|roleid=%d|groupid=%d|contentType=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Integer.valueOf(this.contentType) }));
/*    */       
/*    */ 
/* 70 */       return false;
/*    */     }
/* 72 */     SChatInGroup protocol = new SChatInGroup();
/* 73 */     RoleChatManager.fillRoleInfoInChatContent(this.roleid, protocol.content, this.content, this.contentType);
/* 74 */     protocol.groupid = this.groupid;
/* 75 */     if (RoleChatManager.isPlatformTalkForbid(this.roleid))
/*    */     {
/* 77 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*    */     }
/*    */     else
/*    */     {
/* 81 */       List<Long> memberList = GroupInterface.getGroupMemberList(this.groupid, true);
/* 82 */       OnlineManager.getInstance().sendMulti(protocol, memberList);
/*    */     }
/*    */     
/* 85 */     RoleChatManager.afterChat(this.roleid, 10);
/*    */     
/*    */ 
/* 88 */     GameServer.logger().info(String.format("[chat]PChatInGroupReq.processImp@chat in group success|roleid=%d|groupid=%d|contentType=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Integer.valueOf(this.contentType) }));
/*    */     
/*    */ 
/* 91 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PChatInGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */