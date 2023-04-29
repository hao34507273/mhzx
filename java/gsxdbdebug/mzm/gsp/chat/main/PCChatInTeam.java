/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.List;
/*    */ import mzm.gsp.chat.SChatInTeam;
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCChatInTeam
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int contenttype;
/*    */   private Octets content;
/*    */   
/*    */   public PCChatInTeam(long roleId, int contenttype, Octets content)
/*    */   {
/* 24 */     this.roleId = roleId;
/* 25 */     this.contenttype = contenttype;
/* 26 */     this.content = content;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     if ((this.content == null) || (this.content.getBytes().length < 1)) {
/* 33 */       return false;
/*    */     }
/* 35 */     if (!RoleChatManager.canRoleSpk(this.contenttype, this.content, this.roleId, 3))
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 41 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/* 42 */     if (teamId == null)
/*    */     {
/* 44 */       RoleChatManager.sendFailMoreProc(this.roleId, 3, 20, this.content, this.contenttype);
/* 45 */       return false;
/*    */     }
/* 47 */     List<Long> roleIds = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*    */     
/*    */ 
/* 50 */     SChatInTeam schatInTeam = new SChatInTeam();
/* 51 */     RoleChatManager.fillRoleInfoInChatContent(this.roleId, schatInTeam.chatcontent, this.content, this.contenttype);
/* 52 */     fillPosition(schatInTeam);
/*    */     
/* 54 */     if (RoleChatManager.isPlatformTalkForbid(this.roleId))
/*    */     {
/* 56 */       OnlineManager.getInstance().send(this.roleId, schatInTeam);
/*    */     }
/*    */     else
/*    */     {
/* 60 */       OnlineManager.getInstance().sendMulti(schatInTeam, roleIds);
/*    */     }
/*    */     
/* 63 */     RoleChatManager.afterChat(this.roleId, 3);
/*    */     
/*    */ 
/* 66 */     IdipManager.chatTLog(this.roleId, 0L, teamId.longValue(), 0L, 3, null, this.content);
/*    */     
/* 68 */     return true;
/*    */   }
/*    */   
/*    */   private void fillPosition(SChatInTeam schatInTeam)
/*    */   {
/* 73 */     long leader = TeamInterface.getTeamLeaderByRoleid(this.roleId, false, false);
/* 74 */     if (leader == this.roleId)
/*    */     {
/* 76 */       schatInTeam.position = 1;
/*    */     }
/*    */     else
/*    */     {
/* 80 */       schatInTeam.position = 2;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PCChatInTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */