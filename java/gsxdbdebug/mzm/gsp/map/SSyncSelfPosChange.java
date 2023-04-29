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
/*     */ public class SSyncSelfPosChange
/*     */   extends __SSyncSelfPosChange__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590853;
/*     */   public int mapid;
/*     */   public int mapinstanceid;
/*     */   public Location pos;
/*     */   public Location targetpos;
/*     */   public int direction;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590853;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncSelfPosChange()
/*     */   {
/*  37 */     this.pos = new Location();
/*  38 */     this.targetpos = new Location();
/*     */   }
/*     */   
/*     */   public SSyncSelfPosChange(int _mapid_, int _mapinstanceid_, Location _pos_, Location _targetpos_, int _direction_) {
/*  42 */     this.mapid = _mapid_;
/*  43 */     this.mapinstanceid = _mapinstanceid_;
/*  44 */     this.pos = _pos_;
/*  45 */     this.targetpos = _targetpos_;
/*  46 */     this.direction = _direction_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     if (!this.pos._validator_()) return false;
/*  51 */     if (!this.targetpos._validator_()) return false;
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.mapid);
/*  57 */     _os_.marshal(this.mapinstanceid);
/*  58 */     _os_.marshal(this.pos);
/*  59 */     _os_.marshal(this.targetpos);
/*  60 */     _os_.marshal(this.direction);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.mapid = _os_.unmarshal_int();
/*  66 */     this.mapinstanceid = _os_.unmarshal_int();
/*  67 */     this.pos.unmarshal(_os_);
/*  68 */     this.targetpos.unmarshal(_os_);
/*  69 */     this.direction = _os_.unmarshal_int();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SSyncSelfPosChange)) {
/*  79 */       SSyncSelfPosChange _o_ = (SSyncSelfPosChange)_o1_;
/*  80 */       if (this.mapid != _o_.mapid) return false;
/*  81 */       if (this.mapinstanceid != _o_.mapinstanceid) return false;
/*  82 */       if (!this.pos.equals(_o_.pos)) return false;
/*  83 */       if (!this.targetpos.equals(_o_.targetpos)) return false;
/*  84 */       if (this.direction != _o_.direction) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.mapid;
/*  93 */     _h_ += this.mapinstanceid;
/*  94 */     _h_ += this.pos.hashCode();
/*  95 */     _h_ += this.targetpos.hashCode();
/*  96 */     _h_ += this.direction;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.mapid).append(",");
/* 104 */     _sb_.append(this.mapinstanceid).append(",");
/* 105 */     _sb_.append(this.pos).append(",");
/* 106 */     _sb_.append(this.targetpos).append(",");
/* 107 */     _sb_.append(this.direction).append(",");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncSelfPosChange _o_) {
/* 113 */     if (_o_ == this) return 0;
/* 114 */     int _c_ = 0;
/* 115 */     _c_ = this.mapid - _o_.mapid;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.mapinstanceid - _o_.mapinstanceid;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.pos.compareTo(_o_.pos);
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     _c_ = this.targetpos.compareTo(_o_.targetpos);
/* 122 */     if (0 != _c_) return _c_;
/* 123 */     _c_ = this.direction - _o_.direction;
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SSyncSelfPosChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */