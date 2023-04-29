/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import hub.DataTransferReq;
/*     */ import hub.DataTransferReqXidWrapper;
/*     */ import hub.DataTransferRsp;
/*     */ import hub.DataTransferRspXidWrapper;
/*     */ import hub.GHubHelper;
/*     */ import hub.SelectionOrFinalFightBeginReq;
/*     */ import hub.SelectionOrFinalFightBeginRsp;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutManager;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DTH_KnockOutFightBeginReq
/*     */   extends DataTransferHandler<SelectionOrFinalFightBeginReq, SelectionOrFinalFightBeginRsp>
/*     */ {
/*     */   protected SelectionOrFinalFightBeginReq makeReqDataBean()
/*     */   {
/*  29 */     return new SelectionOrFinalFightBeginReq();
/*     */   }
/*     */   
/*     */ 
/*     */   protected SelectionOrFinalFightBeginRsp makeRspDataBean()
/*     */   {
/*  35 */     return new SelectionOrFinalFightBeginRsp();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onDataTransferReq(DataTransferReq req, SelectionOrFinalFightBeginReq reqData)
/*     */   {
/*  42 */     DataTransferRsp rsp = new DataTransferRsp();
/*  43 */     rsp.direction = req.direction;
/*  44 */     rsp.xid = req.xid;
/*  45 */     rsp.src_id = req.dst_id;
/*  46 */     rsp.dst_id = req.src_id;
/*  47 */     rsp.data_type = req.data_type;
/*  48 */     rsp.retcode = 0;
/*     */     
/*  50 */     new PKnockOutFightBegin(reqData.corps_id, reqData.fight_type, reqData.fight_stage, reqData.fight_index_id, reqData.fight_record_id).call();
/*     */     
/*     */ 
/*  53 */     SelectionOrFinalFightBeginReq selectionOrFinalDataBackRsp = new SelectionOrFinalFightBeginReq();
/*  54 */     OctetsStream os = new OctetsStream();
/*  55 */     selectionOrFinalDataBackRsp.marshal(os);
/*  56 */     rsp.data = os;
/*  57 */     GHubHelper.sendDataTransferRsp(rsp);
/*     */     
/*  59 */     StringBuilder sb = new StringBuilder();
/*  60 */     sb.append("[crossserver_knockout]DTH_KnockOutFightBeginReq.onDataTransferReq@own server receive fight begin");
/*  61 */     sb.append(reqData.toString());
/*     */     
/*  63 */     GameServer.logger().info(sb.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class PKnockOutFightBegin
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long corpsId;
/*     */     
/*     */     private final int knockOutType;
/*     */     
/*     */     private final int fightStage;
/*     */     
/*     */     private final int fightIndexId;
/*     */     
/*     */     private final long fightRecordId;
/*     */     
/*     */ 
/*     */     public PKnockOutFightBegin(long corpsId, int knockOutType, int fightStage, int fightIndexId, long fightRecordId)
/*     */     {
/*  84 */       this.corpsId = corpsId;
/*  85 */       this.knockOutType = knockOutType;
/*  86 */       this.fightStage = fightStage;
/*  87 */       this.fightIndexId = fightIndexId;
/*  88 */       this.fightRecordId = fightRecordId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  94 */       int actiivtyCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*  95 */       int fightZoneId = CrossBattleKnockoutManager.getFightZone(this.corpsId, actiivtyCfgId, this.knockOutType);
/*  96 */       if (fightZoneId < 0)
/*     */       {
/*     */ 
/*  99 */         return false;
/*     */       }
/*     */       
/* 102 */       boolean isSendSuccess = GrcInterface.reportCrossBattleKnockOutFightBegin(actiivtyCfgId, this.knockOutType, fightZoneId, this.fightStage, this.fightIndexId, this.fightRecordId);
/*     */       
/* 104 */       if (!isSendSuccess)
/*     */       {
/* 106 */         Xdb.executor().schedule(new DTH_KnockOutFightBeginReq.RRepeatReportFightBegin(actiivtyCfgId, this.knockOutType, fightZoneId, this.fightStage, this.fightIndexId, this.fightRecordId, 1), 60000L, TimeUnit.MILLISECONDS);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 112 */       StringBuilder contextBuilder = new StringBuilder();
/* 113 */       contextBuilder.append("[crossbattle_knockout]PKnockOutFightBegin.processImp@send fight begin");
/* 114 */       contextBuilder.append("|corps_id=").append(this.corpsId);
/* 115 */       contextBuilder.append("|knock_out_type=").append(this.knockOutType);
/* 116 */       contextBuilder.append("|fight_stage=").append(this.fightStage);
/* 117 */       contextBuilder.append("|fight_index_id=").append(this.fightIndexId);
/* 118 */       contextBuilder.append("|fight_record_id=").append(this.fightRecordId);
/* 119 */       contextBuilder.append("|is_send_success=").append(isSendSuccess);
/*     */       
/* 121 */       GameServer.logger().info(contextBuilder.toString());
/* 122 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class RRepeatReportFightBegin
/*     */     implements Runnable
/*     */   {
/*     */     private final int activityCfgId;
/*     */     private final int knockOutType;
/*     */     private final int fightZoneId;
/*     */     private final int fightStage;
/*     */     private final int fightIndexId;
/*     */     private final long fightRecordId;
/*     */     private int repeatTimes;
/*     */     
/*     */     public RRepeatReportFightBegin(int activityCfgId, int knockOutType, int fightZoneId, int fightStage, int fightIndexId, long fightRecordId, int repeatTimes)
/*     */     {
/* 139 */       this.activityCfgId = activityCfgId;
/* 140 */       this.knockOutType = knockOutType;
/* 141 */       this.fightZoneId = fightZoneId;
/* 142 */       this.fightStage = fightStage;
/* 143 */       this.fightIndexId = fightIndexId;
/* 144 */       this.fightRecordId = fightRecordId;
/* 145 */       this.repeatTimes = repeatTimes;
/*     */     }
/*     */     
/*     */     public void run()
/*     */     {
/* 150 */       StringBuilder contextBuilder = new StringBuilder();
/* 151 */       contextBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 152 */       contextBuilder.append("|knock_out_type=").append(this.knockOutType);
/* 153 */       contextBuilder.append("|fight_zone_id=").append(this.fightZoneId);
/* 154 */       contextBuilder.append("|fight_stage=").append(this.fightStage);
/* 155 */       contextBuilder.append("|fight_index_id=").append(this.fightIndexId);
/* 156 */       contextBuilder.append("|fight_record_id=").append(this.fightRecordId);
/* 157 */       contextBuilder.append("|repeat_times=").append(this.repeatTimes);
/*     */       
/* 159 */       boolean isSendSuccess = GrcInterface.reportCrossBattleKnockOutFightBegin(this.activityCfgId, this.knockOutType, this.fightZoneId, this.fightStage, this.fightIndexId, this.fightRecordId);
/*     */       
/* 161 */       if (!isSendSuccess)
/*     */       {
/* 163 */         this.repeatTimes += 1;
/* 164 */         Xdb.executor().schedule(this, 60000L, TimeUnit.MILLISECONDS);
/*     */         
/* 166 */         StringBuilder sBuilder = new StringBuilder();
/* 167 */         sBuilder.append("[crossbattle_knockout]RRepeatReportFightBegin.send fail");
/* 168 */         sBuilder.append("|context_builder=").append(contextBuilder);
/*     */         
/* 170 */         GameServer.logger().info(sBuilder.toString());
/*     */         
/* 172 */         return;
/*     */       }
/*     */       
/* 175 */       StringBuilder sBuilder = new StringBuilder();
/* 176 */       sBuilder.append("[crossbattle_knockout]RRepeatReportFightBegin.send success");
/* 177 */       sBuilder.append("|context_builder=").append(contextBuilder);
/*     */       
/* 179 */       GameServer.logger().info(sBuilder.toString());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, SelectionOrFinalFightBeginReq reqData, int code)
/*     */   {
/* 189 */     GameServer.logger().error(String.format("[crossserver_knockout]DTH_KnockOutFightBeginReq.onDataTransferRsp@time out now|des=%s", new Object[] { reqData.toString() }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, SelectionOrFinalFightBeginReq reqData, DataTransferRspXidWrapper rspXidWrapper, SelectionOrFinalFightBeginRsp rspData)
/*     */   {
/* 199 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/* 200 */     if (rsp.retcode != 0)
/*     */     {
/* 202 */       GameServer.logger().error(String.format("[crossserver_knockout]DTH_KnockOutFightBeginReq.onDataTransferRsp@ret code is error|errorcode=%d|desc=%s", new Object[] { Integer.valueOf(rsp.retcode), reqData.toString() }));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_KnockOutFightBeginReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */