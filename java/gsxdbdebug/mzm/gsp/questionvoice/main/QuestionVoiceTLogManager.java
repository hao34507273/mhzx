/*    */ package mzm.gsp.questionvoice.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QuestionVoiceTLogManager
/*    */ {
/*    */   private static final String TLOG_QUESTION_VOICE_ACTIVITY = "QuestionVoiceActivity";
/*    */   
/*    */   public static void tlogQuestionVoice(long roleid, int activityid, int questionid, boolean isright, int chooseIndex)
/*    */   {
/* 22 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 23 */     String userid = RoleInterface.getUserId(roleid);
/* 24 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 25 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(activityid), Integer.valueOf(questionid), Integer.valueOf(isright ? 1 : 0), Integer.valueOf(chooseIndex) });
/*    */     
/* 27 */     TLogManager.getInstance().addLog(userid, "QuestionVoiceActivity", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\QuestionVoiceTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */