/*    */ package mzm.gsp.friend;
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
/*    */ public class SUpdateRelationValue
/*    */   extends __SUpdateRelationValue__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587010;
/*    */   public long friendid;
/*    */   public int relationvalue;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12587010;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SUpdateRelationValue() {}
/*    */   
/*    */ 
/*    */   public SUpdateRelationValue(long _friendid_, int _relationvalue_)
/*    */   {
/* 35 */     this.friendid = _friendid_;
/* 36 */     this.relationvalue = _relationvalue_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.friendid);
/* 45 */     _os_.marshal(this.relationvalue);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.friendid = _os_.unmarshal_long();
/* 51 */     this.relationvalue = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SUpdateRelationValue)) {
/* 61 */       SUpdateRelationValue _o_ = (SUpdateRelationValue)_o1_;
/* 62 */       if (this.friendid != _o_.friendid) return false;
/* 63 */       if (this.relationvalue != _o_.relationvalue) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += (int)this.friendid;
/* 72 */     _h_ += this.relationvalue;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.friendid).append(",");
/* 80 */     _sb_.append(this.relationvalue).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUpdateRelationValue _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = Long.signum(this.friendid - _o_.friendid);
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.relationvalue - _o_.relationvalue;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\SUpdateRelationValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */