/*    */ package mzm.gsp.mysteryshop.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MysteryShopInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PFreeRefreshMysteryShop
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int shoptype;
/*    */   
/*    */   public PFreeRefreshMysteryShop(long roleid, int shoptype)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.shoptype = shoptype;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!MysteryShopManager.isMysteryShopSwitchOpenForRole(this.roleid))
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     if (!MysteryShopManager.isOpenForRoleLevel(this.roleid, this.shoptype))
/*    */     {
/* 37 */       String logStr = String.format("[mysteryshop]PFreeRefreshMysteryShop.processImp@role level can not operate mysteryshop|roleid=%d|shoptype=%d|rolelevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype), Integer.valueOf(RoleInterface.getLevel(this.roleid)) });
/*    */       
/*    */ 
/* 40 */       MysteryShopManager.logger.info(logStr);
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     if (!MysteryShopManager.isRoleStateCanOperateMall(this.roleid))
/*    */     {
/* 46 */       String logStr = String.format("[mysteryshop]PFreeRefreshMysteryShop.processImp@role state can not operate mysteryshop|roleid=%d|shoptype=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype) });
/*    */       
/*    */ 
/* 49 */       MysteryShopManager.logger.info(logStr);
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     String userid = RoleInterface.getUserId(this.roleid);
/* 54 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 56 */     MysteryShopInfo mysteryShopInfo = MysteryShopManager.getMysteryShopInfo(this.roleid, this.shoptype);
/* 57 */     if (mysteryShopInfo == null)
/*    */     {
/* 59 */       String logStr = String.format("[mysteryshop]PFreeRefreshMysteryShop.processImp@role have not mysteryshop|roleid=%d|shoptype=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype) });
/*    */       
/*    */ 
/* 62 */       MysteryShopManager.logger.info(logStr);
/* 63 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 67 */     if (mysteryShopInfo.getUsed_free_refresh_times() >= mysteryShopInfo.getCan_free_refresh_times())
/*    */     {
/* 69 */       MysteryShopManager.sendWrongInfo(this.roleid, 6, new String[0]);
/* 70 */       return false;
/*    */     }
/*    */     
/* 73 */     if (!MysteryShopManager.refreshMysteryShopFree(this.roleid, mysteryShopInfo, this.shoptype))
/*    */     {
/* 75 */       String logStr = String.format("[mysteryshop]PFreeRefreshMysteryShop.processImp@refresh fail mysteryshop|roleid=%d|shoptype=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype) });
/*    */       
/*    */ 
/* 78 */       MysteryShopManager.logger.error(logStr);
/* 79 */       return false;
/*    */     }
/*    */     
/* 82 */     MysteryShopManager.synMysteryShopInfo(this.roleid, this.shoptype);
/* 83 */     String logstr = String.format("[mysteryshop]PFreeRefreshMysteryShop.processImp@refresh goods success|userid=%s|roleid=%d|shoptype=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(this.shoptype) });
/*    */     
/*    */ 
/* 86 */     MysteryShopManager.logger.info(logstr);
/*    */     
/* 88 */     MysteryShopTLogManager.tlogMysteryShopRefresh(this.roleid, this.shoptype, -1, -1, mysteryShopInfo);
/* 89 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\main\PFreeRefreshMysteryShop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */