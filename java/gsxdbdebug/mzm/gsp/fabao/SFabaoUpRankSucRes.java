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
/*     */ 
/*     */ public class SFabaoUpRankSucRes
/*     */   extends __SFabaoUpRankSucRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12595997;
/*     */   public int next_rank_skillid;
/*     */   public int random_skillid;
/*     */   public long fabaouuid;
/*     */   public int equiped;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12595997;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SFabaoUpRankSucRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SFabaoUpRankSucRes(int _next_rank_skillid_, int _random_skillid_, long _fabaouuid_, int _equiped_)
/*     */   {
/*  39 */     this.next_rank_skillid = _next_rank_skillid_;
/*  40 */     this.random_skillid = _random_skillid_;
/*  41 */     this.fabaouuid = _fabaouuid_;
/*  42 */     this.equiped = _equiped_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.next_rank_skillid);
/*  51 */     _os_.marshal(this.random_skillid);
/*  52 */     _os_.marshal(this.fabaouuid);
/*  53 */     _os_.marshal(this.equiped);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.next_rank_skillid = _os_.unmarshal_int();
/*  59 */     this.random_skillid = _os_.unmarshal_int();
/*  60 */     this.fabaouuid = _os_.unmarshal_long();
/*  61 */     this.equiped = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SFabaoUpRankSucRes)) {
/*  71 */       SFabaoUpRankSucRes _o_ = (SFabaoUpRankSucRes)_o1_;
/*  72 */       if (this.next_rank_skillid != _o_.next_rank_skillid) return false;
/*  73 */       if (this.random_skillid != _o_.random_skillid) return false;
/*  74 */       if (this.fabaouuid != _o_.fabaouuid) return false;
/*  75 */       if (this.equiped != _o_.equiped) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.next_rank_skillid;
/*  84 */     _h_ += this.random_skillid;
/*  85 */     _h_ += (int)this.fabaouuid;
/*  86 */     _h_ += this.equiped;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.next_rank_skillid).append(",");
/*  94 */     _sb_.append(this.random_skillid).append(",");
/*  95 */     _sb_.append(this.fabaouuid).append(",");
/*  96 */     _sb_.append(this.equiped).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SFabaoUpRankSucRes _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.next_rank_skillid - _o_.next_rank_skillid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.random_skillid - _o_.random_skillid;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = Long.signum(this.fabaouuid - _o_.fabaouuid);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.equiped - _o_.equiped;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\SFabaoUpRankSucRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */