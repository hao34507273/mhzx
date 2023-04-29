/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ import java.util.List;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class PIDIPCmd_QueryRoleStatus extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 15 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 20 */         return new PIDIPCmd_QueryRoleStatus(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_QueryRoleStatus(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 27 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(List<Long> params)
/*    */     throws Exception
/*    */   {
/* 33 */     long roleid = ((Long)params.get(0)).longValue();
/*    */     
/* 35 */     String msg = "";
/* 36 */     boolean exist = RoleInterface.isRoleExit(roleid);
/* 37 */     if (!exist)
/*    */     {
/* 39 */       msg = "not exist";
/*    */     }
/*    */     else
/*    */     {
/* 43 */       int status = RoleInterface.getDeleteState(roleid, true);
/* 44 */       switch (status)
/*    */       {
/*    */       case 0: 
/* 47 */         msg = "delete counter";
/* 48 */         break;
/*    */       case 1: 
/* 50 */         msg = "delete";
/* 51 */         break;
/*    */       case 2: 
/* 53 */         msg = "real delete";
/* 54 */         break;
/*    */       case 3: 
/* 56 */         msg = "normal";
/* 57 */         break;
/*    */       case 4: 
/* 59 */         msg = "recovery";
/* 60 */         break;
/*    */       default: 
/* 62 */         msg = "system error";
/*    */       }
/*    */       
/*    */     }
/*    */     
/* 67 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 68 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = msg);
/* 69 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 71 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_QueryRoleStatus.executeCmd@query done|ret=%d|retMsg=%s|area_id=%d|plat_id=%d|partition=%d|roleid=%d", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), msg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 76 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_QueryRoleStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */