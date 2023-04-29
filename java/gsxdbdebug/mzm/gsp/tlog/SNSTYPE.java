/*    */ package mzm.gsp.tlog;
/*    */ 
/*    */ import java.util.Set;
/*    */ 
/*    */ public enum SNSTYPE
/*    */ {
/*  7 */   SNSTYPE_SHOWOFF(0), 
/*  8 */   SNSTYPE_INVITE(1), 
/*  9 */   SNSTYPE_SENDHEART(2), 
/* 10 */   SNSTYPE_RECEIVEHEART(3), 
/* 11 */   SNSTYPE_SENDEMAIL(4), 
/* 12 */   SNSTYPE_RECEIVEEMAIL(5), 
/* 13 */   SNSTYPE_SHARE(6), 
/* 14 */   SNSTYPE_OTHER(7), 
/*    */   
/* 16 */   SNSTYPE_CREATE_SWORN(8), 
/* 17 */   SNSTYPE_CREATE_SWORN_JOIN(9), 
/* 18 */   SNSTYPE_SWORN_KICKOUT_VOTE(10), 
/* 19 */   SNSTYPE_SWORN_BEKICKOUT(11), 
/* 20 */   SNSTYPE_SWORN_NEWMEMBER_INVITE(12), 
/* 21 */   SNSTYPE_SWORN_NEWMEMBER_BEINVITE(13), 
/* 22 */   SNSTYPE_SWORN_NEWMEMBER_ACCEPT(14), 
/* 23 */   SNSTYPE_SWORN_NEWMEMBER_REJECT(15), 
/*    */   
/* 25 */   SNSTYPE_END(99999);
/*    */   
/*    */   public static void checkValue()
/*    */   {
/* 29 */     Set<Integer> values = new java.util.HashSet();
/* 30 */     for (SNSTYPE type : values())
/*    */     {
/* 32 */       value2SNSTYPE.put(Integer.valueOf(type.value), type);
/*    */       
/* 34 */       if (!values.add(Integer.valueOf(type.value)))
/* 35 */         throw new RuntimeException(String.format("SNSTYPE中定义的常量重复,name=%s,value=%d", new Object[] { type.name(), Integer.valueOf(type.value) }));
/*    */     } }
/*    */   
/* 38 */   private static final java.util.Map<Integer, SNSTYPE> value2SNSTYPE = new java.util.HashMap();
/*    */   public final int value;
/*    */   
/* 41 */   private SNSTYPE(int value) { this.value = value; }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\tlog\SNSTYPE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */