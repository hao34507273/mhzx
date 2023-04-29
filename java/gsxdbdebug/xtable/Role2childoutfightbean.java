/*    */ package xtable;
/*    */ 
/*    */ import xbean.ChildrenOutFightBeans;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Role2childoutfightbean
/*    */ {
/*    */   public static ChildrenOutFightBeans get(Long key)
/*    */   {
/* 12 */     return (ChildrenOutFightBeans)_Tables_.getInstance().role2childoutfightbean.get(key);
/*    */   }
/*    */   
/*    */   public static ChildrenOutFightBeans get(Long key, ChildrenOutFightBeans value)
/*    */   {
/* 17 */     return (ChildrenOutFightBeans)_Tables_.getInstance().role2childoutfightbean.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ChildrenOutFightBeans value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2childoutfightbean.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2childoutfightbean.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ChildrenOutFightBeans value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2childoutfightbean.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2childoutfightbean.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, ChildrenOutFightBeans> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2childoutfightbean.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ChildrenOutFightBeans> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2childoutfightbean;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2childoutfightbean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */