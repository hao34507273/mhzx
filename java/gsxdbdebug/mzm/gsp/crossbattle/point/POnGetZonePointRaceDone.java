/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossbattle.GetZonePointRaceContext;
/*    */ import mzm.gsp.crossbattle.SGetPointRaceRankLocalFail;
/*    */ import mzm.gsp.crossserver.event.GetZonePointRaceDoneArg;
/*    */ import mzm.gsp.crossserver.event.GetZonePointRaceDoneProcedure;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class POnGetZonePointRaceDone
/*    */   extends GetZonePointRaceDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     boolean success = ((GetZonePointRaceDoneArg)this.arg).isSucceed();
/* 20 */     int activityCfgid = ((GetZonePointRaceDoneArg)this.arg).getActivityCfgid();
/* 21 */     int zone = ((GetZonePointRaceDoneArg)this.arg).getZone();
/*    */     
/* 23 */     GetZonePointRaceContext context = new GetZonePointRaceContext();
/* 24 */     context.unmarshal(new OctetsStream(((GetZonePointRaceDoneArg)this.arg).getContext()));
/*    */     
/* 26 */     switch (context.oper_type)
/*    */     {
/*    */     case 2: 
/* 29 */       if (success)
/*    */       {
/* 31 */         List<CorpsPointRaceInfo> data = ((GetZonePointRaceDoneArg)this.arg).getCorpsPointRaceInfos() == null ? new ArrayList() : new ArrayList(((GetZonePointRaceDoneArg)this.arg).getCorpsPointRaceInfos());
/*    */         
/* 33 */         CrossBattlePointManager.onGetZonePointRace(activityCfgid, zone, data);
/*    */       }
/*    */       else
/*    */       {
/* 37 */         OctetsStream contextOs = new OctetsStream();
/* 38 */         contextOs.marshal(context);
/* 39 */         CrossServerInterface.asyncGetZonePointRace(activityCfgid, zone, contextOs);
/*    */       }
/* 41 */       break;
/*    */     case 1: 
/* 43 */       OctetsStream reqOs = new OctetsStream(context.content);
/* 44 */       long roleid = reqOs.unmarshal_long();
/* 45 */       int from = reqOs.unmarshal_int();
/* 46 */       int to = reqOs.unmarshal_int();
/* 47 */       int index = reqOs.unmarshal_int();
/*    */       
/* 49 */       if (success)
/*    */       {
/* 51 */         List<CorpsPointRaceInfo> data = ((GetZonePointRaceDoneArg)this.arg).getCorpsPointRaceInfos() == null ? new ArrayList() : new ArrayList(((GetZonePointRaceDoneArg)this.arg).getCorpsPointRaceInfos());
/*    */         
/* 53 */         CrossBattlePointManager.onGetZonePointRaceDataDone(roleid, activityCfgid, zone, from, to, index, Collections.unmodifiableList(data));
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 58 */         SGetPointRaceRankLocalFail rsp = new SGetPointRaceRankLocalFail();
/* 59 */         rsp.retcode = -5;
/* 60 */         rsp.activity_cfgid = activityCfgid;
/* 61 */         rsp.time_point_cfgid = index;
/* 62 */         rsp.zone = zone;
/* 63 */         rsp.from = from;
/* 64 */         rsp.to = to;
/* 65 */         OnlineManager.getInstance().sendAtOnce(roleid, rsp);
/*    */       }
/* 67 */       break;
/*    */     }
/*    */     
/*    */     
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnGetZonePointRaceDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */