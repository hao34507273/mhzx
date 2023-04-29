/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class SelectionFinalTeamInfo implements Marshal
/*     */ {
/*     */   public Octets corps_name;
/*     */   public long corps_id;
/*     */   public long opponent_corps_id;
/*     */   public int corps_badge_id;
/*     */   public int phys_zone_id;
/*     */   public ArrayList<RoleSelectionFinalInfo> cross_battle_role_info_list;
/*     */   
/*     */   public SelectionFinalTeamInfo()
/*     */   {
/*  19 */     this.corps_name = new Octets();
/*  20 */     this.corps_id = 0L;
/*  21 */     this.opponent_corps_id = 0L;
/*  22 */     this.corps_badge_id = 0;
/*  23 */     this.phys_zone_id = 0;
/*  24 */     this.cross_battle_role_info_list = new ArrayList();
/*     */   }
/*     */   
/*     */   public SelectionFinalTeamInfo(Octets _corps_name_, long _corps_id_, long _opponent_corps_id_, int _corps_badge_id_, int _phys_zone_id_, ArrayList<RoleSelectionFinalInfo> _cross_battle_role_info_list_) {
/*  28 */     this.corps_name = _corps_name_;
/*  29 */     this.corps_id = _corps_id_;
/*  30 */     this.opponent_corps_id = _opponent_corps_id_;
/*  31 */     this.corps_badge_id = _corps_badge_id_;
/*  32 */     this.phys_zone_id = _phys_zone_id_;
/*  33 */     this.cross_battle_role_info_list = _cross_battle_role_info_list_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  37 */     for (RoleSelectionFinalInfo _v_ : this.cross_battle_role_info_list)
/*  38 */       if (!_v_._validator_()) return false;
/*  39 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  43 */     _os_.marshal(this.corps_name);
/*  44 */     _os_.marshal(this.corps_id);
/*  45 */     _os_.marshal(this.opponent_corps_id);
/*  46 */     _os_.marshal(this.corps_badge_id);
/*  47 */     _os_.marshal(this.phys_zone_id);
/*  48 */     _os_.compact_uint32(this.cross_battle_role_info_list.size());
/*  49 */     for (RoleSelectionFinalInfo _v_ : this.cross_battle_role_info_list) {
/*  50 */       _os_.marshal(_v_);
/*     */     }
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  56 */     this.corps_name = _os_.unmarshal_Octets();
/*  57 */     this.corps_id = _os_.unmarshal_long();
/*  58 */     this.opponent_corps_id = _os_.unmarshal_long();
/*  59 */     this.corps_badge_id = _os_.unmarshal_int();
/*  60 */     this.phys_zone_id = _os_.unmarshal_int();
/*  61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  62 */       RoleSelectionFinalInfo _v_ = new RoleSelectionFinalInfo();
/*  63 */       _v_.unmarshal(_os_);
/*  64 */       this.cross_battle_role_info_list.add(_v_);
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof SelectionFinalTeamInfo)) {
/*  72 */       SelectionFinalTeamInfo _o_ = (SelectionFinalTeamInfo)_o1_;
/*  73 */       if (!this.corps_name.equals(_o_.corps_name)) return false;
/*  74 */       if (this.corps_id != _o_.corps_id) return false;
/*  75 */       if (this.opponent_corps_id != _o_.opponent_corps_id) return false;
/*  76 */       if (this.corps_badge_id != _o_.corps_badge_id) return false;
/*  77 */       if (this.phys_zone_id != _o_.phys_zone_id) return false;
/*  78 */       if (!this.cross_battle_role_info_list.equals(_o_.cross_battle_role_info_list)) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += this.corps_name.hashCode();
/*  87 */     _h_ += (int)this.corps_id;
/*  88 */     _h_ += (int)this.opponent_corps_id;
/*  89 */     _h_ += this.corps_badge_id;
/*  90 */     _h_ += this.phys_zone_id;
/*  91 */     _h_ += this.cross_battle_role_info_list.hashCode();
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append("B").append(this.corps_name.size()).append(",");
/*  99 */     _sb_.append(this.corps_id).append(",");
/* 100 */     _sb_.append(this.opponent_corps_id).append(",");
/* 101 */     _sb_.append(this.corps_badge_id).append(",");
/* 102 */     _sb_.append(this.phys_zone_id).append(",");
/* 103 */     _sb_.append(this.cross_battle_role_info_list).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\SelectionFinalTeamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */