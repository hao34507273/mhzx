/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ import java.util.List;
/*    */ import mzm.gsp.task.ban.BanTaskRes;
/*    */ 
/*    */ public class PIDIPCmd_BanGraphReq extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 15 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 20 */         return new PIDIPCmd_BanGraphReq(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_BanGraphReq(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 27 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(List<Long> params)
/*    */     throws Exception
/*    */   {
/* 33 */     int graphId = ((Long)params.get(0)).intValue();
/* 34 */     int banType = ((Long)params.get(1)).intValue();
/* 35 */     boolean ban = ((Long)params.get(2)).intValue() == 1;
/*    */     
/* 37 */     BanTaskRes res = null;
/* 38 */     if (ban)
/*    */     {
/* 40 */       res = mzm.gsp.task.ban.BanGraphInterface.banGraph(graphId, banType);
/*    */     }
/*    */     else
/*    */     {
/* 44 */       res = mzm.gsp.task.ban.BanGraphInterface.freeGraph(graphId, banType);
/*    */     }
/*    */     
/* 47 */     if (!res.isSuc())
/*    */     {
/* 49 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 50 */       String msg = String.format("%s graph failed", new Object[] { ban ? "ban" : "unban" });
/* 51 */       if (res.isBanTypeErr())
/*    */       {
/* 53 */         msg = "ban type error";
/*    */       }
/* 55 */       else if (res.isGraphIdsIllegal())
/*    */       {
/* 57 */         msg = "graphid illegal";
/*    */       }
/* 59 */       else if (res.isGraphTypeIllegal())
/*    */       {
/* 61 */         msg = "graph type illegal";
/*    */       }
/* 63 */       else if (res.isTaskIdsIllegal())
/*    */       {
/* 65 */         msg = "taskid illegal";
/*    */       }
/* 67 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = msg);
/* 68 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */       
/* 70 */       mzm.gsp.GameServer.logger().error(String.format("[idip]PIDIPCmd_BanGraphReq.executeCmd@operate graph failed|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|graphid=%d|ban_type=%d|ban=%b|reason=%d", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Integer.valueOf(graphId), Integer.valueOf(banType), Boolean.valueOf(ban), Integer.valueOf(res.getReasonValue()) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 75 */       return false;
/*    */     }
/*    */     
/* 78 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 79 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = String.format("%s graph success", new Object[] { ban ? "ban" : "unban" }));
/* 80 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 82 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_BanGraphReq.executeCmd@operate graph success|ret=%d|retMsg=%s|area_id=%d|plat_id=%d|partition=%d|graphid=%d|ban_type=%d|ban=%b", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Integer.valueOf(graphId), Integer.valueOf(banType), Boolean.valueOf(ban) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 87 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_BanGraphReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */