/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class GangTeam implements Marshal
/*    */ {
/*    */   public long teamid;
/*    */   public String name;
/*    */   public ArrayList<GangTeamMember> members;
/*    */   public long leaderid;
/*    */   public long create_time;
/*    */   
/*    */   public GangTeam()
/*    */   {
/* 18 */     this.name = "";
/* 19 */     this.members = new ArrayList();
/*    */   }
/*    */   
/*    */   public GangTeam(long _teamid_, String _name_, ArrayList<GangTeamMember> _members_, long _leaderid_, long _create_time_) {
/* 23 */     this.teamid = _teamid_;
/* 24 */     this.name = _name_;
/* 25 */     this.members = _members_;
/* 26 */     this.leaderid = _leaderid_;
/* 27 */     this.create_time = _create_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     for (GangTeamMember _v_ : this.members)
/* 32 */       if (!_v_._validator_()) return false;
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 37 */     _os_.marshal(this.teamid);
/* 38 */     _os_.marshal(this.name, "UTF-16LE");
/* 39 */     _os_.compact_uint32(this.members.size());
/* 40 */     for (GangTeamMember _v_ : this.members) {
/* 41 */       _os_.marshal(_v_);
/*    */     }
/* 43 */     _os_.marshal(this.leaderid);
/* 44 */     _os_.marshal(this.create_time);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.teamid = _os_.unmarshal_long();
/* 50 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 51 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 52 */       GangTeamMember _v_ = new GangTeamMember();
/* 53 */       _v_.unmarshal(_os_);
/* 54 */       this.members.add(_v_);
/*    */     }
/* 56 */     this.leaderid = _os_.unmarshal_long();
/* 57 */     this.create_time = _os_.unmarshal_long();
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof GangTeam)) {
/* 64 */       GangTeam _o_ = (GangTeam)_o1_;
/* 65 */       if (this.teamid != _o_.teamid) return false;
/* 66 */       if (!this.name.equals(_o_.name)) return false;
/* 67 */       if (!this.members.equals(_o_.members)) return false;
/* 68 */       if (this.leaderid != _o_.leaderid) return false;
/* 69 */       if (this.create_time != _o_.create_time) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.teamid;
/* 78 */     _h_ += this.name.hashCode();
/* 79 */     _h_ += this.members.hashCode();
/* 80 */     _h_ += (int)this.leaderid;
/* 81 */     _h_ += (int)this.create_time;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.teamid).append(",");
/* 89 */     _sb_.append("T").append(this.name.length()).append(",");
/* 90 */     _sb_.append(this.members).append(",");
/* 91 */     _sb_.append(this.leaderid).append(",");
/* 92 */     _sb_.append(this.create_time).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\GangTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */