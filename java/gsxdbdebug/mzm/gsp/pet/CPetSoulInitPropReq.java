/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.pet.main.PCPetSoulInitPropReq;
/*     */ 
/*     */ 
/*     */ public class CPetSoulInitPropReq
/*     */   extends __CPetSoulInitPropReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590672;
/*     */   public long petid;
/*     */   public int pos;
/*     */   public int propindex;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PCPetSoulInitPropReq(roleId, this.petid, this.pos, this.propindex));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12590672;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CPetSoulInitPropReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CPetSoulInitPropReq(long _petid_, int _pos_, int _propindex_)
/*     */   {
/*  43 */     this.petid = _petid_;
/*  44 */     this.pos = _pos_;
/*  45 */     this.propindex = _propindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.petid);
/*  54 */     _os_.marshal(this.pos);
/*  55 */     _os_.marshal(this.propindex);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.petid = _os_.unmarshal_long();
/*  61 */     this.pos = _os_.unmarshal_int();
/*  62 */     this.propindex = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CPetSoulInitPropReq)) {
/*  72 */       CPetSoulInitPropReq _o_ = (CPetSoulInitPropReq)_o1_;
/*  73 */       if (this.petid != _o_.petid) return false;
/*  74 */       if (this.pos != _o_.pos) return false;
/*  75 */       if (this.propindex != _o_.propindex) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += (int)this.petid;
/*  84 */     _h_ += this.pos;
/*  85 */     _h_ += this.propindex;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.petid).append(",");
/*  93 */     _sb_.append(this.pos).append(",");
/*  94 */     _sb_.append(this.propindex).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CPetSoulInitPropReq _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.pos - _o_.pos;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.propindex - _o_.propindex;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CPetSoulInitPropReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */