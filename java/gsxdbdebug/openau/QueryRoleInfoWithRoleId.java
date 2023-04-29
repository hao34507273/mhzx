/*    */ package openau;
/*    */ 
/*    */ import mzm.gsp.qingfu.main.PQueryRoleInfoWithRoleId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QueryRoleInfoWithRoleId
/*    */   extends __QueryRoleInfoWithRoleId__
/*    */ {
/*    */   protected void onServer()
/*    */   {
/* 16 */     new PQueryRoleInfoWithRoleId((QueryRoleInfoWithRoleIdArg)getArgument(), (QueryRoleInfoWithRoleIdRes)getResult()).call();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onClient() {}
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onTimeout(int code) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 8907;
/*    */   }
/*    */   
/*    */   public QueryRoleInfoWithRoleId() {
/* 36 */     super.setArgument(new QueryRoleInfoWithRoleIdArg());
/* 37 */     super.setResult(new QueryRoleInfoWithRoleIdRes());
/*    */   }
/*    */   
/*    */   public QueryRoleInfoWithRoleId(QueryRoleInfoWithRoleIdArg argument) {
/* 41 */     super.setArgument(argument);
/* 42 */     super.setResult(new QueryRoleInfoWithRoleIdRes());
/*    */   }
/*    */   
/*    */   public int getTimeout() {
/* 46 */     return 20000;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\openau\QueryRoleInfoWithRoleId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */