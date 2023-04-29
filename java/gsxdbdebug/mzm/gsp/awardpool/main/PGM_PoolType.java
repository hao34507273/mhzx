/*    */ package mzm.gsp.awardpool.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_PoolType extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int typeid;
/*    */   
/*    */   public PGM_PoolType(long roleId, int typeid)
/*    */   {
/* 19 */     this.roleid = roleId;
/* 20 */     this.typeid = typeid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     String userid = RoleInterface.getUserId(this.roleid);
/* 27 */     int level = RoleInterface.getLevel(this.roleid);
/* 28 */     AwardPoolResultData awardPoolResultData = AwardPoolInterface.getAwardPoolData(this.typeid, this.roleid, level);
/* 29 */     if (awardPoolResultData == null)
/*    */     {
/* 31 */       SGMMessageTipRes gmMessageTipRes = new SGMMessageTipRes();
/* 32 */       gmMessageTipRes.result = Integer.MAX_VALUE;
/* 33 */       gmMessageTipRes.args.add(String.format("没有随机到物品,查看传递的type|type=%d|level=%d", new Object[] { Integer.valueOf(this.typeid), Integer.valueOf(level) }));
/* 34 */       OnlineManager.getInstance().sendAtOnce(this.roleid, gmMessageTipRes);
/* 35 */       return false;
/*    */     }
/* 37 */     AwardPoolInterface.doAward(userid, this.roleid, awardPoolResultData, new TLogArg(LogReason.GM_ADD));
/* 38 */     GmManager.getInstance().sendResultToGM(this.roleid, awardPoolResultData.toStringForGM());
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\PGM_PoolType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */