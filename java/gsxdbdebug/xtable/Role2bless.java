/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Bless;
/*    */ import xbean.BlessInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2bless
/*    */ {
/*    */   public static Bless get(Long key)
/*    */   {
/* 12 */     return (Bless)_Tables_.getInstance().role2bless.get(key);
/*    */   }
/*    */   
/*    */   public static Bless get(Long key, Bless value)
/*    */   {
/* 17 */     return (Bless)_Tables_.getInstance().role2bless.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Bless value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2bless.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2bless.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Bless value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2bless.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2bless.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Bless> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2bless.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Bless> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2bless;
/*    */   }
/*    */   
/*    */   public static Bless select(Long key)
/*    */   {
/* 52 */     (Bless)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Bless get(Bless v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, BlessInfo> selectBless_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, BlessInfo> get(Bless v)
/*    */       {
/* 67 */         return v.getBless_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2bless.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */