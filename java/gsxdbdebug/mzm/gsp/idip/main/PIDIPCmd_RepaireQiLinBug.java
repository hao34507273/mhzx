/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.GeneralCommandReq;
/*     */ import idip.GeneralCommandRsp;
/*     */ import idip.IDIPCmd_GeneralCommandReq;
/*     */ import idip.IDIPPacket_GeneralCommandReq;
/*     */ import idip.IDIPPacket_GeneralCommandRsp;
/*     */ import idip.core.IdipHeader;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PIDIPCmd_RepaireQiLinBug extends PIDIPCmd_GeneralCommandReq
/*     */ {
/*     */   static final PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator creater()
/*     */   {
/*  16 */     new PIDIPCmd_GeneralCommandReq.PIDIPCmd_GeneralCommandReqCreator()
/*     */     {
/*     */ 
/*     */       public PIDIPCmd_RepaireQiLinBug create(IDIPCmd_GeneralCommandReq cmd)
/*     */       {
/*  21 */         return new PIDIPCmd_RepaireQiLinBug(cmd);
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */   public PIDIPCmd_RepaireQiLinBug(IDIPCmd_GeneralCommandReq cmd)
/*     */   {
/*  28 */     super(cmd);
/*     */   }
/*     */   
/*     */   protected boolean executeCmd(java.util.List<Long> params)
/*     */     throws Exception
/*     */   {
/*  34 */     long roleid = ((Long)params.get(0)).longValue();
/*  35 */     if (!mzm.gsp.role.main.RoleInterface.isRoleExist(roleid, true))
/*     */     {
/*  37 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -1);
/*  38 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "query roleid empty");
/*  39 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */       
/*  41 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_RepaireQiLinBug.executeCmd@role not found|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|roleid=%d", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     long uuid = ((Long)params.get(1)).longValue();
/*  50 */     long itemId = ((Long)params.get(2)).longValue();
/*  51 */     if (!mzm.gsp.item.main.ItemInterface.isItemExist((int)itemId))
/*     */     {
/*  53 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -2);
/*  54 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "item id wrong");
/*  55 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */       
/*  57 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_RepaireQiLinBug.executeCmd@item id wrong|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|roleid=%d|uuid=%d|item_id=%d", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Long.valueOf(uuid), Long.valueOf(itemId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     long setlevel = ((Long)params.get(3)).longValue();
/*  66 */     long currentLevel = ((Long)params.get(4)).longValue();
/*  67 */     long isAleardyFailed = ((Long)params.get(5)).longValue();
/*     */     
/*  69 */     int checkResult = mzm.gsp.item.main.PGM_CheckLingLevel.checkLingLevel(roleid, uuid, (int)currentLevel);
/*  70 */     if ((isAleardyFailed == 0L) && (checkResult == -1))
/*     */     {
/*  72 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -3);
/*  73 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "uuid wrong");
/*  74 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */       
/*  76 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_RepaireQiLinBug.executeCmd@uuid wrong|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|roleid=%d|uuid=%d|item_id=%d|set_level=%d|current_level=%d|is_aleardy_failed=%d", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Long.valueOf(uuid), Long.valueOf(itemId), Long.valueOf(setlevel), Long.valueOf(currentLevel), Long.valueOf(isAleardyFailed) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if (checkResult == 1)
/*     */     {
/*  87 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -4);
/*  88 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "current level not match");
/*  89 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */       
/*  91 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_RepaireQiLinBug.executeCmd@current level not match|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|roleid=%d|uuid=%d|item_id=%d|set_level=%d|current_level=%d|is_aleardy_failed=%d", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Long.valueOf(uuid), Long.valueOf(itemId), Long.valueOf(setlevel), Long.valueOf(currentLevel), Long.valueOf(isAleardyFailed) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     if (isAleardyFailed == 0L)
/*     */     {
/* 102 */       int ret = mzm.gsp.item.main.PGM_CheckLingLevel.setLingLevel(roleid, uuid, (int)setlevel);
/* 103 */       if (ret != 0)
/*     */       {
/* 105 */         ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -5);
/* 106 */         ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "repair failed");
/* 107 */         ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */         
/* 109 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_RepaireQiLinBug.executeCmd@repair filed|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|roleid=%d|uuid=%d|item_id=%d|set_level=%d|current_level=%d|is_aleardy_failed=%d", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Long.valueOf(uuid), Long.valueOf(itemId), Long.valueOf(setlevel), Long.valueOf(currentLevel), Long.valueOf(isAleardyFailed) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 115 */         return false;
/*     */       }
/*     */     }
/* 118 */     else if (isAleardyFailed == 1L)
/*     */     {
/* 120 */       int ret = mzm.gsp.item.main.PGM_CheckLingLevel.setLingLevelByItemId(roleid, (int)itemId, (int)setlevel);
/* 121 */       if (ret != 0)
/*     */       {
/* 123 */         ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -6);
/* 124 */         ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "repair failed");
/* 125 */         ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */         
/* 127 */         GameServer.logger().error(String.format("[idip]PIDIPCmd_RepaireQiLinBug.executeCmd@repair failed|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|roleid=%d|uuid=%d|item_id=%d|set_level=%d|current_level=%d|is_aleardy_failed=%d", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Long.valueOf(uuid), Long.valueOf(itemId), Long.valueOf(setlevel), Long.valueOf(currentLevel), Long.valueOf(isAleardyFailed) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 133 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 138 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = -7);
/* 139 */       ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "repair failed");
/* 140 */       ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */       
/* 142 */       GameServer.logger().error(String.format("[idip]PIDIPCmd_RepaireQiLinBug.executeCmd@repair failed|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|roleid=%d|uuid=%d|item_id=%d|set_level=%d|current_level=%d|is_aleardy_failed=%d", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Long.valueOf(uuid), Long.valueOf(itemId), Long.valueOf(setlevel), Long.valueOf(currentLevel), Long.valueOf(isAleardyFailed) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).Result = 0);
/* 152 */     ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg = (((GeneralCommandRsp)((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).body).RetMsg = "repair qi lin done");
/* 153 */     ((IDIPCmd_GeneralCommandReq)this.cmd).sendResponse();
/*     */     
/* 155 */     GameServer.logger().error(String.format("[idip]PIDIPCmd_RepaireQiLinBug.executeCmd@repair done|ret=%d|ret_msg=%s|area_id=%d|plat_id=%d|partition=%d|roleid=%d|uuid=%d|item_id=%d|set_level=%d|current_level=%d|is_aleardy_failed=%d", new Object[] { Integer.valueOf(((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.Result), ((IDIPPacket_GeneralCommandRsp)((IDIPCmd_GeneralCommandReq)this.cmd).rsp).head.RetErrMsg, Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).AreaId), Byte.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).PlatId), Integer.valueOf(((GeneralCommandReq)((IDIPPacket_GeneralCommandReq)((IDIPCmd_GeneralCommandReq)this.cmd).req).body).Partition), Long.valueOf(roleid), Long.valueOf(uuid), Long.valueOf(itemId), Long.valueOf(setlevel), Long.valueOf(currentLevel), Long.valueOf(isAleardyFailed) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 161 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd_RepaireQiLinBug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */