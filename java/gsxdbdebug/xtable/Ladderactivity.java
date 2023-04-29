/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.LadderActivity;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Ladderactivity
/*    */ {
/*    */   public static LadderActivity get(Long key)
/*    */   {
/* 12 */     return (LadderActivity)_Tables_.getInstance().ladderactivity.get(key);
/*    */   }
/*    */   
/*    */   public static LadderActivity get(Long key, LadderActivity value)
/*    */   {
/* 17 */     return (LadderActivity)_Tables_.getInstance().ladderactivity.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LadderActivity value)
/*    */   {
/* 22 */     _Tables_.getInstance().ladderactivity.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().ladderactivity.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LadderActivity value)
/*    */   {
/* 32 */     return _Tables_.getInstance().ladderactivity.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().ladderactivity.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, LadderActivity> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().ladderactivity.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LadderActivity> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().ladderactivity;
/*    */   }
/*    */   
/*    */   public static LadderActivity select(Long key)
/*    */   {
/* 52 */     (LadderActivity)getTable().select(key, new TField()
/*    */     {
/*    */       public LadderActivity get(LadderActivity v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectRoleids(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(LadderActivity v)
/*    */       {
/* 67 */         return v.getRoleidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Ladderactivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */