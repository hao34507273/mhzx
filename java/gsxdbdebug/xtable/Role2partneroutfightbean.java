/*    */ package xtable;
/*    */ 
/*    */ import xbean.Role2PartnerBean;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Role2partneroutfightbean
/*    */ {
/*    */   public static Role2PartnerBean get(Long key)
/*    */   {
/* 12 */     return (Role2PartnerBean)_Tables_.getInstance().role2partneroutfightbean.get(key);
/*    */   }
/*    */   
/*    */   public static Role2PartnerBean get(Long key, Role2PartnerBean value)
/*    */   {
/* 17 */     return (Role2PartnerBean)_Tables_.getInstance().role2partneroutfightbean.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Role2PartnerBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2partneroutfightbean.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2partneroutfightbean.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Role2PartnerBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2partneroutfightbean.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2partneroutfightbean.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, Role2PartnerBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2partneroutfightbean.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Role2PartnerBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2partneroutfightbean;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2partneroutfightbean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */