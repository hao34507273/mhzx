/*    */ package mzm.gsp.crossbattle.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.crossbattle.knockout.FightStageEndCorpsInfo;
/*    */ 
/*    */ 
/*    */ public class GetFightStageEndCorpsInfoArg
/*    */ {
/*    */   public final int retcode;
/*    */   public final long corpsId;
/*    */   public final FightStageEndCorpsInfo corpsInfo;
/*    */   public final Octets octets;
/*    */   
/*    */   public GetFightStageEndCorpsInfoArg(int retcode, long corpsId, FightStageEndCorpsInfo corpsInfo, Octets octets)
/*    */   {
/* 16 */     this.retcode = retcode;
/* 17 */     this.corpsId = corpsId;
/* 18 */     this.corpsInfo = corpsInfo;
/* 19 */     this.octets = octets;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isSucceed()
/*    */   {
/* 29 */     return this.retcode == 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\event\GetFightStageEndCorpsInfoArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */