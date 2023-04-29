/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncMapGroupExtraInfoChange
/*     */   extends __SSyncMapGroupExtraInfoChange__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590946;
/*     */   public int group_type;
/*     */   public long groupid;
/*     */   public HashMap<Integer, Integer> extra_infos;
/*     */   public HashSet<Integer> remove_extra_info_keys;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590946;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncMapGroupExtraInfoChange()
/*     */   {
/*  36 */     this.group_type = 2;
/*  37 */     this.extra_infos = new HashMap();
/*  38 */     this.remove_extra_info_keys = new HashSet();
/*     */   }
/*     */   
/*     */   public SSyncMapGroupExtraInfoChange(int _group_type_, long _groupid_, HashMap<Integer, Integer> _extra_infos_, HashSet<Integer> _remove_extra_info_keys_) {
/*  42 */     this.group_type = _group_type_;
/*  43 */     this.groupid = _groupid_;
/*  44 */     this.extra_infos = _extra_infos_;
/*  45 */     this.remove_extra_info_keys = _remove_extra_info_keys_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.group_type);
/*  54 */     _os_.marshal(this.groupid);
/*  55 */     _os_.compact_uint32(this.extra_infos.size());
/*  56 */     for (Map.Entry<Integer, Integer> _e_ : this.extra_infos.entrySet()) {
/*  57 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  58 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  60 */     _os_.compact_uint32(this.remove_extra_info_keys.size());
/*  61 */     for (Integer _v_ : this.remove_extra_info_keys) {
/*  62 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.group_type = _os_.unmarshal_int();
/*  69 */     this.groupid = _os_.unmarshal_long();
/*  70 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  72 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  74 */       int _v_ = _os_.unmarshal_int();
/*  75 */       this.extra_infos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  77 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  79 */       int _v_ = _os_.unmarshal_int();
/*  80 */       this.remove_extra_info_keys.add(Integer.valueOf(_v_));
/*     */     }
/*  82 */     if (!_validator_()) {
/*  83 */       throw new VerifyError("validator failed");
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  89 */     if (_o1_ == this) return true;
/*  90 */     if ((_o1_ instanceof SSyncMapGroupExtraInfoChange)) {
/*  91 */       SSyncMapGroupExtraInfoChange _o_ = (SSyncMapGroupExtraInfoChange)_o1_;
/*  92 */       if (this.group_type != _o_.group_type) return false;
/*  93 */       if (this.groupid != _o_.groupid) return false;
/*  94 */       if (!this.extra_infos.equals(_o_.extra_infos)) return false;
/*  95 */       if (!this.remove_extra_info_keys.equals(_o_.remove_extra_info_keys)) return false;
/*  96 */       return true;
/*     */     }
/*  98 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 102 */     int _h_ = 0;
/* 103 */     _h_ += this.group_type;
/* 104 */     _h_ += (int)this.groupid;
/* 105 */     _h_ += this.extra_infos.hashCode();
/* 106 */     _h_ += this.remove_extra_info_keys.hashCode();
/* 107 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 111 */     StringBuilder _sb_ = new StringBuilder();
/* 112 */     _sb_.append("(");
/* 113 */     _sb_.append(this.group_type).append(",");
/* 114 */     _sb_.append(this.groupid).append(",");
/* 115 */     _sb_.append(this.extra_infos).append(",");
/* 116 */     _sb_.append(this.remove_extra_info_keys).append(",");
/* 117 */     _sb_.append(")");
/* 118 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SSyncMapGroupExtraInfoChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */