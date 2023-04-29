/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ public class RemovePointRaceDoneArg
/*    */ {
/*    */   private final int retcode;
/*    */   private final int activityCfgid;
/*    */   private final int zone;
/*    */   private final int timePointCfgid;
/*    */   private final Octets context;
/*    */   
/*    */   public RemovePointRaceDoneArg(int retcode, int activityCfgid, int zone, int timePointCfgid, Octets context)
/*    */   {
/* 16 */     this.retcode = retcode;
/* 17 */     this.activityCfgid = activityCfgid;
/* 18 */     this.zone = zone;
/* 19 */     this.timePointCfgid = timePointCfgid;
/* 20 */     this.context = context;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isSucceed()
/*    */   {
/* 30 */     return this.retcode == 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean isTimeout()
/*    */   {
/* 40 */     return this.retcode == 8;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getRetCode()
/*    */   {
/* 50 */     return this.retcode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final Octets getContext()
/*    */   {
/* 60 */     return this.context;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getActivityCfgid()
/*    */   {
/* 70 */     return this.activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getZone()
/*    */   {
/* 80 */     return this.zone;
/*    */   }
/*    */   
/*    */   public final int getTimePointCfgid()
/*    */   {
/* 85 */     return this.timePointCfgid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\RemovePointRaceDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */