/*    */ package mzm.gsp.task.condition;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.friend.main.FriendInterface;
/*    */ import mzm.gsp.task.confbean.STaskConteam;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.ConBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Con_Team_7
/*    */   extends AbsCondition
/*    */ {
/*    */   public Con_Team_7(int conId, int conType, int sTaskId)
/*    */   {
/* 24 */     super(conId, conType, sTaskId);
/*    */   }
/*    */   
/*    */   STaskConteam getConteam()
/*    */   {
/* 29 */     return STaskConteam.get(getConId());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isComplete(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*    */   {
/* 35 */     STaskConteam conteam = getConteam();
/* 36 */     if (conteam.personCount == 1)
/*    */     {
/* 38 */       return true;
/*    */     }
/* 40 */     Long teamId = TeamInterface.getTeamidByRoleid(roleId, false);
/* 41 */     if (teamId == null)
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     List<Long> memerList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/* 47 */     if (memerList.size() < conteam.personCount)
/*    */     {
/* 49 */       return false;
/*    */     }
/* 51 */     Long teamLeaderId = Long.valueOf(TeamInterface.getTeamLeaderByTeamid(teamId.longValue(), false));
/* 52 */     if ((teamLeaderId == null) || (teamLeaderId.longValue() < 0L))
/*    */     {
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     for (Iterator i$ = memerList.iterator(); i$.hasNext();) { long memberId = ((Long)i$.next()).longValue();
/*    */       
/* 59 */       if (memberId != teamLeaderId.longValue())
/*    */       {
/*    */ 
/*    */ 
/* 63 */         int friendPoint = FriendInterface.getRelationValue(teamLeaderId.longValue(), memberId, false);
/* 64 */         if (friendPoint < conteam.friendPoint)
/*    */         {
/* 66 */           return false; }
/*    */       }
/*    */     }
/* 69 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 75 */     return 7;
/*    */   }
/*    */   
/*    */   public void checkCfg() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_Team_7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */