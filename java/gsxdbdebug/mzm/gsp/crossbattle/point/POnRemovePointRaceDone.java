/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.RemovePointRaceContext;
/*    */ import mzm.gsp.crossserver.event.RemovePointRaceDoneArg;
/*    */ import mzm.gsp.crossserver.event.RemovePointRaceDoneProcedure;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ 
/*    */ public class POnRemovePointRaceDone extends RemovePointRaceDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     boolean success = ((RemovePointRaceDoneArg)this.arg).isSucceed();
/* 15 */     int activityCfgid = ((RemovePointRaceDoneArg)this.arg).getActivityCfgid();
/* 16 */     int zone = ((RemovePointRaceDoneArg)this.arg).getZone();
/* 17 */     int timePointCfgid = ((RemovePointRaceDoneArg)this.arg).getTimePointCfgid();
/*    */     
/* 19 */     RemovePointRaceContext context = new RemovePointRaceContext();
/* 20 */     context.unmarshal(new OctetsStream(((RemovePointRaceDoneArg)this.arg).getContext()));
/*    */     
/* 22 */     switch (context.oper_type)
/*    */     {
/*    */     case 1: 
/* 25 */       if (!success)
/*    */       {
/* 27 */         OctetsStream contextOs = new OctetsStream();
/* 28 */         contextOs.marshal(context);
/* 29 */         CrossServerInterface.asyncRemovePointRace(activityCfgid, zone, timePointCfgid, contextOs);
/*    */       }
/*    */       else
/*    */       {
/* 33 */         GameServer.logger().info(String.format("[crossbattlepoint]POnRemovePointRaceDone.processImp@remove done|activity_cfgid=%d|zone=%d|time_point_cfgid=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(zone), Integer.valueOf(timePointCfgid) }));
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 38 */       break;
/*    */     }
/*    */     
/*    */     
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnRemovePointRaceDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */