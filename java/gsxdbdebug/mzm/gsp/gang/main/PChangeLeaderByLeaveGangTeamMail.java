/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.gang.confbean.SGangTeamConst;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PChangeLeaderByLeaveGangTeamMail
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long oldLeaderid;
/*    */   private final long newLeaderid;
/* 24 */   private final List<Long> members = new ArrayList();
/*    */   
/*    */   PChangeLeaderByLeaveGangTeamMail(long oldLeaderid, long newLeaderid, Collection<Long> members) {
/* 27 */     this.oldLeaderid = oldLeaderid;
/* 28 */     this.newLeaderid = newLeaderid;
/* 29 */     this.members.addAll(members);
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     String oldLeaderName = RoleInterface.getName(this.oldLeaderid);
/* 36 */     String newLeaderName = RoleInterface.getName(this.newLeaderid);
/*    */     
/* 38 */     TLogArg tlogArg = new TLogArg(LogReason.GANG_TEAM_LEADER_CHANGE_BY_LEAVE_MAIL);
/* 39 */     List<String> contentArgs = new ArrayList();
/* 40 */     contentArgs.add(oldLeaderName);
/* 41 */     contentArgs.add(newLeaderName);
/*    */     
/*    */ 
/* 44 */     for (Iterator i$ = this.members.iterator(); i$.hasNext();) { long memberid = ((Long)i$.next()).longValue();
/* 45 */       MailInterface.asynBuildAndSendMail(memberid, SGangTeamConst.getInstance().ChangeTeamLeaderByLeaveTeamMail, null, contentArgs, tlogArg);
/*    */     }
/*    */     
/*    */ 
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PChangeLeaderByLeaveGangTeamMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */