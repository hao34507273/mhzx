/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.TeamMember;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRmInvite
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long teamId;
/*    */   
/*    */   public PRmInvite(long roleId, long teamId)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.teamId = teamId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     xbean.Team xTeam = xtable.Team.get(Long.valueOf(this.teamId));
/* 29 */     if (xTeam == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     for (TeamMember xMember : xTeam.getMembers())
/*    */     {
/* 36 */       rmInvitee(xMember, this.roleId);
/*    */     }
/* 38 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean rmInvitee(TeamMember xMember, long invitee)
/*    */   {
/* 49 */     boolean find = false;
/* 50 */     Iterator<Long> it = xMember.getInvitees().iterator();
/* 51 */     while (it.hasNext())
/*    */     {
/* 53 */       long ownInvitee = ((Long)it.next()).longValue();
/* 54 */       if (ownInvitee == invitee)
/*    */       {
/*    */ 
/*    */ 
/* 58 */         it.remove();
/* 59 */         find = true;
/*    */       } }
/* 61 */     return find;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PRmInvite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */