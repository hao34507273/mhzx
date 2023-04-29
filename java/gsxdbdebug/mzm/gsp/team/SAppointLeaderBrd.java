/*    */ package mzm.gsp.team;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SAppointLeaderBrd
/*    */   extends __SAppointLeaderBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588322;
/*    */   public long new_leader;
/*    */   public ArrayList<TeamMemberInfo> teammemberinfos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588322;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SAppointLeaderBrd()
/*    */   {
/* 34 */     this.teammemberinfos = new ArrayList();
/*    */   }
/*    */   
/*    */   public SAppointLeaderBrd(long _new_leader_, ArrayList<TeamMemberInfo> _teammemberinfos_) {
/* 38 */     this.new_leader = _new_leader_;
/* 39 */     this.teammemberinfos = _teammemberinfos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (TeamMemberInfo _v_ : this.teammemberinfos)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.new_leader);
/* 50 */     _os_.compact_uint32(this.teammemberinfos.size());
/* 51 */     for (TeamMemberInfo _v_ : this.teammemberinfos) {
/* 52 */       _os_.marshal(_v_);
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.new_leader = _os_.unmarshal_long();
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 60 */       TeamMemberInfo _v_ = new TeamMemberInfo();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.teammemberinfos.add(_v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SAppointLeaderBrd)) {
/* 73 */       SAppointLeaderBrd _o_ = (SAppointLeaderBrd)_o1_;
/* 74 */       if (this.new_leader != _o_.new_leader) return false;
/* 75 */       if (!this.teammemberinfos.equals(_o_.teammemberinfos)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += (int)this.new_leader;
/* 84 */     _h_ += this.teammemberinfos.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.new_leader).append(",");
/* 92 */     _sb_.append(this.teammemberinfos).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\SAppointLeaderBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */