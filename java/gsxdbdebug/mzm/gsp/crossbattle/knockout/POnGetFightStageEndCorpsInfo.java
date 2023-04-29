/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.crossbattle.GetFightStageEndCorpsInfo;
/*    */ import mzm.gsp.crossbattle.GetFightStageEndCorpsInfo_FinalHistory;
/*    */ import mzm.gsp.crossbattle.GetFightStageEndCorpsInfo_MapChampionStatue;
/*    */ import mzm.gsp.crossbattle.event.GetFightStageEndCorpsInfoArg;
/*    */ import mzm.gsp.crossbattle.event.GetFightStageEndCorpsInfoProcedure;
/*    */ import mzm.gsp.crossbattle.event.GetFinalChampionMapStatue;
/*    */ import mzm.gsp.crossbattle.event.GetFinalChampionMapStatueArg;
/*    */ 
/*    */ public class POnGetFightStageEndCorpsInfo
/*    */   extends GetFightStageEndCorpsInfoProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     OctetsStream octetsStream = new OctetsStream(((GetFightStageEndCorpsInfoArg)this.arg).octets);
/*    */     
/* 20 */     GetFightStageEndCorpsInfo getKnockOutContext = new GetFightStageEndCorpsInfo();
/* 21 */     getKnockOutContext.unmarshal(octetsStream);
/*    */     
/* 23 */     OctetsStream contextStream = new OctetsStream(getKnockOutContext.content);
/* 24 */     int reqType = getKnockOutContext.oper_type;
/* 25 */     switch (reqType)
/*    */     {
/*    */     case 1: 
/* 28 */       GetFightStageEndCorpsInfo_FinalHistory finalHistory = new GetFightStageEndCorpsInfo_FinalHistory();
/* 29 */       finalHistory.unmarshal(contextStream);
/*    */       
/* 31 */       CrossBattleKnockoutInterface.sendHistoryCorpInfo(finalHistory.session, finalHistory.rank, finalHistory.role_id, ((GetFightStageEndCorpsInfoArg)this.arg).corpsId, ((GetFightStageEndCorpsInfoArg)this.arg).corpsInfo);
/*    */       
/* 33 */       break;
/*    */     
/*    */     case 2: 
/* 36 */       GetFightStageEndCorpsInfo_MapChampionStatue mapChampionStatue = new GetFightStageEndCorpsInfo_MapChampionStatue();
/* 37 */       mapChampionStatue.unmarshal(contextStream);
/*    */       
/* 39 */       GetFinalChampionMapStatueArg getFinalChampionMapStatueArg = new GetFinalChampionMapStatueArg(((GetFightStageEndCorpsInfoArg)this.arg).isSucceed(), true, mapChampionStatue.session, ((GetFightStageEndCorpsInfoArg)this.arg).corpsInfo);
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 44 */       TriggerEventsManger.getInstance().triggerEvent(new GetFinalChampionMapStatue(), getFinalChampionMapStatueArg);
/*    */     }
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnGetFightStageEndCorpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */