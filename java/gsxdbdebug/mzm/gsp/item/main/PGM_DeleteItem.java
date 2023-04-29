/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.qingfu.main.CostType;
/*    */ import mzm.gsp.qingfu.main.PresentType;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import xbean.Item;
/*    */ 
/*    */ public class PGM_DeleteItem extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int bagid;
/*    */   private final int itemid;
/*    */   private final int num;
/*    */   private final int yuanbao;
/*    */   
/*    */   public PGM_DeleteItem(long roleid, int bagid, int itemid, int num, int yuanbao)
/*    */   {
/* 26 */     this.roleid = roleid;
/* 27 */     this.bagid = bagid;
/* 28 */     this.itemid = itemid;
/* 29 */     this.num = num;
/* 30 */     this.yuanbao = yuanbao;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 35 */     String userid = RoleInterface.getUserId(this.roleid);
/* 36 */     TLogArg tLogArg = new TLogArg(LogReason.GM_ADD);
/* 37 */     QingfuInterface.costYuanbao(userid, this.roleid, 1, CostType.CostBindFirstTest, tLogArg);
/* 38 */     RoleItemBag bag = ItemManager.getBag(this.roleid, this.bagid);
/* 39 */     Map<Integer, Item> items = bag.getItems();
/* 40 */     int count = 0;
/* 41 */     List<Integer> del = new ArrayList();
/* 42 */     for (Map.Entry<Integer, Item> itemEntry : items.entrySet()) {
/* 43 */       Item item = (Item)itemEntry.getValue();
/* 44 */       if (item.getCfgid() == this.itemid) {
/* 45 */         int itemNumber = item.getNumber();
/* 46 */         int d = this.num - count;
/* 47 */         if (d <= 0) break;
/* 48 */         if (d >= itemNumber) {
/* 49 */           del.add(itemEntry.getKey());
/* 50 */           count += itemNumber;
/*    */         } else {
/* 52 */           Set<Long> uuidSet = item.getUuid();
/* 53 */           Long[] uuids = (Long[])uuidSet.toArray(new Long[0]);
/* 54 */           for (int i = 0; i < d; i++) {
/* 55 */             uuidSet.remove(uuids[i]);
/*    */           }
/* 57 */           item.setNumber(itemNumber - d);
/* 58 */           count += d;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 65 */     for (Integer i : del) {
/* 66 */       items.remove(i);
/*    */     }
/* 68 */     count = count * this.yuanbao + 1;
/* 69 */     QingfuInterface.presentYuanbao(userid, this.roleid, count, PresentType.PRESENT_BIND_GM, tLogArg);
/* 70 */     QingfuInterface.presentInnerSaveAmt(userid, count);
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_DeleteItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */