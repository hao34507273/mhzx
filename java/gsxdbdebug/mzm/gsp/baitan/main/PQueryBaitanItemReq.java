/*    */ package mzm.gsp.baitan.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.baitan.SQueryBaitanItemRes;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.DisplayItemList;
/*    */ import xbean.RoleGrid;
/*    */ import xbean.Subtype2ItemList;
/*    */ 
/*    */ public class PQueryBaitanItemReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int pageindex;
/*    */   private int subtype;
/*    */   private int param;
/*    */   
/*    */   public PQueryBaitanItemReq(long roleId, int pageindex, int subtype, int param)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.pageindex = pageindex;
/* 21 */     this.subtype = subtype;
/* 22 */     this.param = param;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (this.pageindex <= 0)
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     if (!BaiTanManager.isSubtyperight(this.subtype))
/*    */     {
/* 34 */       String logStr = String.format("[baitan]PQueryBaitanItemReq.processImp@ baitan subtype error|roleid=%d|subtype=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subtype) });
/*    */       
/* 36 */       BaiTanManager.logger.error(logStr);
/* 37 */       return false;
/*    */     }
/* 39 */     if (!BaiTanManager.isBaiTanSwitchOpenForRole(this.roleId))
/*    */     {
/* 41 */       return false;
/*    */     }
/* 43 */     int level = mzm.gsp.role.main.RoleInterface.getLevel(this.roleId);
/* 44 */     if (!BaiTanManager.isOpenForLevel(level))
/*    */     {
/* 46 */       String logStr = String.format("[baitan]PQueryBaitanItemReq.processImp@ role level not open for baitan|roleid=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(level) });
/*    */       
/* 48 */       BaiTanManager.logger.warn(logStr);
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     int serverlevel = mzm.gsp.server.main.ServerInterface.getCurrentServerLevel();
/* 53 */     RoleGrid roleGrid = xtable.Role2grid.get(Long.valueOf(this.roleId));
/* 54 */     if (roleGrid == null)
/*    */     {
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     Subtype2ItemList subtype2ItemList = xtable.Role2baitanshoppinglist.get(Long.valueOf(this.roleId));
/*    */     
/* 61 */     if (subtype2ItemList == null)
/*    */     {
/* 63 */       return false;
/*    */     }
/*    */     
/* 66 */     if ((subtype2ItemList.getSub2itemlist().get(Integer.valueOf(this.subtype)) == null) || (roleGrid.getLastrefreshtime() != ((DisplayItemList)subtype2ItemList.getSub2itemlist().get(Integer.valueOf(this.subtype))).getFreshtime()))
/*    */     {
/*    */ 
/* 69 */       BaiTanManager.freshRoleShoppingListBySubtype(this.roleId, subtype2ItemList, this.subtype, level, serverlevel, roleGrid.getLastrefreshtime(), roleGrid);
/*    */     }
/*    */     
/* 72 */     SQueryBaitanItemRes res = new SQueryBaitanItemRes();
/*    */     
/* 74 */     if ((BaiTanManager.isEquipSubtype(this.subtype)) && (this.param != 0))
/*    */     {
/* 76 */       BaiTanManager.fillEquipPageInfo(this.roleId, res.pageresult, subtype2ItemList, this.pageindex, this.subtype, this.param);
/*    */     }
/*    */     else
/*    */     {
/* 80 */       BaiTanManager.fillPageInfo(this.roleId, res.pageresult, subtype2ItemList, this.pageindex, this.subtype);
/*    */     }
/* 82 */     res.pageresult.param = this.param;
/* 83 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleId, res);
/* 84 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\PQueryBaitanItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */