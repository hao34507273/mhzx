/*    */ package mzm.gsp.mibao.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.mibao.SGetMiBaoInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.Role2MiBaoInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGM_AddScore extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   public final long roleId;
/*    */   public final int score;
/*    */   
/*    */   public PGM_AddScore(long roleId, int score)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.score = score;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 26 */     lock(Lockeys.get(User.getTable(), userId));
/* 27 */     Role2MiBaoInfo xRole2MiBaoInfo = xtable.Role2mibao.get(Long.valueOf(this.roleId));
/* 28 */     if (xRole2MiBaoInfo == null)
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     xRole2MiBaoInfo.setCurrent_score(xRole2MiBaoInfo.getCurrent_score() + this.score);
/*    */     
/* 35 */     SGetMiBaoInfo sGetMiBaoInfo = new SGetMiBaoInfo();
/* 36 */     sGetMiBaoInfo.current_lucky_value = xRole2MiBaoInfo.getCurrent_lucky_value();
/* 37 */     sGetMiBaoInfo.current_mibao_index_id = xRole2MiBaoInfo.getCurrent_index_id();
/* 38 */     sGetMiBaoInfo.current_score = xRole2MiBaoInfo.getCurrent_score();
/*    */     
/* 40 */     OnlineManager.getInstance().send(this.roleId, sGetMiBaoInfo);
/*    */     
/* 42 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 43 */     messagetip.result = Integer.MAX_VALUE;
/* 44 */     messagetip.args.add(String.format("增加成就积分成功!", new Object[0]));
/* 45 */     OnlineManager.getInstance().sendAtOnce(this.roleId, messagetip);
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\main\PGM_AddScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */