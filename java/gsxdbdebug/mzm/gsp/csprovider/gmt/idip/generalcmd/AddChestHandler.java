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
/*    */ import mzm.gsp.foolsday.main.FoolsDayInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class AddChestHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 20 */     long roleid = Long.parseLong((String)params.get(0));
/* 21 */     int activityCfgid = Integer.parseInt((String)params.get(1));
/* 22 */     int buffid = Integer.parseInt((String)params.get(2));
/*    */     
/* 24 */     if (!RoleInterface.isRoleExist(roleid, true))
/*    */     {
/* 26 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/* 27 */       rsp.retcode = retcode;
/* 28 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/* 29 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 31 */       GameServer.logger().error(String.format("[gmt]AddChestHandler.execute@role not found|roleid=%d|activity_cfgid=%d|buffid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(buffid) }));
/*    */       
/*    */ 
/* 34 */       return;
/*    */     }
/*    */     
/* 37 */     if (!FoolsDayInterface.synAddChestByIdip(roleid, activityCfgid, buffid))
/*    */     {
/* 39 */       int retcode = Retcode.ADD_CHEST_FAILED.value;
/* 40 */       rsp.retcode = retcode;
/* 41 */       Response response = IdipGmtUtil.getResponse(retcode, "add chest failed");
/* 42 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 44 */       GameServer.logger().error(String.format("[gmt]AddChestHandler.execute@add chest failed|roleid=%d|activity_cfgid=%d|buffid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(buffid) }));
/*    */       
/*    */ 
/* 47 */       return;
/*    */     }
/*    */     
/* 50 */     rsp.retcode = Retcode.SUCCESS.value;
/* 51 */     Response response = new Response();
/* 52 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 54 */     GameServer.logger().info(String.format("[gmt]AddChestHandler.execute@add done|roleid=%d|activity_cfgid=%d|buffid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(buffid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\AddChestHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */