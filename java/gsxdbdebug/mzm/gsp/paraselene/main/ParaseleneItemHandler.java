/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.item.main.ItemReasonHandler;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.paraselene.SGainPreciousItemBrd;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class ParaseleneItemHandler implements ItemReasonHandler
/*    */ {
/* 12 */   private static final ParaseleneItemHandler instance = new ParaseleneItemHandler();
/*    */   
/*    */   public static ParaseleneItemHandler getInstance()
/*    */   {
/* 16 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public void gainPreciousItem(long roleid, Map<Integer, Integer> itemid2num)
/*    */   {
/* 22 */     SGainPreciousItemBrd brd = new SGainPreciousItemBrd();
/* 23 */     brd.name = RoleInterface.getName(roleid);
/*    */     
/* 25 */     brd.items.putAll(itemid2num);
/* 26 */     OnlineManager.getInstance().sendAll(brd);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\ParaseleneItemHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */