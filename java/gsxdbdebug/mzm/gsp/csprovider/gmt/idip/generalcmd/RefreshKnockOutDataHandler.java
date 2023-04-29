/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class RefreshKnockOutDataHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 19 */     int activityCfgid = Integer.parseInt((String)params.get(0));
/* 20 */     int knockOutType = Integer.parseInt((String)params.get(1));
/* 21 */     int fightZoneid = Integer.parseInt((String)params.get(2));
/*    */     
/* 23 */     int result = CrossBattleKnockoutInterface.refreshKnockOutData(activityCfgid, knockOutType, fightZoneid);
/* 24 */     if (result < 0)
/*    */     {
/* 26 */       rsp.retcode = Retcode.SUCCESS.value;
/* 27 */       Response response = IdipGmtUtil.getResponse(Retcode.SUCCESS.value, String.format("refresh knockout data failed,result = %d", new Object[] { Integer.valueOf(result) }));
/*    */       
/* 29 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 31 */       GameServer.logger().error(String.format("[gmt]RefreshKnockOutDataHandler.execute@handle failed|activity_cfgid=%d|type=%d|fight_zoneid=%d|retcode=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(knockOutType), Integer.valueOf(fightZoneid), Integer.valueOf(result) }));
/*    */       
/*    */ 
/*    */ 
/* 35 */       return;
/*    */     }
/*    */     
/* 38 */     rsp.retcode = Retcode.SUCCESS.value;
/* 39 */     Response response = new Response();
/* 40 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 42 */     GameServer.logger().info(String.format("[gmt]RefreshKnockOutDataHandler.execute@handle success|activity_cfgid=%d|type=%d|fight_zoneid=%d|retcode=%d", new Object[] { Integer.valueOf(activityCfgid), Integer.valueOf(knockOutType), Integer.valueOf(fightZoneid), Integer.valueOf(result) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\RefreshKnockOutDataHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */