/*     */ package mzm.gsp.map;
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
/*     */ public class SMapNpcStartMove
/*     */   extends __SMapNpcStartMove__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590875;
/*     */   public int npcid;
/*     */   public Location targetloc;
/*     */   public Location currentloc;
/*     */   public int velocity;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590875;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMapNpcStartMove()
/*     */   {
/*  36 */     this.targetloc = new Location();
/*  37 */     this.currentloc = new Location();
/*     */   }
/*     */   
/*     */   public SMapNpcStartMove(int _npcid_, Location _targetloc_, Location _currentloc_, int _velocity_) {
/*  41 */     this.npcid = _npcid_;
/*  42 */     this.targetloc = _targetloc_;
/*  43 */     this.currentloc = _currentloc_;
/*  44 */     this.velocity = _velocity_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     if (!this.targetloc._validator_()) return false;
/*  49 */     if (!this.currentloc._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.npcid);
/*  55 */     _os_.marshal(this.targetloc);
/*  56 */     _os_.marshal(this.currentloc);
/*  57 */     _os_.marshal(this.velocity);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.npcid = _os_.unmarshal_int();
/*  63 */     this.targetloc.unmarshal(_os_);
/*  64 */     this.currentloc.unmarshal(_os_);
/*  65 */     this.velocity = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SMapNpcStartMove)) {
/*  75 */       SMapNpcStartMove _o_ = (SMapNpcStartMove)_o1_;
/*  76 */       if (this.npcid != _o_.npcid) return false;
/*  77 */       if (!this.targetloc.equals(_o_.targetloc)) return false;
/*  78 */       if (!this.currentloc.equals(_o_.currentloc)) return false;
/*  79 */       if (this.velocity != _o_.velocity) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.npcid;
/*  88 */     _h_ += this.targetloc.hashCode();
/*  89 */     _h_ += this.currentloc.hashCode();
/*  90 */     _h_ += this.velocity;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.npcid).append(",");
/*  98 */     _sb_.append(this.targetloc).append(",");
/*  99 */     _sb_.append(this.currentloc).append(",");
/* 100 */     _sb_.append(this.velocity).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SMapNpcStartMove _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = this.npcid - _o_.npcid;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.targetloc.compareTo(_o_.targetloc);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.currentloc.compareTo(_o_.currentloc);
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.velocity - _o_.velocity;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SMapNpcStartMove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */