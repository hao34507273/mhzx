/*    */ package mzm.gsp.wing;
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
/*    */ 
/*    */ 
/*    */ public class CReplaceMainSkill
/*    */   extends __CReplaceMainSkill__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596521;
/*    */   public int index;
/*    */   public int skillindex;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 29 */     return 12596521;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CReplaceMainSkill() {}
/*    */   
/*    */ 
/*    */   public CReplaceMainSkill(int _index_, int _skillindex_)
/*    */   {
/* 39 */     this.index = _index_;
/* 40 */     this.skillindex = _skillindex_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.index);
/* 49 */     _os_.marshal(this.skillindex);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.index = _os_.unmarshal_int();
/* 55 */     this.skillindex = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CReplaceMainSkill)) {
/* 65 */       CReplaceMainSkill _o_ = (CReplaceMainSkill)_o1_;
/* 66 */       if (this.index != _o_.index) return false;
/* 67 */       if (this.skillindex != _o_.skillindex) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.index;
/* 76 */     _h_ += this.skillindex;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.index).append(",");
/* 84 */     _sb_.append(this.skillindex).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CReplaceMainSkill _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.index - _o_.index;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.skillindex - _o_.skillindex;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\CReplaceMainSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */