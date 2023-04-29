/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.DoDeleteMarqueeReq;
/*    */ import idip.IDIPCmd_DoDeleteMarqueeReq;
/*    */ import idip.IDIPPacket_DoDeleteMarqueeReq;
/*    */ import idip.IDIPPacket_DoDeleteMarqueeRsp;
/*    */ 
/*    */ public class PIDIPCmd_DoDeleteMarqueeReq extends PIDIPCmd<IDIPCmd_DoDeleteMarqueeReq>
/*    */ {
/*    */   public PIDIPCmd_DoDeleteMarqueeReq(IDIPCmd_DoDeleteMarqueeReq cmd)
/*    */   {
/* 12 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean handle()
/*    */     throws Exception
/*    */   {
/* 18 */     long indexId = ((DoDeleteMarqueeReq)((IDIPPacket_DoDeleteMarqueeReq)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).req).body).MarqueeId;
/* 19 */     Long marqueeId = MarqueeIndexCache.getInstance().get(indexId);
/* 20 */     if (marqueeId == null)
/*    */     {
/* 22 */       ((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).head.Result = (((idip.DoDeleteMarqueeRsp)((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).body).Result = 'ﭓ');
/* 23 */       ((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((idip.DoDeleteMarqueeRsp)((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).body).RetMsg = "marquee not exist");
/* 24 */       ((IDIPCmd_DoDeleteMarqueeReq)this.cmd).sendResponse();
/*    */       
/* 26 */       mzm.gsp.GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDeleteMarqueeReq.handle@marquee not exist|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|index_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoDeleteMarqueeReq)((IDIPPacket_DoDeleteMarqueeReq)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoDeleteMarqueeReq)((IDIPPacket_DoDeleteMarqueeReq)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoDeleteMarqueeReq)((IDIPPacket_DoDeleteMarqueeReq)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(indexId) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     if (!MarqueeManager.forceDeleteMarquee(marqueeId.longValue()))
/*    */     {
/* 36 */       ((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).head.Result = (((idip.DoDeleteMarqueeRsp)((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).body).Result = 'ﭓ');
/* 37 */       ((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).head.RetErrMsg = (((idip.DoDeleteMarqueeRsp)((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).body).RetMsg = "marquee not exist");
/* 38 */       ((IDIPCmd_DoDeleteMarqueeReq)this.cmd).sendResponse();
/*    */       
/* 40 */       mzm.gsp.GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDeleteMarqueeReq.handle@marquee not exist|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|index_id=%d|MarqueeId=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoDeleteMarqueeReq)((IDIPPacket_DoDeleteMarqueeReq)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoDeleteMarqueeReq)((IDIPPacket_DoDeleteMarqueeReq)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoDeleteMarqueeReq)((IDIPPacket_DoDeleteMarqueeReq)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(indexId), marqueeId }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     ((idip.DoDeleteMarqueeRsp)((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).body).MarqueeId = indexId;
/* 49 */     ((idip.DoDeleteMarqueeRsp)((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).body).Result = (((idip.DoDeleteMarqueeRsp)((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).body).Result = 0);
/* 50 */     ((idip.DoDeleteMarqueeRsp)((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).body).RetMsg = (((idip.DoDeleteMarqueeRsp)((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).body).RetMsg = "ok");
/* 51 */     ((IDIPCmd_DoDeleteMarqueeReq)this.cmd).sendResponse();
/*    */     
/* 53 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_DoDeleteMarqueeReq.handle@do delete marquee done|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|index_id=%d|MarqueeId=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDeleteMarqueeRsp)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoDeleteMarqueeReq)((IDIPPacket_DoDeleteMarqueeReq)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoDeleteMarqueeReq)((IDIPPacket_DoDeleteMarqueeReq)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoDeleteMarqueeReq)((IDIPPacket_DoDeleteMarqueeReq)((IDIPCmd_DoDeleteMarqueeReq)this.cmd).req).body).Partition), Long.valueOf(indexId), marqueeId }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 59 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoDeleteMarqueeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */