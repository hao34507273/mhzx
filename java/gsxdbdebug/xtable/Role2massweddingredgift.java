/*    */ package xtable;
/*    */ 
/*    */ import xbean.MassWeddingRedgift;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2massweddingredgift
/*    */ {
/*    */   public static MassWeddingRedgift get(Long key)
/*    */   {
/* 12 */     return (MassWeddingRedgift)_Tables_.getInstance().role2massweddingredgift.get(key);
/*    */   }
/*    */   
/*    */   public static MassWeddingRedgift get(Long key, MassWeddingRedgift value)
/*    */   {
/* 17 */     return (MassWeddingRedgift)_Tables_.getInstance().role2massweddingredgift.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MassWeddingRedgift value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2massweddingredgift.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2massweddingredgift.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MassWeddingRedgift value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2massweddingredgift.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2massweddingredgift.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, MassWeddingRedgift> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2massweddingredgift.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MassWeddingRedgift> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2massweddingredgift;
/*    */   }
/*    */   
/*    */   public static MassWeddingRedgift select(Long key)
/*    */   {
/* 52 */     (MassWeddingRedgift)getTable().select(key, new TField()
/*    */     {
/*    */       public MassWeddingRedgift get(MassWeddingRedgift v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectRedgiftcfgid(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(MassWeddingRedgift v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getRedgiftcfgid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectTaken(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(MassWeddingRedgift v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getTaken());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2massweddingredgift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */