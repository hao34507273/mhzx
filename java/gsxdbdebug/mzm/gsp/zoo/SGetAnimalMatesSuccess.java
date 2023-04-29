/*     */ package mzm.gsp.zoo;
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
/*     */ public class SGetAnimalMatesSuccess
/*     */   extends __SGetAnimalMatesSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12615446;
/*     */   public long animalid;
/*     */   public int mate_times;
/*     */   public int birth_time;
/*     */   public ArrayList<MateInfo> mate_infos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12615446;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetAnimalMatesSuccess()
/*     */   {
/*  36 */     this.mate_infos = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetAnimalMatesSuccess(long _animalid_, int _mate_times_, int _birth_time_, ArrayList<MateInfo> _mate_infos_) {
/*  40 */     this.animalid = _animalid_;
/*  41 */     this.mate_times = _mate_times_;
/*  42 */     this.birth_time = _birth_time_;
/*  43 */     this.mate_infos = _mate_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (MateInfo _v_ : this.mate_infos)
/*  48 */       if (!_v_._validator_()) return false;
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.animalid);
/*  54 */     _os_.marshal(this.mate_times);
/*  55 */     _os_.marshal(this.birth_time);
/*  56 */     _os_.compact_uint32(this.mate_infos.size());
/*  57 */     for (MateInfo _v_ : this.mate_infos) {
/*  58 */       _os_.marshal(_v_);
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.animalid = _os_.unmarshal_long();
/*  65 */     this.mate_times = _os_.unmarshal_int();
/*  66 */     this.birth_time = _os_.unmarshal_int();
/*  67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  68 */       MateInfo _v_ = new MateInfo();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.mate_infos.add(_v_);
/*     */     }
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SGetAnimalMatesSuccess)) {
/*  81 */       SGetAnimalMatesSuccess _o_ = (SGetAnimalMatesSuccess)_o1_;
/*  82 */       if (this.animalid != _o_.animalid) return false;
/*  83 */       if (this.mate_times != _o_.mate_times) return false;
/*  84 */       if (this.birth_time != _o_.birth_time) return false;
/*  85 */       if (!this.mate_infos.equals(_o_.mate_infos)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += (int)this.animalid;
/*  94 */     _h_ += this.mate_times;
/*  95 */     _h_ += this.birth_time;
/*  96 */     _h_ += this.mate_infos.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.animalid).append(",");
/* 104 */     _sb_.append(this.mate_times).append(",");
/* 105 */     _sb_.append(this.birth_time).append(",");
/* 106 */     _sb_.append(this.mate_infos).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\SGetAnimalMatesSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */