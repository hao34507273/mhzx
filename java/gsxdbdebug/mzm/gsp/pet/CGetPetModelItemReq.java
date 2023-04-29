/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.pet.main.PCGetPetModelItemReq;
/*     */ 
/*     */ public class CGetPetModelItemReq
/*     */   extends __CGetPetModelItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590664;
/*     */   public long petid;
/*     */   public int iscostyuanbao;
/*     */   public long curyuanbao;
/*     */   public int costyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PCGetPetModelItemReq(roleId, this.petid, this.iscostyuanbao, this.curyuanbao, this.costyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12590664;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CGetPetModelItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetPetModelItemReq(long _petid_, int _iscostyuanbao_, long _curyuanbao_, int _costyuanbao_)
/*     */   {
/*  43 */     this.petid = _petid_;
/*  44 */     this.iscostyuanbao = _iscostyuanbao_;
/*  45 */     this.curyuanbao = _curyuanbao_;
/*  46 */     this.costyuanbao = _costyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.petid);
/*  55 */     _os_.marshal(this.iscostyuanbao);
/*  56 */     _os_.marshal(this.curyuanbao);
/*  57 */     _os_.marshal(this.costyuanbao);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.petid = _os_.unmarshal_long();
/*  63 */     this.iscostyuanbao = _os_.unmarshal_int();
/*  64 */     this.curyuanbao = _os_.unmarshal_long();
/*  65 */     this.costyuanbao = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof CGetPetModelItemReq)) {
/*  75 */       CGetPetModelItemReq _o_ = (CGetPetModelItemReq)_o1_;
/*  76 */       if (this.petid != _o_.petid) return false;
/*  77 */       if (this.iscostyuanbao != _o_.iscostyuanbao) return false;
/*  78 */       if (this.curyuanbao != _o_.curyuanbao) return false;
/*  79 */       if (this.costyuanbao != _o_.costyuanbao) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += (int)this.petid;
/*  88 */     _h_ += this.iscostyuanbao;
/*  89 */     _h_ += (int)this.curyuanbao;
/*  90 */     _h_ += this.costyuanbao;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.petid).append(",");
/*  98 */     _sb_.append(this.iscostyuanbao).append(",");
/*  99 */     _sb_.append(this.curyuanbao).append(",");
/* 100 */     _sb_.append(this.costyuanbao).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetPetModelItemReq _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.iscostyuanbao - _o_.iscostyuanbao;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = Long.signum(this.curyuanbao - _o_.curyuanbao);
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.costyuanbao - _o_.costyuanbao;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CGetPetModelItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */