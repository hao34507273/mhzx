/*     */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import csprovider.DataBetweenCspAndGame_Re;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*     */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*     */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*     */ import mzm.gsp.csprovider.gmt.idip.Response;
/*     */ import mzm.gsp.csprovider.main.Retcode;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.PGM_CheckLingLevel;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class RepaireQiLingBugHandler implements IdipHandler
/*     */ {
/*     */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*     */   {
/*  21 */     long roleid = IdipGmtUtil.getRoleid((String)params.get(0));
/*  22 */     long uuid = Long.parseLong((String)params.get(1));
/*  23 */     int itemId = Integer.parseInt((String)params.get(2));
/*  24 */     int setlevel = Integer.parseInt((String)params.get(3));
/*  25 */     int currentLevel = Integer.parseInt((String)params.get(4));
/*  26 */     int isAleardyFailed = Integer.parseInt((String)params.get(5));
/*     */     
/*  28 */     if (!RoleInterface.isRoleExist(roleid, true))
/*     */     {
/*  30 */       int retcode = Retcode.ROLE_NOT_EXIST.value;
/*  31 */       rsp.retcode = retcode;
/*  32 */       Response response = IdipGmtUtil.getResponse(retcode, "role not found");
/*  33 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  35 */       GameServer.logger().error(String.format("[gmt]RepaireQiLingBugHandler.execute@role not found|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*  36 */       return;
/*     */     }
/*     */     
/*  39 */     if (!ItemInterface.isItemExist(itemId))
/*     */     {
/*  41 */       int retcode = Retcode.ITEM_CFG_ID_INVALID.value;
/*  42 */       rsp.retcode = retcode;
/*  43 */       Response response = IdipGmtUtil.getResponse(retcode, "item not exist");
/*  44 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  46 */       GameServer.logger().error(String.format("[gmt]RepaireQiLingBugHandler.execute@item id wrong|roleid=%d|uuid=%d|item_id=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(uuid), Integer.valueOf(itemId) }));
/*     */       
/*     */ 
/*  49 */       return;
/*     */     }
/*     */     
/*  52 */     int checkResult = PGM_CheckLingLevel.checkLingLevel(roleid, uuid, currentLevel);
/*  53 */     if ((isAleardyFailed == 0) && (checkResult == -1))
/*     */     {
/*  55 */       int retcode = Retcode.REPAIRE_QILING_UUID_INVALID.value;
/*  56 */       rsp.retcode = retcode;
/*  57 */       Response response = IdipGmtUtil.getResponse(retcode, "uuid wrond");
/*  58 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  60 */       GameServer.logger().error(String.format("[gmt]RepaireQiLingBugHandler.execute@uuid wrong|roleid=%d|uuid=%d|item_id=%d|set_level=%d|current_level=%d|is_aleardy_failed=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(uuid), Integer.valueOf(itemId), Integer.valueOf(setlevel), Integer.valueOf(currentLevel), Integer.valueOf(isAleardyFailed) }));
/*     */       
/*     */ 
/*     */ 
/*  64 */       return;
/*     */     }
/*     */     
/*  67 */     if (checkResult == 1)
/*     */     {
/*  69 */       int retcode = Retcode.REPAIRE_QILING_CURRENT_LEVEL_NOT_MATCH.value;
/*  70 */       rsp.retcode = retcode;
/*  71 */       Response response = IdipGmtUtil.getResponse(retcode, "current level not match");
/*  72 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/*  74 */       GameServer.logger().error(String.format("[gmt]RepaireQiLingBugHandler.execute@current level not match|roleid=%d|uuid=%d|item_id=%d|set_level=%d|current_level=%d|is_aleardy_failed=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(uuid), Integer.valueOf(itemId), Integer.valueOf(setlevel), Integer.valueOf(currentLevel), Integer.valueOf(isAleardyFailed) }));
/*     */       
/*     */ 
/*     */ 
/*  78 */       return;
/*     */     }
/*     */     
/*  81 */     if (isAleardyFailed == 0)
/*     */     {
/*  83 */       int ret = PGM_CheckLingLevel.setLingLevel(roleid, uuid, setlevel);
/*  84 */       if (ret != 0)
/*     */       {
/*  86 */         int retcode = Retcode.REPAIRE_QILING_SET_LEVEL_FAILED.value;
/*  87 */         rsp.retcode = retcode;
/*  88 */         Response response = IdipGmtUtil.getResponse(retcode, "set ling level failed");
/*  89 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/*  91 */         GameServer.logger().error(String.format("[gmt]RepaireQiLingBugHandler.execute@set ling level failed|roleid=%d|uuid=%d|item_id=%d|set_level=%d|current_level=%d|is_aleardy_failed=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(uuid), Integer.valueOf(itemId), Integer.valueOf(setlevel), Integer.valueOf(currentLevel), Integer.valueOf(isAleardyFailed) }));
/*     */         
/*     */ 
/*     */ 
/*  95 */         return;
/*     */       }
/*     */     }
/*  98 */     else if (isAleardyFailed == 1)
/*     */     {
/* 100 */       int ret = PGM_CheckLingLevel.setLingLevelByItemId(roleid, itemId, setlevel);
/* 101 */       if (ret != 0)
/*     */       {
/* 103 */         int retcode = Retcode.REPAIRE_QILING_SET_LEVEL_BY_ITEM_FAILED.value;
/* 104 */         rsp.retcode = retcode;
/* 105 */         Response response = IdipGmtUtil.getResponse(retcode, "set ling level by itemid failed");
/* 106 */         rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */         
/* 108 */         GameServer.logger().error(String.format("[gmt]RepaireQiLingBugHandler.execute@set ling level by itemid failed|roleid=%d|uuid=%d|item_id=%d|set_level=%d|current_level=%d|is_aleardy_failed=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(uuid), Integer.valueOf(itemId), Integer.valueOf(setlevel), Integer.valueOf(currentLevel), Integer.valueOf(isAleardyFailed) }));
/*     */         
/*     */ 
/*     */ 
/* 112 */         return;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 117 */       int retcode = Retcode.REPAIRE_QILING_FAILED.value;
/* 118 */       rsp.retcode = retcode;
/* 119 */       Response response = IdipGmtUtil.getResponse(retcode, "repair failed");
/* 120 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */       
/* 122 */       GameServer.logger().error(String.format("[gmt]RepaireQiLingBugHandler.execute@repair failed|roleid=%d|uuid=%d|item_id=%d|set_level=%d|current_level=%d|is_aleardy_failed=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(uuid), Integer.valueOf(itemId), Integer.valueOf(setlevel), Integer.valueOf(currentLevel), Integer.valueOf(isAleardyFailed) }));
/*     */       
/*     */ 
/*     */ 
/* 126 */       return;
/*     */     }
/*     */     
/* 129 */     rsp.retcode = Retcode.SUCCESS.value;
/* 130 */     Response response = new Response();
/* 131 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*     */     
/* 133 */     GameServer.logger().info(String.format("[gmt]RepaireQiLingBugHandler.execute@repair done|roleid=%d|uuid=%d|item_id=%d|set_level=%d|current_level=%d|is_aleardy_failed=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(uuid), Integer.valueOf(itemId), Integer.valueOf(setlevel), Integer.valueOf(currentLevel), Integer.valueOf(isAleardyFailed) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\RepaireQiLingBugHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */