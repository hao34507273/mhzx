/*    */ package mzm.gsp.firework.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.firework.SFireworkGainPreciousItemBrd;
/*    */ import mzm.gsp.item.main.ItemReasonHandler;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class FireWorkItemHandler implements ItemReasonHandler
/*    */ {
/* 14 */   private static final FireWorkItemHandler instance = new FireWorkItemHandler();
/*    */   
/*    */   public static FireWorkItemHandler getInstance()
/*    */   {
/* 18 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public void gainPreciousItem(long roleid, Map<Integer, Integer> itemid2num)
/*    */   {
/* 24 */     SFireworkGainPreciousItemBrd brd = new SFireworkGainPreciousItemBrd();
/*    */     try
/*    */     {
/* 27 */       brd.name.setString(RoleInterface.getName(roleid), "UTF-8");
/*    */     }
/*    */     catch (UnsupportedEncodingException e) {}
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 34 */     brd.items.putAll(itemid2num);
/* 35 */     OnlineManager.getInstance().sendAll(brd);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\FireWorkItemHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */