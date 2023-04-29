/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.pet.main.PCPetSoulAddExpReq;
/*     */ 
/*     */ public class CPetSoulAddExpReq
/*     */   extends __CPetSoulAddExpReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590669;
/*     */   public long petid;
/*     */   public int pos;
/*     */   public int itemid;
/*     */   public int isuseall;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PCPetSoulAddExpReq(roleId, this.petid, this.pos, this.itemid, this.isuseall));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12590669;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CPetSoulAddExpReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CPetSoulAddExpReq(long _petid_, int _pos_, int _itemid_, int _isuseall_)
/*     */   {
/*  45 */     this.petid = _petid_;
/*  46 */     this.pos = _pos_;
/*  47 */     this.itemid = _itemid_;
/*  48 */     this.isuseall = _isuseall_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.petid);
/*  57 */     _os_.marshal(this.pos);
/*  58 */     _os_.marshal(this.itemid);
/*  59 */     _os_.marshal(this.isuseall);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.petid = _os_.unmarshal_long();
/*  65 */     this.pos = _os_.unmarshal_int();
/*  66 */     this.itemid = _os_.unmarshal_int();
/*  67 */     this.isuseall = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CPetSoulAddExpReq)) {
/*  77 */       CPetSoulAddExpReq _o_ = (CPetSoulAddExpReq)_o1_;
/*  78 */       if (this.petid != _o_.petid) return false;
/*  79 */       if (this.pos != _o_.pos) return false;
/*  80 */       if (this.itemid != _o_.itemid) return false;
/*  81 */       if (this.isuseall != _o_.isuseall) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += (int)this.petid;
/*  90 */     _h_ += this.pos;
/*  91 */     _h_ += this.itemid;
/*  92 */     _h_ += this.isuseall;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.petid).append(",");
/* 100 */     _sb_.append(this.pos).append(",");
/* 101 */     _sb_.append(this.itemid).append(",");
/* 102 */     _sb_.append(this.isuseall).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CPetSoulAddExpReq _o_) {
/* 108 */     if (_o_ == this) return 0;
/* 109 */     int _c_ = 0;
/* 110 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.pos - _o_.pos;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.itemid - _o_.itemid;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = this.isuseall - _o_.isuseall;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CPetSoulAddExpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */