/*     */ package mzm.gsp.alllotto;
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
/*     */ public class SBrdAllLottoResult
/*     */   extends __SBrdAllLottoResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12626950;
/*     */   public int activity_cfg_id;
/*     */   public int turn;
/*     */   public ArrayList<RoleInfo> award_role_infos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12626950;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBrdAllLottoResult()
/*     */   {
/*  35 */     this.award_role_infos = new ArrayList();
/*     */   }
/*     */   
/*     */   public SBrdAllLottoResult(int _activity_cfg_id_, int _turn_, ArrayList<RoleInfo> _award_role_infos_) {
/*  39 */     this.activity_cfg_id = _activity_cfg_id_;
/*  40 */     this.turn = _turn_;
/*  41 */     this.award_role_infos = _award_role_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (RoleInfo _v_ : this.award_role_infos)
/*  46 */       if (!_v_._validator_()) return false;
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.activity_cfg_id);
/*  52 */     _os_.marshal(this.turn);
/*  53 */     _os_.compact_uint32(this.award_role_infos.size());
/*  54 */     for (RoleInfo _v_ : this.award_role_infos) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  62 */     this.turn = _os_.unmarshal_int();
/*  63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  64 */       RoleInfo _v_ = new RoleInfo();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.award_role_infos.add(_v_);
/*     */     }
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SBrdAllLottoResult)) {
/*  77 */       SBrdAllLottoResult _o_ = (SBrdAllLottoResult)_o1_;
/*  78 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  79 */       if (this.turn != _o_.turn) return false;
/*  80 */       if (!this.award_role_infos.equals(_o_.award_role_infos)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.activity_cfg_id;
/*  89 */     _h_ += this.turn;
/*  90 */     _h_ += this.award_role_infos.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.activity_cfg_id).append(",");
/*  98 */     _sb_.append(this.turn).append(",");
/*  99 */     _sb_.append(this.award_role_infos).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\SBrdAllLottoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */