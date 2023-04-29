/*    */ package mzm.gsp.corps;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
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
/*    */ public class SCreateCorpsSucBro
/*    */   extends __SCreateCorpsSucBro__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617499;
/*    */   public Octets corpsname;
/*    */   public Octets captainname;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617499;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SCreateCorpsSucBro()
/*    */   {
/* 34 */     this.corpsname = new Octets();
/* 35 */     this.captainname = new Octets();
/*    */   }
/*    */   
/*    */   public SCreateCorpsSucBro(Octets _corpsname_, Octets _captainname_) {
/* 39 */     this.corpsname = _corpsname_;
/* 40 */     this.captainname = _captainname_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.corpsname);
/* 49 */     _os_.marshal(this.captainname);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.corpsname = _os_.unmarshal_Octets();
/* 55 */     this.captainname = _os_.unmarshal_Octets();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SCreateCorpsSucBro)) {
/* 65 */       SCreateCorpsSucBro _o_ = (SCreateCorpsSucBro)_o1_;
/* 66 */       if (!this.corpsname.equals(_o_.corpsname)) return false;
/* 67 */       if (!this.captainname.equals(_o_.captainname)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.corpsname.hashCode();
/* 76 */     _h_ += this.captainname.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append("B").append(this.corpsname.size()).append(",");
/* 84 */     _sb_.append("B").append(this.captainname.size()).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\SCreateCorpsSucBro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */