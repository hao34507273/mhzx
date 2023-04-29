/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ import java.util.List;
/*    */ 
/*    */ public class PIDIPCmd_PointExchangeSwitch extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 14 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 19 */         return new PIDIPCmd_PointExchangeSwitch(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_PointExchangeSwitch(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 26 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(List<Long> params)
/*    */     throws Exception
/*    */   {
/* 32 */     int activityCfgid = ((Long)params.get(0)).intValue();
/* 33 */     int mallCfgId = ((Long)params.get(1)).intValue();
/* 34 */     int goodsCfgId = ((Long)params.get(2)).intValue();
/* 35 */     boolean hide = ((Long)params.get(3)).longValue() == 0L;
/*    */     
/* 37 */     boolean result = false;
/* 38 */     if (hide)
/*    */     {
/* 40 */       result = mzm.gsp.activitypointexchange.main.ActivityPointExchangeInterface.xiaJia(activityCfgid, mallCfgId, goodsCfgId);
/*    */     }
/*    */     else
/*    */     {
/* 44 */       result = mzm.gsp.activitypointexchange.main.ActivityPointExchangeInterface.shangJia(activityCfgid, mallCfgId, goodsCfgId);
/*    */     }
/* 46 */     if (!result)
/*    */     {
/* 48 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 49 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "system error");
/* 50 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */       
/* 52 */       mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_PointExchangeSwitch.executeCmd@failed|area_id=%d|plat_id=%d|partition=%d|activity_cfgid=%d|mall_cfgid=%d|goods_cfgid=%d|hide=%b", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Integer.valueOf(activityCfgid), Integer.valueOf(mallCfgId), Integer.valueOf(goodsCfgId), Boolean.valueOf(hide) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 57 */       return false;
/*    */     }
/*    */     
/* 60 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 61 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = String.format("%s success", new Object[] { hide ? "hide" : "display" }));
/* 62 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 64 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_PointExchangeSwitch.executeCmd@success|area_id=%d|plat_id=%d|partition=%d|activity_cfgid=%d|mall_cfgid=%d|goods_cfgid=%d|hide=%b", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Integer.valueOf(activityCfgid), Integer.valueOf(mallCfgId), Integer.valueOf(goodsCfgId), Boolean.valueOf(hide) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 69 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_PointExchangeSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */