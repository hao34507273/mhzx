/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ import idip.core.IdipHeader;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityForIDIPResult;
/*    */ 
/*    */ public class PIDIPCmd_ActivityPause extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 16 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 21 */         return new PIDIPCmd_ActivityPause(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_ActivityPause(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 28 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(List<Long> params)
/*    */     throws Exception
/*    */   {
/* 34 */     int activityId = ((Long)params.get(0)).intValue();
/* 35 */     boolean pause = ((Long)params.get(1)).longValue() == 1L;
/*    */     
/* 37 */     ActivityForIDIPResult result = mzm.gsp.activity.main.ActivityInterface.pauseActivityForIDIP(activityId, pause);
/*    */     
/* 39 */     if (result == ActivityForIDIPResult.SUCCESS)
/*    */     {
/* 41 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 42 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = String.format("activityId=%d %s", new Object[] { Integer.valueOf(activityId), pause ? "pasued" : "recovery" }));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 47 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = result.retCode + 64286);
/* 48 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = result.retString);
/*    */     }
/*    */     
/* 51 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 53 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_ActivityPause.executeCmd@activity pause done|ret=%d|retMsg=%s|area_id=%d|plat_id=%d|partition=%d|activityId=%d|isPause=%b", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Integer.valueOf(activityId), Boolean.valueOf(pause) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 58 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_ActivityPause.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */