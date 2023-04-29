/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ import java.util.List;
/*    */ 
/*    */ public class PIDIPCmd_GroupShoppingItemSwitch extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 14 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 19 */         return new PIDIPCmd_GroupShoppingItemSwitch(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_GroupShoppingItemSwitch(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 26 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(List<Long> params)
/*    */     throws Exception
/*    */   {
/* 32 */     int activityCfgid = ((Long)params.get(0)).intValue();
/* 33 */     int itemCfgid = ((Long)params.get(1)).intValue();
/* 34 */     boolean ban = ((Long)params.get(2)).longValue() == 0L;
/*    */     
/* 36 */     boolean result = false;
/* 37 */     if (ban)
/*    */     {
/* 39 */       result = mzm.gsp.groupshopping.main.GroupShoppingBanInterface.ban(activityCfgid, itemCfgid);
/*    */     }
/*    */     else
/*    */     {
/* 43 */       result = mzm.gsp.groupshopping.main.GroupShoppingBanInterface.unban(activityCfgid, itemCfgid);
/*    */     }
/* 45 */     if (!result)
/*    */     {
/* 47 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 48 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "system error");
/* 49 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */       
/* 51 */       mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_GroupShoppingItemSwitch.executeCmd@failed|area_id=%d|plat_id=%d|partition=%d|activity_cfgid=%d|item_cfgid=%d|ban=%b", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Integer.valueOf(activityCfgid), Integer.valueOf(itemCfgid), Boolean.valueOf(ban) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 60 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = String.format("%s success", new Object[] { ban ? "ban" : "unban" }));
/* 61 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 63 */     mzm.gsp.GameServer.logger().info(String.format("[idip]PIDIPCmd_GroupShoppingItemSwitch.executeCmd@success|area_id=%d|plat_id=%d|partition=%d|activity_cfgid=%d|item_cfgid=%d|ban=%b", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Integer.valueOf(activityCfgid), Integer.valueOf(itemCfgid), Boolean.valueOf(ban) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 68 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_GroupShoppingItemSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */