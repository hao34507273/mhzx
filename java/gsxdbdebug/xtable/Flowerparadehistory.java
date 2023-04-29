/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.FlowerParadeHistory;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Flowerparadehistory
/*    */ {
/*    */   public static FlowerParadeHistory get(Long key)
/*    */   {
/* 12 */     return (FlowerParadeHistory)_Tables_.getInstance().flowerparadehistory.get(key);
/*    */   }
/*    */   
/*    */   public static FlowerParadeHistory get(Long key, FlowerParadeHistory value)
/*    */   {
/* 17 */     return (FlowerParadeHistory)_Tables_.getInstance().flowerparadehistory.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FlowerParadeHistory value)
/*    */   {
/* 22 */     _Tables_.getInstance().flowerparadehistory.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().flowerparadehistory.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FlowerParadeHistory value)
/*    */   {
/* 32 */     return _Tables_.getInstance().flowerparadehistory.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().flowerparadehistory.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, FlowerParadeHistory> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().flowerparadehistory.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FlowerParadeHistory> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().flowerparadehistory;
/*    */   }
/*    */   
/*    */   public static FlowerParadeHistory select(Long key)
/*    */   {
/* 52 */     (FlowerParadeHistory)getTable().select(key, new TField()
/*    */     {
/*    */       public FlowerParadeHistory get(FlowerParadeHistory v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectHistoryroles(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(FlowerParadeHistory v)
/*    */       {
/* 67 */         return v.getHistoryrolesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Integer> selectHistoryocpids(Long key)
/*    */   {
/* 74 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Integer> get(FlowerParadeHistory v)
/*    */       {
/* 78 */         return v.getHistoryocpidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Integer> selectHistorymapids(Long key)
/*    */   {
/* 85 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Integer> get(FlowerParadeHistory v)
/*    */       {
/* 89 */         return v.getHistorymapidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectParadeindex(Long key)
/*    */   {
/* 96 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(FlowerParadeHistory v)
/*    */       {
/* :0 */         return Long.valueOf(v.getParadeindex());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Flowerparadehistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */