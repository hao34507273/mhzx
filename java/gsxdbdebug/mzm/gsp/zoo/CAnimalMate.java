/*    */ package mzm.gsp.zoo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.zoo.main.PCAnimalMate;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAnimalMate
/*    */   extends __CAnimalMate__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615432;
/*    */   public long animalid;
/*    */   public long target_animalid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 1L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PCAnimalMate(roleId, this.animalid, this.target_animalid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12615432;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CAnimalMate() {}
/*    */   
/*    */ 
/*    */   public CAnimalMate(long _animalid_, long _target_animalid_)
/*    */   {
/* 41 */     this.animalid = _animalid_;
/* 42 */     this.target_animalid = _target_animalid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.animalid);
/* 51 */     _os_.marshal(this.target_animalid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.animalid = _os_.unmarshal_long();
/* 57 */     this.target_animalid = _os_.unmarshal_long();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CAnimalMate)) {
/* 67 */       CAnimalMate _o_ = (CAnimalMate)_o1_;
/* 68 */       if (this.animalid != _o_.animalid) return false;
/* 69 */       if (this.target_animalid != _o_.target_animalid) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.animalid;
/* 78 */     _h_ += (int)this.target_animalid;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.animalid).append(",");
/* 86 */     _sb_.append(this.target_animalid).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CAnimalMate _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = Long.signum(this.animalid - _o_.animalid);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = Long.signum(this.target_animalid - _o_.target_animalid);
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\CAnimalMate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */