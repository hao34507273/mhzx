/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncMapEntityExtraInfoChange
/*     */   extends __SSyncMapEntityExtraInfoChange__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590947;
/*     */   public int entity_type;
/*     */   public long instanceid;
/*     */   public MapEntityExtraInfo extra_info;
/*     */   public HashSet<Integer> remove_extra_info_keys;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590947;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncMapEntityExtraInfoChange()
/*     */   {
/*  36 */     this.entity_type = 0;
/*  37 */     this.extra_info = new MapEntityExtraInfo();
/*  38 */     this.remove_extra_info_keys = new HashSet();
/*     */   }
/*     */   
/*     */   public SSyncMapEntityExtraInfoChange(int _entity_type_, long _instanceid_, MapEntityExtraInfo _extra_info_, HashSet<Integer> _remove_extra_info_keys_) {
/*  42 */     this.entity_type = _entity_type_;
/*  43 */     this.instanceid = _instanceid_;
/*  44 */     this.extra_info = _extra_info_;
/*  45 */     this.remove_extra_info_keys = _remove_extra_info_keys_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     if (!this.extra_info._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.entity_type);
/*  55 */     _os_.marshal(this.instanceid);
/*  56 */     _os_.marshal(this.extra_info);
/*  57 */     _os_.compact_uint32(this.remove_extra_info_keys.size());
/*  58 */     for (Integer _v_ : this.remove_extra_info_keys) {
/*  59 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.entity_type = _os_.unmarshal_int();
/*  66 */     this.instanceid = _os_.unmarshal_long();
/*  67 */     this.extra_info.unmarshal(_os_);
/*  68 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  70 */       int _v_ = _os_.unmarshal_int();
/*  71 */       this.remove_extra_info_keys.add(Integer.valueOf(_v_));
/*     */     }
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof SSyncMapEntityExtraInfoChange)) {
/*  82 */       SSyncMapEntityExtraInfoChange _o_ = (SSyncMapEntityExtraInfoChange)_o1_;
/*  83 */       if (this.entity_type != _o_.entity_type) return false;
/*  84 */       if (this.instanceid != _o_.instanceid) return false;
/*  85 */       if (!this.extra_info.equals(_o_.extra_info)) return false;
/*  86 */       if (!this.remove_extra_info_keys.equals(_o_.remove_extra_info_keys)) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += this.entity_type;
/*  95 */     _h_ += (int)this.instanceid;
/*  96 */     _h_ += this.extra_info.hashCode();
/*  97 */     _h_ += this.remove_extra_info_keys.hashCode();
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append(this.entity_type).append(",");
/* 105 */     _sb_.append(this.instanceid).append(",");
/* 106 */     _sb_.append(this.extra_info).append(",");
/* 107 */     _sb_.append(this.remove_extra_info_keys).append(",");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SSyncMapEntityExtraInfoChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */