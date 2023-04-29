/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.lang.reflect.Field;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DirectBufferSizeHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 18 */     Class<?> clzz = Class.forName("java.nio.Bits");
/* 19 */     Field field = clzz.getDeclaredField("reservedMemory");
/* 20 */     field.setAccessible(true);
/* 21 */     long directBufferSize = ((Long)field.get(null)).longValue();
/*    */     
/* 23 */     rsp.retcode = Retcode.SUCCESS.value;
/* 24 */     String retMsg = String.format("directBufferSize=%d", new Object[] { Long.valueOf(directBufferSize) });
/* 25 */     Response response = new Response();
/* 26 */     response.msg = retMsg;
/* 27 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 29 */     GameServer.logger().info(String.format("[gmt]DirectBufferSizeHandler.execute@get direct_buffer_size done|directBufferSize=%d", new Object[] { Long.valueOf(directBufferSize) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\DirectBufferSizeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */