/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityForIDIPResult;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ 
/*    */ public class PIDIPCmd_ActivityForceOpen extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 16 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 21 */         return new PIDIPCmd_ActivityForceOpen(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_ActivityForceOpen(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 28 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(List<Long> params)
/*    */     throws Exception
/*    */   {
/* 34 */     int activityId = ((Long)params.get(0)).intValue();
/* 35 */     long minute = ((Long)params.get(1)).longValue();
/*    */     
/* 37 */     if ((minute <= 0L) && (minute != -1L))
/*    */     {
/* 39 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 40 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "minute <= 0 && minute != -1");
/*    */     }
/*    */     else
/*    */     {
/* 44 */       ActivityForIDIPResult result = null;
/* 45 */       if (minute == -1L)
/*    */       {
/* 47 */         result = ActivityInterface.forceOpenActivityForIDIP(activityId);
/*    */       }
/*    */       else
/*    */       {
/* 51 */         result = ActivityInterface.forceOpenActivityForIDIP(activityId, minute);
/*    */       }
/*    */       
/* 54 */       if (result == ActivityForIDIPResult.SUCCESS)
/*    */       {
/* 56 */         ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 57 */         ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = String.format("activityid=%d force open %d minute", new Object[] { Integer.valueOf(activityId), Long.valueOf(minute) }));
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 62 */         ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = result.retCode + 64286);
/* 63 */         ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = result.retString);
/*    */       }
/*    */     }
/*    */     
/* 67 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 69 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_ActivityForceOpen.executeCmd@activity force open done|ret=%d|retMsg=%s|area_id=%d|plat_id=%d|partition=%d|activityId=%d|minute=%d", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Integer.valueOf(activityId), Long.valueOf(minute) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 74 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 80 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_ActivityForceOpen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */