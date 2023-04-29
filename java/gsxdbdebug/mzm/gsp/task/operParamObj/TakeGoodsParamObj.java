/*    */ package mzm.gsp.task.operParamObj;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.task.GiveoutItemBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TakeGoodsParamObj
/*    */ {
/* 11 */   private List<GiveoutItemBean> giveItemUuids = new ArrayList();
/*    */   
/*    */   public List<GiveoutItemBean> getGiveItemUuids()
/*    */   {
/* 15 */     return this.giveItemUuids;
/*    */   }
/*    */   
/*    */   public void setGiveItemUuids(List<GiveoutItemBean> giveItemUuids)
/*    */   {
/* 20 */     this.giveItemUuids = giveItemUuids;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\operParamObj\TakeGoodsParamObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */