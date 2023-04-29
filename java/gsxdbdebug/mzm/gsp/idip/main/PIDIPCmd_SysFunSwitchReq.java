/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.IDIPCmd_SysFunSwitchReq;
/*    */ import idip.IDIPPacket_SysFunSwitchReq;
/*    */ import idip.IDIPPacket_SysFunSwitchRsp;
/*    */ import idip.SysFunSwitchReq;
/*    */ import idip.SysFunSwitchRsp;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ 
/*    */ public class PIDIPCmd_SysFunSwitchReq extends PIDIPCmd<IDIPCmd_SysFunSwitchReq>
/*    */ {
/*    */   public PIDIPCmd_SysFunSwitchReq(IDIPCmd_SysFunSwitchReq cmd)
/*    */   {
/* 16 */     super(cmd);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean handle()
/*    */     throws Exception
/*    */   {
/* 23 */     long Switch = ((SysFunSwitchReq)((IDIPPacket_SysFunSwitchReq)((IDIPCmd_SysFunSwitchReq)this.cmd).req).body).Switch;
/* 24 */     long moduleID = ((SysFunSwitchReq)((IDIPPacket_SysFunSwitchReq)((IDIPCmd_SysFunSwitchReq)this.cmd).req).body).moduleID;
/* 25 */     long FUNID = ((SysFunSwitchReq)((IDIPPacket_SysFunSwitchReq)((IDIPCmd_SysFunSwitchReq)this.cmd).req).body).FUNID;
/* 26 */     long parameter1 = ((SysFunSwitchReq)((IDIPPacket_SysFunSwitchReq)((IDIPCmd_SysFunSwitchReq)this.cmd).req).body).parameter1;
/* 27 */     long parameter2 = ((SysFunSwitchReq)((IDIPPacket_SysFunSwitchReq)((IDIPCmd_SysFunSwitchReq)this.cmd).req).body).parameter2;
/* 28 */     long parameter3 = ((SysFunSwitchReq)((IDIPPacket_SysFunSwitchReq)((IDIPCmd_SysFunSwitchReq)this.cmd).req).body).parameter3;
/*    */     
/* 30 */     boolean isOpen = Switch == 1L;
/* 31 */     List<Integer> ps = new ArrayList();
/* 32 */     if (parameter1 > 0L)
/*    */     {
/* 34 */       ps.add(Integer.valueOf((int)parameter1));
/*    */     }
/* 36 */     if (parameter2 > 0L)
/*    */     {
/* 38 */       ps.add(Integer.valueOf((int)parameter2));
/*    */     }
/* 40 */     if (parameter3 > 0L)
/*    */     {
/* 42 */       ps.add(Integer.valueOf((int)parameter3));
/*    */     }
/*    */     
/* 45 */     mzm.gsp.open.main.OpenInterface.setOpenStatus((int)moduleID, (int)FUNID, ps, isOpen);
/*    */     
/* 47 */     ((SysFunSwitchRsp)((IDIPPacket_SysFunSwitchRsp)((IDIPCmd_SysFunSwitchReq)this.cmd).rsp).body).Result = 0;
/* 48 */     ((SysFunSwitchRsp)((IDIPPacket_SysFunSwitchRsp)((IDIPCmd_SysFunSwitchReq)this.cmd).rsp).body).RetMsg = "OK";
/* 49 */     ((IDIPCmd_SysFunSwitchReq)this.cmd).sendResponse();
/*    */     
/* 51 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_SysFunSwitchReq.handle@sys_fun_switch done|area_id=%d|plat_id=%d|partition=%d|switch=%d|moduleId=%d|FUNID=%d|parameter1=%d|parameter2=%d|parameter3=%d", new Object[] { Integer.valueOf(((SysFunSwitchReq)((IDIPPacket_SysFunSwitchReq)((IDIPCmd_SysFunSwitchReq)this.cmd).req).body).AreaId), Byte.valueOf(((SysFunSwitchReq)((IDIPPacket_SysFunSwitchReq)((IDIPCmd_SysFunSwitchReq)this.cmd).req).body).PlatId), Integer.valueOf(((SysFunSwitchReq)((IDIPPacket_SysFunSwitchReq)((IDIPCmd_SysFunSwitchReq)this.cmd).req).body).Partition), Long.valueOf(Switch), Long.valueOf(moduleID), Long.valueOf(FUNID), Long.valueOf(parameter1), Long.valueOf(parameter2), Long.valueOf(parameter3) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 56 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_SysFunSwitchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */