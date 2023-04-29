/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ 
/*    */ public class PIDIPCmd_SetRemoteFlushRecordSpeedReq extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 13 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 18 */         return new PIDIPCmd_SetRemoteFlushRecordSpeedReq(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_SetRemoteFlushRecordSpeedReq(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 25 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(java.util.List<Long> params)
/*    */     throws Exception
/*    */   {
/* 31 */     long speed = ((Long)params.get(0)).longValue();
/*    */     
/* 33 */     if (speed <= 0L)
/*    */     {
/* 35 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 36 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "speed <= 0");
/* 37 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */       
/* 39 */       mzm.gsp.GameServer.logger().error(String.format("[idip]PIDIPCmd_SetRemoteFlushRecordSpeedReq.executeCmd@speed <= 0|area_id=%d|plat_id=%d|partition=%d|speed=%d", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(speed) }));
/*    */       
/*    */ 
/*    */ 
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     xdb.Xdb.getInstance().getConf().setRemoteFlushRecordSpeed((int)speed);
/* 47 */     boolean result = true;
/*    */     
/*    */ 
/* 50 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 51 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = String.format("remote flush record speed = %d", new Object[] { Long.valueOf(speed) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 59 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 61 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_SetRemoteFlushRecordSpeedReq.executeCmd@set remote flush record speed done|area_id=%d|plat_id=%d|partition=%d|speed=%d|result=%b", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(speed), Boolean.valueOf(true) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 66 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_SetRemoteFlushRecordSpeedReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */