/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ import xdb.Trace;
/*    */ 
/*    */ public class PIDIPCmd_SetXdbTraceLevelReq extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 14 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 19 */         return new PIDIPCmd_SetXdbTraceLevelReq(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_SetXdbTraceLevelReq(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 26 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(java.util.List<Long> params)
/*    */     throws Exception
/*    */   {
/* 32 */     int xdbTraceLevel = ((Long)params.get(0)).intValue();
/*    */     
/* 34 */     Trace trace = null;
/* 35 */     switch (xdbTraceLevel)
/*    */     {
/*    */     case 0: 
/* 38 */       trace = Trace.DEBUG;
/* 39 */       break;
/*    */     
/*    */     case 1: 
/* 42 */       trace = Trace.INFO;
/* 43 */       break;
/*    */     
/*    */     case 2: 
/* 46 */       trace = Trace.WARN;
/* 47 */       break;
/*    */     
/*    */     case 3: 
/* 50 */       trace = Trace.ERROR;
/* 51 */       break;
/*    */     
/*    */     case 4: 
/* 54 */       trace = Trace.FATAL;
/* 55 */       break;
/*    */     
/*    */     default: 
/* 58 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 59 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "xdb trace level not in (debug:0, info:1, warn:2, error:3, fatal:4)");
/* 60 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */       
/* 62 */       mzm.gsp.GameServer.logger().error(String.format("[idip]PIDIPCmd_SetXdbTraceLevelReq.executeCmd@xdbTraceLevel <= 0|area_id=%d|plat_id=%d|partition=%d|xdbTraceLevel=%d", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Integer.valueOf(xdbTraceLevel) }));
/*    */       
/*    */ 
/*    */ 
/* 66 */       return false;
/*    */     }
/* 68 */     Trace.set(trace);
/*    */     
/* 70 */     boolean result = true;
/*    */     
/*    */ 
/* 73 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 74 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = String.format("xdb treace level = %d", new Object[] { Integer.valueOf(xdbTraceLevel) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 82 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 84 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_SetXdbTraceLevelReq.executeCmd@set xdb trace level done|area_id=%d|plat_id=%d|partition=%d|xdbTraceLevel=%d|result=%b", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Integer.valueOf(xdbTraceLevel), Boolean.valueOf(true) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 89 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 95 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_SetXdbTraceLevelReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */