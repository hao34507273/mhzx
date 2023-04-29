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
/*    */ public class ReportSpeakerMicStatus
/*    */   extends __ReportSpeakerMicStatus__
/*    */ {
/*    */   protected void onServer() {}
/*    */   
/*    */   protected void onClient()
/*    */   {
/* 21 */     if (((ReportSpeakerMicStatusRes)getResult()).retcode != 0)
/*    */     {
/* 23 */       ApolloInterface.onReportSpeakerMicStatusTimeout(this);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeout(int code)
/*    */   {
/* 30 */     ApolloInterface.onReportSpeakerMicStatusTimeout(this);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 36 */     return 12006;
/*    */   }
/*    */   
/*    */   public ReportSpeakerMicStatus() {
/* 40 */     super.setArgument(new ReportSpeakerMicStatusArg());
/* 41 */     super.setResult(new ReportSpeakerMicStatusRes());
/*    */   }
/*    */   
/*    */   public ReportSpeakerMicStatus(ReportSpeakerMicStatusArg argument) {
/* 45 */     super.setArgument(argument);
/* 46 */     super.setResult(new ReportSpeakerMicStatusRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 50 */     return 20000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ReportSpeakerMicStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */