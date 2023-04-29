/*    */ package csprovider;
/*    */ 
/*    */ import mzm.gsp.csprovider.ssp.SSPContext;
/*    */ import mzm.gsp.csprovider.ssp.SSPInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DataBetweenGameAndSocialSpace
/*    */   extends __DataBetweenGameAndSocialSpace__
/*    */ {
/*    */   private SSPContext context;
/*    */   
/*    */   public void setSSPContext(SSPContext context)
/*    */   {
/* 16 */     this.context = context;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onServer()
/*    */   {
/* 22 */     SSPInterface.onServer((DataBetweenGameAndSocialSpaceArg)getArgument(), (DataBetweenGameAndSocialSpaceRes)getResult());
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onClient()
/*    */   {
/* 28 */     SSPInterface.onClient((DataBetweenGameAndSocialSpaceArg)getArgument(), (DataBetweenGameAndSocialSpaceRes)getResult(), this.context);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeout(int code)
/*    */   {
/* 34 */     SSPInterface.onTimeout((DataBetweenGameAndSocialSpaceArg)getArgument(), (DataBetweenGameAndSocialSpaceRes)getResult(), this.context);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 40 */     return 10029;
/*    */   }
/*    */   
/*    */   public DataBetweenGameAndSocialSpace() {
/* 44 */     super.setArgument(new DataBetweenGameAndSocialSpaceArg());
/* 45 */     super.setResult(new DataBetweenGameAndSocialSpaceRes());
/*    */   }
/*    */   
/*    */   public DataBetweenGameAndSocialSpace(DataBetweenGameAndSocialSpaceArg argument) {
/* 49 */     super.setArgument(argument);
/* 50 */     super.setResult(new DataBetweenGameAndSocialSpaceRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 54 */     return 20000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\csprovider\DataBetweenGameAndSocialSpace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */