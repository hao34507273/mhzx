/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class PetFightInfo implements Marshal
/*     */ {
/*     */   public int defense_team;
/*     */   public HashMap<Integer, PetFightTeamInfo> team_info;
/*     */   public HashMap<Integer, PetFightFormationInfo> formation_info;
/*     */   public PetFightSkillInfo skill_info;
/*     */   
/*     */   public PetFightInfo()
/*     */   {
/*  17 */     this.team_info = new HashMap();
/*  18 */     this.formation_info = new HashMap();
/*  19 */     this.skill_info = new PetFightSkillInfo();
/*     */   }
/*     */   
/*     */   public PetFightInfo(int _defense_team_, HashMap<Integer, PetFightTeamInfo> _team_info_, HashMap<Integer, PetFightFormationInfo> _formation_info_, PetFightSkillInfo _skill_info_) {
/*  23 */     this.defense_team = _defense_team_;
/*  24 */     this.team_info = _team_info_;
/*  25 */     this.formation_info = _formation_info_;
/*  26 */     this.skill_info = _skill_info_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  30 */     for (Map.Entry<Integer, PetFightTeamInfo> _e_ : this.team_info.entrySet()) {
/*  31 */       if (!((PetFightTeamInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  33 */     for (Map.Entry<Integer, PetFightFormationInfo> _e_ : this.formation_info.entrySet()) {
/*  34 */       if (!((PetFightFormationInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  36 */     if (!this.skill_info._validator_()) return false;
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  41 */     _os_.marshal(this.defense_team);
/*  42 */     _os_.compact_uint32(this.team_info.size());
/*  43 */     for (Map.Entry<Integer, PetFightTeamInfo> _e_ : this.team_info.entrySet()) {
/*  44 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  45 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  47 */     _os_.compact_uint32(this.formation_info.size());
/*  48 */     for (Map.Entry<Integer, PetFightFormationInfo> _e_ : this.formation_info.entrySet()) {
/*  49 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  50 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  52 */     _os_.marshal(this.skill_info);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  57 */     this.defense_team = _os_.unmarshal_int();
/*  58 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  60 */       int _k_ = _os_.unmarshal_int();
/*  61 */       PetFightTeamInfo _v_ = new PetFightTeamInfo();
/*  62 */       _v_.unmarshal(_os_);
/*  63 */       this.team_info.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  65 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  67 */       int _k_ = _os_.unmarshal_int();
/*  68 */       PetFightFormationInfo _v_ = new PetFightFormationInfo();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.formation_info.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  72 */     this.skill_info.unmarshal(_os_);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof PetFightInfo)) {
/*  79 */       PetFightInfo _o_ = (PetFightInfo)_o1_;
/*  80 */       if (this.defense_team != _o_.defense_team) return false;
/*  81 */       if (!this.team_info.equals(_o_.team_info)) return false;
/*  82 */       if (!this.formation_info.equals(_o_.formation_info)) return false;
/*  83 */       if (!this.skill_info.equals(_o_.skill_info)) return false;
/*  84 */       return true;
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int _h_ = 0;
/*  91 */     _h_ += this.defense_team;
/*  92 */     _h_ += this.team_info.hashCode();
/*  93 */     _h_ += this.formation_info.hashCode();
/*  94 */     _h_ += this.skill_info.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.defense_team).append(",");
/* 102 */     _sb_.append(this.team_info).append(",");
/* 103 */     _sb_.append(this.formation_info).append(",");
/* 104 */     _sb_.append(this.skill_info).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\PetFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */