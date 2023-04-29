/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.compensate.main.CompensateInterface;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DeleteGlobalMailHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 16 */     int tagid = Integer.parseInt((String)params.get(0));
/* 17 */     String mailid = (String)params.get(1);
/*    */     
/* 19 */     if ((tagid <= 0) && (mailid.isEmpty()))
/*    */     {
/* 21 */       int retcode = Retcode.DELETE_GLOBAL_MAIL_PARAMS_INVALID.value;
/* 22 */       rsp.retcode = retcode;
/* 23 */       Response response = IdipGmtUtil.getResponse(retcode, "params invalid");
/* 24 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 26 */       GameServer.logger().error(String.format("[gmt]DeleteGlobalMailHandler.handle@params invalid|tagid=%d|mailid=%s", new Object[] { Integer.valueOf(tagid), mailid }));
/*    */       
/* 28 */       return;
/*    */     }
/*    */     
/* 31 */     boolean result = false;
/* 32 */     if (mailid.isEmpty())
/*    */     {
/* 34 */       result = CompensateInterface.removeCompensate(tagid);
/*    */     }
/*    */     else
/*    */     {
/* 38 */       long id = 0L;
/*    */       try
/*    */       {
/* 41 */         id = Long.parseLong(mailid);
/* 42 */         result = CompensateInterface.removeCompensate(id, tagid);
/*    */       }
/*    */       catch (NumberFormatException e) {}
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 50 */     if (!result)
/*    */     {
/* 52 */       int retcode = Retcode.DELETE_GLOBAL_MAIL_FALIED.value;
/* 53 */       rsp.retcode = retcode;
/* 54 */       Response response = IdipGmtUtil.getResponse(retcode, "delete failed");
/* 55 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 57 */       GameServer.logger().error(String.format("[gmt]DeleteGlobalMailHandler.handle@delete failed|tagid=%d|mailid=%s", new Object[] { Integer.valueOf(tagid), mailid }));
/*    */       
/* 59 */       return;
/*    */     }
/*    */     
/* 62 */     rsp.retcode = Retcode.SUCCESS.value;
/* 63 */     Response response = new Response();
/* 64 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 66 */     GameServer.logger().info(String.format("[gmt]DeleteGlobalMailHandler.execute@delete success|tagid=%d|mailid=%s", new Object[] { Integer.valueOf(tagid), mailid }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\DeleteGlobalMailHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */