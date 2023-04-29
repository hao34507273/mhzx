/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetFightStageCorpsIdListArg
/*    */ {
/*    */   public final int activityCfgId;
/*    */   public final int knockOutType;
/*    */   public final int fightStage;
/*    */   public final Set<Long> corpsIdSet;
/*    */   public final Octets octets;
/*    */   public final int retcode;
/*    */   
/*    */   public GetFightStageCorpsIdListArg(int activityCfgId, int knockOutType, int fightStage, Set<Long> corpsIdSet, Octets octets, int retcode)
/*    */   {
/* 24 */     this.activityCfgId = activityCfgId;
/* 25 */     this.knockOutType = knockOutType;
/* 26 */     this.fightStage = fightStage;
/* 27 */     this.corpsIdSet = corpsIdSet;
/* 28 */     this.octets = octets;
/* 29 */     this.retcode = retcode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isSucceed()
/*    */   {
/* 39 */     return this.retcode == 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isTimeout()
/*    */   {
/* 49 */     return this.retcode == 8;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getRetCode()
/*    */   {
/* 59 */     return this.retcode;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\GetFightStageCorpsIdListArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */