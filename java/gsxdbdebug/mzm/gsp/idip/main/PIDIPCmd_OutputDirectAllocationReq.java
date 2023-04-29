/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import gnet.link.Onlines;
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ 
/*    */ public class PIDIPCmd_OutputDirectAllocationReq extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 14 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 19 */         return new PIDIPCmd_OutputDirectAllocationReq(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_OutputDirectAllocationReq(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 26 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(java.util.List<Long> params)
/*    */     throws Exception
/*    */   {
/* 32 */     long value = Onlines.getInstance().getOutputAllocation();
/*    */     
/* 34 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 35 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = String.format("outputAllocation=%d", new Object[] { Long.valueOf(value) }));
/* 36 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 38 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_OutputDirectAllocationReq.executeCmd@get output_allocation done|area_id=%d|plat_id=%d|partition=%d|output_allocation=%d", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(value) }));
/*    */     
/*    */ 
/*    */ 
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_OutputDirectAllocationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */