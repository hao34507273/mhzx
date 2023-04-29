/*    */ package mzm.gsp.market;
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
/*    */ public class SConditionTimeOutRes
/*    */   extends __SConditionTimeOutRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601444;
/*    */   public int subid;
/*    */   public int index;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12601444;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SConditionTimeOutRes() {}
/*    */   
/*    */ 
/*    */   public SConditionTimeOutRes(int _subid_, int _index_)
/*    */   {
/* 35 */     this.subid = _subid_;
/* 36 */     this.index = _index_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.subid);
/* 45 */     _os_.marshal(this.index);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.subid = _os_.unmarshal_int();
/* 51 */     this.index = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SConditionTimeOutRes)) {
/* 61 */       SConditionTimeOutRes _o_ = (SConditionTimeOutRes)_o1_;
/* 62 */       if (this.subid != _o_.subid) return false;
/* 63 */       if (this.index != _o_.index) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.subid;
/* 72 */     _h_ += this.index;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.subid).append(",");
/* 80 */     _sb_.append(this.index).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SConditionTimeOutRes _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.subid - _o_.subid;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.index - _o_.index;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SConditionTimeOutRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */