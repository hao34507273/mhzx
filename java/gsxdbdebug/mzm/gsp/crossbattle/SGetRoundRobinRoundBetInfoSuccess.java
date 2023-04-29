/*     */ package mzm.gsp.crossbattle;
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
/*     */ public class SGetRoundRobinRoundBetInfoSuccess
/*     */   extends __SGetRoundRobinRoundBetInfoSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617037;
/*     */   public int activity_cfg_id;
/*     */   public int round_index;
/*     */   public int stage;
/*     */   public ArrayList<RoundRobinFightBetInfo> fight_bet_infos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617037;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetRoundRobinRoundBetInfoSuccess()
/*     */   {
/*  36 */     this.fight_bet_infos = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetRoundRobinRoundBetInfoSuccess(int _activity_cfg_id_, int _round_index_, int _stage_, ArrayList<RoundRobinFightBetInfo> _fight_bet_infos_) {
/*  40 */     this.activity_cfg_id = _activity_cfg_id_;
/*  41 */     this.round_index = _round_index_;
/*  42 */     this.stage = _stage_;
/*  43 */     this.fight_bet_infos = _fight_bet_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (RoundRobinFightBetInfo _v_ : this.fight_bet_infos)
/*  48 */       if (!_v_._validator_()) return false;
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.activity_cfg_id);
/*  54 */     _os_.marshal(this.round_index);
/*  55 */     _os_.marshal(this.stage);
/*  56 */     _os_.compact_uint32(this.fight_bet_infos.size());
/*  57 */     for (RoundRobinFightBetInfo _v_ : this.fight_bet_infos) {
/*  58 */       _os_.marshal(_v_);
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  65 */     this.round_index = _os_.unmarshal_int();
/*  66 */     this.stage = _os_.unmarshal_int();
/*  67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  68 */       RoundRobinFightBetInfo _v_ = new RoundRobinFightBetInfo();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.fight_bet_infos.add(_v_);
/*     */     }
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SGetRoundRobinRoundBetInfoSuccess)) {
/*  81 */       SGetRoundRobinRoundBetInfoSuccess _o_ = (SGetRoundRobinRoundBetInfoSuccess)_o1_;
/*  82 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  83 */       if (this.round_index != _o_.round_index) return false;
/*  84 */       if (this.stage != _o_.stage) return false;
/*  85 */       if (!this.fight_bet_infos.equals(_o_.fight_bet_infos)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.activity_cfg_id;
/*  94 */     _h_ += this.round_index;
/*  95 */     _h_ += this.stage;
/*  96 */     _h_ += this.fight_bet_infos.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.activity_cfg_id).append(",");
/* 104 */     _sb_.append(this.round_index).append(",");
/* 105 */     _sb_.append(this.stage).append(",");
/* 106 */     _sb_.append(this.fight_bet_infos).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetRoundRobinRoundBetInfoSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */