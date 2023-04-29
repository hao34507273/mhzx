/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.ArrayList;
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
/*    */ class PJoinGangTeamMail
/*    */   extends LogicProcedure
/*    */ {
/*    */   private String gangTeamName;
/*    */   private final long newMemberid;
/* 22 */   private final List<Long> roles = new ArrayList();
/*    */   
/*    */   PJoinGangTeamMail(String gangTeamName, long newMemberid, List<Long> roles) {
/* 25 */     this.gangTeamName = gangTeamName;
/* 26 */     this.newMemberid = newMemberid;
/* 27 */     this.roles.addAll(roles);
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 32 */     StringBuilder namesBuilder = new StringBuilder();
/* 33 */     for (int i = 0; i < this.roles.size(); i++)
/*    */     {
/* 35 */       String name = RoleInterface.getName(((Long)this.roles.get(i)).longValue());
/* 36 */       namesBuilder.append(name);
/* 37 */       if (i != this.roles.size() - 1) {
/* 38 */         namesBuilder.append(",");
/*    */       }
/*    */     }
/* 41 */     String allNames = namesBuilder.toString();
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 46 */     TLogArg oldMemberTLogArg = new TLogArg(LogReason.GANG_TEAM_JOIN_TO_OTHERS_MAIL);
/* 47 */     TLogArg newMemberTLogArg = new TLogArg(LogReason.GANG_TEAM_JOIN_TO_SELF_MAIL);
/*    */     
/* 49 */     List<String> oldContentArgs = new ArrayList();
/*    */     
/* 51 */     oldContentArgs.add(RoleInterface.getName(this.newMemberid));
/* 52 */     oldContentArgs.add(allNames);
/*    */     
/* 54 */     List<String> newContentArgs = new ArrayList();
/* 55 */     newContentArgs.add(this.gangTeamName);
/* 56 */     newContentArgs.add(allNames);
/*    */     
/* 58 */     for (Iterator i$ = this.roles.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 59 */       if (r == this.newMemberid) {
/* 60 */         MailInterface.asynBuildAndSendMail(r, SGangTeamConst.getInstance().JoinTeamMailToSelf, null, newContentArgs, newMemberTLogArg);
/*    */       }
/*    */       else
/*    */       {
/* 64 */         MailInterface.asynBuildAndSendMail(r, SGangTeamConst.getInstance().JoinTeamMailToOthers, null, oldContentArgs, oldMemberTLogArg);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 69 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PJoinGangTeamMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */