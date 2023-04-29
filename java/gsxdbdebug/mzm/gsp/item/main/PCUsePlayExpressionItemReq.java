/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.item.confbean.SPlayExpressionItemCfg;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCUsePlayExpressionItemReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long uuid;
/*    */   
/*    */   public PCUsePlayExpressionItemReq(long roleid, long uuid)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.uuid = uuid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if ((this.roleid < 0L) || (this.uuid < 0L))
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*    */     {
/* 34 */       String logStr = String.format("[item]PCUsePlayExpressionItemReq.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 36 */       ItemManager.logger.info(logStr);
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     if (!ItemModuleSwitchInterface.isUsePlayExpressionItemSwitchOpenForRole(this.roleid))
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 169, true))
/*    */     {
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     BasicItem item = ItemInterface.getItemByUuid(this.roleid, this.uuid);
/* 51 */     if (item == null)
/*    */     {
/* 53 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     int itemCfgid = item.getCfgId();
/* 58 */     SPlayExpressionItemCfg itemCfg = SPlayExpressionItemCfg.get(itemCfgid);
/* 59 */     if (itemCfg == null)
/*    */     {
/* 61 */       ItemManager.sendWrongInfo(this.roleid, 101, new String[0]);
/* 62 */       return false;
/*    */     }
/*    */     
/* 65 */     TLogArg logArg = new TLogArg(LogReason.ITEM_USE_PLAY_EXPRESSION_ITEM_RME);
/* 66 */     boolean ret = ItemInterface.removeItemByUuid(this.roleid, this.uuid, 1, logArg);
/* 67 */     if (!ret)
/*    */     {
/* 69 */       ItemManager.sendWrongInfo(this.roleid, 40, new String[0]);
/* 70 */       return false;
/*    */     }
/*    */     
/* 73 */     MapInterface.onPlayExpressionItem(this.roleid, itemCfgid);
/*    */     
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PCUsePlayExpressionItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */