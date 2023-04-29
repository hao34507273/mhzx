/*    */ package mzm.gsp;
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
/*    */ 
/*    */ public class SUserForbid
/*    */   extends __SUserForbid__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590090;
/*    */   public long expire_time;
/*    */   public String reason;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590090;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SUserForbid()
/*    */   {
/* 34 */     this.reason = "";
/*    */   }
/*    */   
/*    */   public SUserForbid(long _expire_time_, String _reason_) {
/* 38 */     this.expire_time = _expire_time_;
/* 39 */     this.reason = _reason_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.expire_time);
/* 48 */     _os_.marshal(this.reason, "UTF-16LE");
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.expire_time = _os_.unmarshal_long();
/* 54 */     this.reason = _os_.unmarshal_String("UTF-16LE");
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SUserForbid)) {
/* 64 */       SUserForbid _o_ = (SUserForbid)_o1_;
/* 65 */       if (this.expire_time != _o_.expire_time) return false;
/* 66 */       if (!this.reason.equals(_o_.reason)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.expire_time;
/* 75 */     _h_ += this.reason.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.expire_time).append(",");
/* 83 */     _sb_.append("T").append(this.reason.length()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\SUserForbid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */