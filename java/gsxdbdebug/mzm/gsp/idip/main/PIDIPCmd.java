/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import idip.core.IDIPCmd;
/*     */ import idip.core.IDIPPacket;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.IDIPCmdInfo;
/*     */ import xtable.Idipcmds;
/*     */ 
/*     */ abstract class PIDIPCmd<CMD extends IDIPCmd<?, ?>> extends mzm.gsp.util.LogicProcedure
/*     */ {
/*  11 */   private static final Logger logger = Logger.getLogger("idip");
/*     */   
/*     */   protected final CMD cmd;
/*     */   
/*     */   public PIDIPCmd(CMD cmd)
/*     */   {
/*  17 */     this.cmd = cmd;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  23 */     if (isGameServerLevelCommand())
/*     */     {
/*  25 */       if (mzm.gsp.GameServerInfoManager.getZoneId() != this.cmd.getZoneid())
/*     */       {
/*  27 */         this.cmd.rsp.head.Result = -1;
/*  28 */         this.cmd.rsp.head.RetErrMsg = "system error:zoneid invalid, game server level command.";
/*  29 */         this.cmd.sendResponse();
/*     */         
/*  31 */         logger.error("[idip]PIDIPCmd.processImp@zoneid invalid, game server level command");
/*     */         
/*  33 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  37 */     String serialNo = getSerialNo();
/*  38 */     if (serialNo != null)
/*     */     {
/*  40 */       if (serialNo.isEmpty())
/*     */       {
/*  42 */         this.cmd.rsp.head.Result = -1;
/*  43 */         this.cmd.rsp.head.RetErrMsg = "system error:serial number is empty.";
/*  44 */         this.cmd.sendResponse();
/*     */         
/*  46 */         logger.error("[idip]PIDIPCmd.processImp@serial number is empty");
/*     */         
/*  48 */         return false;
/*     */       }
/*     */       
/*  51 */       IDIPCmdInfo xIDIPCmdInfo = Idipcmds.select(serialNo);
/*  52 */       if (xIDIPCmdInfo != null)
/*     */       {
/*  54 */         this.cmd.rsp.head.Result = -1;
/*  55 */         this.cmd.rsp.head.RetErrMsg = "system error:serial number duplicate.";
/*  56 */         this.cmd.sendResponse();
/*     */         
/*  58 */         logger.error("[idip]PIDIPCmd.processImp@serial number duplicate");
/*     */         
/*  60 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  66 */       if (!handle())
/*     */       {
/*  68 */         return false;
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  73 */       this.cmd.rsp.head.Result = -1;
/*  74 */       this.cmd.rsp.head.RetErrMsg = String.format("system error:%s.", new Object[] { e.getMessage() });
/*  75 */       this.cmd.sendResponse();
/*     */       
/*  77 */       logger.error("[idip]PIDIPCmd.processImp@handle idip cmd erro", e);
/*     */       
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if ((serialNo != null) && (!IdipManager.isIDIPPressureTest()))
/*     */     {
/*  84 */       IDIPCmdInfo xIDIPCmdInfo = xbean.Pod.newIDIPCmdInfo();
/*  85 */       xIDIPCmdInfo.setReqdataCopy(this.cmd.req.toString().getBytes("UTF-8"));
/*  86 */       xIDIPCmdInfo.setRspdataCopy(this.cmd.rsp.toString().getBytes("UTF-8"));
/*  87 */       if (!Idipcmds.add(serialNo, xIDIPCmdInfo))
/*     */       {
/*  89 */         this.cmd.rsp.head.Result = -1;
/*  90 */         this.cmd.rsp.head.RetErrMsg = "system error:update serial number error.";
/*  91 */         this.cmd.sendResponse();
/*     */         
/*  93 */         logger.error("[idip]PIDIPCmd.processImp@update serial number error");
/*     */         
/*  95 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  99 */     return true;
/*     */   }
/*     */   
/*     */   protected abstract boolean handle() throws Exception;
/*     */   
/*     */   protected String getSerialNo()
/*     */   {
/* 106 */     return null;
/*     */   }
/*     */   
/*     */   protected boolean isGameServerLevelCommand()
/*     */   {
/* 111 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PIDIPCmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */