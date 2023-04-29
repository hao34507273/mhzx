/*    */ package mzm.gsp.corps;
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
/*    */ public class SSynMemberExtroInfo
/*    */   extends __SSynMemberExtroInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617495;
/*    */   public long member;
/*    */   public CorpsMemberExtroInfo extroinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617495;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynMemberExtroInfo()
/*    */   {
/* 34 */     this.extroinfo = new CorpsMemberExtroInfo();
/*    */   }
/*    */   
/*    */   public SSynMemberExtroInfo(long _member_, CorpsMemberExtroInfo _extroinfo_) {
/* 38 */     this.member = _member_;
/* 39 */     this.extroinfo = _extroinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.extroinfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.member);
/* 49 */     _os_.marshal(this.extroinfo);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.member = _os_.unmarshal_long();
/* 55 */     this.extroinfo.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SSynMemberExtroInfo)) {
/* 65 */       SSynMemberExtroInfo _o_ = (SSynMemberExtroInfo)_o1_;
/* 66 */       if (this.member != _o_.member) return false;
/* 67 */       if (!this.extroinfo.equals(_o_.extroinfo)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.member;
/* 76 */     _h_ += this.extroinfo.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.member).append(",");
/* 84 */     _sb_.append(this.extroinfo).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\SSynMemberExtroInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */