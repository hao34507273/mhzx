/*     */ package mzm.gsp.petarena;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetFightDataSuccess
/*     */   extends __SGetFightDataSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628251;
/*     */   public Octets active_name;
/*     */   public Octets passive_name;
/*     */   public ArrayList<PetFightInfo> active_infos;
/*     */   public ArrayList<PetFightInfo> passive_infos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12628251;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetFightDataSuccess()
/*     */   {
/*  36 */     this.active_name = new Octets();
/*  37 */     this.passive_name = new Octets();
/*  38 */     this.active_infos = new ArrayList();
/*  39 */     this.passive_infos = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetFightDataSuccess(Octets _active_name_, Octets _passive_name_, ArrayList<PetFightInfo> _active_infos_, ArrayList<PetFightInfo> _passive_infos_) {
/*  43 */     this.active_name = _active_name_;
/*  44 */     this.passive_name = _passive_name_;
/*  45 */     this.active_infos = _active_infos_;
/*  46 */     this.passive_infos = _passive_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     for (PetFightInfo _v_ : this.active_infos)
/*  51 */       if (!_v_._validator_()) return false;
/*  52 */     for (PetFightInfo _v_ : this.passive_infos)
/*  53 */       if (!_v_._validator_()) return false;
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.active_name);
/*  59 */     _os_.marshal(this.passive_name);
/*  60 */     _os_.compact_uint32(this.active_infos.size());
/*  61 */     for (PetFightInfo _v_ : this.active_infos) {
/*  62 */       _os_.marshal(_v_);
/*     */     }
/*  64 */     _os_.compact_uint32(this.passive_infos.size());
/*  65 */     for (PetFightInfo _v_ : this.passive_infos) {
/*  66 */       _os_.marshal(_v_);
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  72 */     this.active_name = _os_.unmarshal_Octets();
/*  73 */     this.passive_name = _os_.unmarshal_Octets();
/*  74 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  75 */       PetFightInfo _v_ = new PetFightInfo();
/*  76 */       _v_.unmarshal(_os_);
/*  77 */       this.active_infos.add(_v_);
/*     */     }
/*  79 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  80 */       PetFightInfo _v_ = new PetFightInfo();
/*  81 */       _v_.unmarshal(_os_);
/*  82 */       this.passive_infos.add(_v_);
/*     */     }
/*  84 */     if (!_validator_()) {
/*  85 */       throw new VerifyError("validator failed");
/*     */     }
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  91 */     if (_o1_ == this) return true;
/*  92 */     if ((_o1_ instanceof SGetFightDataSuccess)) {
/*  93 */       SGetFightDataSuccess _o_ = (SGetFightDataSuccess)_o1_;
/*  94 */       if (!this.active_name.equals(_o_.active_name)) return false;
/*  95 */       if (!this.passive_name.equals(_o_.passive_name)) return false;
/*  96 */       if (!this.active_infos.equals(_o_.active_infos)) return false;
/*  97 */       if (!this.passive_infos.equals(_o_.passive_infos)) return false;
/*  98 */       return true;
/*     */     }
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 104 */     int _h_ = 0;
/* 105 */     _h_ += this.active_name.hashCode();
/* 106 */     _h_ += this.passive_name.hashCode();
/* 107 */     _h_ += this.active_infos.hashCode();
/* 108 */     _h_ += this.passive_infos.hashCode();
/* 109 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 113 */     StringBuilder _sb_ = new StringBuilder();
/* 114 */     _sb_.append("(");
/* 115 */     _sb_.append("B").append(this.active_name.size()).append(",");
/* 116 */     _sb_.append("B").append(this.passive_name.size()).append(",");
/* 117 */     _sb_.append(this.active_infos).append(",");
/* 118 */     _sb_.append(this.passive_infos).append(",");
/* 119 */     _sb_.append(")");
/* 120 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\SGetFightDataSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */