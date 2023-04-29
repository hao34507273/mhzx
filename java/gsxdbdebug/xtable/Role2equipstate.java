/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Equipstate;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2equipstate
/*    */ {
/*    */   public static Equipstate get(Long key)
/*    */   {
/* 12 */     return (Equipstate)_Tables_.getInstance().role2equipstate.get(key);
/*    */   }
/*    */   
/*    */   public static Equipstate get(Long key, Equipstate value)
/*    */   {
/* 17 */     return (Equipstate)_Tables_.getInstance().role2equipstate.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Equipstate value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2equipstate.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2equipstate.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Equipstate value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2equipstate.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2equipstate.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Equipstate> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2equipstate.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Equipstate> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2equipstate;
/*    */   }
/*    */   
/*    */   public static Equipstate select(Long key)
/*    */   {
/* 52 */     (Equipstate)getTable().select(key, new TField()
/*    */     {
/*    */       public Equipstate get(Equipstate v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectState(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(Equipstate v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getState());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectLevel2makecount(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(Equipstate v)
/*    */       {
/* 78 */         return v.getLevel2makecountAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectEqpid2makecount(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(Equipstate v)
/*    */       {
/* 89 */         return v.getEqpid2makecountAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2equipstate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */