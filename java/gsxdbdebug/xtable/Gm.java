/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.GMInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Gm
/*    */ {
/*    */   public static GMInfo get(String key)
/*    */   {
/* 12 */     return (GMInfo)_Tables_.getInstance().gm.get(key);
/*    */   }
/*    */   
/*    */   public static GMInfo get(String key, GMInfo value)
/*    */   {
/* 17 */     return (GMInfo)_Tables_.getInstance().gm.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(String key, GMInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().gm.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(String key)
/*    */   {
/* 27 */     _Tables_.getInstance().gm.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(String key, GMInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().gm.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(String key)
/*    */   {
/* 37 */     return _Tables_.getInstance().gm.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<String, GMInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().gm.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<String, GMInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().gm;
/*    */   }
/*    */   
/*    */   public static GMInfo select(String key)
/*    */   {
/* 52 */     (GMInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public GMInfo get(GMInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Integer> selectSecurity(String key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Integer> get(GMInfo v)
/*    */       {
/* 67 */         return v.getSecurityAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Gm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */