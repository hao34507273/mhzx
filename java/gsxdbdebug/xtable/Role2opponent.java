/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.Opponent;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2opponent
/*    */ {
/*    */   public static Opponent get(Long key)
/*    */   {
/* 12 */     return (Opponent)_Tables_.getInstance().role2opponent.get(key);
/*    */   }
/*    */   
/*    */   public static Opponent get(Long key, Opponent value)
/*    */   {
/* 17 */     return (Opponent)_Tables_.getInstance().role2opponent.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Opponent value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2opponent.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2opponent.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Opponent value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2opponent.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2opponent.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Opponent> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2opponent.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Opponent> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2opponent;
/*    */   }
/*    */   
/*    */   public static Opponent select(Long key)
/*    */   {
/* 52 */     (Opponent)getTable().select(key, new TField()
/*    */     {
/*    */       public Opponent get(Opponent v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectLastfreshtime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(Opponent v)
/*    */       {
/* 67 */         return Long.valueOf(v.getLastfreshtime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectAutofreshtime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(Opponent v)
/*    */       {
/* 78 */         return Long.valueOf(v.getAutofreshtime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectOpponentroleids(Long key)
/*    */   {
/* 85 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(Opponent v)
/*    */       {
/* 89 */         return v.getOpponentroleidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2opponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */