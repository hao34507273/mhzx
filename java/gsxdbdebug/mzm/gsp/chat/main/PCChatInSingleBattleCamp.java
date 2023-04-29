/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.chat.SChatInSingleBattleCamp;
/*    */ import mzm.gsp.singlebattle.main.RoleBattleBaseInfo;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleGlobalInfo;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCChatInSingleBattleCamp
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int contenttype;
/*    */   private Octets content;
/*    */   
/*    */   public PCChatInSingleBattleCamp(long roleId, int contenttype, Octets content)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.contenttype = contenttype;
/* 23 */     this.content = content;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     RoleBattleBaseInfo baseInfo = SingleBattleInterface.getRoleBattleBaseInfo(this.roleId, false);
/* 30 */     if (baseInfo == null)
/*    */     {
/* 32 */       GameServer.logger().error(String.format("[chat]PCChatInSingleBattleCamp.processImp@ baseInfo is null!|roleId=%d|campId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       
/* 34 */       return false;
/*    */     }
/* 36 */     SingleBattleGlobalInfo globalInfo = SingleBattleInterface.getSingleBattleGlobalInfo(baseInfo.getBattleId(), false);
/* 37 */     if (globalInfo == null)
/*    */     {
/* 39 */       GameServer.logger().error(String.format("[chat]PCChatInSingleBattleCamp.processImp@ globalInfo is null!|roleId=%d|campId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(baseInfo.getBattleId()) }));
/*    */       
/*    */ 
/* 42 */       return false;
/*    */     }
/* 44 */     if ((this.content == null) || (this.content.getBytes().length < 1))
/*    */     {
/* 46 */       return false;
/*    */     }
/* 48 */     if (!RoleChatManager.canRoleSpk(this.contenttype, this.content, this.roleId, 13))
/*    */     {
/* 50 */       GameServer.logger().error(String.format("[chat]PCChatInSingleBattleCamp.processImp@ canRoleSpk is forbid!|roleId=%d|campId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       
/*    */ 
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     SChatInSingleBattleCamp schatInCamp = new SChatInSingleBattleCamp();
/* 57 */     RoleChatManager.fillRoleInfoInChatContent(this.roleId, schatInCamp.chatcontent, this.content, this.contenttype);
/* 58 */     globalInfo.campBro(baseInfo.getCampId(), schatInCamp, false);
/*    */     
/* 60 */     RoleChatManager.afterChat(this.roleId, 13);
/*    */     
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PCChatInSingleBattleCamp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */