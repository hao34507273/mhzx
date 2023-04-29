/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.LevelAward;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2levelaward
/*    */ {
/*    */   public static LevelAward get(Long key)
/*    */   {
/* 12 */     return (LevelAward)_Tables_.getInstance().role2levelaward.get(key);
/*    */   }
/*    */   
/*    */   public static LevelAward get(Long key, LevelAward value)
/*    */   {
/* 17 */     return (LevelAward)_Tables_.getInstance().role2levelaward.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LevelAward value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2levelaward.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2levelaward.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LevelAward value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2levelaward.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2levelaward.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, LevelAward> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2levelaward.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LevelAward> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2levelaward;
/*    */   }
/*    */   
/*    */   public static LevelAward select(Long key)
/*    */   {
/* 52 */     (LevelAward)getTable().select(key, new TField()
/*    */     {
/*    */       public LevelAward get(LevelAward v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Integer> selectLevelawardlist(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Integer> get(LevelAward v)
/*    */       {
/* 67 */         return v.getLevelawardlistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2levelaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */