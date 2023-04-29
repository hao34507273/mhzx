/*    */ package xtable;
/*    */ 
/*    */ import xbean.IdCounter;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Itemsubid2count
/*    */ {
/*    */   public static IdCounter get(Long key)
/*    */   {
/* 12 */     return (IdCounter)_Tables_.getInstance().itemsubid2count.get(key);
/*    */   }
/*    */   
/*    */   public static IdCounter get(Long key, IdCounter value)
/*    */   {
/* 17 */     return (IdCounter)_Tables_.getInstance().itemsubid2count.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, IdCounter value)
/*    */   {
/* 22 */     _Tables_.getInstance().itemsubid2count.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().itemsubid2count.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, IdCounter value)
/*    */   {
/* 32 */     return _Tables_.getInstance().itemsubid2count.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().itemsubid2count.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, IdCounter> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().itemsubid2count.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, IdCounter> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().itemsubid2count;
/*    */   }
/*    */   
/*    */   public static IdCounter select(Long key)
/*    */   {
/* 52 */     (IdCounter)getTable().select(key, new TField()
/*    */     {
/*    */       public IdCounter get(IdCounter v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectDropcount(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(IdCounter v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getDropcount());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectUnhitcount(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(IdCounter v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getUnhitcount());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectHistorydropcount(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(IdCounter v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getHistorydropcount());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectModifytime(Long key)
/*    */   {
/* 96 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(IdCounter v)
/*    */       {
/* :0 */         return Long.valueOf(v.getModifytime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Itemsubid2count.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */