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
/*    */ public class PIDIPCmd_DeleteMagicMark extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 15 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 20 */         return new PIDIPCmd_DeleteMagicMark(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_DeleteMagicMark(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 27 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(List<Long> params)
/*    */     throws Exception
/*    */   {
/* 33 */     long roleid = ((Long)params.get(0)).longValue();
/* 34 */     int magicMarkItemId = ((Long)params.get(1)).intValue();
/*    */     
/* 36 */     int cutDuration = mzm.gsp.magicmark.main.MagicMarkInterface.removeMagicMarkByItem(roleid, magicMarkItemId);
/* 37 */     if (cutDuration < 0)
/*    */     {
/* 39 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 40 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "delete failed");
/* 41 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */       
/* 43 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_DeleteMagicMark.executeCmd@failed|area_id=%d|plat_id=%d|partition=%d|roleid=%d|itemid=%d|retcode=%d", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Integer.valueOf(magicMarkItemId), Integer.valueOf(cutDuration) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     if (cutDuration > 0)
/*    */     {
/* 53 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = idip.core.Utils.urlEncode1738(String.format("扣除角色%d小时的法印使用时间", new Object[] { Integer.valueOf(cutDuration) }), "UTF-8"));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 59 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "delete success");
/*    */     }
/*    */     
/* 62 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 63 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 65 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_DeleteMagicMark.executeCmd@success|area_id=%d|plat_id=%d|partition=%d|roleid=%d|itemid=%d|retcode=%d", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Integer.valueOf(magicMarkItemId), Integer.valueOf(cutDuration) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 70 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 76 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_DeleteMagicMark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */