/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.idip.main.MarqueeInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DeleteMarqueeHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 16 */     long indexId = Long.parseLong((String)params.get(0));
/* 17 */     Long marqueeid = MarqueeInterface.getMarqueeid(indexId);
/* 18 */     if (marqueeid == null)
/*    */     {
/* 20 */       int retcode = Retcode.DELETE_MARQUEE_NOT_EXIST.value;
/* 21 */       rsp.retcode = retcode;
/* 22 */       Response response = IdipGmtUtil.getResponse(retcode, "marquee not exist");
/* 23 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 25 */       GameServer.logger().error(String.format("[gmt]DeleteMarqueeHandler.handle@marquee not exist|index_id=%d", new Object[] { Long.valueOf(indexId) }));
/* 26 */       return;
/*    */     }
/*    */     
/* 29 */     boolean result = MarqueeInterface.forceDeleteMarquee(marqueeid.longValue());
/* 30 */     if (!result)
/*    */     {
/* 32 */       int retcode = Retcode.DELETE_MARQUEE_NOT_EXIST.value;
/* 33 */       rsp.retcode = retcode;
/* 34 */       Response response = IdipGmtUtil.getResponse(retcode, "marquee not exist");
/* 35 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 37 */       GameServer.logger().error(String.format("[gmt]DeleteMarqueeHandler.handle@marquee not exist|index_id=%d|marqueeid=%d", new Object[] { Long.valueOf(indexId), marqueeid }));
/*    */       
/*    */ 
/* 40 */       return;
/*    */     }
/*    */     
/* 43 */     rsp.retcode = Retcode.SUCCESS.value;
/* 44 */     Response response = new Response();
/* 45 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 47 */     GameServer.logger().info(String.format("[gmt]DeleteMarqueeHandler.handle@do delete marquee done|index_id=%d|marqueeid=%d", new Object[] { Long.valueOf(indexId), marqueeid }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\DeleteMarqueeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */