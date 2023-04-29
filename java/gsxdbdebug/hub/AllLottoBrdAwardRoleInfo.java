/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class AllLottoBrdAwardRoleInfo implements Marshal
/*    */ {
/*    */   public int activity_cfg_id;
/*    */   public int turn;
/*    */   public ArrayList<AllLottoRoleInfo> award_role_infos;
/*    */   
/*    */   public AllLottoBrdAwardRoleInfo()
/*    */   {
/* 16 */     this.award_role_infos = new ArrayList();
/*    */   }
/*    */   
/*    */   public AllLottoBrdAwardRoleInfo(int _activity_cfg_id_, int _turn_, ArrayList<AllLottoRoleInfo> _award_role_infos_) {
/* 20 */     this.activity_cfg_id = _activity_cfg_id_;
/* 21 */     this.turn = _turn_;
/* 22 */     this.award_role_infos = _award_role_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     for (AllLottoRoleInfo _v_ : this.award_role_infos)
/* 27 */       if (!_v_._validator_()) return false;
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.activity_cfg_id);
/* 33 */     _os_.marshal(this.turn);
/* 34 */     _os_.compact_uint32(this.award_role_infos.size());
/* 35 */     for (AllLottoRoleInfo _v_ : this.award_role_infos) {
/* 36 */       _os_.marshal(_v_);
/*    */     }
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 42 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 43 */     this.turn = _os_.unmarshal_int();
/* 44 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 45 */       AllLottoRoleInfo _v_ = new AllLottoRoleInfo();
/* 46 */       _v_.unmarshal(_os_);
/* 47 */       this.award_role_infos.add(_v_);
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof AllLottoBrdAwardRoleInfo)) {
/* 55 */       AllLottoBrdAwardRoleInfo _o_ = (AllLottoBrdAwardRoleInfo)_o1_;
/* 56 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 57 */       if (this.turn != _o_.turn) return false;
/* 58 */       if (!this.award_role_infos.equals(_o_.award_role_infos)) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += this.activity_cfg_id;
/* 67 */     _h_ += this.turn;
/* 68 */     _h_ += this.award_role_infos.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.activity_cfg_id).append(",");
/* 76 */     _sb_.append(this.turn).append(",");
/* 77 */     _sb_.append(this.award_role_infos).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\AllLottoBrdAwardRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */