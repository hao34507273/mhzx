/*    */ package apollo;
/*    */ 
/*    */ import mzm.gsp.apollo.main.ApolloInterface;
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
/*    */ public class ReportSpeakerOnlineInfo
/*    */   extends __ReportSpeakerOnlineInfo__
/*    */ {
/*    */   protected void onServer() {}
/*    */   
/*    */   protected void onClient()
/*    */   {
/* 21 */     if (((ReportSpeakerOnlineInfoRes)getResult()).retcode != 0)
/*    */     {
/* 23 */       ApolloInterface.onReportSpeakerOnlineInfoTimeout(this);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeout(int code)
/*    */   {
/* 30 */     ApolloInterface.onReportSpeakerOnlineInfoTimeout(this);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 36 */     return 12005;
/*    */   }
/*    */   
/*    */   public ReportSpeakerOnlineInfo() {
/* 40 */     super.setArgument(new ReportSpeakerOnlineInfoArg());
/* 41 */     super.setResult(new ReportSpeakerOnlineInfoRes());
/*    */   }
/*    */   
/*    */   public ReportSpeakerOnlineInfo(ReportSpeakerOnlineInfoArg argument) {
/* 45 */     super.setArgument(argument);
/* 46 */     super.setResult(new ReportSpeakerOnlineInfoRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 50 */     return 20000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ReportSpeakerOnlineInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */