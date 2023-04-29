/*     */ package mzm.gsp.grc;
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
/*     */ 
/*     */ 
/*     */ public class AddBindVitalityInfo
/*     */   extends __AddBindVitalityInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12600380;
/*     */   public RoleVitalityInfo vitality_info;
/*     */   public ArrayList<BindVitalityInfo> recall_bind_infos;
/*     */   public ArrayList<BindVitalityInfo> back_bind_infos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12600380;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public AddBindVitalityInfo()
/*     */   {
/*  35 */     this.vitality_info = new RoleVitalityInfo();
/*  36 */     this.recall_bind_infos = new ArrayList();
/*  37 */     this.back_bind_infos = new ArrayList();
/*     */   }
/*     */   
/*     */   public AddBindVitalityInfo(RoleVitalityInfo _vitality_info_, ArrayList<BindVitalityInfo> _recall_bind_infos_, ArrayList<BindVitalityInfo> _back_bind_infos_) {
/*  41 */     this.vitality_info = _vitality_info_;
/*  42 */     this.recall_bind_infos = _recall_bind_infos_;
/*  43 */     this.back_bind_infos = _back_bind_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     if (!this.vitality_info._validator_()) return false;
/*  48 */     for (BindVitalityInfo _v_ : this.recall_bind_infos)
/*  49 */       if (!_v_._validator_()) return false;
/*  50 */     for (BindVitalityInfo _v_ : this.back_bind_infos)
/*  51 */       if (!_v_._validator_()) return false;
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.vitality_info);
/*  57 */     _os_.compact_uint32(this.recall_bind_infos.size());
/*  58 */     for (BindVitalityInfo _v_ : this.recall_bind_infos) {
/*  59 */       _os_.marshal(_v_);
/*     */     }
/*  61 */     _os_.compact_uint32(this.back_bind_infos.size());
/*  62 */     for (BindVitalityInfo _v_ : this.back_bind_infos) {
/*  63 */       _os_.marshal(_v_);
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     this.vitality_info.unmarshal(_os_);
/*  70 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  71 */       BindVitalityInfo _v_ = new BindVitalityInfo();
/*  72 */       _v_.unmarshal(_os_);
/*  73 */       this.recall_bind_infos.add(_v_);
/*     */     }
/*  75 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  76 */       BindVitalityInfo _v_ = new BindVitalityInfo();
/*  77 */       _v_.unmarshal(_os_);
/*  78 */       this.back_bind_infos.add(_v_);
/*     */     }
/*  80 */     if (!_validator_()) {
/*  81 */       throw new VerifyError("validator failed");
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  87 */     if (_o1_ == this) return true;
/*  88 */     if ((_o1_ instanceof AddBindVitalityInfo)) {
/*  89 */       AddBindVitalityInfo _o_ = (AddBindVitalityInfo)_o1_;
/*  90 */       if (!this.vitality_info.equals(_o_.vitality_info)) return false;
/*  91 */       if (!this.recall_bind_infos.equals(_o_.recall_bind_infos)) return false;
/*  92 */       if (!this.back_bind_infos.equals(_o_.back_bind_infos)) return false;
/*  93 */       return true;
/*     */     }
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  99 */     int _h_ = 0;
/* 100 */     _h_ += this.vitality_info.hashCode();
/* 101 */     _h_ += this.recall_bind_infos.hashCode();
/* 102 */     _h_ += this.back_bind_infos.hashCode();
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.vitality_info).append(",");
/* 110 */     _sb_.append(this.recall_bind_infos).append(",");
/* 111 */     _sb_.append(this.back_bind_infos).append(",");
/* 112 */     _sb_.append(")");
/* 113 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\AddBindVitalityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */