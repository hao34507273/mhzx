/*    */ package xtable;
/*    */ 
/*    */ import xbean.CorpsMember;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2corps
/*    */ {
/*    */   public static CorpsMember get(Long key)
/*    */   {
/* 12 */     return (CorpsMember)_Tables_.getInstance().role2corps.get(key);
/*    */   }
/*    */   
/*    */   public static CorpsMember get(Long key, CorpsMember value)
/*    */   {
/* 17 */     return (CorpsMember)_Tables_.getInstance().role2corps.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CorpsMember value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2corps.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2corps.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CorpsMember value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2corps.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2corps.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, CorpsMember> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2corps.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CorpsMember> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2corps;
/*    */   }
/*    */   
/*    */   public static CorpsMember select(Long key)
/*    */   {
/* 52 */     (CorpsMember)getTable().select(key, new TField()
/*    */     {
/*    */       public CorpsMember get(CorpsMember v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectCorpsid(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(CorpsMember v)
/*    */       {
/* 67 */         return Long.valueOf(v.getCorpsid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectJointime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(CorpsMember v)
/*    */       {
/* 78 */         return Long.valueOf(v.getJointime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectDuty(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(CorpsMember v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getDuty());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2corps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */