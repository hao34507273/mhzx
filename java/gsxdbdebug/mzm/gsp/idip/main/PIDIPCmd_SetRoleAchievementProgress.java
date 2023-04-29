/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.GeneralCommandReq;
/*    */ import idip.GeneralCommandRsp;
/*    */ import idip.IDIPCmd_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandReq;
/*    */ import idip.IDIPPacket_GeneralCommandRsp;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PIDIPCmd_SetRoleAchievementProgress extends PIDIPCmd_GeneralCommandReq
/*    */ {
/*    */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*    */   {
/* 16 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*    */     {
/*    */ 
/*    */       public PIDIPCmd_GeneralCommandReq create(IDIPCmd_GeneralCommandReq cmd)
/*    */       {
/* 21 */         return new PIDIPCmd_SetRoleAchievementProgress(cmd);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public PIDIPCmd_SetRoleAchievementProgress(IDIPCmd_GeneralCommandReq cmd)
/*    */   {
/* 28 */     super(cmd);
/*    */   }
/*    */   
/*    */   protected boolean executeCmd(List<Long> params)
/*    */     throws Exception
/*    */   {
/* 34 */     long roleid = ((Long)params.get(0)).longValue();
/* 35 */     int goalCfgid = ((Long)params.get(1)).intValue();
/* 36 */     int size = ((Long)params.get(2)).intValue();
/*    */     
/* 38 */     if ((size > 7) || (size < 0))
/*    */     {
/* 40 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 41 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "param size invalid");
/* 42 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */       
/* 44 */       GameServer.logger().info(String.format("[idip]PIDIPCmd_SetRoleAchievementProgress.executeCmd@param size invalid|area_id=%d|plat_id=%d|partition=%d|roleid=%d|goal_cfgid=%d|size=%d", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Integer.valueOf(goalCfgid), Integer.valueOf(size) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     List<Integer> newParams = new java.util.ArrayList();
/* 53 */     for (int i = 0; i < size; i++)
/*    */     {
/* 55 */       newParams.add(Integer.valueOf(((Long)params.get(3 + i)).intValue()));
/*    */     }
/*    */     
/* 58 */     mzm.gsp.achievement.main.AchievementInterface.ChangeParamResult changeParamResult = mzm.gsp.achievement.main.AchievementInterface.changeAchievementParam(roleid, goalCfgid, newParams);
/* 59 */     if (changeParamResult != mzm.gsp.achievement.main.AchievementInterface.ChangeParamResult.SUCCESS)
/*    */     {
/* 61 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/* 62 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "system error");
/* 63 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */       
/* 65 */       GameServer.logger().info(String.format("[idip]PIDIPCmd_SetRoleAchievementProgress.executeCmd@failed|area_id=%d|plat_id=%d|partition=%d|roleid=%d|goal_cfgid=%d|retcode=%d|params=%s", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Integer.valueOf(goalCfgid), Integer.valueOf(changeParamResult.value), newParams.toString() }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 70 */       return false;
/*    */     }
/*    */     
/* 73 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 74 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "change success");
/* 75 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*    */     
/* 77 */     GameServer.logger().info(String.format("[idip]PIDIPCmd_SetRoleAchievementProgress.executeCmd@success|area_id=%d|plat_id=%d|partition=%d|roleid=%d|goal_cfgid=%d|params=%s", new Object[] { Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Integer.valueOf(goalCfgid), newParams.toString() }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 82 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean isGameServerLevelCommand()
/*    */   {
/* 88 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_SetRoleAchievementProgress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */