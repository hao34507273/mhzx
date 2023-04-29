/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.MailInfo;
/*    */ import xbean.MailMapBean;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2mail
/*    */ {
/*    */   public static MailMapBean get(Long key)
/*    */   {
/* 12 */     return (MailMapBean)_Tables_.getInstance().role2mail.get(key);
/*    */   }
/*    */   
/*    */   public static MailMapBean get(Long key, MailMapBean value)
/*    */   {
/* 17 */     return (MailMapBean)_Tables_.getInstance().role2mail.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MailMapBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2mail.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2mail.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MailMapBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2mail.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2mail.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MailMapBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2mail.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MailMapBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2mail;
/*    */   }
/*    */   
/*    */   public static MailMapBean select(Long key)
/*    */   {
/* 52 */     (MailMapBean)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MailMapBean get(MailMapBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, MailInfo> selectMailinfomap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, MailInfo> get(MailMapBean v)
/*    */       {
/* 67 */         return v.getMailinfomapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectNextid(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Integer get(MailMapBean v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getNextid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2mail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */