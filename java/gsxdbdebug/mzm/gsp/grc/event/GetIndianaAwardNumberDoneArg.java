/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetIndianaAwardNumberDoneArg
/*    */ {
/*    */   private final int retcode;
/*    */   private final int activityCfgid;
/*    */   private final int turn;
/*    */   private final int sortid;
/*    */   private final Octets result;
/*    */   
/*    */   public GetIndianaAwardNumberDoneArg(int retcode, int activityCfgid, int turn, int sortid, Octets result)
/*    */   {
/* 20 */     this.retcode = retcode;
/* 21 */     this.activityCfgid = activityCfgid;
/* 22 */     this.turn = turn;
/* 23 */     this.sortid = sortid;
/* 24 */     this.result = result;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isSucceed()
/*    */   {
/* 34 */     return this.retcode == 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isTimeout()
/*    */   {
/* 44 */     return this.retcode == 8;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getRetCode()
/*    */   {
/* 54 */     return this.retcode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getActivityCfgid()
/*    */   {
/* 64 */     return this.activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getTurn()
/*    */   {
/* 74 */     return this.turn;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getSortid()
/*    */   {
/* 84 */     return this.sortid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final Octets getResult()
/*    */   {
/* 94 */     return this.result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\GetIndianaAwardNumberDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */