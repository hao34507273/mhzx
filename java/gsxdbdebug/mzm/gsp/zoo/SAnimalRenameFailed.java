/*    */ package mzm.gsp.zoo;
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
/*    */ public class SAnimalRenameFailed
/*    */   extends __SAnimalRenameFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615435;
/*    */   public static final int ERROR_MIN_LEN = -1;
/*    */   public static final int ERROR_MAX_LEN = -2;
/*    */   public static final int ERROR_INVALID = -3;
/*    */   public int retcode;
/*    */   public long animalid;
/*    */   public Octets name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12615435;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SAnimalRenameFailed()
/*    */   {
/* 39 */     this.name = new Octets();
/*    */   }
/*    */   
/*    */   public SAnimalRenameFailed(int _retcode_, long _animalid_, Octets _name_) {
/* 43 */     this.retcode = _retcode_;
/* 44 */     this.animalid = _animalid_;
/* 45 */     this.name = _name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 53 */     _os_.marshal(this.retcode);
/* 54 */     _os_.marshal(this.animalid);
/* 55 */     _os_.marshal(this.name);
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     this.retcode = _os_.unmarshal_int();
/* 61 */     this.animalid = _os_.unmarshal_long();
/* 62 */     this.name = _os_.unmarshal_Octets();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SAnimalRenameFailed)) {
/* 72 */       SAnimalRenameFailed _o_ = (SAnimalRenameFailed)_o1_;
/* 73 */       if (this.retcode != _o_.retcode) return false;
/* 74 */       if (this.animalid != _o_.animalid) return false;
/* 75 */       if (!this.name.equals(_o_.name)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.retcode;
/* 84 */     _h_ += (int)this.animalid;
/* 85 */     _h_ += this.name.hashCode();
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.retcode).append(",");
/* 93 */     _sb_.append(this.animalid).append(",");
/* 94 */     _sb_.append("B").append(this.name.size()).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\SAnimalRenameFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */