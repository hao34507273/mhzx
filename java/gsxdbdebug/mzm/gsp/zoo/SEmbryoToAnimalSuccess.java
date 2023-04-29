/*    */ package mzm.gsp.zoo;
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
/*    */ public class SEmbryoToAnimalSuccess
/*    */   extends __SEmbryoToAnimalSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615431;
/*    */   public AnimalInfo animal;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12615431;
/*    */   }
/*    */   
/*    */ 
/*    */   public SEmbryoToAnimalSuccess()
/*    */   {
/* 33 */     this.animal = new AnimalInfo();
/*    */   }
/*    */   
/*    */   public SEmbryoToAnimalSuccess(AnimalInfo _animal_) {
/* 37 */     this.animal = _animal_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.animal._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.animal);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.animal.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SEmbryoToAnimalSuccess)) {
/* 61 */       SEmbryoToAnimalSuccess _o_ = (SEmbryoToAnimalSuccess)_o1_;
/* 62 */       if (!this.animal.equals(_o_.animal)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.animal.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.animal).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\SEmbryoToAnimalSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */