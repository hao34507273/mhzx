/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.Active;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2active
/*    */ {
/*    */   public static Active get(Long key)
/*    */   {
/* 12 */     return (Active)_Tables_.getInstance().role2active.get(key);
/*    */   }
/*    */   
/*    */   public static Active get(Long key, Active value)
/*    */   {
/* 17 */     return (Active)_Tables_.getInstance().role2active.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Active value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2active.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2active.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Active value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2active.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2active.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Active> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2active.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Active> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2active;
/*    */   }
/*    */   
/*    */   public static Active select(Long key)
/*    */   {
/* 52 */     (Active)getTable().select(key, new TField()
/*    */     {
/*    */       public Active get(Active v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.Map<Integer, Integer> selectActivitymap(Long key)
/*    */   {
/* 63 */     (java.util.Map)getTable().select(key, new TField()
/*    */     {
/*    */       public java.util.Map<Integer, Integer> get(Active v)
/*    */       {
/* 67 */         return v.getActivitymapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Integer> selectAwardcfgids(Long key)
/*    */   {
/* 74 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Integer> get(Active v)
/*    */       {
/* 78 */         return v.getAwardcfgidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectResettime(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(Active v)
/*    */       {
/* 89 */         return Long.valueOf(v.getResettime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Integer> selectAward_index_id_set(Long key)
/*    */   {
/* 96 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Integer> get(Active v)
/*    */       {
/* :0 */         return v.getAward_index_id_setAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2active.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */