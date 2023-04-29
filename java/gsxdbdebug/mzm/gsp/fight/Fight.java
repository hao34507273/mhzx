/*     */ package mzm.gsp.fight;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class Fight
/*     */   implements Marshal
/*     */ {
/*     */   public static final int TYPE_PVE = 0;
/*     */   public static final int TYPE_PVP = 1;
/*     */   public static final int TYPE_PVC = 2;
/*     */   public static final int TYPE_PVIMonster = 3;
/*     */   public static final int TYPE_PETCVC = 4;
/*     */   public int fight_type;
/*     */   public long fight_uuid;
/*     */   public int fight_cfg_id;
/*     */   public int fight_dis_type;
/*     */   public FightTeam active_team;
/*     */   public FightTeam passive_team;
/*     */   public int round;
/*     */   public long operendtime;
/*     */   public ArrayList<Observer> observers;
/*     */   
/*     */   public Fight()
/*     */   {
/*  28 */     this.active_team = new FightTeam();
/*  29 */     this.passive_team = new FightTeam();
/*  30 */     this.observers = new ArrayList();
/*     */   }
/*     */   
/*     */   public Fight(int _fight_type_, long _fight_uuid_, int _fight_cfg_id_, int _fight_dis_type_, FightTeam _active_team_, FightTeam _passive_team_, int _round_, long _operendtime_, ArrayList<Observer> _observers_) {
/*  34 */     this.fight_type = _fight_type_;
/*  35 */     this.fight_uuid = _fight_uuid_;
/*  36 */     this.fight_cfg_id = _fight_cfg_id_;
/*  37 */     this.fight_dis_type = _fight_dis_type_;
/*  38 */     this.active_team = _active_team_;
/*  39 */     this.passive_team = _passive_team_;
/*  40 */     this.round = _round_;
/*  41 */     this.operendtime = _operendtime_;
/*  42 */     this.observers = _observers_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     if (!this.active_team._validator_()) return false;
/*  47 */     if (!this.passive_team._validator_()) return false;
/*  48 */     for (Observer _v_ : this.observers)
/*  49 */       if (!_v_._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.fight_type);
/*  55 */     _os_.marshal(this.fight_uuid);
/*  56 */     _os_.marshal(this.fight_cfg_id);
/*  57 */     _os_.marshal(this.fight_dis_type);
/*  58 */     _os_.marshal(this.active_team);
/*  59 */     _os_.marshal(this.passive_team);
/*  60 */     _os_.marshal(this.round);
/*  61 */     _os_.marshal(this.operendtime);
/*  62 */     _os_.compact_uint32(this.observers.size());
/*  63 */     for (Observer _v_ : this.observers) {
/*  64 */       _os_.marshal(_v_);
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  70 */     this.fight_type = _os_.unmarshal_int();
/*  71 */     this.fight_uuid = _os_.unmarshal_long();
/*  72 */     this.fight_cfg_id = _os_.unmarshal_int();
/*  73 */     this.fight_dis_type = _os_.unmarshal_int();
/*  74 */     this.active_team.unmarshal(_os_);
/*  75 */     this.passive_team.unmarshal(_os_);
/*  76 */     this.round = _os_.unmarshal_int();
/*  77 */     this.operendtime = _os_.unmarshal_long();
/*  78 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  79 */       Observer _v_ = new Observer();
/*  80 */       _v_.unmarshal(_os_);
/*  81 */       this.observers.add(_v_);
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  87 */     if (_o1_ == this) return true;
/*  88 */     if ((_o1_ instanceof Fight)) {
/*  89 */       Fight _o_ = (Fight)_o1_;
/*  90 */       if (this.fight_type != _o_.fight_type) return false;
/*  91 */       if (this.fight_uuid != _o_.fight_uuid) return false;
/*  92 */       if (this.fight_cfg_id != _o_.fight_cfg_id) return false;
/*  93 */       if (this.fight_dis_type != _o_.fight_dis_type) return false;
/*  94 */       if (!this.active_team.equals(_o_.active_team)) return false;
/*  95 */       if (!this.passive_team.equals(_o_.passive_team)) return false;
/*  96 */       if (this.round != _o_.round) return false;
/*  97 */       if (this.operendtime != _o_.operendtime) return false;
/*  98 */       if (!this.observers.equals(_o_.observers)) return false;
/*  99 */       return true;
/*     */     }
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 105 */     int _h_ = 0;
/* 106 */     _h_ += this.fight_type;
/* 107 */     _h_ += (int)this.fight_uuid;
/* 108 */     _h_ += this.fight_cfg_id;
/* 109 */     _h_ += this.fight_dis_type;
/* 110 */     _h_ += this.active_team.hashCode();
/* 111 */     _h_ += this.passive_team.hashCode();
/* 112 */     _h_ += this.round;
/* 113 */     _h_ += (int)this.operendtime;
/* 114 */     _h_ += this.observers.hashCode();
/* 115 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 119 */     StringBuilder _sb_ = new StringBuilder();
/* 120 */     _sb_.append("(");
/* 121 */     _sb_.append(this.fight_type).append(",");
/* 122 */     _sb_.append(this.fight_uuid).append(",");
/* 123 */     _sb_.append(this.fight_cfg_id).append(",");
/* 124 */     _sb_.append(this.fight_dis_type).append(",");
/* 125 */     _sb_.append(this.active_team).append(",");
/* 126 */     _sb_.append(this.passive_team).append(",");
/* 127 */     _sb_.append(this.round).append(",");
/* 128 */     _sb_.append(this.operendtime).append(",");
/* 129 */     _sb_.append(this.observers).append(",");
/* 130 */     _sb_.append(")");
/* 131 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\Fight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */