/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.ChannelSignLimitFunReq;
/*    */ import idip.ChannelSignLimitFunRsp;
/*    */ import idip.IDIPCmd_ChannelSignLimitFunReq;
/*    */ import idip.IDIPPacket_ChannelSignLimitFunReq;
/*    */ import idip.IDIPPacket_ChannelSignLimitFunRsp;
/*    */ import mzm.gsp.GameServer;
/*    */ 
/*    */ public class PIDIPCmd_ChannelSignLimitFunReq extends PIDIPCmd<IDIPCmd_ChannelSignLimitFunReq>
/*    */ {
/*    */   public PIDIPCmd_ChannelSignLimitFunReq(IDIPCmd_ChannelSignLimitFunReq cmd)
/*    */   {
/* 14 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean handle()
/*    */     throws Exception
/*    */   {
/* 20 */     int areaId = ((ChannelSignLimitFunReq)((IDIPPacket_ChannelSignLimitFunReq)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).req).body).AreaId;
/* 21 */     int platid = ((ChannelSignLimitFunReq)((IDIPPacket_ChannelSignLimitFunReq)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).req).body).PlatId;
/* 22 */     int partition = ((ChannelSignLimitFunReq)((IDIPPacket_ChannelSignLimitFunReq)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).req).body).Partition;
/* 23 */     boolean forbidden = ((ChannelSignLimitFunReq)((IDIPPacket_ChannelSignLimitFunReq)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).req).body).Switch == 0L;
/*    */     
/* 25 */     String channel = idip.core.Utils.urlDecode1738(((ChannelSignLimitFunReq)((IDIPPacket_ChannelSignLimitFunReq)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).req).body).Channel);
/* 26 */     if (channel.isEmpty())
/*    */     {
/* 28 */       ((IDIPPacket_ChannelSignLimitFunRsp)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).rsp).head.Result = (((ChannelSignLimitFunRsp)((IDIPPacket_ChannelSignLimitFunRsp)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).rsp).body).Result = '﮽');
/* 29 */       ((IDIPPacket_ChannelSignLimitFunRsp)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).rsp).head.RetErrMsg = (((ChannelSignLimitFunRsp)((IDIPPacket_ChannelSignLimitFunRsp)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).rsp).body).RetMsg = "channel is empty");
/* 30 */       ((IDIPCmd_ChannelSignLimitFunReq)this.cmd).sendResponse();
/*    */       
/* 32 */       GameServer.logger().info(String.format("[idip]PIDIPCmd_ChannelSignLimitFunReq.handle@channel is empty|area_id=%d|plat_id=%d|partition=%d|channel=%s|forbidden=%b", new Object[] { Integer.valueOf(areaId), Integer.valueOf(platid), Integer.valueOf(partition), channel, Boolean.valueOf(forbidden) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 37 */       return false;
/*    */     }
/* 39 */     if (channel.length() > 256)
/*    */     {
/* 41 */       ((IDIPPacket_ChannelSignLimitFunRsp)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).rsp).head.Result = (((ChannelSignLimitFunRsp)((IDIPPacket_ChannelSignLimitFunRsp)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).rsp).body).Result = '﮽');
/* 42 */       ((IDIPPacket_ChannelSignLimitFunRsp)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).rsp).head.RetErrMsg = (((ChannelSignLimitFunRsp)((IDIPPacket_ChannelSignLimitFunRsp)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).rsp).body).RetMsg = String.format("channel length > %d", new Object[] { Integer.valueOf(256) }));
/*    */       
/* 44 */       ((IDIPCmd_ChannelSignLimitFunReq)this.cmd).sendResponse();
/*    */       
/* 46 */       GameServer.logger().info(String.format("[idip]PIDIPCmd_ChannelSignLimitFunReq.handle@channel length > MAX_CHANNEL_LEN|area_id=%d|plat_id=%d|partition=%d|channel=%s|forbidden=%b", new Object[] { Integer.valueOf(areaId), Integer.valueOf(platid), Integer.valueOf(partition), channel, Boolean.valueOf(forbidden) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     boolean result = false;
/* 55 */     if (forbidden)
/*    */     {
/* 57 */       result = mzm.gsp.online.main.ForbidInfoManager.addForbiddenChannel(channel);
/*    */     }
/*    */     else
/*    */     {
/* 61 */       result = mzm.gsp.online.main.ForbidInfoManager.removeForbiddenChannel(channel);
/*    */     }
/*    */     
/* 64 */     if (result)
/*    */     {
/* 66 */       ((ChannelSignLimitFunRsp)((IDIPPacket_ChannelSignLimitFunRsp)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).rsp).body).Result = 0;
/* 67 */       ((ChannelSignLimitFunRsp)((IDIPPacket_ChannelSignLimitFunRsp)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).rsp).body).RetMsg = "OK";
/*    */     }
/*    */     else
/*    */     {
/* 71 */       ((IDIPPacket_ChannelSignLimitFunRsp)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).rsp).head.Result = (((ChannelSignLimitFunRsp)((IDIPPacket_ChannelSignLimitFunRsp)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).rsp).body).Result = '﮾');
/* 72 */       ((IDIPPacket_ChannelSignLimitFunRsp)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).rsp).head.RetErrMsg = (((ChannelSignLimitFunRsp)((IDIPPacket_ChannelSignLimitFunRsp)((IDIPCmd_ChannelSignLimitFunReq)this.cmd).rsp).body).RetMsg = "swich status not match");
/*    */     }
/*    */     
/* 75 */     ((IDIPCmd_ChannelSignLimitFunReq)this.cmd).sendResponse();
/*    */     
/* 77 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_ChannelSignLimitFunReq.handle@channel sign limit fun swich done|area_id=%d|plat_id=%d|partition=%d|channel=%s|forbidden=%b|result=%b", new Object[] { Integer.valueOf(areaId), Integer.valueOf(platid), Integer.valueOf(partition), channel, Boolean.valueOf(forbidden), Boolean.valueOf(result) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 82 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 88 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_ChannelSignLimitFunReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */