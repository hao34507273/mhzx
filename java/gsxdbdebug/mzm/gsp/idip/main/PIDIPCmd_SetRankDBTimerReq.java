/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ import java.util.List;
/*    */ 
/*    */ public class PIDIPCmd_SetRankDBTimerReq extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 14 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 19 */         return new PIDIPCmd_SetRankDBTimerReq(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_SetRankDBTimerReq(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 26 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(List<Long> params)
/*    */     throws Exception
/*    */   {
/* 32 */     int number = ((Long)params.get(0)).intValue();
/*    */     
/* 34 */     if (number < 60)
/*    */     {
/* 36 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 37 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = String.format("save_rankdb_interval_sec < MIN_INTERVAL_SEC %d", new Object[] { Integer.valueOf(60) }));
/*    */       
/* 39 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */       
/* 41 */       mzm.gsp.GameServer.logger().error(String.format("[idip]PIDIPCmd_SetRankDBTimerReq.executeCmd@save_rankdb_interval_sec must >= MIN_INTERVAL_SEC %d|area_id=%d|plat_id=%d|partition=%d|save_rankdb_interval_sec=%d", new Object[] { Integer.valueOf(60), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Integer.valueOf(number) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     boolean result = new mzm.gsp.chart.main.PGM_SetSaveDBIntervalSec(number).call();
/* 50 */     if (result)
/*    */     {
/* 52 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 53 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = String.format("intervalSec=%d", new Object[] { Integer.valueOf(number) }));
/*    */     }
/*    */     else
/*    */     {
/* 57 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 58 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "system error");
/*    */     }
/* 60 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 62 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_SetRankDBTimerReq.executeCmd@set save_rankdb_interval_sec done|area_id=%d|plat_id=%d|partition=%d|save_rankdb_interval_sec=%d|result=%b", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Integer.valueOf(number), Boolean.valueOf(result) }));
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_SetRankDBTimerReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */