/*    */ package mzm.gsp.drawandguess.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.DrawAndGuessInfo;
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
/*    */ 
/*    */ 
/*    */ public class DrawAndGuessInterface
/*    */ {
/*    */   public static boolean isInDrawAndGuess(long roleid)
/*    */   {
/* 21 */     return DrawAndGuessManager.isInDrawAndGuess(roleid);
/*    */   }
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
/*    */   public static void startDrawAndGuess(long drawerId, List<Long> memberIds, int ruleCfgid, IDrawAndGuessContext context)
/*    */   {
/* 35 */     DrawAndGuessManager.startDrawAndGuess(drawerId, memberIds, ruleCfgid, context);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String getAnswer(int questionCfgId)
/*    */   {
/* 46 */     return DrawAndGuessManager.getAnswer(questionCfgId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static int getAnswerResult(int questionCfgId, String answer)
/*    */   {
/* 58 */     return DrawAndGuessManager.getAnswerResult(questionCfgId, answer);
/*    */   }
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
/*    */   public static boolean checkAndSetAnswerInterval(long roleId, int interval, DrawAndGuessInfo drawAndGuessInfo)
/*    */   {
/* 72 */     return DrawAndGuessManager.checkAndSetAnswerInterval(roleId, interval, drawAndGuessInfo);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\DrawAndGuessInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */