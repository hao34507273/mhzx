/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.teamplatform.SSendMatchMembers;
/*    */ import mzm.gsp.teamplatform.TeamInfo;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.MatchKey;
/*    */ import xbean.MatchQueue;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCCheckMatchMembers
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int matchCfgId;
/*    */   private final int index;
/*    */   
/*    */   public PCCheckMatchMembers(long roleId, int matchCfgId, int index)
/*    */   {
/* 26 */     this.roleId = roleId;
/* 27 */     this.matchCfgId = matchCfgId;
/* 28 */     this.index = index;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     MatchQueue xMatchQueue = TeamMatchMananger.getMatchQueue(false);
/* 36 */     int leadersNum = 0;
/* 37 */     int siglesNum = 0;
/* 38 */     ArrayList<TeamInfo> leadersinfo = new ArrayList();
/* 39 */     if (xMatchQueue != null)
/*    */     {
/* 41 */       MatchKey matchKey = new MatchKey(this.matchCfgId, this.index);
/* 42 */       leadersNum = TeamMatchMananger.getMatchQueueLeadersNum(xMatchQueue, matchKey);
/* 43 */       siglesNum = TeamMatchMananger.getMatchQueueRolesNum(xMatchQueue, matchKey);
/* 44 */       int roleLevel = RoleInterface.getLevel(this.roleId);
/* 45 */       TeamMatchMananger.fillLeadersInfo(xMatchQueue, matchKey, this.matchCfgId, this.index, roleLevel, leadersinfo);
/*    */     }
/* 47 */     send2ClientNum(leadersNum, siglesNum, leadersinfo);
/* 48 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   void send2ClientNum(int leadersNum, int siglesNum, ArrayList<TeamInfo> leadersinfo)
/*    */   {
/* 57 */     SSendMatchMembers pro = new SSendMatchMembers();
/* 58 */     pro.leadersnum = leadersNum;
/* 59 */     pro.rolesnum = siglesNum;
/* 60 */     pro.leadersinfo = leadersinfo;
/* 61 */     OnlineManager.getInstance().send(this.roleId, pro);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\PCCheckMatchMembers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */