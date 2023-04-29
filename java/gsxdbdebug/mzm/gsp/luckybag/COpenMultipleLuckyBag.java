/*     */ package mzm.gsp.luckybag;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.luckybag.main.PCOpenLuckyBag;
/*     */ 
/*     */ public class COpenMultipleLuckyBag
/*     */   extends __COpenMultipleLuckyBag__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607500;
/*     */   public int instanceid;
/*     */   public byte use_yuanbao;
/*     */   public long client_yuanbao;
/*     */   public long need_yuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 1L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCOpenLuckyBag(roleId, this.instanceid, this.use_yuanbao == 1, this.client_yuanbao, this.need_yuanbao, true));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12607500;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public COpenMultipleLuckyBag() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public COpenMultipleLuckyBag(int _instanceid_, byte _use_yuanbao_, long _client_yuanbao_, long _need_yuanbao_)
/*     */   {
/*  44 */     this.instanceid = _instanceid_;
/*  45 */     this.use_yuanbao = _use_yuanbao_;
/*  46 */     this.client_yuanbao = _client_yuanbao_;
/*  47 */     this.need_yuanbao = _need_yuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.instanceid);
/*  56 */     _os_.marshal(this.use_yuanbao);
/*  57 */     _os_.marshal(this.client_yuanbao);
/*  58 */     _os_.marshal(this.need_yuanbao);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.instanceid = _os_.unmarshal_int();
/*  64 */     this.use_yuanbao = _os_.unmarshal_byte();
/*  65 */     this.client_yuanbao = _os_.unmarshal_long();
/*  66 */     this.need_yuanbao = _os_.unmarshal_long();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof COpenMultipleLuckyBag)) {
/*  76 */       COpenMultipleLuckyBag _o_ = (COpenMultipleLuckyBag)_o1_;
/*  77 */       if (this.instanceid != _o_.instanceid) return false;
/*  78 */       if (this.use_yuanbao != _o_.use_yuanbao) return false;
/*  79 */       if (this.client_yuanbao != _o_.client_yuanbao) return false;
/*  80 */       if (this.need_yuanbao != _o_.need_yuanbao) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.instanceid;
/*  89 */     _h_ += this.use_yuanbao;
/*  90 */     _h_ += (int)this.client_yuanbao;
/*  91 */     _h_ += (int)this.need_yuanbao;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.instanceid).append(",");
/*  99 */     _sb_.append(this.use_yuanbao).append(",");
/* 100 */     _sb_.append(this.client_yuanbao).append(",");
/* 101 */     _sb_.append(this.need_yuanbao).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(COpenMultipleLuckyBag _o_) {
/* 107 */     if (_o_ == this) return 0;
/* 108 */     int _c_ = 0;
/* 109 */     _c_ = this.instanceid - _o_.instanceid;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.use_yuanbao - _o_.use_yuanbao;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = Long.signum(this.client_yuanbao - _o_.client_yuanbao);
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = Long.signum(this.need_yuanbao - _o_.need_yuanbao);
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\COpenMultipleLuckyBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */