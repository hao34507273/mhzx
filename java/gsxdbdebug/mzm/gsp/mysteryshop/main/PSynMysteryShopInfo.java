/*    */ package mzm.gsp.mysteryshop.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MysteryShopInfo;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleMysteryShops;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2mystery_shops;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PSynMysteryShopInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int shoptype;
/*    */   
/*    */   public PSynMysteryShopInfo(long roleid, int shoptype)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.shoptype = shoptype;
/*    */   }
/*    */   
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
/* 37 */       String logStr = String.format("[mysteryshop]PSynMysteryShopInfo.processImp@role level can not operate mysteryshop|roleid=%d|shoptype=%d|rolelevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype), Integer.valueOf(RoleInterface.getLevel(this.roleid)) });
/*    */       
/*    */ 
/* 40 */       MysteryShopManager.logger.info(logStr);
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     if (!MysteryShopManager.isRoleStateCanOperateMall(this.roleid))
/*    */     {
/* 46 */       String logStr = String.format("[mysteryshop]PSynMysteryShopInfo.processImp@role state can not operate mysteryshop|roleid=%d|shoptype=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype) });
/*    */       
/*    */ 
/* 49 */       MysteryShopManager.logger.info(logStr);
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     String userid = RoleInterface.getUserId(this.roleid);
/* 54 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 56 */     if (!MysteryShopManager.getValidMysteryShopType().contains(Integer.valueOf(this.shoptype)))
/*    */     {
/* 58 */       String logStr = String.format("[mysteryshop]PSynMysteryShopInfo.processImp@shoptype error mysteryshop|roleid=%d|shoptype=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype) });
/*    */       
/*    */ 
/* 61 */       MysteryShopManager.logger.info(logStr);
/* 62 */       return false;
/*    */     }
/*    */     
/* 65 */     RoleMysteryShops roleMysteryShops = Role2mystery_shops.get(Long.valueOf(this.roleid));
/* 66 */     if (roleMysteryShops == null)
/*    */     {
/* 68 */       roleMysteryShops = Pod.newRoleMysteryShops();
/* 69 */       Role2mystery_shops.insert(Long.valueOf(this.roleid), roleMysteryShops);
/*    */     }
/*    */     
/* 72 */     MysteryShopInfo mysteryShopInfo = (MysteryShopInfo)roleMysteryShops.getType2shop_info().get(Integer.valueOf(this.shoptype));
/* 73 */     if (mysteryShopInfo == null)
/*    */     {
/* 75 */       mysteryShopInfo = Pod.newMysteryShopInfo();
/* 76 */       roleMysteryShops.getType2shop_info().put(Integer.valueOf(this.shoptype), mysteryShopInfo);
/*    */       
/* 78 */       long cur = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 79 */       if (!MysteryShopManager.refreshMysteryShopSys(this.roleid, this.shoptype, cur))
/*    */       {
/* 81 */         String logStr = String.format("[mysteryshop]PSynMysteryShopInfo.processImp@refresh fail mysteryshop|roleid=%d|shoptype=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shoptype) });
/*    */         
/*    */ 
/* 84 */         MysteryShopManager.logger.error(logStr);
/* 85 */         return false;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 90 */     MysteryShopManager.synMysteryShopInfo(this.roleid, this.shoptype);
/* 91 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\main\PSynMysteryShopInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */