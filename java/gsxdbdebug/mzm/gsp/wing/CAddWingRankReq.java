/*     */ package mzm.gsp.wing;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.wing.main2.PCAddWingRankReq;
/*     */ 
/*     */ public class CAddWingRankReq
/*     */   extends __CAddWingRankReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596529;
/*     */   public long uuid;
/*     */   public int num;
/*     */   public byte useyuanbao;
/*     */   public long curyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId <= 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCAddWingRankReq(roleId, this.uuid, this.num, this.curyuanbao, this.useyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12596529;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CAddWingRankReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CAddWingRankReq(long _uuid_, int _num_, byte _useyuanbao_, long _curyuanbao_)
/*     */   {
/*  44 */     this.uuid = _uuid_;
/*  45 */     this.num = _num_;
/*  46 */     this.useyuanbao = _useyuanbao_;
/*  47 */     this.curyuanbao = _curyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.uuid);
/*  56 */     _os_.marshal(this.num);
/*  57 */     _os_.marshal(this.useyuanbao);
/*  58 */     _os_.marshal(this.curyuanbao);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.uuid = _os_.unmarshal_long();
/*  64 */     this.num = _os_.unmarshal_int();
/*  65 */     this.useyuanbao = _os_.unmarshal_byte();
/*  66 */     this.curyuanbao = _os_.unmarshal_long();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof CAddWingRankReq)) {
/*  76 */       CAddWingRankReq _o_ = (CAddWingRankReq)_o1_;
/*  77 */       if (this.uuid != _o_.uuid) return false;
/*  78 */       if (this.num != _o_.num) return false;
/*  79 */       if (this.useyuanbao != _o_.useyuanbao) return false;
/*  80 */       if (this.curyuanbao != _o_.curyuanbao) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += (int)this.uuid;
/*  89 */     _h_ += this.num;
/*  90 */     _h_ += this.useyuanbao;
/*  91 */     _h_ += (int)this.curyuanbao;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.uuid).append(",");
/*  99 */     _sb_.append(this.num).append(",");
/* 100 */     _sb_.append(this.useyuanbao).append(",");
/* 101 */     _sb_.append(this.curyuanbao).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CAddWingRankReq _o_) {
/* 107 */     if (_o_ == this) return 0;
/* 108 */     int _c_ = 0;
/* 109 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.num - _o_.num;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.useyuanbao - _o_.useyuanbao;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = Long.signum(this.curyuanbao - _o_.curyuanbao);
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\CAddWingRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */