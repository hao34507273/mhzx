/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RecallLossInfo
/*    */   implements Marshal
/*    */ {
/*    */   public RecallUserInfo user_info;
/*    */   public RecallRoleInfo role_info;
/*    */   public int start_time;
/*    */   public int be_recall_num;
/*    */   public int invite_time;
/*    */   
/*    */   public RecallLossInfo()
/*    */   {
/* 18 */     this.user_info = new RecallUserInfo();
/* 19 */     this.role_info = new RecallRoleInfo();
/*    */   }
/*    */   
/*    */   public RecallLossInfo(RecallUserInfo _user_info_, RecallRoleInfo _role_info_, int _start_time_, int _be_recall_num_, int _invite_time_) {
/* 23 */     this.user_info = _user_info_;
/* 24 */     this.role_info = _role_info_;
/* 25 */     this.start_time = _start_time_;
/* 26 */     this.be_recall_num = _be_recall_num_;
/* 27 */     this.invite_time = _invite_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     if (!this.user_info._validator_()) return false;
/* 32 */     if (!this.role_info._validator_()) return false;
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 37 */     _os_.marshal(this.user_info);
/* 38 */     _os_.marshal(this.role_info);
/* 39 */     _os_.marshal(this.start_time);
/* 40 */     _os_.marshal(this.be_recall_num);
/* 41 */     _os_.marshal(this.invite_time);
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 46 */     this.user_info.unmarshal(_os_);
/* 47 */     this.role_info.unmarshal(_os_);
/* 48 */     this.start_time = _os_.unmarshal_int();
/* 49 */     this.be_recall_num = _os_.unmarshal_int();
/* 50 */     this.invite_time = _os_.unmarshal_int();
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof RecallLossInfo)) {
/* 57 */       RecallLossInfo _o_ = (RecallLossInfo)_o1_;
/* 58 */       if (!this.user_info.equals(_o_.user_info)) return false;
/* 59 */       if (!this.role_info.equals(_o_.role_info)) return false;
/* 60 */       if (this.start_time != _o_.start_time) return false;
/* 61 */       if (this.be_recall_num != _o_.be_recall_num) return false;
/* 62 */       if (this.invite_time != _o_.invite_time) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.user_info.hashCode();
/* 71 */     _h_ += this.role_info.hashCode();
/* 72 */     _h_ += this.start_time;
/* 73 */     _h_ += this.be_recall_num;
/* 74 */     _h_ += this.invite_time;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.user_info).append(",");
/* 82 */     _sb_.append(this.role_info).append(",");
/* 83 */     _sb_.append(this.start_time).append(",");
/* 84 */     _sb_.append(this.be_recall_num).append(",");
/* 85 */     _sb_.append(this.invite_time).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\RecallLossInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */