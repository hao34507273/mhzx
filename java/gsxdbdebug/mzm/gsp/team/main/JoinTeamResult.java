/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JoinTeamResult
/*    */ {
/*    */   private boolean bSucceed;
/*    */   private Map<Receiver, Result> sender2Result;
/*    */   
/*    */   public JoinTeamResult()
/*    */   {
/* 19 */     this.sender2Result = new HashMap();
/*    */   }
/*    */   
/*    */   public static enum Receiver {
/* 23 */     Leader,  Member;
/*    */     
/*    */     private Receiver() {}
/*    */   }
/*    */   
/*    */   public static class Result {
/*    */     public final int res;
/*    */     public final List<String> args;
/*    */     
/*    */     public Result(int res, String... args) {
/* 33 */       this.res = res;
/* 34 */       this.args = new ArrayList();
/* 35 */       for (String arg : args)
/*    */       {
/* 37 */         this.args.add(arg);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isSucceed()
/*    */   {
/* 44 */     return this.bSucceed;
/*    */   }
/*    */   
/*    */   public void setSucceed(boolean bSucceed)
/*    */   {
/* 49 */     this.bSucceed = bSucceed;
/*    */   }
/*    */   
/*    */   public void addResult(Receiver receiver, Result res)
/*    */   {
/* 54 */     this.sender2Result.put(receiver, res);
/*    */   }
/*    */   
/*    */   public Map<Receiver, Result> getSender2Result()
/*    */   {
/* 59 */     return this.sender2Result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\JoinTeamResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */