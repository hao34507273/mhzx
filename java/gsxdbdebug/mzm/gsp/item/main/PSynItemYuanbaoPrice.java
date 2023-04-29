/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.item.SResItemYuanbaoPrice;
/*    */ 
/*    */ public class PSynItemYuanbaoPrice extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private List<Integer> itemids;
/*    */   
/*    */   public PSynItemYuanbaoPrice(long roleid, List<Integer> itemids)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.itemids = itemids;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 19 */     SResItemYuanbaoPrice resItemYuanbaoPrice = new SResItemYuanbaoPrice();
/* 20 */     for (Iterator i$ = this.itemids.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/* 21 */       resItemYuanbaoPrice.itemid2yuanbao.put(Integer.valueOf(id), Integer.valueOf(ItemInterface.getItemYuanBaoPrice(id)));
/*    */     }
/* 23 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleid, resItemYuanbaoPrice);
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PSynItemYuanbaoPrice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */