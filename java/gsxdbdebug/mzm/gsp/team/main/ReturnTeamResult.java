/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReturnTeamResult
/*    */ {
/*    */   private boolean bSucceed;
/*    */   private Result result;
/*    */   
/*    */   public static class Result
/*    */   {
/*    */     public final int res;
/*    */     public final List<String> args;
/*    */     
/*    */     public Result(int res, String... args)
/*    */     {
/* 20 */       this.res = res;
/* 21 */       this.args = new ArrayList();
/* 22 */       for (String arg : args)
/*    */       {
/* 24 */         this.args.add(arg);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isSucceed()
/*    */   {
/* 31 */     return this.bSucceed;
/*    */   }
/*    */   
/*    */   public void setSucceed(boolean bSucceed)
/*    */   {
/* 36 */     this.bSucceed = bSucceed;
/*    */   }
/*    */   
/*    */   public Result getResult()
/*    */   {
/* 41 */     return this.result;
/*    */   }
/*    */   
/*    */   public void setResult(Result result)
/*    */   {
/* 46 */     this.result = result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\ReturnTeamResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */