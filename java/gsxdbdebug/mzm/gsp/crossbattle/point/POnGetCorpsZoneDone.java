/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.GetCorpsZoneContext;
/*    */ import mzm.gsp.crossbattle.GetCorpsZoneReq;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.crossserver.event.GetCorpsZoneDoneArg;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnGetCorpsZoneDone extends mzm.gsp.crossserver.event.GetCorpsZoneDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     GetCorpsZoneReq req = new GetCorpsZoneReq();
/* 17 */     req.unmarshal(new OctetsStream(((GetCorpsZoneDoneArg)this.arg).getContext()));
/* 18 */     GetCorpsZoneContext context = new GetCorpsZoneContext();
/* 19 */     context.unmarshal(new OctetsStream(req.context));
/*    */     
/* 21 */     int activityCfgid = req.activity_cfgid;
/* 22 */     if (((GetCorpsZoneDoneArg)this.arg).isSucceed())
/*    */     {
/* 24 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PGetCorpsZoneDone(context.roleid, context.corpsid, activityCfgid, ((GetCorpsZoneDoneArg)this.arg).getData()));
/*    */       
/* 26 */       return true;
/*    */     }
/*    */     
/* 29 */     GameServer.logger().error(String.format("[crossbattlepoint]POnGetCorpsZoneDone.processImp@fail|retcode=%d|roleid=%d|corpsid=%d|count=%d", new Object[] { Integer.valueOf(((GetCorpsZoneDoneArg)this.arg).getRetcode()), Long.valueOf(context.roleid), Long.valueOf(context.corpsid), Integer.valueOf(context.count) }));
/*    */     
/*    */ 
/*    */ 
/* 33 */     if (context.count >= 3)
/*    */     {
/* 35 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PGetCorpsZoneDone(context.roleid, context.corpsid, activityCfgid, null));
/*    */       
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     context.count += 1;
/* 41 */     OctetsStream contextOs = new OctetsStream();
/* 42 */     contextOs.marshal(context);
/* 43 */     req.context = contextOs;
/*    */     
/* 45 */     OctetsStream reqOs = new OctetsStream();
/* 46 */     reqOs.marshal(req);
/*    */     
/*    */ 
/* 49 */     if (!CrossServerInterface.asyncGetCorpsZone(reqOs))
/*    */     {
/* 51 */       GameServer.logger().error(String.format("[crossbattlepoint]POnGetCorpsZoneDone.processImp@grc send msg failed|retcode=%d|roleid=%d|corpsid=%d|count=%d", new Object[] { Integer.valueOf(((GetCorpsZoneDoneArg)this.arg).getRetcode()), Long.valueOf(context.roleid), Long.valueOf(context.corpsid), Integer.valueOf(context.count) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\POnGetCorpsZoneDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */