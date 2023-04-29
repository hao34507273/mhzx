/*    */ package mzm.gsp.corps;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class CorpsMemberOtherInfo
/*    */   implements Marshal, Comparable<CorpsMemberOtherInfo>
/*    */ {
/*    */   public int multifightvalue;
/*    */   public int mfvrank;
/*    */   
/*    */   public CorpsMemberOtherInfo() {}
/*    */   
/*    */   public CorpsMemberOtherInfo(int _multifightvalue_, int _mfvrank_)
/*    */   {
/* 18 */     this.multifightvalue = _multifightvalue_;
/* 19 */     this.mfvrank = _mfvrank_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.multifightvalue);
/* 28 */     _os_.marshal(this.mfvrank);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.multifightvalue = _os_.unmarshal_int();
/* 34 */     this.mfvrank = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof CorpsMemberOtherInfo)) {
/* 41 */       CorpsMemberOtherInfo _o_ = (CorpsMemberOtherInfo)_o1_;
/* 42 */       if (this.multifightvalue != _o_.multifightvalue) return false;
/* 43 */       if (this.mfvrank != _o_.mfvrank) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.multifightvalue;
/* 52 */     _h_ += this.mfvrank;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.multifightvalue).append(",");
/* 60 */     _sb_.append(this.mfvrank).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CorpsMemberOtherInfo _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.multifightvalue - _o_.multifightvalue;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.mfvrank - _o_.mfvrank;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\CorpsMemberOtherInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */