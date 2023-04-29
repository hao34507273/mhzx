/*    */ package xtable;
/*    */ 
/*    */ import xbean.FactionPVE;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Factionpve
/*    */ {
/*    */   public static FactionPVE get(Long key)
/*    */   {
/* 12 */     return (FactionPVE)_Tables_.getInstance().factionpve.get(key);
/*    */   }
/*    */   
/*    */   public static FactionPVE get(Long key, FactionPVE value)
/*    */   {
/* 17 */     return (FactionPVE)_Tables_.getInstance().factionpve.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FactionPVE value)
/*    */   {
/* 22 */     _Tables_.getInstance().factionpve.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().factionpve.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FactionPVE value)
/*    */   {
/* 32 */     return _Tables_.getInstance().factionpve.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().factionpve.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, FactionPVE> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().factionpve.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FactionPVE> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().factionpve;
/*    */   }
/*    */   
/*    */   public static FactionPVE select(Long key)
/*    */   {
/* 52 */     (FactionPVE)getTable().select(key, new TField()
/*    */     {
/*    */       public FactionPVE get(FactionPVE v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectActivate_times(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(FactionPVE v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getActivate_times());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectSet_times(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(FactionPVE v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getSet_times());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectStart_timestamp(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(FactionPVE v)
/*    */       {
/* 89 */         return Long.valueOf(v.getStart_timestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Factionpve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */