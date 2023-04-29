/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import xbean.BoxAwardBean;
/*    */ import xtable.Boxaward;
/*    */ 
/*    */ public class PCGetOrRefuseItem extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private long awardUuid;
/*    */   private int itemid;
/*    */   private int operation;
/*    */   
/*    */   public PCGetOrRefuseItem(long roleid, long awardUuid, int itemid, int operation)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.awardUuid = awardUuid;
/* 17 */     this.itemid = itemid;
/* 18 */     this.operation = operation;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     lock(xtable.Role2properties.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 24 */     BoxAwardBean xBoxAwardBean = Boxaward.get(Long.valueOf(this.awardUuid));
/* 25 */     if (xBoxAwardBean == null) {
/* 26 */       return false;
/*    */     }
/* 28 */     return BoxAwardManager.getInstance().getOrRefuseItem(this.roleid, this.awardUuid, xBoxAwardBean, this.itemid, this.operation);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\PCGetOrRefuseItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */