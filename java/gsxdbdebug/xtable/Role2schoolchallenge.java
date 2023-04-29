/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.SchoolChallenge;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2schoolchallenge
/*    */ {
/*    */   public static SchoolChallenge get(Long key)
/*    */   {
/* 12 */     return (SchoolChallenge)_Tables_.getInstance().role2schoolchallenge.get(key);
/*    */   }
/*    */   
/*    */   public static SchoolChallenge get(Long key, SchoolChallenge value)
/*    */   {
/* 17 */     return (SchoolChallenge)_Tables_.getInstance().role2schoolchallenge.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, SchoolChallenge value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2schoolchallenge.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2schoolchallenge.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, SchoolChallenge value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2schoolchallenge.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2schoolchallenge.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, SchoolChallenge> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2schoolchallenge.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, SchoolChallenge> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2schoolchallenge;
/*    */   }
/*    */   
/*    */   public static SchoolChallenge select(Long key)
/*    */   {
/* 52 */     (SchoolChallenge)getTable().select(key, new TField()
/*    */     {
/*    */       public SchoolChallenge get(SchoolChallenge v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectCurrentring(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(SchoolChallenge v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getCurrentring());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectAwardcirclecount(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(SchoolChallenge v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getAwardcirclecount());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Integer> selectTaskids(Long key)
/*    */   {
/* 85 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Integer> get(SchoolChallenge v)
/*    */       {
/* 89 */         return v.getTaskidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2schoolchallenge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */