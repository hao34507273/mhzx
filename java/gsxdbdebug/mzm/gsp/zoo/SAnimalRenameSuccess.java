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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SAnimalRenameSuccess
/*    */   extends __SAnimalRenameSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615440;
/*    */   public long animalid;
/*    */   public Octets name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12615440;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SAnimalRenameSuccess()
/*    */   {
/* 34 */     this.name = new Octets();
/*    */   }
/*    */   
/*    */   public SAnimalRenameSuccess(long _animalid_, Octets _name_) {
/* 38 */     this.animalid = _animalid_;
/* 39 */     this.name = _name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.animalid);
/* 48 */     _os_.marshal(this.name);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.animalid = _os_.unmarshal_long();
/* 54 */     this.name = _os_.unmarshal_Octets();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SAnimalRenameSuccess)) {
/* 64 */       SAnimalRenameSuccess _o_ = (SAnimalRenameSuccess)_o1_;
/* 65 */       if (this.animalid != _o_.animalid) return false;
/* 66 */       if (!this.name.equals(_o_.name)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.animalid;
/* 75 */     _h_ += this.name.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.animalid).append(",");
/* 83 */     _sb_.append("B").append(this.name.size()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\SAnimalRenameSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */