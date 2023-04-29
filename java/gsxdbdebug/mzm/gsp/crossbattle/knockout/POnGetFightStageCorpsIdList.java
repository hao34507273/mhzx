/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.GetFightStageCorpsIdList;
/*    */ import mzm.gsp.crossbattle.GetFightStageCorpsIdList_Award;
/*    */ import mzm.gsp.crossbattle.GetFightStageCorpsIdList_NotifyKnockOutCorpsId;
/*    */ import mzm.gsp.crossbattle.event.GetFightStageCorpsIdListArg;
/*    */ import mzm.gsp.crossbattle.event.GetFightStageCorpsIdListProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnGetFightStageCorpsIdList extends GetFightStageCorpsIdListProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     OctetsStream octetsStream = new OctetsStream(((GetFightStageCorpsIdListArg)this.arg).octets);
/*    */     
/* 18 */     GetFightStageCorpsIdList getFightStageCorpsIdList = new GetFightStageCorpsIdList();
/* 19 */     getFightStageCorpsIdList.unmarshal(octetsStream);
/*    */     
/* 21 */     OctetsStream contextStream = new OctetsStream(getFightStageCorpsIdList.content);
/* 22 */     int reqType = getFightStageCorpsIdList.oper_type;
/*    */     
/* 24 */     StringBuilder sb = new StringBuilder();
/* 25 */     switch (reqType)
/*    */     {
/*    */     case 1: 
/* 28 */       GetFightStageCorpsIdList_NotifyKnockOutCorpsId createPrepareWorld = new GetFightStageCorpsIdList_NotifyKnockOutCorpsId();
/* 29 */       createPrepareWorld.unmarshal(contextStream);
/*    */       
/* 31 */       if (!((GetFightStageCorpsIdListArg)this.arg).isSucceed())
/*    */       {
/* 33 */         sb.append("[crossbattle_knockout]POnGetFightStageCorpsIdList.processImp@notif knock out corps id,get fight stage corps info failed");
/*    */         
/* 35 */         GameServer.logger().info(sb.toString());
/* 36 */         return false;
/*    */       }
/*    */       
/* 39 */       sb.append("[crossbattle_knockout]POnGetFightStageCorpsIdList.processImp@notif knock out corps id,get fight stage corps info success");
/*    */       
/* 41 */       GameServer.logger().info(sb.toString());
/*    */       
/* 43 */       return new POnGetNotifyCorpsIdSet(((GetFightStageCorpsIdListArg)this.arg).knockOutType, ((GetFightStageCorpsIdListArg)this.arg).fightStage, ((GetFightStageCorpsIdListArg)this.arg).corpsIdSet).call();
/*    */     
/*    */     case 2: 
/* 46 */       GetFightStageCorpsIdList_Award knockOutAward = new GetFightStageCorpsIdList_Award();
/* 47 */       knockOutAward.unmarshal(contextStream);
/*    */       
/* 49 */       if (!((GetFightStageCorpsIdListArg)this.arg).isSucceed())
/*    */       {
/* 51 */         sb.append("[crossbattle_knockout]POnGetKnockOutInfo.processImp@get fight stage corps info failed");
/* 52 */         sb.append("|activit_cfg_id=").append(((GetFightStageCorpsIdListArg)this.arg).activityCfgId);
/* 53 */         sb.append("|knock_out_type=").append(((GetFightStageCorpsIdListArg)this.arg).knockOutType);
/* 54 */         sb.append("|fight_stage=").append(((GetFightStageCorpsIdListArg)this.arg).fightStage);
/*    */         
/* 56 */         GameServer.logger().error(sb.toString());
/*    */         
/* 58 */         return false;
/*    */       }
/*    */       
/* 61 */       return new PTryKnockOutAward(((GetFightStageCorpsIdListArg)this.arg).activityCfgId, ((GetFightStageCorpsIdListArg)this.arg).knockOutType, ((GetFightStageCorpsIdListArg)this.arg).corpsIdSet).call();
/*    */     }
/*    */     
/*    */     
/* 65 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnGetFightStageCorpsIdList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */