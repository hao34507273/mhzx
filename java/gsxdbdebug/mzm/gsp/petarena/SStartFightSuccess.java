/*     */ package mzm.gsp.petarena;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.award.AwardBean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SStartFightSuccess
/*     */   extends __SStartFightSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628239;
/*     */   public long target_roleid;
/*     */   public int rank;
/*     */   public int teamid;
/*     */   public PetArenaInfo pet_arena_info;
/*     */   public AwardBean award_info;
/*     */   public int add_point;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12628239;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SStartFightSuccess()
/*     */   {
/*  38 */     this.pet_arena_info = new PetArenaInfo();
/*  39 */     this.award_info = new AwardBean();
/*     */   }
/*     */   
/*     */   public SStartFightSuccess(long _target_roleid_, int _rank_, int _teamid_, PetArenaInfo _pet_arena_info_, AwardBean _award_info_, int _add_point_) {
/*  43 */     this.target_roleid = _target_roleid_;
/*  44 */     this.rank = _rank_;
/*  45 */     this.teamid = _teamid_;
/*  46 */     this.pet_arena_info = _pet_arena_info_;
/*  47 */     this.award_info = _award_info_;
/*  48 */     this.add_point = _add_point_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     if (!this.pet_arena_info._validator_()) return false;
/*  53 */     if (!this.award_info._validator_()) return false;
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.target_roleid);
/*  59 */     _os_.marshal(this.rank);
/*  60 */     _os_.marshal(this.teamid);
/*  61 */     _os_.marshal(this.pet_arena_info);
/*  62 */     _os_.marshal(this.award_info);
/*  63 */     _os_.marshal(this.add_point);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.target_roleid = _os_.unmarshal_long();
/*  69 */     this.rank = _os_.unmarshal_int();
/*  70 */     this.teamid = _os_.unmarshal_int();
/*  71 */     this.pet_arena_info.unmarshal(_os_);
/*  72 */     this.award_info.unmarshal(_os_);
/*  73 */     this.add_point = _os_.unmarshal_int();
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SStartFightSuccess)) {
/*  83 */       SStartFightSuccess _o_ = (SStartFightSuccess)_o1_;
/*  84 */       if (this.target_roleid != _o_.target_roleid) return false;
/*  85 */       if (this.rank != _o_.rank) return false;
/*  86 */       if (this.teamid != _o_.teamid) return false;
/*  87 */       if (!this.pet_arena_info.equals(_o_.pet_arena_info)) return false;
/*  88 */       if (!this.award_info.equals(_o_.award_info)) return false;
/*  89 */       if (this.add_point != _o_.add_point) return false;
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  96 */     int _h_ = 0;
/*  97 */     _h_ += (int)this.target_roleid;
/*  98 */     _h_ += this.rank;
/*  99 */     _h_ += this.teamid;
/* 100 */     _h_ += this.pet_arena_info.hashCode();
/* 101 */     _h_ += this.award_info.hashCode();
/* 102 */     _h_ += this.add_point;
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.target_roleid).append(",");
/* 110 */     _sb_.append(this.rank).append(",");
/* 111 */     _sb_.append(this.teamid).append(",");
/* 112 */     _sb_.append(this.pet_arena_info).append(",");
/* 113 */     _sb_.append(this.award_info).append(",");
/* 114 */     _sb_.append(this.add_point).append(",");
/* 115 */     _sb_.append(")");
/* 116 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\SStartFightSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */