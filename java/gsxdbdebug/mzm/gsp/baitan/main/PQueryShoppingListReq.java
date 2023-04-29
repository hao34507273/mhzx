/*    */ package mzm.gsp.baitan.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.baitan.SQueryShopingListRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.server.main.ServerInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleGrid;
/*    */ import xbean.Subtype2ItemList;
/*    */ import xtable.Role2baitanshoppinglist;
/*    */ import xtable.Role2grid;
/*    */ 
/*    */ 
/*    */ public class PQueryShoppingListReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int subtype;
/*    */   private int param;
/*    */   
/*    */   public PQueryShoppingListReq(long roleId, int subtype, int param)
/*    */   {
/* 27 */     this.roleId = roleId;
/* 28 */     this.subtype = subtype;
/* 29 */     this.param = param;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     if (!BaiTanManager.isSubtyperight(this.subtype))
/*    */     {
/* 37 */       String logStr = String.format("[baitan]PQueryShoppingListReq.processImp@ baitan subtype error|roleid=%d|subtype=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subtype) });
/*    */       
/* 39 */       BaiTanManager.logger.error(logStr);
/* 40 */       return false;
/*    */     }
/* 42 */     if (!BaiTanManager.isBaiTanSwitchOpenForRole(this.roleId))
/*    */     {
/* 44 */       return false;
/*    */     }
/* 46 */     int level = RoleInterface.getLevel(this.roleId);
/* 47 */     if (!BaiTanManager.isOpenForLevel(level))
/*    */     {
/* 49 */       String logStr = String.format("[baitan]PQueryShoppingListReq.processImp@ role level not open for baitan|roleid=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(level) });
/*    */       
/*    */ 
/* 52 */       BaiTanManager.logger.warn(logStr);
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     int serverlevel = ServerInterface.getCurrentServerLevel();
/* 57 */     RoleGrid roleGrid = Role2grid.get(Long.valueOf(this.roleId));
/* 58 */     if (roleGrid == null)
/*    */     {
/* 60 */       return false;
/*    */     }
/*    */     
/* 63 */     Subtype2ItemList subtype2ItemList = Role2baitanshoppinglist.get(Long.valueOf(this.roleId));
/* 64 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 65 */     if (subtype2ItemList == null)
/*    */     {
/* 67 */       subtype2ItemList = Pod.newSubtype2ItemList();
/* 68 */       Role2baitanshoppinglist.insert(Long.valueOf(this.roleId), subtype2ItemList);
/* 69 */       BaiTanManager.freshRoleShoppingListBySubtype(this.roleId, subtype2ItemList, this.subtype, level, serverlevel, now, roleGrid);
/* 70 */       roleGrid.setLastrefreshtime(now);
/*    */     }
/*    */     
/* 73 */     SQueryShopingListRes res = new SQueryShopingListRes();
/*    */     
/* 75 */     res.lastfreshtime = TimeUnit.MILLISECONDS.toSeconds(roleGrid.getLastrefreshtime());
/*    */     
/* 77 */     if ((BaiTanManager.isEquipSubtype(this.subtype)) && (this.param != 0))
/*    */     {
/* 79 */       BaiTanManager.fillEquipPageInfo(this.roleId, res.pageresult, subtype2ItemList, 1, this.subtype, this.param);
/*    */     }
/*    */     else
/*    */     {
/* 83 */       BaiTanManager.fillPageInfo(this.roleId, res.pageresult, subtype2ItemList, 1, this.subtype);
/*    */     }
/* 85 */     res.pageresult.param = this.param;
/* 86 */     OnlineManager.getInstance().send(this.roleId, res);
/* 87 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\PQueryShoppingListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */