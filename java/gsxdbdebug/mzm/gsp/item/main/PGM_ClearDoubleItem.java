/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.item.confbean.SItemCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Item;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGM_ClearDoubleItem
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_ClearDoubleItem(long roleId)
/*    */   {
/* 20 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     String userId = RoleInterface.getUserId(this.roleId);
/* 27 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 29 */     RoleItemBag roleItemBag = ItemManager.getBag(this.roleId, 340600000);
/* 30 */     if (roleItemBag == null)
/*    */     {
/* 32 */       GmManager.getInstance().sendResultToGM(this.roleId, "包裹数据找不到");
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     Map<Integer, BasicItem> xBasicItemMap = roleItemBag.getAllItems(false);
/* 37 */     for (Map.Entry<Integer, BasicItem> entry : xBasicItemMap.entrySet())
/*    */     {
/* 39 */       BasicItem basicItem = (BasicItem)entry.getValue();
/* 40 */       Item xItem = basicItem.xItem;
/*    */       
/* 42 */       SItemCfg sItemCfg = SItemCfg.get(xItem.getCfgid());
/* 43 */       if (sItemCfg != null)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 48 */         if (sItemCfg.type == 114)
/*    */         {
/* 50 */           xItem.getExtra().put(Integer.valueOf(221), Integer.valueOf(0)); }
/*    */       }
/*    */     }
/* 53 */     GmManager.getInstance().sendResultToGM(this.roleId, "您的双倍道具已经全部清空次数了");
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_ClearDoubleItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */