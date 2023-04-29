/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.AllBanGraphBean;
/*    */ import xbean.BanGraphBean;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Bangraph
/*    */ {
/*    */   public static AllBanGraphBean get(Long key)
/*    */   {
/* 12 */     return (AllBanGraphBean)_Tables_.getInstance().bangraph.get(key);
/*    */   }
/*    */   
/*    */   public static AllBanGraphBean get(Long key, AllBanGraphBean value)
/*    */   {
/* 17 */     return (AllBanGraphBean)_Tables_.getInstance().bangraph.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, AllBanGraphBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().bangraph.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().bangraph.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, AllBanGraphBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().bangraph.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().bangraph.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, AllBanGraphBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().bangraph.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, AllBanGraphBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().bangraph;
/*    */   }
/*    */   
/*    */   public static AllBanGraphBean select(Long key)
/*    */   {
/* 52 */     (AllBanGraphBean)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public AllBanGraphBean get(AllBanGraphBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, BanGraphBean> selectBangraphs(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, BanGraphBean> get(AllBanGraphBean v)
/*    */       {
/* 67 */         return v.getBangraphsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Bangraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */