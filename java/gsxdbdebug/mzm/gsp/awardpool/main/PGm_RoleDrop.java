/*    */ package mzm.gsp.awardpool.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.awardpool.confbean.SItemPoolSub;
/*    */ import mzm.gsp.awardpool.confbean.SRandomTextTableCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import xbean.IdCounter;
/*    */ import xbean.ItemSubid2Count;
/*    */ 
/*    */ public class PGm_RoleDrop extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long targetRoleid;
/*    */   private final int itemsubid;
/*    */   
/*    */   public PGm_RoleDrop(long gmRoleid, long targetRoleid, int itemsubid)
/*    */   {
/* 19 */     this.gmRoleid = gmRoleid;
/* 20 */     this.targetRoleid = targetRoleid;
/* 21 */     this.itemsubid = itemsubid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     String rolename = mzm.gsp.role.main.RoleInterface.getName(this.targetRoleid);
/* 28 */     int precoiusId = AwardPoolManager.getPreciousCfgId(this.itemsubid);
/* 29 */     if (precoiusId == -1)
/*    */     {
/* 31 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("物品子表%d 错误，没有稀有掉落", new Object[] { Integer.valueOf(this.itemsubid) }));
/* 32 */       return false;
/*    */     }
/* 34 */     ItemSubid2Count xItemSubid2Count = xtable.Role2itemsubid.get(Long.valueOf(this.targetRoleid));
/* 35 */     if (xItemSubid2Count == null)
/*    */     {
/*    */ 
/* 38 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("角色名%s:物品子表%d 错误，没有稀有掉落", new Object[] { rolename, Integer.valueOf(this.itemsubid) }));
/*    */       
/* 40 */       return false;
/*    */     }
/* 42 */     String itemName = "";
/* 43 */     SItemPoolSub sItemPoolSub = SItemPoolSub.get(this.itemsubid);
/* 44 */     if (sItemPoolSub != null)
/*    */     {
/* 46 */       itemName = ItemInterface.getItemName(sItemPoolSub.itemId);
/*    */     }
/*    */     else
/*    */     {
/* 50 */       SRandomTextTableCfg sRandomTextTableCfg = SRandomTextTableCfg.get(this.itemsubid);
/* 51 */       itemName = ItemInterface.getItemName(sRandomTextTableCfg.itemId);
/*    */     }
/*    */     
/* 54 */     IdCounter xIdCounter = (IdCounter)xItemSubid2Count.getItemsubid2count().get(Integer.valueOf(this.itemsubid));
/*    */     
/* 56 */     if (xIdCounter != null)
/*    */     {
/*    */ 
/* 59 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("角色名%s:物品子表%d ：%s 未命中次数 %d 已经掉落次数 %d、历史累计掉落次数%d、稀有配置Id %d", new Object[] { rolename, Integer.valueOf(this.itemsubid), itemName, Integer.valueOf(xIdCounter.getUnhitcount()), Integer.valueOf(xIdCounter.getDropcount()), Integer.valueOf(xIdCounter.getHistorydropcount()), Integer.valueOf(precoiusId) }));
/*    */ 
/*    */ 
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/*    */ 
/* 68 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("角色名%s:物品子表%d ：%s 未命中次数 %d 已经掉落次数 %d、历史累计掉落次数%d、稀有配置Id %d", new Object[] { rolename, Integer.valueOf(this.itemsubid), itemName, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(precoiusId) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\PGm_RoleDrop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */