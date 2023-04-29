/*    */ package mzm.gsp.awardpool.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_PoolLib
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int poollibid;
/*    */   
/*    */   public PGM_PoolLib(long roleId, int poollibid)
/*    */   {
/* 21 */     this.roleid = roleId;
/* 22 */     this.poollibid = poollibid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     List<AwardPoolResultData> awradPoolDatas = AwardPoolInterface.getAwardPoolData(this.poollibid);
/* 29 */     String userid = RoleInterface.getUserId(this.roleid);
/* 30 */     if (awradPoolDatas.size() <= 0)
/*    */     {
/* 32 */       SGMMessageTipRes gmMessageTipRes = new SGMMessageTipRes();
/* 33 */       gmMessageTipRes.result = Integer.MAX_VALUE;
/* 34 */       gmMessageTipRes.args.add(String.format("没有随机到物品,查看传递的libid|libid=%d", new Object[] { Integer.valueOf(this.poollibid) }));
/* 35 */       OnlineManager.getInstance().sendAtOnce(this.roleid, gmMessageTipRes);
/* 36 */       return false;
/*    */     }
/* 38 */     boolean has = false;
/* 39 */     StringBuilder stringBuilder = new StringBuilder();
/* 40 */     for (AwardPoolResultData awardPoolResultData : awradPoolDatas)
/*    */     {
/* 42 */       AwardPoolInterface.doAward(userid, this.roleid, awardPoolResultData, new TLogArg(LogReason.GM_ADD));
/* 43 */       if (has)
/*    */       {
/* 45 */         stringBuilder.append(" # ");
/*    */       }
/* 47 */       has = true;
/* 48 */       stringBuilder.append(awardPoolResultData.toStringForGM());
/*    */     }
/* 50 */     GmManager.getInstance().sendResultToGM(this.roleid, stringBuilder.toString());
/*    */     
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\PGM_PoolLib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */