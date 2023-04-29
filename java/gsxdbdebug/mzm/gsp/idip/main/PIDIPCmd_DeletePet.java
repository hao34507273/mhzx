/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ import java.util.List;
/*    */ 
/*    */ public class PIDIPCmd_DeletePet extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 14 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 19 */         return new PIDIPCmd_DeletePet(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_DeletePet(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 26 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(List<Long> params)
/*    */     throws Exception
/*    */   {
/* 32 */     long roleid = ((Long)params.get(0)).longValue();
/* 33 */     int petCfgid = ((Long)params.get(1)).intValue();
/* 34 */     long petid = ((Long)params.get(2)).longValue();
/* 35 */     if (petid <= 0L)
/*    */     {
/* 37 */       petid = -1L;
/*    */     }
/*    */     
/* 40 */     int retcode = mzm.gsp.pet.main.PetInterface.removePet(roleid, petCfgid, petid);
/* 41 */     if (retcode != 0)
/*    */     {
/* 43 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = retcode);
/* 44 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "delete failed");
/* 45 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */       
/* 47 */       mzm.gsp.GameServer.logger().error(String.format("[idip]PIDIPCmd_DeletePet.executeCmd@failed|area_id=%d|plat_id=%d|partition=%d|roleid=%d|pet_cfgid=%d|petid=%d|retcode=%d", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Integer.valueOf(petCfgid), Long.valueOf(petid), Integer.valueOf(retcode) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "delete success");
/* 56 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 57 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 59 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_DeletePet.executeCmd@success|area_id=%d|plat_id=%d|partition=%d|roleid=%d|pet_cfgid=%d|petid=%d", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Integer.valueOf(petCfgid), Long.valueOf(petid) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 64 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 70 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DeletePet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */