/*    */ package xtable;
/*    */ 
/*    */ import xbean.ShangHuiItem;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Shanghui
/*    */ {
/*    */   public static ShangHuiItem get(Long key)
/*    */   {
/* 12 */     return (ShangHuiItem)_Tables_.getInstance().shanghui.get(key);
/*    */   }
/*    */   
/*    */   public static ShangHuiItem get(Long key, ShangHuiItem value)
/*    */   {
/* 17 */     return (ShangHuiItem)_Tables_.getInstance().shanghui.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ShangHuiItem value)
/*    */   {
/* 22 */     _Tables_.getInstance().shanghui.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().shanghui.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ShangHuiItem value)
/*    */   {
/* 32 */     return _Tables_.getInstance().shanghui.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().shanghui.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, ShangHuiItem> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().shanghui.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ShangHuiItem> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().shanghui;
/*    */   }
/*    */   
/*    */   public static ShangHuiItem select(Long key)
/*    */   {
/* 52 */     (ShangHuiItem)getTable().select(key, new TField()
/*    */     {
/*    */       public ShangHuiItem get(ShangHuiItem v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectRiserate(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(ShangHuiItem v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getRiserate());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectOrginalprice(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(ShangHuiItem v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getOrginalprice());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Shanghui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */