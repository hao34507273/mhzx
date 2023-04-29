/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import hub.CrossCompeteUserDataBack;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.LoginManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCreateTeamBackContext extends LogicProcedure
/*    */ {
/* 14 */   private final List<CrossCompeteUserDataBack> userDataList = new ArrayList();
/*    */   
/*    */   public PCreateTeamBackContext(List<CrossCompeteUserDataBack> userDataList) {
/* 17 */     this.userDataList.addAll(userDataList);
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     List<String> userList = new ArrayList();
/* 23 */     List<Long> roleList = new ArrayList();
/*    */     
/* 25 */     for (CrossCompeteUserDataBack userData : this.userDataList) {
/* 26 */       userList.add(userData.userid);
/* 27 */       roleList.add(Long.valueOf(userData.roleid));
/*    */     }
/*    */     
/*    */ 
/* 31 */     lock(User.getTable(), userList);
/*    */     
/* 33 */     lock(Basic.getTable(), roleList);
/*    */     
/*    */ 
/* 36 */     boolean ret = true;
/* 37 */     for (CrossCompeteUserDataBack userData : this.userDataList) {
/* 38 */       Octets tokenOctets = LoginManager.getLocalToken(userData.userid);
/* 39 */       if (tokenOctets == null) {
/* 40 */         CrossCompeteManager.logWarn("PCreateTeamBackContext.processImp@no local token|userid=%s|roleid=%d", new Object[] { userData.userid, Long.valueOf(userData.roleid) });
/*    */         
/*    */ 
/* 43 */         ret = false;
/*    */       }
/* 45 */       else if (!tokenOctets.equals(userData.user_token)) {
/* 46 */         CrossCompeteManager.logWarn("PCreateTeamBackContext.processImp@token not match|userid=%s|roleid=%d", new Object[] { userData.userid, Long.valueOf(userData.roleid) });
/*    */         
/*    */ 
/* 49 */         ret = false;
/*    */       }
/*    */     }
/*    */     
/* 53 */     if (!ret) {
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     for (CrossCompeteUserDataBack userData : this.userDataList) {
/* 58 */       CrossCompeteManager.onCrossBack(userData.userid, userData.roleid);
/*    */     }
/*    */     
/* 61 */     TeamBackContext context = new TeamBackContext(roleList);
/* 62 */     long contextid = TeamBackContextManager.getInstance().addContext(context);
/*    */     
/* 64 */     TeamBackSession session = new TeamBackSession(60L, contextid);
/* 65 */     context.setSessionid(session.getSessionId());
/*    */     
/* 67 */     CrossCompeteManager.logInfo("PCreateTeamBackContext.processImp@create context succeed|users=%s|roles=%s|contextid=%d", new Object[] { userList, roleList, Long.valueOf(contextid) });
/*    */     
/*    */ 
/*    */ 
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\PCreateTeamBackContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */