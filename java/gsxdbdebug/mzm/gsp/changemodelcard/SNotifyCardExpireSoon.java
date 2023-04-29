/*    */ package mzm.gsp.changemodelcard;
/*    */ 
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
/*    */ public class SNotifyCardExpireSoon
/*    */   extends __SNotifyCardExpireSoon__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12624420;
/*    */   public static final int EXPIRE_BY_TIME = 1;
/*    */   public static final int EXPIRE_BY_PVP_COUNT = 2;
/*    */   public int notify_type;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12624420;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SNotifyCardExpireSoon() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public SNotifyCardExpireSoon(int _notify_type_)
/*    */   {
/* 39 */     this.notify_type = _notify_type_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.notify_type);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.notify_type = _os_.unmarshal_int();
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof SNotifyCardExpireSoon)) {
/* 62 */       SNotifyCardExpireSoon _o_ = (SNotifyCardExpireSoon)_o1_;
/* 63 */       if (this.notify_type != _o_.notify_type) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.notify_type;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.notify_type).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SNotifyCardExpireSoon _o_) {
/* 84 */     if (_o_ == this) return 0;
/* 85 */     int _c_ = 0;
/* 86 */     _c_ = this.notify_type - _o_.notify_type;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\SNotifyCardExpireSoon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */