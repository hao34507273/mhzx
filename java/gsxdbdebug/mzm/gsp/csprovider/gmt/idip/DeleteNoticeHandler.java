/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.idip.main.NoticeInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DeleteNoticeHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 16 */     long noticeid = Long.parseLong((String)params.get(0));
/* 17 */     if (!NoticeInterface.contains(noticeid))
/*    */     {
/* 19 */       int retcode = Retcode.NOTICE_NOTICE_NOT_EXIST.value;
/* 20 */       rsp.retcode = retcode;
/* 21 */       Response response = IdipGmtUtil.getResponse(retcode, "notice not exist");
/* 22 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 24 */       GameServer.logger().error(String.format("[gmt]DeleteNoticeHandler.execute@notice not exist|noticeid=%d", new Object[] { Long.valueOf(noticeid) }));
/* 25 */       return;
/*    */     }
/*    */     
/* 28 */     NoticeInterface.del(noticeid);
/*    */     
/* 30 */     rsp.retcode = Retcode.SUCCESS.value;
/* 31 */     Response response = new Response();
/* 32 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 34 */     GameServer.logger().info(String.format("[gmt]DeleteNoticeHandler.execute@del notice done|noticeid=%d", new Object[] { Long.valueOf(noticeid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\DeleteNoticeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */