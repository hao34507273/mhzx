/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.confbean.HuanHunMiShuConsts;
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.HanhunInfo;
/*    */ import xtable.Role2huanhun;
/*    */ 
/*    */ public class PGetHuanhunAwardReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGetHuanhunAwardReq(long roleId)
/*    */   {
/* 23 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!HuanhunManager.isHunOpen(this.roleId))
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     HanhunInfo xHunInfo = Role2huanhun.get(Long.valueOf(this.roleId));
/* 35 */     if (xHunInfo == null)
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 215, true))
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 47 */     if (xHunInfo.getIteminfos().size() == 0)
/*    */     {
/* 49 */       if (xHunInfo.getStatus() == 3)
/*    */       {
/* 51 */         return false;
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 56 */       if (!HuanhunManager.isAllBoxFull(xHunInfo))
/*    */       {
/* 58 */         return false;
/*    */       }
/*    */       
/* 61 */       TaskInterface.closeActivityGraphWithoutEvent(this.roleId, HuanHunMiShuConsts.getInstance().TASK_GRAPH_ID);
/*    */     }
/*    */     
/* 64 */     boolean isZero = IdipManager.isZeroProfit(this.roleId);
/*    */     
/* 66 */     if (!isZero)
/*    */     {
/*    */ 
/* 69 */       int itemId = HuanHunMiShuConsts.getInstance().AWARD_ITEM_ID;
/* 70 */       int num = HuanHunMiShuConsts.getInstance().AWARD_ITEM_NUM;
/*    */       
/* 72 */       ItemInterface.addItem(this.roleId, itemId, num, new TLogArg(LogReason.HUN_ALL_AWARD_REM));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 77 */       GameServer.logger().info(String.format("[hun]PGetHuanhunAwardReq.processImp@ role is in zero state!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       
/* 79 */       IdipManager.zeroProfitMsg(this.roleId);
/*    */     }
/*    */     
/*    */ 
/* 83 */     HuanhunManager.sendNextNeedInfo(this.roleId, xHunInfo);
/*    */     
/*    */ 
/* 86 */     xHunInfo.getGuyshelpyou().clear();
/* 87 */     xHunInfo.getIteminfos().clear();
/* 88 */     xHunInfo.setStatus(3);
/* 89 */     HuanhunManager.synHunStatus(this.roleId, xHunInfo.getStatus());
/*    */     
/* 91 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\PGetHuanhunAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */