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
/*    */ public class PGM_ClearExpBottle extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_ClearExpBottle(long roleId)
/*    */   {
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     String userId = RoleInterface.getUserId(this.roleId);
/* 26 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 28 */     RoleItemBag roleItemBag = ItemManager.getBag(this.roleId, 340600000);
/* 29 */     if (roleItemBag == null)
/*    */     {
/* 31 */       GmManager.getInstance().sendResultToGM(this.roleId, "包裹数据找不到");
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     Map<Integer, BasicItem> xBasicItemMap = roleItemBag.getAllItems(false);
/* 36 */     for (Map.Entry<Integer, BasicItem> entry : xBasicItemMap.entrySet())
/*    */     {
/* 38 */       BasicItem basicItem = (BasicItem)entry.getValue();
/* 39 */       Item xItem = basicItem.xItem;
/*    */       
/* 41 */       SItemCfg sItemCfg = SItemCfg.get(xItem.getCfgid());
/* 42 */       if (sItemCfg != null)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 47 */         if (sItemCfg.type == 113)
/*    */         {
/* 49 */           xItem.getExtra().put(Integer.valueOf(ItemStoreEnum.LEFT_BOTTLE_EXP_VALUE.getStoreType()), Integer.valueOf(0)); }
/*    */       }
/*    */     }
/* 52 */     GmManager.getInstance().sendResultToGM(this.roleId, "您的经验瓶道具已经全部清空经验了");
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_ClearExpBottle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */