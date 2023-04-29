/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.task.ban.BanGraphInterface;
/*    */ import mzm.gsp.task.ban.BanTaskRes;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class BanGraphHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 20 */     int graphId = Integer.parseInt((String)params.get(0));
/* 21 */     int banType = Integer.parseInt((String)params.get(1));
/* 22 */     boolean ban = Integer.parseInt((String)params.get(2)) == 1;
/*    */     
/* 24 */     BanTaskRes res = null;
/* 25 */     if (ban)
/*    */     {
/* 27 */       res = BanGraphInterface.banGraph(graphId, banType);
/*    */     }
/*    */     else
/*    */     {
/* 31 */       res = BanGraphInterface.freeGraph(graphId, banType);
/*    */     }
/*    */     
/* 34 */     if (!res.isSuc())
/*    */     {
/* 36 */       String msg = String.format("%s graph failed", new Object[] { ban ? "ban" : "unban" });
/* 37 */       if (res.isBanTypeErr())
/*    */       {
/* 39 */         msg = "ban type error";
/*    */       }
/* 41 */       else if (res.isGraphIdsIllegal())
/*    */       {
/* 43 */         msg = "graphid illegal";
/*    */       }
/* 45 */       else if (res.isGraphTypeIllegal())
/*    */       {
/* 47 */         msg = "graph type illegal";
/*    */       }
/* 49 */       else if (res.isTaskIdsIllegal())
/*    */       {
/* 51 */         msg = "taskid illegal";
/*    */       }
/*    */       
/* 54 */       int retcode = Retcode.BAN_GRAPH_FAILED.value;
/* 55 */       rsp.retcode = retcode;
/* 56 */       Response response = IdipGmtUtil.getResponse(retcode, msg);
/* 57 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 59 */       GameServer.logger().error(String.format("[gmt]BanGraphHandler.execute@operate graph failed|graphid=%d|ban_type=%d|ban=%b|reason=%d", new Object[] { Integer.valueOf(graphId), Integer.valueOf(banType), Boolean.valueOf(ban), Integer.valueOf(res.getReasonValue()) }));
/*    */       
/*    */ 
/* 62 */       return;
/*    */     }
/*    */     
/* 65 */     rsp.retcode = Retcode.SUCCESS.value;
/* 66 */     Response response = new Response();
/* 67 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 69 */     GameServer.logger().info(String.format("[gmt]BanGraphHandler.execute@operate graph success|graphid=%d|ban_type=%d|ban=%b", new Object[] { Integer.valueOf(graphId), Integer.valueOf(banType), Boolean.valueOf(ban) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\BanGraphHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */