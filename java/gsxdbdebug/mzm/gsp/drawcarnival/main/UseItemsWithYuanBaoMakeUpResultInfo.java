/*   */ package mzm.gsp.drawcarnival.main;
/*   */ 
/*   */ import java.util.HashMap;
/*   */ import java.util.Map;
/*   */ 
/*   */ public class UseItemsWithYuanBaoMakeUpResultInfo
/*   */ {
/* 8 */   public final Map<Integer, Integer> itemId2countToCost = new HashMap();
/*   */   public int yuanBaoSupplyItemCount;
/*   */   public int yuanBaoToCost;
/*   */   public static final int SUCCESS = 1;
/*   */   public static final int CUT_YUAN_BAO_FAIL = 2;
/*   */   public static final int REMOVE_ITEM_FAIL = 3;
/*   */   public static final int PARAM_INVALID = 4;
/*   */   public int result;
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\UseItemsWithYuanBaoMakeUpResultInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */