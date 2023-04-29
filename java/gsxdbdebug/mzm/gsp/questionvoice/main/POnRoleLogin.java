/*    */ package mzm.gsp.questionvoice.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import xbean.QuestionVoiceBean;
/*    */ import xbean.QuestionVoiceInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2question_voice_info;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 22 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/* 23 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 25 */     QuestionVoiceInfo xQuestionVoiceInfo = Role2question_voice_info.get(Long.valueOf(roleId));
/* 26 */     if (xQuestionVoiceInfo == null)
/*    */     {
/* 28 */       xQuestionVoiceInfo = xbean.Pod.newQuestionVoiceInfo();
/* 29 */       Role2question_voice_info.insert(Long.valueOf(roleId), xQuestionVoiceInfo);
/* 30 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 35 */     for (Iterator<Map.Entry<Integer, QuestionVoiceBean>> it = xQuestionVoiceInfo.getActivity2question_voice().entrySet().iterator(); it.hasNext();)
/*    */     {
/* 37 */       Map.Entry<Integer, QuestionVoiceBean> xEntry = (Map.Entry)it.next();
/* 38 */       int activityId = ((Integer)xEntry.getKey()).intValue();
/*    */       
/* 40 */       if (!QuestionVoiceManager.isFunOpen(roleId, activityId))
/*    */       {
/* 42 */         it.remove();
/*    */       }
/*    */       
/* 45 */       ActivityJoinResult res = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, activityId);
/* 46 */       if (!res.isCanJoin())
/*    */       {
/* 48 */         it.remove();
/*    */       }
/*    */     }
/*    */     
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */