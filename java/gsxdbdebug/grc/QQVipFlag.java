/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QQVipFlag
/*    */   implements Marshal, Comparable<QQVipFlag>
/*    */ {
/*    */   public static final int VIP_NORMAL = 1;
/*    */   public static final int VIP_QQ_LEVEL = 2;
/*    */   public static final int VIP_BLUE = 4;
/*    */   public static final int VIP_RED = 8;
/*    */   public static final int VIP_SUPER = 16;
/*    */   public static final int VIP_XINYUE = 64;
/*    */   public static final int VIP_YELLOW = 128;
/*    */   public static final int VIP_ANIMIC = 256;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof QQVipFlag)) {
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 61 */     int _h_ = 0;
/* 62 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 66 */     StringBuilder _sb_ = new StringBuilder();
/* 67 */     _sb_.append("(");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(QQVipFlag _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\QQVipFlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */