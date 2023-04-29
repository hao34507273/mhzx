/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class CrossBattleSelectionMatchInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public long corps_id;
/*    */   public com.goldhuman.Common.Octets corps_name;
/*    */   public int corps_icon;
/*    */   public int corps_zone_id;
/*    */   public ArrayList<CrossBattleSelectionMatchRoleInfo> match_role_list;
/*    */   
/*    */   public CrossBattleSelectionMatchInfo()
/*    */   {
/* 16 */     this.corps_name = new com.goldhuman.Common.Octets();
/* 17 */     this.match_role_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public CrossBattleSelectionMatchInfo(long _corps_id_, com.goldhuman.Common.Octets _corps_name_, int _corps_icon_, int _corps_zone_id_, ArrayList<CrossBattleSelectionMatchRoleInfo> _match_role_list_) {
/* 21 */     this.corps_id = _corps_id_;
/* 22 */     this.corps_name = _corps_name_;
/* 23 */     this.corps_icon = _corps_icon_;
/* 24 */     this.corps_zone_id = _corps_zone_id_;
/* 25 */     this.match_role_list = _match_role_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     for (CrossBattleSelectionMatchRoleInfo _v_ : this.match_role_list)
/* 30 */       if (!_v_._validator_()) return false;
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.corps_id);
/* 36 */     _os_.marshal(this.corps_name);
/* 37 */     _os_.marshal(this.corps_icon);
/* 38 */     _os_.marshal(this.corps_zone_id);
/* 39 */     _os_.compact_uint32(this.match_role_list.size());
/* 40 */     for (CrossBattleSelectionMatchRoleInfo _v_ : this.match_role_list) {
/* 41 */       _os_.marshal(_v_);
/*    */     }
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 47 */     this.corps_id = _os_.unmarshal_long();
/* 48 */     this.corps_name = _os_.unmarshal_Octets();
/* 49 */     this.corps_icon = _os_.unmarshal_int();
/* 50 */     this.corps_zone_id = _os_.unmarshal_int();
/* 51 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 52 */       CrossBattleSelectionMatchRoleInfo _v_ = new CrossBattleSelectionMatchRoleInfo();
/* 53 */       _v_.unmarshal(_os_);
/* 54 */       this.match_role_list.add(_v_);
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof CrossBattleSelectionMatchInfo)) {
/* 62 */       CrossBattleSelectionMatchInfo _o_ = (CrossBattleSelectionMatchInfo)_o1_;
/* 63 */       if (this.corps_id != _o_.corps_id) return false;
/* 64 */       if (!this.corps_name.equals(_o_.corps_name)) return false;
/* 65 */       if (this.corps_icon != _o_.corps_icon) return false;
/* 66 */       if (this.corps_zone_id != _o_.corps_zone_id) return false;
/* 67 */       if (!this.match_role_list.equals(_o_.match_role_list)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.corps_id;
/* 76 */     _h_ += this.corps_name.hashCode();
/* 77 */     _h_ += this.corps_icon;
/* 78 */     _h_ += this.corps_zone_id;
/* 79 */     _h_ += this.match_role_list.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.corps_id).append(",");
/* 87 */     _sb_.append("B").append(this.corps_name.size()).append(",");
/* 88 */     _sb_.append(this.corps_icon).append(",");
/* 89 */     _sb_.append(this.corps_zone_id).append(",");
/* 90 */     _sb_.append(this.match_role_list).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CrossBattleSelectionMatchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */