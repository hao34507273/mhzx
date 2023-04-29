/*    */ package mzm.gsp.baitan.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.baitan.SGetMoneyRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.ModMoneyResult;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Item;
/*    */ import xbean.RoleGrid;
/*    */ import xbean.ShoppingInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2grid;
/*    */ import xtable.Roleshoppinginfo;
/*    */ 
/*    */ public class PAutoGetMoneyReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PAutoGetMoneyReq(long roleId)
/*    */   {
/* 28 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if (!BaiTanManager.isRoleStateCanBaiTanBuyOrSell(this.roleId))
/*    */     {
/* 36 */       String logStr = String.format("[baitan]PAutoGetMoneyReq.processImp@role state can not baitan sell or buy|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 38 */       BaiTanManager.logger.info(logStr);
/* 39 */       return false;
/*    */     }
/* 41 */     RoleGrid roleGrid = Role2grid.get(Long.valueOf(this.roleId));
/* 42 */     if ((roleGrid == null) || (roleGrid.getShoppingid2channelid().isEmpty()))
/*    */     {
/* 44 */       return false;
/*    */     }
/* 46 */     if (!BaiTanManager.isBaiTanSwitchOpenForRole(this.roleId))
/*    */     {
/* 48 */       return false;
/*    */     }
/* 50 */     List<Long> toremove = new ArrayList();
/* 51 */     TLogArg arg = new TLogArg(LogReason.BAITAN_GET_MONEY_ADD);
/* 52 */     Set<Long> shoppingList = roleGrid.getShoppingid2channelid().keySet();
/* 53 */     Lockeys.lock(Roleshoppinginfo.getTable(), shoppingList);
/* 54 */     Iterator<Long> iterator = shoppingList.iterator();
/* 55 */     while (iterator.hasNext())
/*    */     {
/* 57 */       long shoppingid = ((Long)iterator.next()).longValue();
/*    */       
/* 59 */       ShoppingInfo gridInfo = Roleshoppinginfo.get(Long.valueOf(shoppingid));
/* 60 */       if (gridInfo != null)
/*    */       {
/*    */ 
/*    */ 
/* 64 */         int totalNum = gridInfo.getTotalnum();
/* 65 */         int itemNum = gridInfo.getItem().getNumber();
/* 66 */         int sellNum = totalNum - itemNum;
/* 67 */         int itemid = gridInfo.getItem().getCfgid();
/* 68 */         int price = gridInfo.getPrice();
/* 69 */         if (sellNum > 0)
/*    */         {
/* 71 */           int tax = BaiTanManager.computeMoney(price);
/* 72 */           long money = sellNum * tax;
/*    */           
/* 74 */           if (!RoleInterface.addSilverWithinMax(this.roleId, money, arg).isSucceed())
/*    */           {
/* 76 */             BaiTanManager.sendCommonError(this.roleId, 8);
/* 77 */             return false;
/*    */           }
/* 79 */           gridInfo.setTotalnum(itemNum);
/* 80 */           if (itemNum <= 0)
/*    */           {
/* 82 */             toremove.add(Long.valueOf(shoppingid));
/* 83 */             long channelid = ((Long)roleGrid.getShoppingid2channelid().get(Long.valueOf(shoppingid))).longValue();
/* 84 */             Roleshoppinginfo.remove(Long.valueOf(shoppingid));
/* 85 */             BaiTanManager.removeSCPI(itemid, price, channelid, shoppingid);
/*    */           }
/*    */           
/* 88 */           SGetMoneyRes res = new SGetMoneyRes();
/* 89 */           res.shoppingid = shoppingid;
/* 90 */           res.money = ((int)money);
/* 91 */           OnlineManager.getInstance().send(this.roleId, res);
/*    */         }
/*    */       } }
/* 94 */     for (Iterator i$ = toremove.iterator(); i$.hasNext();) { long shoppingid = ((Long)i$.next()).longValue();
/*    */       
/* 96 */       roleGrid.getShoppingid2channelid().remove(Long.valueOf(shoppingid));
/* 97 */       roleGrid.getNeedrecycleshoppingids().remove(Long.valueOf(shoppingid));
/*    */     }
/* 99 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\PAutoGetMoneyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */