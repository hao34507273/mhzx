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
/*    */ 
/*    */ public class SSyncCorpsInfo2NewMember
/*    */   extends __SSyncCorpsInfo2NewMember__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617515;
/*    */   public CorpsSynInfo corpsinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617515;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSyncCorpsInfo2NewMember()
/*    */   {
/* 33 */     this.corpsinfo = new CorpsSynInfo();
/*    */   }
/*    */   
/*    */   public SSyncCorpsInfo2NewMember(CorpsSynInfo _corpsinfo_) {
/* 37 */     this.corpsinfo = _corpsinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.corpsinfo._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.corpsinfo);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.corpsinfo.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SSyncCorpsInfo2NewMember)) {
/* 61 */       SSyncCorpsInfo2NewMember _o_ = (SSyncCorpsInfo2NewMember)_o1_;
/* 62 */       if (!this.corpsinfo.equals(_o_.corpsinfo)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.corpsinfo.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.corpsinfo).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\SSyncCorpsInfo2NewMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */