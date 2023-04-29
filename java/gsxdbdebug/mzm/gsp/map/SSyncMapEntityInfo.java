/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncMapEntityInfo
/*     */   extends __SSyncMapEntityInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590950;
/*     */   public int entity_type;
/*     */   public long instanceid;
/*     */   public int cfgid;
/*     */   public ArrayList<Location> locs;
/*     */   public MapEntityExtraInfo extra_info;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590950;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncMapEntityInfo()
/*     */   {
/*  37 */     this.entity_type = 0;
/*  38 */     this.locs = new ArrayList();
/*  39 */     this.extra_info = new MapEntityExtraInfo();
/*     */   }
/*     */   
/*     */   public SSyncMapEntityInfo(int _entity_type_, long _instanceid_, int _cfgid_, ArrayList<Location> _locs_, MapEntityExtraInfo _extra_info_) {
/*  43 */     this.entity_type = _entity_type_;
/*  44 */     this.instanceid = _instanceid_;
/*  45 */     this.cfgid = _cfgid_;
/*  46 */     this.locs = _locs_;
/*  47 */     this.extra_info = _extra_info_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     for (Location _v_ : this.locs)
/*  52 */       if (!_v_._validator_()) return false;
/*  53 */     if (!this.extra_info._validator_()) return false;
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.entity_type);
/*  59 */     _os_.marshal(this.instanceid);
/*  60 */     _os_.marshal(this.cfgid);
/*  61 */     _os_.compact_uint32(this.locs.size());
/*  62 */     for (Location _v_ : this.locs) {
/*  63 */       _os_.marshal(_v_);
/*     */     }
/*  65 */     _os_.marshal(this.extra_info);
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  70 */     this.entity_type = _os_.unmarshal_int();
/*  71 */     this.instanceid = _os_.unmarshal_long();
/*  72 */     this.cfgid = _os_.unmarshal_int();
/*  73 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  74 */       Location _v_ = new Location();
/*  75 */       _v_.unmarshal(_os_);
/*  76 */       this.locs.add(_v_);
/*     */     }
/*  78 */     this.extra_info.unmarshal(_os_);
/*  79 */     if (!_validator_()) {
/*  80 */       throw new VerifyError("validator failed");
/*     */     }
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  86 */     if (_o1_ == this) return true;
/*  87 */     if ((_o1_ instanceof SSyncMapEntityInfo)) {
/*  88 */       SSyncMapEntityInfo _o_ = (SSyncMapEntityInfo)_o1_;
/*  89 */       if (this.entity_type != _o_.entity_type) return false;
/*  90 */       if (this.instanceid != _o_.instanceid) return false;
/*  91 */       if (this.cfgid != _o_.cfgid) return false;
/*  92 */       if (!this.locs.equals(_o_.locs)) return false;
/*  93 */       if (!this.extra_info.equals(_o_.extra_info)) return false;
/*  94 */       return true;
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 100 */     int _h_ = 0;
/* 101 */     _h_ += this.entity_type;
/* 102 */     _h_ += (int)this.instanceid;
/* 103 */     _h_ += this.cfgid;
/* 104 */     _h_ += this.locs.hashCode();
/* 105 */     _h_ += this.extra_info.hashCode();
/* 106 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 110 */     StringBuilder _sb_ = new StringBuilder();
/* 111 */     _sb_.append("(");
/* 112 */     _sb_.append(this.entity_type).append(",");
/* 113 */     _sb_.append(this.instanceid).append(",");
/* 114 */     _sb_.append(this.cfgid).append(",");
/* 115 */     _sb_.append(this.locs).append(",");
/* 116 */     _sb_.append(this.extra_info).append(",");
/* 117 */     _sb_.append(")");
/* 118 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SSyncMapEntityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */