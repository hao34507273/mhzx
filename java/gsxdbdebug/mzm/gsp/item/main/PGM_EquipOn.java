/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_EquipOn
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int equipItemId;
/*    */   
/*    */   public PGM_EquipOn(long roleId, int equipequipItemId)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.equipItemId = equipequipItemId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     SItemEquipCfg equipCfg = SItemEquipCfg.get(this.equipItemId);
/* 25 */     if (equipCfg != null)
/*    */     {
/* 27 */       boolean re = true;
/* 28 */       if (ItemInterface.isEquiped(this.roleId, equipCfg.wearpos))
/*    */       {
/* 30 */         re = new PUnEquip(this.roleId, equipCfg.wearpos).call();
/* 31 */         if (!re)
/*    */         {
/* 33 */           return false;
/*    */         }
/*    */       }
/* 36 */       TLogArg logArg = new TLogArg(LogReason.GM_ADD, this.equipItemId);
/* 37 */       re = ItemInterface.addEquipment(this.roleId, this.equipItemId, logArg);
/* 38 */       return re;
/*    */     }
/*    */     
/*    */ 
/* 42 */     GmManager.getInstance().sendResultToGM(this.roleId, "物品id不是装备id");
/*    */     
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_EquipOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */