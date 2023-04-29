/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.gang.SSearchGangListRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GangGlobal;
/*    */ 
/*    */ public class PSearchGangListReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private String condition;
/*    */   
/*    */   public PSearchGangListReq(long roleId, String condition)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.condition = condition;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     GangGlobal xGlobal = GangManager.getXGlobal(false);
/*    */     
/*    */ 
/* 27 */     long gangId = GangManager.findGangInfo(xGlobal, this.condition);
/* 28 */     if (gangId < 0L) {
/* 29 */       SGangNormalResult result = new SGangNormalResult();
/* 30 */       result.result = 4;
/* 31 */       OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/* 32 */       return false;
/*    */     }
/* 34 */     SSearchGangListRes res = new SSearchGangListRes();
/*    */     
/* 36 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/* 37 */     if (xGang == null) {
/* 38 */       SGangNormalResult result = new SGangNormalResult();
/* 39 */       result.result = 4;
/* 40 */       OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/* 41 */       return false;
/*    */     }
/* 43 */     GangManager.fillGangInfo(xGang, res.result);
/* 44 */     res.result.gangid = gangId;
/* 45 */     OnlineManager.getInstance().send(this.roleId, res);
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PSearchGangListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */