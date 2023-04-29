/*     */ package mzm.gsp.fabao;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SFaBaoAutoRankUpRes
/*     */   extends __SFaBaoAutoRankUpRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596043;
/*     */   public int next_rank_skillid;
/*     */   public int random_skillid;
/*     */   public long fabaouuid;
/*     */   public int equiped;
/*     */   public int uptofabaocfgid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12596043;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SFaBaoAutoRankUpRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SFaBaoAutoRankUpRes(int _next_rank_skillid_, int _random_skillid_, long _fabaouuid_, int _equiped_, int _uptofabaocfgid_)
/*     */   {
/*  40 */     this.next_rank_skillid = _next_rank_skillid_;
/*  41 */     this.random_skillid = _random_skillid_;
/*  42 */     this.fabaouuid = _fabaouuid_;
/*  43 */     this.equiped = _equiped_;
/*  44 */     this.uptofabaocfgid = _uptofabaocfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.next_rank_skillid);
/*  53 */     _os_.marshal(this.random_skillid);
/*  54 */     _os_.marshal(this.fabaouuid);
/*  55 */     _os_.marshal(this.equiped);
/*  56 */     _os_.marshal(this.uptofabaocfgid);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.next_rank_skillid = _os_.unmarshal_int();
/*  62 */     this.random_skillid = _os_.unmarshal_int();
/*  63 */     this.fabaouuid = _os_.unmarshal_long();
/*  64 */     this.equiped = _os_.unmarshal_int();
/*  65 */     this.uptofabaocfgid = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SFaBaoAutoRankUpRes)) {
/*  75 */       SFaBaoAutoRankUpRes _o_ = (SFaBaoAutoRankUpRes)_o1_;
/*  76 */       if (this.next_rank_skillid != _o_.next_rank_skillid) return false;
/*  77 */       if (this.random_skillid != _o_.random_skillid) return false;
/*  78 */       if (this.fabaouuid != _o_.fabaouuid) return false;
/*  79 */       if (this.equiped != _o_.equiped) return false;
/*  80 */       if (this.uptofabaocfgid != _o_.uptofabaocfgid) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.next_rank_skillid;
/*  89 */     _h_ += this.random_skillid;
/*  90 */     _h_ += (int)this.fabaouuid;
/*  91 */     _h_ += this.equiped;
/*  92 */     _h_ += this.uptofabaocfgid;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.next_rank_skillid).append(",");
/* 100 */     _sb_.append(this.random_skillid).append(",");
/* 101 */     _sb_.append(this.fabaouuid).append(",");
/* 102 */     _sb_.append(this.equiped).append(",");
/* 103 */     _sb_.append(this.uptofabaocfgid).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SFaBaoAutoRankUpRes _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = this.next_rank_skillid - _o_.next_rank_skillid;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.random_skillid - _o_.random_skillid;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = Long.signum(this.fabaouuid - _o_.fabaouuid);
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.equiped - _o_.equiped;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.uptofabaocfgid - _o_.uptofabaocfgid;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\SFaBaoAutoRankUpRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */