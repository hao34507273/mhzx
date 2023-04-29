/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossbattle.point.CorpsPointRaceInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetZonePointRaceDoneArg
/*    */ {
/*    */   private final int retcode;
/*    */   private final int activityCfgid;
/*    */   private final int zone;
/*    */   private final Octets context;
/*    */   private final List<CorpsPointRaceInfo> corpsPointRaceInfos;
/*    */   
/*    */   public GetZonePointRaceDoneArg(int retcode, int activityCfgid, int zone, Octets context, List<CorpsPointRaceInfo> corpsPointRaceInfos)
/*    */   {
/* 20 */     this.retcode = retcode;
/* 21 */     this.activityCfgid = activityCfgid;
/* 22 */     this.zone = zone;
/* 23 */     this.context = context;
/* 24 */     this.corpsPointRaceInfos = corpsPointRaceInfos;
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
/*    */   public final Octets getContext()
/*    */   {
/* 64 */     return this.context;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getActivityCfgid()
/*    */   {
/* 74 */     return this.activityCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int getZone()
/*    */   {
/* 84 */     return this.zone;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public final List<CorpsPointRaceInfo> getCorpsPointRaceInfos()
/*    */   {
/* 94 */     return this.corpsPointRaceInfos;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GetZonePointRaceDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */