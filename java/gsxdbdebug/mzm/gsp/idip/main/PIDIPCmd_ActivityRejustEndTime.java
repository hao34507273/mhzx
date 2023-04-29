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
/*    */ public class PIDIPCmd_ActivityRejustEndTime extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 16 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 21 */         return new PIDIPCmd_ActivityRejustEndTime(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_ActivityRejustEndTime(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 28 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(List<Long> params)
/*    */     throws Exception
/*    */   {
/* 34 */     int activityId = ((Long)params.get(0)).intValue();
/*    */     
/* 36 */     ActivityForIDIPResult result = mzm.gsp.activity.main.ActivityInterface.reJustActivityEndTimeForIDIP(activityId);
/*    */     
/* 38 */     if (result == ActivityForIDIPResult.SUCCESS)
/*    */     {
/* 40 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 41 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = String.format("activityId=%d rejust endtime success", new Object[] { Integer.valueOf(activityId) }));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 46 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = result.retCode + 64286);
/* 47 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = result.retString);
/*    */     }
/*    */     
/* 50 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 52 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_ActivityRejustEndTime.executeCmd@activity rejust endtime done|ret=%d|retMsg=%s|area_id=%d|plat_id=%d|partition=%d|activityId=%d", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Integer.valueOf(activityId) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 57 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_ActivityRejustEndTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */