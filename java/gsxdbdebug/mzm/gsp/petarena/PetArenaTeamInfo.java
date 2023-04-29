/*     */ package mzm.gsp.petarena;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.pet.PetInfo;
/*     */ 
/*     */ public class PetArenaTeamInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int formation;
/*     */   public int formation_level;
/*     */   public HashMap<Integer, PositionInfo> position_infos;
/*     */   public HashMap<Long, PetInfo> pet_infos;
/*     */   public HashMap<Long, RobotPetInfo> robot_infos;
/*     */   
/*     */   public PetArenaTeamInfo()
/*     */   {
/*  18 */     this.position_infos = new HashMap();
/*  19 */     this.pet_infos = new HashMap();
/*  20 */     this.robot_infos = new HashMap();
/*     */   }
/*     */   
/*     */   public PetArenaTeamInfo(int _formation_, int _formation_level_, HashMap<Integer, PositionInfo> _position_infos_, HashMap<Long, PetInfo> _pet_infos_, HashMap<Long, RobotPetInfo> _robot_infos_) {
/*  24 */     this.formation = _formation_;
/*  25 */     this.formation_level = _formation_level_;
/*  26 */     this.position_infos = _position_infos_;
/*  27 */     this.pet_infos = _pet_infos_;
/*  28 */     this.robot_infos = _robot_infos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  32 */     for (Map.Entry<Integer, PositionInfo> _e_ : this.position_infos.entrySet()) {
/*  33 */       if (!((PositionInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  35 */     for (Map.Entry<Long, PetInfo> _e_ : this.pet_infos.entrySet()) {
/*  36 */       if (!((PetInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  38 */     for (Map.Entry<Long, RobotPetInfo> _e_ : this.robot_infos.entrySet()) {
/*  39 */       if (!((RobotPetInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  41 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  45 */     _os_.marshal(this.formation);
/*  46 */     _os_.marshal(this.formation_level);
/*  47 */     _os_.compact_uint32(this.position_infos.size());
/*  48 */     for (Map.Entry<Integer, PositionInfo> _e_ : this.position_infos.entrySet()) {
/*  49 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  50 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  52 */     _os_.compact_uint32(this.pet_infos.size());
/*  53 */     for (Map.Entry<Long, PetInfo> _e_ : this.pet_infos.entrySet()) {
/*  54 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  55 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  57 */     _os_.compact_uint32(this.robot_infos.size());
/*  58 */     for (Map.Entry<Long, RobotPetInfo> _e_ : this.robot_infos.entrySet()) {
/*  59 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  60 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  66 */     this.formation = _os_.unmarshal_int();
/*  67 */     this.formation_level = _os_.unmarshal_int();
/*  68 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  70 */       int _k_ = _os_.unmarshal_int();
/*  71 */       PositionInfo _v_ = new PositionInfo();
/*  72 */       _v_.unmarshal(_os_);
/*  73 */       this.position_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  75 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  77 */       long _k_ = _os_.unmarshal_long();
/*  78 */       PetInfo _v_ = new PetInfo();
/*  79 */       _v_.unmarshal(_os_);
/*  80 */       this.pet_infos.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  82 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  84 */       long _k_ = _os_.unmarshal_long();
/*  85 */       RobotPetInfo _v_ = new RobotPetInfo();
/*  86 */       _v_.unmarshal(_os_);
/*  87 */       this.robot_infos.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  93 */     if (_o1_ == this) return true;
/*  94 */     if ((_o1_ instanceof PetArenaTeamInfo)) {
/*  95 */       PetArenaTeamInfo _o_ = (PetArenaTeamInfo)_o1_;
/*  96 */       if (this.formation != _o_.formation) return false;
/*  97 */       if (this.formation_level != _o_.formation_level) return false;
/*  98 */       if (!this.position_infos.equals(_o_.position_infos)) return false;
/*  99 */       if (!this.pet_infos.equals(_o_.pet_infos)) return false;
/* 100 */       if (!this.robot_infos.equals(_o_.robot_infos)) return false;
/* 101 */       return true;
/*     */     }
/* 103 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 107 */     int _h_ = 0;
/* 108 */     _h_ += this.formation;
/* 109 */     _h_ += this.formation_level;
/* 110 */     _h_ += this.position_infos.hashCode();
/* 111 */     _h_ += this.pet_infos.hashCode();
/* 112 */     _h_ += this.robot_infos.hashCode();
/* 113 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 117 */     StringBuilder _sb_ = new StringBuilder();
/* 118 */     _sb_.append("(");
/* 119 */     _sb_.append(this.formation).append(",");
/* 120 */     _sb_.append(this.formation_level).append(",");
/* 121 */     _sb_.append(this.position_infos).append(",");
/* 122 */     _sb_.append(this.pet_infos).append(",");
/* 123 */     _sb_.append(this.robot_infos).append(",");
/* 124 */     _sb_.append(")");
/* 125 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\PetArenaTeamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */