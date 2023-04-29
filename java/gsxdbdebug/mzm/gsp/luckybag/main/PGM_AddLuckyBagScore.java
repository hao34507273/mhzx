/*    */ package mzm.gsp.luckybag.main;
/*    */ 
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.LuckyBagInfo;
/*    */ 
/*    */ public class PGM_AddLuckyBagScore extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int addScore;
/*    */   
/*    */   public PGM_AddLuckyBagScore(long gmRoleid, long roleid, int addScore)
/*    */   {
/* 16 */     this.gmRoleid = gmRoleid;
/* 17 */     this.roleid = roleid;
/* 18 */     this.addScore = addScore;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     if (!RoleInterface.isRoleExist(this.roleid, true))
/*    */     {
/* 26 */       notifyClient("角色不存在");
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     LuckyBagInfo xLuckyBagInfo = LuckyBagManager.getAndInitLuckyBagInfo(this.roleid);
/* 31 */     int beginScore = xLuckyBagInfo.getScore();
/* 32 */     int endScore = beginScore + this.addScore;
/* 33 */     if (endScore < 0)
/*    */     {
/* 35 */       endScore = 0;
/*    */     }
/* 37 */     xLuckyBagInfo.setScore(endScore);
/*    */     
/* 39 */     LuckyBagManager.syncLuckyBagExchangeScore(this.roleid, xLuckyBagInfo.getScore());
/*    */     
/* 41 */     notifyClient("设置成功");
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 47 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 48 */     messagetip.result = Integer.MAX_VALUE;
/* 49 */     messagetip.args.add(str);
/* 50 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\main\PGM_AddLuckyBagScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */