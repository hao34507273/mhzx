/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.DoDeleteNoticeReq;
/*    */ import idip.IDIPCmd_DoDeleteNoticeReq;
/*    */ import idip.IDIPPacket_DoDeleteNoticeReq;
/*    */ import idip.IDIPPacket_DoDeleteNoticeRsp;
/*    */ 
/*    */ public class PIDIPCmd_DoDeleteNoticeReq extends PIDIPCmd<IDIPCmd_DoDeleteNoticeReq>
/*    */ {
/*    */   public PIDIPCmd_DoDeleteNoticeReq(IDIPCmd_DoDeleteNoticeReq cmd)
/*    */   {
/* 12 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean handle()
/*    */     throws Exception
/*    */   {
/* 18 */     long noticeId = ((DoDeleteNoticeReq)((IDIPPacket_DoDeleteNoticeReq)((IDIPCmd_DoDeleteNoticeReq)this.cmd).req).body).NoticeId;
/* 19 */     if (!NoticeManager.containsNotice(noticeId))
/*    */     {
/* 21 */       ((idip.DoDeleteNoticeRsp)((IDIPPacket_DoDeleteNoticeRsp)((IDIPCmd_DoDeleteNoticeReq)this.cmd).rsp).body).NoticeId = noticeId;
/* 22 */       ((IDIPPacket_DoDeleteNoticeRsp)((IDIPCmd_DoDeleteNoticeReq)this.cmd).rsp).head.Result = (((idip.DoDeleteNoticeRsp)((IDIPPacket_DoDeleteNoticeRsp)((IDIPCmd_DoDeleteNoticeReq)this.cmd).rsp).body).Result = 'אּ');
/* 23 */       ((IDIPPacket_DoDeleteNoticeRsp)((IDIPCmd_DoDeleteNoticeReq)this.cmd).rsp).head.RetErrMsg = (((idip.DoDeleteNoticeRsp)((IDIPPacket_DoDeleteNoticeRsp)((IDIPCmd_DoDeleteNoticeReq)this.cmd).rsp).body).RetMsg = "notice not exist");
/* 24 */       ((IDIPCmd_DoDeleteNoticeReq)this.cmd).sendResponse();
/*    */       
/* 26 */       mzm.gsp.GameServer.logger().error(String.format("[idip]PIDIPCmd_DoDeleteNoticeReq.handle@notice not exist|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|noticeId=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoDeleteNoticeRsp)((IDIPCmd_DoDeleteNoticeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDeleteNoticeRsp)((IDIPCmd_DoDeleteNoticeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoDeleteNoticeReq)((IDIPPacket_DoDeleteNoticeReq)((IDIPCmd_DoDeleteNoticeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoDeleteNoticeReq)((IDIPPacket_DoDeleteNoticeReq)((IDIPCmd_DoDeleteNoticeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoDeleteNoticeReq)((IDIPPacket_DoDeleteNoticeReq)((IDIPCmd_DoDeleteNoticeReq)this.cmd).req).body).Partition), Long.valueOf(((DoDeleteNoticeReq)((IDIPPacket_DoDeleteNoticeReq)((IDIPCmd_DoDeleteNoticeReq)this.cmd).req).body).NoticeId) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     NoticeManager.forceDelNotice(noticeId);
/*    */     
/* 36 */     ((idip.DoDeleteNoticeRsp)((IDIPPacket_DoDeleteNoticeRsp)((IDIPCmd_DoDeleteNoticeReq)this.cmd).rsp).body).NoticeId = noticeId;
/* 37 */     ((IDIPPacket_DoDeleteNoticeRsp)((IDIPCmd_DoDeleteNoticeReq)this.cmd).rsp).head.Result = (((idip.DoDeleteNoticeRsp)((IDIPPacket_DoDeleteNoticeRsp)((IDIPCmd_DoDeleteNoticeReq)this.cmd).rsp).body).Result = 0);
/* 38 */     ((IDIPPacket_DoDeleteNoticeRsp)((IDIPCmd_DoDeleteNoticeReq)this.cmd).rsp).head.RetErrMsg = (((idip.DoDeleteNoticeRsp)((IDIPPacket_DoDeleteNoticeRsp)((IDIPCmd_DoDeleteNoticeReq)this.cmd).rsp).body).RetMsg = "ok");
/* 39 */     ((IDIPCmd_DoDeleteNoticeReq)this.cmd).sendResponse();
/*    */     
/* 41 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_DoDeleteNoticeReq.handle@del notice done|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|noticeId=%d", new Object[] { Integer.valueOf(((IDIPPacket_DoDeleteNoticeRsp)((IDIPCmd_DoDeleteNoticeReq)this.cmd).rsp).head.Result), ((IDIPPacket_DoDeleteNoticeRsp)((IDIPCmd_DoDeleteNoticeReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((DoDeleteNoticeReq)((IDIPPacket_DoDeleteNoticeReq)((IDIPCmd_DoDeleteNoticeReq)this.cmd).req).body).AreaId), Byte.valueOf(((DoDeleteNoticeReq)((IDIPPacket_DoDeleteNoticeReq)((IDIPCmd_DoDeleteNoticeReq)this.cmd).req).body).PlatId), Integer.valueOf(((DoDeleteNoticeReq)((IDIPPacket_DoDeleteNoticeReq)((IDIPCmd_DoDeleteNoticeReq)this.cmd).req).body).Partition), Long.valueOf(((DoDeleteNoticeReq)((IDIPPacket_DoDeleteNoticeReq)((IDIPCmd_DoDeleteNoticeReq)this.cmd).req).body).NoticeId) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 46 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DoDeleteNoticeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */