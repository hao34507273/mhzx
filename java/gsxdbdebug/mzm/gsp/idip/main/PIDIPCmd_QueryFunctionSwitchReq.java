/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.IDIPCmd_QueryFunctionSwitchReq;
/*    */ import idip.IDIPPacket_QueryFunctionSwitchReq;
/*    */ import idip.IDIPPacket_QueryFunctionSwitchRsp;
/*    */ import idip.QueryFunctionSwitchReq;
/*    */ import idip.QueryFunctionSwitchRsp;
/*    */ import idip.SFunctionSwitchInfo;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PIDIPCmd_QueryFunctionSwitchReq extends PIDIPCmd<IDIPCmd_QueryFunctionSwitchReq>
/*    */ {
/*    */   public PIDIPCmd_QueryFunctionSwitchReq(IDIPCmd_QueryFunctionSwitchReq cmd)
/*    */   {
/* 20 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean handle()
/*    */     throws Exception
/*    */   {
/* 26 */     Map<Integer, Integer> status = new java.util.LinkedHashMap();
/* 27 */     for (int i = 0; i <= 592; i++)
/*    */     {
/* 29 */       status.put(Integer.valueOf(i), Integer.valueOf(1));
/*    */     }
/*    */     
/* 32 */     java.util.List<Integer> closeModules = OpenInterface.getCloseStatusModuleFunSwitches();
/* 33 */     for (Integer moduleid : closeModules)
/*    */     {
/* 35 */       status.put(moduleid, Integer.valueOf(0));
/*    */     }
/*    */     
/* 38 */     for (Map.Entry<Integer, Integer> entry : status.entrySet())
/*    */     {
/* 40 */       SFunctionSwitchInfo switchInfo = new SFunctionSwitchInfo();
/* 41 */       switchInfo.FunctionId = ((Integer)entry.getKey()).intValue();
/* 42 */       switchInfo.Status = ((Integer)entry.getValue()).byteValue();
/* 43 */       ((QueryFunctionSwitchRsp)((IDIPPacket_QueryFunctionSwitchRsp)((IDIPCmd_QueryFunctionSwitchReq)this.cmd).rsp).body).SwitchList.add(switchInfo);
/*    */     }
/*    */     
/* 46 */     ((QueryFunctionSwitchRsp)((IDIPPacket_QueryFunctionSwitchRsp)((IDIPCmd_QueryFunctionSwitchReq)this.cmd).rsp).body).SwitchList_count = ((QueryFunctionSwitchRsp)((IDIPPacket_QueryFunctionSwitchRsp)((IDIPCmd_QueryFunctionSwitchReq)this.cmd).rsp).body).SwitchList.size();
/*    */     
/* 48 */     ((IDIPPacket_QueryFunctionSwitchRsp)((IDIPCmd_QueryFunctionSwitchReq)this.cmd).rsp).head.Result = 0;
/* 49 */     ((IDIPPacket_QueryFunctionSwitchRsp)((IDIPCmd_QueryFunctionSwitchReq)this.cmd).rsp).head.RetErrMsg = "ok";
/* 50 */     ((IDIPCmd_QueryFunctionSwitchReq)this.cmd).sendResponse();
/*    */     
/* 52 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryFunctionSwitchReq.handle@query success|areaid=%d|partition=%d|platid=%d|size=%d", new Object[] { Integer.valueOf(((QueryFunctionSwitchReq)((IDIPPacket_QueryFunctionSwitchReq)((IDIPCmd_QueryFunctionSwitchReq)this.cmd).req).body).AreaId), Integer.valueOf(((QueryFunctionSwitchReq)((IDIPPacket_QueryFunctionSwitchReq)((IDIPCmd_QueryFunctionSwitchReq)this.cmd).req).body).Partition), Byte.valueOf(((QueryFunctionSwitchReq)((IDIPPacket_QueryFunctionSwitchReq)((IDIPCmd_QueryFunctionSwitchReq)this.cmd).req).body).PlatId), Integer.valueOf(((QueryFunctionSwitchRsp)((IDIPPacket_QueryFunctionSwitchRsp)((IDIPCmd_QueryFunctionSwitchReq)this.cmd).rsp).body).SwitchList_count) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 57 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_QueryFunctionSwitchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */