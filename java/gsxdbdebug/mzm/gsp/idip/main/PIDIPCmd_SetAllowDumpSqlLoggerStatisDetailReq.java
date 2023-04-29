/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ 
/*    */ public class PIDIPCmd_SetAllowDumpSqlLoggerStatisDetailReq extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 13 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 18 */         return new PIDIPCmd_SetAllowDumpSqlLoggerStatisDetailReq(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_SetAllowDumpSqlLoggerStatisDetailReq(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 25 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(java.util.List<Long> params)
/*    */     throws Exception
/*    */   {
/* 31 */     boolean isAllow = ((Long)params.get(0)).longValue() == 1L;
/*    */     
/* 33 */     xdb.Xdb.getInstance().getConf().setAllowDumpSqlLoggerStatisDetail(isAllow);
/* 34 */     boolean result = true;
/*    */     
/*    */ 
/* 37 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 38 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = String.format("AllowDumpSqlLoggerStatisDetail = %b", new Object[] { Boolean.valueOf(isAllow) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 47 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 49 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_SetAllowDumpSqlLoggerStatisDetailReq.executeCmd@set allow dump sqlLogger statis detail done|area_id=%d|plat_id=%d|partition=%d|isAllow=%b|result=%b", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Boolean.valueOf(isAllow), Boolean.valueOf(true) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 54 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_SetAllowDumpSqlLoggerStatisDetailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */