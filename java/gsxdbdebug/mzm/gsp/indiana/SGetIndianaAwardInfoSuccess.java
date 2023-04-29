/*     */ package mzm.gsp.indiana;
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
/*     */ public class SGetIndianaAwardInfoSuccess
/*     */   extends __SGetIndianaAwardInfoSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12629004;
/*     */   public int activity_cfg_id;
/*     */   public int turn;
/*     */   public int sortid;
/*     */   public ArrayList<IndianaAwardInfo> award_infos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12629004;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetIndianaAwardInfoSuccess()
/*     */   {
/*  36 */     this.award_infos = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetIndianaAwardInfoSuccess(int _activity_cfg_id_, int _turn_, int _sortid_, ArrayList<IndianaAwardInfo> _award_infos_) {
/*  40 */     this.activity_cfg_id = _activity_cfg_id_;
/*  41 */     this.turn = _turn_;
/*  42 */     this.sortid = _sortid_;
/*  43 */     this.award_infos = _award_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (IndianaAwardInfo _v_ : this.award_infos)
/*  48 */       if (!_v_._validator_()) return false;
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.activity_cfg_id);
/*  54 */     _os_.marshal(this.turn);
/*  55 */     _os_.marshal(this.sortid);
/*  56 */     _os_.compact_uint32(this.award_infos.size());
/*  57 */     for (IndianaAwardInfo _v_ : this.award_infos) {
/*  58 */       _os_.marshal(_v_);
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  65 */     this.turn = _os_.unmarshal_int();
/*  66 */     this.sortid = _os_.unmarshal_int();
/*  67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  68 */       IndianaAwardInfo _v_ = new IndianaAwardInfo();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.award_infos.add(_v_);
/*     */     }
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SGetIndianaAwardInfoSuccess)) {
/*  81 */       SGetIndianaAwardInfoSuccess _o_ = (SGetIndianaAwardInfoSuccess)_o1_;
/*  82 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  83 */       if (this.turn != _o_.turn) return false;
/*  84 */       if (this.sortid != _o_.sortid) return false;
/*  85 */       if (!this.award_infos.equals(_o_.award_infos)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.activity_cfg_id;
/*  94 */     _h_ += this.turn;
/*  95 */     _h_ += this.sortid;
/*  96 */     _h_ += this.award_infos.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.activity_cfg_id).append(",");
/* 104 */     _sb_.append(this.turn).append(",");
/* 105 */     _sb_.append(this.sortid).append(",");
/* 106 */     _sb_.append(this.award_infos).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\SGetIndianaAwardInfoSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */