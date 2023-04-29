/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ 
/*    */ public class PIDIPCmd_DeleteWuShi extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 15 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 20 */         return new PIDIPCmd_DeleteWuShi(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_DeleteWuShi(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 27 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(List<Long> params)
/*    */     throws Exception
/*    */   {
/* 33 */     long roleid = ((Long)params.get(0)).longValue();
/* 34 */     int wuShiTypeId = ((Long)params.get(1)).intValue();
/* 35 */     int fragmentCount = ((Long)params.get(2)).intValue();
/*    */     
/* 37 */     int retcode = mzm.gsp.superequipment.wushi.main.WuShiInterface.removeWuShiByFragmentForIDIP(roleid, wuShiTypeId, fragmentCount, true);
/* 38 */     if (retcode != 0)
/*    */     {
/* 40 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = retcode);
/* 41 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "delete failed");
/* 42 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */       
/* 44 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DeleteWuShi.executeCmd@failed|area_id=%d|plat_id=%d|partition=%d|roleid=%d|typeid=%d|fragment_count=%d|retcode=%d", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Integer.valueOf(wuShiTypeId), Integer.valueOf(fragmentCount), Integer.valueOf(retcode) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 53 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "delete success");
/* 54 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 56 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DeleteWuShi.executeCmd@success|area_id=%d|plat_id=%d|partition=%d|roleid=%d|typeid=%d|fragment_count=%d|retcode=%d", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Integer.valueOf(wuShiTypeId), Integer.valueOf(fragmentCount), Integer.valueOf(retcode) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 61 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 67 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DeleteWuShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */