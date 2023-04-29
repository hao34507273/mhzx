/*     */ package mzm.gsp.team;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class TeamApplicant implements Marshal
/*     */ {
/*     */   public long applicant_id;
/*     */   public String applicant_name;
/*     */   public int applicant_level;
/*     */   public int applicant_menpai;
/*     */   public int applicant_gender;
/*     */   public int avatarid;
/*     */   public int avatarframeid;
/*     */   public String recommender;
/*     */   
/*     */   public TeamApplicant()
/*     */   {
/*  19 */     this.applicant_name = "";
/*  20 */     this.recommender = "";
/*     */   }
/*     */   
/*     */   public TeamApplicant(long _applicant_id_, String _applicant_name_, int _applicant_level_, int _applicant_menpai_, int _applicant_gender_, int _avatarid_, int _avatarframeid_, String _recommender_) {
/*  24 */     this.applicant_id = _applicant_id_;
/*  25 */     this.applicant_name = _applicant_name_;
/*  26 */     this.applicant_level = _applicant_level_;
/*  27 */     this.applicant_menpai = _applicant_menpai_;
/*  28 */     this.applicant_gender = _applicant_gender_;
/*  29 */     this.avatarid = _avatarid_;
/*  30 */     this.avatarframeid = _avatarframeid_;
/*  31 */     this.recommender = _recommender_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  35 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  39 */     _os_.marshal(this.applicant_id);
/*  40 */     _os_.marshal(this.applicant_name, "UTF-16LE");
/*  41 */     _os_.marshal(this.applicant_level);
/*  42 */     _os_.marshal(this.applicant_menpai);
/*  43 */     _os_.marshal(this.applicant_gender);
/*  44 */     _os_.marshal(this.avatarid);
/*  45 */     _os_.marshal(this.avatarframeid);
/*  46 */     _os_.marshal(this.recommender, "UTF-16LE");
/*  47 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  51 */     this.applicant_id = _os_.unmarshal_long();
/*  52 */     this.applicant_name = _os_.unmarshal_String("UTF-16LE");
/*  53 */     this.applicant_level = _os_.unmarshal_int();
/*  54 */     this.applicant_menpai = _os_.unmarshal_int();
/*  55 */     this.applicant_gender = _os_.unmarshal_int();
/*  56 */     this.avatarid = _os_.unmarshal_int();
/*  57 */     this.avatarframeid = _os_.unmarshal_int();
/*  58 */     this.recommender = _os_.unmarshal_String("UTF-16LE");
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  63 */     if (_o1_ == this) return true;
/*  64 */     if ((_o1_ instanceof TeamApplicant)) {
/*  65 */       TeamApplicant _o_ = (TeamApplicant)_o1_;
/*  66 */       if (this.applicant_id != _o_.applicant_id) return false;
/*  67 */       if (!this.applicant_name.equals(_o_.applicant_name)) return false;
/*  68 */       if (this.applicant_level != _o_.applicant_level) return false;
/*  69 */       if (this.applicant_menpai != _o_.applicant_menpai) return false;
/*  70 */       if (this.applicant_gender != _o_.applicant_gender) return false;
/*  71 */       if (this.avatarid != _o_.avatarid) return false;
/*  72 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/*  73 */       if (!this.recommender.equals(_o_.recommender)) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += (int)this.applicant_id;
/*  82 */     _h_ += this.applicant_name.hashCode();
/*  83 */     _h_ += this.applicant_level;
/*  84 */     _h_ += this.applicant_menpai;
/*  85 */     _h_ += this.applicant_gender;
/*  86 */     _h_ += this.avatarid;
/*  87 */     _h_ += this.avatarframeid;
/*  88 */     _h_ += this.recommender.hashCode();
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.applicant_id).append(",");
/*  96 */     _sb_.append("T").append(this.applicant_name.length()).append(",");
/*  97 */     _sb_.append(this.applicant_level).append(",");
/*  98 */     _sb_.append(this.applicant_menpai).append(",");
/*  99 */     _sb_.append(this.applicant_gender).append(",");
/* 100 */     _sb_.append(this.avatarid).append(",");
/* 101 */     _sb_.append(this.avatarframeid).append(",");
/* 102 */     _sb_.append("T").append(this.recommender.length()).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\TeamApplicant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */