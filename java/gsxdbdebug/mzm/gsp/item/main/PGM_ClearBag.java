/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_ClearBag
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int bagid;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_ClearBag(long gmRoleid, long roleid, int bagid)
/*    */   {
/* 21 */     this.gmRoleid = gmRoleid;
/* 22 */     this.bagid = bagid;
/* 23 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     RoleItemBag bag = null;
/* 30 */     if (this.bagid == 1)
/*    */     {
/* 32 */       bag = ItemManager.getBag(this.roleid, 340600000);
/* 33 */       bag.clear();
/* 34 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d包裹清空成功", new Object[] { Long.valueOf(this.roleid) }));
/* 35 */       return true;
/*    */     }
/* 37 */     if (this.bagid == 2)
/*    */     {
/* 39 */       bag = ItemManager.getBag(this.roleid, 340600001);
/* 40 */       bag.clear();
/* 41 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d装备包裹清空成功", new Object[] { Long.valueOf(this.roleid) }));
/* 42 */       return true;
/*    */     }
/* 44 */     if (this.bagid == 3)
/*    */     {
/* 46 */       bag = ItemManager.getBag(this.roleid, 340600005);
/* 47 */       bag.clear();
/* 48 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d灵石包裹清空成功", new Object[] { Long.valueOf(this.roleid) }));
/* 49 */       return true;
/*    */     }
/* 51 */     if (this.bagid == 4)
/*    */     {
/* 53 */       bag = ItemManager.getBag(this.roleid, 340600006);
/* 54 */       bag.clear();
/* 55 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d法宝包裹清空成功", new Object[] { Long.valueOf(this.roleid) }));
/* 56 */       return true;
/*    */     }
/* 58 */     if (this.bagid == 5)
/*    */     {
/* 60 */       bag = ItemManager.getBag(this.roleid, 340600007);
/* 61 */       bag.clear();
/* 62 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d变身卡包裹清空成功", new Object[] { Long.valueOf(this.roleid) }));
/* 63 */       return true;
/*    */     }
/* 65 */     if (this.bagid == 6)
/*    */     {
/* 67 */       bag = ItemManager.getBag(this.roleid, 340600008);
/* 68 */       bag.clear();
/* 69 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d珍宝包裹清空成功", new Object[] { Long.valueOf(this.roleid) }));
/* 70 */       return true;
/*    */     }
/* 72 */     if (this.bagid == 7)
/*    */     {
/* 74 */       bag = ItemManager.getBag(this.roleid, 340600009);
/* 75 */       bag.clear();
/* 76 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d宠物印记包裹清空成功", new Object[] { Long.valueOf(this.roleid) }));
/* 77 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 81 */     bag = ItemManager.getBag(this.roleid, 340600000);
/* 82 */     bag.clear();
/* 83 */     bag = ItemManager.getBag(this.roleid, 340600001);
/* 84 */     bag.clear();
/* 85 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d包裹、装备包裹清空成功", new Object[] { Long.valueOf(this.roleid) }));
/* 86 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_ClearBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */