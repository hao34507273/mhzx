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
/*    */ public class CUnderstandSkill
/*    */   extends __CUnderstandSkill__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596501;
/*    */   public int index;
/*    */   public int skillid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 29 */     return 12596501;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CUnderstandSkill() {}
/*    */   
/*    */ 
/*    */   public CUnderstandSkill(int _index_, int _skillid_)
/*    */   {
/* 39 */     this.index = _index_;
/* 40 */     this.skillid = _skillid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.index);
/* 49 */     _os_.marshal(this.skillid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.index = _os_.unmarshal_int();
/* 55 */     this.skillid = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CUnderstandSkill)) {
/* 65 */       CUnderstandSkill _o_ = (CUnderstandSkill)_o1_;
/* 66 */       if (this.index != _o_.index) return false;
/* 67 */       if (this.skillid != _o_.skillid) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.index;
/* 76 */     _h_ += this.skillid;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.index).append(",");
/* 84 */     _sb_.append(this.skillid).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CUnderstandSkill _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.index - _o_.index;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.skillid - _o_.skillid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\CUnderstandSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */