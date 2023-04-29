/*    */ package mzm.gsp.group;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class GroupMemberBasicInfo
/*    */   implements Marshal, Comparable<GroupMemberBasicInfo>
/*    */ {
/*    */   public int menpai;
/*    */   public byte gender;
/*    */   public int avatarid;
/*    */   public int avatar_frame_id;
/*    */   
/*    */   public GroupMemberBasicInfo() {}
/*    */   
/*    */   public GroupMemberBasicInfo(int _menpai_, byte _gender_, int _avatarid_, int _avatar_frame_id_)
/*    */   {
/* 20 */     this.menpai = _menpai_;
/* 21 */     this.gender = _gender_;
/* 22 */     this.avatarid = _avatarid_;
/* 23 */     this.avatar_frame_id = _avatar_frame_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.menpai);
/* 32 */     _os_.marshal(this.gender);
/* 33 */     _os_.marshal(this.avatarid);
/* 34 */     _os_.marshal(this.avatar_frame_id);
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 39 */     this.menpai = _os_.unmarshal_int();
/* 40 */     this.gender = _os_.unmarshal_byte();
/* 41 */     this.avatarid = _os_.unmarshal_int();
/* 42 */     this.avatar_frame_id = _os_.unmarshal_int();
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof GroupMemberBasicInfo)) {
/* 49 */       GroupMemberBasicInfo _o_ = (GroupMemberBasicInfo)_o1_;
/* 50 */       if (this.menpai != _o_.menpai) return false;
/* 51 */       if (this.gender != _o_.gender) return false;
/* 52 */       if (this.avatarid != _o_.avatarid) return false;
/* 53 */       if (this.avatar_frame_id != _o_.avatar_frame_id) return false;
/* 54 */       return true;
/*    */     }
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 60 */     int _h_ = 0;
/* 61 */     _h_ += this.menpai;
/* 62 */     _h_ += this.gender;
/* 63 */     _h_ += this.avatarid;
/* 64 */     _h_ += this.avatar_frame_id;
/* 65 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuilder _sb_ = new StringBuilder();
/* 70 */     _sb_.append("(");
/* 71 */     _sb_.append(this.menpai).append(",");
/* 72 */     _sb_.append(this.gender).append(",");
/* 73 */     _sb_.append(this.avatarid).append(",");
/* 74 */     _sb_.append(this.avatar_frame_id).append(",");
/* 75 */     _sb_.append(")");
/* 76 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GroupMemberBasicInfo _o_) {
/* 80 */     if (_o_ == this) return 0;
/* 81 */     int _c_ = 0;
/* 82 */     _c_ = this.menpai - _o_.menpai;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     _c_ = this.gender - _o_.gender;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = this.avatarid - _o_.avatarid;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     _c_ = this.avatar_frame_id - _o_.avatar_frame_id;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\GroupMemberBasicInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */