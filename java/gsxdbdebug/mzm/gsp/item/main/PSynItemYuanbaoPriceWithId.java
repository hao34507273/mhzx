/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.item.SResItemYuanbaoPriceWithId;
/*    */ 
/*    */ public class PSynItemYuanbaoPriceWithId extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private List<Integer> itemids;
/*    */   private int id;
/*    */   
/*    */   public PSynItemYuanbaoPriceWithId(long roleid, List<Integer> itemids, int id)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.itemids = itemids;
/* 17 */     this.id = id;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 21 */     SResItemYuanbaoPriceWithId resItemYuanbaoPrice = new SResItemYuanbaoPriceWithId();
/* 22 */     for (Iterator i$ = this.itemids.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/* 23 */       resItemYuanbaoPrice.itemid2yuanbao.put(Integer.valueOf(id), Integer.valueOf(ItemInterface.getItemYuanBaoPrice(id)));
/*    */     }
/* 25 */     resItemYuanbaoPrice.uid = this.id;
/* 26 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleid, resItemYuanbaoPrice);
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PSynItemYuanbaoPriceWithId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */