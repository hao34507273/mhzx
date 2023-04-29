/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ 
/*    */ public class PIDIPCmd_GeneralSysFunSwitchReq extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 16 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 21 */         return new PIDIPCmd_GeneralSysFunSwitchReq(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_GeneralSysFunSwitchReq(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 28 */     super(cmd);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean executeCmd(List<Long> params)
/*    */     throws Exception
/*    */   {
/* 35 */     long Switch = ((Long)params.get(0)).longValue();
/* 36 */     long moduleID = ((Long)params.get(1)).longValue();
/* 37 */     long FUNID = ((Long)params.get(2)).longValue();
/* 38 */     long parameter1 = ((Long)params.get(3)).longValue();
/* 39 */     long parameter2 = ((Long)params.get(4)).longValue();
/* 40 */     long parameter3 = ((Long)params.get(5)).longValue();
/*    */     
/* 42 */     boolean isOpen = Switch == 1L;
/* 43 */     List<Integer> ps = new ArrayList();
/* 44 */     if (parameter1 > 0L)
/*    */     {
/* 46 */       ps.add(Integer.valueOf((int)parameter1));
/*    */     }
/* 48 */     if (parameter2 > 0L)
/*    */     {
/* 50 */       ps.add(Integer.valueOf((int)parameter2));
/*    */     }
/* 52 */     if (parameter3 > 0L)
/*    */     {
/* 54 */       ps.add(Integer.valueOf((int)parameter3));
/*    */     }
/*    */     
/* 57 */     mzm.gsp.open.main.OpenInterface.setOpenStatus((int)moduleID, (int)FUNID, ps, isOpen);
/*    */     
/* 59 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 60 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "OK");
/*    */     
/*    */ 
/*    */ 
/* 64 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 66 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_GeneralSysFunSwitchReq.executeCmd@sys_fun_switch done|area_id=%d|plat_id=%d|partition=%d|switch=%d|moduleId=%d|FUNID=%d|parameter1=%d|parameter2=%d|parameter3=%d", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(Switch), Long.valueOf(moduleID), Long.valueOf(FUNID), Long.valueOf(parameter1), Long.valueOf(parameter2), Long.valueOf(parameter3) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 71 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_GeneralSysFunSwitchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */