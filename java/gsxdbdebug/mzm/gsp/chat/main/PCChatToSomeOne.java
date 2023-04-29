/*     */ package mzm.gsp.chat.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chat.SChatToSomeOne;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCChatToSomeOne
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private long strangerId;
/*     */   private int contenttype;
/*     */   private Octets content;
/*     */   
/*     */   public PCChatToSomeOne(long roleId, long stangerId, int contenttype, Octets content)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.contenttype = contenttype;
/*  30 */     this.content = content;
/*  31 */     this.strangerId = stangerId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if ((this.content == null) || (this.content.array().length < 1)) {
/*  39 */       return false;
/*     */     }
/*  41 */     if (!RoleInterface.isRoleExist(this.strangerId, false))
/*     */     {
/*  43 */       GameServer.logger().error(String.format("[chat]PCChatToSomeOne.processImp@ stranger not exist!|roleId=%d|strangerId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.strangerId) }));
/*     */       
/*     */ 
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  53 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  55 */       GameServer.logger().info(String.format("[chat]PCChatToSomeOne.processImp@ can not chat in roam server!|roleId=%d|strangerId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.strangerId) }));
/*     */       
/*     */ 
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     Set<Long> lockRoles = new HashSet();
/*  62 */     lockRoles.add(Long.valueOf(this.roleId));
/*  63 */     lockRoles.add(Long.valueOf(this.strangerId));
/*     */     
/*     */ 
/*  66 */     lock(Basic.getTable(), lockRoles);
/*     */     
/*     */ 
/*  69 */     SChatToSomeOne chatToSomeOne = new SChatToSomeOne();
/*  70 */     RoleChatManager.fillRoleInfoInChatContent(this.roleId, chatToSomeOne.chatcontent, this.content, this.contenttype);
/*  71 */     chatToSomeOne.senderid = this.roleId;
/*  72 */     chatToSomeOne.listenerid = this.strangerId;
/*     */     
/*  74 */     if (!RoleChatManager.isPlatformTalkForbid(this.roleId))
/*     */     {
/*     */ 
/*  77 */       if (OnlineManager.getInstance().isOnline(this.strangerId))
/*     */       {
/*  79 */         OnlineManager.getInstance().send(this.strangerId, chatToSomeOne);
/*     */       }
/*     */       else
/*     */       {
/*  83 */         ChatStorageManager.addChatInfo(this.roleId, chatToSomeOne, this.strangerId);
/*     */       }
/*     */     }
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
/*  96 */     OnlineManager.getInstance().send(this.roleId, chatToSomeOne);
/*     */     
/*  98 */     RoleChatManager.afterChat(this.roleId, 7);
/*     */     
/*     */ 
/* 101 */     IdipManager.chatTLog(this.roleId, 0L, 0L, this.strangerId, 6, null, this.content);
/*     */     
/* 103 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PCChatToSomeOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */