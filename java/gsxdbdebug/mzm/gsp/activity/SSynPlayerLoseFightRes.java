/*     */ package mzm.gsp.activity;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynPlayerLoseFightRes
/*     */   extends __SSynPlayerLoseFightRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12587577;
/*     */   public LinkedList<RoleInfo> roleinfos;
/*     */   public int mapcfgid;
/*     */   public int monsterid;
/*     */   public int start;
/*     */   public int nextstart;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12587577;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynPlayerLoseFightRes()
/*     */   {
/*  37 */     this.roleinfos = new LinkedList();
/*     */   }
/*     */   
/*     */   public SSynPlayerLoseFightRes(LinkedList<RoleInfo> _roleinfos_, int _mapcfgid_, int _monsterid_, int _start_, int _nextstart_) {
/*  41 */     this.roleinfos = _roleinfos_;
/*  42 */     this.mapcfgid = _mapcfgid_;
/*  43 */     this.monsterid = _monsterid_;
/*  44 */     this.start = _start_;
/*  45 */     this.nextstart = _nextstart_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (RoleInfo _v_ : this.roleinfos)
/*  50 */       if (!_v_._validator_()) return false;
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.compact_uint32(this.roleinfos.size());
/*  56 */     for (RoleInfo _v_ : this.roleinfos) {
/*  57 */       _os_.marshal(_v_);
/*     */     }
/*  59 */     _os_.marshal(this.mapcfgid);
/*  60 */     _os_.marshal(this.monsterid);
/*  61 */     _os_.marshal(this.start);
/*  62 */     _os_.marshal(this.nextstart);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  68 */       RoleInfo _v_ = new RoleInfo();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.roleinfos.add(_v_);
/*     */     }
/*  72 */     this.mapcfgid = _os_.unmarshal_int();
/*  73 */     this.monsterid = _os_.unmarshal_int();
/*  74 */     this.start = _os_.unmarshal_int();
/*  75 */     this.nextstart = _os_.unmarshal_int();
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SSynPlayerLoseFightRes)) {
/*  85 */       SSynPlayerLoseFightRes _o_ = (SSynPlayerLoseFightRes)_o1_;
/*  86 */       if (!this.roleinfos.equals(_o_.roleinfos)) return false;
/*  87 */       if (this.mapcfgid != _o_.mapcfgid) return false;
/*  88 */       if (this.monsterid != _o_.monsterid) return false;
/*  89 */       if (this.start != _o_.start) return false;
/*  90 */       if (this.nextstart != _o_.nextstart) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.roleinfos.hashCode();
/*  99 */     _h_ += this.mapcfgid;
/* 100 */     _h_ += this.monsterid;
/* 101 */     _h_ += this.start;
/* 102 */     _h_ += this.nextstart;
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.roleinfos).append(",");
/* 110 */     _sb_.append(this.mapcfgid).append(",");
/* 111 */     _sb_.append(this.monsterid).append(",");
/* 112 */     _sb_.append(this.start).append(",");
/* 113 */     _sb_.append(this.nextstart).append(",");
/* 114 */     _sb_.append(")");
/* 115 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SSynPlayerLoseFightRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */