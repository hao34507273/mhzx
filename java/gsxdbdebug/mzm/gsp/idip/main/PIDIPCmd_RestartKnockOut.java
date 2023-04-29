/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ 
/*    */ public class PIDIPCmd_RestartKnockOut extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 15 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 20 */         return new PIDIPCmd_RestartKnockOut(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_RestartKnockOut(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 27 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(List<Long> params)
/*    */     throws Exception
/*    */   {
/* 33 */     int activityCfgid = ((Long)params.get(0)).intValue();
/* 34 */     int knockOutType = ((Long)params.get(1)).intValue();
/* 35 */     int restartFightZoneId = ((Long)params.get(2)).intValue();
/* 36 */     int restartFightIndexId = ((Long)params.get(3)).intValue();
/* 37 */     long restartPrepareWorldBeginTimestamp = ((Long)params.get(4)).longValue();
/*    */     
/* 39 */     long time = java.util.concurrent.TimeUnit.SECONDS.toMillis(restartPrepareWorldBeginTimestamp);
/* 40 */     int result = mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface.restartKnockOut(activityCfgid, knockOutType, restartFightZoneId, restartFightIndexId, time);
/*    */     
/* 42 */     if (result < 0)
/*    */     {
/* 44 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = result);
/* 45 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "handle failed");
/* 46 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */       
/* 48 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_RestartKnockOut.executeCmd@handle failed|area_id=%d|plat_id=%d|partition=%d|activity_cfgid=%d|type=%d|fight_zoneid=%d|fight_indexid=%d|begin_timestamp=%d|retcode=%d", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Integer.valueOf(activityCfgid), Integer.valueOf(knockOutType), Integer.valueOf(restartFightZoneId), Integer.valueOf(restartFightIndexId), Long.valueOf(restartPrepareWorldBeginTimestamp), Integer.valueOf(result) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 57 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "ok");
/* 58 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 60 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_RestartKnockOut.executeCmd@handle success|area_id=%d|plat_id=%d|partition=%d|activity_cfgid=%d|type=%d|fight_zoneid=%d|fight_indexid=%d|begin_timestamp=%d|retcode=%d", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Integer.valueOf(activityCfgid), Integer.valueOf(knockOutType), Integer.valueOf(restartFightZoneId), Integer.valueOf(restartFightIndexId), Long.valueOf(restartPrepareWorldBeginTimestamp), Integer.valueOf(result) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_RestartKnockOut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */