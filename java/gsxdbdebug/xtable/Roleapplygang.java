/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.RoleApplyGang;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Roleapplygang
/*    */ {
/*    */   public static RoleApplyGang get(Long key)
/*    */   {
/* 12 */     return (RoleApplyGang)_Tables_.getInstance().roleapplygang.get(key);
/*    */   }
/*    */   
/*    */   public static RoleApplyGang get(Long key, RoleApplyGang value)
/*    */   {
/* 17 */     return (RoleApplyGang)_Tables_.getInstance().roleapplygang.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleApplyGang value)
/*    */   {
/* 22 */     _Tables_.getInstance().roleapplygang.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().roleapplygang.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleApplyGang value)
/*    */   {
/* 32 */     return _Tables_.getInstance().roleapplygang.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().roleapplygang.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleApplyGang> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().roleapplygang.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleApplyGang> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().roleapplygang;
/*    */   }
/*    */   
/*    */   public static RoleApplyGang select(Long key)
/*    */   {
/* 52 */     (RoleApplyGang)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleApplyGang get(RoleApplyGang v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectGangs(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(RoleApplyGang v)
/*    */       {
/* 67 */         return v.getGangsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Roleapplygang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */