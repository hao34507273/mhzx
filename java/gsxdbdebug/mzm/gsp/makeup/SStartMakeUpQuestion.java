/*    */ package mzm.gsp.makeup;
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
/*    */ public class SStartMakeUpQuestion
/*    */   extends __SStartMakeUpQuestion__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12625921;
/*    */   public FactionMakeUpInfo makeupinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12625921;
/*    */   }
/*    */   
/*    */ 
/*    */   public SStartMakeUpQuestion()
/*    */   {
/* 33 */     this.makeupinfo = new FactionMakeUpInfo();
/*    */   }
/*    */   
/*    */   public SStartMakeUpQuestion(FactionMakeUpInfo _makeupinfo_) {
/* 37 */     this.makeupinfo = _makeupinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.makeupinfo._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.makeupinfo);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.makeupinfo.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SStartMakeUpQuestion)) {
/* 61 */       SStartMakeUpQuestion _o_ = (SStartMakeUpQuestion)_o1_;
/* 62 */       if (!this.makeupinfo.equals(_o_.makeupinfo)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.makeupinfo.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.makeupinfo).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\SStartMakeUpQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */