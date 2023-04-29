/*    */ package mzm.gsp.shanghui.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.ShangHuiItem;
/*    */ import xdb.logs.Listener;
/*    */ import xdb.logs.Note;
/*    */ import xtable.Shanghui;
/*    */ 
/*    */ public class ShangHuiItemChangeListener implements Listener
/*    */ {
/*    */   public void onChanged(Object o)
/*    */   {
/* 15 */     final Long id = (Long)o;
/* 16 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception {
/* 19 */         ShangHuiItem xShangHuiItem = Shanghui.select(id);
/* 20 */         ShanghuiManager.addInSell((int)GameServerInfoManager.toLocalId(id.longValue()));
/* 21 */         ShanghuiManager.addShoppingItem(xShangHuiItem, (int)GameServerInfoManager.toLocalId(id.longValue()));
/* 22 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onRemoved(Object o) {}
/*    */   
/*    */ 
/*    */   public void onChanged(Object o, String s, Note note)
/*    */   {
/* 34 */     final Long id = (Long)o;
/* 35 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception {
/* 38 */         ShangHuiItem xShangHuiItem = Shanghui.select(id);
/* 39 */         ShanghuiManager.updateShoppingItem(xShangHuiItem, (int)GameServerInfoManager.toLocalId(id.longValue()));
/* 40 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\ShangHuiItemChangeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */