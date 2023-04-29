/*     */ package mzm.gsp.crosscompete;
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
/*     */ public class SSyncRoleCompete
/*     */   extends __SSyncRoleCompete__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12616740;
/*     */   public int action_point;
/*     */   public long factionid;
/*     */   public int designed_titleid;
/*     */   public int compete_index;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12616740;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncRoleCompete()
/*     */   {
/*  36 */     this.action_point = 0;
/*  37 */     this.factionid = 0L;
/*  38 */     this.designed_titleid = 0;
/*  39 */     this.compete_index = 0;
/*     */   }
/*     */   
/*     */   public SSyncRoleCompete(int _action_point_, long _factionid_, int _designed_titleid_, int _compete_index_) {
/*  43 */     this.action_point = _action_point_;
/*  44 */     this.factionid = _factionid_;
/*  45 */     this.designed_titleid = _designed_titleid_;
/*  46 */     this.compete_index = _compete_index_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.action_point);
/*  55 */     _os_.marshal(this.factionid);
/*  56 */     _os_.marshal(this.designed_titleid);
/*  57 */     _os_.marshal(this.compete_index);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.action_point = _os_.unmarshal_int();
/*  63 */     this.factionid = _os_.unmarshal_long();
/*  64 */     this.designed_titleid = _os_.unmarshal_int();
/*  65 */     this.compete_index = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SSyncRoleCompete)) {
/*  75 */       SSyncRoleCompete _o_ = (SSyncRoleCompete)_o1_;
/*  76 */       if (this.action_point != _o_.action_point) return false;
/*  77 */       if (this.factionid != _o_.factionid) return false;
/*  78 */       if (this.designed_titleid != _o_.designed_titleid) return false;
/*  79 */       if (this.compete_index != _o_.compete_index) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.action_point;
/*  88 */     _h_ += (int)this.factionid;
/*  89 */     _h_ += this.designed_titleid;
/*  90 */     _h_ += this.compete_index;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.action_point).append(",");
/*  98 */     _sb_.append(this.factionid).append(",");
/*  99 */     _sb_.append(this.designed_titleid).append(",");
/* 100 */     _sb_.append(this.compete_index).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncRoleCompete _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = this.action_point - _o_.action_point;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = Long.signum(this.factionid - _o_.factionid);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.designed_titleid - _o_.designed_titleid;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.compete_index - _o_.compete_index;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\SSyncRoleCompete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */