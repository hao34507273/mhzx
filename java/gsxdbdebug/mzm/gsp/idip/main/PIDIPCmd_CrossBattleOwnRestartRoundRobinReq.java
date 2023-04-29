/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.own.RestartResult;
/*    */ 
/*    */ public class PIDIPCmd_CrossBattleOwnRestartRoundRobinReq extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 16 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 21 */         return new PIDIPCmd_CrossBattleOwnRestartRoundRobinReq(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_CrossBattleOwnRestartRoundRobinReq(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 28 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(List<Long> params)
/*    */     throws Exception
/*    */   {
/* 34 */     int activityCfgid = ((Long)params.get(0)).intValue();
/* 35 */     int roundIndex = ((Long)params.get(1)).intValue();
/* 36 */     int restartLevel = ((Long)params.get(2)).intValue();
/* 37 */     long timestamp = java.util.concurrent.TimeUnit.SECONDS.toMillis(((Long)params.get(3)).longValue());
/*    */     
/* 39 */     RestartResult restartResult = mzm.gsp.crossbattle.own.CrossBattleOwnInterface.restartRoundRobinRoundByIdip(activityCfgid, roundIndex, restartLevel, timestamp);
/*    */     
/* 41 */     if (restartResult != RestartResult.Success)
/*    */     {
/* 43 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 44 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = restartResult.desc);
/* 45 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */       
/* 47 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_CrossBattleOwnRestartRoundRobinReq.executeCmd@failed|area_id=%d|plat_id=%d|partition=%d|activity_cfgid=%d|round_index=%d|restart_level=%d|timestamp=%d|retcode=%d", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Integer.valueOf(activityCfgid), Integer.valueOf(roundIndex), Integer.valueOf(restartLevel), Long.valueOf(timestamp), Integer.valueOf(restartResult.code) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 56 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "ok");
/* 57 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 59 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_CrossBattleOwnRestartRoundRobinReq.executeCmd@done|area_id=%d|plat_id=%d|partition=%d|activity_cfgid=%d|round_index=%d|restart_level=%d|timestamp=%d", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Integer.valueOf(activityCfgid), Integer.valueOf(roundIndex), Integer.valueOf(restartLevel), Long.valueOf(timestamp) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 64 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 70 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_CrossBattleOwnRestartRoundRobinReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */