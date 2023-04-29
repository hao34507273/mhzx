/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.mall.main.JifenOperateResult;
/*    */ import mzm.gsp.mall.main.MallInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_AddPetArenaPoint extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int num;
/*    */   
/*    */   public PGM_AddPetArenaPoint(long gmRoleid, long roleid, int num)
/*    */   {
/* 20 */     this.gmRoleid = gmRoleid;
/* 21 */     this.roleid = roleid;
/* 22 */     this.num = num;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (this.num <= 0)
/*    */     {
/* 30 */       notifyClient("数量必须大于0");
/* 31 */       return false;
/*    */     }
/* 33 */     TLogArg logArg = new TLogArg(LogReason.PET_ARENA_GM);
/* 34 */     JifenOperateResult res = MallInterface.addJifen(this.roleid, this.num, 14, true, logArg);
/* 35 */     if (!res.isSuccess())
/*    */     {
/* 37 */       notifyClient("添加失败");
/* 38 */       return false;
/*    */     }
/* 40 */     notifyClient("添加成功");
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 46 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 47 */     messagetip.result = Integer.MAX_VALUE;
/* 48 */     messagetip.args.add(str);
/* 49 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PGM_AddPetArenaPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */