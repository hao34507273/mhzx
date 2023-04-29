/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.BlessRoles;
/*    */ import xbean.MassWeddingBless;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Massweddingbless
/*    */ {
/*    */   public static MassWeddingBless get(Long key)
/*    */   {
/* 12 */     return (MassWeddingBless)_Tables_.getInstance().massweddingbless.get(key);
/*    */   }
/*    */   
/*    */   public static MassWeddingBless get(Long key, MassWeddingBless value)
/*    */   {
/* 17 */     return (MassWeddingBless)_Tables_.getInstance().massweddingbless.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MassWeddingBless value)
/*    */   {
/* 22 */     _Tables_.getInstance().massweddingbless.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().massweddingbless.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MassWeddingBless value)
/*    */   {
/* 32 */     return _Tables_.getInstance().massweddingbless.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().massweddingbless.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MassWeddingBless> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().massweddingbless.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MassWeddingBless> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().massweddingbless;
/*    */   }
/*    */   
/*    */   public static MassWeddingBless select(Long key)
/*    */   {
/* 52 */     (MassWeddingBless)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MassWeddingBless get(MassWeddingBless v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, BlessRoles> selectBlessmap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, BlessRoles> get(MassWeddingBless v)
/*    */       {
/* 67 */         return v.getBlessmapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Massweddingbless.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */