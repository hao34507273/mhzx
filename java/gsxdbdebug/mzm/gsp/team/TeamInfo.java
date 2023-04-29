/*    */ package mzm.gsp.team;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class TeamInfo implements Marshal
/*    */ {
/*    */   public long teamid;
/*    */   public ArrayList<TeamMemberInfo> members;
/*    */   
/*    */   public TeamInfo()
/*    */   {
/* 15 */     this.members = new ArrayList();
/*    */   }
/*    */   
/*    */   public TeamInfo(long _teamid_, ArrayList<TeamMemberInfo> _members_) {
/* 19 */     this.teamid = _teamid_;
/* 20 */     this.members = _members_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     for (TeamMemberInfo _v_ : this.members)
/* 25 */       if (!_v_._validator_()) return false;
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.teamid);
/* 31 */     _os_.compact_uint32(this.members.size());
/* 32 */     for (TeamMemberInfo _v_ : this.members) {
/* 33 */       _os_.marshal(_v_);
/*    */     }
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 39 */     this.teamid = _os_.unmarshal_long();
/* 40 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 41 */       TeamMemberInfo _v_ = new TeamMemberInfo();
/* 42 */       _v_.unmarshal(_os_);
/* 43 */       this.members.add(_v_);
/*    */     }
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof TeamInfo)) {
/* 51 */       TeamInfo _o_ = (TeamInfo)_o1_;
/* 52 */       if (this.teamid != _o_.teamid) return false;
/* 53 */       if (!this.members.equals(_o_.members)) return false;
/* 54 */       return true;
/*    */     }
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 60 */     int _h_ = 0;
/* 61 */     _h_ += (int)this.teamid;
/* 62 */     _h_ += this.members.hashCode();
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this.teamid).append(",");
/* 70 */     _sb_.append(this.members).append(",");
/* 71 */     _sb_.append(")");
/* 72 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\TeamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */