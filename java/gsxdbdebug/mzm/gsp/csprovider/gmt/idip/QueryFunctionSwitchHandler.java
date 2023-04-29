/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import idip.QueryFunctionSwitchRsp;
/*    */ import idip.SFunctionSwitchInfo;
/*    */ import java.util.ArrayList;
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class QueryFunctionSwitchHandler
/*    */   implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 23 */     Map<Integer, Integer> status = new LinkedHashMap();
/* 24 */     for (int i = 0; i <= 592; i++)
/*    */     {
/* 26 */       status.put(Integer.valueOf(i), Integer.valueOf(1));
/*    */     }
/*    */     
/* 29 */     List<Integer> closeModules = OpenInterface.getCloseStatusModuleFunSwitches();
/* 30 */     for (Integer moduleid : closeModules)
/*    */     {
/* 32 */       status.put(moduleid, Integer.valueOf(0));
/*    */     }
/*    */     
/* 35 */     QueryFunctionSwitchRsp queryFunctionSwitchRsp = new QueryFunctionSwitchRsp();
/* 36 */     for (Map.Entry<Integer, Integer> entry : status.entrySet())
/*    */     {
/* 38 */       SFunctionSwitchInfo switchInfo = new SFunctionSwitchInfo();
/* 39 */       switchInfo.FunctionId = ((Integer)entry.getKey()).intValue();
/* 40 */       switchInfo.Status = ((Integer)entry.getValue()).byteValue();
/* 41 */       queryFunctionSwitchRsp.SwitchList.add(switchInfo);
/*    */     }
/*    */     
/* 44 */     queryFunctionSwitchRsp.SwitchList_count = queryFunctionSwitchRsp.SwitchList.size();
/*    */     
/* 46 */     rsp.retcode = Retcode.SUCCESS.value;
/* 47 */     Response response = new Response();
/* 48 */     response.data = queryFunctionSwitchRsp;
/* 49 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 51 */     GameServer.logger().info(String.format("[gmt]QueryFunctionSwitchHandler.handle@query success|size=%d", new Object[] { Integer.valueOf(queryFunctionSwitchRsp.SwitchList_count) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\QueryFunctionSwitchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */