/*    */ package grc;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GrcUploadRoleInfo
/*    */   extends __GrcUploadRoleInfo__
/*    */ {
/*    */   protected void onServer() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onClient() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onTimeout(int code) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 10003;
/*    */   }
/*    */   
/*    */   public GrcUploadRoleInfo() {
/* 36 */     super.setArgument(new GrcUploadRoleInfoArg());
/* 37 */     super.setResult(new GrcUploadRoleInfoRes());
/*    */   }
/*    */   
/*    */   public GrcUploadRoleInfo(GrcUploadRoleInfoArg argument) {
/* 41 */     super.setArgument(argument);
/* 42 */     super.setResult(new GrcUploadRoleInfoRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 46 */     return 30000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcUploadRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */