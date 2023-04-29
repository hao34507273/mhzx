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
/*     */ 
/*     */ public class SSynPlayerWinFightRes
/*     */   extends __SSynPlayerWinFightRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12587576;
/*     */   public LinkedList<RoleInfo> roleinfos;
/*     */   public int mapcfgid;
/*     */   public int monsterid;
/*     */   public int start;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12587576;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynPlayerWinFightRes()
/*     */   {
/*  36 */     this.roleinfos = new LinkedList();
/*     */   }
/*     */   
/*     */   public SSynPlayerWinFightRes(LinkedList<RoleInfo> _roleinfos_, int _mapcfgid_, int _monsterid_, int _start_) {
/*  40 */     this.roleinfos = _roleinfos_;
/*  41 */     this.mapcfgid = _mapcfgid_;
/*  42 */     this.monsterid = _monsterid_;
/*  43 */     this.start = _start_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (RoleInfo _v_ : this.roleinfos)
/*  48 */       if (!_v_._validator_()) return false;
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.compact_uint32(this.roleinfos.size());
/*  54 */     for (RoleInfo _v_ : this.roleinfos) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     _os_.marshal(this.mapcfgid);
/*  58 */     _os_.marshal(this.monsterid);
/*  59 */     _os_.marshal(this.start);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  65 */       RoleInfo _v_ = new RoleInfo();
/*  66 */       _v_.unmarshal(_os_);
/*  67 */       this.roleinfos.add(_v_);
/*     */     }
/*  69 */     this.mapcfgid = _os_.unmarshal_int();
/*  70 */     this.monsterid = _os_.unmarshal_int();
/*  71 */     this.start = _os_.unmarshal_int();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SSynPlayerWinFightRes)) {
/*  81 */       SSynPlayerWinFightRes _o_ = (SSynPlayerWinFightRes)_o1_;
/*  82 */       if (!this.roleinfos.equals(_o_.roleinfos)) return false;
/*  83 */       if (this.mapcfgid != _o_.mapcfgid) return false;
/*  84 */       if (this.monsterid != _o_.monsterid) return false;
/*  85 */       if (this.start != _o_.start) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.roleinfos.hashCode();
/*  94 */     _h_ += this.mapcfgid;
/*  95 */     _h_ += this.monsterid;
/*  96 */     _h_ += this.start;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.roleinfos).append(",");
/* 104 */     _sb_.append(this.mapcfgid).append(",");
/* 105 */     _sb_.append(this.monsterid).append(",");
/* 106 */     _sb_.append(this.start).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SSynPlayerWinFightRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */