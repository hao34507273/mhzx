/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.DoActiveUsrReq;
/*    */ import idip.IDIPCmd_DoActiveUsrReq;
/*    */ import idip.IDIPPacket_DoActiveUsrReq;
/*    */ import idip.IDIPPacket_DoActiveUsrRsp;
/*    */ import idip.core.IdipHeader;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PIDIPCmd_DoActiveUsrReq extends PIDIPCmd<IDIPCmd_DoActiveUsrReq>
/*    */ {
/*    */   public PIDIPCmd_DoActiveUsrReq(IDIPCmd_DoActiveUsrReq cmd)
/*    */   {
/* 15 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean handle()
/*    */     throws Exception
/*    */   {
/* 21 */     String openId = ((DoActiveUsrReq)((IDIPPacket_DoActiveUsrReq)((IDIPCmd_DoActiveUsrReq)this.cmd).req).body).OpenId;
/* 22 */     int areaId = ((DoActiveUsrReq)((IDIPPacket_DoActiveUsrReq)((IDIPCmd_DoActiveUsrReq)this.cmd).req).body).AreaId;
/* 23 */     int partition = ((DoActiveUsrReq)((IDIPPacket_DoActiveUsrReq)((IDIPCmd_DoActiveUsrReq)this.cmd).req).body).Partition;
/*    */     
/* 25 */     String userId = idip.core.Utils.getUserId(openId, areaId, partition);
/* 26 */     xbean.User xUser = xtable.User.get(userId);
/* 27 */     if (null == xUser)
/*    */     {
/* 29 */       ((IDIPPacket_DoActiveUsrRsp)((IDIPCmd_DoActiveUsrReq)this.cmd).rsp).head.Result = 1;
/* 30 */       ((IDIPPacket_DoActiveUsrRsp)((IDIPCmd_DoActiveUsrReq)this.cmd).rsp).head.RetErrMsg = "query userid empty";
/* 31 */       ((IDIPCmd_DoActiveUsrReq)this.cmd).sendResponse();
/*    */       
/* 33 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DoActiveUsrReq.handle@user not found|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoActiveUsrRsp)((IDIPCmd_DoActiveUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoActiveUsrRsp)((IDIPCmd_DoActiveUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoActiveUsrReq)((IDIPPacket_DoActiveUsrReq)((IDIPCmd_DoActiveUsrReq)this.cmd).req).body).PlatId) }));
/*    */       
/*    */ 
/*    */ 
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     xUser.setActivated(true);
/*    */     
/* 42 */     ((IDIPPacket_DoActiveUsrRsp)((IDIPCmd_DoActiveUsrReq)this.cmd).rsp).head.Result = 0;
/* 43 */     ((IDIPPacket_DoActiveUsrRsp)((IDIPCmd_DoActiveUsrReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 44 */     ((IDIPCmd_DoActiveUsrReq)this.cmd).sendResponse();
/*    */     
/* 46 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DoActiveUsrReq.handle@active user success|ret=%d|ret_msg=%s|user_id=%s|area_id=%d|plat_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoActiveUsrRsp)((IDIPCmd_DoActiveUsrReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoActiveUsrRsp)((IDIPCmd_DoActiveUsrReq)this.cmd).rsp).head.RetErrMsg, userId, Integer.valueOf(areaId), Byte.valueOf(((DoActiveUsrReq)((IDIPPacket_DoActiveUsrReq)((IDIPCmd_DoActiveUsrReq)this.cmd).req).body).PlatId) }));
/*    */     
/*    */ 
/*    */ 
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoActiveUsrReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */