/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.Sysawards;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2sysaward
/*    */ {
/*    */   public static Sysawards get(Long key)
/*    */   {
/* 12 */     return (Sysawards)_Tables_.getInstance().role2sysaward.get(key);
/*    */   }
/*    */   
/*    */   public static Sysawards get(Long key, Sysawards value)
/*    */   {
/* 17 */     return (Sysawards)_Tables_.getInstance().role2sysaward.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Sysawards value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2sysaward.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2sysaward.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Sysawards value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2sysaward.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2sysaward.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Sysawards> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2sysaward.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Sysawards> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2sysaward;
/*    */   }
/*    */   
/*    */   public static Sysawards select(Long key)
/*    */   {
/* 52 */     (Sysawards)getTable().select(key, new TField()
/*    */     {
/*    */       public Sysawards get(Sysawards v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectAwardids(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(Sysawards v)
/*    */       {
/* 67 */         return v.getAwardidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2sysaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */