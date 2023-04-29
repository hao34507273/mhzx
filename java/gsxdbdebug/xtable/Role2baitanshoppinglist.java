/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.DisplayItemList;
/*    */ import xbean.Subtype2ItemList;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2baitanshoppinglist
/*    */ {
/*    */   public static Subtype2ItemList get(Long key)
/*    */   {
/* 12 */     return (Subtype2ItemList)_Tables_.getInstance().role2baitanshoppinglist.get(key);
/*    */   }
/*    */   
/*    */   public static Subtype2ItemList get(Long key, Subtype2ItemList value)
/*    */   {
/* 17 */     return (Subtype2ItemList)_Tables_.getInstance().role2baitanshoppinglist.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Subtype2ItemList value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2baitanshoppinglist.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2baitanshoppinglist.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Subtype2ItemList value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2baitanshoppinglist.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2baitanshoppinglist.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Subtype2ItemList> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2baitanshoppinglist.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Subtype2ItemList> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2baitanshoppinglist;
/*    */   }
/*    */   
/*    */   public static Subtype2ItemList select(Long key)
/*    */   {
/* 52 */     (Subtype2ItemList)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Subtype2ItemList get(Subtype2ItemList v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, DisplayItemList> selectSub2itemlist(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, DisplayItemList> get(Subtype2ItemList v)
/*    */       {
/* 67 */         return v.getSub2itemlistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2baitanshoppinglist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */