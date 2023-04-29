/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.ReceiveInvitation;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2receiveinvitation
/*    */ {
/*    */   public static ReceiveInvitation get(Long key)
/*    */   {
/* 12 */     return (ReceiveInvitation)_Tables_.getInstance().role2receiveinvitation.get(key);
/*    */   }
/*    */   
/*    */   public static ReceiveInvitation get(Long key, ReceiveInvitation value)
/*    */   {
/* 17 */     return (ReceiveInvitation)_Tables_.getInstance().role2receiveinvitation.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ReceiveInvitation value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2receiveinvitation.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2receiveinvitation.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ReceiveInvitation value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2receiveinvitation.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2receiveinvitation.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ReceiveInvitation> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2receiveinvitation.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ReceiveInvitation> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2receiveinvitation;
/*    */   }
/*    */   
/*    */   public static ReceiveInvitation select(Long key)
/*    */   {
/* 52 */     (ReceiveInvitation)getTable().select(key, new TField()
/*    */     {
/*    */       public ReceiveInvitation get(ReceiveInvitation v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectInvitations(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(ReceiveInvitation v)
/*    */       {
/* 67 */         return v.getInvitationsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2receiveinvitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */