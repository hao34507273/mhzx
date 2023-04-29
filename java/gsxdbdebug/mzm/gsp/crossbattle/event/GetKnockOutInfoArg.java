/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetKnockOutInfoArg
/*    */ {
/*    */   public final int activityCfgId;
/*    */   public final int knockOutType;
/*    */   public final int fightZoneId;
/*    */   public Octets octets;
/*    */   public int retcode;
/*    */   
/*    */   public GetKnockOutInfoArg(int activityCfgId, int knockOutType, int fightZoneId, Octets octets, int retcode)
/*    */   {
/* 20 */     this.activityCfgId = activityCfgId;
/* 21 */     this.knockOutType = knockOutType;
/* 22 */     this.fightZoneId = fightZoneId;
/* 23 */     this.octets = octets;
/* 24 */     this.retcode = retcode;
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
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\GetKnockOutInfoArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */