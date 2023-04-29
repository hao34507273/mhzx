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
/*    */ import mzm.gsp.npc.confbean.SNpcService;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class BanNpcServiceHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 20 */     int npcServiceId = Integer.parseInt((String)params.get(0));
/* 21 */     boolean ban = Integer.parseInt((String)params.get(1)) == 1;
/* 22 */     if (SNpcService.get(npcServiceId) == null)
/*    */     {
/* 24 */       int retcode = Retcode.NPC_SERVICE_ID_NOT_EXIST.value;
/* 25 */       rsp.retcode = retcode;
/* 26 */       Response response = IdipGmtUtil.getResponse(retcode, "npc service not exist");
/* 27 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 29 */       GameServer.logger().error(String.format("[gmt]BanNpcServiceHandler.execute@npc_service_id not exist|npc_service_id=%d|ban=%b", new Object[] { Integer.valueOf(npcServiceId), Boolean.valueOf(ban) }));
/*    */       
/*    */ 
/* 32 */       return;
/*    */     }
/*    */     
/* 35 */     boolean result = false;
/* 36 */     if (ban)
/*    */     {
/* 38 */       result = NpcInterface.banNpcService(npcServiceId);
/*    */     }
/*    */     else
/*    */     {
/* 42 */       result = NpcInterface.unBanNpcService(npcServiceId);
/*    */     }
/* 44 */     if (!result)
/*    */     {
/* 46 */       int retcode = Retcode.OPERATE_NPC_SERVICE_FAILED.value;
/* 47 */       rsp.retcode = retcode;
/* 48 */       Response response = IdipGmtUtil.getResponse(retcode, "ban npc service failed");
/* 49 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 51 */       GameServer.logger().error(String.format("[gmt]BanNpcServiceHandler.execute@operate failed|npc_service_id=%d|ban=%b", new Object[] { Integer.valueOf(npcServiceId), Boolean.valueOf(ban) }));
/*    */       
/*    */ 
/* 54 */       return;
/*    */     }
/*    */     
/* 57 */     rsp.retcode = Retcode.SUCCESS.value;
/* 58 */     Response response = new Response();
/* 59 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 61 */     GameServer.logger().info(String.format("[gmt]BanNpcServiceHandler.execute@operate success|npc_service_id=%d|ban=%b", new Object[] { Integer.valueOf(npcServiceId), Boolean.valueOf(ban) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\BanNpcServiceHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */