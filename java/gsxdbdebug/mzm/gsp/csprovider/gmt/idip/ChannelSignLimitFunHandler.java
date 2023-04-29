/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.online.main.ForbidInfoManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class ChannelSignLimitFunHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 16 */     String channel = (String)params.get(0);
/* 17 */     boolean forbidden = Integer.parseInt((String)params.get(1)) == 0;
/*    */     
/* 19 */     if (channel.isEmpty())
/*    */     {
/* 21 */       int retcode = Retcode.CHANNEl_EMPTY.value;
/* 22 */       rsp.retcode = retcode;
/* 23 */       Response response = IdipGmtUtil.getResponse(retcode, "channel is empty");
/* 24 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 26 */       GameServer.logger().error(String.format("[gmt]ChannelSignLimitFunHandler.execute@channel is empty|channel=%s|forbidden=%b", new Object[] { channel, Boolean.valueOf(forbidden) }));
/*    */       
/*    */ 
/*    */ 
/* 30 */       return;
/*    */     }
/*    */     
/* 33 */     if (channel.length() > 256)
/*    */     {
/* 35 */       int retcode = Retcode.CHANNEL_TOO_LONG.value;
/* 36 */       rsp.retcode = retcode;
/* 37 */       Response response = IdipGmtUtil.getResponse(retcode, String.format("channel length > %d", new Object[] { Integer.valueOf(256) }));
/*    */       
/* 39 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 41 */       GameServer.logger().error(String.format("[gmt]ChannelSignLimitFunHandler.execute@channel len > MAX_CHANNEL_LEN|channel=%s|forbidden=%b", new Object[] { channel, Boolean.valueOf(forbidden) }));
/*    */       
/*    */ 
/*    */ 
/* 45 */       return;
/*    */     }
/*    */     
/* 48 */     boolean result = false;
/* 49 */     if (forbidden)
/*    */     {
/* 51 */       result = ForbidInfoManager.addForbiddenChannel(channel);
/*    */     }
/*    */     else
/*    */     {
/* 55 */       result = ForbidInfoManager.removeForbiddenChannel(channel);
/*    */     }
/*    */     
/* 58 */     if (!result)
/*    */     {
/* 60 */       int retcode = Retcode.CHANNEL_FAILED.value;
/* 61 */       rsp.retcode = retcode;
/* 62 */       Response response = IdipGmtUtil.getResponse(retcode, "operate failed");
/* 63 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 65 */       GameServer.logger().error(String.format("[gmt]ChannelSignLimitFunHandler.execute@operate failed|channel=%s|forbidden=%b", new Object[] { channel, Boolean.valueOf(forbidden) }));
/*    */       
/*    */ 
/* 68 */       return;
/*    */     }
/*    */     
/* 71 */     rsp.retcode = Retcode.SUCCESS.value;
/* 72 */     Response response = new Response();
/* 73 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 75 */     GameServer.logger().info(String.format("[gmt]ChannelSignLimitFunHandler.execute@channel sign limit fun swich done|channel=%s|forbidden=%b", new Object[] { channel, Boolean.valueOf(forbidden) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\ChannelSignLimitFunHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */