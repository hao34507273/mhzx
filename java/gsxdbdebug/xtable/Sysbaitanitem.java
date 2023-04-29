/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.SysSellItem;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Sysbaitanitem
/*    */ {
/*    */   public static SysSellItem get(Long key)
/*    */   {
/* 12 */     return (SysSellItem)_Tables_.getInstance().sysbaitanitem.get(key);
/*    */   }
/*    */   
/*    */   public static SysSellItem get(Long key, SysSellItem value)
/*    */   {
/* 17 */     return (SysSellItem)_Tables_.getInstance().sysbaitanitem.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, SysSellItem value)
/*    */   {
/* 22 */     _Tables_.getInstance().sysbaitanitem.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().sysbaitanitem.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, SysSellItem value)
/*    */   {
/* 32 */     return _Tables_.getInstance().sysbaitanitem.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().sysbaitanitem.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, SysSellItem> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().sysbaitanitem.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, SysSellItem> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().sysbaitanitem;
/*    */   }
/*    */   
/*    */   public static SysSellItem select(Long key)
/*    */   {
/* 52 */     (SysSellItem)getTable().select(key, new TField()
/*    */     {
/*    */       public SysSellItem get(SysSellItem v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectPrice2num(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(SysSellItem v)
/*    */       {
/* 67 */         return v.getPrice2numAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Sysbaitanitem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */