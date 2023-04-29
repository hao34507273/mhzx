/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.MultiFightValueRank;
/*    */ import xbean.RoleMultiFightValueBean;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Multifightvaluerank
/*    */ {
/*    */   public static MultiFightValueRank get(Long key)
/*    */   {
/* 12 */     return (MultiFightValueRank)_Tables_.getInstance().multifightvaluerank.get(key);
/*    */   }
/*    */   
/*    */   public static MultiFightValueRank get(Long key, MultiFightValueRank value)
/*    */   {
/* 17 */     return (MultiFightValueRank)_Tables_.getInstance().multifightvaluerank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MultiFightValueRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().multifightvaluerank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().multifightvaluerank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MultiFightValueRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().multifightvaluerank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().multifightvaluerank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MultiFightValueRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().multifightvaluerank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MultiFightValueRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().multifightvaluerank;
/*    */   }
/*    */   
/*    */   public static MultiFightValueRank select(Long key)
/*    */   {
/* 52 */     (MultiFightValueRank)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MultiFightValueRank get(MultiFightValueRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<RoleMultiFightValueBean> selectRolerankdatas(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<RoleMultiFightValueBean> get(MultiFightValueRank v)
/*    */       {
/* 67 */         return v.getRolerankdatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Multifightvaluerank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */