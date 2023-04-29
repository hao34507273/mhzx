/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetPointRacePanelInfoSuccess
/*     */   extends __SGetPointRacePanelInfoSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617047;
/*     */   public byte is_five_role_team;
/*     */   public byte is_in_one_corps;
/*     */   public byte is_can_join_point_race;
/*     */   public byte is_role_same_with_sign_up;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617047;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetPointRacePanelInfoSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetPointRacePanelInfoSuccess(byte _is_five_role_team_, byte _is_in_one_corps_, byte _is_can_join_point_race_, byte _is_role_same_with_sign_up_)
/*     */   {
/*  39 */     this.is_five_role_team = _is_five_role_team_;
/*  40 */     this.is_in_one_corps = _is_in_one_corps_;
/*  41 */     this.is_can_join_point_race = _is_can_join_point_race_;
/*  42 */     this.is_role_same_with_sign_up = _is_role_same_with_sign_up_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.is_five_role_team);
/*  51 */     _os_.marshal(this.is_in_one_corps);
/*  52 */     _os_.marshal(this.is_can_join_point_race);
/*  53 */     _os_.marshal(this.is_role_same_with_sign_up);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.is_five_role_team = _os_.unmarshal_byte();
/*  59 */     this.is_in_one_corps = _os_.unmarshal_byte();
/*  60 */     this.is_can_join_point_race = _os_.unmarshal_byte();
/*  61 */     this.is_role_same_with_sign_up = _os_.unmarshal_byte();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SGetPointRacePanelInfoSuccess)) {
/*  71 */       SGetPointRacePanelInfoSuccess _o_ = (SGetPointRacePanelInfoSuccess)_o1_;
/*  72 */       if (this.is_five_role_team != _o_.is_five_role_team) return false;
/*  73 */       if (this.is_in_one_corps != _o_.is_in_one_corps) return false;
/*  74 */       if (this.is_can_join_point_race != _o_.is_can_join_point_race) return false;
/*  75 */       if (this.is_role_same_with_sign_up != _o_.is_role_same_with_sign_up) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.is_five_role_team;
/*  84 */     _h_ += this.is_in_one_corps;
/*  85 */     _h_ += this.is_can_join_point_race;
/*  86 */     _h_ += this.is_role_same_with_sign_up;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.is_five_role_team).append(",");
/*  94 */     _sb_.append(this.is_in_one_corps).append(",");
/*  95 */     _sb_.append(this.is_can_join_point_race).append(",");
/*  96 */     _sb_.append(this.is_role_same_with_sign_up).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetPointRacePanelInfoSuccess _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.is_five_role_team - _o_.is_five_role_team;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.is_in_one_corps - _o_.is_in_one_corps;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.is_can_join_point_race - _o_.is_can_join_point_race;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.is_role_same_with_sign_up - _o_.is_role_same_with_sign_up;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetPointRacePanelInfoSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */