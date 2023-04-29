/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ 
/*    */ public class PIDIPCmd_SetCheckpointPeriodReq extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 13 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 18 */         return new PIDIPCmd_SetCheckpointPeriodReq(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_SetCheckpointPeriodReq(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 25 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(java.util.List<Long> params)
/*    */     throws Exception
/*    */   {
/* 31 */     long period = ((Long)params.get(0)).longValue();
/*    */     
/* 33 */     if (period <= 60L)
/*    */     {
/* 35 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 36 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "period <= 60");
/* 37 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */       
/* 39 */       mzm.gsp.GameServer.logger().error(String.format("[idip]PIDIPCmd_SetCheckpointPeriodReq.executeCmd@period <= 0|area_id=%d|plat_id=%d|partition=%d|period=%d", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(period) }));
/*    */       
/*    */ 
/*    */ 
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     xdb.Xdb.getInstance().getConf().setCheckpointPeriod((int)(period * 1000L));
/* 47 */     boolean result = true;
/*    */     
/*    */ 
/* 50 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 51 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = String.format("checkpoint period = %d", new Object[] { Long.valueOf(period) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 59 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 61 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_SetCheckpointPeriodReq.executeCmd@set checkpoint period done|area_id=%d|plat_id=%d|partition=%d|period=%d|result=%b", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(period), Boolean.valueOf(true) }));
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_SetCheckpointPeriodReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */