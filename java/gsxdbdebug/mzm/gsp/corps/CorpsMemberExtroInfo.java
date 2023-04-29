/*    */ package mzm.gsp.corps;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.pubdata.ModelInfo;
/*    */ 
/*    */ public class CorpsMemberExtroInfo implements Marshal
/*    */ {
/*    */   public int multifightvalue;
/*    */   public ModelInfo model;
/*    */   
/*    */   public CorpsMemberExtroInfo()
/*    */   {
/* 15 */     this.model = new ModelInfo();
/*    */   }
/*    */   
/*    */   public CorpsMemberExtroInfo(int _multifightvalue_, ModelInfo _model_) {
/* 19 */     this.multifightvalue = _multifightvalue_;
/* 20 */     this.model = _model_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     if (!this.model._validator_()) return false;
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.multifightvalue);
/* 30 */     _os_.marshal(this.model);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 35 */     this.multifightvalue = _os_.unmarshal_int();
/* 36 */     this.model.unmarshal(_os_);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof CorpsMemberExtroInfo)) {
/* 43 */       CorpsMemberExtroInfo _o_ = (CorpsMemberExtroInfo)_o1_;
/* 44 */       if (this.multifightvalue != _o_.multifightvalue) return false;
/* 45 */       if (!this.model.equals(_o_.model)) return false;
/* 46 */       return true;
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 52 */     int _h_ = 0;
/* 53 */     _h_ += this.multifightvalue;
/* 54 */     _h_ += this.model.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.multifightvalue).append(",");
/* 62 */     _sb_.append(this.model).append(",");
/* 63 */     _sb_.append(")");
/* 64 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\CorpsMemberExtroInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */