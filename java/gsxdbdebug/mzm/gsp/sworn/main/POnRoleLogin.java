/*    */ package mzm.gsp.sworn.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.title.confbean.SwornConsts;
/*    */ import mzm.gsp.title.main.TitleInterface;
/*    */ import xbean.SwornMember;
/*    */ import xbean.SwornNewMember;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     SwornMember swornMember = xtable.Role2swornmember.get((Long)this.arg);
/* 17 */     if (swornMember == null)
/* 18 */       return false;
/* 19 */     long swornid = swornMember.getSwornid();
/* 20 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), new mzm.gsp.sworn.SRoleSwornId(swornid));
/*    */     
/*    */ 
/* 23 */     xbean.Sworn sworn = xtable.Sworn.get(Long.valueOf(swornid));
/* 24 */     if (sworn != null) {
/* 25 */       OnlineManager.getInstance().sendMulti(new mzm.gsp.sworn.SMemberLoginRes(((Long)this.arg).longValue()), sworn.getMembers());
/*    */     }
/*    */     
/*    */ 
/* 29 */     if (sworn.getMembers().size() == 2)
/*    */     {
/* 31 */       List<String> argsList = TitleInterface.getAppArgs(((Long)this.arg).longValue(), SwornConsts.getInstance().SWORN_TITLE_CFGID, true);
/*    */       
/* 33 */       String rightNumber = SwornManager.getSwornNameNumber(2);
/* 34 */       if ((argsList.size() > 2) && (!((String)argsList.get(1)).equals(rightNumber)))
/*    */       {
/* 36 */         argsList.set(1, rightNumber);
/* 37 */         TitleInterface.replaceAppellationArgs(((Long)this.arg).longValue(), SwornConsts.getInstance().SWORN_TITLE_CFGID, argsList);
/*    */       }
/*    */     }
/*    */     
/* 41 */     int voteType = SwornManager.checkSwornVote(sworn);
/* 42 */     if ((voteType != 0) && (!SwornManager.isSwornVoteSession(swornid))) {
/* 43 */       switch (voteType) {
/*    */       case 1: 
/* 45 */         SwornNewMember newMemberInfo = (SwornNewMember)((Map.Entry)sworn.getNewmember().entrySet().iterator().next()).getValue();
/* 46 */         SwornManager.addSwornVoteSession(swornid, newMemberInfo.getVerifytime(), voteType);
/* 47 */         break;
/*    */       
/*    */       case 3: 
/* 50 */         SwornManager.addSwornVoteSession(swornid, sworn.getKickoutmember().getVerifytime(), voteType);
/* 51 */         break;
/*    */       case 2: 
/* 53 */         SwornManager.addSwornVoteSession(swornid, sworn.getNewname().getVerifytime(), voteType);
/*    */       }
/*    */       
/*    */     }
/*    */     
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */