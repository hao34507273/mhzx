/*    */ package mzm.gsp.indiana;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class IndianaImportBean implements Marshal, Comparable<IndianaImportBean>
/*    */ {
/*    */   public IndianaErrorCode _indianaerrorcode;
/*    */   public AwardState _awardstate;
/*    */   
/*    */   public IndianaImportBean()
/*    */   {
/* 13 */     this._indianaerrorcode = new IndianaErrorCode();
/* 14 */     this._awardstate = new AwardState();
/*    */   }
/*    */   
/*    */   public IndianaImportBean(IndianaErrorCode __indianaerrorcode_, AwardState __awardstate_) {
/* 18 */     this._indianaerrorcode = __indianaerrorcode_;
/* 19 */     this._awardstate = __awardstate_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     if (!this._indianaerrorcode._validator_()) return false;
/* 24 */     if (!this._awardstate._validator_()) return false;
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this._indianaerrorcode);
/* 30 */     _os_.marshal(this._awardstate);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 35 */     this._indianaerrorcode.unmarshal(_os_);
/* 36 */     this._awardstate.unmarshal(_os_);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof IndianaImportBean)) {
/* 43 */       IndianaImportBean _o_ = (IndianaImportBean)_o1_;
/* 44 */       if (!this._indianaerrorcode.equals(_o_._indianaerrorcode)) return false;
/* 45 */       if (!this._awardstate.equals(_o_._awardstate)) return false;
/* 46 */       return true;
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 52 */     int _h_ = 0;
/* 53 */     _h_ += this._indianaerrorcode.hashCode();
/* 54 */     _h_ += this._awardstate.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this._indianaerrorcode).append(",");
/* 62 */     _sb_.append(this._awardstate).append(",");
/* 63 */     _sb_.append(")");
/* 64 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(IndianaImportBean _o_) {
/* 68 */     if (_o_ == this) return 0;
/* 69 */     int _c_ = 0;
/* 70 */     _c_ = this._indianaerrorcode.compareTo(_o_._indianaerrorcode);
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     _c_ = this._awardstate.compareTo(_o_._awardstate);
/* 73 */     if (0 != _c_) return _c_;
/* 74 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\IndianaImportBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */