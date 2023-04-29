/*    */ package mzm.gsp.teamplatform;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.teamplatform.match.MatchNRTimeTaskManager;
/*    */ import mzm.gsp.teamplatform.match.PCCheckMatchMembers;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CCheckMatchMembersNum
/*    */   extends __CCheckMatchMembersNum__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 797201;
/*    */   public MatchCfg matchcfg;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     MatchNRTimeTaskManager.getInstance().addTask(new PCCheckMatchMembers(roleid, this.matchcfg.matchcfgid, this.matchcfg.index));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 797201;
/*    */   }
/*    */   
/*    */ 
/*    */   public CCheckMatchMembersNum()
/*    */   {
/* 38 */     this.matchcfg = new MatchCfg();
/*    */   }
/*    */   
/*    */   public CCheckMatchMembersNum(MatchCfg _matchcfg_) {
/* 42 */     this.matchcfg = _matchcfg_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     if (!this.matchcfg._validator_()) return false;
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.matchcfg);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.matchcfg.unmarshal(_os_);
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CCheckMatchMembersNum)) {
/* 66 */       CCheckMatchMembersNum _o_ = (CCheckMatchMembersNum)_o1_;
/* 67 */       if (!this.matchcfg.equals(_o_.matchcfg)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.matchcfg.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.matchcfg).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CCheckMatchMembersNum _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.matchcfg.compareTo(_o_.matchcfg);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\CCheckMatchMembersNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */