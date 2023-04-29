/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.VisibleMonsterFight;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2monsterfight
/*    */ {
/*    */   public static VisibleMonsterFight get(Long key)
/*    */   {
/* 12 */     return (VisibleMonsterFight)_Tables_.getInstance().role2monsterfight.get(key);
/*    */   }
/*    */   
/*    */   public static VisibleMonsterFight get(Long key, VisibleMonsterFight value)
/*    */   {
/* 17 */     return (VisibleMonsterFight)_Tables_.getInstance().role2monsterfight.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, VisibleMonsterFight value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2monsterfight.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2monsterfight.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, VisibleMonsterFight value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2monsterfight.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2monsterfight.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, VisibleMonsterFight> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2monsterfight.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, VisibleMonsterFight> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2monsterfight;
/*    */   }
/*    */   
/*    */   public static VisibleMonsterFight select(Long key)
/*    */   {
/* 52 */     (VisibleMonsterFight)getTable().select(key, new TField()
/*    */     {
/*    */       public VisibleMonsterFight get(VisibleMonsterFight v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectCountermap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(VisibleMonsterFight v)
/*    */       {
/* 67 */         return v.getCountermapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2monsterfight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */