/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.pet.main.PTransfomPetPlaceReq;
/*     */ 
/*     */ public class CTransfomPetPlaceReq
/*     */   extends __CTransfomPetPlaceReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590618;
/*     */   public static final int TARGET_BAG = 0;
/*     */   public static final int TARGET_DEPOT = 1;
/*     */   public long petid;
/*     */   public int target;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PTransfomPetPlaceReq(roleId, this.petid, this.target));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12590618;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CTransfomPetPlaceReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CTransfomPetPlaceReq(long _petid_, int _target_)
/*     */   {
/*  44 */     this.petid = _petid_;
/*  45 */     this.target = _target_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.petid);
/*  54 */     _os_.marshal(this.target);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.petid = _os_.unmarshal_long();
/*  60 */     this.target = _os_.unmarshal_int();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CTransfomPetPlaceReq)) {
/*  70 */       CTransfomPetPlaceReq _o_ = (CTransfomPetPlaceReq)_o1_;
/*  71 */       if (this.petid != _o_.petid) return false;
/*  72 */       if (this.target != _o_.target) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += (int)this.petid;
/*  81 */     _h_ += this.target;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.petid).append(",");
/*  89 */     _sb_.append(this.target).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CTransfomPetPlaceReq _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.petid - _o_.petid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.target - _o_.target;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CTransfomPetPlaceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */