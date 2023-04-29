/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.GeneralCommandReq;
/*     */ import idip.GeneralCommandRsp;
/*     */ import idip.IDIPCmd_GeneralCommandReq;
/*     */ import idip.IDIPPacket_GeneralCommandReq;
/*     */ import idip.IDIPPacket_GeneralCommandRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ 
/*     */ public class PIDIPCmd_SetRoleStatus extends PIDIPCmd_GeneralCommandReq
/*     */ {
/*     */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*     */   {
/*  16 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*     */     {
/*     */ 
/*     */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*     */       {
/*  21 */         return new PIDIPCmd_SetRoleStatus(cmd);
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */   public PIDIPCmd_SetRoleStatus(IDIPCmd_GeneralCommandReq cmd)
/*     */   {
/*  28 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean executeCmd(List<Long> params)
/*     */     throws Exception
/*     */   {
/*  34 */     long roleid = ((Long)params.get(0)).longValue();
/*  35 */     int status = ((Long)params.get(1)).intValue();
/*  36 */     boolean remove = ((Long)params.get(2)).intValue() == 0;
/*     */     
/*  38 */     if (!mzm.gsp.status.main.RoleStatusInterface.containsStatus(status))
/*     */     {
/*  40 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/*  41 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "status invalid");
/*  42 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */       
/*  44 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_SetRoleStatus.executeCmd@status invalid|ret=%d|retMsg=%s|area_id=%d|plat_id=%d|partition=%d|roleid=%d|status=%d|remove=%b", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Integer.valueOf(status), Boolean.valueOf(remove) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!mzm.gsp.role.main.RoleInterface.isRoleExist(roleid, true))
/*     */     {
/*  54 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/*  55 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "role not exist");
/*  56 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */       
/*  58 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_SetRoleStatus.executeCmd@role not exist|ret=%d|retMsg=%s|area_id=%d|plat_id=%d|partition=%d|roleid=%d|status=%d|remove=%b", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Integer.valueOf(status), Boolean.valueOf(remove) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     boolean result = false;
/*  67 */     if (remove)
/*     */     {
/*  69 */       result = mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleid, status);
/*     */     }
/*     */     else
/*     */     {
/*  73 */       result = mzm.gsp.status.main.RoleStatusInterface.setStatus(roleid, status, true);
/*     */     }
/*     */     
/*  76 */     if (!result)
/*     */     {
/*  78 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/*  79 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = String.format("%s failed", new Object[] { remove ? "remove status" : "set status" }));
/*     */       
/*  81 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */       
/*  83 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_SetRoleStatus.executeCmd@handle failed|ret=%d|retMsg=%s|area_id=%d|plat_id=%d|partition=%d|roleid=%d|status=%d|remove=%b", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Integer.valueOf(status), Boolean.valueOf(remove) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/*  92 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = String.format("%s success", new Object[] { remove ? "remove status" : "set status" }));
/*     */     
/*  94 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */     
/*  96 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_ActivityClose.executeCmd@success|ret=%d|retMsg=%s|area_id=%d|plat_id=%d|partition=%d|roleid=%d|status=%d|remove=%b", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Integer.valueOf(status), Boolean.valueOf(remove) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 101 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean isGameServerLevelCommand()
/*     */   {
/* 107 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_SetRoleStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */