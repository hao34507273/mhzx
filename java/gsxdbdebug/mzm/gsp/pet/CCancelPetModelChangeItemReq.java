/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.pet.main.PCCancelPetModelChangeItemReq;
/*     */ 
/*     */ 
/*     */ public class CCancelPetModelChangeItemReq
/*     */   extends __CCancelPetModelChangeItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590663;
/*     */   public long petid;
/*     */   public int iscostyuanbao;
/*     */   public long curyuanbao;
/*     */   public int costyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCCancelPetModelChangeItemReq(roleId, this.petid, this.iscostyuanbao, this.curyuanbao, this.costyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12590663;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CCancelPetModelChangeItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CCancelPetModelChangeItemReq(long _petid_, int _iscostyuanbao_, long _curyuanbao_, int _costyuanbao_)
/*     */   {
/*  45 */     this.petid = _petid_;
/*  46 */     this.iscostyuanbao = _iscostyuanbao_;
/*  47 */     this.curyuanbao = _curyuanbao_;
/*  48 */     this.costyuanbao = _costyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.petid);
/*  57 */     _os_.marshal(this.iscostyuanbao);
/*  58 */     _os_.marshal(this.curyuanbao);
/*  59 */     _os_.marshal(this.costyuanbao);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.petid = _os_.unmarshal_long();
/*  65 */     this.iscostyuanbao = _os_.unmarshal_int();
/*  66 */     this.curyuanbao = _os_.unmarshal_long();
/*  67 */     this.costyuanbao = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CCancelPetModelChangeItemReq)) {
/*  77 */       CCancelPetModelChangeItemReq _o_ = (CCancelPetModelChangeItemReq)_o1_;
/*  78 */       if (this.petid != _o_.petid) return false;
/*  79 */       if (this.iscostyuanbao != _o_.iscostyuanbao) return false;
/*  80 */       if (this.curyuanbao != _o_.curyuanbao) return false;
/*  81 */       if (this.costyuanbao != _o_.costyuanbao) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += (int)this.petid;
/*  90 */     _h_ += this.iscostyuanbao;
/*  91 */     _h_ += (int)this.curyuanbao;
/*  92 */     _h_ += this.costyuanbao;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.petid).append(",");
/* 100 */     _sb_.append(this.iscostyuanbao).append(",");
/* 101 */     _sb_.append(this.curyuanbao).append(",");
/* 102 */     _sb_.append(this.costyuanbao).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CCancelPetModelChangeItemReq _o_) {
/* 108 */     if (_o_ == this) return 0;
/* 109 */     int _c_ = 0;
/* 110 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.iscostyuanbao - _o_.iscostyuanbao;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = Long.signum(this.curyuanbao - _o_.curyuanbao);
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = this.costyuanbao - _o_.costyuanbao;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CCancelPetModelChangeItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */