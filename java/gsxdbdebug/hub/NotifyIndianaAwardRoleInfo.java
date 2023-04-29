/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class NotifyIndianaAwardRoleInfo implements Marshal
/*    */ {
/*    */   public int activity_cfg_id;
/*    */   public int turn;
/*    */   public int sortid;
/*    */   public HashMap<Integer, IndianaAwardRoleInfo> award_role_infos;
/*    */   
/*    */   public NotifyIndianaAwardRoleInfo()
/*    */   {
/* 17 */     this.award_role_infos = new HashMap();
/*    */   }
/*    */   
/*    */   public NotifyIndianaAwardRoleInfo(int _activity_cfg_id_, int _turn_, int _sortid_, HashMap<Integer, IndianaAwardRoleInfo> _award_role_infos_) {
/* 21 */     this.activity_cfg_id = _activity_cfg_id_;
/* 22 */     this.turn = _turn_;
/* 23 */     this.sortid = _sortid_;
/* 24 */     this.award_role_infos = _award_role_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     for (Map.Entry<Integer, IndianaAwardRoleInfo> _e_ : this.award_role_infos.entrySet()) {
/* 29 */       if (!((IndianaAwardRoleInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.activity_cfg_id);
/* 36 */     _os_.marshal(this.turn);
/* 37 */     _os_.marshal(this.sortid);
/* 38 */     _os_.compact_uint32(this.award_role_infos.size());
/* 39 */     for (Map.Entry<Integer, IndianaAwardRoleInfo> _e_ : this.award_role_infos.entrySet()) {
/* 40 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 41 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 47 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 48 */     this.turn = _os_.unmarshal_int();
/* 49 */     this.sortid = _os_.unmarshal_int();
/* 50 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 52 */       int _k_ = _os_.unmarshal_int();
/* 53 */       IndianaAwardRoleInfo _v_ = new IndianaAwardRoleInfo();
/* 54 */       _v_.unmarshal(_os_);
/* 55 */       this.award_role_infos.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof NotifyIndianaAwardRoleInfo)) {
/* 63 */       NotifyIndianaAwardRoleInfo _o_ = (NotifyIndianaAwardRoleInfo)_o1_;
/* 64 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 65 */       if (this.turn != _o_.turn) return false;
/* 66 */       if (this.sortid != _o_.sortid) return false;
/* 67 */       if (!this.award_role_infos.equals(_o_.award_role_infos)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.activity_cfg_id;
/* 76 */     _h_ += this.turn;
/* 77 */     _h_ += this.sortid;
/* 78 */     _h_ += this.award_role_infos.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.activity_cfg_id).append(",");
/* 86 */     _sb_.append(this.turn).append(",");
/* 87 */     _sb_.append(this.sortid).append(",");
/* 88 */     _sb_.append(this.award_role_infos).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\NotifyIndianaAwardRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */