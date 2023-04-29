/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.PropertyList;
/*    */ import xbean.WingRandomProperty;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2wingrandomproperty
/*    */ {
/*    */   public static WingRandomProperty get(Long key)
/*    */   {
/* 12 */     return (WingRandomProperty)_Tables_.getInstance().role2wingrandomproperty.get(key);
/*    */   }
/*    */   
/*    */   public static WingRandomProperty get(Long key, WingRandomProperty value)
/*    */   {
/* 17 */     return (WingRandomProperty)_Tables_.getInstance().role2wingrandomproperty.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, WingRandomProperty value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2wingrandomproperty.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2wingrandomproperty.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, WingRandomProperty value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2wingrandomproperty.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2wingrandomproperty.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, WingRandomProperty> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2wingrandomproperty.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, WingRandomProperty> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2wingrandomproperty;
/*    */   }
/*    */   
/*    */   public static WingRandomProperty select(Long key)
/*    */   {
/* 52 */     (WingRandomProperty)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public WingRandomProperty get(WingRandomProperty v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, PropertyList> selectIndex2wingproperty(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, PropertyList> get(WingRandomProperty v)
/*    */       {
/* 67 */         return v.getIndex2wingpropertyAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2wingrandomproperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */