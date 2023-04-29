/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GetAllLottoAwardRoleInfoDoneArg
/*    */ {
/*    */   private final int retcode;
/*    */   private final int activityCfgid;
/*    */   private final Octets result;
/*    */   
/*    */   public GetAllLottoAwardRoleInfoDoneArg(int retcode, int activityCfgid, Octets result)
/*    */   {
/* 13 */     this.retcode = retcode;
/* 14 */     this.activityCfgid = activityCfgid;
/* 15 */     this.result = result;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isSucceed()
/*    */   {
/* 25 */     return this.retcode == 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isTimeout()
/*    */   {
/* 35 */     return this.retcode == 8;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getRetCode()
/*    */   {
/* 45 */     return this.retcode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getActivityCfgid()
/*    */   {
/* 55 */     return this.activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final Octets getResult()
/*    */   {
/* 65 */     return this.result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\GetAllLottoAwardRoleInfoDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */