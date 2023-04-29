/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.Openserver;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2openserver
/*    */ {
/*    */   public static Openserver get(Long key)
/*    */   {
/* 12 */     return (Openserver)_Tables_.getInstance().role2openserver.get(key);
/*    */   }
/*    */   
/*    */   public static Openserver get(Long key, Openserver value)
/*    */   {
/* 17 */     return (Openserver)_Tables_.getInstance().role2openserver.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Openserver value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2openserver.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2openserver.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Openserver value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2openserver.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2openserver.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Openserver> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2openserver.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Openserver> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2openserver;
/*    */   }
/*    */   
/*    */   public static Openserver select(Long key)
/*    */   {
/* 52 */     (Openserver)getTable().select(key, new TField()
/*    */     {
/*    */       public Openserver get(Openserver v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Integer> selectAwardeddays(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Integer> get(Openserver v)
/*    */       {
/* 67 */         return v.getAwardeddaysAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSigntime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(Openserver v)
/*    */       {
/* 78 */         return Long.valueOf(v.getSigntime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2openserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */