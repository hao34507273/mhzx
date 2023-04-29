/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GrcLossUserInfo implements Marshal
/*    */ {
/*    */   public GrcRecallUserInfo user_info;
/*    */   public GrcRoleInfo roleinfo;
/*    */   public long start_time;
/*    */   public int be_recall_num;
/*    */   public long invite_time;
/*    */   
/*    */   public GrcLossUserInfo()
/*    */   {
/* 16 */     this.user_info = new GrcRecallUserInfo();
/* 17 */     this.roleinfo = new GrcRoleInfo();
/*    */   }
/*    */   
/*    */   public GrcLossUserInfo(GrcRecallUserInfo _user_info_, GrcRoleInfo _roleinfo_, long _start_time_, int _be_recall_num_, long _invite_time_) {
/* 21 */     this.user_info = _user_info_;
/* 22 */     this.roleinfo = _roleinfo_;
/* 23 */     this.start_time = _start_time_;
/* 24 */     this.be_recall_num = _be_recall_num_;
/* 25 */     this.invite_time = _invite_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     if (!this.user_info._validator_()) return false;
/* 30 */     if (!this.roleinfo._validator_()) return false;
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.user_info);
/* 36 */     _os_.marshal(this.roleinfo);
/* 37 */     _os_.marshal(this.start_time);
/* 38 */     _os_.marshal(this.be_recall_num);
/* 39 */     _os_.marshal(this.invite_time);
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 44 */     this.user_info.unmarshal(_os_);
/* 45 */     this.roleinfo.unmarshal(_os_);
/* 46 */     this.start_time = _os_.unmarshal_long();
/* 47 */     this.be_recall_num = _os_.unmarshal_int();
/* 48 */     this.invite_time = _os_.unmarshal_long();
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof GrcLossUserInfo)) {
/* 55 */       GrcLossUserInfo _o_ = (GrcLossUserInfo)_o1_;
/* 56 */       if (!this.user_info.equals(_o_.user_info)) return false;
/* 57 */       if (!this.roleinfo.equals(_o_.roleinfo)) return false;
/* 58 */       if (this.start_time != _o_.start_time) return false;
/* 59 */       if (this.be_recall_num != _o_.be_recall_num) return false;
/* 60 */       if (this.invite_time != _o_.invite_time) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.user_info.hashCode();
/* 69 */     _h_ += this.roleinfo.hashCode();
/* 70 */     _h_ += (int)this.start_time;
/* 71 */     _h_ += this.be_recall_num;
/* 72 */     _h_ += (int)this.invite_time;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.user_info).append(",");
/* 80 */     _sb_.append(this.roleinfo).append(",");
/* 81 */     _sb_.append(this.start_time).append(",");
/* 82 */     _sb_.append(this.be_recall_num).append(",");
/* 83 */     _sb_.append(this.invite_time).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcLossUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */