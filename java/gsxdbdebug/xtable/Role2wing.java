/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.Wing;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2wing
/*    */ {
/*    */   public static Wing get(Long key)
/*    */   {
/* 12 */     return (Wing)_Tables_.getInstance().role2wing.get(key);
/*    */   }
/*    */   
/*    */   public static Wing get(Long key, Wing value)
/*    */   {
/* 17 */     return (Wing)_Tables_.getInstance().role2wing.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Wing value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2wing.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2wing.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Wing value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2wing.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2wing.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Wing> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2wing.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Wing> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2wing;
/*    */   }
/*    */   
/*    */   public static Wing select(Long key)
/*    */   {
/* 52 */     (Wing)getTable().select(key, new TField()
/*    */     {
/*    */       public Wing get(Wing v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<xbean.WingInfo> selectWinglist(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<xbean.WingInfo> get(Wing v)
/*    */       {
/* 67 */         return v.getWinglistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectCurindex(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(Wing v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getCurindex());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Boolean selectIsshowwing(Long key)
/*    */   {
/* 85 */     (Boolean)getTable().select(key, new TField()
/*    */     {
/*    */       public Boolean get(Wing v)
/*    */       {
/* 89 */         return Boolean.valueOf(v.getIsshowwing());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2wing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */